package com.golead.common.service.system;

import java.io.Serializable;
import java.util.List;

import com.golead.common.model.SysDept;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;

public interface SysDeptService {
	public SysDept findSysDept(Serializable id) throws ServiceException;

	public PageQuery querySysDept(PageQuery pageQuery) throws ServiceException;
	
	public List<SysDept> findSysDepts(Serializable orgId) throws ServiceException;
	
	public List<SysDept> findAllDept()throws ServiceException;
	
	public List<SysDept> findSysDeptByDeptCode(String code) throws ServiceException;
}
