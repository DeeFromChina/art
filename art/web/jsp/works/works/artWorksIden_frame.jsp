<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="/common/header.jsp" %>
  </head>
<frameset cols="160,160,*" frameborder="no" border="0" framespacing="0">
	<frame src="<%=CONTEXT_PATH%>works/artWorksIden.do?action=ARTIST" name="leftFrame" frameborder="1" scrolling="yes" noresize="noresize" id="leftFrame" title="leftFrame" />
	<frame name="centerFrame" frameborder="1" scrolling="yes" noresize="noresize" id="centerFrame" title="centerFrame" />
	<frame name="mainFrame" frameborder="1" scrolling="yes" id="mainFrame" title="mainFrame" />
</frameset>
<noframes><body>
</body>
</noframes>
</html>
