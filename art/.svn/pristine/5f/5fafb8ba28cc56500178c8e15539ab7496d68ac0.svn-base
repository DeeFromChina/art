<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <%@include file="/common/header.jsp" %>

	<script language="javascript">		
	var hyperlink = "../works/ArtWorksNetwork.do";
	var fulllink = contextpath + "works/ArtWorksNetwork.do";
	var fulllink_exhibit = contextpath + "literature/ArtLiteratureNetwork.do";

		// 用于浏览该题材下的用户
		function view(id) {
			editMode="VIEW";
			openWindow("查看媒体", fulllink_exhibit + "?action=view&record.id=" + id, 0.8, 0.8);
		}
   
		function goDel() {
			var id = findMultiSelected("删除",pub_grid);
			if(id == "") return;
			var res = confirm("是否真的要删除?");
			if(res == true) {
				var data=ajaxSubmit(fulllink+"?action=delete&ids=" + id,"publicationForm");
		 		if(data.exit>0){
		 			  alert(data.message);
		 			  return;
		 		}
		 		else {	  
		 			goSearch();
		 		} 
			}
		}
		
		function closedialog(ret) {
			var res=ret['ret'];
			if(res==true) {
				if(editMode=="ADD") {
					var data=ajaxSubmit(fulllink+"?action=SAVE&ids=" +  ret['str1'],"publicationForm");
			 		if(data.exit>0){
			 			  alert(data.message);
			 			  return;
			 		}
			 		else {	  
			 			goSearch();
			 		} 
				}
			}
			editMode="";
		}

		function goAdd() {
			editMode="ADD";
			var worksId = $$('worksId').value;
			var url_link = fulllink+"?action=ADD"+"&record.worksId="+worksId;
		    openWindow("选择媒体",url_link,0.8,0.8);	
		}

		function renew() {
			var order = getElement("query.order");                  order.value="";
			var desc =  getElement("query.orderDirection");         desc.value="";
			var pn =    getElement("query.pageNumber");             pn.value="1";
			var ps =    getElement("query.pageSize");               if(ps!=null) ps.value="15";
			goSearch();
		}

		function closedialog(ret) {
			if(ret==true || ret=='true') {
				goSearch();
			}	
			editMode="";
		}
		
		function init(){
			renew(); 
			hide();
		}

		function hide(){
			if(document.getElementById('hide').value==1){
				$(".controlTable").each(function(){
					this.style.display="none";
				});
			}
			if(document.getElementById('hide').value==1){
				$(".queryTable").each(function(){
					this.style.display="none";
				});
			}
		}
		
		function goSearch(){ 
			gopubGridSearch(); 
		}
	</script>

<style type="text/css">
   html, body {width:100%; height:100%;}
</style>
</head>

<body onload="init()">
<div class="special-padding"  id="mainDiv">  
<s:form action="pubWorks" id="publicationForm" method="post" namespace="/publication">
<s:hidden name="record.hide" id="hide"/>
<s:hidden name="query.order" />
<s:hidden name="query.orderDirection" />
<s:hidden name="query.pageNumber" />
<s:hidden name="query.recordCount" />
<s:hidden name="query.pageCount" />
<s:hidden name="query.parameters.worksId" id="worksId" />
	<table width="100%" id="tbl" cellpadding="0" cellspacing="0" class="queryTable">

		<tr>
            <td class="textL">
                &nbsp;&nbsp;标题：<s:textfield style="width:200px;" name="query.parameters.literatureTitle" />
                &nbsp;&nbsp;作者：<s:textfield style="width:200px;" name="query.parameters.literatureAuther" />
                &nbsp;&nbsp;文献提及作品：<s:textfield style="width:200px;" name="query.parameters.literatureWorks" />
                &nbsp;&nbsp;<gl:button name="btnQuery" onClick="goSearch()">查询</gl:button>
            </td>
  <%--<td class="textR">引用文献：</td>--%>
  <%--<td class="textL"><s:textfield style="width:200px;" name="query.parameters.quoteLiterature" /> </td>--%>
		<%--</tr>--%>
		<%--<tr>--%>
  <%--<td class="textR">文献相关人物：</td>--%>
  <%--<td class="textL"><s:textfield style="width:200px;" name="query.parameters.personInvolved" /> </td>--%>
  <%--<td class="textR">文献相关展览：</td>--%>
  <%--<td class="textL"><s:textfield style="width:200px;" name="query.parameters.relatedExhib" /> </td>--%>
  <%--<td class="textR">文献相关事件：</td>--%>
  <%--<td class="textL"><s:textfield style="width:200px;" name="query.parameters.relatedEvent" /> </td>--%>
		</tr>
	</table>
<table id="btn" width="100%" cellspacing="1" cellpadding="1" class="controlTable">
	<tr>
		<td>

			<gl:button styleClass="sbuBtnStyle"  icon="addIcon" onClick="goAdd()">增加</gl:button>
			<gl:button styleClass="sbuBtnStyle" icon="delIcon" onClick="goDel()">删除</gl:button>
		</td>
	</tr>	
</table>
<gl:grid styleClass="pageTurn" id="pub" page="true" form="publicationForm"  property="query" cellPadding="0" cellSpacing="0" >
   var grid = new dhtmlXGridObject();
   grid.setImagePath(imagePath);
   var headAlign=[tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter];
   grid.setHeader("#master_checkbox,标题,作者,链接,文献提及作品,引用文献,文献相关人物,文献相关展览,文献相关事件",null,headAlign);
   grid.setInitWidthsP("5,10,10,10,10,10,15,15,15");
   grid.setColAlign("center,center,center,center,center,center,center,center,center");
   grid.setColTypes("ch,link,ro,ro,ro,ro,ro,ro,ro");
   grid.setColSorting("na,str,str,str,str,str,str,str,str");
   gridSort("false,false,false,false,false,false,false,false,false");
   grid.setSkin("dhx_terrace");
   grid.init();
   var gDiv=$$('pub_box');
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
    
	 var gDiv=window.document.getElementById('pub_box');
	 var mDiv=window.document.getElementById('mainDiv');
	 var btn=window.document.getElementById('btn');
	    
    function goResize(){
   	 var he;
	    if(isIE()) he=window.document.body.offsetHeight; else he=window.innerHeight;

		 mDiv.style.height=he-42+"px";
		 var hide2=window.document.getElementById('hide');
		 if(hide2.value==1){
			 gDiv.style.height=mDiv.offsetHeight+"px";
		 }else{
		 	gDiv.style.height=mDiv.offsetHeight-btn.offsetHeight-btn.offsetTop+1+"px";
		 }
		 gDiv.style.width=mDiv.offsetWidth-6+"px";
    }
    goResize();   
</script>
</body>
</html>