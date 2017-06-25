package com.golead.common.service.system.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.golead.common.dao.SysResourceDao;
import com.golead.common.model.SysResource;
import com.golead.common.service.system.SysResourceService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.DAOException;
import com.golead.core.exception.ServiceException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;
@Service
public class SysResourceServiceImpl extends BaseServiceImpl implements SysResourceService {
	private static final long	serialVersionUID	= 1L;

	
	@Override
   public SysResource findSysResource(Serializable id) throws ServiceException {
		try {
			return sysResourceDao.get(id);
		}
		catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	
	@Override
   public void createSysResource(SysResource sysResource) throws ServiceException {
		try {
			sysResourceDao.save(sysResource);
		}
		catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	
	@Override
   public void updateSysResource(SysResource sysResource) throws ServiceException {
		try {
			SysResource tmp = sysResourceDao.get(sysResource.getId());
			ConvertUtil.convertToModelForUpdate(tmp, sysResource);
			sysResourceDao.update(tmp);
		}
		catch (DAOException e) {
			throw new ServiceException(e);
		}
		catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	
	@Override
   public void removeSysResource(Serializable id) throws ServiceException {
		try {
			sysResourceDao.delete(id);
		}
		catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	
	@Override
   public void removeSysResources(Serializable[] ids) throws ServiceException {
		try {
			sysResourceDao.deleteAll(ids);
		}
		catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	
	@Override
   public PageQuery querySysResource(PageQuery pageQuery) throws ServiceException {
		try {
			PageQuery query =null;// sysResourceDao.queryBySelectId(pageQuery);
			pageQuery.setRecordSet(query.getRecordSet());
			pageQuery.setRecordCount(query.getRecordCount());
			return pageQuery;
		}
		catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	
	@Override
   public List<SysResource> findAll() throws ServiceException {
		try {
			return sysResourceDao.findAll(SysResource.PROP_PARENT_ID, true);
		}
		catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	
	
	@Override
   public List<SysResource> findResources() throws ServiceException {
		try {
			try {
				String hql = "select t from SysResource as t where t.parentId != 0";
				List<SysResource> list = sysResourceDao.findByHql(hql);
				return list;
			} catch (DAOException de) {
				throw new ServiceException("数据库操作错误。");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServiceException("系统错误。");
			}
		}
		catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	
	@Override
   public boolean needCheck(String url) throws ServiceException {
		if (url == null) return false;
		
		List<SysResource> list = sysResourceDao.findByField(SysResource.PROP_ACTION_URL, url);
		if (list != null && list.size() > 0) return true;
		else return false;
	}
	

   @Resource
	private SysResourceDao	sysResourceDao;

	/**
	 * 注入DAO
	 * 
	 * @see com.thunisoft.core.service.SysResourceService#setSysResourceDao(SysResource
	 *      sysResourceDao)
	 */
	public void setSysResourceDao(SysResourceDao sysResourceDao) {
		this.sysResourceDao = sysResourceDao;
	}
}