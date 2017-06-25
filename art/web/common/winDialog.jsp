<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%
	String path = request.getContextPath();
	String CONTEXT_PATH = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <meta http-equiv="x-ua-compatible" content="ie=7;ie=8" />
	<link rel="stylesheet" type="text/css" href="<%=CONTEXT_PATH%>dhtmlx/dhtmlx.css" />
	<link rel="stylesheet" type="text/css" href="<%=CONTEXT_PATH%>dhtmlx/dhtmlx_add.css" />
   <script src="<%=CONTEXT_PATH%>dhtmlx/dhtmlx.js"></script>
   <script language="javascript" src="<%=CONTEXT_PATH%>js/ctrl_util.js"></script>
 
   <style type="text/css">
      html, body {width:100%; height:100%;overflow:hidden;margin:0px;}
      body {background-color: transparent;}
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
   var title=decodeURI('<%=request.getParameter("t")%>');
   var urlink='<%=request.getParameter("l")%>';
   var width='<%=request.getParameter("w")%>';
   var height='<%=request.getParameter("h")%>';
   var zIndex;
   var cw;
   var dhxWinsGlb;
   var w;
   
   function open(){
    	dhxWinsGlb = new dhtmlXWindows();
//	   dhxWinsGlb.enableAutoViewport(false);
	   dhxWinsGlb.attachViewportTo("winvp");
//	   dhxWinsGlb.setImagePath("<%=CONTEXT_PATH%>dhtmlx/imgs/");
//	   dhxWinsGlb.setEffect("move", true);
	   var mainbody=window.document.body;
	   var left=(mainbody.offsetWidth-width)/2;
	   var top=(mainbody.offsetHeight-height)/2;

	  var zi=<%=request.getParameter("z")%>;
	  if(zi==null){
		 zIndex=200;
	  }
	  else {
		 zIndex=zi+200;
	  }
	  var bf=$$('back_frame');
 	  bf.style.zIndex=zIndex;
	  w = dhxWinsGlb.createWindow('wn', left,top, width,height);
     w.setText(title);
     w.setModal(true);
     w.button("park").hide();
     w.attachURL(urlink);
     w.attachEvent("onClose", doOnCloseWin);
     w.keepInViewport(true);   
   }

   function doOnCloseWin(win){
	  var fm=w.getFrame().contentWindow.document.forms[0];
	  if(typeof(fm)==="undefined") {
		   window.parent.closeWin();
	  }
	  else {
		   var dt=formIsDirty(fm);
		   if(dt){
		 	  var res=confirm("数据已修改，确定要退出？");
		 	  if(res){
		 		  window.parent.closeWin();
		 	  }
		    }
		    else{
			   window.parent.closeWin();
			}
	  }
   }
   
   function closeWin(){
	      var bf=$$('back_frame');
	      bf.src='<%=CONTEXT_PATH%>/common/blank.jsp';
 	      bf.style.display='none';
	      cw=null;
   }
   
   function closedialog(ret) {
	   if(ret==false||ret=='false') {
		  var fm=w.getFrame().contentWindow.document.forms[0];
		  if(typeof(fm)==="undefined") {
			   window.parent.closeWin();
			   return;
		  }
		  var dt=formIsDirty(fm);
		  if(dt){
			  var res=confirm("数据已修改，确定要退出？");
			  if(!res){
				  return;
			  }
		  }
	   }
	   
	   if(cw==null){
		   window.parent.closedialog(ret);
	   }
	   else {
	      var bf=$$('back_frame');
	      bf.src='<%=CONTEXT_PATH%>/common/blank.jsp';
 	      bf.style.display='none';
	      cw.closedialog(ret);
	      cw=null;
	   }
	}
   
   function closedialog2(ret) {
	   if(cw==null){
		   window.parent.closedialog2(ret);
	   }
	   else {
	      var bf=$$('back_frame');
	      bf.src='<%=CONTEXT_PATH%>/common/blank.jsp';
 	      bf.style.display='none';
	      cw.closedialog2(ret);
	      cw=null;
	   }
	}  

   function openWindow(title,urlink,width,height,pw){
    	cw=pw;
 	   var bf=$$('back_frame');
 	   bf.style.display='block';
 	   var ul=escape(urlink);
 	   var ln='<%=CONTEXT_PATH%>/common/winDialog.jsp?t='+title+'&l='+ul+'&w='+width+'&h='+height+'&z='+zIndex;
 	   bf.src=ln;
    }
  </script> 
</head>
<body onload="open()">
<div id="winvp" style="position: relative;height:100%;width:100%;"></div>
<iframe id="back_frame" name="back_frame" src="<%=CONTEXT_PATH%>/common/blank.jsp" allowtransparency="true" frameborder="0" scrolling="no"></iframe>
</body>
</html>