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
		  
		  var pwd=getElement('record.pwd');
		  var compwd=getElement('record.confirmPwd');
		  if(!checkString(pwd,"密码",30,true)) return;
		  if(!checkString(compwd,"确认密码",30,true)) return;
		  if(pwd.value!=compwd.value){
		     alert("密码和确认密码不相同！");
		     pwd.focus();
		     return;
		  }
		  if(pwd.value.length<4){
		     alert("密码长度不能小于4位！");
		     pwd.focus();
		     return;
		  }
		  		
		  document.forms[0].action=fulllink+"?action=SAVEPWD";
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
  	<s:hidden name="record.id" />
		<table cellpadding="0" cellspacing="0" width="100%" class="formTable">
			 <tr >
				  <td width="35%"><font color="red">*</font>密码：</td>
				  <td width="65%">
					   <s:password name="record.pwd" />
				  </td>
			 </tr>
			 <tr>
				  <td ><font color="red">*</font>确认密码：</td>
				  <td >
					   <s:password name="record.confirmPwd" />
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
