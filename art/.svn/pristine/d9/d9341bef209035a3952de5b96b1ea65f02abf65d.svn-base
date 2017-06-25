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

        var pageLink = contextpath + 'appManager/appArtistPageManager.do';
        
        var pageAction = pageLink + '?action=PAGE';
        
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
  
        function goAdd() {
    		openWindow("添加首页设置", pageLink + '?action=ADD&record.tempId='+$$('templateId').value, 0.8, 0.8);
    	}
        
        function goModify() {
    		var id = findSelected("修改",grid);
    		if(id == "") return;
    		openWindow("修改", pageLink + '?action=EDIT&ids='+id, 0.8, 0.8);
    	}
        
        function goDel() {
    		var id = findMultiSelected("删除",grid);
    		if(id == "") return;
    		var res = confirm("是否真的要删除?");
    		if(res == true) {
    			var data = ajaxSubmit(pageLink + "?action=DELETE&ids=" + id, 'appArtistPageTemplateManagerForm');
    			if (data.exit > 0) {
    				alert(data.message);
    				return;
    			} else {
    				goSreach(); 
    			}
    		}
    	}
        
        function checkFormInput() {
            if (!checkString(getElement('form.record.templateName'), "模板名", 30, true)) return;
            return true;
        }

        function closedialog(ret) {
            if (ret == 'true') {
            	goSreach();
            }
            editMode = "";
        }

		function goSreach(){
			var data = ajaxSubmit(fulllink + pageAction,"appArtistPageTemplateManagerForm");
			if(data.exit>0){
				alert(data.message);
				return;
			} else {
				grid.clearAll();
				grid.parse(data,'json');
				grid.checkAll(false);
			} 
		} 
        
        function init() {
            showMessage('<s:property value="errorMessage" escape="false"/>');
            goSreach();
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
	<div class="special-padding" id="mainDiv">
		<s:form action="appArtistPageTemplateManager" id="appArtistPageTemplateManagerForm"
			method="post" namespace="/appManager">
			<s:hidden name="form.record.id" id="templateId"/>
			<table id="tbl" cellpadding="0" cellspacing="0" width="99%" class="formTable">
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
			<table id="btn" width="99%" cellspacing="1" cellpadding="1"
				class="controlTable">
				<tr>
					<td>
						<gl:button styleClass="sbuBtnStyle" icon="addIcon" onClick="goAdd()">增加</gl:button> 
						<gl:button styleClass="sbuBtnStyle" icon="subIcon" onClick="goModify()">修改</gl:button>
						<gl:button styleClass="sbuBtnStyle" icon="delIcon" onClick="goDel()">删除</gl:button>
					</td>
				</tr>
			</table>	
			<div id="gridDiv"></div>
			<script language="javascript">
				var grid = new dhtmlXGridObject("gridDiv");
				grid.setImagePath(imagePath);
				var headAlign = [tCenter,tCenter,tCenter,tCenter,tCenter,tCenter];
				grid.setHeader("#master_checkbox,图片,颜色,自定义颜色,位置,描述",null, headAlign);
				grid.setInitWidthsP("5,20,10,10,10,45");
				grid.setColAlign("center,center,center,center,center,center");
				grid.setColTypes("ch,ro,ro,ro,ro,ro");
				grid.setColSorting("na,str,str,str,str,str");
				grid.init();
				var gDiv = $$('gridDiv');
			</script>
		</s:form>
	</div>
	<div id="btnDiv" class="btnDiv">
		<gl:button name="btnAdd" onClick="goSubmit()">保存</gl:button>
		&nbsp;
		<gl:button name="btnAdd" onClick="goCancel()">取消</gl:button>
	</div>

	<%@include file="/common/dialog.jsp"%>
	<script type="text/javascript">
		if(window.addEventListener) {
			window.addEventListener("resize",goResize,false); 
		}
		else {
			window.attachEvent('onresize',goResize);
		}
		  
		var mDiv = window.document.getElementById('mainDiv');
		var tDiv = window.document.getElementById('tbl');
		var btn = window.document.getElementById('btn');
		var bDiv = window.document.getElementById('btnDiv');
		   
		function goResize(){
			var he;
			if(isIE()) he = window.document.body.offsetHeight; else he=window.innerHeight;
			mDiv.style.height = he - 42+"px";
			gDiv.style.height = mDiv.offsetHeight - bDiv.offsetHeight - btn.offsetHeight - btn.offsetTop + 2 + "px";
			tDiv.style.width  = mDiv.offsetWidth - 4 + "px";
			gDiv.style.width  = mDiv.offsetWidth - 6 + "px";
			btn.style.width   = tDiv.offsetWidth + "px";
			bDiv.style.top    = mDiv.offsetHeight + mDiv.offsetTop*2 + "px";
		}
		goResize();   
	</script> 
	
	
</body>
</html>