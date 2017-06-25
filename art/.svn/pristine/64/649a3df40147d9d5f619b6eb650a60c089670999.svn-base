package com.golead.art.works;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.golead.art.literature.model.ArtLiteratureMedium;
import com.golead.art.literature.model.ArtLiteratureMediumResearch;
import com.golead.art.literature.service.ArtLiteratureMediumResearchService;
import com.golead.art.literature.service.ArtLiteratureMediumService;
import com.golead.art.utils.QTool;
import com.golead.art.works.model.ArtWorks;
import com.golead.art.works.model.ArtWorksMedium;
import com.golead.art.works.service.ArtSysLogService;
import com.golead.art.works.service.ArtWorksMediumService;
import com.golead.art.works.service.ArtWorksService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.web.action.BaseAction;

public class ArtWorksMediumAction extends BaseAction {

   private final Log logger = LogFactory.getLog(ArtWorksMediumAction.class);

   @Override
   public String doExecute() throws Exception {
      String forward = "";
      String action = form.getAction();

      if (action == null) action = LIST;
      if (logger.isDebugEnabled()) logger.debug("action:" + action);
      try {
         initForm();
         if (LIST.equalsIgnoreCase(action)) forward = LIST;
         else if (PAGE.equalsIgnoreCase(action)) forward = pagePublication();
         else if (ADD.equalsIgnoreCase(action)) forward = add();
         else if ("ADDPAGE".equalsIgnoreCase(action)) forward = addpage();
         else if (SAVE.equalsIgnoreCase(action)) forward = savePublication();
         else if (DELETE.equalsIgnoreCase(action)) forward = deletePublication();
      }
      catch (Exception e) {// 其他系统出错
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         forward = ERROR;
      }
      return forward;
   }

   public void initForm() throws Exception {
      setCode(form, "EXHIB_TYPE");
   }

   public String pagePublication() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'pageRole' method");
      try {
         PageQuery pageQuery = form.getQuery() == null ? new PageQuery() : form.getQuery();
         pageQuery = artWorksMediumService.queryArtWorksMedium(pageQuery);
         if (pageQuery != null) {
            List<Map<String, Object>> rs = pageQuery.getRecordSet();
            if (rs != null) {
               List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
               for (int i = 0; i < rs.size(); i++) {
                  Map<String, Object> publication = rs.get(i);
                  Map<String, Object> map = new HashMap<String, Object>();
                  map.put("id", publication.get("id"));
                  String link = "^javascript:view(" + publication.get("literatureId") + ")^_self";
                  map.put(
                        "data",
                        new Object[] { "", publication.get("literatureTitle") + link, publication.get("shotPeople"), publication.get("contentDesc"),
                              publication.get("literatureWorks"), publication.get("personInvolved"), publication.get("relatedExhib"),
                              publication.get("relatedEvent") });
                  list.add(map);
               }
               String res = genGridJson(pageQuery, list);
               artSysLogService.createArtSysLog(currentUser.getUserName(), "作品管理", "作品媒介关系管理", "查询条件为：" + QTool.getParamter(pageQuery.getParameters()));
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

   public String add() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'add()' method");
      try {
         return ADD;
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

   public String addpage() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'addpage()' method");
      try {
         PageQuery pq = form.getQuery();
         pq.getParameters().put("groupby", "id");
         pq = artLiteratureMediumService.queryArtLiteratureMedium(pq);
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         for (Map<String, Object> item : pq.getRecordSet()) {
            Map<String, Object> map = new HashMap<String, Object>();
            String link = "^javascript:view(" + item.get("id") + ");^_self";
            map.put("id", item.get("id"));
            map.put("data", new Object[] { "", item.get("literatureTitle") + link, item.get("shotPeople"), item.get("contentDesc") });
            list.add(map);
         }
         String res = genGridJson(pq, list);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "作品管理", "作品媒介关系管理", "查询条件为：" + QTool.getParamter(pq.getParameters()));
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

   public String savePublication() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'savePublication' method");
      try {
         String[] id = ids.split(",");
         int[] add_ids = new int[id.length];
         StringBuffer log = new StringBuffer();
         int worksId = Integer.valueOf(form.getRecord().get("worksId"));
         ArtWorks artWorks = artWorksService.getArtWorks(worksId);
         log.append(artWorks.getWorksCName()).append(":").append("[");
         for (int i = 0; i < add_ids.length; i++) {
            add_ids[i] = Integer.valueOf(id[i]);
            ArtLiteratureMedium artLiteratureMedium = artLiteratureMediumService.getArtLiteratureMedium(add_ids[i]);
            if (log.length() > 0) log.append(",");
            log.append(artLiteratureMedium.getLiteratureTitle());
         }
         log.append("]");
         artWorksMediumService.createArtWorksMedium(worksId, add_ids);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "作品管理", "作品媒介关系管理", "添加作品媒介关系：" + log.toString());
         setResponse("{exit:0}");
      }
      catch (Exception e) {
         e.printStackTrace();
         addMessage(getForm(), e.getMessage());
         return ADD;
      }
      return null;
   }

   public String deletePublication() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'deleteAuction' method");
      try {
         String[] id = ids.split(",");
         Integer[] del_ids = new Integer[id.length];
         StringBuffer log = new StringBuffer();
         for (int i = 0; i < del_ids.length; i++) {
            del_ids[i] = Integer.valueOf(id[i]);

            ArtWorksMedium artWorksMedium = artWorksMediumService.getArtWorksMedium(del_ids[i]);
            ArtLiteratureMedium artLiteratureMedium = artLiteratureMediumService.getArtLiteratureMedium(artWorksMedium.getMediumId());
            if (log.length() > 0) log.append(",");
            log.append(artLiteratureMedium.getLiteratureTitle());
         }
         artWorksMediumService.deleteArtWorksMediums(del_ids);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "作品管理", "作品媒介关系管理", "删除作品媒介关系：" + log.toString());
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

   @Resource
   private ArtLiteratureMediumResearchService artLiteratureMediumResearchService;

   @Resource
   private ArtLiteratureMediumService         artLiteratureMediumService;

   @Resource
   private ArtWorksMediumService              artWorksMediumService;

   @Resource
   private ArtSysLogService                   artSysLogService;

   @Resource
   private ArtWorksService                    artWorksService;

}
