<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/header.jsp"%>
<script type="text/javascript">
	var hyperlink = "../appManager/appArtistPageTemplateManager.do";
	var fulllink = contextpath + "appManager/appArtistPageTemplateManager.do";
	
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
	
	function goAdd() {
		openWindow("添加模板", fulllink + '?action=ADD', 0.8, 0.8);
	}
	
	function goModify() {
		var id = findSelected("修改",appArtistPageTemplateManager_grid);
		if(id == "") return;
		openWindow("修改", fulllink + '?action=EDIT&ids='+id, 0.8, 0.8);
	}
	
	function goDel() {
		var id = findMultiSelected("删除",appArtistPageTemplateManager_grid);
		if(id == "") return;
		var res = confirm("是否真的要删除?");
		if(res == true) {
			var data = ajaxSubmit(fulllink + "?action=DELETE&ids=" + id, 'appArtistPageTemplateManagerForm');
			if (data.exit > 0) {
				alert(data.message);
				return;
			} else {
				goSearch();
			}
		}
	}
	
	function goOperation(id){
		openWindow("操作", fulllink + '?action=OPERATION&query.parameters.tempId='+id, 0.8, 0.8);
	}
	
	function goSearch(){
		goappArtistPageTemplateManagerGridSearch();
	}
	
	function init(){
		showMessage('<s:property value="errorMessage" escape="false"/>');
		renew();
	}
</script>

<style type="text/css">
html, body {
	width: 100%;
	height: 100%;
}
</style>
</head>
<body onload="init()">
	<div class="special-padding" id="mainDiv">
		<s:form action="appArtistPageTemplateManager" id="appArtistPageTemplateManagerForm"
			method="post" namespace="/appManager">
			<s:hidden name="query.order" />
			<s:hidden name="query.orderDirection" />
			<s:hidden name="query.pageNumber" />
			<s:hidden name="query.recordCount" />
			<s:hidden name="query.pageCount" />
			<table width="99%" id="tbl" cellpadding="0" cellspacing="0"
				class="queryTable"></table>
			<table id="btn" width="99%" cellspacing="1" cellpadding="1"
				class="controlTable">
				<tr>
					<td>
						<gl:button styleClass="sbuBtnStyle" icon="addIcon" onClick="goAdd()">添加模板</gl:button> 
						<gl:button styleClass="sbuBtnStyle" icon="subIcon" onClick="goModify()">修改模板</gl:button>
						<gl:button styleClass="sbuBtnStyle" icon="delIcon" onClick="goDel()">删除模板</gl:button>
					</td>
				</tr>
			</table>
			<gl:grid styleClass="pageTurn" id="appArtistPageTemplateManager" page="true"
				form="appArtistPageTemplateManagerForm" property="query" cellPadding="0"
				cellSpacing="0">
                var grid = new dhtmlXGridObject();
                grid.setImagePath(imagePath);
                var headAlign = [tCenter,tCenter,tCenter,tCenter,tCenter,tCenter];
                grid.setHeader("#master_checkbox,模板名称,创建人,创建时间,描述,操作",null, headAlign);
                grid.setInitWidthsP("5,20,10,10,45,10");
                grid.setColAlign("center,center,center,center,center,center");
                grid.setColTypes("ch,ro,ro,ro,ro,ro");
                grid.setColSorting("na,str,str,str,str,str");
                grid.init();
                var gDiv = $$('appArtistPageTemplateManager_box');
            </gl:grid>
		</s:form>
	</div>

	<%@include file="/common/dialog.jsp"%>
	<%@include file="/common/resizeList1.jsp"%>

</body>
</html>