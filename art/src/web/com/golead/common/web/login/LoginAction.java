package com.golead.common.web.login;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.golead.art.works.service.ArtSysLogService;
import com.golead.common.service.login.LoginService;
import com.golead.core.util.Const;
import com.golead.core.web.UserSession;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction implements Action {

   private static final long serialVersionUID = 1L;

   private String            action;

   private String            skin;

   private String            userName;

   // mainType：为"0"使用下拉菜单，为"1"使用风琴菜单，为"2"使用树形菜单。
   private String            mainType         = "0";

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   private String password;

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getAction() {
      return action;
   }

   public void setAction(String action) {
      this.action = action;
   }

   @Resource
   private LoginService        loginService;
   private Map<String, Object> request;
   private Map<String, Object> session;

   public LoginService getLoginService() {
      return loginService;
   }

   public void setLoginService(LoginService loginService) {
      this.loginService = loginService;
   }

   public void setSession(Map<String, Object> session) {
      this.session = session;
   }

   @Override
   @SuppressWarnings("unchecked")
   public String execute() throws Exception {
      String forward = null;
      ActionContext ctx = ActionContext.getContext();
      request = (Map<String, Object>) ctx.get("request");
      session = ctx.getSession();
      HttpServletResponse response = (HttpServletResponse) ctx.get(StrutsStatics.HTTP_RESPONSE);
      response.setHeader("Content-Type", "text/html; charset=UTF-8");
      response.setHeader("Pragma", "no-cache");
      response.setHeader("Cache-Control", "no-cache");
      response.setDateHeader("Expires", 0);

      
      try {
         if (action == null || "".equals(action)) {
            forward = "LOGIN";
         }
         else if ("logout".equalsIgnoreCase(action)) {
            UserSession userSession = (UserSession)  session.get(Const.SESSION);
            session.remove(Const.SESSION);
            artSysLogService.createArtSysLog(userSession.getUserName(), "", "", "退出系统");
            forward = "LOGIN";
         }
         else if ("login".equalsIgnoreCase(action)) {
            if(userName==null) return null;
            validateLogin();
            forward = "SUCESS";
         }
         else if ("skin".equalsIgnoreCase(action)) {
            UserSession userSession = (UserSession) session.get(Const.SESSION);
            if (skin == null || skin.equalsIgnoreCase("default")) userSession.getProperties().remove("skin");
            else userSession.getProperties().put("skin", skin);
            loginService.changeProperty(Integer.valueOf(userSession.getUserId()), "skin", skin);
            forward = "SUCESS";
         }
      } catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         forward = "LOGIN";
      }
      return forward;
   }

   public void validateLogin() throws Exception {
      UserSession userSession = loginService.login(userName, password);
      if (userSession != null) {
         session.put(Const.SESSION, userSession);
         artSysLogService.createArtSysLog(userSession.getUserName(), "", "", "登录系统");
      }
      else {
         throw new Exception("用户名或密码错误。");
      }
   }

   public String getSkin() {
      return skin;
   }

   public void setSkin(String skin) {
      this.skin = skin;
   }

   public String getMainType() {
      return mainType;
   }

   public void setMainType(String mainType) {
      this.mainType = mainType;
   }
   
   @Resource
   private ArtSysLogService artSysLogService;

}
