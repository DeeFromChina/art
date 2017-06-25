<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <%@include file="/common/header.jsp" %>

	<script type="text/javascript">
      var fulllink = contextpath + "system/sysUser.do";		

	function goCancel(){
		parent.closedialog(false);
	}
	
	function goSubmit(){
		document.forms[0].action=fulllink+"?action=SAVEPROPERTY";
    	document.forms[0].submit();
	}
  
  function init(){
     showMessage('<s:property value="errorMessage" escape="false"/>');
  }
	
	</script>
<style type="text/css">
   html, body {width:100%; height:100%; margin:0px; padding:0px; overflow:hidden;}
</style>
</head>

<body onload="init()">
<div id="formDiv" class="formDiv" style="text-align:left!important;">	
  <s:form action="sysUser" id="userForm" method="post" namespace="/system">
		<table cellpadding="0" cellspacing="0" width="100%" >
			 <tr >
				  <td style="padding-top:2px;">
				  &nbsp;桌面皮肤：<s:radio list="#{'default':'缺省','skyblue':'蓝天','autumn':'金秋','summer':'草地'}" name="record.skin" value="#{record.skin}"/>
				  </td>
			 </tr>
	 </table>
</s:form>
</div>			
<div id="btnDiv" class="btnDiv">
			      <gl:button name="btnAdd" onClick="goSubmit()">保存</gl:button>
				    &nbsp;
			      <gl:button name="btnCancel" onClick="goCancel()">取消</gl:button>
</div>
<%@include file="/common/resize.jsp" %>

</body>
</html>
