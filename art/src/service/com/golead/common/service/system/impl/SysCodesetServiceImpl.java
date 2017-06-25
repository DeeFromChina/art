package com.golead.common.service.system.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.golead.common.dao.SysCodeDao;
import com.golead.common.dao.SysCodesetDao;
import com.golead.common.model.SysCodeset;
import com.golead.common.service.system.SysCodesetService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
@Service
public class SysCodesetServiceImpl implements SysCodesetService {
   @Resource
	private SysCodesetDao	sysCodesetDao;
   @Resource
	private SysCodeDao	sysCodeDao;

	public void setSysCodesetDao(SysCodesetDao sysCodesetDao) {
		this.sysCodesetDao = sysCodesetDao;
	}

	@Override
   public SysCodeset findSysCodeset(Serializable id) throws ServiceException {
		try {
			return sysCodesetDao.get(id);
		}
		catch (Exception e) {

			throw new ServiceException(e);
		}
	}

	/**
	 * 用Unique Key查找对象
	 */
	@Override
   public SysCodeset findSysCodesetByUK(String ukField, Object ukValue) throws ServiceException {
		try {
			Collection<SysCodeset> c = findSysCodesetByField(ukField, ukValue);
			if (c != null && !c.isEmpty()) { return c.iterator().next(); }
			return null;
		}
		catch (Exception e) {

			throw new ServiceException(e);
		}
	}

	@Override
   public void createSysCodeset(SysCodeset sysCodeset) throws ServiceException {
		try {
			sysCodesetDao.save(sysCodeset);
		}
		catch (Exception e) {

			throw new ServiceException(e);
		}
	}

	@Override
   public void updateSysCodeset(SysCodeset sysCodeset) throws ServiceException {
		try {
			sysCodesetDao.update(sysCodeset);
		}
		catch (Exception e) {

			throw new ServiceException(e);
		}
	}


	@Override
   public void removeSysCodeset(Serializable id) throws ServiceException {
		try {
			sysCodesetDao.delete(id);
		}
		catch (Exception e) {

			throw new ServiceException(e);
		}
	}

	/**
	 * 批删除对象
	 * 
	 * @param id
	 *           the identifier (primary key) of the class
	 */
	@Override
   public void removeSysCodesets(Serializable[] ids) throws ServiceException {
		try {
			for (int i = 0; i < ids.length; i++) {
				removeSysCodeset(ids[i]);
			}
		}
		catch (Exception e) {

			throw new ServiceException(e);
		}
	}

	/**
	 * 使用外健批删除从表记录
	 * 
	 * @param fieldName
	 *           字段名
	 * @param fieldValue
	 *           字段值,这里必须传入字段相应的类型,如Long不能用String
	 * @see com.thunisoft.core.service.SysCodesetService#removeSysCodesetByField(String
	 *      fieldName, Object fieldValue)
	 */
	@Override
   public void removeSysCodesetByField(String fieldName, Object fieldValue) throws ServiceException {
		try {
			sysCodesetDao.deleteByField(fieldName, fieldValue);
		}
		catch (Exception e) {

			throw new ServiceException(e);
		}
	}

	/**
	 * 使用外健获取从表记录
	 * 
	 * @param fieldName
	 *           字段名
	 * @param fieldValue
	 *           字段值,这里必须传入字段相应的类型,如Long不能用String
	 * @see com.thunisoft.core.service.SysCodesetService#findSysCodesetByField(String
	 *      fieldName, Object fieldValue)
	 */
	@Override
   public Collection<SysCodeset> findSysCodesetByField(String fieldName, Object fieldValue) throws ServiceException {
		try {
			return sysCodesetDao.findByField(fieldName, fieldValue);
		}
		catch (Exception e) {

			throw new ServiceException(e);
		}
	}

	/**
	 * 使用外健计算从表记录数
	 * 
	 * @param fieldName
	 *           字段名
	 * @param fieldValue
	 *           字段值,这里必须传入字段相应的类型,如Long不能用String
	 * @return
	 * @see com.thunisoft.core.service.SysCodesetService#countSysCodesetByField(String
	 *      fieldName, Object fieldValue)
	 */
	@Override
   public int countSysCodesetByField(String fieldName, Object fieldValue) throws ServiceException {
		try {
			return sysCodesetDao.countByField(fieldName, fieldValue);
		}
		catch (Exception e) {

			throw new ServiceException(e);
		}
	}

	/**
	 * @return 全部
	 * @throws Exception
	 */
	@Override
   public Collection<SysCodeset> findAllSysCodeset() throws ServiceException {
		try {
			return sysCodesetDao.findAll(SysCodeset.PROP_ID,true);
		}
		catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	public SysCodeDao getSysCodeDao() {
		return sysCodeDao;
	}

	public void setSysCodeDao(SysCodeDao sysCodeDao) {
		this.sysCodeDao = sysCodeDao;
	}

	public PageQuery getCodesetsForTree(PageQuery pagequery)
			throws ServiceException {
		return null;//sysCodesetDao.queryBySelectId(pagequery);
	}

	public PageQuery querySysCodeset(PageQuery pageQuery) throws ServiceException {
		try {
			PageQuery  query=null;//sysCodesetDao.queryBySelectId(pageQuery);
			pageQuery.setRecordSet(query.getRecordSet());
			pageQuery.setRecordCount(query.getRecordCount());
			return pageQuery;
		}
		catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
