<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <%@include file="/common/header.jsp" %>
<script type="text/javascript">
	var fulllink = contextpath + "auction/exchangeRate.do";

	function goCancel(){
		 parent.closedialog(false);
	}
  
	
	function init(){
	    tabbar.setTabActive("a1");	
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
  <s:form action="exchangeRate" id="exchangeForm" method="post" namespace="/auction">
			<table id="tblForm" cellpadding="0" cellspacing="0" width="98%" class="formTable">
		    	<col width="15%"/>
			    <col width="35%"/>
			    <col width="15%"/>
			    <col width="35%"/>
				<tr>
					<td class="textR">年份：</td>
				  	<td class="textL">
				  	  <s:property value="record.year"/>
				  	</td >
				  	<td class="textL" colspan="2">兑换规则：人民币1元兑换其他货币的汇率</td>
				</tr>
				<tr>
					<td class="textR"><font color="red">*</font>季度：</td>
				  	<td>
				  		<s:property value="record.season"/>
				  	</td>
				  	<td class="textL" colspan="2"/>
				</tr>
				<tr>
			    	<td class="textR">港币：</td>
				  	<td  class="textL">
				  	  <s:property value="record.hkExchangeRate" />
				  	</td>
				  	<td class="textR">美元：</td>
				  	<td class="textL">
				  	  <s:property value="record.dExchangeRate" />
				  	</td>
				</tr>
				<tr>
				  	<td class="textR">欧元：</td>
				  	<td class="textL">
				  	  <s:property value="record.eExchangeRate" />
				  	</td>
				  		<td class="textR">英镑：</td>
				  	<td  class="textL">
				  	  <s:property value="record.pExchangeRate" />
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
