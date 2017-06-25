<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <%@include file="/common/header.jsp" %>
	<script type="text/javascript">
		var hyperlink = "../wx/wxMenuButon.do";
		var fulllink = contextpath + "wx/wxMenuButon.do";

		function addcodeset(codesetid) {
// 			openWindow('添加代码', fulllink+'?action=ADD&codesetid='+codesetid, 600, 350);
		}

		function modifycodeset() {
// 			var mygrid=dhxLayout.cells("b").getFrame().contentWindow.mygrid;
// 			var id = findSelected("修改",mygrid);
// 			if(id == "") return;
// 			var rulcodesetedit=fulllink+'?action=EDIT&ids='+id;
// 			openWindow("修改代码", rulcodesetedit, 600, 350);
		}

		function deletecodeset(codesetid) {
// 			var mygrid=dhxLayout.cells("b").getFrame().contentWindow.mygrid;
// 			var id = findMultiSelected("删除",mygrid);
// 			if(id == "") return;
// 			var res = confirm("是否真的要删除?");
// 			if(res == true) {
// 				var innerDoc;
// 				if (_isIE) {
// 					innerDoc = dhxLayout.cells("b").getFrame().contentWindow.document;
// 				} else {
// 					innerDoc = dhxLayout.cells("b").getFrame().contentDocument;
// 				}
// 				innerDoc.forms[0].action = hyperlink + "?action=delete&ids=" + id+"&codesetid="+codesetid;
// 				innerDoc.forms[0].target = "_self";
// 				innerDoc.forms[0].submit();
// 			}
		}

		function view() {
// 			var id = dhxLayout.cells("b").getFrame().contentWindow.getModifyId();
// 			if(id == "") return;
// 			var urllink = contextpath+"system/sysCode.do"+"?action=CODELIST&codesetid="+id;
// 			openWindow('浏览系统代码值',  urllink, 600, 250);
		}

		function viewCodesetGrid(id){
      if(id==null||id==""||id=="root") {
      	rightPanel.attachURL("<%= CONTEXT_PATH%>dhtmlx/imgs/blank.html");
         toolbar.disableItem("new_codeset");
         toolbar.disableItem("modify_codeset");
         toolbar.disableItem("del_codeset");
      	}	
    	else {
    	 rightPanel.attachURL("<%= CONTEXT_PATH%>system/sysCode.do?action=CODELIST&codesetid="+id);
         toolbar.enableItem("new_codeset");
         toolbar.enableItem("modify_codeset");
         toolbar.enableItem("del_codeset");
    	}   
		}
	</script>
<style type="text/css">
   html, body {width:100%; height:100%;}
</style>
  </head>

<body>
	<div id="div_left" style="background-color:#ffffff;height:100%;width:100%;"></div>

	<script type="text/javascript">

		var dhxLayout = new dhtmlXLayoutObject(document.body, "2U");
    	dhxLayout.setSkin("dhx_terrace");
    	var leftPanel=dhxLayout.cells("a");
    	var rightPanel=dhxLayout.cells("b");
    	leftPanel.hideHeader();
    	leftPanel.attachObject("div_left");
    	leftPanel.setWidth(250);
    	rightPanel.hideHeader();

		var toolbar = dhxLayout.attachToolbar();
		toolbar.setIconsPath("<%= CONTEXT_PATH%>dhtmlx/imgs/icon/");
		toolbar.addButton("add_menu", 0, "添加", "code_add.gif", "code_add.gif");
    	toolbar.addSeparator("sep1", 1);
		toolbar.addButton("modify_menu", 2, "修改", "code_mod.gif", "code_mod.gif");
    	toolbar.addSeparator("sep2", 3);
		toolbar.addButton("del_menu", 4, "删除", "code_del.gif", "code_del.gif");
		toolbar.addSeparator("sep1", 5);
		toolbar.addButton("start_menu", 6, "启用", "code_del.gif", "code_del.gif");
		toolbar.addSeparator("sep1", 7);
		toolbar.addButton("stop_menu", 8, "停用", "code_del.gif", "code_del.gif");
		toolbar.addSeparator("sep1", 9);
		toolbar.addButton("update_menu", 10, "更新菜单", "code_del.gif", "code_del.gif");
		//点击事件
		toolbar.attachEvent("onClick", function(id){
			if(id=="add_menu") {
// 				var nodeId=tree.getSelectedItemId();
// 				addcodeset(nodeId);
			}
			else if(id=="modify_menu") modifycodeset();
			else if(id=="del_menu") {
// 				var nodeId=tree.getSelectedItemId();
// 				deletecodeset(nodeId);
			}
			else if(id=="start_menu") {
// 				var nodeId=tree.getSelectedItemId();
// 				deletecodeset(nodeId);
			}
			else if(id=="stop_menu") {
// 				var nodeId=tree.getSelectedItemId();
// 				deletecodeset(nodeId);
			}
			else if(id=="update_menu") {
// 				var nodeId=tree.getSelectedItemId();
// 				deletecodeset(nodeId);
			}
		});

    	toolbar.disableItem("add_menu");
    	toolbar.disableItem("modify_menu");
     	toolbar.disableItem("del_menu");
     	toolbar.disableItem("start_menu");
     	toolbar.disableItem("stop_menu");

		var tree = new dhtmlXTreeObject("div_left","100%","100%",0);
		tree.setImagePath("<%=CONTEXT_PATH%>dhtmlx/imgs/dhxtree_terrace/");
		tree.attachEvent("onClick", function(id){
			viewCodesetGrid(id);
		});
    	tree.setSkin('dhx_terrace');
		tree.setXMLAutoLoading("<%= CONTEXT_PATH%>wx/wxMenuButon.do?action=getTree");
		tree.loadXML("<%= CONTEXT_PATH%>wx/wxMenuButon.do?action=getTree");

		var dhxWins = dhxLayout.dhxWins;
		var winName="winCodeset";   //打开窗口名称
	   var editMode;       		//页面编辑状态：ADD,EDIT,DELETE
		dhxWins.enableAutoViewport(true);
		dhxWins.setImagePath("<%= CONTEXT_PATH%>dhtmlx/imgs/");

		function openWindow(title,urlink,width,height){
			var w = dhxWins.createWindow(winName, 0, 0, width,height);
			w.setText(title);
			w.keepInViewport(true);
			w.setModal(true);
			w.centerOnScreen();
			w.button("minmax1").hide();
			w.button("minmax2").hide();
			w.button("park").hide();
			w.attachURL(urlink);
			return w;    
	    }

		function closedialog(ret){
			dhxWins.window(winName).close();
			var id = tree.getSelectedItemId();
			if(ret) reSearch(id);
			return id;
		}

		function reSearch(id){
			viewCodesetGrid(id);
			//dhxLayout.cells("b").getFrame().contentWindow.renew(id);
		}
	</script>
</body>
</html>