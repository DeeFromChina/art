package com.golead.common.service.system;

import java.io.Serializable;
import java.util.Collection;

import com.golead.common.model.SysCodeset;
import com.golead.core.exception.ServiceException;

public interface SysCodesetService {
	/**
	 * 用PK查找对象
	 */
	public SysCodeset findSysCodeset(Serializable id) throws ServiceException;

	/**
	 * 用Unique Key查找对象
	 */
	public SysCodeset findSysCodesetByUK(String ukField, Object ukValue) throws ServiceException;

	/**
	 * 新增对象
	 * 
	 * @param
	 */
	public void createSysCodeset(SysCodeset sysCodeset) throws ServiceException;

	/**
	 * 更新对象
	 * 
	 * @param
	 */
	public void updateSysCodeset(SysCodeset sysCodeset) throws ServiceException;

	/**
	 * 删除对象
	 * 
	 * @param clazz
	 *           model class to lookup
	 * @param id
	 *           the identifier (primary key) of the class
	 */
	public void removeSysCodeset(Serializable id) throws ServiceException;

	/**
	 * 批删除对象
	 * 
	 * @param id
	 *           the identifier (primary key) of the class
	 */
	public void removeSysCodesets(Serializable[] ids) throws ServiceException;

	/**
	 * @param fieldName
	 *           字段名
	 * @param fieldValue
	 *           字段值,这里必须传入字段相应的类型,如Long不能用String
	 */
	public void removeSysCodesetByField(String fieldName, Object fieldValue) throws ServiceException;

	/**
	 * @return 返回全部表对象 Collection<SysCodeset>
	 * @throws Exception
	 */
	public Collection<SysCodeset> findAllSysCodeset() throws ServiceException;

	/**
	 * @param fieldName
	 *           字段名
	 * @param fieldValue
	 *           字段值,这里必须传入字段相应的类型,如Long不能用String
	 */
	public Collection<SysCodeset> findSysCodesetByField(String fieldName, Object fieldValue) throws ServiceException;

	/**
	 * 计算记录数
	 * 
	 * @param fieldName
	 *           字段名
	 * @param fieldValue
	 *           字段值,这里必须传入字段相应的类型,如Long不能用String
	 * @return
	 */
	public int countSysCodesetByField(String fieldName, Object fieldValue) throws ServiceException;
	/**
	 * 分页动态查询
	 * 
	 * @param queryObject
	 *           (queryObject.getResult()<Map(fieldName, fieldValue)>)
	 * @return
	 */
	// public PagerObject querySysCodeset(QueryString queryString,PagerObject
	// queryObject) throws ServiceException ;

}
