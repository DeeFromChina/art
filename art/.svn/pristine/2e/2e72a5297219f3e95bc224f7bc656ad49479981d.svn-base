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

import com.golead.art.app.commentary.service.ArtCommentaryService;
import com.golead.art.utils.QTool;
import com.golead.art.works.service.ArtSysLogService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.web.action.BaseAction;

/**
 * 处理用户意见反馈的Action
 * */
public class AppFeedbackAction extends BaseAction {

   private Log                  log = LogFactory.getLog(AppFeedbackAction.class);

   private DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
   
   @Resource
   private ArtCommentaryService artCommentaryService;
   
   @Resource
   private ArtSysLogService              artSysLogService;

   private void initForm(){
      this.setCode(form, "DATE_YEAR");
      this.setCode(form, "DATE_MONTH");
   }
   
   @Override
   public String doExecute() throws Exception {
      String forward = "";
      String action = getForm().getAction();
      initForm();
      if (action == null) forward = LIST;
      try {
         if (LIST.equalsIgnoreCase(action)) forward = feedbackList();
         else if (PAGE.equalsIgnoreCase(action)) forward = feedbackPage();
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         return ERROR;
      }
      return forward;
   }

   public String feedbackList() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'feedbackList()' method");
      return LIST;
   }

   public String feedbackPage() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'feedbackPage()' method");
      try {
         PageQuery pageQuery = form.getQuery() == null ? new PageQuery() : form.getQuery();
         pageQuery = artCommentaryService.queryArtFeedback(pageQuery);
         if (pageQuery != null) {
            List<Map<String, Object>> recordSet = pageQuery.getRecordSet();
            if (recordSet != null) {
               List<Map<String, Object>> gridRowList = new ArrayList<Map<String, Object>>();
               for (int i = 0; i < recordSet.size(); i++) {
                  Map<String, Object> map = recordSet.get(i);
                  Map<String, Object> row = new HashMap<String, Object>();
                  row.put("id", map.get("id"));
                  row.put("data", new Object[] { "", map.get("accountName"), format.format((Date)map.get("createTime")), map.get("content") });
                  gridRowList.add(row);
               }
               String res = genGridJson(pageQuery, gridRowList);
               artSysLogService.createArtSysLog(currentUser.getUserName(), "App管理", "用户意见反馈管理", "查询条件为：" + QTool.getParamter(pageQuery.getParameters()));
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
}
