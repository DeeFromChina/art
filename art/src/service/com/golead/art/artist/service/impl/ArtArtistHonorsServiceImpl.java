package com.golead.art.artist.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;
import com.golead.art.artist.dao.ArtArtistHonorsDao;
import com.golead.art.artist.model.ArtArtistHonors;
import com.golead.art.artist.service.ArtArtistHonorsService;

import javax.annotation.Resource; 

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

@Service
public class ArtArtistHonorsServiceImpl extends BaseServiceImpl implements ArtArtistHonorsService {
	private static final long serialVersionUID = 1L;

	public ArtArtistHonors getArtArtistHonors(Serializable id) throws ServiceException {
		try {
			return artArtistHonorsDao.get(id);
        } catch (DAOException e) {
          e.printStackTrace();
          throw new ServiceException("数据库操作错误。");
        } catch (ServiceException se) {
          se.printStackTrace();
          throw se;
        } catch (Exception e) {
          e.printStackTrace();
          throw new ServiceException("系统错误。");
        }
	}

	public void createArtArtistHonors(ArtArtistHonors artArtistHonors) throws ServiceException {
		try {
			artArtistHonorsDao.save(artArtistHonors);
        } catch (DAOException e) {
          e.printStackTrace();
          throw new ServiceException("数据库操作错误。");
        } catch (ServiceException se) {
          se.printStackTrace();
          throw se;
        } catch (Exception e) {
          e.printStackTrace();
          throw new ServiceException("系统错误。");
        }
	}

	public void updateArtArtistHonors(Map<String, String> artArtistHonorsMap) throws ServiceException {
		try {
            Integer pkId = new Integer(artArtistHonorsMap.get(ArtArtistHonors.PROP_ID));
			ArtArtistHonors tmp = artArtistHonorsDao.get(pkId);
			ConvertUtil.mapToObject(tmp, artArtistHonorsMap, true);			
			artArtistHonorsDao.update(tmp);
        } catch (DAOException e) {
          e.printStackTrace();
          throw new ServiceException("数据库操作错误。");
        } catch (ServiceException se) {
          se.printStackTrace();
          throw se;
        } catch (Exception e) {
          e.printStackTrace();
          throw new ServiceException("系统错误。");
        }
	}

	public void deleteArtArtistHonors(Serializable id) throws ServiceException {
		try {
			artArtistHonorsDao.delete(id);
        } catch (DAOException e) {
          e.printStackTrace();
          throw new ServiceException("数据库操作错误。");
        } catch (ServiceException se) {
          se.printStackTrace();
          throw se;
        } catch (Exception e) {
          e.printStackTrace();
          throw new ServiceException("系统错误。");
        }
	}

	public void deleteArtArtistHonorss(Serializable[] ids) throws ServiceException {
		try {
			artArtistHonorsDao.deleteAll(ids);
        } catch (DAOException e) {
          e.printStackTrace();
          throw new ServiceException("数据库操作错误。");
        } catch (ServiceException se) {
          se.printStackTrace();
          throw se;
        } catch (Exception e) {
          e.printStackTrace();
          throw new ServiceException("系统错误。");
        }
	}

	public void deleteArtArtistWithHonorss(Serializable[] ids) throws ServiceException {
		try {
			for (Serializable id : ids) {
				artArtistHonorsDao.deleteByField("artistId", id);
			}
        } catch (DAOException e) {
          e.printStackTrace();
          throw new ServiceException("数据库操作错误。");
        } catch (ServiceException se) {
          se.printStackTrace();
          throw se;
        } catch (Exception e) {
          e.printStackTrace();
          throw new ServiceException("系统错误。");
        }
	}
	
	public String importHonors(String path,int artistId) throws ServiceException {
		String message = "";
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			HSSFWorkbook wb = new HSSFWorkbook(fileInputStream);
			HSSFSheet sht = wb.getSheetAt(0);
			if (sht != null) {
				for (int rowNum = 2; rowNum < sht.getLastRowNum(); rowNum++) {
					HSSFRow hssfRow = sht.getRow(rowNum);
					if(hssfRow == null) continue;
					if (hssfRow.getCell(0) == null) {
						message = "成功操作到第" + String.valueOf(rowNum-1) + "行";
						break;
					}
					if(("").equals(getValue(hssfRow.getCell(0)))) {
						message = "成功操作到第" + String.valueOf(rowNum-1) + "行";
						break;
					}
					ArtArtistHonors artArtistHonors = new ArtArtistHonors();
					String str = "";
					artArtistHonors.setArtistId(artistId);
					str = getValue(hssfRow.getCell(1));
					if ("".equals(str)) {
						message = "第" + String.valueOf(rowNum) + "行找不到时间";
						break;
					}
					artArtistHonors.setHonorTime(str);
					str = getValue(hssfRow.getCell(2));
					if ("".equals(str)) {
						message = "第" + String.valueOf(rowNum) + "行找不到描述";
						break;
					}
					artArtistHonors.setHonorDesc(str);
					createArtArtistHonors(artArtistHonors);
				}
			}
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		File file = new File(path);
		if(file.exists() && file.isFile()){
			file.delete();
		}
		return message;
	}
	
	private String getValue(HSSFCell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			// 返回数值类型的值
			DecimalFormat df = new DecimalFormat("0");
			return df.format(hssfCell.getNumericCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_FORMULA) {
			// 返回数值类型的值
			return String.valueOf(hssfCell.getNumericCellValue());
		} else {
			// 返回字符串类型的值
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}
	
	public PageQuery queryArtArtistHonors(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("artArtistHonorsList", pageQuery);
        } catch (DAOException e) {
          e.printStackTrace();
          throw new ServiceException("数据库操作错误。");
        } catch (ServiceException se) {
          se.printStackTrace();
          throw se;
        } catch (Exception e) {
          e.printStackTrace();
          throw new ServiceException("系统错误。");
        }
	}
	
	private void createSqlFilter(PageQuery page) {
		String artistId = page.getParameters().get("artistId");
		String paras = "";
		paras = " aah.artist_id = " + artistId + " ";
		if (paras.length() > 0) {
			page.getParameters().put("paras", paras);
		}
	}
	
    @Resource
	private ArtArtistHonorsDao	artArtistHonorsDao;

	public void setArtArtistHonorsDao(ArtArtistHonorsDao artArtistHonorsDao) {
		this.artArtistHonorsDao = artArtistHonorsDao;
	}
}

