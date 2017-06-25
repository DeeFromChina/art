<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp" %>
<script language="javascript">		
	var contextpath = "<%=CONTEXT_PATH%>";
	
	var fulllink = contextpath + "artist/ArtistDonation.do";	
	
	function goCancel(){
		parent.closedialog('false');
		
	}


	
	function init(){
		showMessage('<s:property value="errorMessage" escape="false"/>');
	}

	function goWorks(id){
		var url_link= contextpath + 'works/artWorks.do?action=EDIT&ids='+id;
	    openWindow("修改作品基本信息",url_link,0.8,0.8);
	}

	</script>
<style type="text/css"> 
   html, body {width:100%; height:100%; margin:0px; padding:0px; overflow:hidden;}
</style>
</head>
 
<body onload="init()">
	<s:form action="ArtistDonation" id="ArtistDonationForm" method="post" namespace="/artist">
			<s:hidden name="record.id" id="id"/>
			<s:hidden name="record.artistId" id="artistId"/>
			<div id="formDiv" class="formDiv" style="padding: 0px;">
			<table cellpadding="0" cellspacing="0" width="99%" class="formTable">
				<tr>
					<td width="15%"  class="textR">事件：</td>
					<td width="35%" class="textL"><s:property value="form.record.donationDesc" /> </td>
					<td class="textR" width="15%" >时间：</td>
					<td width="35%" class="textL">
						<s:property value="form.record.donationTime"  />
					</td>
				</tr>
				<tr>
					<td class="textR" valign="top">捐赠作品：</td>
					<td colspan="3" valign="top" class="textL">
					<s:if test="record.worksName == 1">
						<s:iterator value="cookies" id="co" status="coco">
							<a href="#" onclick="goWorks('${co.id}')">${co.name}</a>
						</s:iterator>
					</s:if>
					</td>
			    </tr> 
		 	</table>
	</div>
</s:form>

<div id="btnDiv" class="btnDiv">
	<gl:button name="btnAdd" onClick="goCancel()" >关闭</gl:button>
</div>

<%@include file="/common/resize.jsp" %>
<%@include file="/common/dialog.jsp"%>

</body>
</html>