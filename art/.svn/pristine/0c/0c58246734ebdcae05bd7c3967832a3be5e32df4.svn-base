package com.golead.common.web.system;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.golead.common.model.SysDept;
import com.golead.common.service.system.SysDeptService;
import com.golead.common.service.system.SysOrgService;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.WebException;
import com.golead.core.util.ConvertUtil;
import com.golead.core.web.action.BaseAction;
import com.golead.core.web.form.BaseForm;

public class SysDeptAction extends BaseAction {

   protected static final String RET_NORAML  = "{\"exit\":\"0\"}";

   protected static final int    OPER_FAILED = 1;

   private final Log             log         = LogFactory.getLog(SysDept.class);

   @Override
   public String doExecute() throws Exception {
      String action = getForm().getAction();
      if (action == null) action = EDIT;
      if (log.isDebugEnabled()) log.debug("action:" + action);
      String forward;

      try {
         if (ADD.equalsIgnoreCase(action)) forward = addDept(); // 打开增加页面
         else if (SAVE.equalsIgnoreCase(action)) forward = saveDept(); // 保存增加数据
         else if (EDIT.equalsIgnoreCase(action)) forward = editDept(); // 打开修改页面
         else if (UPDATE.equalsIgnoreCase(action)) forward = updateDept();// 保存修改数据
         else if (DELETE.equalsIgnoreCase(action)) forward = deleteDept();// 删除
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

   public String addDept() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'addDept' method");
      try {
         getForm().getRecord().put("orgId", orgId);
         getForm().getRecord().put("upDeptId", (pid == null) ? "" : pid);
         initForm(getForm(), ADD);
         return "ADD";
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("err", e);
         return "ERROR";
      }
   }

   public String saveDept() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'saveDept' method");
      String forward = "";

      try {
         SysDept sysDept = new SysDept();
         ConvertUtil.mapToObject(sysDept, getForm().getRecord(), false);
         sysOrgService.createSysDept(sysDept);
         request.put("returnStatus", RETURN_NORMAL);
         forward = "MESSAGE";
      }
      catch (ServiceException e) {
         addMessage(getForm(), e.getMessage());
         initForm(getForm(), ADD);
         return "ADD";
      }
      catch (Exception e) {
         e.printStackTrace();
         addMessage(getForm(), "保存操作失败!");
         initForm(getForm(), ADD);
         forward = "ADD";
      }
      return forward;
   }

   public String editDept() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'editDept' method");

      try {
         SysDept sysDept = sysDeptService.findSysDept(new Integer(id));
         ConvertUtil.objectToMap(getForm().getRecord(), sysDept);
         initForm(getForm(), EDIT);
         return "EDIT";
      }
      catch (ServiceException e) {
         request.put("errMsg", e.getMessage());
         return "ERROR";
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("err", e);
         return "ERROR";
      }
   }

   public String updateDept() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'updateDept' method");
      String forward;
      try {
         SysDept sysDept = sysOrgService.findSysDept(new Integer(getForm().getRecord().get("id")));
         ConvertUtil.mapToObject(sysDept, getForm().getRecord(), false);
         sysOrgService.updateSysDept(sysDept);
         request.put("returnStatus", RETURN_NORMAL);
         forward = "MESSAGE";
      }
      catch (ServiceException e) {
         addMessage(getForm(), e.getMessage());
         initForm(getForm(), EDIT);
         return "EDIT";
      }
      catch (Exception e) {
         addMessage(getForm(), "保存操作失败!");
         initForm(getForm(), EDIT);
         forward = "EDIT";
      }
      return forward;
   }

   public String deleteDept() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'deleteDept' method");
      HttpServletResponse response = ServletActionContext.getResponse();
      response.setContentType("text/plain;charset=UTF-8");
      response.setHeader("Cache_Control", "no-cache");
      StringBuffer sb = new StringBuffer();
      try {
         if (id != null) {
            sysOrgService.removeSysDept(new Integer(id));
         }
         sb.append(RET_NORAML);
      }
      catch (Exception e) {
         sb.append(JsonErrorMessage(OPER_FAILED, "部门删除失败！"));
      }
      response.getWriter().write(sb.toString());
      response.getWriter().close();
      return null;
   }

   private void initForm(BaseForm baseForm, String action) {
   }

   private String JsonErrorMessage(int errNo, String msg) {
      return "{\"exit\":\"" + errNo + "\",\"message\":\"" + msg + "\"}";
   }

   @Resource
   private SysDeptService sysDeptService;

   @Resource
   private SysOrgService  sysOrgService;

   private String         orgId;

   private String         pid;

   private String         id;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getOrgId() {
      return orgId;
   }

   public void setOrgId(String orgId) {
      this.orgId = orgId;
   }

   public String getPid() {
      return pid;
   }

   public void setPid(String pid) {
      this.pid = pid;
   }
}
