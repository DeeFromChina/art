<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <%@include file="/common/header.jsp" %>
	<script type="text/javascript">
      var fulllink = contextpath + "system/sysUser.do";		

	function goCancel(){
		 var ret=new Object();
		 ret['ret']=false;
		 ret['str']='';
		 ret['str1']='';
		 parent.closedialog(ret);
	}
	
	function goSubmit(){
		var strId="";
		var strName="";
		var items=getElements('selUser');
		for(var i=0;i<items.length;i++){
			if(items[i].checked){
				strId=items[i].value;
				strName=items[i].title;
				break;
			}
		}
		
		 var ret=new Object();
		 ret['ret']=true;
		 ret['userId']=strId;
		 ret['userName']=strName;
	    parent.closedialog(ret);
	}
  
	  function init(){
		  showMessage('<s:property value="errorMessage" escape="false"/>')
	  }
	
	</script>
<style type="text/css">
   html, body {width:100%; height:100%; margin:0px; padding:0px; overflow:hidden;}
</style>
</head>

<body onload="init()">
<div id="formDiv" class="formDiv" style="text-align:left!important;background:#d6e8fe;padding-top:3px;">
  <s:form method="post" action="/system/sysUser.do">
  	 <s:hidden name="record.ids" />
  	    &nbsp;<input type="radio" value="" <s:if test="userList==''" >checked</s:if> 
  	    name="selUser" title="无用户" /><img src="<%=CONTEXT_PATH%>dhtmlx/imgs/icon/people.gif" />(无用户)<br/>
  	 <s:iterator value="users" id="item">
  	    &nbsp;<input type="radio" value="<s:property value='#item.id'/>" <s:if test="userList==#item.id" >checked</s:if> 
  	    name="selUser" title="<s:property value='#item.userName'/>" /><img src="<%=CONTEXT_PATH%>dhtmlx/imgs/icon/people.gif" /> 
  	    <s:property value="#item.userName"/><br/>
  	 </s:iterator>
  </s:form>		
</div>
<div id="btnDiv" class="btnDiv">
			      <gl:button name="btnAdd" onClick="goSubmit()">确定</gl:button>
				    &nbsp;
			      <gl:button name="btnCancel" onClick="goCancel()">取消</gl:button>

</div>
<%@include file="/common/resize.jsp" %>
<script type="text/javascript">
</script>  
</body>
</html>
