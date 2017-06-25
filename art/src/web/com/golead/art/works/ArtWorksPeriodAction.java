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

import com.golead.art.artist.model.ArtArtist;
import com.golead.art.artist.model.ArtArtistWorksPeriod;
import com.golead.art.artist.service.ArtArtistService;
import com.golead.art.artist.service.ArtArtistWorksPeriodService;
import com.golead.art.utils.FileUtils;
import com.golead.art.utils.PrintExcel;
import com.golead.art.utils.PrintPoint;
import com.golead.art.utils.QTool;
import com.golead.art.works.model.ArtWorks;
import com.golead.art.works.model.ArtWorksPeriod;
import com.golead.art.works.service.ArtSysLogService;
import com.golead.art.works.service.ArtWorksPeriodService;
import com.golead.art.works.service.ArtWorksService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.util.ConvertUtil;
import com.golead.core.web.action.BaseAction;

public class ArtWorksPeriodAction extends BaseAction {

   private final Log                 logger    = LogFactory.getLog(ArtWorksPeriodAction.class);

   private static final String       FILE_PATH = ServletActionContext.getServletContext().getRealPath("") + File.separator + "template" + File.separator
         + "works" + File.separator + "period";

   private List<Map<String, String>> cookie    = new ArrayList<Map<String, String>>();

   @Resource
   private ArtWorksPeriodService     artWorksPeriodService;

   @Resource
   private ArtWorksService           artWorksService;

   @Resource
   private ArtArtistService          artArtistService;

   @Resource
   ArtArtistWorksPeriodService       artArtistWorksPeriodService;

   @Resource
   private ArtSysLogService          artSysLogService;

   private File                      importFile;
   private String                    importFileFileName;
   private String                    importFileContentType;

   public String doExecute() throws Exception {
      String forward = "";
      String action = form.getAction();

      if (action == null) action = LIST;
      if (logger.isDebugEnabled()) logger.debug("action:" + action);
      try {
         initForm();
         if (LIST.equalsIgnoreCase(action)) forward = LIST;
         else if (PAGE.equalsIgnoreCase(action)) forward = getPageDate();
         else if (ADD.equalsIgnoreCase(action)) forward = addPeriod();
         else if (SAVE.equalsIgnoreCase(action)) forward = savePeriod();
         else if (EDIT.equalsIgnoreCase(action)) forward = editPeriod();
         else if (UPDATE.equalsIgnoreCase(action)) forward = updatePeriod();
         else if (VIEW.equalsIgnoreCase(action)) forward = view();
         else if (DELETE.equalsIgnoreCase(action)) forward = delete();
         else if ("GOEXCEL".equalsIgnoreCase(action)) forward = goExcel();
         else if ("EXCEL".equalsIgnoreCase(action)) forward = excel();
         else if ("DOWNLOAD".equalsIgnoreCase(action)) forward = download();
      }
      catch (Exception e) {// 其他系统出错
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         forward = ERROR;
      }
      return forward;
   }

   public void initForm() throws Exception {
      setCode(form, "ART_TYPE,DATE_YEAR,MEDIUM_TYPE,SIGNATURE,PERIOD_TYPE");
   }

   private String getPageDate() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'getPageDate' method");
      try {
         initForm();
         String id = form.getRecord().get("id");
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         PageQuery pageQuery = form.getQuery();
         pageQuery.getParameters().put("id", id);
         pageQuery = artWorksPeriodService.queryArtWorksPeriod(pageQuery);
         if (pageQuery.getRecordSet() != null) {
            for (Map<String, Object> item : pageQuery.getRecordSet()) {
               if (item.get("id") == null) {
                  break;
               }
               Map<String, Object> map = new HashMap<String, Object>();
               map.put("id", item.get("id"));
               map.put("data", new Object[] { "", findCodeName(form, "PERIOD_TYPE", item.get("periodType").toString()), item.get("periodName") });
               list.add(map);
            }
         }
         String res = genGridJson(pageQuery, list);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "作品管理", "作品时期管理", "查询条件为：" + QTool.getParamter(pageQuery.getParameters()));
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

   private String addPeriod() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'addWorks' method");
      String forward = null;
      try {
         initForm();
         //         List<ArtArtistWorksPeriod> periods = artArtistWorksPeriodService.findByArtistId(Integer.valueOf(form.getRecord().get("artistId")));
         List<ArtArtistWorksPeriod> periods = artArtistWorksPeriodService.findAllGroupPeriods();
         for (ArtArtistWorksPeriod period : periods) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", period.getPeriodName());
            map.put("id", period.getId().toString());
            map.put("type", period.getPeriodType());
            map.put("marquee", "0");
            if (period.getPeriodName().length() > 11) {
               map.put("marquee", "1");
            }
            cookie.add(map);
         }
         return ADD;
      }
      catch (Exception e) {
         e.printStackTrace();
         forward = ERROR;
      }
      return forward;
   }

   private String savePeriod() throws Exception {
      try {
         initForm();
         Map<String, String> record = form.getRecord();
         String periodName = record.get("periodName");
         artWorksPeriodService.createArtWorksPeriodAndArtArtistWorksPeriod(record);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "作品管理", "作品时期管理", "添加作品时期：" + "[" + periodName + "]");
         return returnForward(RETURN_NORMAL);
      }
      catch (Exception e) {
         addMessage(form, e.getMessage());
         initForm();
         return ADD;
      }
   }

   private String editPeriod() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'editWorks' method");
      String forward = null;
      try {
         initForm();
         String id = form.getRecord().get("id");
         ArtWorksPeriod artWorksPeriod = artWorksPeriodService.getArtWorksPeriod(Integer.valueOf(id));
         ConvertUtil.objectToMap(getForm().getRecord(), artWorksPeriod);
         ArtArtistWorksPeriod onePeriod = artArtistWorksPeriodService.findOneArtArtistWorksPeriod(form.getRecord());
         if (onePeriod != null) {
            form.getRecord().put("artistworksPeriodId", onePeriod.getId().toString());
         }
         else {
            form.getRecord().put("artistworksPeriodId", "");
         }
         List<ArtArtistWorksPeriod> periods = artArtistWorksPeriodService.findAllGroupPeriods();
         for (ArtArtistWorksPeriod period : periods) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", period.getPeriodName());
            map.put("id", period.getId().toString());
            map.put("type", period.getPeriodType());
            map.put("marquee", "0");
            if (period.getPeriodName().length() > 11) {
               map.put("marquee", "1");
            }
            cookie.add(map);
         }
         return EDIT;
      }
      catch (Exception e) {
         e.printStackTrace();
         forward = ERROR;
      }
      return forward;
   }

   private String updatePeriod() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'updateWorks' method");
      try {
         initForm();
         Map<String, String> record = form.getRecord();
         String periodName = record.get("periodName");
         artWorksPeriodService.updateArtWorksPeriod(record);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "作品管理", "作品时期管理", "添加作品时期：" + "[" + periodName + "]");
         return returnForward(RETURN_NORMAL);
      }
      catch (Exception e) {
         addMessage(form, e.getMessage());
         initForm();
         return EDIT;
      }
   }

   private String view() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'view' method");
      try {
         initForm();
         String id = form.getRecord().get("id");
         ArtWorks works = artWorksService.getArtWorks(Integer.valueOf(id));
         ConvertUtil.objectToMap(getForm().getRecord(), works);
         ArtArtist artist = artArtistService.getArtArtist(works.getArtistId());
         form.getRecord().put("artArtistName", artist.getCname());
         form.getRecord().put("artArtistId", artist.getId().toString());
         form.getRecord().put("chineseName", works.getWorksCName());
         form.getRecord().put("englishName", works.getWorksEName());
         form.getRecord().put("no", works.getWorksNo());
         String partSize = works.getPartSize();
         String[] partSizes = partSize.split(";");
         for (int i = 0; i < partSizes.length; i++) {
            Map<String, String> map = new HashMap<String, String>();
            String size = partSizes[i];
            String[] sizes = size.split("\\*");
            String partSize_l = sizes[0];
            String partSize_w = sizes[1];
            map.put("l_" + String.valueOf(i), partSize_l);
            map.put("w_" + String.valueOf(i), partSize_w);
            map.put("id", String.valueOf(i));
            //            partSizeList.add(map);
         }
      }
      catch (Exception e) {
         initForm();
         return ERROR;
      }
      return VIEW;
   }

   private String delete() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'delete' method");
      try {
//         String artistId = form.getRecord().get("artistId");
//         List<ArtArtistWorksPeriod> artArtistWorksPeriods = artArtistWorksPeriodService.findByArtistId(Integer.valueOf(artistId));
//         List<Map<String, String>> list = new ArrayList<Map<String, String>>();
//         for (ArtArtistWorksPeriod artistWorksPeriod : artArtistWorksPeriods) {
//            Map<String, String> map = new HashMap<String, String>();
//            map.put("periodName", artistWorksPeriod.getPeriodName());
//            map.put("periodType", artistWorksPeriod.getPeriodType());
//            map.put("id", artistWorksPeriod.getId().toString());
//            list.add(map);
//         }

//         List<ArtWorksPeriod> artWorksPeriods = new ArrayList<ArtWorksPeriod>();
         String[] idlist = ids.split(",");
         Integer[] dels = new Integer[idlist.length];
         for (int i = 0; i < idlist.length; i++) {
            dels[i] = Integer.valueOf(idlist[i]);
//            ArtWorksPeriod artWorksPeriod = artWorksPeriodService.getArtWorksPeriod(dels[i]);
//            artWorksPeriods.add(artWorksPeriod);
         }
//         int length = 0;
//         if (list.size() != 0) {
//            length = idlist.length;
//         }
//         Integer[] dels2 = new Integer[length];
         int i = 0;
//         for (Map<String, String> map : list) {
//            for (ArtWorksPeriod artWorksPeriod : artWorksPeriods) {
//               if (artWorksPeriod.getPeriodName().equals(map.get("periodName")) && artWorksPeriod.getPeriodType().equals(map.get("periodType"))) {
//                  dels2[i] = Integer.valueOf(map.get("id"));
//                  i++;
//               }
//            }
//         }
//         artArtistWorksPeriodService.deleteArtArtistWorksPeriods(dels2);
         StringBuffer log = new StringBuffer();
         for (int j = 0; j < dels.length; j++) {
            ArtWorksPeriod artWorksPeriod = artWorksPeriodService.getArtWorksPeriod(dels[i]);
            if (log.length() > 0) log.append(",");
            log.append(artWorksPeriod.getPeriodName());
         }
         artWorksPeriodService.deleteArtWorksPeriods(dels);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "作品管理", "作品时期管理", "删除作品时期：" + log.toString());
         setResponse("{exit:0}");
      }
      catch (Exception e) {
         e.printStackTrace();
         return ERROR;
      }
      return null;
   }

   private String goExcel() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'goExcel' method");
      try {
         return "GOEXCEL";
      }
      catch (Exception e) {
         e.printStackTrace();
         return LIST;
      }
   }

   private String excel() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'excel' method");
      try {
         String id = form.getRecord().get("id");
         File file = new File(FILE_PATH);
         if (!file.exists()) {
            file.mkdirs();
         }
         String path = FILE_PATH + File.separator + importFileFileName;
         FileUtils.fileUpload(path, importFile);
         String message = artWorksPeriodService.importArtWorksPeriod(path, Integer.valueOf(id));
         if (!"".equals(message)) {
            if (message.startsWith("成功")) {
               request.put("msg", message);
            }
            else {
               throw new Exception(message);
            }
         }
         return returnForward(message);
      }
      catch (Exception e) {
         e.printStackTrace();
         if (e.getMessage() != null) {
            addMessage(form, e.getMessage());
         }
         return "GOEXCEL";
      }
   }

   private String download() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'download' method");
      try {
         HttpServletResponse response = (HttpServletResponse) ctx.get(StrutsStatics.HTTP_RESPONSE);
         response.setContentType("APPLICATION/DOWNLOAD");
         response.setContentType("application/octed-stream,charset=gb2312");
         response.setHeader("Content-Disposition", "attachment;filename=" + new String("作品时期模板.xls".getBytes("gb2312"), "ISO-8859-1"));
         String tempPath = ServletActionContext.getServletContext().getRealPath("") + File.separator + "template" + File.separator + "works" + File.separator
               + "art_works_period.xls";
         File tempFile = new File(tempPath);
         if (!tempFile.exists()) { throw new Exception(); }

         PrintExcel printExcel = new PrintExcel();
         InputStream inp = null;
         inp = new FileInputStream(tempFile);
         HSSFWorkbook wb = null;
         POIFSFileSystem f = new POIFSFileSystem(inp);
         wb = new HSSFWorkbook(f);

         HSSFDataFormat format = wb.createDataFormat();

         HSSFCellStyle csString = wb.createCellStyle();
         csString.setBorderLeft(CellStyle.BORDER_THIN);
         csString.setBorderRight(CellStyle.BORDER_THIN);
         csString.setBorderTop(CellStyle.BORDER_THIN);
         csString.setBorderBottom(CellStyle.BORDER_THIN);
         csString.setAlignment(HSSFCellStyle.ALIGN_CENTER);
         csString.setDataFormat(format.getFormat("@"));

         HSSFCellStyle csDecimal = wb.createCellStyle();
         csDecimal.setBorderLeft(CellStyle.BORDER_THIN);
         csDecimal.setBorderRight(CellStyle.BORDER_THIN);
         csDecimal.setBorderTop(CellStyle.BORDER_THIN);
         csDecimal.setBorderBottom(CellStyle.BORDER_THIN);
         csDecimal.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));

         HSSFCellStyle csDecimal1 = wb.createCellStyle();
         csDecimal1.setBorderLeft(CellStyle.BORDER_THIN);
         csDecimal1.setBorderRight(CellStyle.BORDER_THIN);
         csDecimal1.setBorderTop(CellStyle.BORDER_THIN);
         csDecimal1.setBorderBottom(CellStyle.BORDER_THIN);
         HSSFDataFormat csformat = wb.createDataFormat();
         csDecimal1.setDataFormat(csformat.getFormat("0.000"));

         List<PrintPoint> printPointList = new ArrayList<PrintPoint>();

         printExcel.setPrintPointList(printPointList);// 填写数据
         printExcel.doFillSheet(wb, 0);// 写入workbook的第一页
         printExcel.doPrint(response, tempFile, wb);// workbook输出到response中。
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   public List<Map<String, String>> getCookie() {
      return cookie;
   }

   public void setCookie(List<Map<String, String>> cookie) {
      this.cookie = cookie;
   }

   public File getImportFile() {
      return importFile;
   }

   public void setImportFile(File importFile) {
      this.importFile = importFile;
   }

   public String getImportFileFileName() {
      return importFileFileName;
   }

   public void setImportFileFileName(String importFileFileName) {
      this.importFileFileName = importFileFileName;
   }

   public String getImportFileContentType() {
      return importFileContentType;
   }

   public void setImportFileContentType(String importFileContentType) {
      this.importFileContentType = importFileContentType;
   }

}
