<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <%@include file="/common/header.jsp" %>

	<script type="text/javascript">
	 var fulllink = contextpath + "publication/pubLiterature.do";

		function goCancel() {
			parent.closedialog(false);
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
    <s:form action="pubLiterature" id="publicationForm" method="post" namespace="/publication">
  		<s:hidden name="form.record.id"/>
			<table id="tblForm" cellpadding="0" cellspacing="0" width="98%" class="formTable">
			   <s:hidden name="record.pubId"/>
				<tr>
					<td width="20%" class="textR">文献名称：</td>
				  	<td width="80%" class="textL">
						<s:property value="record.literatureName"  />
				  	</td>
				 </tr> 	
				 <tr>
			    	<td class="textR" >相关页码：</td>
				 	<td class="textL">
						<s:property value="record.pageNumber" />
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