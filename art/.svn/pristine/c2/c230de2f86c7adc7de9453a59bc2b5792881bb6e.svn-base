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
		 var ret=new Object();
		 ret['ret']=false;
		 ret['str']='';
		 ret['str1']='';
		 parent.closedialog(ret);
	}
	
	function goSubmit(){
		  var ids=$NAME('artArtistId');
		  var str="";
		  var str1="";

		  for(var i=0;i<ids.length;i++){
		  	 if(ids[i].checked) str+=ids[i].value;
		  	 if(ids[i].checked) str1+=ids[i].title;
		  }
			 var ret=new Object();
			 ret['ret']=true;
			 ret['str']=str;
			 ret['str1']=str1;
		    parent.closedialog(ret);
	}
  
	  function init(){
		  showMessage('<s:property value="errorMessage" escape="false"/>')
	  }
	  
	</script>
<style type="text/css">
   html, body {width:100%; height:100%; margin:0px; padding:0px; overflow:hidden;}
</style>
</head>

<body onload="init()">
<div id="formDiv" class="formDiv" style="left:0px;top:0px;text-align:left!important;background:white;border:1px solid #c1b2ff!important;">
  <s:form method="post" action="/works/artWorks.do">
  	 <s:hidden property="record.ids" />
  	 <s:iterator value="query.recordSet" id="item">
  	    <input type="radio" style="width:16px;" <s:property value="CHECKED"/> name="artArtistId" value="<s:property value='id'/>" 
	   	title="<s:property value='cname'/>" /><img style="width:16px;" src="<%=CONTEXT_PATH%>dhtmlx/imgs/icon/people.gif" /><span style="width:100px;"><s:property value="cname"/></span><br/>
  	 </s:iterator>
  </s:form>		
</div>
<div id="btnDiv" class="btnDiv">
			      <gl:button name="btnAdd" onClick="goSubmit()">确定</gl:button>
				    &nbsp;
			      <gl:button name="btnCancel" onClick="goCancel()">取消</gl:button>

</div>
<script type="text/javascript">
var mainbody=window.document.body;
if(window.addEventListener) {
	     window.addEventListener("resize",goResize,false); 
}
else {
	     window.attachEvent('onresize',goResize);
}

var fDiv=window.document.getElementById('formDiv');
var bDiv=window.document.getElementById('btnDiv');

function goResize(){
   fDiv.style.width=mainbody.offsetWidth-4+"px";
   bDiv.style.width=mainbody.offsetWidth-bDiv.offsetLeft*2+"px";
   fDiv.style.height=mainbody.offsetHeight-bDiv.offsetHeight-10+"px";
   bDiv.style.top=fDiv.offsetHeight+fDiv.offsetTop*2+"px";
}
goResize();
</script>
</body>
</html>
