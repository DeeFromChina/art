package com.golead.art.artist;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.golead.art.works.model.ArtArtistWorksSeriesResearch;
import com.golead.art.works.model.ArtWorks;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.components.Else;

import com.golead.art.artist.model.ArtArtistWorksSeries;
import com.golead.art.artist.service.ArtArtistWorksSeriesService;
import com.golead.art.utils.FileUtils;
import com.golead.art.utils.PrintExcel;
import com.golead.art.utils.PrintPoint;
import com.golead.art.utils.QTool;
import com.golead.art.works.service.ArtArtistWorksSeriesResearchService;
import com.golead.art.works.service.ArtSysLogService;
import com.golead.art.works.service.ArtWorksService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.util.ConvertUtil;
import com.golead.core.web.action.BaseAction;

public class ArtistWorksSeriesAction extends BaseAction {

   private Log                                 log                   = LogFactory.getLog(ArtistWorksSeriesAction.class);

   public static String                        FILE_PATH             = ServletActionContext.getServletContext().getRealPath("");
   private File                                files;
   private String                              filesFileName;

   private final String                        REPRESENTATIVE        = "REPRESENTATIVE";

   private final String                        REPRESENTATIVE_PAGE   = "REPRESENTATIVE_PAGE";

   private final String                        REPRESENTATIVE_ADD    = "REPRESENTATIVE_ADD";

   private final String                        REPRESENTATIVE_DELETE = "REPRESENTATIVE_DELETE";

   private final String                        REPRESENTATIVE_SAVE   = "REPRESENTATIVE_SAVE";

   private final String                        SERIESWORKSPAGE       = "SERIES_WORKS_PAGE";

   private String                              cellImgFormat         = "<a href='%s' target='_blank'><img src='%s' /></a>";

   private String                              thumbnailPathFormat   = "%supload/auction/%s/thumbnail/%s";

   private String                              imgPathFormat         = "%supload/auction/%s/%s";

   @Resource
   private ArtArtistWorksSeriesService         artArtistWorksSeriesService;

   @Resource
   private ArtArtistWorksSeriesResearchService artArtistWorksSeriesResearchService;

   @Resource
   private ArtWorksService                     artWorksService;

   @Resource
   private ArtSysLogService                    artSysLogService;

   @Override
   public String doExecute() throws Exception {
      String forward = "";
      String action = getForm().getAction();
      initForm();
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
         else if (VIEW.equalsIgnoreCase(action)) forward = viewExperience();
         else if ("IMPORT".equalsIgnoreCase(action)) forward = importExperience();
         else if ("DOWNLOAD".equalsIgnoreCase(action)) forward = downloadTemplate();

         else if (REPRESENTATIVE.equalsIgnoreCase(action)) forward = representative();
         else if (REPRESENTATIVE_PAGE.equalsIgnoreCase(action)) forward = representativePage();
         else if (REPRESENTATIVE_ADD.equalsIgnoreCase(action)) forward = representativeAdd();
         else if (REPRESENTATIVE_SAVE.equalsIgnoreCase(action)) forward = representativeSave();
         else if (REPRESENTATIVE_DELETE.equalsIgnoreCase(action)) forward = representativeDelete();
         else if (SERIESWORKSPAGE.equalsIgnoreCase(action)) forward = seriesWorksPage();

      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         forward = ERROR;
      }
      return forward;
   }

   /**
    * 系列代表作列表
    */
   public String representative() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'representative()' method");
      return REPRESENTATIVE;
   }

   /**
    * 系列代表作列表数据
    */
   public String representativePage() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'representativePage()' method");
      try {
         PageQuery pageQuery = form.getQuery();
         pageQuery = artArtistWorksSeriesResearchService.queryArtArtistWorksSeriesResearch(pageQuery);
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         for (Map<String, Object> item : pageQuery.getRecordSet()) {
            String folderName = item.get("folderName").toString();
            String thumbnail;
            String cell;
            if (item.get("thumbnail") != null) {
               thumbnail = item.get("thumbnail").toString();
               String thumbnailPath = String.format(thumbnailPathFormat, request.get("CONTEXT_PATH"), folderName, thumbnail);
               String imgPath = String.format(imgPathFormat, request.get("CONTEXT_PATH"), folderName, thumbnail);
               cell = String.format(cellImgFormat, imgPath, thumbnailPath);
            }
            else {
               cell = "暂无图片";
            }
            String worksCName = item.get("worksCName") + "";
            String worksEName = item.get("worksEName") + "";
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", item.get("id"));
            map.put("data", new Object[] { "", cell, worksCName, worksEName });
            list.add(map);
         }
         String res = genGridJson(pageQuery, list);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "艺术家管理", "艺术家作品系列代表作管理", "查询条件为：" + QTool.getParamter(pageQuery.getParameters()));
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

   /**
    * 跳转到代表作候选列表
    */
   public String representativeAdd() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'representativeAdd()' method");
      return REPRESENTATIVE_ADD;
   }

   /**
    * 代表作候选列表数据
    */
   public String seriesWorksPage() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'representativeAdd()' method");
      try {
         PageQuery pageQuery = form.getQuery();
         pageQuery = artArtistWorksSeriesService.queryArtArtistSeriesWorks(pageQuery);
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         for (Map<String, Object> item : pageQuery.getRecordSet()) {
            String folderName = item.get("folderName").toString();
            String thumbnail;
            String cell;
            if (item.get("thumbnail") != null) {
               thumbnail = item.get("thumbnail").toString();
               String thumbnailPath = String.format(thumbnailPathFormat, request.get("CONTEXT_PATH"), folderName, thumbnail);
               String imgPath = String.format(imgPathFormat, request.get("CONTEXT_PATH"), folderName, thumbnail);
               cell = String.format(cellImgFormat, imgPath, thumbnailPath);
            }
            else {
               cell = "暂无图片";
            }
            String worksCName = item.get("worksCName") + "";
            String worksEName = item.get("worksEName") + "";
            String seriesName = item.get("seriesName") + "";
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", item.get("id"));
            map.put("data", new Object[] { "", seriesName, cell, worksCName, worksEName });
            list.add(map);
         }
         String res = genGridJson(pageQuery, list);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "艺术家管理", "艺术家作品系列候选代表作管理", "查询条件为：" + QTool.getParamter(pageQuery.getParameters()));
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

   /**
    * 保存代表作列表
    */
   public String representativeSave() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'representativeSave()' method");
      String seriesId = form.getRecord().get("seriesId");
      String[] worksIds = ids.split(",");
      StringBuffer log = new StringBuffer();
      ArtArtistWorksSeries artArtistWorksSeries = artArtistWorksSeriesService.getArtArtistWorksSeries(Integer.valueOf(seriesId));
      log.append(artArtistWorksSeries.getSeriesName() + ":" + "[");
      List<ArtArtistWorksSeriesResearch> artArtistWorksSeriesResearchList = new ArrayList<ArtArtistWorksSeriesResearch>();
      for (int i = 0; i < worksIds.length; i++) {
         ArtArtistWorksSeriesResearch artArtistWorksSeriesResearch = new ArtArtistWorksSeriesResearch();
         artArtistWorksSeriesResearch.setSeriesId(Integer.valueOf(seriesId));
         artArtistWorksSeriesResearch.setWorksId(Integer.valueOf(worksIds[i]));
         ArtWorks artWorks = artWorksService.getArtWorks(Integer.valueOf(worksIds[i]));
         if (log.length() > 0) log.append(",");
         log.append(artWorks.getWorksCName());
         artArtistWorksSeriesResearchList.add(artArtistWorksSeriesResearch);
      }
      log.append("]");
      artArtistWorksSeriesResearchService.createArtArtistWorksSeriesResearch(artArtistWorksSeriesResearchList);
      artSysLogService.createArtSysLog(currentUser.getUserName(), "艺术家管理", "艺术家作品系列代表作管理", "添加代表作：" + log.toString());
      return returnForward(RETURN_NORMAL);
   }

   /**
    * 删除系列代表作列表
    */
   public String representativeDelete() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'representativeDelete()' method");
      try {
         String[] id = ids.split(",");
         Integer[] del_ids = new Integer[id.length];
         StringBuffer log = new StringBuffer();
         for (int i = 0; i < id.length; i++) {
            del_ids[i] = Integer.valueOf(id[i]);
            if (log.length() > 0) log.append(",");
            log.append(del_ids[i]);
         }
         artSysLogService.createArtSysLog(currentUser.getUserName(), "艺术家管理", "艺术家作品系列代表作管理", "删除代表作：" + log.toString());
         artArtistWorksSeriesResearchService.deleteArtArtistWorksSeriesResearchs(del_ids);
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

   /**
    * 系列列表
    */
   public String list() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'list()' method");
      return LIST;
   }

   /**
    * 系列列表数据
    */
   public String page() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'pageExperience()' method");
      try {
         PageQuery pageQuery = form.getQuery();
         String artistId = getForm().getRecord().get("artistId");
         pageQuery.getParameters().put("artistId", artistId);
         pageQuery = artArtistWorksSeriesService.queryArtArtistWorksSeries(pageQuery);
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         for (Map<String, Object> item : pageQuery.getRecordSet()) {
            Map<String, Object> map = new HashMap<String, Object>();
            String important = this.findCodeName(form, "COMMENT_LEVEL", item.get("seriesImportant") + "");
            map.put("id", item.get("id"));
            map.put("data", new Object[] { "", item.get("seriesName"), item.get("appearYear"), important, item.get("seriesTheme"), item.get("seriesPeriod") });
            list.add(map);
         }
         String res = genGridJson(pageQuery, list);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "艺术家管理", "艺术家作品系列管理", "查询条件为：" + QTool.getParamter(pageQuery.getParameters()));
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

   /**
    * 跳转到添加系列
    */
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

   /**
    * 保存系列
    */
   public String save() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'save()' method");
      try {
         ArtArtistWorksSeries artArtistWorksSeries = new ArtArtistWorksSeries();
         ConvertUtil.mapToObject(artArtistWorksSeries, form.getRecord(), false);
         artArtistWorksSeriesService.createArtArtistWorksSeries(artArtistWorksSeries);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "艺术家管理", "艺术家作品系列管理", "添加系列：" + artArtistWorksSeries.getSeriesName());
         ids = artArtistWorksSeries.getId().toString();
         return edit();
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

   /**
    * 修改系列
    */
   public String edit() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'edit()' method");
      String forward = null;
      try {
         int id = Integer.valueOf(ids);
         ArtArtistWorksSeries artArtistWorksSeries = artArtistWorksSeriesService.getArtArtistWorksSeries(id);
         ConvertUtil.objectToMap(getForm().getRecord(), artArtistWorksSeries);
         return EDIT;
      }
      catch (Exception e) {
         e.printStackTrace();
         forward = ERROR;
      }
      return forward;
   }

   /**
    * 更新系列
    */
   public String update() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'update()' method");
      try {
         Map<String, String> record = getForm().getRecord();
         artArtistWorksSeriesService.updateArtArtistWorksSeries(record);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "艺术家管理", "艺术家作品系列管理", "更新系列：" + record.get(ArtArtistWorksSeries.PROP_SERIES_NAME));
         return returnForward(RETURN_NORMAL);
      }
      catch (Exception e) {
         addMessage(form, e.getMessage());
         initForm();
         return EDIT;
      }
   }

   /**
    * 删除系列
    */
   public String delete() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'delete()' method");
      try {
         StringBuffer log = new StringBuffer();
         String[] id = ids.split(",");
         Integer[] del_ids = new Integer[id.length];
         for (int i = 0; i < id.length; i++) {
            del_ids[i] = Integer.valueOf(id[i]);
            ArtArtistWorksSeries artArtistWorksSeries = artArtistWorksSeriesService.getArtArtistWorksSeries(del_ids[i]);
            if (log.length() > 0) log.append(",");
            log.append(artArtistWorksSeries.getSeriesName());
         }
         artArtistWorksSeriesService.deleteArtArtistWorksSeriess(del_ids);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "艺术家管理", "艺术家作品系列管理", "删除系列：" + log.toString());
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

   public String viewExperience() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'viewExperience()' method");
      try {
         //         ArtArtistExperience artArtistExperience = artArtistExperienceService.getArtArtistExperience(Integer.valueOf(ids));
         //         ConvertUtil.objectToMap(getForm().getRecord(), artArtistExperience);
      }
      catch (Exception e) {
         e.printStackTrace();
         return ERROR;
      }
      return VIEW;
   }

   public String importExperience() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'importExperience()' method");
      try {
         artSysLogService.createArtSysLog(currentUser.getUserName(), "艺术家管理", "艺术家作品系列管理", "导入系列");
         if (files != null) {
            File file = new File(FILE_PATH + File.separator + "template" + File.separator + "artist" + File.separator + "experience");
            if (!file.exists()) {
               file.mkdirs();
            }
            String path = FILE_PATH + File.separator + "template" + File.separator + "artist" + File.separator + "experience" + File.separator + filesFileName;
            FileUtils.fileUpload(path, files);
            int artistId = Integer.valueOf(getForm().getRecord().get("artistId"));
            String message = artArtistWorksSeriesService.importFile(path, artistId);
            if (!"".equals(message)) {
               if (message.startsWith("成功")) {
                  request.put("msg", message);
               }
               else {
                  throw new Exception(message);
               }
            }
            return returnForward(RETURN_NORMAL);
         }
         else return "IMPORT";
      }
      catch (Exception e) {
         e.printStackTrace();
         if (e.getMessage() != null) {
            addMessage(getForm(), e.getMessage());
         }
         return "IMPORT";
      }
   }

   public String downloadTemplate() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'downloadTemplate()' method");
      try {
         artSysLogService.createArtSysLog(currentUser.getUserName(), "艺术家管理", "艺术家作品系列管理", "下载系列模板列表");
         HttpServletResponse response = (HttpServletResponse) ctx.get(StrutsStatics.HTTP_RESPONSE);
         response.setContentType("APPLICATION/DOWNLOAD");
         response.setContentType("application/octed-stream,charset=gb2312");
         response.setHeader("Content-Disposition", "attachment;filename=" + new String("作品系列导入模板.xls".getBytes("gb2312"), "ISO-8859-1"));
         String templatePath = ServletActionContext.getServletContext().getRealPath("/template/artist/art_artist_worksSeries.xls");
         File templateFile = new File(templatePath);
         PrintExcel printExcel = new PrintExcel();
         InputStream inputStream = new FileInputStream(templateFile);
         HSSFWorkbook hssfWorkbook = null;
         POIFSFileSystem poifsFileSystem = new POIFSFileSystem(inputStream);
         hssfWorkbook = new HSSFWorkbook(poifsFileSystem);

         HSSFDataFormat format = hssfWorkbook.createDataFormat();

         HSSFCellStyle csString = hssfWorkbook.createCellStyle();
         csString.setBorderLeft(CellStyle.BORDER_THIN);
         csString.setBorderRight(CellStyle.BORDER_THIN);
         csString.setBorderTop(CellStyle.BORDER_THIN);
         csString.setBorderBottom(CellStyle.BORDER_THIN);
         csString.setAlignment(HSSFCellStyle.ALIGN_CENTER);
         csString.setDataFormat(format.getFormat("@"));

         HSSFCellStyle csDecimal = hssfWorkbook.createCellStyle();
         csDecimal.setBorderLeft(CellStyle.BORDER_THIN);
         csDecimal.setBorderRight(CellStyle.BORDER_THIN);
         csDecimal.setBorderTop(CellStyle.BORDER_THIN);
         csDecimal.setBorderBottom(CellStyle.BORDER_THIN);
         csDecimal.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));

         HSSFCellStyle csDecimal1 = hssfWorkbook.createCellStyle();
         csDecimal1.setBorderLeft(CellStyle.BORDER_THIN);
         csDecimal1.setBorderRight(CellStyle.BORDER_THIN);
         csDecimal1.setBorderTop(CellStyle.BORDER_THIN);
         csDecimal1.setBorderBottom(CellStyle.BORDER_THIN);
         HSSFDataFormat csformat = hssfWorkbook.createDataFormat();
         csDecimal1.setDataFormat(csformat.getFormat("0.000"));

         List<PrintPoint> printPoints = new ArrayList<PrintPoint>();

         printExcel.setPrintPointList(printPoints);// 填写数据
         printExcel.doFillSheet(hssfWorkbook, 0);// 写入workbook的第一页
         printExcel.doPrint(response, templateFile, hssfWorkbook);// workbook输出到response中。
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   public void initForm() throws Exception {
      setCode(form, "COMMENT_LEVEL");
   }

   public File getFiles() {
      return files;
   }

   public void setFiles(File files) {
      this.files = files;
   }

   public String getFilesFileName() {
      return filesFileName;
   }

   public void setFilesFileName(String filesFileName) {
      this.filesFileName = filesFileName;
   }

}
