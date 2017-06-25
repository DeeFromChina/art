package com.golead.art.works.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;

import com.golead.art.works.dao.ArtPublicationArtistDao;
import com.golead.art.works.model.ArtPublicationArtist;
import com.golead.art.works.service.ArtPublicationArtistService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ArtPublicationArtistServiceImpl extends BaseServiceImpl implements ArtPublicationArtistService {
   private static final long serialVersionUID = 1L;

   public ArtPublicationArtist getArtPublicationArtist(Serializable id) throws ServiceException {
      try {
         return artPublicationArtistDao.get(id);
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

   public void createArtPublicationArtist(ArtPublicationArtist artPublicationArtist) throws ServiceException {
      try {
         artPublicationArtistDao.save(artPublicationArtist);
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

   public void createArtPublicationArtist(List<ArtPublicationArtist> artPublicationArtist) throws ServiceException {
      try {
         artPublicationArtistDao.saveOrUpdateAll(artPublicationArtist);
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

   public void updateArtPublicationArtist(Map<String, String> artPublicationArtistMap) throws ServiceException {
      try {
         Integer pkId = new Integer(artPublicationArtistMap.get(ArtPublicationArtist.PROP_ID));
         ArtPublicationArtist tmp = artPublicationArtistDao.get(pkId);
         ConvertUtil.mapToObject(tmp, artPublicationArtistMap, true);
         artPublicationArtistDao.update(tmp);
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

   public void deleteArtPublicationArtist(Serializable id) throws ServiceException {
      try {
         artPublicationArtistDao.delete(id);
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

   public void deleteArtPublicationArtists(Serializable[] ids) throws ServiceException {
      try {
         artPublicationArtistDao.deleteAll(ids);
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

   public PageQuery queryArtPublicationArtist(PageQuery pageQuery) throws ServiceException {
      try {
         createSqlFilter(pageQuery);
         return jdbcDao.queryBySqlId("artPublicationArtistList", pageQuery);
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

   public PageQuery queryArtist(PageQuery pageQuery) throws ServiceException {
      try {
         createSqlFilter(pageQuery);
         return jdbcDao.queryBySqlId("artPublicationArtistList2", pageQuery);
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
      Map<String, String> parameters = page.getParameters();
      String publicationId = parameters.get("publicationId");

      if (publicationId != null && !"".equals(publicationId)) {
         if (tmp.length() > 0) tmp.append(" AND ");
         tmp.append(" apa.pub_id = ").append(publicationId);
      }

      if (tmp.length() > 0) parameters.put("paras", tmp.toString());
   }

   @Resource
   private ArtPublicationArtistDao artPublicationArtistDao;

   public void setArtPublicationArtistDao(ArtPublicationArtistDao artPublicationArtistDao) {
      this.artPublicationArtistDao = artPublicationArtistDao;
   }
}
