package com.golead.art.appManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.golead.art.app.appUser.model.ArtAppUser;
import com.golead.art.app.appUser.service.ArtAppUserService;
import com.golead.art.utils.QTool;
import com.golead.art.works.service.ArtSysLogService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.web.action.BaseAction;

/**
 * App用户管理
 *
 * @author JiaHua-Lan 2016/11/4
 */
public class AppUserManagerAction extends BaseAction {

   @Override
   public String doExecute() throws Exception {
      String forward = "";
      String action = getForm().getAction();
      if (action == null) forward = LIST;
      initForm();
      try {
         if (LIST.equalsIgnoreCase(action)) forward = listAppUser();
         else if (PAGE.equalsIgnoreCase(action)) forward = pageAppUser();
         //用户禁言部分
         else if (TO_PROHIBITION_ACTION.equalsIgnoreCase(action)) forward = toProhibition();
         else if (PROHIBITION_ACTION.equalsIgnoreCase(action)) forward = prohibitionOfSpeaking();
         else if (NOT_PROHIBITION_ACTION.equalsIgnoreCase(action)) forward = liftTheProhibition();
         else if (CHECK_PROHIBITION_ACTION.equalsIgnoreCase(action)) forward = checkProhibition();
         //用户启用部分
         else if (TO_USER_DISABLE_ACTION.equalsIgnoreCase(action)) forward = toUserDisabled();
         else if (USER_ENABLE_ACTION.equalsIgnoreCase(action)) forward = userEnabled();
         else if (USER_DISABLE_ACTION.equalsIgnoreCase(action)) forward = userDisabled();
         else if (CHECK_USER_ENABLE_ACTION.equalsIgnoreCase(action)) forward = checkUserEnable();
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         return ERROR;
      }
      return forward;
   }

   private void initForm() {
      setCode(form, "START_OR_STOP");
      setCode(form, "YES_OR_NO");
   }

   /**
    * 跳转到App用户管理页面
    */
   public String listAppUser() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'listAppUser()' method");
      return LIST;
   }

   /**
    * 用户列表数据
    */
   public String pageAppUser() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'pageAppUser()' method");
      try {
         PageQuery pageQuery = form.getQuery() == null ? new PageQuery() : form.getQuery();
         pageQuery = artAppUserService.queryArtAppUser(pageQuery);
         if (pageQuery != null) {
            List<Map<String, Object>> recordSet = pageQuery.getRecordSet();
            if (recordSet != null) {
               List<Map<String, Object>> gridRowList = new ArrayList<Map<String, Object>>();
               for (int i = 0; i < recordSet.size(); i++) {
                  Map<String, Object> map = recordSet.get(i);
                  Map<String, Object> row = new HashMap<String, Object>();
                  
                  String userStatus = this.findCodeName(form, "START_OR_STOP", map.get(ArtAppUser.PROP_USER_STATUS) + "");
                  String reopenTime;
                  if (map.get(ArtAppUser.PROP_REOPEN_TIME) != null) reopenTime = format.format((Date) map.get(ArtAppUser.PROP_REOPEN_TIME));
                  else reopenTime = "";

                  String isProhibition = this.findCodeName(form, "YES_OR_NO", map.get(ArtAppUser.PROP_NO_COMMENT) + "");
                  String recommentTime;
                  if (map.get(ArtAppUser.PROP_RECOMMENT_TIME) != null) recommentTime = format.format((Date) map.get(ArtAppUser.PROP_RECOMMENT_TIME));
                  else recommentTime = "";
                  
                  row.put(ArtAppUser.PROP_ID, map.get(ArtAppUser.PROP_ID));
                  row.put("data", new Object[] { "", map.get(ArtAppUser.PROP_ACCOUNT_NAME), map.get(ArtAppUser.PROP_USER_NAME), userStatus, reopenTime,
                        isProhibition, recommentTime });
                  gridRowList.add(row);
               }
               String res = genGridJson(pageQuery, gridRowList);
               artSysLogService.createArtSysLog(currentUser.getUserName(), "App管理", "App用户管理管理", "查询条件为：" + QTool.getParamter(pageQuery.getParameters()));
               setResponse(res);
            }
         }
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

   /**
    * 跳转到用户禁言设置页面
    */
   public String toProhibition() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'toProhibition()' method");
      Map<String, String> record = form.getRecord();
      record.put(ArtAppUser.PROP_ID, ids);
      return TO_PROHIBITION_ACTION;
   }

   public String checkProhibition() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'checkProhibition()' method");
      ArtAppUser user = artAppUserService.getArtAppUser(Integer.valueOf(ids));
      if (PROHIBITION.equals(user.getNoComment())) {
         setResponse("{exit:1,message:\"用户已处于禁言状态\"}");
      }
      else {
         setResponse("{exit:0,message:\"用户没有被禁言禁言\"}");
      }
      return null;
   }

   /**
    * 用户禁言
    */
   public String prohibitionOfSpeaking() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'prohibitionOfSpeaking()' method");
      Map<String, String> record = form.getRecord();
      String id = record.get(ArtAppUser.PROP_ID);
      ArtAppUser user = artAppUserService.getArtAppUser(Integer.valueOf(id));
      user.setNoComment(PROHIBITION);
      String recommentTime = record.get(ArtAppUser.PROP_RECOMMENT_TIME);
      user.setRecommentTime(format.parse(recommentTime));
      artAppUserService.updateArtAppUser(user);
      artSysLogService.createArtSysLog(currentUser.getUserName(), "App管理", "App用户管理管理", "用户禁言：" + user.getUserName());
      return returnForward(RETURN_NORMAL);
   }

   /**
    * 解除禁言
    */
   public String liftTheProhibition() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'liftTheProhibition()' method");
      try {
         ArtAppUser artAppUser = artAppUserService.getArtAppUser(Integer.valueOf(ids));
         artAppUser.setRecommentTime(null);
         artAppUser.setNoComment(NOT_PROHIBITION);
         artAppUserService.updateArtAppUser(artAppUser);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "App管理", "App用户管理管理", "解除用户禁言：" + artAppUser.getUserName());
         setResponse("{exit:0}");
      }
      catch (ServiceException e) {
         setResponse("{exit:1,message:\"" + e.getMessage() + "\"}");
      }
      catch (Exception e) {
         setResponse("{exit:1,message:\"解除禁言操作失败!\"}");
      }
      return null;
   }

   /**
    * 跳转到用户停用设置页面
    */
   public String toUserDisabled() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'toUserDisabled()' method");
      form.getRecord().put(ArtAppUser.PROP_ID, ids);
      return TO_USER_DISABLE_ACTION;
   }

   /**
    * 检查用户是否可用
    */
   public String checkUserEnable() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'checkUserEnable()' method");
      ArtAppUser user = artAppUserService.getArtAppUser(Integer.valueOf(ids));
      if (USER_ENABLE.equals(user.getUserStatus())) {
         setResponse("{exit:1,message:\"用户是可用的\"}");
      }
      else {
         setResponse("{exit:0,message:\"用户已被停用\"}");
      }
      return null;
   }

   /**
    * 用户停用
    */
   public String userDisabled() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'userDisabled()' method");
      Map<String, String> record = form.getRecord();
      String id = record.get(ArtAppUser.PROP_ID);
      ArtAppUser user = artAppUserService.getArtAppUser(Integer.valueOf(id));
      user.setUserStatus(USER_DISABLE);
      String reopenTime = record.get(ArtAppUser.PROP_REOPEN_TIME);
      user.setReopenTime(format.parse(reopenTime));
      user.setReason(record.get(ArtAppUser.PROP_REASON));
      artAppUserService.updateArtAppUser(user);
      artSysLogService.createArtSysLog(currentUser.getUserName(), "App管理", "App用户管理管理", "停用用户：" + user.getUserName());
      return returnForward(RETURN_NORMAL);
   }

   /**
    * 用户启用
    */
   public String userEnabled() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'userEnabled()' method");
      try {
         ArtAppUser artAppUser = artAppUserService.getArtAppUser(Integer.valueOf(ids));
         artAppUser.setReopenTime(null);
         artAppUser.setUserStatus(USER_ENABLE);
         artAppUserService.updateArtAppUser(artAppUser);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "App管理", "App用户管理管理", "用户启用：" + artAppUser.getUserName());
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

   private DateFormat        format                   = new SimpleDateFormat("yyyy-MM-dd");

   @Resource
   private ArtAppUserService artAppUserService;
   
   @Resource
   private ArtSysLogService              artSysLogService;

   /**
    * 检查用户可否被禁言
    */
   private final String      CHECK_PROHIBITION_ACTION = "CHECK_PROHIBITION";

   /**
    * 跳转到禁言设置页面的Action名
    */
   private final String      TO_PROHIBITION_ACTION    = "TO_PROHIBITION";

   /**
    * 用户禁言的Action名
    */
   private final String      PROHIBITION_ACTION       = "PROHIBITION";

   /**
    * 用户解除禁言的Action名
    */
   private final String      NOT_PROHIBITION_ACTION   = "NOT_PROHIBITION";

   /**
    * 检查用户状态
    */
   private final String      CHECK_USER_ENABLE_ACTION = "CHECK_USER_ENABLE";

   /**
    * 用户启用的Action名
    */
   private final String      USER_ENABLE_ACTION       = "USER_ENABLE";

   /**
    * 跳转到用户禁用设置页面的Action名
    */
   private final String      TO_USER_DISABLE_ACTION   = "TO_USER_DISABLE";

   /**
    * 用户禁用的Action名
    */
   private final String      USER_DISABLE_ACTION      = "USER_DISABLE";

   /**
    * 禁言状态
    */
   private final String      PROHIBITION              = "1";

   /**
    * 非禁言状态
    */
   private final String      NOT_PROHIBITION          = "0";

   /**
    * 用户启用
    */
   private final String      USER_ENABLE              = "1";

   /**
    * 用户停用
    */
   private final String      USER_DISABLE             = "0";

   private Log               log                      = LogFactory.getLog(AppUserManagerAction.class);
}
