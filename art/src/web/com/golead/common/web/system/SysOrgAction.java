package com.golead.common.web.system;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;

import com.golead.common.model.SysDept;
import com.golead.common.model.SysOrg;
import com.golead.common.service.system.SysOrgService;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.WebException;
import com.golead.core.util.ConvertUtil;
import com.golead.core.web.action.BaseAction;
import com.golead.core.web.form.BaseForm;

public class SysOrgAction extends BaseAction {

   protected static final String RET_NORAML  = "{\"exit\":\"0\"}";

   protected static final int    OPER_FAILED = 1;

   protected int                 filteByUser = 0;
   protected int                 showDepts   = 1;

   private final Log             log         = LogFactory.getLog(SysOrg.class);

   @Override
   public String doExecute() throws Exception {
      String action = form.getAction();
      if (action == null) action = LIST;
      String forward;
      try {
         if (LIST.equalsIgnoreCase(action)) forward = search(); // 打开查询列表页面
         else if ("GETTREE".equalsIgnoreCase(action)) forward = getTreeNode(); // 打开树
         else if (ADD.equalsIgnoreCase(action)) forward = addOrg(); // 打开增加页面
         else if (SAVE.equalsIgnoreCase(action)) forward = saveOrg(); // 保存增加数据
         else if (EDIT.equalsIgnoreCase(action)) forward = editOrg(); // 打开修改页面
         else if (UPDATE.equalsIgnoreCase(action)) forward = updateOrg();// 保存修改数据
         else if (DELETE.equalsIgnoreCase(action)) forward = deleteOrg();// 删除
         else {
            request.put("err", new WebException("找不到该action方法：" + action));
            forward = "ERROR";// 找不到合适的action
         }
      }
      catch (Exception e) {// 其他系统出错
         request.put("err", e);
         forward = "ERROR";
      }
      return forward;
   }

   public String addOrg() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'addOrg' method");

      try {
         form.getRecord().put("upOrgId", pid);
         initForm(form, ADD);
         return "ADD";
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("err", e);
         return "ERROR";
      }
   }

   public String saveOrg() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'saveOrg' method");
      String forward = null;

      try {
         SysOrg sysOrg = new SysOrg();
         ConvertUtil.mapToObject(sysOrg, form.getRecord(), false);
         sysOrgService.createSysOrg(sysOrg);
         request.put("returnStatus", RETURN_NORMAL);
         forward = "MESSAGE";
      }
      catch (ServiceException e) {
         addMessage(form, e.getMessage());
         initForm(form, ADD);
         forward = ADD;
      }
      catch (Exception e) {
         e.printStackTrace();
         addMessage(form, "保存操作失败!");
         initForm(form, ADD);
         forward = ADD;
      }
      return forward;
   }

   public String editOrg() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'editOrg' method");

      try {
         SysOrg sysOrg = sysOrgService.findSysOrg(new Integer(id));
         ConvertUtil.objectToMap(form.getRecord(), sysOrg);
         initForm(form, EDIT);
         return "EDIT";
      }
      catch (ServiceException e) {
         request.put("errMsg", e.getMessage());
         return ERROR;
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("err", e);
         return "ERROR";
      }
   }

   private void initForm(BaseForm baseForm, String action) {
   }

   public String updateOrg() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'updateOrg' method");
      String forward = "";

      try {
         SysOrg sysOrg = sysOrgService.findSysOrg(new Integer(form.getRecord().get("id")));
         ConvertUtil.mapToObject(sysOrg, form.getRecord(), false);
         sysOrgService.updateSysOrg(sysOrg);
         request.put("returnStatus", RETURN_NORMAL);
         forward = "MESSAGE";
      }
      catch (Exception e) {
         addMessage(form, "保存操作失败!");
         initForm(form, EDIT);
         forward = "EDIT";
      }
      return forward;
   }

   public String deleteOrg() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'deleteOrg' method");
      HttpServletResponse response = (HttpServletResponse) ctx.get(StrutsStatics.HTTP_RESPONSE);
      response.setContentType("text/plain;charset=UTF-8");
      response.setHeader("Cache_Control", "no-cache");
      StringBuffer sb = new StringBuffer();
      try {
         if (id != null) {
            sysOrgService.removeSysOrg(new Integer(id));
         }
         sb.append(RET_NORAML);
      }
      catch (Exception e) {
         sb.append(JsonErrorMessage(OPER_FAILED, "单位删除失败！"));
      }
      response.getWriter().write(sb.toString());
      response.getWriter().close();
      return null;
   }

   public String search() throws Exception {
      return "LIST";
   }

   public String getTreeNode() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'getTree' method");
      HttpServletResponse response = (HttpServletResponse) ctx.get(StrutsStatics.HTTP_RESPONSE);
      response.setContentType("text/xml;charset=UTF-8");
      response.setHeader("Cache_Control", "no-cache");
      try {
         List orgs = null;
         List depts = null;
         if (id.indexOf("org") == 0) {
            orgs = sysOrgService.findChildOrgs(id.substring(3));
            if (this.showDepts == 1) depts = sysOrgService.findChildDeptsByOrgId(id.substring(3));
            response.getWriter().write(getNodes(orgs, depts, id));
         }
         else if (id.indexOf("dept") == 0) {
            if (this.showDepts == 1) depts = sysOrgService.findChildDeptsByDeptId(id.substring(4));
            response.getWriter().write(getNodes(null, depts, id));
         }
         else {
            if (this.filteByUser == 1) {
               orgs = new ArrayList<Object>();
               orgs.add(sysOrgService.findSysOrg(Integer.valueOf(currentUser.getOrgId())));
            }
            else {
               orgs = sysOrgService.findChildOrgs(null);
            }

            response.getWriter().write(getTopNodes(orgs));
         }
         response.getWriter().close();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   private String getTopNodes(List orgs) {
      StringBuffer sb = new StringBuffer("");
      sb.append("<?xml version='1.0' encoding='UTF-8' ?>");
      sb.append("<tree id=\"0\">");
      if (orgs != null) {
         for (int i = 0; i < orgs.size(); i++) {
            SysOrg so = (SysOrg) orgs.get(i);
            sb.append("<item id=\"org" + so.getId() + "\" text=\"" + so.getOrgName()
                  + "\" im0=\"../icon/house_big.gif\" im1=\"../icon/house_big.gif\" im2=\"../icon/house_big.gif\" child=\"1\" open=\"1\">");
            sb.append("<userdata name=\"name\">" + so.getOrgName() + "</userdata>");
            sb.append("<userdata name=\"type\">" + so.getOrgType() + "</userdata>");
            sb.append("<userdata name=\"parentId\">" + (so.getUpOrgId() == null ? "" : so.getUpOrgId()) + "</userdata>");
            sb.append("<userdata name=\"orgCode\">" + (so.getOrgCode() == null ? "" : so.getOrgCode()) + "</userdata>");
            sb.append("</item>");
         }
      }
      sb.append("</tree>");
      return sb.toString();
   }

   private String getNodes(List orgs, List depts, String id) {
      StringBuffer sb = new StringBuffer("");
      sb.append("<?xml version='1.0' encoding='UTF-8' ?>");
      sb.append("<tree id=\"" + id + "\">");
      if (orgs != null) {
         for (int i = 0; i < orgs.size(); i++) {
            SysOrg so = (SysOrg) orgs.get(i);
            sb.append("<item id=\"org" + so.getId() + "\" text=\"" + so.getOrgName()
                  + "\" im0=\"../icon/house_big.gif\" im1=\"../icon/house_big.gif\" im2=\"../icon/house_big.gif\" child=\"1\">");
            sb.append("<userdata name=\"name\">" + so.getOrgName() + "</userdata>");
            sb.append("<userdata name=\"type\">" + so.getOrgType() + "</userdata>");
            sb.append("<userdata name=\"orgCode\">" + (so.getOrgCode() == null ? "" : so.getOrgCode()) + "</userdata>");
            sb.append("<userdata name=\"parentId\">" + (so.getUpOrgId() == null ? "" : so.getUpOrgId()) + "</userdata>");
            sb.append("</item>");
         }
      }
      if (depts != null) {
         for (int i = 0; i < depts.size(); i++) {
            SysDept sp = (SysDept) depts.get(i);
            sb.append("<item id=\"dept" + sp.getId() + "\" text=\"" + sp.getDeptName()
                  + "\" im0=\"../icon/people.gif\" im1=\"../icon/people.gif\" im2=\"../icon/people.gif\" child=\"1\">");
            sb.append("<userdata name=\"name\">" + sp.getDeptName() + "</userdata>");
            sb.append("<userdata name=\"orgId\">" + (sp.getOrgId() == null ? "" : "org" + sp.getOrgId()) + "</userdata>");
            sb.append("<userdata name=\"parentId\">" + (sp.getUpDeptId() == null ? "" : "dept" + sp.getUpDeptId()) + "</userdata>");
            sb.append("<userdata name=\"deptCode\">" + (sp.getDeptCode() == null ? "" : sp.getDeptCode()) + "</userdata>");
            sb.append("</item>");
         }
      }
      sb.append("</tree>");
      return sb.toString();
   }

   protected String JsonErrorMessage(int errNo, String msg) {
      return "{\"exit\":\"" + errNo + "\",\"message\":\"" + msg + "\"}";
   }

   private String id;

   private String pid;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getPid() {
      return pid;
   }

   public void setPid(String pid) {
      this.pid = pid;
   }

   public int getFilteByUser() {
      return filteByUser;
   }

   public void setFilteByUser(int filteByUser) {
      this.filteByUser = filteByUser;
   }

   public int getShowDepts() {
      return showDepts;
   }

   public void setShowDepts(int showDepts) {
      this.showDepts = showDepts;
   }

   @Resource
   private SysOrgService sysOrgService;

}
