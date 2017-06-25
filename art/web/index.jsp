<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%
	String path = request.getContextPath();
	String CONTEXT_PATH = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <!--[if gte IE 8]>
    <meta http-equiv="X-UA-Compatible" content="IE=8"/>
    <![endif]-->
    <!--[if lt IE 8]>
    <meta http-equiv="X-UA-Compatible" content="IE=7"/>
    <![endif]-->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>
    <link rel="icon" href="<%=CONTEXT_PATH%>images/logo.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="<%=CONTEXT_PATH%>images/logo.ico" type="image/x-icon" />
    <link rel="bookmark" href="<%=CONTEXT_PATH%>images/logo.ico" type="image/x-icon" />
	<title>艺术云平台</title>
	<link rel="stylesheet" type="text/css" href="<%=CONTEXT_PATH%>dhtmlx/dhtmlx.css" />
    <script src="<%=CONTEXT_PATH%>dhtmlx/dhtmlx.js"></script>
<style type="text/css">
html {
	width: 100%;
	height: 100%;
	border:none;
	overflow: hidden;
}
body {
	background-color:#f0f0f0;
	width:100%;
	height:100%;
	left:0px;
	top:0px;
	margin:0px;
	border:0px;
	text-align:center;
}
.frm {
	width:100%;
	height:100%;
	left:0px;
	top:0px;
	margin: 0px;
	border:none;
}
</style>
<script language="javascript">
   function init(){
	   var fr=window.document.getElementById('main_frame');
	   if(fr.offsetWidth>1440){
		   fr.style.width="1440px";
	   }
   }
</script>
</head>
<body onload="init()">
<iframe id="main_frame" style="border:none;" name="main_frame" src="<%=CONTEXT_PATH%>login.do" class="frm" frameborder="0" scrolling="auto"></iframe>
</body>
</html> 