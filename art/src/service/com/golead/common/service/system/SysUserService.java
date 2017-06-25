package com.golead.common.service.system;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.common.model.SysResource;
import com.golead.common.model.SysRole;
import com.golead.common.model.SysUser;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;

public interface SysUserService {
	public static String SYSUSER = "1";

	public SysUser getUser(Serializable id) throws ServiceException;

	public void createUser(SysUser sysUser, String roleIds) throws ServiceException;

	public void updateUser(Map<String, String> user) throws ServiceException;

	public void deleteUsers(Serializable[] ids) throws ServiceException;

	public List<SysUser> findAllUser() throws ServiceException;

	public PageQuery queryUser(PageQuery page) throws ServiceException;

	// 启用一批帐号
	public void startUsers(Serializable[] ids) throws ServiceException;

	// 暂停一批帐号
	public void stopUsers(Serializable[] ids) throws ServiceException;

	// 保存密码
	public void saveUserPwd(Serializable id, String pwd) throws ServiceException;

	// 保存密码
	public void saveMyPwd(Serializable id, String oldPwd, String pwd) throws ServiceException;

	// 保存权限
	public void saveUserRights(Serializable id, String rights) throws ServiceException;

	// 查询用户角色
	public List<SysRole> findUserRoles(Serializable id) throws ServiceException;

	// 查询用户权限
	public List<SysResource> findUserResources(Serializable id) throws ServiceException;

	// 用户排序号
	public int maxOrder() throws ServiceException;
	
	// 根据角色和部门Id查询用户信息
	public List<Map<String, Object>> findUserByRolesAndDeptId(Map<String, String> map) throws ServiceException;
	
   public void saveUserProperty(Integer id,Map<String, String> map) throws ServiceException;

   public Map<String,String> getUserProperty(Integer id) throws ServiceException;

   public String findUserNameById(Object obj);
}
