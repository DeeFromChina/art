package com.golead.common.service.login.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.golead.art.app.appUser.dao.ArtAppUserDao;
import com.golead.art.app.appUser.model.ArtAppUser;
import com.golead.common.dao.SysDeptDao;
import com.golead.common.dao.SysOrgDao;
import com.golead.common.dao.SysPropertyDao;
import com.golead.common.dao.SysResourceDao;
import com.golead.common.dao.SysUserDao;
import com.golead.common.model.SysDept;
import com.golead.common.model.SysOrg;
import com.golead.common.model.SysProperty;
import com.golead.common.model.SysUser;
import com.golead.common.service.login.LoginService;
import com.golead.core.dao.JdbcDao;
import com.golead.core.exception.DAOException;
import com.golead.core.exception.ServiceException;
import com.golead.core.util.Const;
import com.golead.core.util.Encryption;
import com.golead.core.web.UserSession;

@Service
public class LoginServiceImpl implements LoginService {

   public static String   VERIFIED   = "0";
   public static String   NEEDVERIFY = "1";

   @Resource
   private SysUserDao     sysUserDao;
   @Resource
   private SysOrgDao      sysOrgDao;
   @Resource
   private SysDeptDao     sysDeptDao;
   @Resource
   private SysResourceDao sysResourceDao;
   @Resource
   private SysPropertyDao sysPropertyDao;

   @Resource
   private JdbcDao        jdbcDao;
   
   @Resource
   private ArtAppUserDao  artAppUserDao;

   @Override
   public UserSession login(String accountName, String password) throws ServiceException {
      if (accountName == null) throw new ServiceException("系统错误。");
      UserSession session = null;
      try {
         session = checkAccount(accountName, password);
         getPrivileges(session);
         getProperties(session);
         return session;
      } catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      } catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      } catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   @Override
   public UserSession appLogin(String accountName, String password) throws ServiceException {
      if (accountName == null) throw new ServiceException("系统错误。");
      UserSession session = null;
      try {
         session = checkAppAccount(accountName, password);
         return session;
      } catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      } catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      } catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }

   }

   private UserSession checkAppAccount(String accountName, String password) throws ServiceException {
      UserSession session = null;
      List<ArtAppUser> users = artAppUserDao.findByField(ArtAppUser.PROP_ACCOUNT_NAME, accountName);
      if (users == null || users.size() == 0) throw new ServiceException("用户帐号或密码错误。");
      if (users.size() > 1) throw new ServiceException("系统错误。");

      ArtAppUser user = users.get(0);
      if (!Const.LOGIN_ACTIVE.equals(user.getUserStatus())) throw new ServiceException("用户已被停用，请与系统管理员联系。");
      String str = Encryption.encrypt(password.getBytes());
      if (!str.equals(user.getPassword())) throw new ServiceException("用户帐号或密码有误。");

      session = new UserSession();
      session.setUserId(user.getId().toString());
      session.setAccountName(user.getAccountName());
      session.setUserName(user.getUserName());
      session.setLoginTime(new Date());
      return session;
   }

   private UserSession checkAccount(String accountName, String password) throws ServiceException {
      UserSession session = null;
      List<SysUser> users = sysUserDao.findByField(SysUser.PROP_USER_ACCOUNT, accountName);
      if (users == null || users.size() == 0) throw new ServiceException("用户帐号或密码错误。");
      if (users.size() > 1) throw new ServiceException("系统错误。");

      SysUser user = users.get(0);
      if (!Const.LOGIN_ACTIVE.equals(user.getUserStatus())) throw new ServiceException("用户已被停用，请与系统管理员联系。");
      if (user.getOrgId() == null) throw new ServiceException("找不到用户所在单位，请与系统管理员联系。");
      if (user.getDeptId() == null) throw new ServiceException("找不到用户所在部门，请与系统管理员联系。");
      String str = Encryption.encrypt(password.getBytes());
      if (!str.equals(user.getUserPassword())) throw new ServiceException("用户帐号或密码有误。");

      session = new UserSession();
      session.setUserId(user.getId().toString());
      session.setAccountName(user.getUserAccount());
      session.setUserName(user.getUserName());
      session.setLoginTime(new Date());
      session.setOrgId(user.getOrgId().toString());
      session.setDeptId(user.getDeptId().toString());

      SysOrg sysOrg = sysOrgDao.get(user.getOrgId());
      session.setOrgCode(sysOrg.getOrgCode());
      session.setOrgName(sysOrg.getOrgName());
      session.setOrgShortName(sysOrg.getOrgAbbr());

      SysDept sysDept = sysDeptDao.get(user.getDeptId());
      if (sysDept != null) {
         session.setDeptCode(sysDept.getDeptCode());
         session.setDeptName(sysDept.getDeptName());
         session.setDeptShortName(sysDept.getDeptAbbr());
      }

      List<Map<String, Object>> roles = jdbcDao.queryBySqlId("getUserRoles", user.getId());
      for (int i = 0; i < roles.size(); i++) {
         session.getRoles().put(new Integer(roles.get(i).get("roleId").toString()), roles.get(i).get("roleName").toString());
      }
      return session;
   }

   private void getPrivileges(UserSession session) throws ServiceException {
      Map<String, String> privileges = session.getPrivileges();

      Iterator<Integer> it = session.getRoles().keySet().iterator();
      if (it == null) return;
      while (it.hasNext()) {
         Integer key = it.next();
         List<Map<String, Object>> rights = jdbcDao.queryBySqlId("getRoleRights", key);
         if (rights != null) {
            for (Map<String, Object> right : rights) {
               if (!privileges.containsKey(right.get("resCode").toString())) {
                  privileges.put(right.get("resCode").toString(), right.get("resName").toString());
               }
            }
         }
      }

      Integer uid = new Integer(session.getUserId());
      List<Map<String, Object>> rights = jdbcDao.queryBySqlId("getUserRights", uid);
      if (rights != null) {
         for (Map<String, Object> right : rights) {
            if (!privileges.containsKey(right.get("resCode").toString())) {
               privileges.put(right.get("resCode").toString(), right.get("resName").toString());
            }
         }
      }

   }

   private void getProperties(UserSession session) throws ServiceException {
      Map<String, String> properties = session.getProperties();
      Integer uid = new Integer(session.getUserId());
      List<Map<String, Object>> pros = jdbcDao.queryBySqlId("getUserProperty", uid);
      if (pros != null) {
         for (Map<String, Object> pro : pros) {
            if (!properties.containsKey(pro.get("propertyKey").toString())) {
               properties.put(pro.get("propertykey").toString(), pro.get("propertyvalue") == null ? "" : pro.get("propertyvalue").toString());
            }
         }
      }
   }

   public SysDeptDao getSysDeptDao() {
      return sysDeptDao;
   }

   public void setSysDeptDao(SysDeptDao sysDeptDao) {
      this.sysDeptDao = sysDeptDao;
   }

   public SysUserDao getSysUserDao() {
      return sysUserDao;
   }

   public void setSysUserDao(SysUserDao sysUserDao) {
      this.sysUserDao = sysUserDao;
   }

   public SysResourceDao getSysResourceDao() {
      return sysResourceDao;
   }

   public void setSysResourceDao(SysResourceDao sysResourceDao) {
      this.sysResourceDao = sysResourceDao;
   }

   public SysOrgDao getSysOrgDao() {
      return sysOrgDao;
   }

   public void setSysOrgDao(SysOrgDao sysOrgDao) {
      this.sysOrgDao = sysOrgDao;
   }

   public JdbcDao getJdbcDao() {
      return jdbcDao;
   }

   public void setJdbcDao(JdbcDao jdbcDao) {
      this.jdbcDao = jdbcDao;
   }

   public SysPropertyDao getSysPropertyDao() {
      return sysPropertyDao;
   }

   public void setSysPropertyDao(SysPropertyDao sysPropertyDao) {
      this.sysPropertyDao = sysPropertyDao;
   }

   @Override
   public void changeProperty(Integer id, String key, String value) throws ServiceException {
      String[] fieldNames = { SysProperty.PROP_USER_ID, SysProperty.PROP_PROPERTY_KEY };
      Object[] fieldValues = { id, key };
      List<SysProperty> sysProperties = sysPropertyDao.findByFields(fieldNames, fieldValues);
      SysProperty sysProperty;
      if (sysProperties.size() != 0) {
         sysProperty = sysProperties.get(0);
         sysProperty.setPropertyValue(value);
      }
      else {
         sysProperty = new SysProperty();
         sysProperty.setUserId(id);
         sysProperty.setPropertyKey(key);
         sysProperty.setPropertyValue(value);
      }
      sysPropertyDao.saveOrUpdate(sysProperty);
   }
}
