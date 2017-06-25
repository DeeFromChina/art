package com.golead.common.service.system;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.golead.core.exception.ServiceException;
import com.golead.core.dao.model.PageQuery;

import com.golead.common.model.SysProperty;

public interface SysPropertyService {

	public SysProperty getSysProperty(Serializable id) throws ServiceException;

	public void createSysProperty(SysProperty sysProperty) throws ServiceException;

	public void updateSysProperty(Map<String, String> sysPropertyMap) throws ServiceException;

	public void deleteSysProperty(Serializable id) throws ServiceException;

	public PageQuery querySysProperty(PageQuery pageQuery) throws ServiceException;

	public void deleteSysPropertys(Serializable[] ids) throws ServiceException;  
	
	 public List<SysProperty> findSysProperty(int userId,String key) throws ServiceException;
	 
	 public void saveProperties(Integer id, String key,String value) throws ServiceException;
	 
}

