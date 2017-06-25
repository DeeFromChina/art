package com.golead.common.web.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.golead.common.model.SysResource;
import com.golead.common.model.SysRole;
import com.golead.common.model.SysUser;
import com.golead.common.service.system.SysResourceService;
import com.golead.common.service.system.SysRoleService;
import com.golead.common.service.system.SysUserService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.WebException;
import com.golead.core.util.ConvertUtil;
import com.golead.core.web.action.BaseAction;
import com.golead.core.web.form.QueryForm;

public class SysRoleAction extends BaseAction {

   private static final long   serialVersionUID = 1L;

   private static Log          log              = LogFactory.getLog(SysRoleAction.class);

   private static final String START            = "START";

   private static final String STOP             = "STOP";

   private static final String CHECKROLE        = "CHECKROLE";

   private static final String RIGHTS           = "RIGHTS";                              // 分配权限

   private static final String SAVERIGHTS       = "SAVERIGHTS";                          // 保存权限

   private static final String GETRIGHTS        = "GETRIGHTS";                           // 取得权限树

   @Override
   public String doExecute() throws Exception {

      String action = form.getAction();
      if (action == null) action = "LIST";
      if (log.isDebugEnabled()) log.debug("action:" + action);
      String forward = null;
      try {
         if (LIST.equalsIgnoreCase(action)) forward = searchRole(); // 打开查询列表页面
         else if (PAGE.equalsIgnoreCase(action)) forward = pageRole(); // 查询分页数据
         else if (ADD.equalsIgnoreCase(action)) forward = addRole(); // 打开增加页面
         else if (SAVE.equalsIgnoreCase(action)) forward = saveRole(); // 保存增加数据
         else if (EDIT.equalsIgnoreCase(action)) forward = editRole(); // 打开修改页面
         else if (UPDATE.equalsIgnoreCase(action)) forward = updateRole();// 保存修改数据
         else if (VIEW.equalsIgnoreCase(action)) forward = viewRole();
         else if (DELETE.equalsIgnoreCase(action)) forward = deleteRole();// 删除
         else if (START.equalsIgnoreCase(action)) forward = startRole(); // 启动角色
         else if (STOP.equalsIgnoreCase(action)) forward = stopRole(); // 暂停角色
         else if (RIGHTS.equalsIgnoreCase(action)) forward = rights(); // 打开分配权限页面
         else if (SAVERIGHTS.equalsIgnoreCase(action)) forward = saveRights();// 保存打开分配权限
         else if (CHECKROLE.equalsIgnoreCase(action)) forward = checkRole();
         else if ("SELECTROLES".equalsIgnoreCase(action)) forward = getRoles();// 取得角色
         else {
            request.put("err", new WebException("找不到该action方法：" + action));
            forward = ERROR;// 找不到合适的action
         }
      }
      catch (Exception e) {
         request.put("errMsg", e);
         forward = ERROR;
      }
      return forward;
   }

   public String searchRole() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'searchRole' method");
      initForm(form);
      PageQuery pageQuery = form.getQuery();
      pageQuery.setPageSize("20");
      return LIST;
   }

   public String pageRole() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'pageRole' method");
      try {
         PageQuery pageQuery = form.getQuery() == null ? new PageQuery() : form.getQuery();
         initForm(form);
         pageQuery = sysRoleService.querySysRole(pageQuery);
         if (pageQuery != null) {
            List<Map<String, Object>> rs = pageQuery.getRecordSet();
            if (rs != null) {
               List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
               for (int i = 0; i < rs.size(); i++) {
                  Map<String, Object> role = rs.get(i);
                  String roleStatus = findCodeName(form, "START_OR_STOP", role.get("status") == null ? null : role.get("status").toString());
                  Map<String, Object> map = new HashMap<String, Object>();
                  map.put("id", role.get("id"));
                  String link = "^javascript:view(" + role.get("id") + ")^_self";
                  String remark=role.get("remark")==null?"":role.get("remark").toString();
                  map.put("data", new Object[] {"", role.get("code"), role.get("rolename")+link, remark, roleStatus });
                  list.add(map);
               }
               String res = genGridJson(pageQuery, list);
               setResponse(res);
            }
            else setResponse("{exit:1,message:\"数据访问错误。\"}");
         }
         else setResponse("{exit:1,message:\"数据访问错误。\"}");
      }
      catch (ServiceException e) {
         setResponse("{exit:1,message:\"" + e.getMessage() + "\"}");
      }
      catch (Exception e) {
         e.printStackTrace();
         setResponse("{exit:1,message:\"数据访问错误。\"}");
      }
      return null;
   }

   public String getRoles() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'getRoles' method");
      try {
         List<SysRole> listrole = sysRoleService.findAllRole();
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         for (SysRole role : listrole) {
            Map<String, Object> map = new HashMap<String, Object>();
            ConvertUtil.objectToMap(map, role);
            if ((";" + ids).indexOf(";" + map.get("id") + ";") > -1) map.put("CHECKED", "checked");
            else map.put("CHECKED", "");
            list.add(map);
         }
         form.getQuery().setRecordSet(list);
         return "SELECTROLES";
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         return ERROR;
      }
   }

   public String addRole() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'addRole' method");
      String forward = null;
      try {
         initForm(form);
         return ADD;
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e);
         forward = ERROR;
      }
      return forward;
   }

   public String saveRole() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'saveRole' method");
      try {
         SysRole role = new SysRole();
         role.setRoleStatus("1");
         ConvertUtil.mapToObject(role, form.getRecord(), false);
         sysRoleService.createRole(role);
         return returnForward(RETURN_NORMAL);
      }
      catch (ServiceException e) {
         addMessage(form, e.getMessage());
         initForm(form);
         return ADD;
      }
      catch (Exception ex) {
         ex.printStackTrace();
         addMessage(form, "保存操作失败!");
         initForm(form);
         return ADD;
      }
   }

   public String editRole() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'editRole' method");
      String forward = null;
      try {
         int id = Integer.valueOf(ids);
         SysRole sysRole = sysRoleService.getRole(id);
         ConvertUtil.objectToMap(form.getRecord(), sysRole);
         initForm(form);
         forward = EDIT;
      }
      catch (ServiceException e) {
         request.put("errMsg", e);
         forward = "ERROR";
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("err", e);
         forward = "ERROR";
      }
      return forward;
   }

   public String updateRole() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'updateRole' method");
      String forward = null;
      try {
         SysRole sysRole = new SysRole();
         int id = Integer.valueOf(form.getRecord().get("id"));
         sysRole.setId(id);
         ConvertUtil.mapToObject(sysRole, form.getRecord(), false);
         sysRoleService.updateRole(sysRole);
         return returnForward(RETURN_NORMAL);
      }
      catch (ServiceException e) {
         addMessage(form, e.getMessage());
         initForm(form);
         forward = EDIT;
      }
      catch (Exception e) {
         e.printStackTrace();
         addMessage(form, "保存操作失败。");
         initForm(form);
         forward = EDIT;
      }
      return forward;
   }

   public String deleteRole() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'deleteRole' method");
      try {
         String[] id = ids.split(",");
         Integer[] del_ids = new Integer[id.length];
         for (int i = 0; i < id.length; i++) {
            del_ids[i] = Integer.parseInt(id[i]);
         }
         sysRoleService.deleteRoles(del_ids);
         setResponse("{exit:0}");
      }
      catch (ServiceException e) {
         setResponse("{exit:1,message:\"" + e.getMessage() + "\"}");
      }
      catch (Exception e) {
         setResponse("{exit:1,message:\"删除操作失败!\"}");
      }
      return null;
   }

   public String rights() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'rightsUser' method");
      form.getRecord().put("id", ids);

      try {
         PageQuery pageQuery = form.getQuery();
         sysResources = (List<SysResource>) sysResourceService.findAll();

         rights = sysRoleService.findRoleRights(new Integer(ids));

         return "RIGHTS";
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         return ERROR;
      }
   }

   public String saveRights() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'saveRights' method");
      String forward = null;
      try {
         String id = form.getRecord().get("id");
         String rights = form.getRecord().get("rights");
         sysRoleService.saveRights(new Integer(id), rights);
         return returnForward(RETURN_NORMAL);
      }
      catch (Exception e) {
         e.printStackTrace();
         addMessage(form, "保存操作失败。");
         forward = "RIGHTS";
      }
      return forward;

   }

   public String viewRole() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'viewRole' method");
      String forward = null;
      try {
         int roleId = new Integer(ids);
         SysRole role = sysRoleService.getRole(roleId);
         String roleStatus = findCodeName(form, "START_STOP", role.getRoleStatus());
         role.setRoleStatus(roleStatus);
         ConvertUtil.objectToMap(form.getRecord(), role);
         sysResources = sysRoleService.searchRoleRights(role.getId());
         sysUsers = sysRoleService.findRoleUsers(role.getId());
         initForm(form);
         forward = "VIEW";
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("err", e);
         forward = "ERROR";
      }
      return forward;
   }

   public String startRole() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'startRole' method");
      try {
         sysRoleService.startRoles(parseId(ids.split(",")));
         setResponse("{exit:0}");
      }
      catch (ServiceException e) {
         setResponse("{exit:1,message:\"" + e.getMessage() + "\"}");
      }
      catch (Exception e) {
         setResponse("{exit:1,message:\"启用操作失败!\"}");
      }
      return null;
   }

   public String stopRole() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'stopRole' method");
      try {
         sysRoleService.stopRoles(parseId(ids.split(",")));
         setResponse("{exit:0}");
      }
      catch (ServiceException e) {
         setResponse("{exit:1,message:\"" + e.getMessage() + "\"}");
      }
      catch (Exception e) {
         setResponse("{exit:1,message:\"暂停操作失败!\"}");
      }
      return null;
   }

   public String checkRole() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'checkRole' method");
      HttpServletResponse response = ServletActionContext.getResponse();
      try {
         SysRole role = sysRoleService.getRole(new Integer(ids));

         //         if (SysRoleService.SYSROLE.equals(role.getRoleType())) response.getWriter().write("Y");
         //         else {
         response.getWriter().write("N");
         //         }
      }
      catch (Exception e) {
         e.printStackTrace();
         response.getWriter().write("ERROR");
      }
      response.getWriter().close();
      return null;

   }

   private java.io.Serializable[] parseId(String[] ids) throws Exception {
      if (ids == null || ids.length == 0) { throw new Exception("非法进入编辑页。"); }
      Serializable id[] = null;
      try {
         id = new Integer[ids.length];
         for (int i = 0; i < id.length; i++) {
            id[i] = new Integer(ids[i]);
         }
      }
      catch (Exception e) {
         id = ids;
      }
      return id;
   }

   private void initForm(QueryForm queryForm) {
      String action = form.getAction();
      setCode(queryForm, "START_OR_STOP");
      queryForm.getRecord().put("roleStatusName", findCodeName(queryForm, "START_OR_STOP", queryForm.getRecord().get("roleStatus")));
      if (ADD.equalsIgnoreCase(action)) {
         queryForm.getRecord().put(SysRole.PROP_ROLE_STATUS, "1");

      }

   }

   private String gridInfo;

   public String getGridInfo() {
      return gridInfo;
   }

   private String ids;

   public String getIds() {
      return ids;
   }

   public void setIds(String ids) {
      this.ids = ids;
   }

   private List rights;

   public List getRights() {
      return rights;
   }

   private List users;

   public List getUsers() {
      return users;
   }

   public void setUsers(List users) {
      this.users = users;
   }

   public void setRights(List rights) {
      this.rights = rights;
   }

   /**
    * 注入service
    */

   @Resource
   private SysResourceService sysResourceService;

   @Resource
   private SysRoleService     sysRoleService;

   @Resource
   private SysUserService     sysUserService;

   private List<SysResource>  sysResources;

   private List<SysUser>      sysUsers;

   public List<SysUser> getSysUsers() {
      return sysUsers;
   }

   public void setSysUsers(List<SysUser> sysUsers) {
      this.sysUsers = sysUsers;
   }

   public List<SysResource> getSysResources() {
      return sysResources;
   }

   public void setSysResources(List<SysResource> sysResources) {
      this.sysResources = sysResources;
   }

}
