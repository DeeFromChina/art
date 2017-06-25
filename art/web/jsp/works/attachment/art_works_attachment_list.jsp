<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/header.jsp"%>

<script language="javascript">
	var fulllink = contextpath + "works/artAttachment.do";
	var hyperlink = contextpath + "works/artAttachment.do";
	function closedialog(ret) {
			goSearch();
		/* if(ret=='true') {
		} */	
		editMode="";
	}
	
	function renew()  {
		var order = getElement("query.order");                  order.value="";
		var desc = getElement("query.orderDirection");          desc.value="";
		var pn = getElement("query.pageNumber");                pn.value="1";
		var ps = getElement("query.pageSize");                  ps.value="10";
	    goSearch();
	}

	function init() {
		showMessage('<s:property value="errorMessage" escape="false"/>');
		renew();
	}

	function goSearch() {
		goartAttachmentGridSearch();
	}
	
	function eXcell_button(cell){                             //excell name is defined here
	    if (cell){                                                     //default pattern, just copy it
	        this.cell = cell;
	        this.grid = this.cell.parentNode.grid;
	        eXcell_ro.call(this);                                //use methods of "ed" excell
	    }
	    
	    this.setValue=function(val){
	    	
	    	if(val != null && val.length > 0) {
	    		
		    var str=val.split('^');
			    if(str[0] != "null"){
					this.setCValue("<input type='button' style='height:20px;' onclick='goAllot("+str[2]+")' value='" + str[0] + "'/>",val);
			    }else{
			    	this.setCValue("<input type='button' style='height:20px;' onclick='goAllot(0,0)' value='" + str[1] + "'/>",val);
			    }
	    	}
	    	

	    }
	    
	    this.getValue=function(){
	    	if(this.cell.firstChild != null){
	    		return this.cell.firstChild.value; // get button label
	    	} else {
	    		return "";
	    	}
	    }
	}
	eXcell_button.prototype = new eXcell;
	
	function goAllot(id){
		if(id == 0){
			alert("该作品没有图片");
			return;
		}
		var url_link=fulllink+'?action=SHOW&record.id='+id;
	    openWindow("浏览",url_link,0.8,0.8); 
	}
	
</script>

<style type="text/css">
html, body {
	width: 100%;
	height: 100%;
}
</style>
</head>

<body onload="init()">
	<div class="special-padding" id="mainDiv">
		<s:form action="artAttachment" id="artAttachmentForm" method="post" namespace="/artWorks">
			<s:hidden name="query.order" />
			<s:hidden name="query.orderDirection" />
			<s:hidden name="query.pageNumber" />
			<s:hidden name="query.recordCount" />
			<s:hidden name="query.pageCount" />
			<table width="100%" id="tbl" cellpadding="0" cellspacing="0" class="queryTable">
				<tbody>
					<tr>
						<td class="textL" style="width: 80%">
						&nbsp;&nbsp;作者：<s:textfield style="width:100px;" name="query.parameters.artist" /> 
						&nbsp;&nbsp;作品名称：<s:textfield style="width:100px;" name="query.parameters.name" /> 
						&nbsp;&nbsp;作品类型：<s:select style="width:80px;" list="codeSets.ART_TYPE" listKey="value" listValue="codeName" name="query.parameters.artType"></s:select>
  						&nbsp;&nbsp;<gl:button name="btnQuery" onClick="goSearch()">查询</gl:button>
						</td>
					</tr>
				</tbody>
			</table>
			<gl:grid styleClass="pageTurn" id="artAttachment" page="true" form="artAttachmentForm" property="query" cellPadding="0" cellSpacing="0">
			var grid = new dhtmlXGridObject();
			grid.setImagePath(imagePath);
			var headAlign=[tCenter,tCenter,tCenter,tCenter,tCenter];
			grid.setHeader("作品类型,作者,作品名称,作品描述,浏览",null,headAlign);
			grid.setInitWidthsP("20,20,20,20,20");
			grid.setColAlign("center,center,center,center,center");
			grid.setColTypes("ro,ro,ro,ro,button");
			grid.setColSorting("str,str,str,str");
			grid.setSkin("dhx_terrace");
			grid.init();
			var gDiv=$$('artAttachment_box');
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
    
	 var gDiv=window.document.getElementById('artAttachment_box');
	 var mDiv=window.document.getElementById('mainDiv');
	 var tDiv=window.document.getElementById('tbl');
	    
    function goResize(){
   	 var he;
	    if(isIE()) he=window.document.body.offsetHeight; else he=window.innerHeight;

		 mDiv.style.height=he-42+"px";
		 gDiv.style.height=mDiv.offsetHeight-50+"px";
		 tDiv.style.width=mDiv.offsetWidth-4+"px";
		 gDiv.style.width=mDiv.offsetWidth-6+"px";
    }
    goResize();   
</script> 
</body>
</html>