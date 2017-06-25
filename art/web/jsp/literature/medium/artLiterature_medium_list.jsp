<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/header.jsp"%>

<script language="javascript">  
	var hyperlink = "../literature/ArtLiteratureMedium.do";	
	var fulllink = contextpath + "literature/ArtLiteratureMedium.do";		
      
	function goAdd()  {
		editMode="ADD";
	    openWindow("添加相关视频/声音",fulllink+'?action=ADD',0.7,0.9);
	}
	
	function view(id) {
	       /* var url_link=fulllink+'?action=VIEW&record.id='+id;
	       editMode="VIEW";
	       openWindow("查看相关视频/声音信息",url_link,0.7,0.9); */	
		url_link = fulllink+'?action=EDIT&record.id='+id;
		editMode="EDIT";
	    openWindow("修改相关视频/声音信息",url_link,0.7,0.9);	
	}
	
	function goModify(){
		var id = findSelected("修改",ArtLiteratureMedium_grid);
		if (id == "") return;
		url_link = fulllink+'?action=EDIT&record.id='+id;
		editMode="EDIT";
	    openWindow("修改相关视频/声音信息",url_link,0.7,0.9);	  
	}

	function goDel()  {
		var id = findMultiSelected("删除",ArtLiteratureMedium_grid);
		if (id == "") return;
		var res = confirm("是否要删除？");
		if (res == true){
			var data = ajaxSubmit(fulllink+"?action=delete&ids=" + id,"ArtLiteratureMediumForm");
			if(data.exit>0){
	 			  alert(data.message);
	 			  return;
	 		}else {	  
	 			goSearch();
	 		} 
		}
	}
	
	function goImport() {
		editMode="EXCEL";
		url_link = fulllink+'?action=IMPORT';
		openWindow("导入相关视频/声音",url_link,0.5,0.5);
	}
	
	function downloadTemp() {
		document.forms[0].action = fulllink + "?action=DOWNLOAD";
		document.forms[0].target = "_self";
		document.forms[0].submit();
	}
	
	function renew()  {
		var order = getElement("query.order");                  order.value="";
		var desc = getElement("query.orderDirection");          desc.value="";
		var pn = getElement("query.pageNumber");                pn.value="1";
		var ps = getElement("query.pageSize");                  ps.value="10";
	    goSearch();
	}

	function closedialog(ret){
		var res=ret['ret'];
		if(res==true) {
	    	 getElement('query.parameters.artArtistId').value=ret['str'];
	    	 getElement('query.parameters.artArtistName').value=ret['str1'];
	     }
	    if(ret==true || ret=='true') {
	   		goSearch();
	    }
	    if(ret == 'false' && editMode=="EXCEL"){
			goSearch();
		}
		editMode="";
	}
	
	function goSearch(){
		goArtLiteratureMediumGridSearch(); 
	}
	
	function init(){
		showMessage('<s:property value="errorMessage" escape="false"/>');
		hide();
		renew();
	} 
	
	function hide(){
		if(document.getElementById('hide').value==1){
			$(".controlTable").each(function(){
				this.style.display="none";
			});
		}
	}

	function goExport(){
		document.forms[0].action = fulllink + "?action=EXPORT";
		document.forms[0].target = "_self";
		document.forms[0].submit();
	}
	
	function goArtArtist(){
		var url_link=contextpath+'literature/ArtLiteratureWords.do?action=ARTIST&ids='+$$("artArtistId").value;
	    openWindow("选择艺术家",url_link,200,300);	
	}
</script>

<style type="text/css">
html,body {
	width: 100%;
	height: 100%;
}
</style>
</head>

<body onload="init()">
	<div class="special-padding" id="mainDiv">
		<s:form action="ArtLiteratureMedium" id="ArtLiteratureMediumForm" method="post" namespace="/literature" enctype="multipart/form-data">
			<s:hidden name="record.hide" id="hide"/>
			<s:hidden name="query.order" />
			<s:hidden name="query.orderDirection" />
			<s:hidden name="query.pageNumber" />
			<s:hidden name="query.recordCount" />
			<s:hidden name="query.pageCount" />
		 	<table width="99%" id="tbl" cellpadding="0" cellspacing="0" class="queryTable">
				<tr>
					<td class="textL">
						&nbsp;&nbsp;艺术家：<s:textfield style="width:150px;" name="query.parameters.artArtistName" />
						&nbsp;&nbsp;文献标题：<s:textfield style="width:150px;" name="query.parameters.literatureTitle"/>
						&nbsp;&nbsp;制作方：<s:textfield style="width:150px;" name="query.parameters.shotPeople"/>
						&nbsp;&nbsp;文献提及作品：<s:textfield style="width:150px;"  name="query.parameters.literatureWorks"/>
						&nbsp;&nbsp;引用文献：<s:textfield style="width:150px;"  name="query.parameters.quoteLiterature"/>
						<br/>
						&nbsp;&nbsp;文献相关人物：<s:textfield style="width:150px;"  name="query.parameters.personInvolved"/>
						&nbsp;&nbsp;文献相关展览：<s:textfield style="width:150px;"  name="query.parameters.relatedExhib"/>
						&nbsp;&nbsp;文献相关事件：<s:textfield style="width:150px;"  name="query.parameters.relatedEvent"/>
						&nbsp;&nbsp;<gl:button name="btnQuery" onClick="goSearch()">查询</gl:button>
					</td>
				</tr>
			</table>
			<table id="btn" width="99%" cellspacing="1" cellpadding="1" class="controlTable">
				<tr>
					<td>
						<gl:button styleClass="sbuBtnStyle" icon="addIcon" onClick="goAdd()">增加</gl:button> 
						<gl:button styleClass="sbuBtnStyle" icon="subIcon" onClick="goModify()">修改</gl:button> 
						<gl:button styleClass="sbuBtnStyle" icon="delIcon" onClick="goDel()">删除</gl:button>

						<gl:button name="btnQuery" onClick="goExport()">导出</gl:button>
					</td>
				</tr>
			</table>
			<gl:grid styleClass="pageTurn" id="ArtLiteratureMedium" page="true" form="ArtLiteratureMediumForm"  property="query" cellPadding="0" cellSpacing="0">
				var grid = new dhtmlXGridObject();
         	    grid.setImagePath(imagePath);
				var headAlign = [tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter];
				grid.setHeader("#master_checkbox,艺术家,标题,时长,制作方,拍摄时间,内容描述,文献提及作品,文献相关人物,文献相关展览,文献相关事件",null, headAlign);
				grid.setInitWidthsP("3,7,10,5,7,7,12,12,12,12,12");
				grid.setColAlign("center,center,center,center,center,center,center,center,center,center,center");
				grid.setColTypes("ch,ro,link,ro,ro,ro,ro,ro,ro,ro,ro");
				grid.setColSorting("na,str,str,str,str,str,str,str,str,str,str");
				grid.enableMultiline(true);
				grid.init();
				var gDiv = $$('ArtLiteratureMedium_box');
			</gl:grid>
		</s:form>
	</div>
	
<%@include file="/common/dialog.jsp"%>
<script type="text/javascript">
    if(window.addEventListener) {
 	     window.addEventListener("resize",goResize,false); 
    }
    else {
 	     window.attachEvent('onresize',goResize);
    }
    
	 var gDiv=window.document.getElementById('ArtLiteratureMedium_box');
	 var mDiv=window.document.getElementById('mainDiv');
	 var tDiv=window.document.getElementById('tbl');
	 var btn=window.document.getElementById('btn');
	    
	function goResize(){
		var he;
		if(isIE()) he=window.document.body.offsetHeight; else he=window.innerHeight;

		mDiv.style.height=he-42+"px";
		gDiv.style.height=mDiv.offsetHeight-btn.offsetHeight-btn.offsetTop+1+"px";
		tDiv.style.width=mDiv.offsetWidth-4+"px";
		gDiv.style.width=mDiv.offsetWidth-6+"px";
		btn.style.width=tDiv.offsetWidth+"px";
	}
    goResize();   
</script> 

</body>
</html>