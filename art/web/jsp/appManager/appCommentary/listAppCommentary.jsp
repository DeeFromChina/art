<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@include file="/common/header.jsp"%>
<script type="text/javascript">
	var hyperlink = "../appManager/appCommentaryManager.do";
	var fulllink = contextpath + "appManager/appCommentaryManager.do";

	function goPass(){
		var id = findSelected("允许通过",appCommentaryManager_grid);
		if (id == "") return;
		var res = confirm("是否允许该评论通过审核？");
		if (res == true) var data = ajaxSubmit(fulllink+"?action=PASS"+"&ids=" + id,"appCommentaryManagerForm");
		if(data.exit>0){
 			  alert(data.message);
 			  return;
 		}else {	  
 			goSearch();
 		}
	}
   
	function goDisPass(){
		var id = findSelected("不允许通过",appCommentaryManager_grid);
		if (id == "") return;
		var res = confirm("是否不允许该评论通过审核？");
		if (res == true) var data = ajaxSubmit(fulllink+"?action=DISPASS"+"&ids=" + id,"appCommentaryManagerForm");
		if(data.exit>0){
 			  alert(data.message);
 			  return;
 		}else {	  
 			goSearch();
 		} 
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
		editMode="";
	}
	
	function goSearch(){
		goappCommentaryManagerGridSearch();
	}
	
	function init(){
		showMessage('<s:property value="errorMessage" escape="false"/>');
		renew();
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
        <s:form action="appCommentaryManager" id="appCommentaryManagerForm" method="post" namespace="/appManager">
            <s:hidden name="query.order" />
            <s:hidden name="query.orderDirection" />
            <s:hidden name="query.pageNumber" />
            <s:hidden name="query.recordCount" />
            <s:hidden name="query.pageCount" />
            
            <table width="99%" id="tbl" cellpadding="0" cellspacing="0" class="queryTable">
                <tr>
                    <td width="100%" style="height:30px;" class="textL">
                        &nbsp;&nbsp;年：<s:select style="width:80px;" list="codeSets.DATE_YEAR" listKey="value" listValue="codeName" name="query.parameters.YEAR"/>
                        &nbsp;&nbsp;月份：<s:select style="width:60px;" list="codeSets.DATE_MONTH" listKey="value" listValue="codeName" name="query.parameters.MONTH"/>
                        &nbsp;&nbsp;留言状态：<s:select style="width:80px;" list="codeSets.COMMENTARY_STATUS" listKey="value" listValue="codeName" name="query.parameters.commentaryStatus"/>
                        &nbsp;&nbsp;用户账户：<s:textfield style="width:100px;"  name="query.parameters.appAccountName"/>
                        &nbsp;&nbsp;审批人账户：<s:textfield style="width:100px;"  name="query.parameters.userAccount"/>
                        &nbsp;&nbsp;作品名：<s:textfield style="width:150px;"  name="query.parameters.worksName"/>
                        &nbsp;&nbsp;<gl:button name="btnQuery" onClick="goSearch()">查询</gl:button>
                    </td>
                </tr>
            </table>
            <table id="btn" width="99%" cellspacing="1" cellpadding="1" class="controlTable">
                <tr>
                    <td>
                       
                        <gl:button styleClass="sbuBtnStyle" icon="delIcon" onClick="goPass()">通过</gl:button>
                        <gl:button styleClass="sbuBtnStyle" icon="subIcon" onClick="goDisPass()">不予通过</gl:button>
                    </td>
                </tr>
            </table>
            <gl:grid styleClass="pageTurn" id="appCommentaryManager" page="true" form="appCommentaryManagerForm"  property="query" cellPadding="0" cellSpacing="0">
                var grid = new dhtmlXGridObject();
                grid.setImagePath(imagePath);
                var headAlign = [tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter];
                grid.setHeader("#master_checkbox,作品图片,作品中文名,作品英文名,用户账号,审批人账号,审批时间,评论状态,评论内容",null, headAlign);
                grid.setInitWidthsP("5,20,10,10,10,10,10,5,20");
                grid.setColAlign("center,center,center,center,center,center,center,center,center");
                grid.setColTypes("ch,link,ro,ro,ro,ro,ro,ro,ro");
                grid.setColSorting("na,str,str,str,str,str,str,str,str");
                grid.init();
                var gDiv = $$('appCommentaryManager_box');
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
	    
		 var gDiv=window.document.getElementById('appCommentaryManager_box');
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