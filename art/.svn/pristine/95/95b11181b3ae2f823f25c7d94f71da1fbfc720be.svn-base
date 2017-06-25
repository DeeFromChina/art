<%@ page language="java" contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>

<%
	String path = request.getContextPath();
	String CONTEXT_PATH = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.util.List"%><html><head>
<meta http-equiv="X-UA-Compatible" content="ie=7;ie=8" />
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<title>查询结果 </title>
<link rel="stylesheet" type="text/css" href="<%=CONTEXT_PATH%>dhtmlx/dhtmlx.css" />
<link rel="stylesheet" type="text/css" href="<%=CONTEXT_PATH%>dhtmlx/skins/dhtmlxcalendar_simplecolorsand.css" />
<script src="<%=CONTEXT_PATH%>dhtmlx/dhtmlx.js"></script>

<link rel="stylesheet" type="text/css" href="<%=CONTEXT_PATH%>css/main.css" />
<script language="javascript" src="<%=CONTEXT_PATH%>js/ctrl_util.js"></script>
<script language="javascript" src="<%=CONTEXT_PATH%>js/date_validate.js"></script>
<style type="text/css">
.highlight{
color:#ee0000;
font-weight:bold;
}
html, body{ background:url(<%=CONTEXT_PATH%>jsp/searchEngine/body_bg.jpg) bottom right no-repeat #fff; 
border:1px solid #f7f7f7; 
padding:0; margin:0; text-align:center; height:99%;
.fontStyle{ padding:3px; display:block; font-size:13px;line-height:30px;}
}
		
</style>
<link href="<%=CONTEXT_PATH%>css/Pager.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
var Startime,Endtime;
var st=new Date();
Startime=st.getTime();
</script>
<script type="text/javascript" src="<%=CONTEXT_PATH%>js/Pager.js" charset="gbk"></script>

<script type="text/javascript">
var contextpath = "<%=CONTEXT_PATH%>";
	var fulllink = contextpath + "literature/searchEngine.do";	
		
		function view(docId){
			 var url = fulllink + "?action=DOWNLOAD&record.docId=" + docId;
			 document.forms[0].action=url;
		 	 document.forms[0].submit();
		}		

	function goSubmit(){
	  document.forms[0].action=fulllink+"?action=RESULT";
 	  document.forms[0].submit();
	}
	 
	    function goCondition(){	
	    	$$('cond').style.display='inline';
	    }
	    function goStatic(){
	    	$$('cond').style.display='none';
	    	goSubmit();
	    	
	    }
	    function goCancel(){
	    	$$('cond').style.display='none';
	    }  
	    function init(){
	    	$$('cond').style.display='none';
	    }
</script>
</head>

<body onload="init()">
<h1>全文检索查询</h1>
<s:form action="searchEngine" method="post" id="searchEngineForm" namespace="/literature">
		<div style="padding-left:150px;height:32px;padding-top:10px; ">
			<s:textfield name="query.parameters.text" cssStyle="width:500px;"/>
	  	&nbsp;&nbsp;显示记录数:&nbsp;<s:textfield name="record.maxresults" value="100" cssStyle="width:50px;"/>
	  	&nbsp;&nbsp;<gl:button name="btnAdd" onClick="goSubmit()" >检索</gl:button>
	  	&nbsp;&nbsp;<gl:button name="btnAdd" onClick="goCondition()" >高级检索</gl:button>
	  	</div>
		<div style="padding-left:150px;height:24px;text-indent:270px;text-align:left;">
		共搜索到&nbsp;<strong><%=request.getAttribute("totalNum")%></strong>&nbsp;条记录(用时：<span id="timespan"></span> 毫秒)
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
</s:form>

<s:iterator value="query.recordSet" id="doc" status="seqNo">
			<table border="0" cellpadding="3" cellspacing="" width="100%" style="border: 1px solid #becfe1;">
				<tr align="left" style="cursor: hand" onclick="">
					<td width="80%"><b>&nbsp;&nbsp;&nbsp;文献标题:</b>&nbsp;<s:property value="title" /></td>
					<td width="10%"><b>作者:</b>&nbsp;<s:property value="author" /> </td>
					<td width="10%"><b>刊登时间:</b>&nbsp;<s:property value="time" /> </td>
				</tr>
				<tr align="left">
					<td colspan="3" style="background: #d6e8fe; border: 1px solid #becfe1; border-bottom: none; border-right: none; border-left: none;">
						 <font class="fontStyle">&nbsp;&nbsp;&nbsp;<s:property value="text"  escape="false"/> <br /> </font></td>
				</tr>
				<tr align="left" style="cursor: hand" onclick="">
					<td colspan="3"><b>&nbsp;&nbsp;&nbsp;出版社:</b>&nbsp;<s:property value="press" />
					<b>&nbsp;&nbsp;&nbsp;出版物名称:</b>&nbsp;<s:property value="publicationName" />
					<b>&nbsp;&nbsp;&nbsp;</b>&nbsp;<a href="javascript:view(<s:property value='docId' />)"><s:property value="fileName" escape="false"/></a> 
					</td>
				</tr>

				
				
			</table>
			<br/>		
</s:iterator>
<br/><br/>

<div id="pageBasicTemplate1" style="display:none"> 
	 共#{recordCount}记录
     页次#{pageIndex}/#{pageCount}
     每页#{pageSize}条
     每页#{pageSizeSelect}条
     #{pageFrist}
     #{pagePrevious}
     #{pageText}
     #{pageNext}
     #{pageLast}
     #{pageSelect}
     #{pageInput}
     #{pageGo} </div>
<div id="myPager1"> </div>
<div id="pageWrapper1"> </div>
<div id="pageWrapper2"> </div>
<div id="pageWrapper3"> </div>
<div id="pageWrapper4"> </div>
<div id="pageWrapper5"> </div>
<div id="pageWrapper6"> </div>
<div id="pageWrapper7"> </div>
<div id="pageWrapper8"> </div>


<script type="text/javascript">
var mainbody=window.document.body;

var urlStr="<%=CONTEXT_PATH%>obj/searchEngine.do?action=RESULT&pageIndex=#{pageIndex}&pageSize=#{pageSize}";
urlStr+="&maxresults=<%=request.getAttribute("maxresults")%>&text=<%=request.getAttribute("text")%>"
urlStr+="&startDate=<%=request.getAttribute("startDate")%>&endDate=<%=request.getAttribute("endDate")%>"
var myPager1 = new Web.Pager("myPager1",1,1,urlStr,document.getElementById("pageBasicTemplate1").innerHTML);
myPager1.setDataText(1,["【#{pageIndex}】","[#{pageIndex}]"],["首页","首页"],["上一页","上一页"],["下一页","下一页"],["尾页","尾页"],["页:#{pageIndex}/#{pageCount}","页:#{pageIndex}/#{pageCount}"],["Go"]);
myPager1.setDataInfo(1,<%=request.getAttribute("maxresults")%>,<%=request.getAttribute("totalNum")%>);
myPager1.write();

var et=new Date();
Endtime=et.getTime();
document.getElementById('timespan').innerHTML=Endtime-Startime;
</script>


<%@include file="/common/dialog.jsp"%>
</body>
</html>   
