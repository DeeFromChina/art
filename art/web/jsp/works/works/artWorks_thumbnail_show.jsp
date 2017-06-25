<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp" %>
<script language="javascript">		
	var contextpath = "<%=CONTEXT_PATH%>";
	var fulllink = contextpath + "works/artCase.do";	
	var partSize;
	var i = 0;
	var ret=new Object();

	function goCancel(){
		parent.closedialog('false');
	}

	function goSubmit() {
		if(checkFormInput()){
		    var url =fulllink+"?action=SAVE";
		  	document.forms[0].action=url;
			document.forms[0].submit();
		} 
	}
	
	function checkFormInput(){
		if(!checkString(getElement('record.caseName'),"个案名称",30,true)) return;
		if(!checkString(getElement('record.caseAuther'),"作者",30,true)) return;
		if(!checkString(getElement('record.caseTime'),"时间",30,true)) return;
		if(!checkString(getElement('record.researchTopic'),"研究主题",30,true)) return;
		if(!checkString(getElement('record.caseContent'),"内容",30,true)) return;
		if(!checkFile()) return;
		return true;
	}
	
	function closedialog(ret) {
		var res=ret['ret'];
		if(ret=='true') {
			goSearch();
		}
		editMode="";
	}
	
	function init(){
		var img1 = document.getElementById("img1");
		var name = document.getElementById("name").value;
		var worksId = document.getElementById("worksId").value;
		img1.src="<%=CONTEXT_PATH%>upload/works/thumbnail/"+worksId+"/"+name;
		var width = img1.width;
		var height = img1.height;
		img1.width = width*0.5;
		img1.height = height*0.5;
		showMessage('<s:property value="errorMessage" escape="false"/>');
	}
	
	</script>
<style type="text/css"> 
   html, body {width:100%; height:100%; margin:0px; padding:0px; overflow:hidden;}
</style>
</head>
 
<body onload="init()">
	<s:form action="artCase" id="artCaseForm" method="post" namespace="/works"  enctype="multipart/form-data">
			<s:hidden name="record.name" id="name"/>
			<s:hidden name="record.artistId" id="artistId"/>
			<s:hidden name="record.worksId" id="worksId"/>
			<div id="formDiv" class="formDiv" style="padding:0px;">
			<img src="" id="img1"></img>
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