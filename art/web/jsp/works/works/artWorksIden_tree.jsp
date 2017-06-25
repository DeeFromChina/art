<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp"%>
<style type="text/css">
html, body { width: 100%; height: 100%; }
</style>
</head>
<body>
	<s:hidden name="record.mediumCategory" id="mediumCategory"></s:hidden>
	<s:hidden name="record.id" id="mediumId"></s:hidden>
   	<div id="left_div" style="width:100%;height:100%;overflow-y:auto;">
   	</div>
	<script type="text/javascript">
		function goSumbit(id){
			var artistId = tree.getUserData(id,"parentId");
			if(artistId == ""){
				return;
			}
			var name = tree.getUserData(id,"name");
			rightPanel.attachURL("<%=CONTEXT_PATH%>works/artWorksIden.do?action=IDEN&query.parameters.artistId=" + artistId + "&query.parameters.name=" + name);
		}

		var dhxLayout = new dhtmlXLayoutObject(document.body, "2U");
    	dhxLayout.setSkin("dhx_terrace");
    	var leftPanel=dhxLayout.cells("a");
    	var rightPanel=dhxLayout.cells("b");
    	rightPanel.hideHeader();
    	leftPanel.hideHeader();
    	leftPanel.setWidth(300);
    	leftPanel.attachObject("left_div");
    	
		var tree = new dhtmlXTreeObject("left_div","100%","100%",0);
		tree.setImagePath("<%=CONTEXT_PATH%>dhtmlx/imgs/dhxtree_terrace/");
	    tree.attachEvent("onClick", function(id){
	    	goSumbit(id);
	    });
	    tree.attachEvent("onMouseIn", function(id){
	    	 var str=tree.getUserData(id,"name");
	    	 tree.setItemText(id,"<font color='#bb4422'>"+str+"</font>");
	    });
	    tree.attachEvent("onMouseOut", function(id){
	    	 var str=tree.getUserData(id,"name");
	    	 tree.setItemText(id,str);
	    });
	    tree.enableCheckBoxes(false);
    	tree.setSkin('dhx_terrace');
    	tree.loadXML("<%= CONTEXT_PATH%>works/artWorksIden.do?action=GETTREE&id=0");
		tree.setXMLAutoLoading("<%= CONTEXT_PATH%>works/artWorksIden.do?action=getTree");

	</script>
	<%@include file="/common/dialog.jsp" %>
</body>
</html>