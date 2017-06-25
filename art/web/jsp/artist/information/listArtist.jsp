<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/header.jsp"%>

<script language="javascript">  
	var hyperlink = "../artist/ArtistInformation.do";	
	var fulllink = contextpath + "artist/ArtistInformation.do";		
      
	function goAdd()  {
		editMode="ADD";
	    openWindow("添加艺术家",fulllink+'?action=ADD',0.99,0.99);
	}
	
	function view(id) {
	       /* var url_link=fulllink+'?action=VIEW&ids='+id;
	       editMode="VIEW";
	       openWindow("查看艺术家信息",url_link,0.8,0.8); */
		url_link = fulllink+'?action=EDIT&ids='+id;
		editMode="EDIT";
	    openWindow("修改艺术家信息",url_link,0.99,0.99);
	}
	
	function goModify(){
		var id = findSelected("修改",ArtistInformation_grid);
		if (id == "") return;
		url_link = fulllink+'?action=EDIT&ids='+id;
		editMode="EDIT";
	    openWindow("修改艺术家信息",url_link,0.99,0.99);	  
	}

	function goDel()  {
		var id = findMultiSelected("删除",ArtistInformation_grid);
		if (id == "") return;
		var res = confirm("是否要删除？");
		if (res == true){
			var data = ajaxSubmit(fulllink+"?action=delete&ids=" + id,"ArtistInformationForm");
			if(data.exit>0){
	 			  alert(data.message);
	 			  return;
	 		}else {	  
	 			goSearch();
	 		} 
		}
	}
	
	function goImport() {
		url_link = fulllink+'?action=IMPORT';
		openWindow("导入艺术家",url_link,0.5,0.5);
	}
	
	function goExport(){
		editMode="EXCEL";
		document.forms[0].action = fulllink + "?action=EXPORT";
		document.forms[0].target = "_self";
		document.forms[0].submit();
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
		if(ret==true || ret=='true') {
	   		goSearch();
		}
		if(ret == 'false' && editMode=="EXCEL"){
			goSearch();
		}
		editMode="";
	}
	
	function goSearch(){
		goArtistInformationGridSearch(); 
	}
	
	function init(){
		showMessage('<s:property value="errorMessage" escape="false"/>');
		renew();
		hide();
	} 

	function goSelect(){
		var selectType=$$("selectType").value;
		if(selectType.indexOf('m')>-1){
			var id = findMultiSelected("选择艺术家",ArtistInformation_grid);
			if (id == "") return;
			var str="";
			var str1="";
			var ids=id.split(",");
			  for(var i=0;i<ids.length;i++){
				  var name = ArtistInformation_grid.cellById(ids[i],2).getValue();
				  name = name.split("^")[0];
				  str+=ids[i];
				  str1+=name;
				  if((i+1)!=ids.length){
					  str+=",";
					  str1+="、";
				  }
			  }
			  var ret=new Object();
			  ret['ret']=true;
			  ret['str1']=str;
			  ret['str2']=str1;
			  parent.closedialog(ret);
			
		} else {
			var id = findSelected("选择艺术家",ArtistInformation_grid);
			if (id == "") return;
			var name = ArtistInformation_grid.cellById(id,2).getValue();
			name = name.split("^")[0];
			var ret=new Object();
			ret['ret']=true;
			ret['str']=id;
			ret['str1']=name;
			parent.closedialog(ret);
		}
	}
	
	function hide(){
		if(document.getElementById('hide').value==1){
			$(".controlTable").each(function(){
				this.style.display="none";
			});
		}
	}
	
</script>

<style type="text/css">
html,body {
	width: 100%;
	height: 100%;
}
a img{ border:none}
</style>
</head>

<body onload="init()">
	<div class="special-padding" id="mainDiv">
		<s:form action="ArtistInformation" id="ArtistInformationForm" method="post" namespace="/artist" enctype="multipart/form-data">
			<s:hidden name="record.hide" id="hide" />
			<s:hidden name="query.order" />
			<s:hidden name="query.orderDirection" />
			<s:hidden name="query.pageNumber" />
			<s:hidden name="query.recordCount" />
			<s:hidden name="query.pageCount" />
			<s:hidden name="query.parameters.selectType" id="selectType" />
		 	<table width="99%" id="tbl" cellpadding="0" cellspacing="0" class="queryTable">
				<tr>
					<td width="100%" style="height:30px;" class="textL">&nbsp;&nbsp;
						&nbsp;&nbsp; 艺术家姓名：<s:textfield style="width:150px;"  name="query.parameters.cName"/>&nbsp;&nbsp;
						&nbsp;&nbsp;<gl:button name="btnQuery" onClick="goSearch()">查询</gl:button>
					</td>
				</tr>
			</table>
			<table id="btn" width="99%" cellspacing="1" cellpadding="1" class="controlTable">
				<tr>
					<td>
					<s:if test="query.parameters.type==1">
						<gl:button styleClass="sbuBtnStyle" icon="subIcon" onClick="goSelect()">确认</gl:button>
					</s:if>
					 <s:else>
						<gl:button styleClass="sbuBtnStyle" icon="addIcon" onClick="goAdd()">增加</gl:button> 
						<gl:button styleClass="sbuBtnStyle" icon="subIcon" onClick="goModify()">修改</gl:button> 
						<gl:button styleClass="sbuBtnStyle" icon="delIcon" onClick="goDel()">删除</gl:button>
						<gl:button styleClass="sbuBtnStyle" icon="delIcon" onClick="goImport()">导入</gl:button>
						<gl:button styleClass="sbuBtnStyle" icon="delIcon" onClick="downloadTemp()">下载模板</gl:button>
						<%--<gl:button name="btnQuery" onClick="goExport()">导出</gl:button>--%>
					</s:else>
					</td>
				</tr>
			</table>
			<gl:grid styleClass="pageTurn" id="ArtistInformation" page="true" form="ArtistInformationForm"  property="query" cellPadding="0" cellSpacing="0">
				var grid = new dhtmlXGridObject();
         	    grid.setImagePath(imagePath);
				var headAlign = [tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter];
				grid.setHeader("#master_checkbox,艺术家照片缩略图,中文名,英文名,性别,生日期,卒日期,出生国家,出生地点,祖籍,国籍,星座,现居住工作地,艺术家时期类型",null, headAlign);
				grid.setInitWidthsP("3,10,8,8,4,7,7,8,8,7,7,7,8,8");
				grid.setColAlign("center,center,center,center,center,center,center,center,center,center,center,center,center,center");
				grid.setColTypes("ch,ro,link,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro");
				grid.setColSorting("na,str,str,str,str,str,str,str,str,str,str,str,str,str");
				grid.enableMultiline(true);
				grid.init();
				var gDiv = $$('ArtistInformation_box');
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
    
	 var gDiv=window.document.getElementById('ArtistInformation_box');
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