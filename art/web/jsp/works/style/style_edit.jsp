<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <%@include file="/common/header.jsp" %>

	<script type="text/javascript">
		var fulllink = contextpath + "works/worksStyle.do";

		function goCancel() {
			parent.closedialog(false);
		}

		function goSubmit() {
		  if(!checkString(getElement('form.record.styleName'),"风格名称",100,true)) return;
		  if(!checkString(getElement('form.record.styleDesc'),"说明",200,false)) return;					
			
		  document.forms[0].action=fulllink+"?action=UPDATE";
    	  document.forms[0].submit();
		}
		
		  function init(){
			  showMessage('<s:property value="errorMessage" escape="false" />');
		  }
  </script>
  <style type="text/css">
     html, body {width:100%; height:100%; margin:0px; padding:0px; overflow:hidden;}
  </style>
</head>

<body onload="init()">
<div id="formDiv" class="formDiv">
   <s:form action="worksStyle" id="styleForm" method="post" namespace="/works">
  		<s:hidden name="form.record.id"/>
			<table id="tblForm" cellpadding="0" cellspacing="0" width="98%" class="formTable">
				<tr>
					<td width="20%" class="textR"><font color="red">*</font>风格名称：</td>
				  	<td width="80%">
						<s:textfield name="form.record.styleName" />
				  	</td>
				</tr>
				<tr>
			    	<td class="textR" valign="top">说明：</td>
				 	<td >
						<s:textarea name="form.record.styleDesc" ></s:textarea>
				 	</td>
				</tr>
	 		</table>
 </s:form>	
</div>
<div id="btnDiv" class="btnDiv">
		<gl:button name="btnAdd" onClick="goSubmit()">保存</gl:button>
		&nbsp;
	   <gl:button name="btnCancel" onClick="goCancel()">取消</gl:button>
</div>	  
<%@include file="/common/dialog.jsp" %>
<%@include file="/common/resize.jsp" %>
<script type="text/javascript">

</script>
</body>
</html>