<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp"%>
	<script language="javascript">

        var hyperlink = "../appManager/appArtistPageTemplateManager.do";
        var fulllink = contextpath + "appManager/appArtistPageTemplateManager.do";

        function goCancel() {
            parent.closedialog('false');
        }

        function goSubmit() {
            if (checkFormInput()) {
                var url = fulllink + "?action=SAVE";
                document.forms[0].action = url;
                document.forms[0].submit();
            }
        }

        function checkFormInput() {
            if (!checkString(getElement('form.record.templateName'), "模板名", 30, true)) return;
            return true;
        }

        function init() {
            showMessage('<s:property value="errorMessage" escape="false"/>');
        }

    </script>
<style type="text/css">
html, body {
	width: 100%;
	height: 100%;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
}
</style>
</head>

<body onload="init()">
	<s:form action="appArtistPageTemplateManager" id="appArtistPageTemplateManagerForm"
		method="post" namespace="/appManager">
		<div id="formDiv" class="formDiv" style="padding: 0px;">
			<table cellpadding="0" cellspacing="0" width="99%" class="formTable">
				<col width="15%"/>
				<col width="85%"/>
				<tr>
					<td class="textR"><font color="red">*</font>模板名：</td>
					<td ><s:textfield name="form.record.templateName" /></td>
				</tr>	
				<tr>
					<td class="textR">描述：</td>
					<td ><s:textarea name="form.record.templateRemark" /></td>
				</tr>
			</table>
		</div>
	</s:form>
	<div id="btnDiv" class="btnDiv">
		<gl:button name="btnAdd" onClick="goSubmit()">下一步</gl:button>
		&nbsp;
		<gl:button name="btnAdd" onClick="goCancel()">取消</gl:button>
	</div>
	<%@include file="/common/dialog.jsp"%>
	<%@include file="/common/resize.jsp"%>
</body>
</html>