package com.golead.common.service.system.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.golead.common.dao.SysResourceDao;
import com.golead.common.dao.SysResourceRoleDao;
import com.golead.common.dao.SysRoleDao;
import com.golead.common.dao.SysUserDao;
import com.golead.common.dao.SysUserRoleDao;
import com.golead.common.model.SysResource;
import com.golead.common.model.SysResourceRole;
import com.golead.common.model.SysRole;
import com.golead.common.model.SysUser;
import com.golead.common.model.SysUserRole;
import com.golead.common.service.system.SysRoleService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.DAOException;
import com.golead.core.exception.ServiceException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;

@Service
public class SysRoleServiceImpl extends BaseServiceImpl implements SysRoleService {

   private static final long serialVersionUID = 1L;

   public static String      SYS_NOTVERIFY    = "1";

   public static String      SYS_OPER_DELETE  = "3";

   public static String      SYS_VERIFIED     = "0";

   public static String      SYS_OPER_NONE    = "";

   public static String      SYS_OPER_ADD     = "1";

   @Override
   public List<SysRole> findAllRole() throws ServiceException {
      try {
         return sysRoleDao.findAll();
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   @Override
   public SysRole getRole(Serializable id) throws ServiceException {
      try {
         return sysRoleDao.get(id);
      }
      catch (DAOException e) {
         throw new ServiceException(e);
      }
   }

   @Override
   public void createRole(SysRole sysRole) throws ServiceException {
      try {
         List<SysRole> list = sysRoleDao.findByField(SysRole.PROP_ROLE_NAME, sysRole.getRoleName());
         if (list != null && list.size() > 0) {
            throw new ServiceException("角色名[" + sysRole.getRoleName() + "]已经存在，不能使用");
         }
         sysRoleDao.save(sysRole);
      }
      catch (DAOException e) {
         throw new ServiceException(e);
      }
      catch (ServiceException ex) {
         ex.printStackTrace();
         throw ex;
      }
      catch (Exception exc) {
         exc.printStackTrace();
         throw new ServiceException("系统错误。");
      }

   }

   @Override
   public void updateRole(SysRole sysRole) throws ServiceException {
      try {
         List<SysRole> list = sysRoleDao.findByField(SysRole.PROP_ROLE_NAME, sysRole.getRoleName());
         if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
               SysRole role = list.get(i);
               if (sysRole.getId().intValue() != role.getId().intValue()) {
                  throw new ServiceException("角色名[" + sysRole.getRoleName() + "]存在重复，不能使用");
               }
            }
         }
         Integer roleId = sysRole.getId();
         SysRole tem = sysRoleDao.get(roleId);
         String status = tem.getRoleStatus();
         String uName = tem.getRoleName();

         ConvertUtil.convertToModelForUpdate(tem, sysRole);

         if (SYSROLE.equals(tem.getRoleType())) {
            tem.setRoleStatus(status);
            tem.setRoleName(uName);
         }
         sysRoleDao.update(tem);
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (ServiceException ex) {
         ex.printStackTrace();
         throw ex;
      }
      catch (Exception exc) {
         throw new ServiceException("系统错误。");
      }

   }

   @Override
   public void deleteRole(Serializable id) throws ServiceException {
      try {
         SysRole tem = sysRoleDao.get(id);
         if (SYSROLE.equals(tem.getRoleType())) {
            throw new ServiceException("该角色不能删除。");
         }
         sysRoleDao.delete(tem);

         sysUserRoleDao.deleteByField(SysUserRole.PROP_ROLE_ID, id);
         sysResourceRoleDao.deleteByField(SysResourceRole.PROP_ROLE_ID, id);
      }
      catch (DAOException de) {
         de.printStackTrace();
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
   public PageQuery querySysRole(PageQuery page) throws ServiceException {
      try {
         String sql = "select r.id as id,r.role_code as code,r.role_name as rolename,r.remark as remark,r.role_status as status from sys_role r";

         String fstr = createSqlFilter(page);
         if (fstr.length() > 0) sql += " where " + fstr;

         page.setQuerySql(sql);
         return jdbcDao.queryBySql(page);
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   private String createSqlFilter(PageQuery page) {
      StringBuffer buffer = new StringBuffer();
      Map<String, String> fields = page.getParameters();
      String str = fields.get("roleCode");
      if (str != null && !"".equals(str)) {
         if (str.contains("%")) buffer.append(" r.role_code like '" + str + "'");
         else buffer.append(" r.role_code  like '%" + str + "%'");
      }
      str = fields.get("roleName");
      if (str != null && !"".equals(str)) {
         if (buffer.length() > 0) buffer.append(" and ");
         buffer.append(" r.role_name  like '%" + str + "%'");
      }
      str = fields.get("roleStatus");
      if (str != null && !"".equals(str)) {
         if (buffer.length() > 0) buffer.append(" and ");
         buffer.append(" r.role_status =" + str);
      }
      return buffer.toString();
   }

   @Override
   public void deleteRoles(Serializable[] ids) throws ServiceException {
      try {
         for (int i = 0; i < ids.length; i++) {
            SysRole tmp = sysRoleDao.get(ids[i]);
            if (SYSROLE.equals(tmp.getRoleType())) {
               throw new ServiceException("系统角色不能删除。");
            }
            sysUserRoleDao.deleteByField(SysUserRole.PROP_ROLE_ID, tmp.getId());
            sysResourceRoleDao.deleteByField(SysResourceRole.PROP_ROLE_ID, tmp.getId());
         }
         sysRoleDao.deleteAll(ids);
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
   public void saveRights(Integer id, String rights) throws ServiceException {
      String tmp = "," + rights + ",";
      try {
         SysRole sysRole = sysRoleDao.get(id);
         if (sysRole == null) throw new ServiceException("该角色不存在");
         List<SysResourceRole> roleRights = sysResourceRoleDao.findByField(SysResourceRole.PROP_ROLE_ID, id);
         for (int i = 0; i < roleRights.size(); i++) {
            SysResourceRole srr = roleRights.get(i);
            if (tmp.indexOf("," + srr.getResId().toString() + ",") < 0) {
               sysResourceRoleDao.delete(srr);
            } else {
               tmp = tmp.replace("," + srr.getResId().toString() + ",", ",");// 放弃没有变化的权限
            }
         }
         String[] newRights = tmp.split(",");
         for (int i = 0; i < newRights.length; i++) {
            String r = newRights[i];
            if (r == null || r.equals("")) continue;
            SysResourceRole sru = new SysResourceRole();// 增加权限
            sru.setRoleId(id);
            sru.setStatus(SYS_VERIFIED);// 待审核//2011/4/6日已经改为“不需要审核”
            sru.setOper(SYS_OPER_ADD);// 设置增加操作
            sru.setResId(new Integer(r));
            sysResourceRoleDao.save(sru);
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

   @Override
   public void startRoles(Serializable[] ids) throws ServiceException {
      try {
         for (int i = 0; i < ids.length; i++) {
            SysRole tmp = sysRoleDao.get(ids[i]);
            if (tmp != null) {
               tmp.setRoleStatus("1");
               sysRoleDao.update(tmp);
            }
         }
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统出错。");
      }
   }

   @Override
   public void stopRoles(Serializable[] ids) throws ServiceException {
      try {
         for (int i = 0; i < ids.length; i++) {
            SysRole tmp = sysRoleDao.get(ids[i]);
            if (tmp != null && !SYSROLE.equals(tmp.getRoleType())) { // 系统固定的用户不能暂停。
               tmp.setRoleStatus("0");
               sysRoleDao.update(tmp);
            }
         }
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   /**
    * 注入DAO
    * 
    * @see com.thunisoft.core.service.SysRoleService#setSysRoleDao(SysRole
    *      sysRoleDao)
    */
   @Resource
   private SysRoleDao sysRoleDao;

   public void setSysRoleDao(SysRoleDao sysRoleDao) {
      this.sysRoleDao = sysRoleDao;
   }

   @Resource
   private SysResourceRoleDao sysResourceRoleDao;

   public void setSysResourceRoleDao(SysResourceRoleDao sysResourceRoleDao) {
      this.sysResourceRoleDao = sysResourceRoleDao;
   }

   @Resource
   private SysUserRoleDao sysUserRoleDao;

   public SysUserRoleDao getSysUserRoleDao() {
      return sysUserRoleDao;
   }

   public void setSysUserRoleDao(SysUserRoleDao sysUserRoleDao) {
      this.sysUserRoleDao = sysUserRoleDao;
   }

   public void setSysUserRoleDaoo(SysUserRoleDao sysUserRoleDao) {
      this.sysUserRoleDao = sysUserRoleDao;
   }

   @Resource
   private SysResourceDao sysResourceDao;

   public SysResourceDao getSysResourceDao() {
      return sysResourceDao;
   }

   public void setSysResourceDao(SysResourceDao sysResourceDao) {
      this.sysResourceDao = sysResourceDao;
   }

   @Resource
   private SysUserDao sysUserDao;

   public SysUserDao getSysUserDao() {
      return sysUserDao;
   }

   public void setSysUserDao(SysUserDao sysUserDao) {
      this.sysUserDao = sysUserDao;
   }

   @Override
   public List<SysResource> findRoleRights(Serializable id) throws ServiceException {
      List<Integer> list = new ArrayList<Integer>();
      try {
         List<SysResourceRole> srs = sysResourceRoleDao.findByField(SysResourceRole.PROP_ROLE_ID, id);
         for (SysResourceRole s : srs) {
            list.add(s.getResId());
         }
         return sysResourceDao.findAll(list.toArray(new Serializable[list.size()]));
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   @Override
   public List<SysResource> searchRoleRights(Serializable id) throws ServiceException {
      List<Integer> list = new ArrayList<Integer>();
      try {
         List<SysResourceRole> srs = sysResourceRoleDao.findByField(SysResourceRole.PROP_ROLE_ID, id);

         for (SysResourceRole se : srs) {
            SysResource res = sysResourceDao.get(se.getResId());
            if (res == null) continue;
            if (res.getParentId() != 0 && !list.contains(res.getParentId())) {
               list.add(res.getParentId());
            }
         }
         for (SysResourceRole s : srs) {
            SysResource re = sysResourceDao.get(s.getResId());
            if (re == null) continue;
            if (re.getParentId() == 0) continue;
            list.add(re.getId());

         }
         return sysResourceDao.findAll(list.toArray(new Serializable[list.size()]));
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   @Override
   public List<SysUser> findRoleUsers(Serializable id) throws ServiceException {
      List<Integer> list = new ArrayList<Integer>();
      try {
         List<SysUserRole> srs = sysUserRoleDao.findByField(SysUserRole.PROP_ROLE_ID, id);
         for (SysUserRole s : srs) {
            list.add(s.getUserId());
         }
         return sysUserDao.findAll(list.toArray(new Serializable[list.size()]));
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   // 130704 cgy 判断userSession中的角色集roles是否包含了指定代码的角色
   @Override
   public boolean hasRole(Map<Integer, String> roles, String roleCode) {
      boolean hasRole = false;
      PageQuery pq = new PageQuery();
      pq.getParameters().put(SysRole.PROP_ROLE_CODE, roleCode);
      querySysRole(pq);
      List<Map<String, Object>> list = pq.getRecordSet();
      if (list.size() == 1) {
         Object obj = list.get(0).get(SysRole.PROP_ID);
         String value = obj != null ? obj.toString() : "0";
         if (roles.containsKey(new Integer(value))) {
            hasRole = true;
         }
      }
      return hasRole;
   }

}
