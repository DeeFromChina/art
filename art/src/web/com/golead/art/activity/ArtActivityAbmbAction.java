package com.golead.art.activity;

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
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.struts2.StrutsStatics;

import com.golead.art.activity.model.ArtActivityAbmb;
import com.golead.art.activity.service.ArtActivityAbmbService;
import com.golead.art.artist.model.ArtCountry;
import com.golead.art.artist.service.ArtCountryService;
import com.golead.art.utils.PrintExcel;
import com.golead.art.utils.PrintPoint;
import com.golead.art.utils.QTool;
import com.golead.art.works.service.ArtSysLogService;
import com.golead.art.works.service.ArtWorksService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.util.ConvertUtil;
import com.golead.core.web.action.BaseAction;

/**
 * 艺博会
 * 
 * @author 尹湘
 * @version 1.0
 * @since 2016年9月22日 下午2:27:41
 */
public class ArtActivityAbmbAction extends BaseAction {

   private Log log = LogFactory.getLog(ArtActivityAbmbAction.class);

   @Override
   public String doExecute() throws Exception {
      String forward = "";
      String action = getForm().getAction();
      if (action == null) action = LIST;
      if (log.isDebugEnabled()) log.debug("action" + action);
      try {
         if (LIST.equalsIgnoreCase(action)) forward = sreachAbmb();
         else if (PAGE.equalsIgnoreCase(action)) forward = pageAbmb();
         else if (ADD.equalsIgnoreCase(action)) forward = addAbmb();
         else if (SAVE.equalsIgnoreCase(action)) forward = saveAbmb();
         else if (EDIT.equalsIgnoreCase(action)) forward = editAbmb();
         else if (UPDATE.equalsIgnoreCase(action)) forward = updateAbmb();
         else if (DELETE.equalsIgnoreCase(action)) forward = deleteAbmb();
         else if (VIEW.equalsIgnoreCase(action)) forward = viewAbmb();
         else if ("EXPORT".equalsIgnoreCase(action)) forward = export();
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         forward = ERROR;
      }
      return forward;
   }

   public void initForm() throws Exception {
   }
   
   public String sreachAbmb() throws Exception {
      return LIST;
   }

   public String pageAbmb() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'pageAbmb' method");
      try {
         PageQuery pageQuery = form.getQuery() == null ? new PageQuery() : form.getQuery();
         pageQuery = artActivityAbmbService.queryArtActivityAbmb(pageQuery);
         if (pageQuery != null) {
            List<Map<String, Object>> rs = pageQuery.getRecordSet();
            if (rs != null) {
               List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
               for (int i = 0; i < rs.size(); i++) {
                  Map<String, Object> abmb = rs.get(i);
                  Map<String, Object> map = new HashMap<String, Object>();
                  String[] artists = abmb.get("cName") == null ? null : abmb.get("cName").toString().split(",");
                  StringBuffer atr = new StringBuffer();

                  if(artists!=null) {
                     if (artists.length >= 2) {
                        atr.append(artists[0]).append(",").append(artists[1]).append("等");
                     } else {
                        atr.append(artists[0]);
                     }
                  }
                  String abmbYear = abmb.get("abmbYear") == null ? null : abmb.get("abmbYear") + "年";
                  String abmbMonth = abmb.get("abmbMonth") == null ? null : abmb.get("abmbMonth") + "月";
                  String abmbNumber = abmb.get("abmbNumber") == null ? null : "第" + abmb.get("abmbNumber") + "届";
                  String abmbTime = "";
                  if (abmbYear != null) {
                     abmbTime = abmbYear;
                  }
                  if (abmbMonth != null) {
                     abmbTime += abmbMonth;
                  }
                  map.put("id", abmb.get("id"));
                  String link = "^javascript:view(" + abmb.get("id") + ")^_self";
                  map.put("data",
                        new Object[] { "", atr.toString(),abmb.get("abmbName") + link, abmbNumber, abmb.get("sponsor"), abmb.get("artDirector"), abmbTime,
                              abmb.get("country"), abmb.get("city") });
                  list.add(map);
               }
               String res = genGridJson(pageQuery, list);
               artSysLogService.createArtSysLog(currentUser.getUserName(), "艺博会管理", "艺博会管理", "查询条件为：" + QTool.getParamter(pageQuery.getParameters()));
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

   public String addAbmb() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'addAbmb' method");
      try {
         return ADD;
      }
      catch (Exception e) {
         e.printStackTrace();
         return ERROR;
      }
   }

   public String saveAbmb() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'saveAbmb' method");
      try {
         ArtActivityAbmb abmb = new ArtActivityAbmb();
         ConvertUtil.mapToObject(abmb, form.getRecord(), false);
         artActivityAbmbService.createArtActivityAbmb(abmb);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "艺博会管理", "艺博会管理", "添加艺博会：" + abmb.getAbmbName());
         ids = abmb.getId().toString();
         form.getRecord().put("next","1");
         return editAbmb();
      }
      catch (Exception e) {
         addMessage(getForm(), e.getMessage());
         return ADD;
      }
   }

   public String editAbmb() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'editAbmb' method");
      try {
         ArtActivityAbmb abmb = artActivityAbmbService.getArtActivityAbmb(Integer.valueOf(ids));
         ConvertUtil.objectToMap(form.getRecord(), abmb);
         if (abmb.getCountryId() != null) {
            ArtCountry country = artCountryService.getArtCountry(abmb.getCountryId());
            form.getRecord().put("countryName", country.getCountryName());
         }
         return EDIT;
      }
      catch (Exception e) {
         e.printStackTrace();
         return ERROR;
      }
   }

   public String updateAbmb() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'updateAbmb' method");
      try {
         Map<String, String> record = form.getRecord();
         artActivityAbmbService.updateArtActivityAbmb(form.getRecord());
         artSysLogService.createArtSysLog(currentUser.getUserName(), "艺博会管理", "艺博会管理", "添加艺博会：" + record.get(ArtActivityAbmb.PROP_ABMB_NAME));
         return returnForward(RETURN_NORMAL);
      }
      catch (Exception e) {
         e.printStackTrace();
         return EDIT;
      }
   }

   public String deleteAbmb() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'deleteAbmb' method");
      try {
         String[] id = ids.split(",");
         Integer[] del_ids = new Integer[id.length];
         StringBuffer log = new StringBuffer();
         for (int i = 0; i < del_ids.length; i++) {
            del_ids[i] = Integer.valueOf(id[i]);
            ArtActivityAbmb abmb = artActivityAbmbService.getArtActivityAbmb(del_ids[i]);
            if(log.length()>0)log.append(",");
            log.append(abmb.getAbmbName());
         }
         artActivityAbmbService.deleteArtActivityAbmbs(del_ids);
         artSysLogService.createArtSysLog(currentUser.getUserName(), "艺博会管理", "艺博会管理", "删除艺博会：" + log.toString());
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

   public String viewAbmb() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'viewAbmb' method");
      String forward = null;
      try {
         ArtActivityAbmb abmb = artActivityAbmbService.getArtActivityAbmb(Integer.valueOf(ids));
         ConvertUtil.objectToMap(form.getRecord(), abmb);
         if (abmb.getCountryId() != null) {
            ArtCountry country = artCountryService.getArtCountry(abmb.getCountryId());
            form.getRecord().put("countryName", country.getCountryName());
         }
         String abmbYear = abmb.getAbmbYear() == null ? null : abmb.getAbmbYear() + "年";
         String abmbMonth = abmb.getAbmbMonth() == null ? null : abmb.getAbmbMonth() + "月";
         String abmbNumber = abmb.getAbmbNumber() == null ? "" : "第" + abmb.getAbmbNumber() + "届";
         String abmbTime = "";
         if (abmbYear != null) {
            abmbTime = abmbYear;
         }
         if (abmbMonth != null) {
            abmbTime += abmbMonth;
         }
         form.getRecord().put("abmbTime", abmbTime);
         form.getRecord().put("abmbNumber", abmbNumber);
         forward = "VIEW";
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("err", e);
         forward = "ERROR";
      }
      return forward;
   }

   public String export() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'export()' method");
      try {
         initForm();
         HttpServletResponse response = (HttpServletResponse) ctx.get(StrutsStatics.HTTP_RESPONSE);
         response.setContentType("APPLICATION/DOWNLOAD");
         response.setContentType("application/octed-stream,charset=gb2312");
         response.setHeader("Content-Disposition", "attachment;filename=" + new String("展览导出数据.xls".getBytes("gb2312"), "ISO-8859-1"));
         PageQuery pq = form.getQuery();
         HSSFWorkbook hssfWorkbook = artActivityAbmbService.export(form, pq);
         
         PrintExcel printExcel = new PrintExcel();
         
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
         artSysLogService.createArtSysLog(currentUser.getUserName(), "艺博会管理", "艺博会管理", "导出艺博会");
         printExcel.doPrint(response, null, hssfWorkbook);// workbook输出到response中。
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }
   
   @Resource
   private ArtActivityAbmbService artActivityAbmbService;

   @Resource
   private ArtCountryService      artCountryService;

   @Resource
   private ArtWorksService        artWorksService;
   
   @Resource
   private ArtSysLogService              artSysLogService;

}
