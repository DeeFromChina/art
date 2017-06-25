package com.golead.art.auction.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;
import com.golead.art.auction.dao.ArtAuctionExchangeDao;
import com.golead.art.auction.model.ArtAuctionExchange;
import com.golead.art.auction.service.ArtAuctionExchangeService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class ArtAuctionExchangeServiceImpl extends BaseServiceImpl implements ArtAuctionExchangeService {
   private static final long serialVersionUID = 1L;

   public ArtAuctionExchange getArtAuctionExchange(Serializable id) throws ServiceException {
      try {
         return artAuctionExchangeDao.get(id);
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

   public void createArtAuctionExchange(ArtAuctionExchange artAuctionExchange) throws ServiceException {
      try {
         List<ArtAuctionExchange> exchanges = artAuctionExchangeDao.findByField(ArtAuctionExchange.PROP_YEAR, artAuctionExchange.getYear());
         if (exchanges != null && exchanges.size() > 0) { throw new ServiceException("年份名:[" + artAuctionExchange.getYear() + "]已经存在，不能添加。"); }
         artAuctionExchangeDao.save(artAuctionExchange);
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

   public void updateArtAuctionExchange(Map<String, String> artAuctionExchangeMap) throws ServiceException {
      try {
         Integer pkId = new Integer(artAuctionExchangeMap.get(ArtAuctionExchange.PROP_ID));
         ArtAuctionExchange tmp = artAuctionExchangeDao.get(pkId);
         ConvertUtil.mapToObject(tmp, artAuctionExchangeMap, true);
         artAuctionExchangeDao.update(tmp);
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

   public void deleteArtAuctionExchange(Serializable id) throws ServiceException {
      try {
         artAuctionExchangeDao.delete(id);
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

   public void deleteArtAuctionExchanges(Serializable[] ids) throws ServiceException {
      try {
         artAuctionExchangeDao.deleteAll(ids);
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

   public PageQuery queryArtAuctionExchange(PageQuery pageQuery) throws ServiceException {
      try {
         createSqlFilter(pageQuery);
         return jdbcDao.queryBySqlId("artAuctionExchangeList", pageQuery);
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
      String str = map.get("year");
      if (str != null && !"".equals(str)) {
         tmp = "t.year = " + str;
      }
      if (tmp.length() > 0) map.put("paras", tmp);
   }

   @Resource
   private ArtAuctionExchangeDao artAuctionExchangeDao;

   public void setArtAuctionExchangeDao(ArtAuctionExchangeDao artAuctionExchangeDao) {
      this.artAuctionExchangeDao = artAuctionExchangeDao;
   }
}
