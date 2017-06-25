package com.golead.art.works.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.DAOException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;
import com.golead.art.works.dao.ArtSysLogDao;
import com.golead.art.works.model.ArtSysLog;
import com.golead.art.works.service.ArtSysLogService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class ArtSysLogServiceImpl extends BaseServiceImpl implements ArtSysLogService {
   private static final long serialVersionUID = 1L;

   public ArtSysLog getArtSysLog(Serializable id) throws ServiceException {
      try {
         return artSysLogDao.get(id);
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

   public void createArtSysLog(ArtSysLog artSysLog) throws ServiceException {
      try {
         artSysLogDao.save(artSysLog);
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

   public void createArtSysLog(String operator, String operModule, String operFunction, String operResult) throws ServiceException {
      try {
         ArtSysLog artSysLog = new ArtSysLog();
         artSysLog.setOperator(operator);
         artSysLog.setOperDate(new Date());
         artSysLog.setOperFunction(operFunction);
         artSysLog.setOperModule(operModule);
         artSysLog.setOperResult(operResult);
         artSysLogDao.save(artSysLog);
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

   public void updateArtSysLog(Map<String, String> artSysLogMap) throws ServiceException {
      try {
         Integer pkId = new Integer(artSysLogMap.get(ArtSysLog.PROP_ID));
         ArtSysLog tmp = artSysLogDao.get(pkId);
         ConvertUtil.mapToObject(tmp, artSysLogMap, true);
         artSysLogDao.update(tmp);
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

   public void deleteArtSysLog(Serializable id) throws ServiceException {
      try {
         artSysLogDao.delete(id);
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

   public void deleteArtSysLogs(Serializable[] ids) throws ServiceException {
      try {
         artSysLogDao.deleteAll(ids);
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
   public void deleteArtSysLogs(String beginTime, String endTime) throws ServiceException {
      try {
         List<ArtSysLog> byHql = artSysLogDao.findByHql("FROM ArtSysLog asl WHERE asl.operDate > '" + beginTime + "' AND asl.operDate < '" + endTime+"'");
         artSysLogDao.deleteAll(byHql);
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

   public PageQuery queryArtSysLog(PageQuery pageQuery) throws ServiceException {
      try {
         createSqlFilter(pageQuery);
         return jdbcDao.queryBySqlId("artSysLogList", pageQuery);
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

      String operator = parameters.get("operator");

      if (operator != null && !"".equals(operator)) {
         if (tmp.length() > 0) tmp.append(" AND ");
         tmp.append(" asl.operator LIKE ").append("'%").append(operator).append("%'");
      }

      String operModule = parameters.get("operModule");
      if (operModule != null && !"".equals(operModule)) {
         if (tmp.length() > 0) tmp.append(" AND ");
         tmp.append(" asl.oper_module LIKE ").append("'%").append(operModule).append("%'");
      }

      if (tmp.length() > 0) parameters.put("paras", tmp.toString());
   }

   @Resource
   private ArtSysLogDao artSysLogDao;

   public void setArtSysLogDao(ArtSysLogDao artSysLogDao) {
      this.artSysLogDao = artSysLogDao;
   }
}
