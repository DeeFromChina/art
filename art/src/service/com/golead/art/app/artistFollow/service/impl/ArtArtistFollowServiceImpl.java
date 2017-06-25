package com.golead.art.app.artistFollow.service.impl;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.golead.art.app.artistFollow.dao.ArtArtistFollowDao;
import com.golead.art.app.artistFollow.model.ArtArtistFollow;
import com.golead.art.app.artistFollow.service.ArtArtistFollowService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.DAOException;
import com.golead.core.exception.ServiceException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;

@Service
public class ArtArtistFollowServiceImpl extends BaseServiceImpl implements ArtArtistFollowService {
   private static final long serialVersionUID = 1L;

   public ArtArtistFollow getArtArtistFollow(Serializable id) throws ServiceException {
      try {
         return artArtistFollowDao.get(id);
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

   public void createArtArtistFollow(ArtArtistFollow artArtistFollow) throws ServiceException {
      try {
         artArtistFollowDao.save(artArtistFollow);
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

   public void updateArtArtistFollow(Map<String, String> artArtistFollowMap) throws ServiceException {
      try {
         Integer pkId = new Integer(artArtistFollowMap.get(ArtArtistFollow.PROP_ID));
         ArtArtistFollow tmp = artArtistFollowDao.get(pkId);
         ConvertUtil.mapToObject(tmp, artArtistFollowMap, true);
         artArtistFollowDao.update(tmp);
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

   public void deleteArtArtistFollow(Serializable id) throws ServiceException {
      try {
         artArtistFollowDao.delete(id);
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

   public void deleteArtArtistFollows(Serializable[] ids) throws ServiceException {
      try {
         artArtistFollowDao.deleteAll(ids);
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

   public PageQuery queryArtArtistFollow(PageQuery pageQuery) throws ServiceException {
      try {
         createSqlFilter(pageQuery);
         return jdbcDao.queryBySqlId("artArtistFollowList", pageQuery);
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

      String year = parameters.get("YEAR");
      if (year != null && !"".equals(year)) {
         if (tmp.length() > 0) tmp.append(" AND ");
         tmp.append(" YEAR(aaf.follow_time) = ").append(year);
      }

      String month = parameters.get("MONTH");
      if (month != null && !"".equals(month)) {
         if (tmp.length() > 0) tmp.append(" AND ");
         tmp.append(" MONTH(aaf.follow_time) = ").append(month);
      }

      String accountName = parameters.get("accountName");
      if (accountName != null && !"".equals(accountName)) {
         if (tmp.length() > 0) tmp.append(" AND ");
         tmp.append(" apu.account_name LIKE ").append("'%").append(accountName).append("%'");
      }

      String artistName = parameters.get("artistName");
      if (artistName != null && !"".equals(artistName)) {
         if (tmp.length() > 0) tmp.append(" AND ");
         tmp.append(" aa.c_name LIKE ").append("'%").append(artistName).append("%'").append(" OR ").append(" aa.e_name LIKE ").append("'%").append(artistName)
               .append("%'");
      }

      if (tmp.length() > 0) parameters.put("paras", tmp.toString());
   }

   @Resource
   private ArtArtistFollowDao artArtistFollowDao;

   public void setArtArtistFollowDao(ArtArtistFollowDao artArtistFollowDao) {
      this.artArtistFollowDao = artArtistFollowDao;
   }
}
