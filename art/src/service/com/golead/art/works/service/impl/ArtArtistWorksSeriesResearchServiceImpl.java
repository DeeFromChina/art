package com.golead.art.works.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;

import com.golead.art.works.dao.ArtArtistWorksSeriesResearchDao;
import com.golead.art.works.model.ArtArtistWorksSeriesResearch;
import com.golead.art.works.service.ArtArtistWorksSeriesResearchService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ArtArtistWorksSeriesResearchServiceImpl extends BaseServiceImpl implements ArtArtistWorksSeriesResearchService {
   private static final long serialVersionUID = 1L;

   public ArtArtistWorksSeriesResearch getArtArtistWorksSeriesResearch(Serializable id) throws ServiceException {
      try {
         return artArtistWorksSeriesResearchDao.get(id);
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

   public void createArtArtistWorksSeriesResearch(ArtArtistWorksSeriesResearch artArtistWorksSeriesResearch) throws ServiceException {
      try {
         artArtistWorksSeriesResearchDao.save(artArtistWorksSeriesResearch);
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
   public void createArtArtistWorksSeriesResearch(List<ArtArtistWorksSeriesResearch> artArtistWorksSeriesResearch) throws ServiceException {
      try {
         artArtistWorksSeriesResearchDao.saveOrUpdateAll(artArtistWorksSeriesResearch);
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

   public void updateArtArtistWorksSeriesResearch(Map<String, String> artArtistWorksSeriesResearchMap) throws ServiceException {
      try {
         Integer pkId = new Integer(artArtistWorksSeriesResearchMap.get(ArtArtistWorksSeriesResearch.PROP_ID));
         ArtArtistWorksSeriesResearch tmp = artArtistWorksSeriesResearchDao.get(pkId);
         ConvertUtil.mapToObject(tmp, artArtistWorksSeriesResearchMap, true);
         artArtistWorksSeriesResearchDao.update(tmp);
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

   public void deleteArtArtistWorksSeriesResearch(Serializable id) throws ServiceException {
      try {
         artArtistWorksSeriesResearchDao.delete(id);
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

   public void deleteArtArtistWorksSeriesResearchs(Serializable[] ids) throws ServiceException {
      try {
         artArtistWorksSeriesResearchDao.deleteAll(ids);
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

   public PageQuery queryArtArtistWorksSeriesResearch(PageQuery pageQuery) throws ServiceException {
      try {
         createSqlFilter(pageQuery);
         return jdbcDao.queryBySqlId("artArtistWorksSeriesResearchList", pageQuery);
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

      String artistId = parameters.get("artistId");

      if (artistId != null && !artistId.isEmpty()) {
         if (tmp.length() > 0) tmp.append(" AND ");
         tmp.append(" aw.artist_id = ").append(artistId);
      }

      String worksCName = parameters.get("worksCName");
      if (worksCName != null && !worksCName.isEmpty()) {
          if (tmp.length() > 0) tmp.append(" AND ");
          tmp.append(" aw.works_c_name LIKE ").append("'%").append(worksCName).append("%'");
      }

      String seriesId = parameters.get("seriesId");
      if (seriesId != null && !seriesId.isEmpty()) {
         if (tmp.length() > 0) tmp.append(" AND ");
         tmp.append(" aawsr.series_id = ").append(seriesId);
      }

      if (tmp.length() > 0) parameters.put("paras", tmp.toString());
   }

   @Resource
   private ArtArtistWorksSeriesResearchDao artArtistWorksSeriesResearchDao;

   public void setArtArtistWorksSeriesResearchDao(ArtArtistWorksSeriesResearchDao artArtistWorksSeriesResearchDao) {
      this.artArtistWorksSeriesResearchDao = artArtistWorksSeriesResearchDao;
   }
}
