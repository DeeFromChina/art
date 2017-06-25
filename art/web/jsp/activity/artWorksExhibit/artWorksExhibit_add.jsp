<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/header.jsp"%>

<script language="javascript">  
	var hyperlink = "../activity/ArtWorksExhibit.do";
	var fulllink = contextpath + "activity/ArtWorksExhibit.do";

	function goSelect()  {
		var id = findMultiSelected("添加",ArtistInformation_grid);
		if (id == "") return;
		var res = confirm("是否要添加展览？");
		if (res == true){
			var data=ajaxSubmit(fulllink+"?action=SAVE&ids=" +  id,"ArtistInformationForm");
	 		if(data.exit>0){
	 			  alert(data.message);
	 			  return;
	 		}
	 		else {	
	 			parent.closedialog(true);
	 		} 
		}
	}
	
	function renew()  {
		var order = getElement("query.order");                  order.value="";
		var desc = getElement("query.orderDirection");          desc.value="";
		var pn = getElement("query.pageNumber");                pn.value="1";
		var ps = getElement("query.pageSize");                  ps.value="10";
	    goSearch();
	}

	function closedialog(ret){
	    if(ret==true || ret=='true') {
	   		goSearch();
	    }
		editMode="";
	}
	
	function goSearch(){
		pageAction = '?action=ADDPAGE';
		goArtistInformationGridSearch();
		/* var data=ajaxSubmit(fulllink+"?action=ADDPAGE","ArtistInformationForm");
 		if(data.exit>0){
 			  alert(data.message);
 			  return;
 		}
 		else {	  
 			ArtistInformation_grid.clearAll();
 			ArtistInformation_grid.parse(data,'json');
 			ArtistInformation_grid.checkAll(false);
 		}  */
	}
	
	function init(){
		showMessage('<s:property value="errorMessage" escape="false"/>');
		renew();
	} 
	
</script>

<style type="text/css">
html,body {
	width: 100%;
	height: 100%;
}
</style>
</head>

<body onload="init()">
	<div class="special-padding" id="mainDiv">
		<s:form action="ArtistInformation" id="ArtistInformationForm" method="post" enctype="multipart/form-data">
			<s:hidden name="record.worksId" id="worksId" />
			<s:hidden name="query.parameters.type" id="type" />
			<s:hidden name="query.order" />
			<s:hidden name="query.orderDirection" />
			<s:hidden name="query.pageNumber" />
			<s:hidden name="query.recordCount" />
			<s:hidden name="query.pageCount" />
			<table width="100%" id="tbl" cellpadding="0" cellspacing="0" class="queryTable">
			<tbody>
				<tr>
					<td class="textL">
		  &nbsp;&nbsp;展览名称：<s:textfield style="width:200px;" name="query.parameters.exhibitName" /> 
		  &nbsp;&nbsp;<gl:button name="btnQuery" onClick="goSearch()">查询</gl:button>
					</td>
				</tr>
			</tbody>
			</table>
			<table id="btn" width="99%" cellspacing="1" cellpadding="1" class="controlTable">
				<tr>
					<td>
						<gl:button styleClass="sbuBtnStyle" icon="delIcon" onClick="goSelect()">确定</gl:button>
					</td>
				</tr>
			</table>
			<gl:grid styleClass="pageTurn" id="ArtistInformation" page="true" form="ArtistInformationForm"  property="query" cellPadding="0" cellSpacing="0">
				var grid = new dhtmlXGridObject();
         	    grid.setImagePath(imagePath);
				var headAlign = [tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter];
				grid.setHeader("#master_checkbox,展览名称,机构,展览类别,国家,城市,年份,月份",null, headAlign);
				grid.setInitWidthsP("5,20,15,10,15,15,10,10");
				grid.setColAlign("center,center,center,center,center,center,center,center");
				grid.setColTypes("ch,ro,ro,ro,ro,ro,ro,ro");
				grid.setColSorting("na,str,str,str,str,str,str,str");
				grid.init();
				var gDiv = $$('ArtistInformation_box');
			</gl:grid>
		</s:form>
	</div>
	
<%@include file="/common/dialog.jsp"%>
<script type="text/javascript">
    if(window.addEventListener) {
 	     window.addEventListener("resize",goResize,false); 
    }
    else {
 	     window.attachEvent('onresize',goResize);
    }
    
	 var gDiv=window.document.getElementById('ArtistInformation_box');
	 var mDiv=window.document.getElementById('mainDiv');
	 var tDiv=window.document.getElementById('tbl');
	 var btn=window.document.getElementById('btn');
	    
    function goResize(){
   	 var he;
	    if(isIE()) he=window.document.body.offsetHeight; else he=window.innerHeight;

		 mDiv.style.height=he-42+"px";
		 gDiv.style.height=mDiv.offsetHeight-btn.offsetHeight-btn.offsetTop+1+"px";
		 tDiv.style.width=mDiv.offsetWidth-4+"px";
		 gDiv.style.width=mDiv.offsetWidth-6+"px";
	    btn.style.width=tDiv.offsetWidth+"px";
    }
    goResize();   
</script> 

</body>
</html>