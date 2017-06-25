<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp" %>
<script language="javascript">		
	
	var fulllink = contextpath + "artist/ArtistExperience.do";	
	
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
		if(!checkString(getElement('form.record.year'),"年份",30,true)) return;
		if(!checkString(getElement('form.record.cexperience'),"经历",30,true)) return;
		/* if(!checkString(getElement('form.record.eexperience'), "经历（英文）", 30, true)) return; */
		return true;
	}
	
	function closedialog(ret) {
		if(ret=='true') {
			goSearch();
		}
		editMode="";
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
	<s:form action="ArtistExperience" id="ArtistExperienceForm" method="post" namespace="/artist">
			<s:hidden name="record.artistId" id="artistId"/>
			<div id="formDiv" class="formDiv" style="padding: 0px;">
			<table cellpadding="0" cellspacing="0" width="99%" class="formTable">
				<tr>
					<td class="textR" width="15%" >年份：</td>
					<td class="textL" width="35%" ><s:property value="form.record.expeTime"/></td>
					<td colspan="3">&nbsp;</td>
				</tr>
				<tr>
					<td class="textR" valign="top">人生事件：</td>
					<td class="textL" colspan="4" ><s:property value="form.record.lifeExperience"/></td>
			    </tr> 
				<tr>
					<td class="textR" valign="top">历史事件：</td>
					<td class="textL" colspan="4" ><s:property value="form.record.historyExperience"/></td>
			    </tr> 
		 	</table>
	</div>
	<div id="page_1" style="padding:1px;"> </div>
	<div id="page_2" style="padding:1px;"> </div>
</s:form>

<div id="btnDiv" class="btnDiv">
	<gl:button name="btnAdd" onClick="goCancel()" >关闭</gl:button>
</div>

<%@include file="/common/resize.jsp" %>
<%@include file="/common/dialog.jsp"%>

</body>
</html>