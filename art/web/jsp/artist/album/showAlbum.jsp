<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp" %>
<script language="javascript">		
	var contextpath = "<%=CONTEXT_PATH%>";
	
	var fulllink = contextpath + "artist/ArtistAlbum.do";	
	
	var ret=new Object();

	function fresh() {  
		if(location.href.indexOf("?reload=true")<0)
			{
				location.href+="?reload=true";  
			}  
		}  
		setTimeout("fresh()",50);
	
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
		if(!checkFile()) return;
		if(!checkString(getElement('form.record.photoDesc'), "描述", 30, true)) return;
		return true;
	}
	
	function checkFile() {
		var isPass = true;
		$(".checkFile").each(function(){
			if(!checkString(this,"相片",400,true)) {
				isPass = false;
				return false;
			}
			var format = this.value.split(".");
			var i = format.length;
			if(format[i-1] != "jpg" && format[i-1] != "jpeg" && format[i-1] != "gif" && format[i-1] != "png"){
				alert("只能上传图片格式！");
				isPass = false;
				return false;
			}
		});
		return isPass;
	}
	
	function closedialog(ret) {
		if(ret=='true') {
			goSearch();
		}
		editMode="";
	}

	
	function init(){
		var img1 = document.getElementById("img1");
		var name = document.getElementById("name").value;
		var artistId = document.getElementById("artistId").value;
		img1.src="<%=CONTEXT_PATH%>upload/artist/album/"+artistId+"/"+name+"?rand=1";
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
	<s:form action="ArtistAlbum" id="ArtistAlbumForm" method="post" namespace="/artist"  enctype="multipart/form-data">
			<s:hidden name="record.name" id="name"/>
			<s:hidden name="record.artistId" id="artistId"/>
			<div id="formDiv" class="formDiv" style="padding:0px;">
			<img src="" id="img1"></img>
		 	</div>
</s:form>

<div id="btnDiv" class="btnDiv">
	 <gl:button name="btnAdd" onClick="goCancel()" >关闭</gl:button>
</div>

<%@include file="/common/resize.jsp" %>
<%@include file="/common/dialog.jsp"%>

</body>
</html>