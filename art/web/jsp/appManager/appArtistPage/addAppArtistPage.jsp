<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp"%>
<script language="javascript">

        var hyperlink = "../appManager/appArtistPageManager.do";
        var fulllink = contextpath + "appManager/appArtistPageManager.do";

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

        function checkFile() {
    		var isPass = true;
    		$(".checkFile").each(function(){
    			if(!checkString(this,"图片",60,true)) {
    				isPass = false;
    				return false;
    			}
    			var format = this.value.split(".");
    			var i = format.length;
    			if(format[i-1] != "jpg" && format[i-1] != "jpeg" && format[i-1] != "gif" && format[i-1] != "png"){
    				alert("只能上传图片格式！");
    				isPass = false;
    				return false;
    			}
    		});
    		return isPass;
    	}
        
        function checkFormInput() {
            if (!checkString(getElement('form.record.seqNo'), "模块", 30, true)) return;
            if (!checkString(getElement('form.record.color'), "颜色", 30, true)) return;
            return true;
        }

        function closedialog(ret) {
            if (ret == 'true') {
                goSearch();
            }
            editMode = "";
        }


        function init() {
            showMessage('<s:property value="errorMessage" escape="false"/>');
            var colorSelf = new dhtmlXColorPicker("colorSelf");
            var color = new dhtmlXColorPicker("color");
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
	<s:form action="appArtistPageManager" id="appArtistPageManagerForm"
		method="post" namespace="/appManager" enctype="multipart/form-data">
		<div id="formDiv" class="formDiv" style="padding: 0px;">
			<s:hidden name="form.record.tempId" />
			<table cellpadding="0" cellspacing="0" width="99%" class="formTable">
				<tr>
					<td class="textR" width="15%"><font color="red">*</font>图片：</td>
					<td width="35%"><input type="file" name="file" id="file"
						class="checkFile" /></td>
					<td class="textR" width="15%"><font color="red">*</font>模块：</td>
					<td><s:select list="codeSets.ARTISRT_PAGE" listKey="value"
							listValue="codeName" name="form.record.seqNo" /></td>
				</tr>
				<tr>
					<td class="textR"><font color="red">*</font>颜色：</td>
					<td><s:textfield name="form.record.color" readonly="true" id="color" /></td>
					<td class="textR">自定义颜色：</td>
					<td><s:textfield name="form.record.colorSelf" readonly="true" id="colorSelf" /></td>
				</tr>
				<tr>
					<td class="textR">描述：</td>
					<td colspan="3"><s:textarea name="form.record.remark" /></td>
				</tr>
			</table>
		</div>
	</s:form>
	<div id="btnDiv" class="btnDiv">
		<gl:button name="btnAdd" onClick="goSubmit()">保存</gl:button>
		&nbsp;
		<gl:button name="btnAdd" onClick="goCancel()">关闭</gl:button>
	</div>

	<%@include file="/common/dialog.jsp"%>
	<%@include file="/common/resize.jsp"%>
</body>
</html>