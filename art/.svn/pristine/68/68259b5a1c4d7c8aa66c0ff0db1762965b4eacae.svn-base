package com.golead.common.service.system.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.golead.common.dao.SysDeptDao;
import com.golead.common.dao.SysOrgDao;
import com.golead.common.model.SysDept;
import com.golead.common.model.SysOrg;
import com.golead.common.service.system.SysOrgService;
import com.golead.core.exception.DAOException;
import com.golead.core.exception.ServiceException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;

@Service
public class SysOrgServiceImpl extends BaseServiceImpl implements SysOrgService {
   private static final long serialVersionUID = 1L;

   @Override
   public SysOrg findSysOrg(Serializable id) throws ServiceException {

      try {
         SysOrg tmp = sysOrgDao.get(id);
         return tmp;
      }
      catch (DAOException de) {
         de.printStackTrace();
         throw new ServiceException(de);
      }
   }

   @Override
   public void createSysOrg(SysOrg sysOrg) throws ServiceException {
      try {
         List<SysOrg> list = sysOrgDao.findByField(SysOrg.PROP_ORG_NAME, sysOrg.getOrgName());
         if (list != null && list.size() > 0) { throw new ServiceException("单位名:[" + sysOrg.getOrgName() + "]已经存在，不能使用。"); }

         list = sysOrgDao.findByField(SysOrg.PROP_ORG_CODE, sysOrg.getOrgCode());
         if (list != null && list.size() > 0) { throw new ServiceException("单位编号:[" + sysOrg.getOrgCode() + "]已经存在，不能使用。"); }

         Integer upId = sysOrg.getUpOrgId();
         if (upId == null) { throw new ServiceException("找不到该单位的上级单位，不能保存。"); }

         SysOrg upSysOrg = sysOrgDao.get(upId);
         if (upSysOrg == null) { throw new ServiceException("找不到该单位的上级单位，不能保存。"); }

         String sqlStr = "select max(" + SysOrg.COL_TREE_CODE + ") as tc from " + SysOrg.REF_TABLE + " where " + SysOrg.COL_TREE_CODE + " like '"
               + upSysOrg.getTreeCode() + "%'";
         List<Map<String, Object>> codeList = jdbcDao.queryBySql(sqlStr);
         if (codeList == null || codeList.size() == 0) { throw new ServiceException("找不到该单位的上级单位，不能保存。"); }

         String tcnew = "";
         String tc = codeList.get(0).get("tc").toString();
         if (tc.equalsIgnoreCase(upSysOrg.getTreeCode())) tcnew = tc + "001";
         else {
            String stmp = tc.substring(upSysOrg.getTreeCode().length());
            int mid = Integer.valueOf(stmp) + 1;
            stmp = "000" + mid;
            tcnew = upSysOrg.getTreeCode() + stmp.substring(stmp.length() - 3);
         }

         sysOrg.setTreeLevel(upSysOrg.getTreeLevel() + 1);
         sysOrg.setTreeCode(tcnew);
         sysOrgDao.save(sysOrg);
      }
      catch (DAOException de) {
         de.printStackTrace();
         throw new ServiceException(de);
      }
   }

   @Override
   public void updateSysOrg(SysOrg sysOrg) throws ServiceException {
      try {
         List<SysOrg> list = sysOrgDao.findByField(SysOrg.PROP_ORG_NAME, sysOrg.getOrgName());
         if (list != null) {
            for (int i = 0; i < list.size(); i++) {
               SysOrg org = list.get(i);
               if (sysOrg.getId().intValue() != org.getId().intValue()) { throw new ServiceException("单位名:[" + sysOrg.getOrgName() + "]存在重复，不能使用。"); }
            }
         }
         list = sysOrgDao.findByField(SysOrg.PROP_ORG_CODE, sysOrg.getOrgCode());
         if (list != null) {
            for (int i = 0; i < list.size(); i++) {
               SysOrg org = list.get(i);
               if (sysOrg.getId().intValue() != org.getId().intValue()) { throw new ServiceException("单位编号:[" + sysOrg.getOrgCode() + "]存在重复，不能使用。"); }
            }
         }

         SysOrg tmp = sysOrgDao.get(sysOrg.getId());
         ConvertUtil.convertToModelForUpdate(tmp, sysOrg);
         sysOrgDao.update(tmp);
      }
      catch (DAOException de) {
         de.printStackTrace();
         throw new ServiceException(de);
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException(e);
      }
   }

   @Override
   public void removeSysOrg(Serializable id) throws ServiceException {
      try {
         SysOrg tmp = sysOrgDao.get(id);
         if (tmp == null) return;
         if (SYSORG.equals(tmp.getOrgType())) { throw new ServiceException("该单位不能删除。");// 系统顶层单位不能删除。
         }

         sysDeptDao.deleteByField(SysDept.PROP_ORG_ID, tmp.getId());
         sysOrgDao.deleteByField(SysOrg.PROP_UP_ORG_ID, tmp.getId());// 级联删除尚未完成。
         sysOrgDao.delete(tmp.getId());
      }
      catch (DAOException de) {
         de.printStackTrace();
         throw new ServiceException(de);
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException(e);
      }
   }

   @Override
   public void removeSysOrgs(Serializable[] ids) throws ServiceException {
      return;
   }

   @Override
   public List<SysOrg> findSysOrgAll() throws ServiceException {
      try {
         List<SysOrg> list = sysOrgDao.findAll(SysOrg.PROP_ORDER_NO, true);
         return list;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException(e);
      }
   }

   @Override
   public SysDept findSysDept(Serializable id) throws ServiceException {
      try {
         return sysDeptDao.get(id);
      }
      catch (DAOException de) {
         de.printStackTrace();
         throw new ServiceException(de);
      }
   }

   @Override
   public List<SysOrg> findChildOrgs() throws ServiceException {
      try {
         return sysOrgDao.findByField(SysOrg.PROP_TREE_LEVEL, 2);
      }
      catch (DAOException de) {
         de.printStackTrace();
         throw new ServiceException(de);
      }

   }

   @Override
   public void createSysDept(SysDept sysDept) throws ServiceException {
      try {
         Integer orgId = sysDept.getOrgId();
         if (orgId == null) throw new ServiceException("找不到该部门所在单位。");

         List<SysDept> list = sysDeptDao.findByField(SysDept.PROP_DEPT_NAME, sysDept.getDeptName());
         if (list != null) {
            for (int i = 0; i < list.size(); i++) {
               SysDept dept = list.get(i);
               if (sysDept.getOrgId().intValue() == dept.getOrgId().intValue()) { throw new ServiceException("部门名:[" + sysDept.getDeptName() + "]存在重复，不能使用。"); }
            }
         }
         list = sysDeptDao.findByField(SysDept.PROP_DEPT_CODE, sysDept.getDeptCode());
         if (list != null) {
            for (int i = 0; i < list.size(); i++) {
               SysDept dept = list.get(i);
               if (sysDept.getOrgId().intValue() == dept.getOrgId().intValue()) { throw new ServiceException("部门编号:[" + sysDept.getDeptName() + "]存在重复，不能使用。"); }
            }
         }

         sysDeptDao.save(sysDept);
      }
      catch (DAOException de) {
         de.printStackTrace();
         throw new ServiceException(de);
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException(e);
      }
   }

   @Override
   public void updateSysDept(SysDept sysDept) throws ServiceException {
      try {
         Integer orgId = sysDept.getOrgId();
         if (orgId == null) throw new ServiceException("找不到该部门所在单位。");

         List<SysDept> list = sysDeptDao.findByField(SysDept.PROP_DEPT_NAME, sysDept.getDeptName());
         if (list != null) {
            for (int i = 0; i < list.size(); i++) {
               SysDept dept = list.get(i);
               if (sysDept.getId().intValue() != dept.getId().intValue() && sysDept.getOrgId().intValue() == dept.getOrgId().intValue()) { throw new ServiceException(
                     "部门名:[" + sysDept.getDeptName() + "]存在重复，不能使用。"); }
            }
         }
         list = sysDeptDao.findByField(SysDept.PROP_DEPT_CODE, sysDept.getDeptCode());
         if (list != null) {
            for (int i = 0; i < list.size(); i++) {
               SysDept dept = list.get(i);
               if (sysDept.getId().intValue() != dept.getId().intValue() && sysDept.getOrgId().intValue() == dept.getOrgId().intValue()) { throw new ServiceException(
                     "部门编号:[" + sysDept.getDeptName() + "]存在重复，不能使用。"); }
            }
         }

         SysDept tmp = sysDeptDao.get(sysDept.getId());
         ConvertUtil.convertToModelForUpdate(tmp, sysDept);
         sysDeptDao.update(tmp);
      }
      catch (DAOException de) {
         de.printStackTrace();
         throw new ServiceException(de);
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException(e);
      }
   }

   @Override
   public void removeSysDept(Serializable id) throws ServiceException {
      try {
         SysDept tmp = sysDeptDao.get(id);
         if (tmp == null) return;
         sysDeptDao.deleteByField(SysDept.PROP_UP_DEPT_ID, tmp.getId().toString());// 级联操作尚未实现。
         sysDeptDao.delete(id);
      }
      catch (DAOException de) {
         de.printStackTrace();
         throw new ServiceException(de);
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException(e);
      }
   }

   @Override
   public List<SysDept> findSysDepts(Serializable orgId) throws ServiceException {
      List<SysDept> list;
      try {
         list = sysDeptDao.findByField(SysDept.PROP_ORG_ID, new Integer(orgId.toString()), SysDept.PROP_ORDER_NO, true);
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException(e);
      }
      return list;
   }

   public List<SysDept> findSysDeptAll() throws ServiceException {
      try {
         List<SysDept> list = sysDeptDao.findAll();
         return list;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException(e);
      }
   }

   public List<SysOrg> findOrgs() throws ServiceException {
      return null;
   }

   @Override
   public List<SysOrg> findChildOrgs(Serializable orgId) throws ServiceException {
      if (orgId != null) return sysOrgDao.findByField(SysOrg.PROP_UP_ORG_ID, new Integer(orgId.toString()), SysOrg.PROP_ORDER_NO, true);
      else return sysOrgDao.findByField(SysOrg.PROP_UP_ORG_ID, null, SysOrg.PROP_ORDER_NO, true);
   }

   public List<SysOrg> findChildOrgs(Serializable orgId, String orgType) throws ServiceException {
      return sysOrgDao.findByFields(new String[] { SysOrg.PROP_UP_ORG_ID, SysOrg.PROP_ORG_TYPE }, new Object[] { Integer.valueOf(orgId.toString()), orgType },
            SysOrg.PROP_ORDER_NO, true);
   }
   
   @Override
   public List<SysOrg> findChildOrgs(Serializable orgId, Map<String, String> parameters) throws ServiceException {
	   StringBuffer hql = new StringBuffer();
	   hql.append("from " + SysOrg.REF_CLASS + " ");
	   
	   if(orgId != null) hql.append(" where " + SysOrg.PROP_UP_ORG_ID + "=" + orgId);
	   else hql.append(" where " + SysOrg.PROP_UP_ORG_ID + " is null ");
	   
	   if(parameters.get("catalog").equals("0")) hql.append(" and " + SysOrg.PROP_ORG_TYPE + " != '2' ");
	   else if(parameters.get("catalog").equals("1")) hql.append(" and " + SysOrg.PROP_ORG_TYPE + " = '2' ");
	   
	   hql.append(" order by " + SysOrg.PROP_ORDER_NO + " asc");
	   
	   return sysOrgDao.findByHql(hql.toString());
   }

   @Override
   public List<SysDept> findChildDeptsByOrgId(Serializable orgId) throws ServiceException {
      List<SysDept> list = findSysDepts(orgId);
      List<SysDept> res = new ArrayList<SysDept>();
      for (int i = 0; i < list.size(); i++) {
         SysDept tmp = list.get(i);
         if (tmp.getUpDeptId() == null || "".equals(tmp.getUpDeptId())) res.add(tmp);
      }
      return res;
   }

   @Override
   public List<SysDept> findChildDeptsByDeptId(Serializable deptId) throws ServiceException {
      return sysDeptDao.findByField(SysDept.PROP_UP_DEPT_ID, deptId);
   }

   @Override
   public List<SysOrg> findTopOrgs() throws ServiceException {
      try {
         String sqlStr = "select o.id as oid,o.org_name as orgName from sys_org o where o.up_org_id=1 or o.up_org_id is null";
         List<Map<String, Object>> list = jdbcDao.queryBySql(sqlStr);
         List<SysOrg> orgs = new ArrayList<SysOrg>();
         for (int i = 0; i < list.size(); i++) {
            SysOrg org = new SysOrg();
            BigDecimal oid = (BigDecimal) list.get(i).get("oid");
            String orgName = (String) list.get(i).get("orgName");
            if (oid != null) org.setId(oid.intValue());
            if (orgName != null) org.setOrgName(orgName);
            orgs.add(org);
         }
         return orgs;
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   @Resource
   private SysOrgDao  sysOrgDao;

   @Resource
   private SysDeptDao sysDeptDao;

   public void setSysOrgDao(SysOrgDao sysOrgDao) {
      this.sysOrgDao = sysOrgDao;
   }

   public SysDeptDao getSysDeptDao() {
      return sysDeptDao;
   }

   public void setSysDeptDao(SysDeptDao sysDeptDao) {
      this.sysDeptDao = sysDeptDao;
   }

   @Override
   public SysOrg getSysOrgByName(String name) throws ServiceException {
      try {
         List<SysOrg> sysOrgs = sysOrgDao.findByField(SysOrg.PROP_ORG_NAME, name);
         if (sysOrgs.size() > 0) return sysOrgs.get(0);
         return null;
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   @Override
   public SysOrg getSysOrgByAbbr(String name) throws ServiceException {
      try {
         List<SysOrg> sysOrgs = sysOrgDao.findByField(SysOrg.PROP_ORG_ABBR, name);
         if (sysOrgs.size() > 0) return sysOrgs.get(0);
         return null;
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   @Override
   public SysOrg getSysOrgByCode(String code) throws ServiceException {
      try {
         List<SysOrg> sysOrgs = sysOrgDao.findByField(SysOrg.PROP_ORG_CODE, code);
         if (sysOrgs.size() > 0) return sysOrgs.get(0);
         return null;
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   @Override
   public List<SysOrg> findsSysOrgsWithoutOrgIdOne() throws ServiceException {
      try {
         String sqlStr = "select o.id as oid,o.org_name as orgName from sys_org o where o.up_org_id=1";
         List<Map<String, Object>> list = jdbcDao.queryBySql(sqlStr);
         List<SysOrg> orgs = new ArrayList<SysOrg>();
         for (int i = 0; i < list.size(); i++) {
            SysOrg org = new SysOrg();
            Integer oid = (Integer) list.get(i).get("oid");
            String orgName = (String) list.get(i).get("orgName");
            if (oid != null) org.setId(oid.intValue());
            if (orgName != null) org.setOrgName(orgName);
            orgs.add(org);
         }
         return orgs;
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   @Override
   public String findOrgNameByCode(Object code) {
      if (code == null) return "";

      SysOrg org = this.getSysOrgByCode(String.valueOf(code));
      if (org == null) return "";

      return org.getOrgName();
   }

   @Override
   public List<SysOrg> listCompany() throws ServiceException {
      try {

         StringBuffer hql = new StringBuffer();
         hql.append("from " + SysOrg.REF_CLASS + " a ");
         hql.append("where a." + SysOrg.PROP_ORG_TYPE + " = '0' ");
         hql.append("and a." + SysOrg.PROP_UP_ORG_ID + " is not null ");
         hql.append(" order by a." + SysOrg.PROP_ORDER_NO + " asc ");
         return sysOrgDao.findByHql(hql.toString());

      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");

      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;

      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   @Override
   public boolean isParentCompany(Integer orgId) {
      try {

         SysOrg org = findSysOrg(orgId);
         if ("0".equals(org.getOrgType()) && org.getUpOrgId() == null) {
            return true;
         }
         else {
            return false;
         }

      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");

      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;

      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }

   }

}
