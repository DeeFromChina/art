<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/config/tag/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/config/tag/struts-template.tld" prefix="template"%>
<%@ taglib uri="/WEB-INF/config/tag/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/config/tag/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/config/tag/gw-tag.tld" prefix="gw" %>
<%
	String path = request.getContextPath();
	String CONTEXT_PATH = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
  <meta http-equiv="Content-Type" content="text/HTML; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=CONTEXT_PATH%>css/main.css" />
	<style type="text/css">
    .highlight{ color:#CC0000; font-weight:bold; }
		.btn{ width:80px;height:30px; padding:0 12px; line-height:28px; font-size:15px; outline:none; border-color:#CCCCCC #999999 #999999 #CCCCCC; border-width:1px; border-style:solid; background:url(<%=CONTEXT_PATH%>pages/dynamicquery/searchEngine/btn_bg.jpg) repeat-x; font-weight:bold;vertical-align:middle;}
</style>
	</head>
	<body >
	<html:form  method="post" action="/querycfg/columnSynthesisCfg.do">
		<div style="height:650px;padding: 3px 3px 0px 3px;overflow-y:auto;">
	 <table id="tblForm" cellpadding="0" cellspacing="0" class="formTable" style="text-algin:left;height:650px"  >
			  <tbody>
			 <tr align="left">
			    <td style="width:10%">发件人：</td>
				  <td width="40%" style="text-align:left;width:40%"> <bean:write name="emailFrom"/></td>
			    <td style="width:10%">发送时间：</td>
					<td width="40%" style="text-align:left;width:40%"> <bean:write name="emailSendDate"/></td>
			</tr>
			<tr align="left">
			   <td >收件人：</td>
				 <td  style="text-align:left;"> <bean:write name="emailTo"/> </td>
			   <td >抄送人：</td>
				 <td  style="text-align:left;"> <bean:write name="emailCc" filter="false"/></td>
			</tr>
			<tr >
			   <td >主题：</td>
				 <td colspan="3" style="text-align:left;"> <b><bean:write name="emailSubject" filter="false"/></b></td>
			</tr>
			<tr align="left">
					<td> 状态： </td>
					<td  style="text-align:left;" colspan="3"> <bean:write name="flag" filter="false"/> </td>
			</tr>
			<tr>
			   <td >附件：</td>
				 <td colspan="3" style="text-align:left;"> <bean:write name="emailAttachPath" filter="false"/> </td>
			</tr>
			<tr rowspan="3" style="height:100%" >
			   <td style="vertical-align:top;">内容：</td>
				 <td colspan="3" style="text-align:left;vertical-align:top;font-size:14px;"> <bean:write name="emailContent" filter="false"/> </td>
			</tr>
        </tbody>
	 </table>
	</div>
	<div style="height:70px;padding: 10px 3px 0px 3px;text-align:center;">
		<input type="button" onclick="window.close();" value="关闭" class="btn"/>
	</div>
	 </html:form>
	</body>
</html>
