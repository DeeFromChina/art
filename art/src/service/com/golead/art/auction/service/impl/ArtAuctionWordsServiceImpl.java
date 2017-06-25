package com.golead.art.auction.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;
import com.golead.art.auction.dao.ArtAuctionWordsDao;
import com.golead.art.auction.model.ArtAuctionWords;
import com.golead.art.auction.service.ArtAuctionWordsService;
import com.golead.art.utils.FileUtils;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ArtAuctionWordsServiceImpl extends BaseServiceImpl implements ArtAuctionWordsService {
   private static final long serialVersionUID = 1L;

   public ArtAuctionWords getArtAuctionWords(Serializable id) throws ServiceException {
      try {
         return artAuctionWordsDao.get(id);
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   public void createArtAuctionWords(ArtAuctionWords artAuctionWords, List<File> files, String filesFileName, String path) throws ServiceException {
      try {
         StringBuffer attachment = new StringBuffer();
         String[] attachmentNames;
         if (files != null) {
            attachmentNames = filesFileName.split(",");
            for (int i = 0; i < files.size(); i++) {
               File file = files.get(i);
               String newName = String.valueOf(System.currentTimeMillis());
               String endLess = attachmentNames[i].split("\\.")[1];
               FileUtils.fileUpload(path + File.separator + newName + "." + endLess, file);
               attachment.append(newName + "." + endLess);
               if (i + 1 != files.size()) attachment.append(";");
            }
         }
         artAuctionWords.setAttachment(attachment.toString());
         artAuctionWordsDao.save(artAuctionWords);
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   public void updateArtAuctionWords(Map<String, String> artAuctionWordsMap, List<File> files, String fileName, String filesFileName, String path)
         throws ServiceException {
      try {
         Integer pkId = new Integer(artAuctionWordsMap.get(ArtAuctionWords.PROP_ID));
         ArtAuctionWords tmp = artAuctionWordsDao.get(pkId);
         StringBuffer newAttachment = new StringBuffer();

         String attachment;//数据库值
         String[] deleteAttachments = null;//需要删除的附件

         if (tmp.getAttachment() != null && !"".equals(tmp.getAttachment())) {
            attachment = tmp.getAttachment();
            deleteAttachments = attachment.replace(fileName, "").split(";");
            File file = new File(path);
            File[] fileList = file.listFiles();
            if (fileList != null) {
               for (File inFile : fileList) {
                  for (String deleteAttachment : deleteAttachments) {
                     if (deleteAttachment.equals(inFile.getName())) {
                        inFile.delete();
                     }
                  }
               }
               File[] fileList2 = new File(path).listFiles();
               if (fileList2.length == 0) {
                  file.delete();
               }
            }
            if (fileName.length() > 0) {
               newAttachment.append(fileName + ";");
            }
         }

         if (files != null) {
            String[] attachmentNames = filesFileName.split(",");
            for (int i = 0; i < files.size(); i++) {
               File file = files.get(i);
               String newName = String.valueOf(System.currentTimeMillis());
               String endLess = attachmentNames[i].split("\\.")[1];
               FileUtils.fileUpload(path + File.separator + newName + "." + endLess, file);
               newAttachment.append(newName + "." + endLess);
               if (i + 1 != files.size()) newAttachment.append(";");
            }
         }

         tmp.setAttachment(newAttachment.toString());
         ConvertUtil.mapToObject(tmp, artAuctionWordsMap, true);
         artAuctionWordsDao.update(tmp);
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   public void deleteArtAuctionWords(Serializable id) throws ServiceException {
      try {
         artAuctionWordsDao.delete(id);
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   public void deleteArtAuctionWordss(Serializable[] ids) throws ServiceException {
      try {
         artAuctionWordsDao.deleteAll(ids);
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   public void deleteArtAuctionWordss(Serializable[] ids, String path) throws ServiceException {
      try {
         List<String> fileNames = new ArrayList<String>();
         for (Serializable id : ids) {
            ArtAuctionWords artAuctionWords = getArtAuctionWords(id);
            String[] attachments = artAuctionWords.getAttachment().split(";");
            if (artAuctionWords.getAttachment().length() > 0) {
               for (String attachment : attachments) {
                  fileNames.add(attachment);
               }
            }
         }
         File[] fileLies = new File(path).listFiles();
         if (fileLies != null) {
            for (File file : fileLies) {
               for (String fileName : fileNames) {
                  if (fileName.equals(file.getName())) {
                     file.delete();
                  }
               }
            }
            fileLies = new File(path).listFiles();
            if (fileLies.length == 0) {
               File file = new File(path);
               file.delete();
            }
         }
         artAuctionWordsDao.deleteAll(ids);
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   public String importWords(String path, int auctionId) throws ServiceException {
      String message = "";
      try {
         FileInputStream fileInputStream = new FileInputStream(path);
         HSSFWorkbook wb = new HSSFWorkbook(fileInputStream);
         HSSFSheet sht = wb.getSheetAt(0);
         if (sht != null) {
            for (int rowNum = 2; rowNum < sht.getLastRowNum(); rowNum++) {
               HSSFRow hssfRow = sht.getRow(rowNum);
               if (hssfRow == null) continue;
               if (hssfRow.getCell(0) == null) {
                  message = "成功操作到第" + String.valueOf(rowNum - 1) + "行";
                  break;
               }
               if (("").equals(getValue(hssfRow.getCell(0)))) {
                  message = "成功操作到第" + String.valueOf(rowNum - 1) + "行";
                  break;
               }
               ArtAuctionWords artAuctionWords = new ArtAuctionWords();
               String str = "";
               Date time = null;
               str = getValue(hssfRow.getCell(1));
               if ("".equals(str)) {
                  message = "第" + String.valueOf(rowNum) + "行找不到文章主题";
                  break;
               }
               artAuctionWords.setWordsTheme(str);
               str = getValue(hssfRow.getCell(2));
               if ("".equals(str)) {
                  message = "第" + String.valueOf(rowNum) + "行找不到出处";
                  break;
               }
               artAuctionWords.setWordsSource(str);
               time = hssfRow.getCell(3).getDateCellValue();
               if ("".equals(time)) {
                  message = "第" + String.valueOf(rowNum) + "行找不到时间";
                  break;
               }
               artAuctionWords.setWordsTime(time);
               artAuctionWords.setAuctionId(auctionId);
               artAuctionWordsDao.save(artAuctionWords);
            }
         }
         fileInputStream.close();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      File file = new File(path);
      if (file.exists() && file.isFile()) {
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

   public PageQuery queryArtAuctionWords(PageQuery pageQuery) throws ServiceException {
      try {
         createSqlFilter(pageQuery);
         return jdbcDao.queryBySqlId("artAuctionWordsList", pageQuery);
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   private void createSqlFilter(PageQuery page) {
      String paras = "";
      Map<String, String> map = page.getParameters();
      String auctionId = map.get("auctionId");
      if (auctionId != null && !"".equals(auctionId.trim())) {
         paras = " auction_id = " + auctionId.trim();
      }
      if (paras.length() > 0) page.getParameters().put("paras", paras);
   }

   @Resource
   private ArtAuctionWordsDao artAuctionWordsDao;

   public void setArtAuctionWordsDao(ArtAuctionWordsDao artAuctionWordsDao) {
      this.artAuctionWordsDao = artAuctionWordsDao;
   }
}
