package com.golead.art.works;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.golead.art.utils.QTool;
import com.golead.art.works.model.ArtWorksTheme;
import com.golead.art.works.service.ArtSysLogService;
import com.golead.art.works.service.ArtWorksThemeService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.util.ConvertUtil;
import com.golead.core.web.action.BaseAction;

/**
 * 作品题材
 * 
 * @author 尹湘
 * @version 1.0
 * @since 2016年9月3日 下午2:38:13
 */
public class ArtWorksThemeAction extends BaseAction {

   private Log              log         = LogFactory.getLog(ArtWorksThemeAction.class);
   private SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");

   @Override
   public String doExecute() throws Exception {
      String forward = "";
      String action = getForm().getAction();
      if (action == null) action = LIST;
      if (log.isDebugEnabled()) log.debug("action" + action);
      try {
         if (LIST.equalsIgnoreCase(action)) forward = sreachTheme();
         else if (PAGE.equalsIgnoreCase(action)) forward = pageTheme();
         else if (ADD.equalsIgnoreCase(action)) forward = addTheme();
         else if (SAVE.equalsIgnoreCase(action)) forward = saveTheme();
         else if (EDIT.equalsIgnoreCase(action)) forward = editTheme();
         else if (UPDATE.equalsIgnoreCase(action)) forward = updateTheme();
         else if (DELETE.equalsIgnoreCase(action)) forward = deleteTheme();
         else if (VIEW.equalsIgnoreCase(action)) forward = viewTheme();
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         forward = ERROR;
      }
      return forward;
   }

   public String sreachTheme() throws Exception {
      return LIST;
   }

   public String pageTheme() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'pageTheme' method");
      try {
         PageQuery pageQuery = form.getQuery() == null ? new PageQuery() : form.getQuery();
         pageQuery = artWorksThemeService.queryArtWorksTheme(pageQuery);
         if (pageQuery != null) {
            List<Map<String, Object>> rs = pageQuery.getRecordSet();
            if (rs != null) {
               List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
               for (int i = 0; i < rs.size(); i++) {
                  Map<String, Object> theme = rs.get(i);
                  Map<String, Object> map = new HashMap<String, Object>();
                  map.put("id", theme.get("id"));
                  String link = "^javascript:view(" + theme.get("id") + ")^_self";
                  map.put("data",
                        new Object[] { "", theme.get("themeName") + link, theme.get("themeDesc"), theme.get("createPerson"), dateFormate.format(theme.get("createTime")) });
                  list.add(map);
               }
               String res = genGridJson(pageQuery, list);
               artSysLogService.createArtSysLog(currentUser.getUserName(), "作品管理", "题材管理", "查询条件为：" + QTool.getParamter(pageQuery.getParameters()));
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

   public String addTheme() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'addTheme' method");
      try {
         return ADD;
      }
      catch (Exception e) {
         e.printStackTrace();
         return ERROR;
      }
   }

   public String saveTheme() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'saveTheme' method");
      try {
         ArtWorksTheme theme = new ArtWorksTheme();
         ConvertUtil.mapToObject(theme, form.getRecord(), false);
         theme.setCreatePerson(currentUser.getUserName());
         theme.setCreateTime(new Date());
         artWorksThemeService.createArtWorksTheme(theme);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "作品管理", "题材管理", "添加题材："+theme.getThemeName() );
         return returnForward(RETURN_NORMAL);
      }
      catch (Exception e) {
         addMessage(getForm(), e.getMessage());
         return ADD;
      }
   }

   public String editTheme() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'editTheme' method");
      try {
         ArtWorksTheme theme = artWorksThemeService.getArtWorksTheme(Integer.valueOf(ids));
         ConvertUtil.objectToMap(form.getRecord(), theme);
         return EDIT;
      }
      catch (Exception e) {
         e.printStackTrace();
         return ERROR;
      }
   }

   public String updateTheme() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'updateTheme' method");
      try {
         Map<String,String> record = form.getRecord();
         record.put("updatePerson", currentUser.getUserName());
         record.put("updateTime", dateFormate.format(new Date()));
         artWorksThemeService.updateArtWorksTheme(record);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "作品管理", "题材管理", "修改题材："+record.get(ArtWorksTheme.PROP_THEME_NAME));
         return returnForward(RETURN_NORMAL);
      }
      catch (Exception e) {
         e.printStackTrace();
         return EDIT;
      }
   }

   public String deleteTheme() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'deleteTheme' method");
      try {
         String[] id = ids.split(",");
         Integer[] del_ids = new Integer[id.length];
         StringBuffer log = new StringBuffer();
         for (int i = 0; i < del_ids.length; i++) {
            del_ids[i] = Integer.valueOf(id[i]);
            ArtWorksTheme artWorksTheme = artWorksThemeService.getArtWorksTheme(del_ids[i]);
            if(log.length()>0)log.append(",");
            log.append(artWorksTheme.getThemeName());
         }
         artWorksThemeService.deleteArtWorksThemes(del_ids);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "作品管理", "题材管理", "删除题材："+log.toString());
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

   public String viewTheme() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'viewTheme' method");
      String forward = null;
      try {
         ArtWorksTheme theme = artWorksThemeService.getArtWorksTheme(Integer.valueOf(ids));
         ConvertUtil.objectToMap(form.getRecord(), theme);
         forward = "VIEW";
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("err", e);
         forward = "ERROR";
      }
      return forward;
   }

   @Resource
   private ArtWorksThemeService artWorksThemeService;
   
   @Resource
   private ArtSysLogService          artSysLogService;
}
