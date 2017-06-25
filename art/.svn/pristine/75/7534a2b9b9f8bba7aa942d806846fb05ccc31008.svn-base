package com.golead.art.works;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;

import com.golead.art.artist.model.ArtArtist;
import com.golead.art.artist.model.ArtArtistWorksSeries;
import com.golead.art.artist.model.ArtCountry;
import com.golead.art.artist.service.ArtArtistService;
import com.golead.art.artist.service.ArtArtistWorksSeriesService;
import com.golead.art.artist.service.ArtCountryService;
import com.golead.art.utils.QTool;
import com.golead.art.works.model.ArtMedium;
import com.golead.art.works.model.ArtWorksStyle;
import com.golead.art.works.model.ArtWorksTheme;
import com.golead.art.works.service.ArtMediumService;
import com.golead.art.works.service.ArtSysLogService;
import com.golead.art.works.service.ArtWorksIdenService;
import com.golead.art.works.service.ArtWorksService;
import com.golead.art.works.service.ArtWorksStyleService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.web.action.BaseAction;

public class ArtWorksIdenAction extends BaseAction {

   private final Log                   logger        = LogFactory.getLog(ArtWorksIdenAction.class);

   @Resource
   private ArtArtistService            artArtistService;

   @Resource
   private ArtWorksService             artWorksService;

   @Resource
   private ArtWorksIdenService         artWorksIdenService;

   @Resource
   private ArtCountryService           artCountryService;

   @Resource
   private ArtWorksStyleService        artWorksStyleService;

   @Resource
   private ArtSysLogService            artSysLogService;

   @Resource
   private ArtMediumService            artMediumService;

   @Resource
   private ArtArtistWorksSeriesService artArtistWorksSeriesService;

   private SimpleDateFormat            sdf           = new SimpleDateFormat("yyyy-MM-dd");
   private DecimalFormat               decimalFormat = new DecimalFormat("#,###,###,###.##");
   private List<Map<String, String>>   artist        = new ArrayList<Map<String, String>>();
   private List<Map<String, String>>   works         = new ArrayList<Map<String, String>>();
   
   private String id;

   public List<Map<String, String>> getArtist() {
      return artist;
   }

   public void setArtist(List<Map<String, String>> artist) {
      this.artist = artist;
   }

   public List<Map<String, String>> getWorks() {
      return works;
   }

   public void setWorks(List<Map<String, String>> works) {
      this.works = works;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String doExecute() throws Exception {
      String forward = "";
      String action = form.getAction();

      if (action == null) action = LIST;
      if (logger.isDebugEnabled()) logger.debug("action:" + action);
      try {
         if (LIST.equalsIgnoreCase(action)) forward = LIST;
         else if ("ARTIST".equalsIgnoreCase(action)) forward = artist(); // 艺术家
         else if ("WORKS".equalsIgnoreCase(action)) forward = works(); // 艺术品
         else if ("IDEN".equalsIgnoreCase(action)) forward = iden();
         else if (PAGE.equalsIgnoreCase(action)) forward = page();
         else if ("GETTREE".equalsIgnoreCase(action)) forward = getTreeNode(); // 打开树
         else if ("TREE".equalsIgnoreCase(action)) forward = "TREE"; // 打开树
      }
      catch (Exception e) {// 其他系统出错
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         forward = ERROR;
      }
      return forward;
   }

   private String artist() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'artist' method");
      try {
         List<ArtArtist> artArtists = artArtistService.findAllArtArtist();
         for (ArtArtist artArtist : artArtists) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("id", artArtist.getId().toString());
            map.put("name", artArtist.getCname());
            artist.add(map);
         }
         return "ARTIST";
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         return ERROR;
      }
   }

   private String works() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'works' method");
      try {
         List<Map<String, Object>> artWorks = artWorksIdenService.groupByArtistId(form.getRecord().get("artistId"));
         for (Map<String, Object> work : artWorks) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", work.get("name").toString());
            works.add(map);
         }
         return "WORKS";
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         return ERROR;
      }
   }
   
   private String iden() throws Exception {
      try {
         initForm();
         return "IDEN";
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         return ERROR;
      }
   }

   private String page() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'getPageData' method");
      try {
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         PageQuery pageQuery = form.getQuery();
         String condition = form.getRecord().get("condition");
         if(condition != null && condition.length() > 0){
            condition = condition.replace(" ", "");
            String[] conditions = condition.split(",");
            for(int i = 0; i < conditions.length; i++){
               pageQuery.getParameters().put(conditions[i], conditions[i]);
            }
         }
         pageQuery = artWorksIdenService.queryArtWorks(pageQuery);
         if (pageQuery.getRecordSet() != null) {
            for (Map<String, Object> item : pageQuery.getRecordSet()) {
               Map<String, Object> map = new HashMap<String, Object>();
               if(!putToMap(map, item)){
                  throw new Exception();
               }
               list.add(map);
            }
         }
         String res = genGridJson(pageQuery, list);
//         artSysLogService.createArtSysLog(currentUser.getUserName(), "作品管理", "作品管理", "查询条件为：" + QTool.getParamter(pageQuery.getParameters()));
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

   public String getTreeNode() throws Exception {
      if (logger.isDebugEnabled()) logger.debug("Entering 'getTree' method");
      HttpServletResponse response = (HttpServletResponse) ctx.get(StrutsStatics.HTTP_RESPONSE);
      response.setContentType("text/xml;charset=UTF-8");
      response.setHeader("Cache_Control", "no-cache");
      try {
//         String id = returnString(form.getRecord().get("id"));
         if ("0".equals(id)) {
            response.getWriter().write(getTopNodes());
         }
         else if (isInteger(id)) {
            List<Map<String, Object>> artWorks = artWorksIdenService.groupByArtistId(id);
            response.getWriter().write(getDeptsNodes(artWorks, id));
         }
         response.getWriter().close();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   private String getDeptsNodes(List<Map<String, Object>> list, String id) {
      StringBuffer sb = new StringBuffer("");
      sb.append("<?xml version='1.0' encoding='UTF-8' ?>");
      sb.append("<tree id=\"" + id +"\">");
      for (Map<String, Object> map : list) {
         sb.append("<item id=\"" + map.get("name") + "\" text=\"" + map.get("name") + "\" im0=\"../icon/house_big.gif\" im1=\"../icon/house_big.gif\" im2=\"../icon/house_big.gif\">");
         sb.append("<userdata name=\"name\">" + map.get("name") + "</userdata>");
         sb.append("<userdata name=\"parentId\">" + id + "</userdata>");
         sb.append("</item>");
      }
      sb.append("</tree>");
      return sb.toString();
   }

   private String getTopNodes() {
      StringBuffer sb = new StringBuffer("");
      sb.append("<?xml version='1.0' encoding='UTF-8' ?>");
      sb.append("<tree id=\"0\">");
      List<ArtArtist> artArtists = artArtistService.findAllArtArtist();
      for(ArtArtist artArtist : artArtists){
         sb.append("<item id=\"" + artArtist.getId().toString() + "\" text=\"" + artArtist.getCname() + "\" im0=\"../icon/house_big.gif\" im1=\"../icon/house_big.gif\" im2=\"../icon/house_big.gif\" child=\"1\" >");
         sb.append("<userdata name=\"name\">" + artArtist.getCname() + "</userdata>");
         sb.append("<userdata name=\"parentId\">" + "" + "</userdata>");
         sb.append("</item>");
      }
      sb.append("</tree>");
      return sb.toString();
   }

   private boolean putToMap(Map<String, Object> map, Map<String, Object> item) throws Exception {
      try {
         String artistlink = "^javascript:artistview(" + item.get("artistId") + ");^_self";
         String worklink = "^javascript:workview(" + item.get("id") + ");^_self";
         String createTime = "";
         createTime = createTime(item, createTime);
         String worksIden = "";
         worksIden = worksIden(item, worksIden);
         String auctionTime = "";
         if (item.get("auctionTime") != null) {
            auctionTime = sdf.format(item.get("auctionTime"));
         }
         String flag = "";
         flag = flag(item, flag);
         String tmpStyle = "";
         tmpStyle(item, tmpStyle);
         String sizeCm = "";
         sizeCm = sizeCm(item, sizeCm);
         String sizeIn = "";
         sizeIn = sizeIn(item, sizeIn);
         String sizeRule = "";
         sizeRule = sizeRule(item, sizeRule);
         String str = "";
         str = str(item, str);
         String fakePaintings = returnString(item.get("fakePaintings"));
         fakePaintings = fakePaintings(item, fakePaintings);
         item.put("fakePaintings", fakePaintings);
         item.put("flag", flag);
         item.put("worksIden", worksIden);
         item.put("str", str);
         item.put("artistlink", artistlink);
         item.put("worklink", worklink);
         item.put("createTime", createTime);
         item.put("sizeCm", sizeCm);
         item.put("sizeIn", sizeIn);
         item.put("sizeRule", sizeRule);
         item.put("tmpStyle", tmpStyle);
         item.put("auctionTime", auctionTime);
         if(!itemToMap(map, item)){
            throw new Exception();
         }
      }
      catch (ServiceException e) {
         e.printStackTrace();
         return false;
      }
      return true;
   }

   private boolean itemToMap(Map<String, Object> map, Map<String, Object> item) throws Exception {
      try {
         map.put("id", item.get("id"));
         map.put(
               "data",
               new Object[] { "", item.get("worksIden"), item.get("fakePaintings"), item.get("flag"), item.get("str"), item.get("no"),
                     returnString(item.get("c_name")) + returnString(item.get("artistlink")),
                     returnString(item.get("chineseName")) + returnString(item.get("worklink")), item.get("englishName"), item.get("createTime"),
                     item.get("sizeCm"), item.get("sizeIn"), item.get("sizeRule"), findCodeName(form, "SIGNATURE", returnString(item.get("signature"))),
                     item.get("signatureContent"), findCodeName(form, "MEDIUM", returnString(item.get("mediumMaterial"))),
                     findCodeName(form, "MEDIUM", returnString(item.get("mediumShape"))),
                     findCodeName(form, "WORKSSERIES", returnString(item.get("worksSeries"))),
                     findCodeName(form, "COUNTRY", returnString(item.get("createCountry"))) + "" + returnString(item.get("createPlace")), item.get("tmpStyle"),
                     item.get("auctionTime"), item.get("auctionHouse"), decimalFormatString(item.get("lowestPrice")),
                     decimalFormatString(item.get("highestPrice")), decimalFormatString(item.get("tranPrice")), decimalFormatString(item.get("tradePrice")) });
      }
      catch (ServiceException e) {
         e.printStackTrace();
         return false;
      }
      return true;
   }

   public void initForm() throws Exception {
      setCode(form, "SIGNATURE");
      List<ArtMedium> mediums = artMediumService.findAll();
      setCode(form, "MEDIUM", mediums, ArtMedium.PROP_MEDIUM_NAME, ArtMedium.PROP_ID, true);
      List<ArtCountry> artCountries = artCountryService.findAll();
      setCode(form, "COUNTRY", artCountries, ArtCountry.PROP_COUNTRY_NAME, ArtCountry.PROP_ID, true);
      List<ArtArtistWorksSeries> artArtistWorksSeries = artArtistWorksSeriesService.findAll();
      setCode(form, "WORKSSERIES", artArtistWorksSeries, ArtArtistWorksSeries.PROP_SERIES_NAME, ArtArtistWorksSeries.PROP_ID, true);
      List<ArtWorksStyle> artWorksStyles = artWorksStyleService.findAll();
      setCode(form, "WORKSSTYLE", artWorksStyles, ArtWorksStyle.PROP_STYLE_NAME, ArtWorksStyle.PROP_ID, true);
      List<Map<String, Object>> condition = new ArrayList<Map<String,Object>>();
      String[] ids = new String[]{"createYear","sizeCm","sizeIn","sizeRule"};
      String[] conditions = new String[]{"创建年份","尺寸cm","尺寸in","尺寸rule"};
      for(int i = 0; i < conditions.length; i++){
         Map<String, Object> map = new HashMap<String, Object>();
         map.put("id", ids[i]);
         map.put("name", conditions[i]);
         condition.add(map);
      }
      setCode(form, "CONDITION", condition, "name", "id", false);
   }

   private String createTime(Map<String, Object> item, String createTime) {
      String createYear = returnString(item.get("createYear"));
      createTime = addString(createTime, createYear, "年");
      String createMonth = returnString(item.get("createMonth"));
      createTime = addString(createTime, createMonth, "月");
      String createDay = returnString(item.get("createDay"));
      createTime = addString(createTime, createDay, "日");
      return createTime;
   }

   private String flag(Map<String, Object> item, String flag) {
      if ("0".equals(item.get("repeatMarker"))) {
         flag = "否";
      }
      else {
         flag = "是";
      }
      return flag;
   }
   
   private String worksIden(Map<String, Object> item, String worksIden){
      if ("1".equals(item.get("worksIden"))) {
         worksIden = "已处理";
      }
      else {
         worksIden = "未处理";
      }
      return worksIden;
   }

   private String tmpStyle(Map<String, Object> item, String tmpStyle) {
      String styleType = returnString(item.get("styleType"));
      if (styleType != null && !"".equals(styleType)) {
         String[] styleTypes = styleType.split(";");
         for (int i = 0; i < styleTypes.length; i++) {
            ArtWorksStyle style = artWorksStyleService.getArtWorksStyle(Integer.valueOf(styleTypes[i]));
            tmpStyle += style.getStyleName() + ";";
         }
      }
      return tmpStyle;
   }

   private String sizeCm(Map<String, Object> item, String sizeCm) {
      String sizeCmWidth = decimalFormatString(item.get("sizeCmWidth") == null ? "" : item.get("sizeCmWidth").toString());
      String sizeCmHeight = decimalFormatString(item.get("sizeCmHeight") == null ? "" : item.get("sizeCmHeight").toString());
      String sizeCmLength = decimalFormatString(item.get("sizeCmLength") == null ? "" : item.get("sizeCmLength").toString());
      sizeCm = sizeCmLength + returnX(sizeCmLength, sizeCmWidth) + sizeCmWidth + returnX(sizeCmWidth, sizeCmHeight) + sizeCmHeight;
      if ("".equals(sizeCmWidth) && !"".equals(sizeCmHeight) && !"".equals(sizeCmLength)) {
         sizeCm = sizeCmLength + "X" + sizeCmHeight;
      }
      return sizeCm;
   }

   private String sizeIn(Map<String, Object> item, String sizeIn) {
      String sizeInWidth = decimalFormatString(item.get("sizeInWidth") == null ? "" : item.get("sizeInWidth").toString());
      String sizeInHeight = decimalFormatString(item.get("sizeInHeight") == null ? "" : item.get("sizeInHeight").toString());
      String sizeInLength = decimalFormatString(item.get("sizeInLength") == null ? "" : item.get("sizeInLength").toString());
      sizeIn = sizeInLength + returnX(sizeInLength, sizeInWidth) + sizeInWidth + returnX(sizeInWidth, sizeInHeight) + sizeInHeight;
      if ("".equals(sizeInWidth) && !"".equals(sizeInHeight) && !"".equals(sizeInLength)) {
         sizeIn = sizeInLength + "X" + sizeInHeight;
      }
      return sizeIn;
   }

   private String sizeRule(Map<String, Object> item, String sizeRule) {
      String sizeRuleWidth = decimalFormatString(item.get("sizeRuleWidth") == null ? "" : item.get("sizeRuleWidth").toString());
      String sizeRuleHeight = decimalFormatString(item.get("sizeRuleHeight") == null ? "" : item.get("sizeRuleHeight").toString());
      String sizeRuleLength = decimalFormatString(item.get("sizeRuleLength") == null ? "" : item.get("sizeRuleLength").toString());
      sizeRule = sizeRuleLength + returnX(sizeRuleLength, sizeRuleWidth) + sizeRuleWidth + returnX(sizeRuleWidth, sizeRuleHeight) + sizeRuleHeight;
      if ("".equals(sizeRuleWidth) && !"".equals(sizeRuleHeight) && !"".equals(sizeRuleLength)) {
         sizeRule = sizeRuleLength + "X" + sizeRuleHeight;
      }
      return sizeRule;
   }

   private String str(Map<String, Object> item, String str) {
      String enName = item.get("folderName") == null ? "" : item.get("folderName").toString();
      String thumbnail = returnString(item.get("thumbnail"));
      if (!thumbnail.equals("")) {
         thumbnail = request.get("CONTEXT_PATH") + "upload/auction/" + enName + "/" + "thumbnail" + "/" + thumbnail;
      }
      String thumbnail2 = request.get("CONTEXT_PATH") + "upload/auction/" + enName + "/" + returnString(item.get("thumbnail"));
      str = "<a href='" + thumbnail2 + "' target='_blank'><img src='" + thumbnail + "' /></a>";
      if ("".equals(returnString(item.get("thumbnail")))) {
         str = "暂无图片";
      }
      return str;
   }

   private String fakePaintings(Map<String, Object> item, String fakePaintings) {
      if (fakePaintings.equals("1")) {
         fakePaintings = "假画";
      }
      else {
         fakePaintings = "";
      }
      return fakePaintings;
   }

   private String returnX(String a, String b) {
      if (!"".equals(a) && !"".equals(b)) { return "X"; }
      return "";
   }

   private String decimalFormatString(Object object) {
      String str = object == null ? "" : object.toString().trim();
      if (!"".equals(str)) { return decimalFormat.format(Double.valueOf(str)); }
      return "";
   }

   private String returnString(Object object) {
      String str = object == null ? "" : object.toString();
      return str;
   }

   private String addString(String str, String equalStr, String addStr) {
      if (!"".equals(equalStr)) {
         if (equalStr.indexOf(addStr) > -1) return str + equalStr;
         else return str + equalStr + addStr;
      }
      return str;
   }
   
   private boolean isInteger(String id){
      try {
         if(id != null){
            Integer.valueOf(id);
            return true;
         }
      }
      catch (Exception e) {
         return false;
      }
      return false;
   }

}
