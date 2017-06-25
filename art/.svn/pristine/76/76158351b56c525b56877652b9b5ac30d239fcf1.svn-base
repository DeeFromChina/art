<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <%@include file="/common/header.jsp" %>

	<script type="text/javascript">
      var fulllink = contextpath + "system/sysDept.do";		

	function goCancel(){
		parent.closedialog(false);
	}
	
	function goSubmit(){
		
		  if(!checkString(getElement('form.record.deptName'),"部门名称",60,true)) return;
		  if(!checkString(getElement('form.record.deptCode'),"部门编号",20,true)) return;
		  if(!checkString(getElement('form.record.deptAbbr'),"部门简称",60,false)) return;
		  if(!checkNumeric(getElement('form.record.orderNo'),"顺序号",6,true,true)) return;
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
  <s:form action="sysDept" id="deptForm" method="post" namespace="/system">
  	<s:hidden name="form.record.orgId" />
  	<s:hidden name="form.record.upDeptId" />

		<table id="tblForm" cellpadding="0" cellspacing="0" width="98%" class="formTable">
			 <tr >
				  <td width="20%"><font color="red">*</font>部门名称：</td>
				  <td width="30%">
					   <s:textfield name="form.record.deptName" />
				  </td>
				  <td width="20%"><font color="red">*</font>部门编号：</td>
					<td width="30%">
					   <s:textfield name="form.record.deptCode" />
					</td>
			 </tr>
			 <tr>
				  <td >部门简称：</td>
				  <td >
					   <s:textfield name="form.record.deptAbbr" />
				  </td>
				  <td ><font color="red">*</font>顺序号：</td>
				  <td>
					   <s:textfield name="form.record.orderNo" />
				  </td>
			 </tr>
			<tr>
			   <td valign="top">备注：</td>
				 <td colspan="3">
					  <s:textarea rows="5" name="form.record.remark" ></s:textarea>
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
