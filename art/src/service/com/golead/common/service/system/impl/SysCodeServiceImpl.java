package com.golead.common.service.system.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.golead.common.dao.SysCodeDao;
import com.golead.common.dao.SysCodesetDao;
import com.golead.common.model.SysCode;
import com.golead.common.model.SysCodeset;
import com.golead.common.service.system.SysCodeService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.DAOException;
import com.golead.core.exception.ServiceException;
import com.golead.core.util.ConvertUtil;
import com.golead.core.web.CommonService;


@Service
public class SysCodeServiceImpl implements SysCodeService {
   private static final long serialVersionUID = 1L;

   @Override
   public SysCode findSysCode(Serializable id) throws ServiceException {
      try {
         return sysCodeDao.get(id);
      }
      catch (DAOException e) {
         throw new ServiceException(e);
      }
   }

   @Override
   public void createSysCode(SysCode sysCode) throws ServiceException {
      try {
         List<SysCode> list = sysCodeDao.findByField(SysCode.PROP_CS_ID, sysCode.getCsId());

         if (list != null) {
            for (int i = 0; i < list.size(); i++) {
               SysCode tmp = list.get(i);
               if (tmp.getItemName().equalsIgnoreCase(sysCode.getItemName()) || tmp.getItemValue().equalsIgnoreCase(sysCode.getItemValue())) { throw new ServiceException(
                     "代码名称和代码值不能重复。"); }
            }
         }
         sysCodeDao.save(sysCode);
         SysCodeset sysCodeset = sysCodesetDao.get(sysCode.getCsId());
         commonService.remove(sysCodeset.getEnName());
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
   public void updateSysCode(SysCode sysCode) throws ServiceException {
      try {
         List<SysCode> list = sysCodeDao.findByField(SysCode.PROP_CS_ID, sysCode.getCsId());

         if (list != null) {
            for (int i = 0; i < list.size(); i++) {
               SysCode tmp = list.get(i);
               if (tmp.getId().intValue() != sysCode.getId().intValue()
                     && (tmp.getItemName().equalsIgnoreCase(sysCode.getItemName()) || tmp.getItemValue().equalsIgnoreCase(sysCode.getItemValue()))) { throw new ServiceException(
                     "代码名称和代码值不能重复。"); }
            }
         }
         SysCode tmp = sysCodeDao.get(sysCode.getId());
         ConvertUtil.convertToModelForUpdate(tmp, sysCode);
         sysCodeDao.update(tmp);
         SysCodeset sysCodeset = sysCodesetDao.get(sysCode.getCsId());
         commonService.remove(sysCodeset.getEnName());
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
   public void removeSysCode(Serializable id) throws ServiceException {
      try {
         SysCode sysCode = sysCodeDao.get(id);
         String ename = sysCodesetDao.get(sysCode.getCsId()).getEnName();
         sysCodeDao.delete(id);
         commonService.remove(ename);
      }
      catch (DAOException e) {
         throw new ServiceException(e);
      }
   }

   @Override
   public void removeSysCodes(Serializable[] ids) throws ServiceException {
      try {
         SysCode sysCode = sysCodeDao.get(ids[0]);
         String ename = sysCodesetDao.get(sysCode.getCsId()).getEnName();
         sysCodeDao.deleteAll(ids);
         commonService.remove(ename);
      }
      catch (Exception e) {
         throw new ServiceException(e);
      }
   }

   @Override
   public PageQuery querySysCode(PageQuery pageQuery) throws ServiceException {
      try {
         PageQuery query = null;// sysCodeDao.queryBySelectId(pageQuery);
         pageQuery.setRecordSet(query.getRecordSet());
         pageQuery.setRecordCount(query.getRecordCount());
         return pageQuery;
      }
      catch (Exception e) {
         throw new ServiceException(e);
      }
   }

   @Override
   public List<SysCode> findAll() throws ServiceException {
      try {
         return sysCodeDao.findAll();
      }
      catch (Exception e) {
         throw new ServiceException(e);
      }
   }

   @Override
   public List<SysCode> findCodeBySetId(Integer CsId) throws ServiceException {
      try {
         return sysCodeDao.findByField(SysCode.PROP_CS_ID, CsId, SysCode.PROP_ITEM_VALUE, true);
      }
      catch (Exception e) {
         throw new ServiceException(e);
      }
   }

   @Override
   public SysCode findCodeByName(String name) throws ServiceException{
      try {
         List<SysCode> codes = sysCodeDao.findByField(SysCode.PROP_ITEM_NAME, name);
         if(codes.size()>0)return codes.get(0);
         return null;
      }
      catch (Exception e) {
         throw new ServiceException(e);
      }
   }

   @Override
   public List<SysCode> findTreeCodes(Integer CsId) throws ServiceException {
      try {
         String[] fields = { SysCode.PROP_CS_ID };
         Object[] values = { CsId };
         String[] orders = { SysCode.PROP_TREE_LEVEL, SysCode.PROP_ITEM_VALUE };
         boolean[] decs = { true, true };
         return sysCodeDao.findByFields(fields, values, orders, decs);
      }
      catch (Exception e) {
         throw new ServiceException(e);
      }
   }

   @Resource
   private SysCodesetDao sysCodesetDao;

   @Resource
   private SysCodeDao    sysCodeDao;

   public void setSysCodeDao(SysCodeDao sysCodeDao) {
      this.sysCodeDao = sysCodeDao;
   }

   @Override
   public PageQuery getSysCodesetsForTree(PageQuery pagequery) throws ServiceException {
      return null;// sysCodesetDao.queryBySelectId(pagequery);
   }

   public void setSysCodesetDao(SysCodesetDao sysCodesetDao) {
      this.sysCodesetDao = sysCodesetDao;
   }

   @Override
   public List<SysCode> findCodes(String CodesetName) throws ServiceException {
      try {
         List<SysCodeset> Codesets = sysCodesetDao.findByField(SysCodeset.PROP_EN_NAME, CodesetName);
         List<SysCode> codes = sysCodeDao.findByField(SysCode.PROP_CS_ID, Codesets.get(0).getId(), SysCode.PROP_ITEM_VALUE, true);
         return codes;
      }
      catch (Exception e) {
         throw new ServiceException(e);
      }

   }

   @Resource
   private CommonService commonService;

   public CommonService getCommonService() {
      return commonService;
   }

   public void setCommonService(CommonService commonService) {
      this.commonService = commonService;
   }

   @Override
   public SysCode findYear(String year) throws ServiceException {
      try {
         List<SysCode> codes = sysCodeDao.findByField(SysCode.PROP_ITEM_NAME, year);
         if(codes.size()>0) return codes.get(0);
         return null;
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
   public SysCode findOils(String oils) throws ServiceException {
      try {
         List<SysCode> codes = sysCodeDao.findByField(SysCode.PROP_ITEM_NAME, oils);
         if(codes.size()>0) return codes.get(0);
         return null;
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
   public String findCodeByItemValue(String valus, int csId) {
      try{
         String[] as = new String[]{SysCode.PROP_CS_ID,SysCode.PROP_ITEM_VALUE};
         Object[] aobj = new Object[] {csId,valus};
         List<SysCode> list = sysCodeDao.findByFields(as, aobj);
         return list.get(0).getItemName();
      }
      catch (Exception e) {
         throw new ServiceException(e);
      }
   }
}