package com.golead.common.service.system.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.golead.common.dao.SysDeptDao;
import com.golead.common.model.SysDept;
import com.golead.common.service.system.SysDeptService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.DAOException;
import com.golead.core.exception.ServiceException;
@Service
public class SysDeptServiceImpl implements SysDeptService {
	
	
	@Override
   public SysDept findSysDept(Serializable id) throws ServiceException {
		try {
			return sysDeptDao.get(id);
		}
		catch (DAOException e) {
			throw new ServiceException("查询数据库错误。");
		}
	}

	
	@Override
   public List<SysDept> findSysDepts(Serializable orgId) throws ServiceException {
		List<SysDept> list;
		try {
			list = sysDeptDao.findByField(SysDept.PROP_ORG_ID, new Integer(orgId.toString()));
		}
		catch (Exception e) {
			throw new ServiceException("查询数据库错误。");
		}
		return list;
	}

	
	@Override
   public PageQuery querySysDept(PageQuery pageQuery) throws ServiceException {
		try {
//			PageQuery query = sysDeptDao.queryBySelectId(pageQuery);
//			pageQuery.setRecordSet(query.getRecordSet());
//			pageQuery.setRecordCount(query.getRecordCount());
			return pageQuery;
		}
		catch (Exception e) {
			throw new ServiceException("查询数据库错误。");
		}
	}

	
	@Override
   public List<SysDept> findAllDept() throws ServiceException {
		try {
			return sysDeptDao.findAll();
		}
		catch (Exception e) {
			throw new ServiceException("查询数据库错误。");
		}
	}
	
	
	@Override
   public List<SysDept> findSysDeptByDeptCode(String code) throws ServiceException {
	      try {
	         return sysDeptDao.findByField(SysDept.PROP_DEPT_CODE, code);
	      } catch (Exception e) {
	         e.printStackTrace();
	         throw new ServiceException(e);
	      }
	   }
	
   @Resource
	private SysDeptDao	sysDeptDao;

	/**
	 * 注入DAO
	 * 
	 * @see com.thunisoft.core.service.SysDeptService#setSysDeptDao(SysDept
	 *      sysDeptDao)
	 */
	public void setSysDeptDao(SysDeptDao sysDeptDao) {
		this.sysDeptDao = sysDeptDao;
	}
}
