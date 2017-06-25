<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <%@include file="/common/header.jsp" %>

	<script type="text/javascript">
      var fulllink = contextpath + "system/sysUser.do";		

	function goRoles(){
	    var url_link=contextpath+'system/sysRole.do?action=SelectRoles&ids='+getElement("record.roleIds").value;
        openWindow("选择角色",url_link,200,300);	  
	}

	function goCancel(){
		parent.closedialog('false');
	}

	function goSubmit(){
		  //checkString参数：对象名、标题、长度、是否检测空值
		  if(!checkString(getElement('record.userName'),"姓名",30,true)) return;

		  if(!checkString(getElement('record.userAccount'),"帐号",30,true)) return;
		  var account=getElement('record.userAccount');
		  if(account.value.length<3){
			     alert("帐号不能小于3位！");
			     account.focus();
			     return;
			  }
		  //checkNumeric参数：对象名、标题、长度、是否检测空值,是否检测大于0
		  if(!checkNumeric(getElement('record.orderNo'),"顺序号",6,true,true)) return;

		  //checkEmpty参数：对象名、标题
		  if(!checkEmpty(getElement('record.orgId'),"单位")) return;
		  //if(!checkEmpty(getElement('record.deptId'),"部门")) return;

		  if(!checkString(getElement('record.tel'),"联系电话",32,false)) return;
		  if(!checkString(getElement('record.email'),"电子邮件",32,false)) return;
		  if(!checkString(getElement('record.remark'),"备注",200,false)) return;		
		  
		  document.forms[0].action=fulllink+"?action=UPDATE";
    	document.forms[0].submit();
	}

  function closedialog(ret){
	  var res=ret['ret'];
     if(res==true) {
    	 getElement('record.roleIds').value=ret['str'];
    	 getElement('record.roleNames').value=ret['str1'];
     }	
  }	
  
  function init(){
	  showMessage('<s:property value="errorMessage" escape="false"/>')
  }
  
  
	function queryDepts(){
		 var id=getElement('record.orgId').value;
		 if(id=="")id=0;
	    var loader = dhx4.ajax.postSync(fulllink+'?action=getDepts&ids='+id, "");

	    var str="";
	    if (loader.xmlDoc.responseText != null) str = loader.xmlDoc.responseText;
	    if(str==""||str=="ERROR") {
	       alert("系统出错。");
	   	 return;
	    }
	    var sel=getElement('record.deptId');
	    showSelect(str,"dept",sel);
 }

	
	</script>
<style type="text/css">
   html, body {width:100%; height:100%;background-color:#ffffff; margin:0px; padding:0px; overflow:hidden;}
</style>
</head>

<body onload="init()">
<div id="formDiv" class="formDiv">
  <s:form action="sysUser" id="userForm" method="post" namespace="/system">
  	<s:hidden styleId="userId" name="record.id" />
	<s:hidden name="record.deptId" value="1"></s:hidden>
		<table id="tblForm" cellpadding="0" cellspacing="0" width="100%" class="formTable">
			 <tr >
				  <td width="15%"><font color="red">*</font>姓名：</td>
				  <td width="35%"> <s:textfield name="record.userName" /> </td>
				  <td width="15%"><font color="red">*</font>用户状态：</td>
				  <td  width="35%" class="sel">
					 <s:select list="codeSets.START_OR_STOP" name="record.userStatus" listKey="value" listValue="codeName"></s:select> 
				  </td>
			 </tr>
			 <tr>
				  <td ><font color="red">*</font>账号：</td>
				  <td > <s:textfield name="record.userAccount" /> </td>
				  <td ><font color="red">*</font>顺序号：</td>
				  <td> <s:textfield name="record.orderNo" /> </td>
			 </tr>
			 <tr>
				  <td ><font color="red">*</font>单位：</td>
				  <td  class="sel">
				  	<s:select list="codeSets.orgs" listKey="value" onchange="queryDepts()" listValue="codeName" name="record.orgId"></s:select>
				  </td>
				  <td colspan="2"></td>
				  <!-- 
				  <td ><font color="red">*</font>部门：</td>
				  <td  class="sel">
				  	<s:select list="codeSets.depts" listKey="value" listValue="codeName" name="record.deptId"></s:select>
				  </td>
				   -->
			</tr>
			 <tr>
				  <td>联系电话：</td>
				  <td > <s:textfield name="record.tel" /> </td>
				  <td >电子邮件：</td>
				  <td > <s:textfield name="record.email" /> </td>
			</tr>
			 <tr>
				  <td >角色：</td>
				  <td colspan="3" class="sel">
				  	 <table cellpadding="0" cellspacing="0" border="0" width="100%" height="100%" class="tbnBtnStyle">
				  	 	  <tr>
		   	           <td width="*">
		   	           	   <s:textfield styleId="roleNames" readonly="true" name="record.roleNames" />
  	                        <s:hidden styleId="roleIds" name="record.roleIds" />
		   	           	</td>
		   	           <td width="45px" class="btn">
		   	               <gl:button name="btnRoles" styleClass="btnFormStyle" onClick="goRoles()">角色</gl:button>
		   	           </td>
			          </tr>
			       </table>
			    </td>      
			</tr>
			<tr>
			   <td valign="top">备注：</td>
				 <td colspan="3">
					  <s:textarea rows="10" name="record.remark" ></s:textarea>
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
