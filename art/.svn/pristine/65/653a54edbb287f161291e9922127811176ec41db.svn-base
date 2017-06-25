package com.golead.common.service.system;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.golead.common.model.SysDept;
import com.golead.common.model.SysOrg;
import com.golead.core.exception.ServiceException;

public interface SysOrgService {
   public static String SYSORG = "1";

   public SysOrg findSysOrg(Serializable id) throws ServiceException;

   public void createSysOrg(SysOrg sysOrg) throws ServiceException;

   public void updateSysOrg(SysOrg sysOrg) throws ServiceException;

   public void removeSysOrg(Serializable id) throws ServiceException;

   public void removeSysOrgs(Serializable[] ids) throws ServiceException;

   public SysDept findSysDept(Serializable id) throws ServiceException;

   public void createSysDept(SysDept sysDept) throws ServiceException;

   public void updateSysDept(SysDept sysDept) throws ServiceException;

   public void removeSysDept(Serializable id) throws ServiceException;

   public List<SysDept> findSysDepts(Serializable orgId) throws ServiceException;

   // 查询所有的单位
   public List<SysOrg> findSysOrgAll() throws ServiceException;

   public List<SysOrg> findChildOrgs(Serializable orgId) throws ServiceException;

   public List<SysDept> findChildDeptsByOrgId(Serializable orgId) throws ServiceException;

   public List<SysDept> findChildDeptsByDeptId(Serializable deptId) throws ServiceException;

   public List<SysOrg> findTopOrgs() throws ServiceException;

   public List<SysOrg> findChildOrgs() throws ServiceException;

   public SysOrg getSysOrgByName(String name) throws ServiceException;

   public SysOrg getSysOrgByAbbr(String name) throws ServiceException;

   public List<SysOrg> findsSysOrgsWithoutOrgIdOne() throws ServiceException;

   public SysOrg getSysOrgByCode(String code) throws ServiceException;

   public String findOrgNameByCode(Object code);

   public List<SysOrg> listCompany() throws ServiceException;

   public boolean isParentCompany(Integer orgId) throws ServiceException;

   public List<SysOrg> findChildOrgs(Serializable orgId, String orgType) throws ServiceException;

   public List<SysOrg> findChildOrgs(Serializable orgId, Map<String, String> parameters) throws ServiceException;
}
