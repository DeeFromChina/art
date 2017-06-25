<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp" %>
<script language="javascript">		
	var fulllink = contextpath + "works/artCase.do";	

	function goCancel(){
		parent.closedialog('false');
	}

	function init(){
		showMessage('<s:property value="errorMessage" escape="false"/>');
	}
	
	
	</script>
<style type="text/css"> 
   html, body {width:100%; height:100%; margin:0px; padding:0px; overflow:hidden;}
</style>
</head>
 
<body onload="init()">
	<s:form action="artCase" id="artCaseForm" method="post" namespace="/works" >
			<s:hidden name="record.id" id="id"/>
			<s:hidden name="record.artistId" id="artistId"/>
			<s:hidden name="record.worksId" id="worksId"/>
			<div id="formDiv" class="formDiv" style="padding:0px;">
			<table cellpadding="0" cellspacing="0" class="formTable">
				<tr>
					<td width="25%" class="textR">个案名称：</td>
					<td width="75%" class="textL"><s:property value="record.caseName"/></td>
				</tr>
				<tr>
					<td width="25%" class="textR">作者：</td>
					<td width="75%" class="textL"><s:property value="record.caseAuther"/></td>
				</tr>
				<tr>
					<td width="25%" class="textR">时间：</td>
					<td width="75%" class="textL">
						<s:property value="record.caseTime"/>
					</td>
				</tr>
				<tr>
					<td width="25%" class="textR">研究主题：</td>
					<td width="75%" class="textL"><s:property value="record.researchTopic"/></td>
				</tr>
				<tr>
					<td class="textR" valign="top">内容：</td>
					<td colspan="3" valign="top" class="textL">
						<s:property value="record.caseContent" />
					</td>
				</tr>
				<tr>
					<td><font color="red">*</font>附件：</td>
					<td colspan="3" class="textL">
						<table  id="tblUpload" cellpadding="0" cellspacing="0" width="100%"  class="tbnBtnStyle" align="left">
							<s:iterator value="pic" id="p" status="pp">
								<tr>
								<td class="textL">
								    <a href="<%=CONTEXT_PATH%>upload/works/case/<s:property value='record.worksId'/>/${p.realName}" target="_blank" >${p.name}</a>
								</td>
								</tr>
							</s:iterator>
						</table>
					</td>
				</tr>
		 	</table>
		 </div>
</s:form>

<div id="btnDiv" class="btnDiv">
	 <gl:button name="btnAdd" onClick="goCancel()" >关闭</gl:button>
</div>

<script type="text/javascript"> 
 
</script>

<%@include file="/common/dialog.jsp"%>
<%@include file="/common/resize.jsp" %>
</body>
</html>