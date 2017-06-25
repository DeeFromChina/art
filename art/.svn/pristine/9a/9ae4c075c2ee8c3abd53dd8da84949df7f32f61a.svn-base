<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%
   String path = request.getContextPath();
			String CONTEXT_PATH = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Page-Enter" content="blendTrans(Duration=0.5)" />
<meta http-equiv="Page-Exit" content="blendTrans(Duration=0.5)" />

<style type="text/css">
body {
	width: 100%;
	height: 100%;
	border: none;
	font-family: 微软雅黑, 宋体, Verdana, Geneva, sans-serif;
	font-size: 14px;
	background: #add1eb;
	margin: 0px;
	overflow: hidden;
}

#wrapper {
    text-align:center;
	width:100%;
	height:100%;
	top: 0px;
	overflow:hidden;
}

.ad_head {
	position: relative;
	top:0px;
	width: 400px;
	margin: 0 auto;
	height: 220px;
}

.ad_login {
  	background: url(<%=CONTEXT_PATH%>images/login/bg.png) no-repeat;
	position: relative;
	top:20px;
	width: 410px;
	height: 357px;
	margin: 0 auto;
}

.ad_form {
	width: 305px;
	position: relative;
	top: 80px;
	left: 50px;
}

.ad_form p {
	height: 30px;
	font-size: 16px;
	margin-bottom:15px;
}

.ad_form label {
	width: 50px;
	vertical-align: middle;
	float: left;
	line-height: 30px;
	height: 30px;
	margin-left: 22px;
}

.ad_form input {
	font-family: "微软雅黑";
    font-size:14px;
	line-height: 26px;
	height: 26px;
	width: 200px;
	margin-left: 5px;
	border: 1px solid #848c8a;
	outline: none;
	vertical-align: middle;
}

.ad_form .ad_lbt {
	background: url(<%=CONTEXT_PATH%>images/login/button.png) no-repeat center;
	width: 340px;
	height: 27px;
	border: 0px;
	display: block;
	cursor: pointer;
	margin-top: 10px;
	margin-left: -10px;
}
</style>

<script language="javascript" type="text/javascript">  
var msg="";

function checkLength(o,n,min,max) {
   if(o.value.length > max || o.value.length < min) {
	    msg=msg+n+("长度必须介于"+min+"和"+max+"之间。\r\n");
			return false;
	 } 
	 else {
      return true;
   }
}

function checkRegexp(o,regexp,n) {
   if(regexp.test(o.value)) {
      return true;
   } 
   else {
	    msg=msg+n+"\r\n";
      return false;
	 }
}

function checkInput(userName,password){
   var bValid = true;

   bValid = bValid & checkLength(userName,"用户名",4,30);
   //bValid = bValid & checkRegexp(userName,/^[a-z]([0-9a-z_])+$/i,"用户名必须是字母或数字。");
   bValid = bValid & checkLength(password,"密码",8,30);
					
   return bValid;
}
           
function goValidate(){
   var uName = document.getElementById("userName");
   var password =document.getElementById("password");
   if(checkInput(uName,password)){
//	   document.forms[0].action="<%=CONTEXT_PATH%>login.do?action=login";
	   document.forms[0].submit();
   }
   else {
      alert(msg);
      msg="";
   }
}

function login(){
	var msg='<%=request.getAttribute("errMsg")%>';
	if(msg!='null')
		alert(msg);
	document.getElementById("userName").focus();
}

function goKeyPress() {
	if(window.event.keyCode == 13) goValidate();  
}

</script>
</head>
<body onload="login()">
<div id="wrapper">
	<div id="titleDiv" class="ad_head"><img id="imgDiv" src="<%=CONTEXT_PATH%>images/login/logo.png" width="400" height="220" /></div>
    <div id="loginDiv" class="ad_login">
    	<div class="ad_form">
	<form id="loginForm" action="<%=CONTEXT_PATH%>login.do?action=login" method="post">
            <p><label>账号：</label><input name="userName" id="userName" type="text"  onkeypress="goKeyPress()" value="admin"  maxlength="20" /></p>
            <p><label>密码：</label><input name="password" id="password" type="password"  onkeypress="goKeyPress()" value="admin_bilang" /></p>
            <p><input id="brnSubmit" type="button" onclick="goValidate()" onkeypress="goKeyPress()" class="ad_lbt" /></p>
    </form>
        </div>
    </div>
</div>	
<script type="text/javascript">
var tdiv=window.document.getElementById('titleDiv');
var adiv=window.document.getElementById('loginDiv');
var wdiv=window.document.getElementById('wrapper');
wdiv.style.height=document.body.offsetHeight-1+'px';
if(wdiv.offsetHeight>570){
	tdiv.style.top=(wdiv.offsetHeight-570)/2+"px";
	adiv.style.top=tdiv.offsetTop+20+"px";
}
</script>
	
</body>
</html>