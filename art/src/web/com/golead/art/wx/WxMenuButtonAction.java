package com.golead.art.wx;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.golead.common.model.SysCode;
import com.golead.common.model.SysCodeset;
import com.golead.common.service.system.SysCodeService;
import com.golead.common.service.system.SysCodesetService;
import com.golead.common.web.system.SysCodeAction;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;
import com.golead.core.util.Const;
import com.golead.core.util.ConvertUtil;
import com.golead.core.web.UserSession;
import com.golead.core.web.action.BaseAction;
import com.golead.core.web.form.QueryForm;

public class WxMenuButtonAction extends BaseAction {

   private final Log log = LogFactory.getLog(SysCodeAction.class);

   @Override
   public String doExecute() throws Exception {
      String forward = "";
      String action = form.getAction();

      if (action == null) action = LIST;
      if (log.isDebugEnabled()) log.debug("action:" + action);
      try {
         if (LIST.equalsIgnoreCase(action)) forward = LIST;
         else if ("getTree".equalsIgnoreCase(action)) forward = getTreeNode();
         else if ("codeTree".equalsIgnoreCase(action)) forward = getCodeTree();
         else if ("CODELIST".equalsIgnoreCase(action)) forward = searchSysCodeGrid();
         else if (ADD.equalsIgnoreCase(action)) forward = addSysCode();
         else if (SAVE.equalsIgnoreCase(action)) forward = saveSysCode();
         else if (EDIT.equalsIgnoreCase(action)) forward = editSysCode();
         else if (UPDATE.equalsIgnoreCase(action)) forward = updateSysCode();
         else if (DELETE.equalsIgnoreCase(action)) forward = deleteSysCode();
      }
      catch (Exception e) {// 其他系统出错
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         forward = ERROR;
      }
      return forward;
   }

   private String getTreeNode() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'getTreeNode' mathod");

      try {
         HttpServletResponse response = ServletActionContext.getResponse();
         response.setContentType("text/xml;charset=UTF-8");
         response.setHeader("Cache_Control", "no-cache");

         getCategoryTree(response);

         response.getWriter().close();
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         return ERROR;
      }
      return null;
   }

   private void getCategoryTree(HttpServletResponse response) throws Exception {

      if (ids == null || "".equalsIgnoreCase(ids)) {
         Element root = DocumentHelper.createElement("tree").addAttribute("id", "0");
         Element topNode = root.addElement("item").addAttribute("text", "艺术云微信菜单").addAttribute("id", "root").addAttribute("open", "1");
         topNode.addAttribute("im0", "../icon/code_all.gif").addAttribute("im1", "../icon/code_all.gif").addAttribute("im2", "../icon/code_all.gif")
               .addAttribute("child", "1");
         topNode.addElement("userdata").addAttribute("name", "name").addText("系统代码");

         List<SysCodeset> Codesets = (List<SysCodeset>) sysCodesetService.findAllSysCodeset();
         List<Map<String, String>> categorys = new ArrayList<Map<String, String>>();
         for (SysCodeset Codeset : Codesets) {
            Map<String, String> map = new HashMap<String, String>();
            ConvertUtil.objectToMap(map, Codeset);
            categorys.add(map);
         }

         for (Map<String, String> category : categorys) {
            Element item = topNode.addElement("item");
            String id = category.get(SysCodeset.PROP_ID);
            String text = category.get(SysCodeset.PROP_CN_NAME);
            item.addAttribute("text", text).addAttribute("id", id);
            item.addAttribute("im0", "../icon/1-6.png").addAttribute("im1", "../icon/1-6.png").addAttribute("im2", "../icon/1-6.png");
            item.addElement("userdata").addAttribute("name", "name").addText(text);
         }

         response.getWriter().write("<?xml version='1.0' encoding='UTF-8' ?>");
         response.getWriter().write(root.asXML());
      }
   }

   private String getCodeTree() throws Exception {
      try {
         initForm(form, LIST);
         List<SysCode> codes = sysCodeService.findTreeCodes(Integer.valueOf(Codesetid));
         List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
         if (codes != null) {
            for (SysCode code : codes) {
               Map<String, Object> map = new HashMap<String, Object>();
               map.put("id", code.getId());
               String us = findCodeName(form, "START_STOP", code.getCodeStatus());

               map.put("data", new Object[] { code.getId(), code.getItemName(), code.getItemValue(), us, code.getRemark() });
               listmap.add(map);
            }

            String res = genGridXml(codes);
            setResponse(res);
         }
         else setResponse("{}");
      }
      catch (ServiceException e) {
         setResponse("{}");
      }
      catch (Exception e) {
         e.printStackTrace();
         setResponse("{}");
      }
      return null;
   }

   private String genGridXml(List<SysCode> codes) {
      StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?><rows>");
      for (SysCode sc : codes) {
         sb.append("<row>");

         sb.append("</row>");
      }
      sb.append("</rows>");
      return sb.append("</rows>").toString();
   }

   private String searchSysCodeGrid() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'searchSysCodeGrid' method");
      setCode(form, "START_STOP");
      try {
         SysCodeset scs = sysCodesetService.findSysCodeset(Integer.valueOf(Codesetid));
         List<SysCode> codes = sysCodeService.findCodeBySetId(Integer.valueOf(Codesetid));
         if (scs.getCsType() != null && scs.getCsType().equals("1")) return "CODETREE";
         List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
         if (codes != null) {
            for (SysCode code : codes) {
               Map<String, Object> map = new HashMap<String, Object>();
               map.put("id", code.getId());
               String us = findCodeName(form, "START_STOP", code.getCodeStatus());

               map.put("data", new Object[] { code.getId(), code.getItemName(), code.getItemValue(), us, code.getRemark() });
               listmap.add(map);
            }
            JSONArray jsonObject = JSONArray.fromObject(listmap);
            gridInfo = jsonObject.toString();
         }

      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         return ERROR;
      }
      return "CODELIST";
   }

   public String addSysCode() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'addSysCode' method");

      initForm(form, ADD);
      if (Codesetid != null && !"".equals(Codesetid)) {
         String name = sysCodesetService.findSysCodeset(Integer.parseInt(Codesetid)).getCnName();
         form.getRecord().put("CodesetName", name);
         form.getRecord().put(SysCode.PROP_CS_ID, Codesetid);
         form.getRecord().put("codeStatus", "1");
      }
      else {
         request.put("errMsg", "系统参数错误。");
         return ERROR;
      }
      return ADD;
   }

   public String saveSysCode() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'saveCodeset' method");

      try {
         SysCode sysCode = new SysCode();
         ConvertUtil.mapToObject(sysCode, form.getRecord(), false);
         UserSession user = (UserSession) session.get(Const.SESSION);
         if (currentUser != null) sysCode.setCreateby(user.getAccountName());
         sysCode.setItemName(form.getRecord().get("name"));
         sysCode.setItemValue(form.getRecord().get("value"));
         sysCode.setCreatedate(new Date());

         sysCodeService.createSysCode(sysCode);
         Codesetid = sysCode.getCsId().toString();
         return returnForward(RETURN_NORMAL);
      }
      catch (ServiceException e) {
         addMessage(form, e.getMessage());
         initForm(form, ADD);
         return ADD;
      }
      catch (Exception e) {
         e.printStackTrace();
         addMessage(form, "保存操作失败!");
         initForm(form, ADD);
         return ADD;
      }
   }

   public String editSysCode() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'editCodeset' method");

      initForm(form, EDIT);
      SysCode sysCode = sysCodeService.findSysCode(new Integer(ids));
      ConvertUtil.objectToMap(form.getRecord(), sysCode);
      String name = sysCodesetService.findSysCodeset(sysCode.getCsId()).getCnName();
      form.getRecord().put("codesetName", name);
      return EDIT;
   }

   public String updateSysCode() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'updateCodeset' method");

      try {

         SysCode sysCode = sysCodeService.findSysCode(new Integer(form.getRecord().get("id")));
         // 遇到异常重新返回编辑页面时CodesetName会丢失
         String name = sysCodesetService.findSysCodeset(sysCode.getCsId()).getCnName();
         form.getRecord().put("CodesetName", name);

         if (sysCode != null) {
            ConvertUtil.mapToObject(sysCode, form.getRecord(), true);
            UserSession user = (UserSession) session.get(Const.SESSION);
            if (user != null) sysCode.setModifyby(user.getAccountName());
            sysCode.setModifydate(new Date());
            sysCodeService.updateSysCode(sysCode);
            request.put("msg", "修改成功！");

            return returnForward(RETURN_NORMAL);
         }
         else {
            request.put("operstatus", "0");
            addMessage(form, "数据集记录不存在");
            return ERROR;
         }
      }
      catch (ServiceException e) {
         addMessage(form, e.getMessage());
         initForm(form, EDIT);
         return EDIT;
      }
      catch (Exception e) {
         e.printStackTrace();
         addMessage(form, "编辑操作失败");
         initForm(form, EDIT);
         return EDIT;
      }
   }

   public String deleteSysCode() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'deleteCodeset' method");

      try {
         if (ids != null && ids.trim().length() > 0) {
            sysCodeService.removeSysCodes(parseId(ids.split(",")));
         }
      }
      catch (Exception e) {
      }
      return searchSysCodeGrid();
   }

   private void initForm(QueryForm queryForm, String action) throws Exception {
      setCode(queryForm, "START_STOP");

      PageQuery query = new PageQuery();
      // query.setSelectParamId("GET_SYSCodeset_PAGE");
      query.getParameters().put("queryString", "");
      query.setPageSize("0");

      if ("ADD".equalsIgnoreCase(action)) {
         queryForm.getRecord().put("status", "1");
      }

      // List<Map<String, String>> Codesets =
      // sysCodeService.getSysCodesetsForTree(query).getRecordSet();
      // if (Codesets == null) {
      // Codesets = new ArrayList<Map<String, String>>();
      // }
      List<SysCodeset> Codesets = (List<SysCodeset>) sysCodesetService.findAllSysCodeset();
      setCode(queryForm, "Codesets", Codesets, SysCodeset.PROP_CN_NAME.toUpperCase(), SysCodeset.PROP_ID.toUpperCase(), false);
   }

   private java.io.Serializable[] parseId(String[] ids) throws Exception {
      if (ids == null || ids.length == 0) { throw new Exception("非法操作！"); }
      java.io.Serializable id[] = null;
      try {
         id = new Integer[ids.length];
         for (int i = 0; i < ids.length; i++) {
            id[i] = new Integer(ids[i]);
         }
      }
      catch (Exception e) {
         id = ids;
      }
      return id;
   }

   private String            Codesetid;

   private String            ids;

   private String            gridInfo;

   @Resource
   private SysCodeService    sysCodeService;

   @Resource
   private SysCodesetService sysCodesetService;

   public String getCodesetid() {
      return Codesetid;
   }

   public void setCodesetid(String Codesetid) {
      this.Codesetid = Codesetid;
   }

   @Override
   public void setIds(String ids) {
      this.ids = ids;
   }

   public String getGridInfo() {
      return gridInfo;
   }

}

