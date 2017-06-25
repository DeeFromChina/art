<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <%@include file="/common/header.jsp" %>

	<script type="text/javascript">
      var fulllink = contextpath + "system/sysRole.do";		

	function goCancel(){
		 parent.closedialog(false);
	}
	
	function goSubmit(){
		  document.forms[0].rights.value=tree.getAllChecked();
		  document.forms[0].action=fulllink+"?action=saveRights";
    	document.forms[0].submit();
	}
  
	  function init(){
		  showMessage('<s:property value="errorMessage" escape="false" />');
	  }
	
	</script>
<style type="text/css">
   html, body {width:100%; height:100%; margin:0px; padding:0px; overflow:hidden;}
</style>
</head>

<body onload="init()">
  <s:form action="sysRole" id="roleForm" method="post" namespace="/system">
  	<s:hidden name="record.id" />
  	<s:hidden id="rights" name="record.rights" />
  </s:form>		
<div id="formDiv" style="border:1px solid #c1b2f9;background:white;text-align:left!important;">
   <div id="treeDiv" style="width:100%;height:100%;overflow-y:auto;">
   </div>
</div>
<div id="btnDiv" class="btnDiv">
			      <gl:button name="btnAdd" onClick="goSubmit()">保存</gl:button>
				    &nbsp;
			      <gl:button name="btnCancel" onClick="goCancel()">取消</gl:button>
    </div>
<script type="text/javascript">
	  var mainbody=window.document.body;
    if(window.addEventListener) {
 	     window.addEventListener("resize",goResize,false); 
    }
    else {
 	     window.attachEvent('onresize',goResize);
    }
    
    var fDiv=window.document.getElementById('formDiv');
    var bDiv=window.document.getElementById('btnDiv');
    
    function goResize(){
       fDiv.style.width=mainbody.offsetWidth-4+"px";
       bDiv.style.width=mainbody.offsetWidth-bDiv.offsetLeft*3+"px";
       fDiv.style.height=mainbody.offsetHeight-bDiv.offsetHeight-4+"px";
       bDiv.style.top=fDiv.offsetHeight+fDiv.offsetTop*3+"px";
    }
    goResize();   
</script> 
<script type="text/javascript">

    var tree = new dhtmlXTreeObject("treeDiv","100%","100%",0);
    tree.setImagePath("<%=CONTEXT_PATH%>dhtmlx/imgs/dhxtree_terrace/");
    tree.setSkin('dhx_terrace');
    tree.enableCheckBoxes(true, false);
    tree.enableTreeLines(false);
    tree.enableTreeImages(true);
    //tree.enableThreeStateCheckboxes(1);
    <s:iterator value="sysReources">
      tree.insertNewChild(<s:if test="#parentId!=0">'</s:if><s:property value="parentId"/><s:if test="#parentId!=0">'</s:if>
      ,'<s:property value="id"/>','<s:property value="resName"/>',0,0,0,0,"","1");
    </s:iterator>
    tree.openAllItems(0);
<s:iterator value="rights">
 tree.setCheck('<s:property value="id"/>',1);
</s:iterator>
   tree.attachEvent("onCheck", function(id,state){
	   checkTree(id,state);
   });
   
   function checkTree(id,state){
	   var pid = tree.getParentId(id);
	   if(pid== null|| pid=="") return;
       tree.setCheck(pid,1);
       checkTree(pid,state);
   }
</script>   
</body>
</html>
