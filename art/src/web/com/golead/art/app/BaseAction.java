package com.golead.art.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.golead.core.common.Code;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.util.Const;
import com.golead.core.web.CommonService;
import com.golead.core.web.UserSession;
import com.golead.core.web.form.BaseForm;
import com.golead.core.web.form.QueryForm;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction implements ModelDriven<QueryForm> {

   private static final long     serialVersionUID = 1L;

   protected Map<String, Object> request;
   protected Map<String, Object> session;
   protected ActionContext       ctx;
   protected UserSession         currentUser;
   protected String              ids;

   protected QueryForm           form             = new QueryForm();

   public QueryForm getForm() {
      return form;
   }

   public void setForm(QueryForm form) {
      this.form = form;
   }

   public QueryForm getModel() {
      return form;
   }

   public void setIds(String ids) {
      this.ids = ids;
   }

   public String getIds() {
   return ids;
}

private CommonService commonService;

   public CommonService getCommonService() {
      return commonService;
   }

   public void setCommonService(CommonService commonService) {
      this.commonService = commonService;
   }

   private final Log             log            = LogFactory.getLog(BaseAction.class);

   protected static final Long   defaultLong    = null;
   protected static final int    ERROR_MSG_SIZE = 30;

   protected static final String LIST           = "LIST";
   protected static final String PAGE           = "PAGE";
   protected static final String ADD            = "ADD";
   protected static final String SAVE           = "SAVE";
   protected static final String EDIT           = "EDIT";
   protected static final String UPDATE         = "UPDATE";
   protected static final String DELETE         = "DELETE";
   protected static final String VIEW           = "VIEW";
   protected static final String SEARCH         = "SEARCH";
   protected static final String MESSAGE        = "MESSAGE";
   protected static final String ERROR          = "ERROR";
   protected static final String RETURN_NORMAL  = "0";
   protected static final String NOTLOGIN       = "notLogin";
   protected static final String NOPRIVILEGE    = "noPrivilege";
   protected static final String HAVEPRIVILEGE  = "havePrivilege";

   protected static final String ADMIN          = "admin";

   @SuppressWarnings("unchecked")
   public String execute() throws Exception {
      if (log.isDebugEnabled()) log.debug("enter execute...");

      ctx = ActionContext.getContext();
      request = (Map<String, Object>) ctx.get("request");
      session = ctx.getSession();
      currentUser = (UserSession) session.get(Const.SESSION);
      HttpServletRequest httpRequest = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
     String CONTEXT_PATH = httpRequest.getScheme() + "://" + httpRequest.getServerName() + ":" + httpRequest.getServerPort() + httpRequest.getContextPath() + "/";
     request.put("CONTEXT_PATH", CONTEXT_PATH);
     String islogon = HAVEPRIVILEGE;
      String forward;
      if (islogon.equals(HAVEPRIVILEGE)) {
         HttpServletResponse response = (HttpServletResponse) ctx.get(StrutsStatics.HTTP_RESPONSE);
         response.setHeader("Content-Type", "text/html; charset=UTF-8");
         response.setHeader("Pragma", "no-cache");
         response.setHeader("Cache-Control", "no-cache");
         response.setDateHeader("Expires", 0);

         forward = doExecute();

      }
      else {
         forward = HAVEPRIVILEGE;
      }
      return forward;
   }

   public abstract String doExecute() throws Exception;

   protected String getErrorMsg(Exception e, int size) {
      String errorMsg = e.getMessage();
      if (errorMsg != null && errorMsg.length() > size) {
         errorMsg = errorMsg.substring(0, size) + "...";
      }
      return errorMsg;
   }

   public String checkLogin(UserSession currentUser) {
      HttpServletRequest httpRequest = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
      if (currentUser == null) return NOTLOGIN;
      else {
         String uriStr = httpRequest.getRequestURI();
         String action = httpRequest.getParameter("action");
         String contextPath = httpRequest.getContextPath();
         String urlPath = uriStr.replaceAll(contextPath + "/", "");

         if (action != null) urlPath += "?action=" + action;
         else urlPath += "?action=list";

         // 找到资源表中本链接是否存在。
         String rCode = commonService.findResourceCode(urlPath);
         //         String clazz = this.getClass().getName();
         //         String rCode = commonService.findResourceCode(clazz,action);

         // 如果不存在，不做权限控制。
         if ("".equals(rCode)) return HAVEPRIVILEGE;

         // 如果存在，检查当前用户权限中是否具有本链接的权限。
         if (currentUser.getPrivileges().containsKey(rCode)) return HAVEPRIVILEGE;
         else return NOPRIVILEGE;
      }
   }

   protected void setResponse(String doc, String charset, boolean bom) throws Exception {
      HttpServletResponse response = (HttpServletResponse) ctx.get(StrutsStatics.HTTP_RESPONSE);
      response.setHeader("Content-Type", "text/xml; charset=" + charset);
      if (bom) {
         response.setCharacterEncoding("UTF-8");
         response.getWriter().write(0xEF);
         response.getWriter().write(0xBB);
         response.getWriter().write(0xBF);
      }
      response.getWriter().write(doc);
      response.getWriter().close();
   }

   protected void setResponse(String doc) throws Exception {
      HttpServletResponse response = (HttpServletResponse) ctx.get(StrutsStatics.HTTP_RESPONSE);
      response.getWriter().write(doc);
      response.getWriter().close();
   }

   protected String genGridJson(List<Map<String, Object>> list) {
      JSONArray jsonObject = JSONArray.fromObject(list);
      String res = "{exit:0,rows:" + jsonObject.toString() + "}";
      return res;
   }
   
   protected String genGridJson(PageQuery pageQuery, List<Map<String, Object>> list) {
      JSONArray jsonObject = JSONArray.fromObject(list);
      String res = "{exit:0,";
      res += "rows:" + jsonObject.toString() + ",";
      res += "rc:" + pageQuery.getRecordCount() + ",";
      res += "pc:" + pageQuery.getPageCount() + ",";
      res += "pn:" + pageQuery.getPageNumber();
      res += "}";
      return res;
   }

   /**
    * 在ActionForm中增加一个提示信息
    * 
    * @param objForm
    *           需要增加信息的ActionForm
    * @param info
    *           提示信息
    */
   protected void addMessage(Object objForm, String info) {
      BaseForm bf = (BaseForm) objForm;
      String msg = bf.getErrorMessage();
      if (!msg.equals("")) msg = msg + "\n";
      bf.setErrorMessage(msg + info);
   }

   /**
    * 在ActionForm中
    * 
    * @param objForm
    *           要查找的ActionForm
    * @param codeNo
    *           代码集编号
    * @param value
    *           代码值
    * @return value对应的代码名称
    */
   protected String findCodeName(Object objForm, String codeNo, Serializable value) {
      BaseForm bf = (BaseForm) objForm;

      List<Code> list = bf.getCodeSets().get(codeNo);
      if (value == null) return "";
      if (list == null) return "";
      for (int i = 0; i < list.size(); i++) {
         Code code = list.get(i);
         String v;
         if (value instanceof String) v = ((String) value).trim();
         else v = value.toString();
         if (v.equals(code.getValue())) return code.getCodeName();
      }
      return "";
   }

   /**
    * 在ActionForm中的代码集集合中增加一组代码集
    * 
    * @param objForm
    *           要增加代码集的ActionForm
    * @param codeSetNos
    *           要增加代码集的编号集合，以逗号或者分号分隔
    */
   protected void setCode(Object obj, String codeSetNos) {
      String[] codes;
      if (codeSetNos == null) return;
      if (codeSetNos.indexOf(";") > 0) codes = codeSetNos.split(";");
      else if (codeSetNos.indexOf(",") > 0) codes = codeSetNos.split(",");
      else {
         codes = new String[1];
         codes[0] = codeSetNos;
      }

      for (int i = 0; i < codes.length; i++) {
         List<Code> codeSet = commonService.load(codes[i]);
         setCode(obj, codes[i], codeSet);
      }
   }

   /**
    * 在ActionForm中的代码集集合中增加一个代码集
    * 
    * @param objForm
    *           要增加代码集的ActionForm
    * @param codeSetNo
    *           要增加代码集的编号
    * @param codes
    *           要增加代码集
    */
   protected void setCode(Object obj, String codeSetNo, List<Code> codes) {
      if (codes == null) return;
      BaseForm bf = (BaseForm) obj;
      bf.getCodeSets().put(codeSetNo, codes);
   }

   /**
    * 在ActionForm中的代码集集合中增加一个代码集
    * 
    * @param objForm
    *           要增加代码集的ActionForm
    * @param codeSetNo
    *           要增加代码集的编号
    * @param objects
    *           代码集的来源对象集合
    * @param label
    *           对象中作为codeName的属性
    * @param value
    *           对象中作为value的属性
    */
   protected void setCode(Object obj, String codeSetNo, List objects, String label, String value, boolean nullObject) {
      if (objects == null) return;
      BaseForm bf = (BaseForm) obj;
      List<Code> al = new ArrayList<Code>();

      if (nullObject) al.add(new Code("", ""));
      for (int i = 0; i < objects.size(); i++) {
         Code code = new Code();
         Object objtmp = objects.get(i);
         Object ol = null;
         Object ov = null;
         try {
            ol = PropertyUtils.getProperty(objtmp, label);
            ov = PropertyUtils.getProperty(objtmp, value);
         }
         catch (Exception e) {
            ol = null;
            ov = null;
         }
         if (ol != null && ov != null) {
            code.setCodeName(ol.toString());
            code.setValue(ov.toString());
            al.add(code);
         }
      }
      bf.getCodeSets().put(codeSetNo, al);
   }

   protected String returnForward(String returnStatus) {
      request.put("returnStatus", returnStatus);
      return MESSAGE;
   }
}
