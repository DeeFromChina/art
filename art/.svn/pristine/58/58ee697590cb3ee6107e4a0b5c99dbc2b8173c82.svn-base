<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <%@include file="/common/header.jsp" %>
<script type="text/javascript">
      var fulllink = contextpath + "system/sysRole.do";		

	function goCancel(){
		 parent.closedialog(false);
	}
  
	
	function init(){
	    tabbar.setTabActive("a1");	
	}
	
	</script>
<style type="text/css">
html,body {
	width: 100%;
	height: 100%;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
}
</style>
</head>

<body onload="init();">
	<s:form action="sysRole" id="roleForm" method="post" namespace="/system">
		<s:hidden name="record.id" />
	</s:form>
	<div id="formDiv" class="formDiv" style="text-align: left !important;">
		<div id="div_main" style="border:1px solid #aaaaaa; width: 100%; height: 100%; background: white;"></div>
		<div id="div_genaral" style="border:0px solid #aaaaaa;height:200px; width: 100%; background: white; padding: 5px; text-align: center">
			<table cellpadding="0" cellspacing="0" class="formTable" style="width: 98%;">
				<tr>
					<td width="20%">角色标识：</td>
					<td width="30%" class="textLW">
					<s:property value="record.roleCode" />
					</td>
					<td width="20%">状态：</td>
					<td width="30%" class="textLW">
					<s:property value="record.roleStatus" />
					</td>
				</tr>
				<tr>
					<td>角色名称：</td>
					<td colspan="3" class="textLW">
					<s:property value="record.roleName" />
					</td>
				</tr>
				<tr>
					<td>备注：</td>
					<td colspan="3" class="textLW">
					<s:property value="record.remark" />
					</td>
				</tr>
			</table>
		</div>
		<div id="div_rights" style="position: relative; top: 0; left: 0; width: 100%; height: 99%; padding-top: 3px; text-align: left;">
		</div>
		<div id="div_users" style="position: relative; top: 0; left: 0; width: 100%; height: 99%; padding-top: 3px; text-align: center;">
			<div id="div_usersMiddle"
				style="position: relative; top: 0; left: 0; background: #d6e8fe; width: 99%; border: 1px solid #b1b1b1; text-align: left !important;">
			   	<table cellpadding="0" cellspacing="0" border="0"
					style="position: relative; top: 0; left: 0; text-align: left !important;">
					<s:iterator value="sysUsers">
						<tr style="height: 20px;">
							<td>&nbsp;
							<s:property value="accountName" />(<s:property value="userName" />)
							</td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
	</div>
	<div id="btnDiv" class="btnDiv">
		<gl:button name="btnCancel" onClick="goCancel()">返回</gl:button>
	</div>
	<script type="text/javascript">
	  var mainbody=window.document.body;
    if(window.addEventListener) {
 	     window.addEventListener("resize",goResize,false); 
    }
    else {
 	     window.attachEvent('onresize',goResize);
    }
    
    var fDiv=window.document.getElementById('formDiv');
    var mDiv=window.document.getElementById('div_main');
    var bDiv=window.document.getElementById('btnDiv');
       fDiv.style.width=mainbody.offsetWidth-fDiv.offsetLeft*2+"px";
       bDiv.style.width=mainbody.offsetWidth-bDiv.offsetLeft*2+"px";
       fDiv.style.height=mainbody.offsetHeight-bDiv.offsetHeight-fDiv.offsetTop*2+"px";
       mDiv.style.width=mainbody.offsetWidth-5+"px";
       mDiv.style.height=mainbody.offsetHeight-bDiv.offsetHeight-10+"px";
       bDiv.style.top=fDiv.offsetHeight+fDiv.offsetTop*4+"px";

    
    function goResize(){
       fDiv.style.width=mainbody.offsetWidth-fDiv.offsetLeft*2+"px";
       bDiv.style.width=mainbody.offsetWidth-bDiv.offsetLeft*2+"px";
       fDiv.style.height=mainbody.offsetHeight-bDiv.offsetHeight-fDiv.offsetTop*2+"px";
       bDiv.style.top=fDiv.offsetHeight+fDiv.offsetTop*4+"px";
    }
</script>
  
	<script type="text/javascript">
	
	var tabbar = new dhtmlXTabBar("div_main", "top");
    tabbar.setSkin('dhx_terrace');
    tabbar.setArrowsMode("auto");
    tabbar.addTab("a1", "基本信息", "100px");
    tabbar.addTab("a2", "权限", "70px");
    tabbar.addTab("a3", "用户", "70px");
    tabbar.tabs("a1").attachObject("div_genaral");
    tabbar.tabs("a2").attachObject("div_rights");
    tabbar.tabs("a3").attachObject("div_users");
    tabbar.tabs("a1").setActive();
    
    var tree = new dhtmlXTreeObject("div_rights","100%","100%",0);
    tree.setSkin('dhx_terrace');
    tree.setImagePath("<%=CONTEXT_PATH%>dhtmlx/imgs");
    <s:iterator value="sysResources">
    tree.insertNewChild(<s:if test="#parentId!=0">'</s:if><s:property value="parentId"/><s:if test="#parentId!=0">'</s:if>,'<s:property value="id"/>','<s:property value="resName"/>');
  </s:iterator>
    tree.openAllItems(0);
</script>
</body>
</html>
