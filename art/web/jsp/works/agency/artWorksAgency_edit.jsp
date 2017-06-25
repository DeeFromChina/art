<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp" %>
<script language="javascript">		
	
	var fulllink = contextpath + "works/ArtWorksAgency.do";

	function goCancel(){
		parent.closedialog('false');
		
	}

	function goSubmit() {
		if(checkFormInput()){
		    var url =fulllink+"?action=UPDATE";
		  	document.forms[0].action=url;
			document.forms[0].submit();
		}
	}
	
	function checkFormInput(){
		if(!checkString(getElement('record.agencyName'),"机构",100,true)) return;
		return true;
	}
	
	function closedialog(ret) {
		var res=ret['ret'];
		if(res==true) {
			if(editMode=="Agency"){
		    	 getElement('record.agencyId').value=ret['str'];
		    	 getElement('record.agencyName').value=ret['str1'];
		    }
		}
		
		editMode="";
	}

	function init(){
		showMessage('<s:property value="errorMessage" escape="false"/>');
	}
	
	function goArtAgency(){
		editMode="Agency"
			var url_link="<%=CONTEXT_PATH%>system/artAgency.do?query.parameters.type=1";
	    openWindow("选择机构",url_link,0.8,0.8);	
	}
	
	</script>
<style type="text/css"> 
   html, body {width:100%; height:100%; margin:0px; padding:0px; overflow:hidden;}
</style>
</head>
 
<body onload="init()">
	<s:form action="ArtWorksAgency" id="ArtWorksAgencyForm" method="post" namespace="/works">
			<s:hidden name="record.worksId" id="worksId"/>
			<s:hidden name="record.id" id="id"/>
			<div id="formDiv" class="formDiv" style="padding: 0px;">
			<table cellpadding="0" cellspacing="0" width="99%" class="formTable">
				<tr>
					<td class="textR" width="15%" ><font color="red">*</font>机构：</td>
					<td width="35%" class="textL">
						<s:textfield readonly="true" name="record.agencyName" style="width:80%;" />
  	                    <s:hidden name="record.agencyId" />
  	                    <gl:button name="btnArtAgency" styleClass="btnFormStyle" onClick="goArtAgency()">选择</gl:button>
					</td>
				</tr>
				<tr>
					<td class="textR" valign="top">时间：</td>
					<td><s:textfield name="form.record.collectTime" placeholder="xxxx年xx月xx日"></s:textfield></td>
			    </tr> 
				<tr>
					<td class="textR" valign="top">描述：</td>
					<td><s:textarea height="80px" name="form.record.collectDesc"></s:textarea></td>
			    </tr> 
		 	</table>
	</div>
</s:form>

<div id="btnDiv" class="btnDiv">
	<gl:button name="btnAdd" onClick="goSubmit()" >保存</gl:button>&nbsp;
	<gl:button name="btnAdd" onClick="goCancel()" >关闭</gl:button>
</div>

<%@include file="/common/resize.jsp" %>
<%@include file="/common/dialog.jsp"%>

</body>
</html>