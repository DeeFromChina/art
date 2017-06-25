<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <%@include file="/common/header.jsp" %>
<script type="text/javascript">
      var fulllink = contextpath + "activity/activityAbmb.do";		

	function goCancel(){
		 parent.closedialog(false);
	}
  
	
	function init(){
	    
	}
	
	</script>
<style type="text/css">
html,body {
	width: 100%;
	height: 100%;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
}
</style>
</head>

<body onload="init();">
	<div id="formDiv" class="formDiv">
	<s:form action="activityAbmb" id="abmbForm" method="post" namespace="/activity">
			<table id="tblForm" cellpadding="0" cellspacing="0" width="98%" class="formTable">
				<tr>
					<td width="15%" class="textR">名称：</td>
				  	<td width="35%" class="textL">
						<s:property value="form.record.abmbName" />
				  	</td>
				  	<td width="15%" class="textR">届数：</td>
				  	<td width="35%" class="textL">
						<s:property value="form.record.abmbNumber"/>
				  	</td>
				</tr>
				<tr>
			    	<td class="textR">主办方：</td>
				 	<td  class="textL">
						<s:property value="form.record.sponsor" />
				 	</td>
				 	<td class="textR">艺术总监：</td>
				 	<td  class="textL">
						<s:property value="form.record.artDirector" />
				 	</td>
				</tr>
				<tr>
			    	<td class="textR">国家：</td>
				 	<td  class="textL">
						 <s:property value="form.record.countryName"/>
				 	</td>
				 	<td class="textR">城市：</td>
				 	<td  class="textL">
						<s:property value="form.record.city" />
				 	</td>
				</tr>
				<tr>
			    	<td class="textR">开幕时间：</td>
				 	<td colspan="3" class="textL">
				 	   <s:property value="form.record.abmbTime" />
					</td>		 	
				</tr>
				
	 		</table>
	 </s:form>
	</div>
	
	<div id="btnDiv" class="btnDiv">
		<gl:button name="btnCancel" onClick="goCancel()">关闭</gl:button>
	</div>
	<%@include file="/common/dialog.jsp" %>
<%@include file="/common/resize.jsp" %>
</body>
</html>
