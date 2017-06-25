<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@include file="/common/header.jsp" %>
    <script language="javascript">

        var hyperlink = "../appManager/appHomePageManager.do";
        var fulllink = contextpath + "appManager/appHomePageManager.do";

        function goCancel() {
            parent.closedialog('false');
        }

        function goSubmit() {
            if (checkFormInput()) {
                var url = fulllink + "?action=UPDATE";
                document.forms[0].action = url;
                document.forms[0].submit();
            }
        }

        function checkFormInput() {
            if (!checkString(getElement('form.record.homepageStatus'), "作者", 30, true)) return;
            if (!checkString(getElement('form.record.seqNo'), "序号", 30, true)) return;
            return true;
        }

        function checkFile() {
    		var isPass = true;
    		$(".checkFile").each(function(){
    			if(!checkString(this,"相片",60,true)) {
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
        
        function closedialog(ret) {
            if (ret == 'true') {
                goSearch();
            }
            editMode = "";
        }

        
        function goChange(re){
    		if(re == "1"){
    			document.getElementById("file").style.display="";
    			document.getElementById("cancel").style.display="";
    			document.getElementById("change").style.display="none";
    			$(".fileName").each(function(){
    				this.style.display="none";
    			});
    		}
    		if(re == "2"){
    			document.getElementById("file").style.display="none";
    			document.getElementById("cancel").style.display="none";
    			document.getElementById("change").style.display="";
    			$(".fileName").each(function(){
    				this.style.display="";
    			});
    		}
    	}

        function init() {
        	document.getElementById("cancel").style.display="none";
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
    <s:form action="appHomePageManager" id="appHomePageManagerForm" method="post" namespace="/appManager" enctype="multipart/form-data">
        <div id="formDiv" class="formDiv" style="padding: 0px;">
        	<s:hidden name="form.record.id"/>
            <table cellpadding="0" cellspacing="0" width="99%" class="formTable">
                <tr>
                    <td class="textR" width="15%">图片显示：</td>
                    <td>
						<table width="100%" cellpadding="0" cellspacing="0" class="tbnBtnStyle" border="0">
							<tr>
								<td>
									<a href="<s:property value='form.record.img'/>" target="_blank">点击显示图片</a>
									<input type="file" name="file" id="file" class="checkFile" style="display:none" />
								</td>
								<td width="45px">
									<gl:button name="btnArtArtist" styleClass="btnFormStyle" id="change" onClick="goChange('1')">更改</gl:button>
								</td>
								<td width="45px">
									<gl:button name="btnArtArtist" styleClass="btnFormStyle" id="cancel" onClick="goChange('2')">取消</gl:button>
								</td>
							</tr>
						</table>                    
                    </td>
                    
                    <td class="textR" width="15%"><font color="red">*</font>序号：</td>
                    <td width="35%"><s:textfield name="form.record.seqNo"/></td>
                </tr>
                <tr>
                    <td class="textR" width="15%">状态：</td>
                    <td colspan="3"><s:select list="codeSets.START_OR_STOP" listKey="value" listValue="codeName" name="form.record.homepageStatus"/></td>
                </tr>
            </table>
        </div>
    </s:form>

    <div id="btnDiv" class="btnDiv">
        <gl:button name="btnAdd" onClick="goSubmit()">保存</gl:button>&nbsp;
        <gl:button name="btnAdd" onClick="goCancel()">关闭</gl:button>
    </div>

    <%@include file="/common/dialog.jsp"%>
    <%@include file="/common/resize.jsp" %>
</body>
</html>