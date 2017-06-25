package com.golead.art.literature.service.impl;

import java.io.File;
import java.io.Serializable;
import java.util.*;

import javax.annotation.Resource;

import com.golead.art.util.AttachmentUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.golead.art.literature.dao.ArtLiteratureOtherDao;
import com.golead.art.literature.model.ArtLiteratureOther;
import com.golead.art.literature.model.ArtLiteratureOtherResearch;
import com.golead.art.literature.service.ArtLiteratureOtherResearchService;
import com.golead.art.literature.service.ArtLiteratureOtherService;
import com.golead.art.utils.FileUtils;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.DAOException;
import com.golead.core.exception.ServiceException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;

@Service
public class ArtLiteratureOtherServiceImpl extends BaseServiceImpl implements ArtLiteratureOtherService {
   private static final long serialVersionUID = 1L;

   public ArtLiteratureOther getArtLiteratureOther(Serializable id) throws ServiceException {
      try {
         return artLiteratureOtherDao.get(id);
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

   public void createArtLiteratureOther(ArtLiteratureOther artLiteratureOther) throws ServiceException {
      try {
         artLiteratureOtherDao.save(artLiteratureOther);
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

   public void updateArtLiteratureOther(Map<String, String> record, List<File> files, String[] filesFileName, String[] attachmentName, String path)
         throws ServiceException {
      try {
         Integer literatureOtherId = Integer.valueOf(record.get("id"));
         ArtLiteratureOther artLiteratureOther = getArtLiteratureOther(literatureOtherId);
         ArtLiteratureOtherResearch artLiteratureOtherResearch = artLiteratureOtherResearchService
               .getArtLiteratureOtherResearchByArtLiteratureOtherId(artLiteratureOther.getId());
         ConvertUtil.convertToModel(artLiteratureOther, record);
         ConvertUtil.convertToModel(artLiteratureOtherResearch, record);

         String literatureOtherAttachmentPath = path += literatureOtherId;

         StringBuffer attachmentNameBuffer = new StringBuffer();

         if (attachmentName != null && attachmentName.length > 0) {
            Set<String> attachmentNameSet = new HashSet<String>(Arrays.asList(attachmentName));
            Set<String> attachmentSet = new HashSet<String>(Arrays.asList(artLiteratureOther.getAttachment().split(",")));
            attachmentSet.removeAll(attachmentNameSet);
            List<String> deleteFileName = new ArrayList<String>();
            for (String s : attachmentSet) {
               deleteFileName.add(s.split("/")[1]);
            }
            AttachmentUtils.deleteAttachment(literatureOtherAttachmentPath, deleteFileName.toArray(new String[attachmentSet.size()]));
            for (int i = 0; i < attachmentName.length; i++) {
               attachmentNameBuffer.append(attachmentName[i]);
               if (i != (attachmentName.length - 1)) attachmentNameBuffer.append(",");
            }
         }
         else if (artLiteratureOther.getAttachment() != null && !"".equals(artLiteratureOther.getAttachment())) {
            String[] split = artLiteratureOther.getAttachment().split(",");
            String[] deleteFileNames = new String[split.length];
            for (int i = 0; i < split.length; i++) {
               deleteFileNames[i] = split[i].split("/")[1];
            }
            AttachmentUtils.deleteAttachment(literatureOtherAttachmentPath, deleteFileNames);
         }

         if (filesFileName != null && filesFileName.length > 0) {
            for (int i = 0; i < filesFileName.length; i++) {
               String newAttachemenName = AttachmentUtils.addAttachment(files.get(i), filesFileName[i], literatureOtherAttachmentPath);
               attachmentNameBuffer.append(newAttachemenName);
               if (i != (filesFileName.length - 1)) attachmentNameBuffer.append(",");
            }
         }
         artLiteratureOther.setAttachment(attachmentNameBuffer.toString());
         artLiteratureOtherDao.update(artLiteratureOther);
         artLiteratureOtherResearchService.updateArtLiteratureOtherResearch(artLiteratureOtherResearch);
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

   public void updateArtLiteratureOther(Map<String, String> artLiteratureOtherMap) throws ServiceException {
      try {
         Integer pkId = new Integer(artLiteratureOtherMap.get(ArtLiteratureOther.PROP_ID));
         ArtLiteratureOther tmp = artLiteratureOtherDao.get(pkId);
         ConvertUtil.mapToObject(tmp, artLiteratureOtherMap, true);
         artLiteratureOtherDao.update(tmp);
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

   public void deleteArtLiteratureOther(Serializable id) throws ServiceException {
      try {
         artLiteratureOtherDao.delete(id);
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

   public void deleteArtLiteratureOthers(Serializable[] ids) throws ServiceException {
      try {
         artLiteratureOtherDao.deleteAll(ids);
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

   public PageQuery queryArtLiteratureOther(PageQuery pageQuery) throws ServiceException {
      try {
         createSqlFilter(pageQuery);
         return jdbcDao.queryBySqlId("artLiteratureOtherList", pageQuery);
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
      StringBuffer tmp = new StringBuffer();

      Map<String, String> map = page.getParameters();

      String artArtistId = map.get("artistId");

      if (artArtistId != null && !"".equals(artArtistId)) {
         if (tmp.length() > 0) tmp.append(" AND ");
         tmp.append(" alo.artist_id = ").append(artArtistId.trim());
      }

      String cName = map.get("cName");
      if (cName != null && !"".equals(cName)) {
         if (tmp.length() > 0) tmp.append(" AND ");
         tmp.append(" aa.c_name LIKE '%").append(cName.trim()).append("%'");
      }

      String literatureTitle = map.get("literatureTitle");
      if (literatureTitle != null && !"".equals(literatureTitle)) {
         if (tmp.length() > 0) tmp.append(" AND ");
         tmp.append(" alo.literature_title like '%").append(literatureTitle.trim()).append("%'");
      }

      if (tmp.length() > 0) {
         page.getParameters().put("paras", tmp.toString());
      }
   }

   public boolean saveFile(ArtLiteratureOther artLiteratureOther, List<File> files, String filesFileName, String FILE_PATH) throws ServiceException {
      try {
         String[] names = filesFileName.split(",");
         String path = FILE_PATH + File.separator + artLiteratureOther.getId().toString();
         if (!new File(path).exists()) {
            new File(path).mkdirs();
         }
         StringBuffer fileName = new StringBuffer();
         if (files != null) {
            for (int i = 0; i < files.size(); i++) {
               if (files.get(i) == null) {
                  break;
               }
               File file = files.get(i);
               String cName = String.valueOf(System.currentTimeMillis());
               String[] endless = names[i].split("\\.");
               FileUtils.fileUpload(path + File.separator + cName + "." + endless[endless.length - 1], file);
               fileName.append(names[i] + "/" + cName + "." + endless[endless.length - 1]);
               if ((i + 1) != files.size()) fileName.append(",");
            }
         }
         artLiteratureOther.setAttachment(fileName.toString());
         updateArtLiteratureOther(artLiteratureOther);
         return false;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   public void updateFile(ArtLiteratureOtherResearch artLiteratureOtherResearch, ArtLiteratureOther artLiteratureOther, List<File> files, String filesFileName,
         String FILE_PATH, String fileName) throws ServiceException {
      try {
         artLiteratureOtherResearchService.updateArtLiteratureOtherResearch(artLiteratureOtherResearch);
         String path = FILE_PATH + File.separator + artLiteratureOther.getId().toString();
         File file = new File(path);
         File[] files2 = null;
         if (file.exists()) {
            files2 = file.listFiles();//原本的文件
         }
         Map<String, String> map = new HashMap<String, String>();
         if (fileName != null && !"".equals(fileName)) {
            String[] fileNames = fileName.split(",");
            for (int i = 0; i < fileNames.length; i++) {
               if (fileNames[i] != null && !"".equals(fileNames[i])) {
                  map.put(fileNames[i], "");
               }
            }
         }
         String attachment = artLiteratureOther.getAttachment();
         StringBuffer newAttachment = new StringBuffer();
         if (attachment != null && !"".equals(attachment)) {
            String[] attachments = attachment.split(",");
            for (int i = 0; i < attachments.length; i++) {
               if (map.get(attachments[i].split("/")[1]) == null) {
                  deleteFile(files2, attachments[i].split("/")[1]);
                  attachments[i] = "";
               }
               if (attachments[i] != "") {
                  newAttachment.append(attachments[i]);
                  newAttachment.append(",");
               }
            }

         }
         if (files != null) {
            saveFile(artLiteratureOther, files, filesFileName, FILE_PATH);
            attachment = artLiteratureOther.getAttachment();
            newAttachment.append(attachment);
         }
         String att = newAttachment.toString();
         if (att.endsWith(",")) {
            att.substring(0, att.length() - 1);
         }
         artLiteratureOther.setAttachment(att);
         updateArtLiteratureOther(artLiteratureOther);
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   private void deleteFile(File[] files, String fileName) {
      if (files == null) { return; }
      for (int i = 0; i < files.length; i++) {
         File file = files[i];
         if (file.getName().equals(fileName)) {
            file.delete();
         }
      }
   }

   @Override
   public void updateArtLiteratureOther(ArtLiteratureOther artLiteratureOther) throws ServiceException {
      try {
         artLiteratureOtherDao.update(artLiteratureOther);
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

   @Resource
   private ArtLiteratureOtherDao             artLiteratureOtherDao;

   @Resource
   private ArtLiteratureOtherResearchService artLiteratureOtherResearchService;

   public void setArtLiteratureOtherDao(ArtLiteratureOtherDao artLiteratureOtherDao) {
      this.artLiteratureOtherDao = artLiteratureOtherDao;
   }
}
