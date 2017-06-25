<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/header.jsp"%>

<script language="javascript">  
var hyperlink = contextpath + "works/artMedium.do";
	var fulllink = contextpath + "works/artMedium.do";
	var fulllink_exhibit = contextpath + "literature/ArtLiteratureMedium.do";
	
	function view(id) {
	       var url_link=fulllink_exhibit+'?action=VIEW&record.id='+id;
	       editMode="VIEW";
	       openWindow("查看媒体信息",url_link,0.8,0.8);	
	}

	function goSelect()  {
		var id = findMultiSelected("添加",ArtistInformation_grid);
		if (id == "") return;
		var res = confirm("是否要添加媒体？");
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
			<s:hidden name="query.order" />
			<s:hidden name="query.orderDirection" />
			<s:hidden name="query.pageNumber" />
			<s:hidden name="query.recordCount" />
			<s:hidden name="query.pageCount" />
			<table width="100%" id="tbl" cellpadding="0" cellspacing="0" class="queryTable">
			<tbody>
				<tr>
					<td class="textL">
		  &nbsp;&nbsp;标题：<s:textfield style="width:200px;" name="query.parameters.literatureTitle" /> 
		  &nbsp;&nbsp;制作方：<s:textfield style="width:200px;" name="query.parameters.shotPeople" /> 
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
				var headAlign=[tLeft,tCenter,tCenter,tCenter];
   				grid.setHeader("#master_checkbox,标题,制作方,内容描述",null,headAlign);
   				grid.setInitWidthsP("5,35,25,35");
   				grid.setColAlign("center,center,center,center");
   				grid.setColTypes("ch,link,ro,ro");
   				grid.setColSorting("na,str,str,str");
   				gridSort("false,false,false,false");
   				grid.setSkin("dhx_terrace");
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