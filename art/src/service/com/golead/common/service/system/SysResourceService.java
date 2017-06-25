package com.golead.common.service.system;

import java.io.Serializable;
import java.util.List;

import com.golead.common.model.SysResource;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;

public interface SysResourceService {

   public SysResource findSysResource(Serializable id) throws ServiceException;

   public void createSysResource(SysResource sysResource) throws ServiceException;

   public void updateSysResource(SysResource sysResource) throws ServiceException;

   public void removeSysResource(Serializable id) throws ServiceException;

   public PageQuery querySysResource(PageQuery pageQuery) throws ServiceException;

   public void removeSysResources(Serializable[] ids) throws ServiceException;

   public List<SysResource> findAll() throws ServiceException;

   public boolean needCheck(String url) throws ServiceException;
   
   public List<SysResource> findResources() throws ServiceException;
   

}