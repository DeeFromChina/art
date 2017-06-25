<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <%@include file="/common/header.jsp" %>
	<script language="javascript">
		var hyperlink = "../system/sysCode.do";

		function getModifyId() {
			alert('dd');
			var id = findSelected("ID","修改");
			if (id == "") return "";
			return id;
		}
		
		function getId() {
			var id = findSelected("ID","浏览代码");
			if (id == "") return "";
			return id;
		}

		function getDeleteId() {
			var ids = findMultiSelected("ID","删除");
			if (ids == "") return "";
			return ids;
		}

		function viewCode(id) {
			var urllink = contextpath+"system/sysCode.do"+"?action=LIST&codesetid="+id;
			parent.openWindow('浏览代码',  urllink, 800, 450);
		}

		function renew(id)  {
			/* var order = getElement("query.order");                  order.value="";
			var desc =  getElement("query.orderDirection");         desc.value="";
			var pn =    getElement("query.pageNumber");             pn.value="1";
			var ps =    getElement("query.pageSize");               ps.value="10";
			var v1 =    getElement("query.parameters.treeid");      v1.value=id; */
			gosearch("CODELIST&codesetid="+id);
		}
		
		  function init(){
			  showMessage('<s:property value="errorMessage" escape="false"/>')
		  }

</script>


<style type="text/css">
   html, body {width:100%; height:100%;}
</style>
</head>

<body onload="init()" >
<s:form action="sysCode" id="codeForm" method="post" namespace="/system">
				<s:hidden name="query.parameters.action1" value="CODELIST"/>

				<s:hidden name="query.parameters.treeid" />
				<s:hidden name="query.order" />
				<s:hidden name="query.orderDirection" />
				<s:hidden name="query.pageNumber" />
				<s:hidden name="query.recordCount" />
				<s:hidden name="query.pageCount" />
		
			<div id="gridbox" style="border:none;background-color:white;"></div>
</s:form>
<script type="text/javascript">
   gridbox.style.height=window.document.body.offsetHeight+"px";
   gridbox.style.width=window.document.body.offsetWidth+"px";
	
   mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath("<%=CONTEXT_PATH%>dhtmlx/imgs/");
	var headAlign=[tCenter,tCenter,tCenter,tCenter];
	mygrid.setHeader(" ,代码名称,代码值,备注",null,headAlign);
	mygrid.setInitWidthsP("5,30,15,50");
	mygrid.setColAlign("center,center,center,center");
	mygrid.setColTypes("ch,ro,ro,ro");
	mygrid.setColSorting("na,str,str,str");
	mygrid.init();
	mygrid.setSkin("dhx_terrace");
		var gDiv=$$('gridbox_box');
	data = {rows: ${gridInfo}};
	mygrid.parse(data,"json");
	mygrid.checkAll(false);
	
</script>
</body>
</html>