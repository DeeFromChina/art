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
import com.golead.art.artist.dao.ArtArtistEduDao;
import com.golead.art.artist.model.ArtArtistEdu;
import com.golead.art.artist.service.ArtArtistEduService;

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
public class ArtArtistEduServiceImpl extends BaseServiceImpl implements ArtArtistEduService {
	private static final long serialVersionUID = 1L;

	public ArtArtistEdu getArtArtistEdu(Serializable id) throws ServiceException {
		try {
			return artArtistEduDao.get(id);
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

	public void createArtArtistEdu(ArtArtistEdu artArtistEdu) throws ServiceException {
		try {
			artArtistEduDao.save(artArtistEdu);
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

	public void updateArtArtistEdu(Map<String, String> artArtistEduMap) throws ServiceException {
		try {
            Integer pkId = new Integer(artArtistEduMap.get(ArtArtistEdu.PROP_ID));
			ArtArtistEdu tmp = artArtistEduDao.get(pkId);
			ConvertUtil.mapToObject(tmp, artArtistEduMap, true);			
			artArtistEduDao.update(tmp);
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

	public void deleteArtArtistEdu(Serializable id) throws ServiceException {
		try {
			artArtistEduDao.delete(id);
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

	public void deleteArtArtistEdus(Serializable[] ids) throws ServiceException {
		try {
			artArtistEduDao.deleteAll(ids);
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

	public void deleteArtArtistWithEdus(Serializable[] ids) throws ServiceException {
		try {
			for(Serializable id : ids) {
				artArtistEduDao.deleteByField("artistId", id);
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
	
	public String importEdu(String path,int artistId) throws ServiceException {
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
					ArtArtistEdu artArtistEdu = new ArtArtistEdu();
					String str = "";
					artArtistEdu.setArtistId(artistId);
					str = getValue(hssfRow.getCell(1));
					if ("".equals(str)) {
						message = "第" + String.valueOf(rowNum) + "行找不到时间";
						break;
					}
					artArtistEdu.setEduTime(str);
					str = getValue(hssfRow.getCell(2));
					if ("".equals(str)) {
						message = "第" + String.valueOf(rowNum) + "行找不到描述";
						break;
					}
					artArtistEdu.setEduDesc(str);
					createArtArtistEdu(artArtistEdu);
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
	
	public void createArtArtistEdu(List<ArtArtistEdu> list) throws ServiceException {
		try {
			for (ArtArtistEdu artArtistEdu : list) {
				artArtistEduDao.save(artArtistEdu);
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
	
	public PageQuery queryArtArtistEdu(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("artArtistEduList", pageQuery);
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
		String paras = "";
		Map<String, String> parameters = page.getParameters();
		String artist_id = parameters.get("artistId");
		paras = " aae.artist_id = " + artist_id + " ";
		if (paras.length() > 0)
			page.getParameters().put("paras", paras);
	}
	
    @Resource
	private ArtArtistEduDao	artArtistEduDao;

	public void setArtArtistEduDao(ArtArtistEduDao artArtistEduDao) {
		this.artArtistEduDao = artArtistEduDao;
	}
}

