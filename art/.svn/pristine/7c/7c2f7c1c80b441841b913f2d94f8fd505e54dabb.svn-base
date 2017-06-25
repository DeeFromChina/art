<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <%@include file="/common/header.jsp" %>

	<script language="javascript">		
		var hyperlink = "../system/sysRole.do";
		var fulllink = contextpath + "system/sysRole.do";

		// 用于浏览该角色下的用户
		function view(id) {
			editMode="VIEW";
			openWindow("查看角色", fulllink + "?action=view&ids=" + id, 600, 440);
		}
		//用于浏览配置给该角色的权限
		function viewRight(id) {
			editMode="RIGHT";
			openWindow("查看权限", fulllink + "?action=viewRight&ids=" + id, 500, 300);
		}

   function goRights()  {
	    var id = findSelected("分配",role_grid);
	    if(id == "") return;
	    
	    var loader = dhx4.ajax.postSync(fulllink+'?action=CheckRole&ids='+id, "");
	    rights(loader,id);
   }

   function rights(loader,id)  {
   	  var str="";
   	  if (loader.xmlDoc.responseText != null) str = loader.xmlDoc.responseText;
   	  if(str==""||str=="ERROR") {
   	  	 alert("系统出错。");
   	     return;
   	  }
   	  else if(str=="Y"){
   	  	 alert("系统角色不能分配权限。");
   	     return;
   	  }
      
      //var url_link=fulllink+'?action=rights&ids='+id;
      var url_link=contextpath+'system/sysReource.do?action=roleRights&id='+id;
	  editMode="RIGHTS";
      openWindow("分配角色权限",url_link,300,450);	
   }
   
		function goDel() {
			var id = findMultiSelected("删除",role_grid);
			if(id == "") return;
			var res = confirm("是否真的要删除?");
			if(res == true) {
				var data=ajaxSubmit(fulllink+"?action=delete&ids=" + id,"roleForm");
		 		if(data.exit>0){
		 			  alert(data.message);
		 			  return;
		 		}
		 		else {	  
		 			goSearch();
		 		} 
			}
		}
		
		function goRowDblClick() {
			var btn = $$('btnModify');
			if(btn==null) {
				var id = findSelected("修改",role_grid);
				if(id == "") return;
				view(id);
			}
			else {
				goModify();
			}
		}
		
		function goModify() {
			var id = findSelected("修改",role_grid);
			if(id == "") return;
    		var urlink=fulllink+'?action=EDIT&ids='+id;
    		editMode="EDIT";
			openWindow("修改角色", urlink, 600, 300);
		}

		function goStart() {
			var id = findMultiSelected("启用",role_grid);
			if(id == "") return;
			var data=ajaxSubmit(fulllink+"?action=start&ids=" + id,"roleForm");
	 		if(data.exit>0){
	 			  alert(data.message);
	 			  return;
	 		}
	 		else {	  
	 			goSearch();
	 		}   
		}

		function goStop() {
			var id = findMultiSelected("暂停",role_grid);
			if(id == "") return;
			var data=ajaxSubmit(fulllink+"?action=stop&ids=" + id,"roleForm");
	 		if(data.exit>0){
	 			  alert(data.message);
	 			  return;
	 		}
	 		else {	  
	 			goSearch();
	 		}   
		}

		function goAdd() {
			editMode="ADD";
			openWindow("添加角色", fulllink+'?action=ADD', 600, 300);
		}

		function renew() {
			var order = getElement("query.order");                  order.value="";
			var desc =  getElement("query.orderDirection");         desc.value="";
			var pn =    getElement("query.pageNumber");             pn.value="1";
			var ps =    getElement("query.pageSize");               if(ps!=null) ps.value="10";
			var v0 =    getElement("query.parameters.roleCode");    v0.value="";
			var v1 =    getElement("query.parameters.roleName");    v1.value="";
			var v2 =    getElement("query.parameters.roleStatus");  v2.value="";
			goSearch();
		}

		function closedialog(ret) {
			if(ret=='true') {
				if(editMode=="RIGHTS") {
					alert("角色权限已经被修改。");
				}
				goSearch();
			}	
			editMode="";
		}
		
		function init(){
			renew(); 
		}

		function goSearch(){ 
			goroleGridSearch(); 
		}
	</script>

<style type="text/css">
   html, body {width:100%; height:100%;}
</style>
</head>

<body onload="init()">
<div class="special-padding"  id="mainDiv">  
<s:form action="sysRole" id="roleForm" method="post" namespace="/system">
<s:hidden name="query.order" />
<s:hidden name="query.orderDirection" />
<s:hidden name="query.pageNumber" />
<s:hidden name="query.recordCount" />
<s:hidden name="query.pageCount" />
	<table width="100%" id="tbl" cellpadding="0" cellspacing="0" class="queryTable">
	<tbody>
		<tr>
			<td class="textL">
  &nbsp;&nbsp;角色标识：<s:textfield style="width:100px;" name="query.parameters.roleCode" /> 
  &nbsp;&nbsp;角色名称：<s:textfield style="width:100px;" name="query.parameters.roleName" /> 
  &nbsp;&nbsp;是否启用：<s:select style="width:80px;" list="codeSets.START_OR_STOP" listKey="value" listValue="codeName" name="query.parameters.roleStatus"></s:select>
  &nbsp;&nbsp;<gl:button name="btnQuery" onClick="goSearch()">查询</gl:button>
			</td>
		</tr>
	</tbody>
	</table>
<table id="btn" width="100%" cellspacing="1" cellpadding="1" class="controlTable">
	<tr>
		<td>
				   <gl:button styleClass="sbuBtnStyle"  icon="addIcon" onClick="goAdd()">增加</gl:button>
			      <gl:button id="btnModify" styleClass="sbuBtnStyle" icon="subIcon" onClick="goModify()">修改</gl:button>
			      <gl:button styleClass="sbuBtnStyle" icon="delIcon" onClick="goDel()">删除</gl:button>
			      <gl:button styleClass="sbuBtnStyle" icon="stopIcon" onClick="goStop()">暂停</gl:button>
			      <gl:button styleClass="sbuBtnStyle" icon="playIcon" onClick="goStart()">启用</gl:button>
			      <gl:button styleClass="sbuBtnStyle" icon="assigningPermissions" onClick="goRights()">分配权限</gl:button>
		</td>
	</tr>	
</table>
<gl:grid styleClass="pageTurn" id="role" page="true" form="roleForm"  property="query" cellPadding="0" cellSpacing="0" >
   var grid = new dhtmlXGridObject();
   grid.setImagePath(imagePath);
   var headAlign=[tLeft,tCenter,tCenter,tLeft,tCenter];
   grid.setHeader("#master_checkbox,角色标识,角色名称,描述,是否启用",null,headAlign);
   grid.setInitWidthsP("3,15,25,47,10");
   grid.setColAlign("center,center,center,left,center");
   grid.setColTypes("ch,ro,link,ro,ro");
   grid.setColSorting("na,str,str,str,str");
   grid.attachEvent("onRowDblClicked", goRowDblClick);  
   gridSort("false,true,true,false,true");
   grid.setSkin("dhx_terrace");
   grid.init();

   var gDiv=$$('role_box');
</gl:grid>
</s:form>
</div>
<%@include file="/common/dialog.jsp"%>
<%@include file="/common/resizeList1.jsp" %>
</body>
</html>