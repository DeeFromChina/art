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
	<div id="left_div" style="background-color: #ffffff; height: 100%; width: 100%;"></div>

	<script type="text/javascript">
	
	function goSubmit(id){
			if(tree.getUserData(id,"treeCode") == "m1" || tree.getUserData(id,"treeCode") == "s1"){
				return;
			}
		  var mediumCategory=$$('mediumCategory').value;
		  var mediumId;
		  if(mediumCategory == "1"){
			  mediumId = tree.getUserData(id,"materialId");
		  }
		  if(mediumCategory == "2"){
			  mediumId = tree.getUserData(id,"shapeId");
		  }
		  var str = mediumId;
		  var str1 = tree.getUserData(id,"name");
			 var ret=new Object();
			 ret['medium']=true;
			 ret['str']=str;
			 ret['str1']=str1;
			 ret['mediumCategory']=mediumCategory;
		    parent.closedialog(ret);
	}
	
	function closedialog(ret){
	     if(ret=='true') {
	       var nodeId = tree.getSelectedItemId();
	     	 if(editMode=="ADD") {
	          tree.refreshItem(nodeId);
	       }
	       else if(editMode=="EDIT"){
	          tree.closeItem(nodeId);
            var parentId = tree.getParentId(nodeId);
            tree.selectItem(parentId);
	          tree.refreshItem(parentId);
	       }
	     }
	     editMode="";	
   }

		var dhxLayout = new dhtmlXLayoutObject(document.body, "1C");
    	dhxLayout.setSkin("dhx_terrace");
    	var leftPanel=dhxLayout.cells("a");
    	leftPanel.hideHeader();
    	leftPanel.attachObject("left_div");

		var tree = new dhtmlXTreeObject("left_div","100%","100%",0);
		tree.setImagePath("<%=CONTEXT_PATH%>dhtmlx/imgs/dhxtree_terrace/");
	    tree.attachEvent("onClick", function(id){
	    	goSubmit(id);
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
    	tree.loadXML("<%= CONTEXT_PATH%>artist/medium.do?action=getTree&id=0&record.mediumCategory="+$$('mediumCategory').value);
		tree.setXMLAutoLoading("<%= CONTEXT_PATH%>artist/medium.do?action=getTree&record.mediumCategory="+$$('mediumCategory').value);
		showMenuItems("0");

	</script>
	<%@include file="/common/dialog.jsp" %>
</body>
</html>