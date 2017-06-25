package com.golead.art.publication.service.impl;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import javax.annotation.Resource;

import com.golead.art.util.AttachmentUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.golead.art.artist.dao.ArtArtistDao;
import com.golead.art.artist.model.ArtArtist;
import com.golead.art.publication.dao.ArtPublicationDao;
import com.golead.art.publication.model.ArtPublication;
import com.golead.art.publication.service.ArtPublicationService;
import com.golead.core.common.Code;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.DAOException;
import com.golead.core.exception.ServiceException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;
import com.golead.core.web.form.BaseForm;

@Service
public class ArtPublicationServiceImpl extends BaseServiceImpl implements ArtPublicationService {
   private static final long serialVersionUID = 1L;

   public ArtPublication getArtPublication(Serializable id) throws ServiceException {
      try {
         return artPublicationDao.get(id);
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

   public void createArtPublication(ArtPublication artPublication) throws ServiceException {
      try {
         artPublicationDao.save(artPublication);
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

   public String getArtPublicationPath(ArtPublication artPublication, String filePath) {
      String catalogName = artPublication.getCatalogName();
      String path;
      if (catalogName != null && !"".equals(catalogName)) {
         path = filePath + File.separator + catalogName;
      }
      else {
         String newCatalogName = String.valueOf(System.currentTimeMillis());
         path = filePath + File.separator + newCatalogName;
         artPublication.setCatalogName(newCatalogName);
      }
      File file = new File(path);
      if (!file.exists()) {
         file.mkdir();
      }
      return path;
   }

   public void createArtPublication(ArtPublication artPublication, File cover, String coverFileName, File backCover, String backCoverFileName, List<File> files,
         String[] filesFileName, String filePath) throws ServiceException {
      try {
         String dir = getArtPublicationPath(artPublication, filePath);
         if (cover != null) {
            String coverAttachment = AttachmentUtils.addAttachment(cover, coverFileName, dir);
            artPublication.setCover(coverAttachment);
         }
         if (backCover != null) {
            String backCoverAttachment = AttachmentUtils.addAttachment(backCover, backCoverFileName, dir);
            artPublication.setBackCover(backCoverAttachment);
         }
         if (files != null && files.size() > 0) {
            String[] catalogOtherNameList = new String[filesFileName.length];
            for (int i = 0; i < filesFileName.length; i++) {
               catalogOtherNameList[i] = AttachmentUtils.addAttachment(files.get(i), filesFileName[i], dir);
            }
            String catalogOther = StringUtils.join(catalogOtherNameList, ",");
            artPublication.setCatalogOther(catalogOther);
         }
         artPublicationDao.save(artPublication);
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

   private void changePath(ArtPublication publication, String filePath) throws IOException {
      Integer artistId = publication.getArtistId();
      String cover = publication.getCover();
      String backCover = publication.getBackCover();
      String catalogOther = publication.getCatalogOther();
      String fileNames = "";
      if (StringUtils.isNotEmpty(cover)) {
         fileNames += cover;
      }
      if (StringUtils.isNotEmpty(backCover)) {
         fileNames += "," + backCover;
      }
      if (StringUtils.isNotEmpty(catalogOther)) {
         fileNames += "," + catalogOther;
      }
      final String t = fileNames;
      if (artistId != null) {
         String oldPath = filePath + File.separator + artArtistDao.get(artistId).getFolderName();
         File file = new File(oldPath);
         if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles(new FilenameFilter() {
               @Override
               public boolean accept(File dir, String name) {
                  int index = t.indexOf(name);
                  if (index != -1) { return true; }
                  return false;
               }
            });
            for (File f : files) {
               File target = new File(filePath);
               FileUtils.copyFileToDirectory(f, target);
            }
         }
         publication.setArtistId(null);
      }
   }

   public void updateArtPublication(Map<String, String> artPublicationMap, File cover, String coverFileName, File backCover, String backCoverFileName,
         List<File> files, String[] filesFileName, String catalogOther, String filePath) throws ServiceException {
      try {
         Integer pkId = new Integer(artPublicationMap.get(ArtPublication.PROP_ID));
         ArtPublication oldPublication = artPublicationDao.get(pkId);
         String dir = getArtPublicationPath(oldPublication, filePath);
         Integer artistId = oldPublication.getArtistId();
         if (artistId != null) {
            changePath(oldPublication,dir);
         }
         ConvertUtil.mapToObject(oldPublication, artPublicationMap, true);

         //判断封面是否需要替换
         if (cover != null) {
            String coverStr = oldPublication.getCover();
            if (coverStr != null) {
               String[] coverNames = coverStr.split("/");
               String coverName;
               if (coverNames.length > 1) {
                  coverName = coverNames[1];
               }
               else {
                  coverName = coverNames[0];
               }
               String replaceCover = AttachmentUtils.replaceAttachment(cover, coverFileName, dir, coverName);
               oldPublication.setCover(replaceCover);
            }
            else {
               String attachment = AttachmentUtils.addAttachment(cover, coverFileName, dir);
               oldPublication.setCover(attachment);
            }
         }
         //判断封底是否需要替换
         if (backCover != null) {
            String backCoverStr = oldPublication.getBackCover();
            if (backCoverStr != null) {
               String[] backCoverNames = backCoverStr.split("/");
               String backCoverName;
               if (backCoverNames.length > 1) {
                  backCoverName = backCoverNames[1];
               }
               else {
                  backCoverName = backCoverNames[0];
               }
               String replaceBackCover = AttachmentUtils.replaceAttachment(backCover, backCoverFileName, dir, backCoverName);
               oldPublication.setBackCover(replaceBackCover);
            }
            else {
               String attachment = AttachmentUtils.addAttachment(backCover, backCoverFileName, dir);
               oldPublication.setBackCover(attachment);
            }
         }
         //判断其他是否有新增或修改
         String oldPublicationCatalogOther = oldPublication.getCatalogOther();
         if (catalogOther != null) {
            Set<String> oldPublicationCatalogOtherNameSet = new HashSet<String>(Arrays.asList(oldPublicationCatalogOther.split(",")));
            Set<String> catalogOtherNameSet = new HashSet<String>(Arrays.asList(catalogOther.split(",")));
            oldPublicationCatalogOtherNameSet.removeAll(catalogOtherNameSet);
            List<String> attachmentFileName = new ArrayList<String>();
            for (String fileName : oldPublicationCatalogOtherNameSet) {
               attachmentFileName.add(fileName.split("/")[1]);
            }
            AttachmentUtils.deleteAttachment(dir, attachmentFileName.toArray(new String[attachmentFileName.size()]));
            oldPublication.setCatalogOther(catalogOther);
         }
         else if (oldPublicationCatalogOther != null && !"".equals(oldPublicationCatalogOther)) {
            String[] split = oldPublicationCatalogOther.split(",");
            String[] deleteFileNames = new String[split.length];
            for (int i = 0; i < split.length; i++) {
               deleteFileNames[i] = split[i].split("/")[1];
            }
            AttachmentUtils.deleteAttachment(dir, deleteFileNames);
            oldPublication.setCatalogOther(null);
         }
         if (files != null && files.size() > 0) {
            String[] newCatalogOtherName = new String[files.size()];
            for (int i = 0; i < files.size(); i++) {
               newCatalogOtherName[i] = AttachmentUtils.addAttachment(files.get(i), filesFileName[i], dir);
            }
            String c;
            if (catalogOther != null && !"".equals(catalogOther)) {
               c = catalogOther + "," + StringUtils.join(newCatalogOtherName, ",");
            }
            else {
               c = StringUtils.join(newCatalogOtherName, ",");
            }
            oldPublication.setCatalogOther(c);
         }

         artPublicationDao.update(oldPublication);
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

   public void deleteArtPublication(Serializable id) throws ServiceException {
      try {
         artPublicationDao.delete(id);
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

   @Override
   public void deleteArtPublications(Serializable[] ids, String path) throws ServiceException {
      try {
         for (Serializable id : ids) {
            ArtPublication publication = artPublicationDao.get(id);
            String dir = getArtPublicationPath(publication, path);
            List<String> fileName = new ArrayList<String>();
            String cover = publication.getCover();
            if (cover != null && !"".equals(cover)) {
               fileName.add(cover.split("/")[1]);
            }
            String backCover = publication.getBackCover();
            if (backCover != null && !"".equals(backCover)) {
               fileName.add(backCover.split("/")[1]);
            }
            String catalogOther = publication.getCatalogOther();
            if (catalogOther != null && !"".equals(catalogOther)) {
               String[] split = catalogOther.split(",");
               for (int i = 0; i < split.length; i++) {
                  fileName.add(split[i].split("/")[1]);
               }
            }
            AttachmentUtils.deleteAttachment(dir, fileName.toArray(new String[fileName.size()]));
            artPublicationDao.delete(publication);
         }
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

   public PageQuery queryArtPublication(PageQuery pageQuery) throws ServiceException {
      try {
         createSqlFilter(pageQuery);
         return jdbcDao.queryBySqlId("artPublicationList", pageQuery);
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
      String tmp = "";
      Map<String, String> map = page.getParameters();
      String str = map.get("publicationType");
      if (str != null && !"".equals(str.trim())) {
         if (tmp.length() > 0) tmp += " and ";
         tmp += " p.publication_type ='" + str.trim() + "'";
      }
      str = map.get("artistName");
      if (str != null && !"".equals(str.trim())) {
         if (tmp.length() > 0) tmp += " and ";
         tmp += " a.c_name like '%" + str.trim() + "%'";
      }
      str = map.get("publicationYear");
      if (str != null && !"".equals(str.trim())) {
         if (tmp.length() > 0) tmp += " and ";
         tmp += " p.publication_year =" + str.trim();
      }
      str = map.get("publicationName");
      if (str != null && !"".equals(str.trim())) {
         if (tmp.length() > 0) tmp += " and ";
         tmp += " p.publication_name like '%" + str.trim() + "%'";
      }

      if (tmp.length() > 0) map.put("paras", tmp);
   }

   public List<ArtPublication> findAll() throws ServiceException {
      try {
         return artPublicationDao.findAll();
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   @SuppressWarnings("deprecation")
   public HSSFWorkbook export(BaseForm form, PageQuery pageQuery) throws ServiceException {
      try {
         HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
         HSSFSheet sheet = hssfWorkbook.createSheet("sheet1");
         HSSFRow row = sheet.createRow((int) 0);

         HSSFCell cell = row.createCell((short) 0);
         cell.setCellValue("出版物名称");
         cell = row.createCell((short) 1);
         cell.setCellValue("艺术家");
         cell = row.createCell((short) 2);
         cell.setCellValue("出版机构");
         cell = row.createCell((short) 3);
         cell.setCellValue("出版时间");
         cell = row.createCell((short) 4);
         cell.setCellValue("编辑信息");
         cell = row.createCell((short) 5);
         cell.setCellValue("发行量");
         cell = row.createCell((short) 6);
         cell.setCellValue("印次");
         cell = row.createCell((short) 7);
         cell.setCellValue("出版物类型");
         cell = row.createCell((short) 8);
         cell.setCellValue("总页数");
         cell = row.createCell((short) 9);
         cell.setCellValue("价格");
         pageQuery.setPageSize("-1");
         PageQuery pageQuery2 = queryArtPublication(pageQuery);
         int i = 0;
         for (Map<String, Object> item : pageQuery2.getRecordSet()) {
            String time = "";
            time = addString(time, returnString(item.get("publicationYear")), "年");
            time = addString(time, returnString(item.get("publicationMonth")), "月");
            String publicationType = findCodeName(form, "PUBLI_TYPE", returnString(item.get("publicationType")));
            String money = returnString(item.get("price")) + findCodeName(form, "CURRENCY_TYPE", returnString(item.get("priceUnit")));
            row = sheet.createRow(i + 1);
            row.createCell((short) 0).setCellValue(returnString(item.get("publicationName")));
            row.createCell((short) 1).setCellValue(returnString(item.get("cName")));
            row.createCell((short) 2).setCellValue(returnString(item.get("press")));
            row.createCell((short) 3).setCellValue(time);
            row.createCell((short) 4).setCellValue(returnString(item.get("editor")));
            row.createCell((short) 5).setCellValue(returnString(item.get("circulation")));
            row.createCell((short) 6).setCellValue(returnString(item.get("impression")));
            row.createCell((short) 7).setCellValue(publicationType);
            row.createCell((short) 8).setCellValue(returnString(item.get("pageCount")));
            row.createCell((short) 9).setCellValue(money);
            i++;
         }
         return hssfWorkbook;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   private String returnString(Object object) {
      String str = object == null ? "" : object.toString();
      return str;
   }

   private String addString(String str, String equalStr, String addStr) {
      if (!"".equals(equalStr)) {
         if (equalStr.indexOf(addStr) > -1) return str + equalStr;
         else return str + equalStr + addStr;
      }
      return str;
   }

   private String findCodeName(Object objForm, String codeNo, Serializable value) {
      BaseForm bf = (BaseForm) objForm;

      List<Code> list = bf.getCodeSets().get(codeNo);
      if (value == null) return "";
      if (list == null) return "";
      for (int i = 0; i < list.size(); i++) {
         Code code = list.get(i);
         String v;
         if (value instanceof String) v = ((String) value).trim();
         else v = value.toString();
         if (v.equals(code.getValue())) return code.getCodeName();
      }
      return "";
   }

   @Resource
   private ArtPublicationDao artPublicationDao;

   @Resource
   private ArtArtistDao      artArtistDao;
}
