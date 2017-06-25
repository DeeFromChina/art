package com.golead.art.publication.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;

import com.golead.art.publication.dao.ArtPublicationWorksDao;
import com.golead.art.publication.model.ArtPublicationWorks;
import com.golead.art.publication.service.ArtPublicationWorksService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ArtPublicationWorksServiceImpl extends BaseServiceImpl implements ArtPublicationWorksService {
   private static final long serialVersionUID = 1L;

   public ArtPublicationWorks getArtPublicationWorks(Serializable id) throws ServiceException {
      try {
         return artPublicationWorksDao.get(id);
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

   public void createArtPublicationWorks(ArtPublicationWorks artPublicationWorks) throws ServiceException {
      try {
         artPublicationWorksDao.save(artPublicationWorks);
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

   public void createArtPublicationWorks(int[] ids, int pubId) throws ServiceException {
      try {
         for (int i = 0; i < ids.length; i++) {
            ArtPublicationWorks artPublicationWorks = new ArtPublicationWorks();
            artPublicationWorks.setPubId(pubId);
            artPublicationWorks.setWorksId(ids[i]);
            artPublicationWorksDao.save(artPublicationWorks);
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

   public void updateArtPublicationWorks(Map<String, String> artPublicationWorksMap) throws ServiceException {
      try {
         Integer pkId = new Integer(artPublicationWorksMap.get(ArtPublicationWorks.PROP_ID));
         ArtPublicationWorks tmp = artPublicationWorksDao.get(pkId);
         ConvertUtil.mapToObject(tmp, artPublicationWorksMap, true);
         artPublicationWorksDao.update(tmp);
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

   public void deleteArtPublicationWorks(Serializable id) throws ServiceException {
      try {
         artPublicationWorksDao.delete(id);
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

   public void deleteArtPublicationWorkss(Serializable[] ids) throws ServiceException {
      try {
         artPublicationWorksDao.deleteAll(ids);
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

   public PageQuery queryArtPublicationWorks(PageQuery pageQuery) throws ServiceException {
      try {
         createSqlFilter(pageQuery);
         return jdbcDao.queryBySqlId("artPublicationWorksList", pageQuery);
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
      String str = map.get("pubId");
      if (str != null && !"".equals(str.trim())) {
         tmp += "p.pub_id =" + str.trim();
      }
      str = map.get("worksName");
      if (str != null && !"".equals(str.trim())) {
         if (tmp.length() > 0) tmp += " and ";
         tmp += " ( w.works_c_name like '%" + str.trim() + "%' or  w.works_e_name like '%" + str.trim() + "%' )";
      }
      if (tmp.length() > 0) map.put("paras", tmp);
   }

   @Resource
   private ArtPublicationWorksDao artPublicationWorksDao;

   public void setArtPublicationWorksDao(ArtPublicationWorksDao artPublicationWorksDao) {
      this.artPublicationWorksDao = artPublicationWorksDao;
   }
}
