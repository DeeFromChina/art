package com.golead.art.artist;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.golead.art.utils.QTool;
import com.golead.art.works.model.ArtArtistWorksSeriesCase;
import com.golead.art.works.service.ArtArtistWorksSeriesCaseService;
import com.golead.art.works.service.ArtSysLogService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.util.ConvertUtil;
import com.golead.core.web.action.BaseAction;

public class ArtistWorksSeriesCaseAction extends BaseAction {

   private Log                             log = LogFactory.getLog(ArtistWorksSeriesCaseAction.class);

   @Resource
   private ArtArtistWorksSeriesCaseService artArtistWorksSeriesCaseService;
   
   @Resource
   private ArtSysLogService                artSysLogService;
   
   private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

   @Override
   public String doExecute() throws Exception {
      String forward = "";
      String action = getForm().getAction();
      if (action == null) {
         forward = LIST;
      }
      try {
         if (LIST.equalsIgnoreCase(action)) forward = list();
         else if (PAGE.equalsIgnoreCase(action)) forward = page();
         else if (ADD.equalsIgnoreCase(action)) forward = add();
         else if (SAVE.equalsIgnoreCase(action)) forward = save();
         else if (EDIT.equalsIgnoreCase(action)) forward = edit();
         else if (UPDATE.equalsIgnoreCase(action)) forward = update();
         else if (DELETE.equalsIgnoreCase(action)) forward = delete();
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         forward = ERROR;
      }
      return forward;
   }

   public void initForm() {

   }

   public String list() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'list()' method");
      return LIST;
   }

   public String page() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'pageExperience()' method");
      try {
         PageQuery pageQuery = form.getQuery();
         String artistId = getForm().getRecord().get("artistId");
         pageQuery.getParameters().put("artistId", artistId);
         pageQuery = artArtistWorksSeriesCaseService.queryArtArtistWorksSeriesCase(pageQuery);
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         for (Map<String, Object> item : pageQuery.getRecordSet()) {
            Map<String, Object> map = new HashMap<String, Object>();
            
            
            map.put("id", item.get("id"));
            map.put("data",
                  new Object[] { "" ,item.get("caseName"), item.get("author"), dateFormat.format(item.get("caseTime")), item.get("caseContent") });
            list.add(map);
         }
         String res = genGridJson(pageQuery, list);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "艺术家管理", "艺术家作品系列管理", "查询条件为：" + QTool
               .getParamter(pageQuery.getParameters()));
         setResponse(res);
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

   public String add() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'add()' method");
      String forward = null;
      try {
         return ADD;
      }
      catch (Exception e) {
         e.printStackTrace();
         forward = ERROR;
      }
      return forward;
   }

   public String save() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'save()' method");
      try {
         ArtArtistWorksSeriesCase artArtistWorksSeries = new ArtArtistWorksSeriesCase();
         ConvertUtil.mapToObject(artArtistWorksSeries, form.getRecord(), false);
         artArtistWorksSeriesCaseService.createArtArtistWorksSeriesCase(artArtistWorksSeries);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "艺术家管理", "艺术家作品系列管理", "添加系列个案研究：" + artArtistWorksSeries.getCaseName());
         return returnForward(RETURN_NORMAL);
      }
      catch (ServiceException e) {
         addMessage(getForm(), e.getMessage());
         return ADD;
      }
      catch (Exception e) {
         e.printStackTrace();
         addMessage(getForm(), "保存操作失败!");
         return ADD;
      }
   }

   public String edit() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'edit()' method");
      String forward = null;
      try {
         int id = Integer.valueOf(ids);
         ArtArtistWorksSeriesCase artArtistWorksSeries = artArtistWorksSeriesCaseService.getArtArtistWorksSeriesCase(id);
         ConvertUtil.objectToMap(getForm().getRecord(), artArtistWorksSeries);
         return EDIT;
      }
      catch (Exception e) {
         e.printStackTrace();
         forward = ERROR;
      }
      return forward;
   }

   public String update() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'update()' method");
      try {
         Map<String, String> record = getForm().getRecord();
         artArtistWorksSeriesCaseService.updateArtArtistWorksSeriesCase(record);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "艺术家管理", "艺术家作品系列管理", "修改系列个案研究：" + record.get(ArtArtistWorksSeriesCase.PROP_CASE_NAME));
         return returnForward(RETURN_NORMAL);
      }
      catch (Exception e) {
         addMessage(form, e.getMessage());
         initForm();
         return EDIT;
      }
   }

   public String delete() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'delete()' method");
      try {
         StringBuffer log = new StringBuffer();
         String[] id = ids.split(",");
         Integer[] del_ids = new Integer[id.length];
         for (int i = 0; i < id.length; i++) {
            del_ids[i] = Integer.valueOf(id[i]);
            ArtArtistWorksSeriesCase artArtistWorksSeriesCase = artArtistWorksSeriesCaseService.getArtArtistWorksSeriesCase(del_ids[i]);
            if(log.length()>0)log.append(",");
            log.append("[").append(artArtistWorksSeriesCase.getId()).append(":").append(artArtistWorksSeriesCase.getCaseName()).append("]");
         }
         artArtistWorksSeriesCaseService.deleteArtArtistWorksSeriesCases(del_ids);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "艺术家管理", "艺术家作品系列管理", "删除系列个案研究：" + log.toString());
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
}
