<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp" %>
<script language="javascript">		
	
	var fulllink = contextpath + "artist/ArtistWorksYear.do";

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
		if(!checkString(getElement('form.record.startYear'),"开始年份",4,true)) return;
		if(!checkString(getElement('form.record.endYear'),"结束年份",4,true)) return;
		if(!checkString(getElement('form.record.yearImportant'),"重要程度",4,true)) return;
		return true;
	}
	
	function closedialog(ret) {
		if(ret=='true') {
			goSearch();
		}
		editMode="";
	}

	function init(){
		showMessage('<s:property value="errorMessage" escape="false"/>');
	}
	

	</script>
<style type="text/css"> 
   html, body {width:100%; height:100%; margin:0px; padding:0px; overflow:hidden;}
</style>
</head>
 
<body onload="init()">
<s:form action="ArtistWorksYear" id="ArtistWorksYearForm" method="post" namespace="/artist">
	<s:hidden name="record.artistId" id="artistId"/>
    <s:hidden name="record.id" id="id"/>
	<div id="tblForm"></div>
	<div id="page_0"  style="padding:2px; height:100%; width:100%;">
		<div id="formDiv" class="formDiv" style="padding: 0px;">
			<table cellpadding="0" cellspacing="0" width="99%" class="formTable">
				<tr>
					<td class="textR" width="15%" ><font color="red">*</font>开始年份：</td>
					<td width="35%" ><s:textfield name="form.record.startYear"/></td>
					<td class="textR" width="15%" ><font color="red">*</font>结束年份：</td>
					<td width="35%" ><s:textfield name="form.record.endYear"/></td>
				</tr>
				<tr>
					<td class="textR" width="15%" ><font color="red">*</font>重要度：</td>
					<td width="35%" ><s:select list="codeSets.COMMENT_LEVEL" listKey="value" listValue="codeName" name="form.record.yearImportant"/></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
	</div>
    <iframe  id="page_1" name="page_1" width="100%" height="100%" scrolling="no" frameborder="0"></iframe>
</s:form>

<div id="btnDiv" class="btnDiv">
	<gl:button name="btnAdd" onClick="goSubmit()" >保存</gl:button>&nbsp;
	<gl:button name="btnAdd" onClick="goCancel()" >关闭</gl:button>
</div>


<%@include file="/common/dialog.jsp"%>
<script type="text/javascript">
    var mainbody=window.document.body;
    if(window.addEventListener) {
        window.addEventListener("resize",goResize,false);
    } else {
        window.attachEvent('onresize',goResize);
    }

    var fDiv=window.document.getElementById('formDiv');
    var bDiv=window.document.getElementById('btnDiv');
    var btbl=window.document.getElementById('tblForm');

    function goResize(){
        fDiv.style.width=mainbody.offsetWidth-fDiv.offsetLeft*2+"px";
        bDiv.style.width=mainbody.offsetWidth-bDiv.offsetLeft*2+"px";
        fDiv.style.height=mainbody.offsetHeight-bDiv.offsetHeight-fDiv.offsetTop*2+"px";
        bDiv.style.top=fDiv.offsetHeight+fDiv.offsetTop*2-5+"px";
        if(btbl){
            btbl.style.width=fDiv.offsetWidth-fDiv.offsetLeft-9+"px";
            btbl.style.height=fDiv.offsetHeight-fDiv.offsetTop-12+"px";
        }
    }
    goResize();

    var tabbar = new dhtmlXTabBar("tblForm", "top");
    tabbar.setSkin('dhx_terrace');
    tabbar.setArrowsMode("auto");
    tabbar.addTab("a0", "年代基本信息", "100px");
    tabbar.addTab("a1", "年代代表作", "100px");

    tabbar.enableAutoReSize(true);
    tabbar.enableTabCloseButton(true);

    tabbar.tabs("a0").attachObject("page_0");
    tabbar.tabs("a0").setActive();
    tabbar.tabs("a1").attachObject("page_1");

    window.frames["page_1"].location.href = fulllink +'?action=REPRESENTATIVE&query.parameters.artistId=' + $$('artistId').value + '&query.parameters.yearId=' + $$('id').value;;
</script>
</body>
</html>