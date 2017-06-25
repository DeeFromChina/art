package com.golead.art.app;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.golead.core.util.Const;
import com.golead.core.web.CommonService;
import com.golead.core.web.UserSession;
import com.golead.core.web.action.BaseAction;
import com.golead.core.web.form.QueryForm;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public abstract class RemoteClientBaseAction implements ModelDriven<QueryForm> {

	   private final Log             log            = LogFactory.getLog(BaseAction.class);

	   protected Map<String, Object> request;
	   protected Map<String, Object> session;
	   protected ActionContext       ctx;
	   protected UserSession         currentUser;
	   protected String              ids;
	   
	   protected QueryForm           form             = new QueryForm();
	   
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
	   

	
	@Override
	public QueryForm getModel() {
		return form;
	}

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		if (log.isDebugEnabled())
			log.debug("enter execute...");

		ctx = ActionContext.getContext();
		request = (Map<String, Object>) ctx.get("request");
		session = ctx.getSession();
		currentUser = (UserSession) session.get(Const.SESSION);
		HttpServletRequest httpRequest = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		String CONTEXT_PATH = httpRequest.getScheme() + "://"
				+ httpRequest.getServerName() + ":"
				+ httpRequest.getServerPort() + httpRequest.getContextPath()
				+ "/";
		request.put("CONTEXT_PATH", CONTEXT_PATH);

		String forward;
		String islogon = checkLogin(currentUser);
		if (islogon.equals(HAVEPRIVILEGE)) {
			HttpServletResponse response = (HttpServletResponse) ctx.get(StrutsStatics.HTTP_RESPONSE);
			response.setHeader("Content-Type", "text/html; charset=UTF-8");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);

			forward = doExecute();

		} else {
			setResponse("{exit:1,message:\"操作超时,请重新登录!\"}");
			forward = null;
		}
		return forward;
	}
	
	public abstract String doExecute() throws Exception;
	
	public String checkLogin(UserSession currentUser) {
		HttpServletRequest httpRequest = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		if (currentUser == null) return NOTLOGIN;
		else {
			String uriStr = httpRequest.getRequestURI();
			String action = httpRequest.getParameter("action");
			String contextPath = httpRequest.getContextPath();
			String urlPath = uriStr.replaceAll(contextPath + "/", "");

			if (action != null)
				urlPath += "?action=" + action;
			else
				urlPath += "?action=list";

			// 找到资源表中本链接是否存在。
			String rCode = commonService.findResourceCode(urlPath);
			// String clazz = this.getClass().getName();
			// String rCode = commonService.findResourceCode(clazz,action);

			// 如果不存在，不做权限控制。
			if ("".equals(rCode))
				return HAVEPRIVILEGE;

			// 如果存在，检查当前用户权限中是否具有本链接的权限。
			if (currentUser.getPrivileges().containsKey(rCode))
				return HAVEPRIVILEGE;
			else
				return NOPRIVILEGE;
		}
	}

	protected void setResponse(String doc) throws Exception {
		HttpServletResponse response = (HttpServletResponse) ctx.get(StrutsStatics.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(doc);
		response.getWriter().close();
	}
	
	@Resource
	private CommonService commonService;


}
