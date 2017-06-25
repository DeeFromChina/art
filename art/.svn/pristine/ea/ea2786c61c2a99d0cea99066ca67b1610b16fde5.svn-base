package com.golead.art.works;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.golead.art.activity.model.ArtAgency;
import com.golead.art.activity.service.ArtAgencyService;
import com.golead.art.artist.model.ArtArtist;
import com.golead.art.artist.model.ArtArtistCollector;
import com.golead.art.artist.service.ArtArtistCollectorService;
import com.golead.art.utils.FileUtils;
import com.golead.art.utils.PrintExcel;
import com.golead.art.utils.PrintPoint;
import com.golead.art.utils.QTool;
import com.golead.art.works.model.ArtWorks;
import com.golead.art.works.model.ArtWorksAgency;
import com.golead.art.works.service.ArtSysLogService;
import com.golead.art.works.service.ArtWorksAgencyService;
import com.golead.art.works.service.ArtWorksService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.util.ConvertUtil;
import com.golead.core.web.action.BaseAction;

public class ArtWorksAgencyAction extends BaseAction {

   private final Log logger = LogFactory.getLog(ArtWorksAgencyAction.class);

   @Override
   public String doExecute() throws Exception {
      String forward = "";
      String action = form.getAction();

      if (action == null) action = LIST;
      if (logger.isDebugEnabled()) logger.debug("action:" + action);
      try {
         if (LIST.equalsIgnoreCase(action)) forward = LIST;
         else if (PAGE.equalsIgnoreCase(action)) forward = page();
         else if (ADD.equalsIgnoreCase(action)) forward = add();
         else if (SAVE.equalsIgnoreCase(action)) forward = save();
         else if (EDIT.equalsIgnoreCase(action)) forward = edit();
         else if (UPDATE.equalsIgnoreCase(action)) forward = update();
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

   public String page() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering page() method");
      try {
         PageQuery pq = getForm().getQuery();
         pq = artWorksAgencyService.queryArtWorksAgency(pq);
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         for (Map<String, Object> item : pq.getRecordSet()) {
            Map<String, Object> map = new HashMap<String, Object>();
            String agencylink = "^javascript:agencyview(" + item.get("agencyId") + ");^_self";
            map.put("id", item.get("id"));
            map.put("data", new Object[] { "", item.get("agencyCName") + agencylink, item.get("collectTime"), item.get("collectDesc") });
            list.add(map);
         }
         String res = genGridJson(pq, list);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "作品管理", "作品信息管理", "查询条件为：" + QTool.getParamter(pq.getParameters()));
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
      if (logger.isDebugEnabled()) logger.debug("Entering 'add()' method");
      try {
         return ADD;
      }
      catch (Exception e) {
         e.printStackTrace();
         return ERROR;
      }
   }

   public String save() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'save()' method");
      try {
         ArtWorksAgency artWorksAgency = new ArtWorksAgency();
         ConvertUtil.convertToModel(artWorksAgency, form.getRecord());
         artWorksAgencyService.createArtWorksAgency(artWorksAgency);
         ArtWorks artWorks = artWorksService.getArtWorks(Integer.valueOf(form.getRecord().get("worksId")));
         ArtAgency artAgency = artAgencyService.getArtAgency(artWorksAgency.getAgencyId());
         artSysLogService.createArtSysLog(currentUser.getUserName(), "作品管理", "作品信息管理",
               "添加机构：" + artWorks.getWorksCName() + ":" + "[" + artAgency.getAgencyCName() + "]");
         return returnForward(RETURN_NORMAL);
      }
      catch (Exception e) {
         e.printStackTrace();
         return ERROR;
      }
   }

   public String edit() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'edit()' method");
      try {
         int id = Integer.valueOf(form.getRecord().get("id"));
         ArtWorksAgency artWorksAgency = artWorksAgencyService.getArtWorksAgency(id);
         ArtAgency artAgency = artAgencyService.getArtAgency(artWorksAgency.getAgencyId());
         ConvertUtil.objectToMap(form.getRecord(), artWorksAgency);
         form.getRecord().put("agencyName", artAgency.getAgencyCName());
         return EDIT;
      }
      catch (Exception e) {
         e.printStackTrace();
         return ERROR;
      }
   }

   public String update() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'update()' method");
      try {
         artWorksAgencyService.updateArtWorksAgency(form.getRecord());
         ArtWorks artWorks = artWorksService.getArtWorks(Integer.valueOf(form.getRecord().get("worksId")));
         ArtAgency artAgency = artAgencyService.getArtAgency(Integer.valueOf(form.getRecord().get("agencyId")));
         artSysLogService.createArtSysLog(currentUser.getUserName(), "作品管理", "作品信息管理",
               "修改机构：" + artWorks.getWorksCName() + ":" + "[" + artAgency.getAgencyCName() + "]");
         return returnForward(RETURN_NORMAL);
      }
      catch (Exception e) {
         e.printStackTrace();
         return ERROR;
      }

   }

   public String delete() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'delete()' method");
      try {
         String[] id = ids.split(",");
         Integer[] del_ids = new Integer[id.length];
         for (int i = 0; i < del_ids.length; i++) {
            del_ids[i] = Integer.valueOf(id[i]);
         }
         String log = artWorksAgencyService.findNameByIds(ids);
         artWorksAgencyService.deleteArtWorksAgencys(del_ids);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "作品管理", "作品信息管理", "删除机构：" + log.toString());
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
      if (logger.isDebugEnabled()) logger.debug("Entering 'view()' method");
      try {
         int id = Integer.valueOf(form.getRecord().get("id"));
         ArtWorksAgency artWorksAgency = artWorksAgencyService.getArtWorksAgency(id);
         ConvertUtil.objectToMap(form.getRecord(), artWorksAgency);
         return VIEW;
      }
      catch (Exception e) {
         e.printStackTrace();
         return ERROR;
      }
   }

   public String importCollect() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'importCollect()' method");
      try {
//         if (files != null) {
//            File file = new File(FILE_PATH + File.separator + "template" + File.separator + "artist" + File.separator + "collect");
//            if (!file.exists()) {
//               file.mkdirs();
//            }
//            String path = FILE_PATH + File.separator + "template" + File.separator + "artist" + File.separator + "collect" + File.separator + filesFileName;
//            FileUtils.fileUpload(path, files);
//            int artistId = Integer.valueOf(getForm().getRecord().get("artistId"));
//            String message = artArtistCollectorService.importCollects(path, artistId);
//            if (!"".equals(message)) {
//               if (message.startsWith("成功")) {
//                  artSysLogService.createArtSysLog(currentUser.getUserName(), "艺术家管理", "收藏家管理", "导入收藏家");
//                  request.put("msg", message);
//               }
//               else {
//                  throw new Exception(message);
//               }
//            }
//            return returnForward(RETURN_NORMAL);
//         }
//         else return "IMPORT";
      }
      catch (Exception e) {
         e.printStackTrace();
         if (e.getMessage() != null) {
            addMessage(getForm(), e.getMessage());
         }
         return "IMPORT";
      }
      return null;
   }

   public String downloadTemplate() throws Exception {
//      if (log.isDebugEnabled()) log.debug("Entering 'downloadTemplate()' method");
      try {
         HttpServletResponse response = (HttpServletResponse) ctx.get(StrutsStatics.HTTP_RESPONSE);
         response.setContentType("APPLICATION/DOWNLOAD");
         response.setContentType("application/octed-stream,charset=gb2312");
         response.setHeader("Content-Disposition", "attachment;filename=" + new String("收藏家导入模板.xls".getBytes("gb2312"), "ISO-8859-1"));
         String templatePath = ServletActionContext.getServletContext().getRealPath("/template/artist/art_artist_collect.xls");
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
         artSysLogService.createArtSysLog(currentUser.getUserName(), "艺术家管理", "收藏家管理", "下载收藏家模板");
         printExcel.doPrint(response, templateFile, hssfWorkbook);// workbook输出到response中。
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @Resource
   private ArtWorksAgencyService artWorksAgencyService;

   @Resource
   private ArtSysLogService      artSysLogService;
   
   @Resource
   private ArtWorksService      artWorksService;
   
   @Resource
   private ArtAgencyService      artAgencyService;
}
