package com.golead.art.works.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.golead.common.model.SysCode;
import com.golead.common.service.system.SysCodeService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;
import com.golead.art.artist.model.ArtArtistWorksPeriod;
import com.golead.art.artist.service.ArtArtistWorksPeriodService;
import com.golead.art.works.dao.ArtWorksPeriodDao;
import com.golead.art.works.model.ArtWorks;
import com.golead.art.works.model.ArtWorksPeriod;
import com.golead.art.works.service.ArtWorksPeriodService;
import com.golead.art.works.service.ArtWorksService;

import javax.annotation.Resource; 

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ArtWorksPeriodServiceImpl extends BaseServiceImpl implements ArtWorksPeriodService {
   private static final long serialVersionUID = 1L;

   public ArtWorksPeriod getArtWorksPeriod(Serializable id) throws ServiceException {
      try {
         return artWorksPeriodDao.get(id);
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

   public void createArtWorksPeriod(ArtWorksPeriod artWorksPeriod) throws ServiceException {
      try {
         artWorksPeriodDao.save(artWorksPeriod);
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

   public void updateArtWorksPeriod(Map<String, String> artWorksPeriodMap) throws ServiceException {
      try {
         Integer pkId = new Integer(artWorksPeriodMap.get(ArtWorksPeriod.PROP_ID));
         ArtWorksPeriod tmp = artWorksPeriodDao.get(pkId);
         ConvertUtil.mapToObject(tmp, artWorksPeriodMap, true);  
         artWorksPeriodMap.put("id", artWorksPeriodMap.get("artistworksPeriodId"));
         artArtistWorksPeriodService.updateArtArtistWorksPeriod(artWorksPeriodMap);
         artWorksPeriodDao.update(tmp);
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

   public void deleteArtWorksPeriod(Serializable id) throws ServiceException {
      try {
         artWorksPeriodDao.delete(id);
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

   public void deleteArtWorksPeriods(Serializable[] ids) throws ServiceException {
      try {
         artWorksPeriodDao.deleteAll(ids);
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

   public PageQuery queryArtWorksPeriod(PageQuery pageQuery) throws ServiceException {
      try {
        createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("artWorksPeriodList", pageQuery);
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
      String paras = " 1=1 ";
      Map<String, String> map = page.getParameters();
      
      String worksId = map.get("id");
      if (worksId != null && worksId.trim().length() > 0) {
         paras += " AND works.id =" + worksId.trim();
      }
      
      if (paras.length() > 0) page.getParameters().put("paras", paras);
   }
   
   public void createArtWorksPeriodAndArtArtistWorksPeriod(Map<String, String> map) throws ServiceException{
      try {
         ArtWorksPeriod artWorksPeriod = new ArtWorksPeriod();
         artWorksPeriod.setPeriodType(map.get("periodType"));
         artWorksPeriod.setPeriodName(map.get("periodName"));
         artWorksPeriod.setWorksId(Integer.valueOf(map.get("worksId")));
         createArtWorksPeriod(artWorksPeriod);
         ArtArtistWorksPeriod artArtistWorksPeriod = new ArtArtistWorksPeriod();
         artArtistWorksPeriod.setArtistId(Integer.valueOf(map.get("artistId")));
         artArtistWorksPeriod.setPeriodName(map.get("periodName"));
         artArtistWorksPeriod.setPeriodType(map.get("periodType"));
         artArtistWorksPeriodService.createArtArtistWorksPeriod(artArtistWorksPeriod);
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
   
   public String importArtWorksPeriod(String path, Integer id) throws ServiceException{
      String message = "";
      try {
         ArtWorks artWorks = artWorksService.getArtWorks(id);
         List<SysCode> sysCodes = sysCodeService.findCodeBySetId(17);
         Map<String, String> map = new HashMap<String, String>();
         for(SysCode sysCode : sysCodes){
            map.put(sysCode.getItemName(), sysCode.getItemValue());
         }
         InputStream is = new FileInputStream(path);
         HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
         // 循环工作表Sheet
         HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
         if (hssfSheet != null) {
            for (int rowNum = 2; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
               HSSFRow hssfRow = hssfSheet.getRow(rowNum);
               if (hssfRow == null) continue;
               
               ArtWorksPeriod artWorksPeriod = new ArtWorksPeriod();
               if(hssfRow.getCell(0) == null){
                  message = "成功操作到第" + String.valueOf(rowNum-1) + "行";
                  break;
               }
               if("".equals(getValue(hssfRow.getCell(0)))){
                  message = "成功操作到第" + String.valueOf(rowNum-1) + "行";
                  break;
               }
               if(!artWorks.getWorksCName().equals(getValue(hssfRow.getCell(0))) && !artWorks.getWorksEName().equals(getValue(hssfRow.getCell(0)))){
                  message = "第" + String.valueOf(rowNum) + "行作品中文名不对";
                  break;
               }
               //时期名称
               String periodName = getValue(hssfRow.getCell(1));
               if("".equals(periodName)){
                  message = "第" + String.valueOf(rowNum) + "行时期名称不能为空";
                  break;
               }
               artWorksPeriod.setPeriodName(periodName);
               //时期类型
               String periodType = getValue(hssfRow.getCell(2));
               if(map.get(periodType) == null){
                  message = "第" + String.valueOf(rowNum) + "行找不到时期类型";
                  break;
               }
               periodType = map.get(periodType);
               artWorksPeriod.setPeriodType(periodType);
               artWorksPeriod.setWorksId(id);
               createArtWorksPeriod(artWorksPeriod);
            }
         }
      }
      catch (Exception e) {
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
      }
      else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
         // 返回数值类型的值  
         DecimalFormat df = new DecimalFormat("0");
         return df.format(hssfCell.getNumericCellValue());
      }
      else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_FORMULA) {
         // 返回数值类型的值  
         return String.valueOf(hssfCell.getNumericCellValue());
      }
      else {
         // 返回字符串类型的值      
         return String.valueOf(hssfCell.getStringCellValue());
      }
   }
   
    @Resource
   private ArtWorksPeriodDao  artWorksPeriodDao;
    
    @Resource
    private SysCodeService  sysCodeService;
    
    @Resource
    private ArtWorksService  artWorksService;
    
    @Resource
    private ArtArtistWorksPeriodService  artArtistWorksPeriodService;

   public void setArtWorksPeriodDao(ArtWorksPeriodDao artWorksPeriodDao) {
      this.artWorksPeriodDao = artWorksPeriodDao;
   }
}

