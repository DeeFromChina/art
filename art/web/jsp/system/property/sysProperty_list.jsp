<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <%@include file="/common/header.jsp" %>
	<script type="text/javascript">
      var fulllink = contextpath + "system/sysProperty.do";		

	function goCancel(){
		 parent.closedialog(false);
	}
	
	function goSubmit(){
		alert("保存后需重新登录，首选项配置才会生效！");
		document.forms[0].action=fulllink+"?action=save";
		document.forms[0].submit();
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
  <div id="formDiv" class="formDiv" style="text-align:left!important;background:#d6e8fe;">
  <s:form method="post" namespace="/system" action="sysProperty">
  	 <table id="tblForm" cellpadding="0" cellspacing="0" width="99%" class="formTable">
			 <tr >
				  <td width="30%" class="textR">ETL任务执行时间：</td>
				  <td width="70%"><s:textfield name="record.etlJob" /></td>
			 </tr>
			 <tr >
				  <td width="30%" class="textR">警报任务执行时间：</td>
				  <td width="70%"><s:textfield name="record.alertJob" /></td>
			 </tr>
			 <tr >
				  <td width="30%" class="textR">账号同步时间：</td>
				  <td width="70%"><s:textfield name="record.hrJob" /></td>
			 </tr>
	 </table>
  </s:form>		
</div>
<div id="btnDiv" class="btnDiv">
			      <gl:button name="btnAdd" onClick="goSubmit()">保存</gl:button>
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
       fDiv.style.width=mainbody.offsetWidth-fDiv.offsetLeft*3+"px";
       bDiv.style.width=mainbody.offsetWidth-bDiv.offsetLeft*3+"px";
       fDiv.style.height=mainbody.offsetHeight-bDiv.offsetHeight-fDiv.offsetTop*3+"px";
       bDiv.style.top=fDiv.offsetHeight+fDiv.offsetTop*3+"px";
    }
    goResize();   
</script>   
</body>
</html>
