<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
#importFile {
	width: 50%;
}
</style>
<script type="text/javascript">
	var fulllink = contextpath + "works/artPeriod.do";		

	function importTemp() {
		if (!checkString(getElement('importFile'), "文件", 300, true))
			return;
		var editMode = "EXCEL";
		var id=$$('id').value;
		document.forms[0].action = fulllink + "?action=" + editMode+"&record.id="+id;
		document.forms[0].submit();
	}

	function downloadTemp() {
		var editMode = "DOWNLOAD";
		document.forms[0].action = fulllink + "?action=" + editMode;
		document.forms[0].target = "_self";
		document.forms[0].submit();
	}

	function goCancel() {
		parent.closedialog('false');
	}

	function init() {
		showMessage('<s:property value="errorMessage" escape="false"/>');
	}
</script>
</head>
<body onload="init()">
	<div class="special-padding" id="mainDiv">
		<s:form action="artPeriod" id="artPeriodForm" method="post" ENCTYPE="multipart/form-data">
		<s:hidden name="record.id" id="id"/>
			<table width="100%" id="tbl" cellpadding="0" cellspacing="0"
				class="formTable">
				<tbody>
					<tr>
						<td width="20%" class="textR">请选择：</td>
						<td width="80%" class="textL"><s:file name="importFile"></s:file>
						</td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="2"><gl:button
								name="download" onClick="downloadTemp()">下载Excel模板</gl:button> <gl:button
								name="import" onClick="importTemp()">导入</gl:button> <gl:button
								name="cancel" onClick="goCancel()">关闭</gl:button>
						</td>
					</tr>
				</tbody>
			</table>
		</s:form>
	</div>
</body>
</html>