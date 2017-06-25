package com.golead.art.app.homePage.service.impl;

import java.io.File;
import java.io.Serializable;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.golead.art.app.homePage.dao.ArtAppHomePageDao;
import com.golead.art.app.homePage.model.ArtAppHomePage;
import com.golead.art.app.homePage.service.ArtAppHomePageService;
import com.golead.art.utils.FileUtils;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.DAOException;
import com.golead.core.exception.ServiceException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;

@Service
public class ArtAppHomePageServiceImpl extends BaseServiceImpl implements ArtAppHomePageService {
   private static final long serialVersionUID = 1L;

   public ArtAppHomePage getArtAppHomePage(Serializable id) throws ServiceException {
      try {
         return artAppHomePageDao.get(id);
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

   public void createArtAppHomePage(ArtAppHomePage artAppHomePage) throws ServiceException {
      try {
         artAppHomePageDao.save(artAppHomePage);
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

   private void setFile(ArtAppHomePage artAppHomePage, File file, String fileFileName, String path) {
      if (file != null) {
         String homepagePhoto = artAppHomePage.getHomepagePhoto();
         File file2 = new File(path);
         if(!file2.exists()){
            file2.mkdirs();
         }
         if (homepagePhoto != null) {
            File tFile = new File(path + File.pathSeparator + homepagePhoto);
            tFile.delete();
         }
         StringBuffer buffer = new StringBuffer();
         String cName = String.valueOf(System.currentTimeMillis());
         String extension = fileFileName.substring(fileFileName.lastIndexOf(".") + 1);
         buffer.append(fileFileName + "/" + cName + "." + extension);
         FileUtils.fileUpload(path + File.separator + cName + "." + extension, file);
         artAppHomePage.setHomepagePhoto(buffer.toString());
      }
   }

   public void createArtAppHomePage(ArtAppHomePage artAppHomePage, File file, String fileFileName, String path) throws ServiceException {
      try {
         setFile(artAppHomePage, file, fileFileName, path);
         artAppHomePageDao.save(artAppHomePage);
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

   public void updateArtAppHomePage(Map<String, String> artAppHomePageMap) throws ServiceException {
      try {
         Integer pkId = new Integer(artAppHomePageMap.get(ArtAppHomePage.PROP_ID));
         ArtAppHomePage tmp = artAppHomePageDao.get(pkId);
         ConvertUtil.mapToObject(tmp, artAppHomePageMap, true);
         artAppHomePageDao.update(tmp);
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
   public void updateArtAppHomePage(Map<String, String> artAppHomePageMap, File file, String fileName, String dir) throws ServiceException {
      try {
         Integer pkId = new Integer(artAppHomePageMap.get(ArtAppHomePage.PROP_ID));
         ArtAppHomePage tmp = artAppHomePageDao.get(pkId);
         ConvertUtil.mapToObject(tmp, artAppHomePageMap, true);
         setFile(tmp, file, fileName, dir);
         artAppHomePageDao.update(tmp);
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

   public void deleteArtAppHomePage(Serializable id) throws ServiceException {
      try {
         artAppHomePageDao.delete(id);
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

   public void deleteArtAppHomePage(Serializable id, String dir) throws ServiceException {
      try {
         ArtAppHomePage appHomePage = artAppHomePageDao.get(id);
         File file = new File((dir + File.pathSeparator + appHomePage.getHomepagePhoto().split("/")[1]));
         if (file.exists()) {
            file.delete();
         }
         artAppHomePageDao.delete(id);
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

   public void deleteArtAppHomePages(Serializable[] ids) throws ServiceException {
      try {
         artAppHomePageDao.deleteAll(ids);
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
   public void deleteArtAppHomePages(Serializable[] ids, String dir) throws ServiceException {
      try {
         for (int i = 0; i < ids.length; i++) {
            ArtAppHomePage artAppHomePage = artAppHomePageDao.get(ids[i]);
            artAppHomePageDao.delete(artAppHomePage);
            File file = new File(dir + File.separator + artAppHomePage.getHomepagePhoto().split("/")[1]);
            if (file.exists()) {
               file.delete();
            }
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

   public PageQuery queryArtAppHomePage(PageQuery pageQuery) throws ServiceException {
      try {
         createSqlFilter(pageQuery);
         return jdbcDao.queryBySqlId("artAppHomePageList", pageQuery);
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
   }

   @Resource
   private ArtAppHomePageDao artAppHomePageDao;

   public void setArtAppHomePageDao(ArtAppHomePageDao artAppHomePageDao) {
      this.artAppHomePageDao = artAppHomePageDao;
   }
}
