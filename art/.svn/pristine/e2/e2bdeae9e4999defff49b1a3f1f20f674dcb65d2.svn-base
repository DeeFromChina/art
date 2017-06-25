<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <%@include file="/common/header.jsp" %>
	<script type="text/javascript">

	function goCancel(){
		 var ret=new Object();
		 ret['ret']=false;
		 ret['str']='';
		 ret['str1']='';
		 parent.closedialog(ret);
	}
	
	function goSubmit(){
		  var ids=$NAME('artArtistId');
		  var str="";
		  var str1="";

		  for(var i=0;i<ids.length;i++){
		  	 if(ids[i].checked) str+=ids[i].value;
		  	 if(ids[i].checked) str1+=ids[i].title;
		  }
			 var ret=new Object();
			 ret['ret']=true;
			 ret['str']=str;
			 ret['str1']=str1;
		    parent.closedialog(ret);
	}
  
	  function init(){
		  showMessage('<s:property value="errorMessage" escape="false"/>')
	  }
	  
	</script>
<style type="text/css">
   /* html, body {width:100%; height:100%; margin:0px; padding:0px; overflow:hidden;} */
</style>
</head>

<body onload="init()">
	<table>
		<s:iterator value="works" id="w">
			<tr>
				<td class="textL">
					<a href="<%=CONTEXT_PATH%>works/artWorksIden.do?action=IDEN&query.parameters.name=${w.name}" target="mainFrame" >${w.name}</a>
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>