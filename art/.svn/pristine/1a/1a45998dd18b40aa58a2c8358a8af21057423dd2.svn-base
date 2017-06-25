<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/header.jsp" %>
<script language="javascript">  
var hyperlink = "../literature/searchEngine.do";	
var fulllink = contextpath + "literature/searchEngine.do";	

function init(){
	showMessage('<s:property value="errorMessage" escape="false"/>');
	if(window.addEventListener) {
		window.addEventListener("resize",goResize,false); 
	}
	else {
		window.attachEvent('onresize',goResize);
	}

	goResize();
}

function goResize(){
	var he;
	if(isIE()) 
		he = window.document.body.offsetHeight; 
	else 
		he = window.innerHeight;
	
	var mDiv = $$("mainDiv");
	var btnDiv = $$("btnDiv");
	
	mDiv.style.height = he - btnDiv.offsetHeight + "px";
	btnDiv.style.width = mDiv.offsetWidth - 6 + "px";
	btnDiv.style.top = mDiv.offsetHeight + mDiv.offsetTop +"px";
}

function close(){
	dhxWins.window(winName).close();
}

function closedialog(ret){
   if(ret=='true') {
      
   }	
}

function goCancel(){
	parent.closedialog('false');
}

function goDownload(){
	gosearch("DOWNLOAD");
}

</script>

<style type="text/css">
   html, body {width:100%; height:100%; margin:0px; padding:0px; overflow:hidden;}
</style>
</head>

<body onload="init()" >
<div id="formDiv" class="formDiv">
		<s:form action="FullIndexQuery" id="FullIndexQueryForm" method="post" namespace="/literature" >
			<s:hidden id="docId" name="record.docId"></s:hidden>
			<table id="tblForm" cellpadding="0" cellspacing="0" width="99%" class="formTable">
				<tbody>
					<colgroup>
        				<col width=18%></col>
        				<col width=32%></col>
        				<col width=18%></col>
        				<col width=32%></col>
    				</colgroup>
					<tr>
						<td class="textR" ><b>文献标题：</b></td>
						<td class="textL" colspan="3" ><s:property value="record.fileName" /></td>
					</tr>
					<tr>
						<td class="textR" ><b>作者：</b></td>
						<td class="textL" ><s:property value="record.author" /></td>
						<td class="textR" ><b>发布时间：</b></td>
						<td class="textL" ><s:property value="record.time" /></td>
					</tr>
					<tr>
						<td class="textL" colspan="4">
							<s:property value="record.content" escape="false"></s:property></td>
					</tr>
				</tbody>
				</table>
		</s:form>
	</div>
	<div id="btnDiv" class="btnDiv">
		<gl:button name="btnCancel" onClick="goCancel()">关闭</gl:button>
		<gl:button name="btnCancel" onClick="goDownload()">下载</gl:button>
	</div>
</body>
<%@include file="/common/resize.jsp" %>
<%@include file="/common/dialog.jsp"%>
</html>