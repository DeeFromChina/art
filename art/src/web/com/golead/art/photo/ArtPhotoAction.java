package com.golead.art.photo;

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
import com.golead.art.artist.service.ArtArtistService;
import com.golead.art.photo.model.ArtPhoto;
import com.golead.art.photo.service.ArtPhotoService;
import com.golead.art.publication.model.ArtPublication;
import com.golead.art.publication.service.ArtPublicationService;
import com.golead.art.utils.PrintExcel;
import com.golead.art.utils.PrintPoint;
import com.golead.art.utils.QTool;
import com.golead.art.works.service.ArtSysLogService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.util.ConvertUtil;
import com.golead.core.web.action.BaseAction;

public class ArtPhotoAction extends BaseAction {

   private final Log                 logger    = LogFactory.getLog(ArtPhotoAction.class);

   private static final String       FILE_PATH = ServletActionContext.getServletContext().getRealPath("/upload/photo/");

   private List<Map<String, String>> cookie    = new ArrayList<Map<String, String>>();

   @Resource
   private ArtArtistService          artArtistService;

   @Resource
   private ArtPublicationService     artPublicationService;

   @Resource
   private ArtPhotoService           artPhotoService;

   @Resource
   private ArtSysLogService          artSysLogService;

   private File                      files;
   private String                    filesFileName;
   private String                    filesContentType;

   public String doExecute() throws Exception {
      String forward = "";
      String action = form.getAction();

      if (action == null) action = LIST;
      if (logger.isDebugEnabled()) logger.debug("action:" + action);
      try {
         initForm();
         if (LIST.equalsIgnoreCase(action)) forward = LIST;
         else if (PAGE.equalsIgnoreCase(action)) forward = getPageDate();
         else if (ADD.equalsIgnoreCase(action)) forward = add();
         else if (SAVE.equalsIgnoreCase(action)) forward = save();
         else if (EDIT.equalsIgnoreCase(action)) forward = edit();
         else if (UPDATE.equalsIgnoreCase(action)) forward = update();
         else if ("ARTIST".equalsIgnoreCase(action)) forward = artist();
         else if ("PUBLICATION".equalsIgnoreCase(action)) forward = publication();
         else if (VIEW.equalsIgnoreCase(action)) forward = view();
         else if (DELETE.equalsIgnoreCase(action)) forward = delete();
         else if ("GOEXCEL".equalsIgnoreCase(action)) forward = goExcel();
         else if ("EXCEL".equalsIgnoreCase(action)) forward = excel();
         else if ("DOWNLOAD".equalsIgnoreCase(action)) forward = download();
         else if ("DOWNLOADFILE".equalsIgnoreCase(action)) forward = downloadFile();
      }
      catch (Exception e) {// 其他系统出错
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         forward = ERROR;
      }
      return forward;
   }

   public void initForm() throws Exception {
      setCode(form, "PHOTO_TYPE");
   }

   private String getPageDate() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'getPageDate' method");
      try {
         initForm();
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         PageQuery pageQuery = form.getQuery();
         pageQuery = artPhotoService.queryArtPhoto(pageQuery);
         if (pageQuery.getRecordSet() != null) {
            for (Map<String, Object> item : pageQuery.getRecordSet()) {
               Map<String, Object> map = new HashMap<String, Object>();
               String thumbnail = item.get("photo") == null ? "" : item.get("photo").toString();
               String src = "";
               String photo = item.get("photo") == null ? "" : item.get("photo").toString();
               if (photo.split("/").length > 1) {
                  photo = photo.split("/")[1];
               }
               if (!thumbnail.equals("")) {
                  src = request.get("CONTEXT_PATH") + "/upload/photo/" + item.get("folderName") + File.separator + photo;
                  thumbnail = request.get("CONTEXT_PATH") + "/upload/photo/" + item.get("folderName") + File.separator + "thumbnails" + File.separator + photo;
               }
               String photoType = item.get("photoType") == null ? "" : item.get("photoType").toString();
               map.put("id", item.get("id"));
               String photoTime = item.get("photoTime") == null ? "" : item.get("photoTime").toString();
               //               if (!"".equals(photoTime)) {
               //                  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
               //                  Date date = (Date) sdf.parse(photoTime);
               //                  photoTime = sdf.format(date);
               //               }
               String link = "^javascript:modify(" + item.get("id") + ");^_self";
               String str = "<a href='" + src + "' target='_blank'><img src='" + thumbnail + "' /></a>";
               if (thumbnail.equals("")) {
                  str = "暂无图片";
               }
               map.put("data", new Object[] { "", str, item.get("photoName") + link, item.get("cName"), photoTime, item.get("photoAddr"), item.get("photoDesc"),
                     item.get("photoSource"), findCodeName(form, "PHOTO_TYPE", photoType) });
               list.add(map);
            }
         }
         String res = genGridJson(pageQuery, list);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "照片管理", "照片管理", "查询条件为：" + QTool.getParamter(pageQuery.getParameters()));
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

   private String add() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'add' method");
      String forward = null;
      try {
         initForm();
         return ADD;
      }
      catch (Exception e) {
         e.printStackTrace();
         forward = ERROR;
      }
      return forward;
   }

   private String save() throws Exception {
      try {
         Map<String, String> record = form.getRecord();
         artPhotoService.createArtPhoto(record, files, filesFileName, FILE_PATH);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "照片管理", "照片管理", "添加照片：" + record.get(ArtPhoto.PROP_PHOTO_NAME));
         return returnForward(RETURN_NORMAL);
      }
      catch (Exception e) {
         addMessage(form, e.getMessage());
         initForm();
         return ADD;
      }
   }

   private String edit() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'edit' method");
      String forward = null;
      try {
         String id = form.getRecord().get("id");
         ArtPhoto artPhoto = artPhotoService.getArtPhoto(Integer.valueOf(id));
         ConvertUtil.objectToMap(form.getRecord(), artPhoto);
         ArtArtist artist = artArtistService.getArtArtist(artPhoto.getArtistId());
         if (artPhoto.getPubId() != null) {
            ArtPublication artPublication = artPublicationService.getArtPublication(artPhoto.getPubId());
            if (artPublication!=null) {
               form.getRecord().put("publicationName", artPublication.getPublicationName());
               form.getRecord().remove("artistId");
            }
         }
         else if (artPhoto.getArtistId() != null) {
            form.getRecord().put("artistName", artist.getCname());
         }
         form.getRecord().put("artistName", artist.getCname());
         form.getRecord().put("eName", artist.getEname());
         form.getRecord().put("photoPath", artist.getFolderName());
         String attachment = artPhoto.getPhoto();
         if (attachment != null) {
            String[] attachments = attachment.split(",");
            for (int i = 0; i < attachments.length; i++) {
               Map<String, String> map = new HashMap<String, String>();
               map.put("name", artPhoto.getPhotoName());
               map.put("saveName", attachments[i]);
               cookie.add(map);
            }
         }
         return EDIT;
      }
      catch (Exception e) {
         e.printStackTrace();
         forward = ERROR;
      }
      return forward;
   }

   private String update() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'update' method");
      try {
         Map<String, String> record = form.getRecord();
         artPhotoService.updateArtPhoto(record, files, filesFileName, FILE_PATH);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "照片管理", "照片管理", "修改照片：" + record.get(ArtPhoto.PROP_PHOTO_NAME));
         return returnForward(RETURN_NORMAL);
      }
      catch (Exception e) {
         e.printStackTrace();
         addMessage(form, e.getMessage());
         initForm();
         return EDIT;
      }
   }

   private String artist() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'artist' method");
      try {
         List<ArtArtist> artArtists = artArtistService.findAllArtArtist();
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         for (ArtArtist artArtist : artArtists) {
            Map<String, Object> map = new HashMap<String, Object>();
            ConvertUtil.objectToMap(map, artArtist);
            if ((";" + ids).indexOf(";" + map.get("id")) > -1) map.put("CHECKED", "checked");
            else map.put("CHECKED", "");
            list.add(map);
         }
         form.getQuery().setRecordSet(list);
         return "ARTIST";
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         return ERROR;
      }
   }

   private String publication() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'publication' method");
      try {
         List<ArtPublication> artPublications = artPublicationService.findAll();
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         for (ArtPublication artPublication : artPublications) {
            Map<String, Object> map = new HashMap<String, Object>();
            ConvertUtil.objectToMap(map, artPublication);
            if ((";" + ids).indexOf(";" + map.get("id")) > -1) map.put("CHECKED", "checked");
            else map.put("CHECKED", "");
            list.add(map);
         }
         form.getQuery().setRecordSet(list);
         return "PUBLICATION";
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         return ERROR;
      }
   }

   private String show() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'show' method");
      try {
         return "SHOW";
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         return ERROR;
      }
   }

   private String view() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'edit' method");
      String forward = null;
      try {
         return VIEW;
      }
      catch (Exception e) {
         e.printStackTrace();
         forward = ERROR;
      }
      return forward;
   }

   private String delete() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'delete' method");
      try {
         String[] idlist = ids.split(",");
         Integer[] dels = new Integer[idlist.length];
         StringBuffer log = new StringBuffer();
         for (int i = 0; i < idlist.length; i++) {
            dels[i] = Integer.valueOf(idlist[i]);
            ArtPhoto artPhoto = artPhotoService.getArtPhoto(Integer.valueOf(idlist[i]));
            if (log.length() > 0) log.append(",");
            log.append(artPhoto.getPhotoName());
         }
         artPhotoService.deleteArtPhotos(dels, FILE_PATH);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "照片管理", "照片管理", "删除照片：" + log.toString());
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
         //         String message = artWorksPeriodService.importArtWorksPeriod(path, Integer.valueOf(id));
         //         if(!"".equals(message)){
         //            if(message.startsWith("成功")){
         //               request.put("msg", message);
         //            }else{
         //               throw new Exception(message);
         //            }
         //         }
         //         return returnForward(message);
         return null;
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
         artSysLogService.createArtSysLog(currentUser.getUserName(), "照片管理", "照片管理", "下载照片导入模板");
         printExcel.doPrint(response, tempFile, wb);// workbook输出到response中。
      }
      catch (Exception e) {
         e.printStackTrace();
         setResponse("{exit:1,message:\"数据访问错误。\"}");
      }
      return null;
   }

   private String downloadFile() throws Exception {
      try {
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

   public String getFilesContentType() {
      return filesContentType;
   }

   public void setFilesContentType(String filesContentType) {
      this.filesContentType = filesContentType;
   }

}
