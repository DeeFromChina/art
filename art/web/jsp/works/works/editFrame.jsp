<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<%@include file="/common/header.jsp" %>
<script language="javascript">	
	var contextpath = "<%=CONTEXT_PATH%>";
	var fulllink = contextpath + "works/artWorks.do";	
	var periodlink = contextpath + "works/artPeriod.do";	
	var evaluatelink = contextpath + "works/artEvaluate.do";	
	var caselink = contextpath + "works/artCase.do";	
	var somelink = contextpath + "works/artSome.do";	
	var exhibitlink = contextpath + "activity/ArtWorksExhibit.do";	
	var abmblink = contextpath + "works/ArtWorksAbmb.do";	
	var wordlink = contextpath + "works/ArtWorksWords.do";	
	var networklink = contextpath + "works/ArtWorksNetwork.do";	
	var mediumlink = contextpath + "works/artMedium.do";	
	var auctionlink = contextpath + "auction/ArtAuction.do";	
	var agencylink = contextpath + "works/ArtWorksAgency.do";	
	var serieslink = contextpath + "artist/ArtistWorksSeries.do";	
</script>
<style type="text/css"> 
   html, body {width:100%; height:100%; margin:0px; padding:0px; overflow-x:hidden;}
   fieldset{border : 1px solid #B0C4DE;}
</style>
<body>
<s:hidden name="record.id" id="id"/>
<s:hidden name="record.artistId" id="artistId"/>
<div>
        <fieldset>
		<legend>作品基本信息</legend>
		<iframe id="page_0" name="page_0" width="100%" height="1200px;" scrolling="no" frameborder="0"></iframe>
		</fieldset>


        <fieldset>
		<legend>作品时期</legend>
		<iframe id="page_1" name="page_1" width="100%" height="450px;" scrolling="no" frameborder="0"></iframe>
		</fieldset>
		
		<fieldset >
		<legend>意义与评价</legend>
		<iframe id="page_2" name="page_2" width="100%" height="450px;" scrolling="no" frameborder="0"></iframe>
		</fieldset>
		
		<fieldset >
		<legend>个案研究</legend>
		<iframe id="page_3" name="page_3" width="100%" height="450px;" scrolling="no" frameborder="0"></iframe>
		</fieldset>
		
		<fieldset >
		<legend>相关作品</legend>
		<iframe id="page_4" name="page_4" width="100%" height="450px;" scrolling="no" frameborder="0"></iframe>
		</fieldset>
		
		
		<fieldset >
		<legend>相关展览</legend>
		<iframe id="page_5" name="page_5" width="100%" height="450px;" scrolling="no" frameborder="0"></iframe>
		</fieldset>
		
		
		<fieldset >
		<legend>相关艺博会</legend>
		<iframe id="page_7" name="page_7" width="100%" height="450px;" scrolling="no" frameborder="0"></iframe>
		</fieldset>
		
		
		<fieldset >
		<legend>相关纸媒</legend>
		<iframe id="page_8" name="page_8" width="100%" height="450px;" scrolling="no" frameborder="0"></iframe>
		</fieldset>
		
		<fieldset >
		<legend>相关网媒</legend>
		<iframe id="page_9" name="page_9" width="100%" height="450px;" scrolling="no" frameborder="0"></iframe>
		</fieldset>
		
		<fieldset >
		<legend>相关音视频</legend>
		<iframe id="page_10" name="page_10" width="100%" height="450px;" scrolling="no" frameborder="0"></iframe>
		</fieldset>
		
		<fieldset >
		<legend>拍卖信息</legend>
		<iframe id="page_11" name="page_11" width="100%" height="450px;" scrolling="no" frameborder="0"></iframe>
		</fieldset>
		
		<fieldset >
		<legend>合作机构信息</legend>
		<iframe id="page_12" name="page_12" width="100%" height="450px;" scrolling="no" frameborder="0"></iframe>
		</fieldset>
</div>
</body>
<script language="javascript">
window.frames["page_0"].location.href=fulllink+'?action=EDIT&ids='+$$('id').value+'&record.artistId='+$$('artistId').value;
window.frames["page_1"].location.href=periodlink+'?action=LIST&record.id='+$$('id').value+'&record.artistId='+$$('artistId').value;
window.frames["page_2"].location.href=evaluatelink+'?action=LIST&record.id='+$$('id').value+'&record.artistId='+$$('artistId').value;
window.frames["page_3"].location.href=caselink+'?action=LIST&record.id='+$$('id').value+'&record.artistId='+$$('artistId').value;
window.frames["page_4"].location.href=somelink+'?action=LIST&record.id='+$$('id').value+'&record.artistId='+$$('artistId').value;
window.frames["page_5"].location.href=exhibitlink+'?action=LIST&query.parameters.worksId='+$$('id').value+"&record.type=1";
window.frames["page_7"].location.href=abmblink+'?action=LIST&query.parameters.worksId='+$$('id').value;
window.frames["page_8"].location.href=wordlink+'?action=LIST&query.parameters.worksId='+$$('id').value;
window.frames["page_9"].location.href=networklink+'?action=LIST&query.parameters.worksId='+$$('id').value;
window.frames["page_10"].location.href=mediumlink+'?action=LIST&query.parameters.worksId='+$$('id').value;
window.frames["page_11"].location.href=auctionlink+'?action=LIST&query.parameters.worksId='+$$('id').value+"&record.view=view";
window.frames["page_12"].location.href=agencylink+'?action=LIST&query.parameters.worksId='+$$('id').value;
</script>
</html>
