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
	</script>
<style type="text/css">
   html, body {width:100%; height:100%; margin:0px; padding:0px; overflow:hidden;}
</style>
</head>

<body>
<div id="formDiv" class="formDiv">	
  <s:form action="sysUser" id="userForm" method="post" namespace="/system">

		<table cellpadding="0" cellspacing="0" width="98%" class="formTable">
			 <tr >
				  <td width="15%">姓名：</td>
				  <td width="35%" class="textLW">
					   &nbsp;<s:property value="record.userName" />
				  </td>
				  <td width="15%">顺序号：</td>
					<td width="35%" class="textLW">
					   &nbsp;<s:property value="record.orderNo" />
					</td>
			 </tr>
			 <tr>
				  <td >账号：</td>
				  <td  class="textLW">
					   &nbsp;<s:property value="record.userAccount" />
				  </td>
				  <td >部门：</td>
				  <td class="textLW">
					   &nbsp;<s:property value="record.deptName" />
				  </td>
			 </tr>
			 <tr>
				  <td>入职时间：</td>
				  <td  class="textLW">
					   &nbsp;<s:property value="record.hireDate" />
				  </td>
				  <td >年龄：</td>
				  <td  class="textLW">
					   &nbsp;<s:property value="record.age" />
              </td>
			</tr>
			 <tr>
				  <td>用户状态：</td>
				  <td class="textLW">
					 &nbsp;<s:property value="record.userStatusName" />
				  </td>
				  <td colspan="2">&nbsp;</td>
			</tr>
			 <tr>
				  <td >角色：</td>
				  <td colspan="3"  class="textLW">
					   &nbsp;<s:property value="record.roleNames" />
			    </td>      
			</tr>			
			<tr >
			   <td vAlign="top">备注：</td>
				 <td colspan="3" class="textLW" style="white-space:wrap;height:100px;" vAlign="top">
					  &nbsp;<s:property value="record.remark" />
				 </td>
			</tr>
	 </table>

 </s:form>	
</div>
<div id="btnDiv" class="btnDiv">
			<gl:button name="btnCancel" onClick="goCancel()">返回</gl:button>
</div>
<%@include file="/common/resize.jsp" %>  
</body>
</html>
