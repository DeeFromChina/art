<%@ page language="java" contentType="text/html;charset=UTF-8"
   import="com.golead.core.util.Const,com.golead.core.web.UserSession"%>
   <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<%
   String path = request.getContextPath();
	String CONTEXT_PATH = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
 <%
               UserSession userSession = (UserSession) request.getSession().getAttribute(Const.SESSION);
               String userString="当前用户： "+userSession.getUserName()+"("+userSession.getAccountName()+")";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7;ie=8" />
<link rel="stylesheet" type="text/css" href="<%=CONTEXT_PATH%>dhtmlx/dhtmlx.css" />
<link rel="stylesheet" type="text/css" href="<%=CONTEXT_PATH%>dhtmlx/dhtmlx_custom.css" />
<script src="<%=CONTEXT_PATH%>dhtmlx/dhtmlx.js"></script>
<script language="javascript" src="<%=CONTEXT_PATH%>js/ctrl_util.js"></script>
<style type="text/css">
html,body {
   width: 100%;
   height: 100%;
   border: none;
   overflow: hidden;
}
/* --------------以下为新增css---------------- */
#sysName {
   padding-top:10px;
   padding-left:20px;
   height: 55px;
   text-indent:5px;
   font-size: 28px;
   color:blue;
   font-weight:bold;
}

#topBanner {
   background: url(<%=CONTEXT_PATH%>images/banner.png) no-repeat left top;
   height: 64px;
   position: relative;
   background-color:#aaccee;
}

#header {
   width: 100%;
   zoom: 1;
}

#hInput {
   position: absolute;
   right: 0;
   top: 0;
   height: 64px;
   width: 366px;
   text-align: right;
   line-height: 64px;
}

#logSate {
   position: absolute;
   left: 0px;
   top: 42px;
   _top: 14px;
   padding: 2px 0 0 25px;
   text-align: left;
   color: #000000;
   width: 100%;
   font-size:12px;
}

#header .headerBtn1 {
   cursor: pointer;
   background: url(<%=CONTEXT_PATH%>images/icon_list.gif) no-repeat right;
   width: 72px;
   height: 18px;
   line-height: 18px;
   border: none;
   margin-right: 3px;
   margin-top: 44px;
   font-size: 12px;
   color: #000000;
   padding: 2px 0 0 0px;
   text-align: right;
}

#header .headerBtn {
   cursor: pointer;
   background: url(<%=CONTEXT_PATH%>images/icon_list.gif) no-repeat right;
   width: 50px;
   height: 18px;
   line-height: 18px;
   border: none;
   margin-right: 3px;
   margin-top: 44px;
   font-size: 12px;
   color: #000000;
   padding: 2px 0 0 0px;
   text-align: right;
}

#header #topHome {
   background-position: -90px -151px;
}

#header #topHelp {
   background-position: -90px -100px;
}

#header #topExit {
   background-position: -90px 2px;
}

#header #topPwd {
   background-position: -90px -280px;
}

#header .headerBtn:hover {
   color: #ff0000
}

#container {
   width: 100%;
   height: 100%;
   zoom: 1;
   overflow: hidden;
   position: absolute;
}

#back_frame {
   position: absolute;
   left: 0px;
   top: 0px;
   height: 100%;
   width: 100%;
   display:none;
}
</style>
<script type="text/javascript">
	 var contextpath = "<%=CONTEXT_PATH%>";	
	 var imgPath="<%=CONTEXT_PATH%>dhtmlx/imgs/icon/";
	 
    var editMode;       

   function go(link,title,fName){
   	  var f="leaf.gif";
   	  if(fName) f=fName;
      var img="<img src='"+imgPath+f+"' />";  

      var t="<font style='font-size:12px; font-weight:bold'>"+title+"</font>";
      dhxToolbar.removeItem("img");
      dhxToolbar.removeItem("title");
   	  dhxToolbar.addText("img", 0,img);
   	  dhxToolbar.addText("title", 1,t);
   	  if(title=='首页'||title=='帮助') centerPanel.hideToolbar(); else centerPanel.showToolbar();
      var cont=window.document.getElementById('container');
      cont.src=contextpath+link;
   }
   function changetitle(title){
   	  var t="&lt;font style='font-size:12px; font-weight:bold'&gt;"+title+"&lt;/font&gt;";
      dhxToolbar.removeItem("title");
   	  dhxToolbar.addText("title", 0,t);
   }
   function showmain(){
   		window.location.href='<%=CONTEXT_PATH%>main.jsp';
   }
   function logout(){
   	if(confirm('是否真的要注销并重新登录?')==true){
   		window.location.href='<%=CONTEXT_PATH%>login.do?action=logout';
   	}
   }
   function checklogin(){
   		var url='<%=CONTEXT_PATH%>login.do?action=checklogin';
   		var loader=dhtmlxAjax.postSync(url,'');
   		var value = loader.xmlDoc.responseText;
   		if(value!='OK'){
   			alert('您还未登录系统');
   			window.location.href='login.jsp';
   		}
   }
   
   function goCategray()  {
//        var url_link=contextpath+'jsp/demo/standard/stdCategary_list.jsp';
		var url_link=contextpath+'/meta/stdCategory.do';
       editMode=="CATEGRAY";
       openWindow("数据分类管理",url_link,800,500,this);	  
   }
   
   function goChangePwd()  {
       var url_link=contextpath+'/system/sysUser.do?action=MYPWD';
       editMode=="PWD";
       openWindow("修改密码",url_link,300,170,this);	  
   }
   
   function goProperty()  {
       var url_link=contextpath+'/system/sysProperty.do';
       editMode=="PROPERTY";
       openWindow("首选项",url_link,500,300,this);
   }
   function goPlan(){
	   alert("数据录入点击事件！");
   }
   function goHelp(){
	   
   }
   
</script>
</head>
<body onload="">
<!-- 
  <body onload="checklogin()"> 
-->


   <div id="topBanner" style="display: none;">
      <div id="sysName"></div>
      <div id="header">
         <div id="logSate" style="">
           
            <%=userString%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span id="showTime"></span>
         </div>
         <div id="hInput">
            <button name="topPage" id="topHome" type="button" onclick="go('system/blank.do','首页','code_child.gif')" class="headerBtn">首页</button>
            <button id="topHelp" type="button" onclick="goHelp()" class="headerBtn">帮助</button>
            <button id="topPwd" type="button" onclick="goChangePwd()" class="headerBtn1">修改密码</button>
            <button id="topExit" type="button" onclick="logout()" class="headerBtn">退出</button>
         </div>
      </div>
      <div id="sysMenu" >菜单</div>
   </div>
   <script type="text/javascript">
   var serverTime='<%out.print(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS").format(new Date()));%>';
	var teptime=serverTime.split('-');
    date = new Date();   
    date.setYear(teptime[0]);
    date.setMonth(teptime[1]);
    date.setDate(teptime[2]);
    date.setHours(teptime[3],teptime[4],teptime[5],teptime[6]);
    
	setTimeout('updateCurrentDate('+'<% out.print(new java.util.Date().getTime());%>'+')', 100);     
	updateCurrentDate = function(time) {   
	    date.setTime(parseInt(time) + 1000);   
	    //alert(date.toLocaleString());
	    //alert(teptime);
//	    document.getElementById('showTime').innerHTML=date.toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());
	    setTimeout('updateCurrentDate('+date.getTime()+')', 1000);   
	} 

	 var dhxLayout = new dhtmlXLayoutObject(document.body, "2E");
	 dhxLayout.setSkin("dhx_skyblue");
	 var topPanel=dhxLayout.cells("a");
	 var centerPanel=dhxLayout.cells("b");

	 topPanel.setHeight(91);
	 topPanel.hideHeader();
	 topPanel.fixSize(true,true);
	 topPanel.attachObject("topBanner");
	  

	 var menu = new dhtmlXMenuObject("sysMenu","dhx_skyblue");
   var menustr="<menu>";
  
<gl:menu code="A99" id="div9" title="系统管理" img="css/navImg/settings-icon16.png">
	<item code="A9901" onclick="go('system/sysOrg.do','组织机构管理','7-1.gif')" text="组织机构管理" img="css/navImg/7-1.gif" />
	<item code="A9902" onclick="go('system/sysRole.do','角色权限管理','7-2.gif')" text="角色权限管理" img="css/navImg/7-2.gif" />
	<item code="A9903" onclick="go('system/sysUser.do','用户管理','7-3.gif')" text="用户管理" img="css/navImg/7-3.gif" />
	<item code="A9904" onclick="go('system/sysCode.do','系统代码管理','7-7.gif')" text="系统代码管理" img="css/navImg/7-7.gif" />
</gl:menu>
   menustr+="</menu>";
   menu.loadXMLString(menustr);
   menu.attachEvent("onClick", menuclick);

   
   function menuclick(id){
   	eval(menu.getUserData(id,"onclick"));
   } 
//dashboardAction.do
</script>
   <div id="mainFrame">
      <iframe id="container" src="blank.jsp" style="overflow-y: hidden !important; overflow-x: hidden !important; width: 100%; height: 100%;" frameborder="0" ></iframe>
   </div>
   <iframe id="back_frame" name="back_frame" src="#" allowtransparency="true" frameborder="0" scrolling="no"></iframe>
   <script type="text/javascript">
	 centerPanel.hideHeader();
	 centerPanel.attachObject("mainFrame");
   var dhxToolbar = centerPanel.attachToolbar();
   dhxToolbar.addText("title", 0,"");
   centerPanel.hideToolbar();
</script>
<%@include file="/common/topDialog.jsp" %>
</body>
</html>