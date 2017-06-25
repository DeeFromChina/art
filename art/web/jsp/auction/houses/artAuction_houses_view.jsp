<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp" %>
<script language="javascript">		
	
	var fulllink = contextpath + "auction/ArtAuctionHouses.do";	

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
	<s:form action="ArtAuctionHouses" id="ArtAuctionHousesForm" method="post" namespace="/auction">
			<div id="formDiv" class="formDiv" style="padding: 0px;">
			<table cellpadding="0" cellspacing="0" width="99%" class="formTable">
				<tr>
					<td class="textR" width="15%" >拍卖行：</td>
					<td width="35%" class="textL"><s:property value="form.record.auctionHouse" /></td>
					<td class="textR" width="15%" >国家：</td>
					<td width="35%"  class="textL"><s:property value="form.record.nationality" /></td>
				</tr>
				<tr>
					<td class="textR" >地址：</td>
					<td  class="textL"><s:property value="form.record.addr" /></td>
					<td class="textR" >网址：</td>
					<td class="textL" ><s:property value="form.record.website" /></td>
				</tr>
				<tr>
					<td class="textR" valign="top">描述：</td>
					<td colspan="3"  style="height:60px" class="textL"><s:property value="form.record.remark" /></td>
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