<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <%@include file="/common/header.jsp" %>

	<script type="text/javascript">
		var fulllink = contextpath + "system/sysRole.do";

		function goCancel() {
			parent.closedialog(false);
		}

		function goSubmit() {
		  if(!checkString(getElement('form.record.roleCode'),"角色标识",30,true)) return;
		  if(!checkString(getElement('form.record.roleName'),"角色名称",30,true)) return;
		  if(!checkString(getElement('form.record.remark'),"备注",200,false)) return;			
			
			document.forms[0].action=fulllink+"?action=SAVE";
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
	<div id="formDiv" class="formDiv">
  <s:form action="sysRole" id="roleForm" method="post" namespace="/system">
			<table id="tblForm" cellpadding="0" cellspacing="0" width="98%" class="formTable">
				<tr>
					<td width="15%" class="textR"><font color="red">*</font>角色标识：</td>
				  	<td width="35%">
						<s:textfield name="form.record.roleCode" />
				  	</td>
					<td width="15%" class="textR"><font color="red">*</font>状态：</td>
					<td  width="35%" class="sel">
					<s:select list="codeSets.START_OR_STOP" listKey="value" listValue="codeName" name="form.record.roleStatus"></s:select>
  					</td>
				</tr>
				<tr>
				  	<td class="textR"><font color="red">*</font>角色名称：</td>
					<td colspan="3">
						<s:textfield name="form.record.roleName" />
					</td>
			 	</tr>
				<tr>
			    	<td class="textR" valign="top">描述：</td>
				 	<td colspan="3" >
						<s:textarea name="form.record.remark" ></s:textarea>
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
<%@include file="/common/dialog.jsp" %>
<%@include file="/common/resize.jsp" %>
<script type="text/javascript">

</script>
</body>
</html>