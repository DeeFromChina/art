<%@page import="com.golead.common.model.SysResource"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.*" %>
<%@page language="java" pageEncoding="UTF-8" import="com.golead.core.util.Const,com.golead.core.web.UserSession"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
   String path1 = request.getContextPath();
	String CONTEXT_PATH1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path1 + "/";
%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7;ie=8" />
<link rel="stylesheet" type="text/css" href="<%=CONTEXT_PATH1%>dhtmlx/dhtmlx.css" />
<script src="<%=CONTEXT_PATH1%>dhtmlx/dhtmlx.js"></script>
  <script language="javascript" src="<%= CONTEXT_PATH1 %>/js/ctrl_util.js"></script>
  <head>
  <style type="text/css">
  .pdiv {
   width: 55px;
   height: 100px;
   border: none;
   color:black;
   text-align:center;
   font-size:12px;
   cursor:hand;
   margin:0 auto;
//   background-color:red;
}
</style>
<body>
<table width="100%" cellspacing="0" cellpadding="0" border="0">
<%
UserSession userSession = (UserSession) request.getSession().getAttribute(Const.SESSION);
Map<String,String> pros=userSession.getPropertys();
String shortCut = pros.get("shortCut");
if(shortCut!=null){
List<SysResource> resources=(List<SysResource>)request.getAttribute("resources");
int j=0;
for(int i=0;i<resources.size();i++){
	SysResource resource=resources.get(i);
	String resCode=resource.getResCode();
	if(shortCut.indexOf(resCode+";")>-1){
%>
<%if(j%2==0) {%><tr><%}%>
<td>
<div class='pdiv' onclick="javascript:window.parent.go('<%=resource.getActionUrl()%>','<%=resource.getResName() %>','people.gif');">
   <div style="height:50px;text-align:center;background:url(<%=CONTEXT_PATH1%>images/icon48-<%=j+1%>.png) no-repeat center top;">
   </div>
<%=resource.getResName() %>
</div>
</td>
<%if(j%2==1) {%></tr><%}%>
<%
	j++;
	}
}
if(j%2==1) {%><td>&nbsp;</td></tr><%
   }
}
%>
</table>
</body>	
</html>	
	 