package com.golead.art.appManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.golead.art.utils.QTool;
import com.golead.art.works.service.ArtSysLogService;
import com.golead.art.works.service.ArtWorksFollowService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.web.action.BaseAction;

/**
 * 处理作品关注的Action
 */
public class AppWorksFollowAction extends BaseAction {

   @Override
   public String doExecute() throws Exception {
      String forward = "";
      String action = getForm().getAction();
      initForm();
      if (action == null) forward = LIST;
      try {
         if (LIST.equalsIgnoreCase(action)) forward = worksFollowList();
         else if (PAGE.equalsIgnoreCase(action)) forward = worksFollowPage();
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         return ERROR;
      }
      return forward;
   }

   private void initForm() {
      setCode(form, "DATE_YEAR");
      setCode(form, "DATE_MONTH");
   }

   /**
    * 作品关注列表页面
    */
   public String worksFollowList() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'worksFollowList()' method");
      return LIST;
   }

   /**
    * 作品关注列表数据
    */
   public String worksFollowPage() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'worksFollowPage()' method");
      try {
         PageQuery pageQuery = form.getQuery() == null ? new PageQuery() : form.getQuery();
         pageQuery = artWorksFollowService.queryArtWorksFollow(pageQuery);
         if (pageQuery != null) {
            List<Map<String, Object>> recordSet = pageQuery.getRecordSet();
            if (recordSet != null) {
               List<Map<String, Object>> gridRowList = new ArrayList<Map<String, Object>>();
               for (int i = 0; i < recordSet.size(); i++) {
                  Map<String, Object> map = recordSet.get(i);
                  Map<String, Object> row = new HashMap<String, Object>();
                  //拼接作品图片和缩略图的地址
                  String folderName = map.get("folderName").toString();
                  String thumbnailName = map.get("thumbnail").toString();
                  String thumbnailPath = String.format(thumbnailPathFormat, request.get("CONTEXT_PATH"),folderName, thumbnailName);
                  String imgPath = String.format(imgPathFormat, request.get("CONTEXT_PATH"),folderName,thumbnailName);
                  String cell = String.format(cellImgFormat, imgPath,thumbnailPath);
                  
                  row.put("id", map.get("id"));
                  row.put("data", new Object[] { 
                        ""
                        , cell
                        ,map.get("worksCName")
                        ,map.get("worksEName")
                        ,map.get("accountName")
                        ,dateFormat.format((Date)map.get("followTime"))
                  });
                  gridRowList.add(row);
               }
               String res = genGridJson(pageQuery, gridRowList);
               artSysLogService.createArtSysLog(currentUser.getUserName(), "App管理", "作品关注管理", "查询条件为：" + QTool.getParamter(pageQuery.getParameters()));
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

   private Log                    log       = LogFactory.getLog(AppWorksFollowAction.class);

   @Resource
   private ArtWorksFollowService  artWorksFollowService;
   
   @Resource
   private ArtSysLogService              artSysLogService;

   private DateFormat             dateFormat    = new SimpleDateFormat("yyyy-MM-dd");

   private String                 cellImgFormat   = "<a href='%s' target='_blank'><img src='%s' /></a>";

   private String                 thumbnailPathFormat = "%supload/auction/%s/thumbnail/%s";

   private String                 imgPathFormat   = "%supload/auction/%s/%s";
}
