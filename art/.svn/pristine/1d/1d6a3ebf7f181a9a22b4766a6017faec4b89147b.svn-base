<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp" %>
<script language="javascript">		
	var fulllink = contextpath + "artist/ArtPhoto.do";	

	function goCancel(){
		parent.closedialog('false');
		
	}

	
	function init(){
		showMessage('<s:property value="errorMessage" escape="false"/>');
	}
	
	 function a(e){
		  document.all.im.src = e.src;
		  document.all.img_div.style.left = 0;
		  document.all.img_div.style.top = 0;
		  document.all.img_div.style.display = "";
	  }
	  function b(){ 
		  document.all.img_div.style.left = 0;
		  document.all.img_div.style.top = 0;
		  document.all.img_div.style.display = "none";
	  }

	</script>
<style type="text/css"> 
   html, body {width:100%; height:100%; margin:0px; padding:0px; overflow:hidden;}
</style>
</head>
 
<body onload="init()">
	<s:form action="ArtPhoto" id="ArtPhotoForm" method="post" namespace="/artist" >
			<s:hidden name="record.id" id="id" />
			<s:hidden name="record.eName" id="eName" />
	 <div id="formDiv" class="formDiv" style="padding: 0px;">
			<table cellpadding="0" cellspacing="0" width="99%" class="formTable">
				<tr>
					<td width="15%" class="textR">艺术家：</td>
					<td width="35%" class="textL"><s:property value="record.artistName"  />
  	                </td>
					<td class="textR" width="15%">图片名称：</td>
					<td class="textL" width="35%"><s:property value="form.record.photoName"/></td>
				</tr>
				<tr>
					<td class="textR">类型：</td>
					<td class="textL"><s:property value="record.photoType"  /></td>
					<td class="textR">时间：</td>
					<td class="textL">
						 <s:property value="record.photoTime"  />
					</td>
				</tr>
				<tr>
					<td class="textR">地点：</td>
					<td colspan="3" class="textL"><s:property value="form.record.photoAddr"/></td>
				</tr>
				<tr>
					<td class="textR">图片来源：</td>
					<td colspan="3" class="textL"><s:property value="form.record.photoSource"/></td>
					
				</tr>
				<tr>
					<td class="textR" valign="top">图片：</td>
					<td colspan="3" class="textL">
					   <img src="<%=CONTEXT_PATH%>upload/photo/<s:property value='record.attachment'/>" style="width: 80px;height: 80px;"  onmouseover="a(this)" onmouseout="b()"/>
					</td>
				</tr>
				<tr>
					<td class="textR" valign="top">描述：</td>
					<td colspan="3" class="textL" height="80px">
						<s:property value="record.photoDesc"/>
					</td>
				</tr>
		 	</table>
	</div>
</s:form>

<div id="btnDiv" class="btnDiv">
	<gl:button name="btnAdd" onClick="goSubmit()" >保存</gl:button>&nbsp;
	<gl:button name="btnAdd" onClick="goCancel()" >关闭</gl:button>
</div>

<%@include file="/common/resize.jsp" %>
<%@include file="/common/dialog.jsp"%>

</body>
</html>