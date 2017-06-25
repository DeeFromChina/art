package com.golead.common.service.system;

import java.io.Serializable;
import java.util.List;

import com.golead.common.model.SysCode;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;

public interface SysCodeService {

   public SysCode findSysCode(Serializable id) throws ServiceException;

   public void createSysCode(SysCode sysCode) throws ServiceException;

   public void updateSysCode(SysCode sysCode) throws ServiceException;

   public void removeSysCode(Serializable id) throws ServiceException;

   public PageQuery querySysCode(PageQuery pageQuery) throws ServiceException;

   public void removeSysCodes(Serializable[] ids) throws ServiceException;

   public PageQuery getSysCodesetsForTree(PageQuery pagequery) throws ServiceException;

   public List<SysCode> findCodeBySetId(Integer codeSetId) throws ServiceException;

   public List<SysCode> findTreeCodes(Integer codeSetId) throws ServiceException;

   public List<SysCode> findCodes(String codeSetName) throws ServiceException;

   public List<SysCode> findAll() throws ServiceException;
   
   public SysCode findCodeByName(String name) throws ServiceException;
	
	public SysCode findYear(String year) throws ServiceException;
	
	public SysCode findOils(String oils) throws ServiceException;
	
   public String findCodeByItemValue(String valus,int csId);
}
