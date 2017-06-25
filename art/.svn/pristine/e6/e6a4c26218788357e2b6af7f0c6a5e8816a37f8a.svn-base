package com.golead.art.publication;

import com.golead.art.activity.model.ArtAgency;
import com.golead.art.activity.service.ArtAgencyService;
import com.golead.art.publication.model.ArtPublication;
import com.golead.art.publication.model.ArtPublicationAgency;
import com.golead.art.publication.service.ArtPublicationAgencyService;
import com.golead.art.publication.service.ArtPublicationService;
import com.golead.art.utils.QTool;
import com.golead.art.works.service.ArtSysLogService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.web.action.BaseAction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JiaHu 2016/12/8.
 */
public class ArtPublicationagAencyAction extends BaseAction {

   private final Log                   logger = LogFactory.getLog(ArtPublicationagAencyAction.class);

   @Resource
   private ArtPublicationAgencyService artPublicationAgencyService;

   @Resource
   private ArtAgencyService            artAgencyService;

   @Resource
   private ArtPublicationService       artPublicationService;

   @Resource
   private ArtSysLogService            artSysLogService;

   final String                        link   = "^javascript:view(%s)^_self";

   @Override
   public String doExecute() throws Exception {
      String forward = "";
      String action = form.getAction();
      initForm();
      if (action == null) action = LIST;
      if (logger.isDebugEnabled()) logger.debug("action:" + action);
      try {
         if (LIST.equalsIgnoreCase(action)) forward = list();
         else if (PAGE.equalsIgnoreCase(action)) forward = page();
         else if (ADD.equalsIgnoreCase(action)) forward = add();
         else if ("ADD_PAGE".equalsIgnoreCase(action)) forward = addPage();
         else if (SAVE.equalsIgnoreCase(action)) forward = save();

         else if (VIEW.equalsIgnoreCase(action)) forward = view();
         else if (DELETE.equalsIgnoreCase(action)) forward = delete();
      }
      catch (Exception e) {// 其他系统出错
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         forward = ERROR;
      }
      return forward;
   }

   private String getValue(Map map, String key) {
      Object value = map.get(key);
      return value == null || "".equals(value) ? "" : value.toString();
   }

   private void initForm() {
      setCode(form, "AGENCY_TYPE");
   }

   public String list() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'list' method");
      return LIST;
   }

   public String page() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'page' method");
      try {
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         PageQuery pageQuery = form.getQuery();
         pageQuery = artPublicationAgencyService.queryArtPublicationAgency(pageQuery);
         if (pageQuery.getRecordSet() != null) {
            for (Map<String, Object> item : pageQuery.getRecordSet()) {
               Map<String, Object> map = new HashMap<String, Object>();
               String id = getValue(item, "id");
               String agencyId = getValue(item, "agencyId");
               String view = String.format(link, agencyId);
               String agencyCname = getValue(item, "agencyCname");
               String agencyEname = getValue(item, "agencyEname");
               String agencyName = agencyCname + "/" + agencyEname;
               String countryName = getValue(item, "countryName");
               String agencyType = findCodeName(form, "AGENCY_TYPE", getValue(item, "agencyType"));
               map.put("id", id);
               map.put("data", new Object[] { "", agencyName , countryName, agencyType });
               list.add(map);
            }
         }
         String res = genGridJson(pageQuery, list);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "出版物管理", "出版物相关机构管理", "查询条件为：" + QTool.getParamter(pageQuery.getParameters()));
         setResponse(res);
      }
      catch (ServiceException e) {
         e.printStackTrace();
         setResponse("{exit:1,message:\"" + e.getMessage() + "\"}");
      }
      catch (Exception e) {
         e.printStackTrace();
         setResponse("{exit:1,message:\"数据访问错误。\"}");
      }
      return null;
   }

   public String add() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'add' method");
      try {
         return ADD;
      }
      catch (Exception e) {
         e.printStackTrace();
         return ERROR;
      }
   }

   public String addPage() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'page' method");
      try {
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         PageQuery pageQuery = form.getQuery();
         pageQuery = artPublicationAgencyService.queryAgency(pageQuery);
         if (pageQuery.getRecordSet() != null) {
            for (Map<String, Object> item : pageQuery.getRecordSet()) {
               Map<String, Object> map = new HashMap<String, Object>();
               String id = getValue(item, "id");
               String view = String.format(link, id);
               String agencyCname = getValue(item, "agencyCname");
               String agencyEname = getValue(item, "agencyEname");
               String agencyName = agencyCname + "/" + agencyEname;
               String countryName = getValue(item, "countryName");
               String agencyType = findCodeName(form, "AGENCY_TYPE", getValue(item, "agencyType"));
               map.put("id", id);
               map.put("data", new Object[] { "", agencyName , countryName, agencyType });
               list.add(map);
            }
         }
         String res = genGridJson(pageQuery, list);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "出版物管理", "可关联的出版物相关机构", "查询条件为：" + QTool.getParamter(pageQuery.getParameters()));
         setResponse(res);
      }
      catch (ServiceException e) {
         e.printStackTrace();
         setResponse("{exit:1,message:\"" + e.getMessage() + "\"}");
      }
      catch (Exception e) {
         e.printStackTrace();
         setResponse("{exit:1,message:\"数据访问错误。\"}");
      }
      return null;
   }

   public String save() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'save' method");
      try {
         Map<String, String> record = form.getRecord();
         Integer publicationId = Integer.valueOf(record.get("publicationId"));
         ArtPublication artPublication = artPublicationService.getArtPublication(publicationId);
         String[] split = ids.split(",");
         List<ArtPublicationAgency> artPublicationAgencies = new ArrayList<ArtPublicationAgency>();
         StringBuffer log = new StringBuffer();
         log.append(artPublication.getPublicationName()).append(":").append("[");
         for (int i = 0; i < split.length; i++) {
            Integer agencyId = Integer.valueOf(split[i]);
            ArtPublicationAgency artPublicationAgency = new ArtPublicationAgency();
            artPublicationAgency.setAgencyId(agencyId);
            artPublicationAgency.setPublicationId(publicationId);
            artPublicationAgencies.add(artPublicationAgency);
            ArtAgency artAgency = artAgencyService.getArtAgency(agencyId);
            log.append(artAgency.getAgencyCName());
            if (i != split.length - 1) log.append(",");
         }
         log.append("]");
         artPublicationAgencyService.createArtPublicationAgency(artPublicationAgencies);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "出版物管理", "出版物相关机构管理", "添加出版物相关机构" + log.toString());
         return returnForward(RETURN_NORMAL);
      }
      catch (Exception e) {
         addMessage(form, e.getMessage());
         initForm();
         return ADD;
      }
   }

   public String delete() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'delete' method");
      try {
         String[] split = ids.split(",");
         Integer[] idArray = new Integer[split.length];
         StringBuffer log = new StringBuffer();
         for (int i = 0; i < split.length; i++) {
            idArray[i] = Integer.valueOf(split[i]);
            ArtPublicationAgency artPublicationAgency = artPublicationAgencyService.getArtPublicationAgency(idArray[i]);
            ArtAgency artAgency = artAgencyService.getArtAgency(artPublicationAgency.getAgencyId());
            ArtPublication artPublication = artPublicationService.getArtPublication(artPublicationAgency.getPublicationId());
            log.append(artPublication.getPublicationName()).append(":").append(artAgency.getAgencyCName());
            if (log.length() > 0) log.append(",");
         }
         artPublicationAgencyService.deleteArtPublicationAgencys(idArray);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "出版物管理", "出版物相关机构管理", "删除出版物相关机构" + log.toString());
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

   public String view() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'view' method");
      return VIEW;
   }

}
