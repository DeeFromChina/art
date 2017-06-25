package com.golead.common.web.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;

import com.golead.common.model.SysOrg;
import com.golead.common.service.system.SysOrgService;
import com.golead.core.exception.WebException;
import com.golead.core.web.action.BaseAction;
import com.golead.core.web.form.BaseForm;

public class SysOrgSelectAction extends BaseAction {

   protected static final String RET_NORAML  = "{\"exit\":\"0\"}";

   protected static final int    OPER_FAILED = 1;

   protected int                 filteByUser = 1;
   protected String              catalog = "0";

   private final Log             log         = LogFactory.getLog(SysOrg.class);

   @Override
   public String doExecute() throws Exception {
      String action = form.getAction();
      if (action == null) action = LIST;
      String forward;
      try {
         if (LIST.equalsIgnoreCase(action)) forward = search(); // 打开查询列表页面
         else if ("GETTREE".equalsIgnoreCase(action)) forward = getTreeNode(); // 打开树
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

   private void initForm(BaseForm baseForm, String action) {
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
         Map<String, String> parameters = new HashMap<String, String>();
         parameters.put("catalog", this.catalog);
         
         if (id.indexOf("org") == 0) {
            orgs = sysOrgService.findChildOrgs(id.substring(3), parameters);
            response.getWriter().write(getNodes(orgs, id));
            
         } else {
            if (this.filteByUser == 1) {
               orgs = new ArrayList<Object>();
               orgs.add(sysOrgService.findSysOrg(Integer.valueOf(currentUser.getOrgId())));
               
            } else {
               orgs = sysOrgService.findChildOrgs(null, parameters);
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
            sb.append("<item id=\"org" + so.getId() + "\" text=\"" + so.getOrgAbbr()
                  + "\" im0=\"../icon/house_big.gif\" im1=\"../icon/house_big.gif\" im2=\"../icon/house_big.gif\" child=\"1\" open=\"1\">");
            sb.append("<userdata name=\"name\">" + so.getOrgAbbr() + "</userdata>");
            sb.append("<userdata name=\"type\">" + so.getOrgType() + "</userdata>");
            sb.append("<userdata name=\"parentId\">" + (so.getUpOrgId() == null ? "" : so.getUpOrgId()) + "</userdata>");
            sb.append("<userdata name=\"orgCode\">" + (so.getOrgCode() == null ? "" : so.getOrgCode()) + "</userdata>");
            sb.append("</item>");
         }
      }
      sb.append("</tree>");
      return sb.toString();
   }

   private String getNodes(List orgs, String id) {
      StringBuffer sb = new StringBuffer("");
      sb.append("<?xml version='1.0' encoding='UTF-8' ?>");
      sb.append("<tree id=\"" + id + "\">");
      if (orgs != null) {
         for (int i = 0; i < orgs.size(); i++) {
            SysOrg so = (SysOrg) orgs.get(i);
            sb.append("<item id=\"org" + so.getId() + "\" text=\"" + so.getOrgAbbr()
                  + "\" im0=\"../icon/house_big.gif\" im1=\"../icon/house_big.gif\" im2=\"../icon/house_big.gif\" child=\"1\">");
            sb.append("<userdata name=\"name\">" + so.getOrgAbbr() + "</userdata>");
            sb.append("<userdata name=\"type\">" + so.getOrgType() + "</userdata>");
            sb.append("<userdata name=\"orgCode\">" + (so.getOrgCode() == null ? "" : so.getOrgCode()) + "</userdata>");
            sb.append("<userdata name=\"parentId\">" + (so.getUpOrgId() == null ? "" : so.getUpOrgId()) + "</userdata>");
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

   public String getCatalog() {
	  return catalog;
   }

   public void setCatalog(String catalog) {
	  this.catalog = catalog;
   }

   @Resource
   private SysOrgService sysOrgService;

}
