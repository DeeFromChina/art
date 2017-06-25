<%@ page language="java" contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>

<%
String path = request.getContextPath();
String CONTEXT_PATH = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<style type="text/css">
		html,body{ background:url(<%=CONTEXT_PATH%>jsp/searchEngine/body_bg.jpg) bottom right no-repeat #fff; border:1px solid #f7f7f7; padding:0; margin:0; text-align:center; height:100%; overflow:hidden;}
		</style>
<link rel="stylesheet" type="text/css" href="<%=CONTEXT_PATH%>dhtmlx/dhtmlx.css" />
<link rel="stylesheet" type="text/css" href="<%=CONTEXT_PATH%>dhtmlx/skins/dhtmlxcalendar_simplecolorsand.css" />
<script src="<%=CONTEXT_PATH%>dhtmlx/dhtmlx.js"></script>

<link rel="stylesheet" type="text/css" href="<%=CONTEXT_PATH%>css/main.css" />
<script language="javascript" src="<%= CONTEXT_PATH %>js/ctrl_util.js"></script>
<script language="javascript" src="<%= CONTEXT_PATH %>js/date_validate.js"></script>
</head>

<body onload="init()">
	<h1>全文搜索查询</h1>
	<s:form action="searchEngine" method="post" id="searchEngineForm" namespace="/literature">
		<div style="padding-left:150px;height:32px;padding-top:10px; ">
		<s:textfield name="query.parameters.text" cssStyle="width:500px;"/>
	  	&nbsp;&nbsp;显示记录数:&nbsp;<s:textfield name="record.maxresults" value="100" cssStyle="width:50px;"/>
	  	&nbsp;&nbsp;<gl:button name="btnAdd" onClick="goSubmit()" >检索</gl:button>
	  	&nbsp;&nbsp;<gl:button name="btnAdd" onClick="goCondition()" >高级检索</gl:button>
		</div>
		<div id="cond" style="overflow: hidden;text-align:left;display:none;">		 
		 <table id="tbl" cellpadding="0" cellspacing="0" class="formTable" style="width:600px;" align="center">
			  <tr>
			    <td class="textR" width="20%">作者： </td>  
			    <td class="textL"  width="80%"> <s:textfield  name="query.parameters.author" />
			    </td>
			 </tr>	
			 <tr>  
			    <td class="textR" >出版物名称： </td>  
			    <td class="textL"> <s:textfield name="query.parameters.publicationName" />
			    </td>
			</tr>	
			<tr>
			    <td class="textR" >刊登时间： </td>  
			    <td class="textL" ><s:textfield name="query.parameters.startDate" cssStyle="width:100px;"/>&nbsp;至&nbsp;<s:textfield name="query.parameters.endDate" cssStyle="width:100px;"/>
			    </td>
			</tr>
			<tr>
			    <td class="textR" >文献类型： </td>  
			    <td class="textL">			       
			      <s:checkboxlist list="codeSets.WORDSTYPE" listKey="value" listValue="codeName" name="query.parameters.wordsType" cssStyle="width:15px;"/>
			    </td>
			</tr>
		    </table>
		    <div id="divBtn" style="position:relative;height: 30px;text-align: center;padding-top:10px;">
				<gl:button name="btnQuery" onClick="goStatic()">检索</gl:button>
				&nbsp;
				<gl:button name="btnCancel" onClick="goCancel()">关闭</gl:button>
			</div>
	</div>
		
		<div style="height:200px;">&nbsp;</div>
    </s:form>

 <script>	 
   	var contextpath = "<%=CONTEXT_PATH%>";
   	var fulllink = contextpath + "literature/searchEngine.do";	
   	var mainbody=window.document.body;
 
     function goSubmit(){
   		  document.forms[0].action=fulllink+"?action=RESULT";
       	  document.forms[0].submit();
   	}
     
    function goCondition(){	
    	$$('cond').style.display='inline';//   
    }
    function goStatic(){
    	$$('cond').style.display='none';
    	goSubmit();
    }
    function goCancel(){
    	$$('cond').style.display='none';
    }  
    function init(){
    	$$('cond').style.display='none';//inline   
    }
</script>   
        
</body>

</html>