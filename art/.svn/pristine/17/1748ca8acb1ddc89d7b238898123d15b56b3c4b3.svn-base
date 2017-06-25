<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html;charset=UTF-8" import="java.io.*" %>
<% String CONTEXT_PATH = request.getContextPath(); %>
<html>
<head>
<style type="text/css">
<!--
body {
	font: 100% 宋体, 新宋体;
	background: #f2f2f2;
	margin: 0; 
	padding: 0;
	text-align: center; 
	color: #000000;
}
.oneColFixCtr #container {
	width: 400px;  
	height:250px;
	background: #FFFFFF;
	margin: 10px auto; 
	border: 1px solid #000000;
	text-align: left;
}
.oneColFixCtr #mainContent {
	padding: 5px; 
}
#mainContent h1{
	background:url(<%= CONTEXT_PATH%>/common/images/warning.gif) no-repeat left center;
	height:48px;
	text-indent:2em;
	line-height:48px;
	}
#mainContent div{
	border:0px dashed #bcccda;
	padding:10px;
	text-indent:3em;
	background:#fcfcfc;
	line-height:1.5em;
	
	}
-->
</style>
<script type="text/javascript">
function showPage(){
	if(parent.showPage){
		parent.showPage();
	}
}

	
</script>
</head>

<body class="oneColFixCtr" onload="showPage()" style="overflow: hidden;padding-top:30px;">
<div id="container">
  <div id="mainContent">
	<h1>错误提示</h1>
    <div>
    <s:if test="#request.errorMessage!=''">
      <s:property value="#request.errorMessage" />
    </s:if>
   <s:if test="#request.errorMessage==''">
    系统繁忙，请稍后再试
    </s:if>
    </div>
	<!-- end #mainContent --></div>
<!-- end #container --></div>
	<div style="visibility: hidden;height:100px;">
	 
	 <% Exception e=(Exception)request.getAttribute("errMsg");
	 if(e!=null) 
	 {
	 	StringWriter writer = new StringWriter();
		e.printStackTrace(new PrintWriter(writer));		
		out.println(writer.getBuffer());
	 }
	 %>
	 
	</div>
</body>
</html>