<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp" %>
<script language="javascript">		
	var contextpath = "<%=CONTEXT_PATH%>";
	var fulllink = contextpath + "works/artPeriod.do";	
	var partSize;
	var i = 0;
	var ret=new Object();

	function goCancel(){
		parent.closedialog('false');
	}

	function goSubmit() {
		if(checkFormInput()){
		    var url =fulllink+"?action=SAVE";
		  	document.forms[0].action=url;
			document.forms[0].submit();
		} 
	}
	
	function checkFormInput(){
		if(!checkString(getElement('record.periodType'),"时期类型",30,true)) return;
		/* var le = document.getElementById('periodName').value.length;
		if(le>100){
			alert("“时期名称”中输入的数据太长!");
			return;
		} */
		if(!checkString(getElement('record.periodName'),"时期名称",200,true)) return;
		return true;
	}
	
	function closedialog(ret) {
		var res=ret['ret'];
		if(ret=='true') {
			goSearch();
		}
		editMode="";
	}

	
	function init(){
		showMessage('<s:property value="errorMessage" escape="false"/>');
	}
	
	function gets_id(objName){
		 if(document.getElementById){
		  return eval('document.getElementById("' + objName + '")');
		 }else if(document.layers){
		  return eval("document.layers['" + objName +"']");
		 }else{
		  return eval('document.all.' + objName);
		 }
		}
	
		//打开DIV层
		function disp_cc()
		{
		 if(gets_id('hh').style.display=='none')
		 {
		  gets_id('hh').style.display='';
		 }
		 else
		 {
		  gets_id('hh').style.display='none';
		 }
		}
		
		function add(id,txt) {    
	        var li= document.createElement("li");    
	        var href_a = document.createElement("a");  
	            href_a.href="javascript:del('"+id+"');";  
	            href_a.innerHTML ="del";  
	            li.innerHTML=txt;  
	            li.id=id;  
	            li.appendChild(href_a);  
	            ul.appendChild(li);    
	    }
		
		//赋值
		function gets_value(str)
		{
		 document.getElementById('periodName').value = str;
		 gets_id('hh').style.display='none';
		}
		
	</script>
<style type="text/css"> 
   html, body {width:100%; height:100%; margin:0px; padding:0px; overflow:hidden;}
   
<!--
ul ,li {margin: 0px;padding: 0px;list-style: none;}
.formDiv .classlist {right: 5px;position: absolute;background-color: #F5FBFF;width: 160px;border: 1px solid #C9E4F4;top: 28px;font-size: 12px;line-height: 22px;padding-top: 0px;}
.formDiv .classlist li {display: inline;}
.formDiv .classlist .lis a {text-decoration: none;background-image: url();background-repeat: no-repeat;background-position: 5px 7px;height: 22px;width: 151px;float: left;padding-left: 15px;}
.formDiv .classlist .lis a:hover {color: #FFFFFF;background-color: #0E9CC8;}
.formDiv .classlist .lis a:active {color: #FFFFFF;background-color: #0D96C0;}
a:link {text-decoration: none;}
a:visited {text-decoration: none;color: #333333;}
a:hover {text-decoration: underline;color: #333333;}
a:active {text-decoration: none;color: #333333;}
-->
</style>
</head>
 
<body onload="init()">
	<s:form action="artPeriod" id="artWorksPeriodForm" method="post" namespace="/works">
			<s:hidden name="record.artistId" id="artistId"/>
			<s:hidden name="record.worksId" id="worksId"/>
			<div id="formDiv" class="formDiv" style="padding:0px;">
			<table cellpadding="0" cellspacing="0" class="formTable">
				<tr>
					<td width="25%" class="textR"><font color="red">*</font>时期类型：</td>
					<td width="75%"><s:select list="codeSets.PERIOD_TYPE" listKey="value" listValue="codeName" name="record.periodType" /></td>
				</tr>
				<tr>
					<td class="textR" valign="top"><font color="red">*</font>时期名称：</td>
					<td colspan="2" valign="top">
						<s:textarea style="height:80px;" name="record.periodName" id="periodName"></s:textarea>
					</td>
				</tr>
				<tr><td></td><td><input type="button" value="历史记录" style="width:70px" onClick="disp_cc();"/></td></tr>
				<div id="hh" style="display:none;overflow:scroll;overflow-x:hidden;height:100px;" class=classlist>
				    <ul id="ul1">
				    	<s:iterator value="cookie" id="co"  status="coco">
					    		<li class=lis><a href="#" onClick="gets_value('${co.name}')">
					    		<s:if test='#co.marquee == "1"'>
					    			<marquee behavior="alternate" scrollamount="2">
					    		</s:if>
					    		${co.name}
					    		<s:if test='#co.marquee == "1"'>
					    			</marquee>
					    		</s:if>
					    		</a></li>
						</s:iterator>
				    </ul>
				</div>
		 	</table>
		 </div>
</s:form>

<div id="btnDiv" class="btnDiv">
	<gl:button name="btnAdd" onClick="goSubmit()" >保存</gl:button>
     &nbsp;
	 <gl:button name="btnAdd" onClick="goCancel()" >关闭</gl:button>
</div>

<script type="text/javascript"> 
 
</script>

<%@include file="/common/dialog.jsp"%>
<%@include file="/common/resize.jsp" %>
</body>
</html>