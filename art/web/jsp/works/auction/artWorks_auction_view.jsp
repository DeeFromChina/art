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

	var fulllink = contextpath + "works/ArtWorksAuction.do";	
	var auctionVideoLink = contextpath + "auction/ArtAuctionVideo.do";
	var auctionWordsLink = contextpath + "auction/ArtAuctionWords.do";

	var ret=new Object();

	function goCancel(){
		parent.closedialog(false);
	}


	function init(){
		showMessage('<s:property value="errorMessage" escape="false"/>');
		calendar = initCalendar("auctionTime","imgAuctionTime");
		//hidebtn();
	}
	
	
	
	</script>
<style type="text/css"> 
   html, body {width:100%; height:100%; margin:0px; padding:0px; overflow:hidden;}
</style>
</head>
 
<body onload="init()">
	<s:form action="ArtWorksAuction" id="ArtWorksAuctionForm" method="post" namespace="/works" enctype="multipart/form-data">
			<s:hidden name="record.id" id="auctionId"/>
			<div id="tblForm"></div>
			<div id="page_0"  style="padding:2px; height:100%; width:100%;">
			<div id="formDiv" class="formDiv" style="padding:2px;">
				<table cellpadding="0" cellspacing="0" class="formTable" style="width: 99%;">
				<col width="15%"/>
				<col width="15%"/>
				<col width="20%"/>
				<col width="15%"/>
				<col width="15%"/>
				<col width="20%"/>
				<tr>
					<td class="textR" >拍卖会：</td>
					<td colspan="2" class="textL" ><s:property value="form.record.auction" /></td>
					<td class="textR" >拍卖编号：</td>
					<td colspan="2" class="textL"><s:property value="form.record.auctionNo" /></td>
				</tr>
				
				<tr>
					<td class="textR" >拍场：</td>
					<td  colspan="2" class="textL"><s:property value="form.record.saleName" /></td>
					<td class="textR" >季节：</td>
					<td  colspan="2" class="textL"><s:property value="form.record.autionSeason" /></td>
				</tr>
				
				<tr>
					<td class="textR" >标识：</td>
					<td colspan="2" class="textL"><s:property value="form.record.auctionIdentity" /></td>
					<td class="textR" >拍卖时间：</td>
					<td class="textL" colspan="2">
						<s:property value="form.record.auctionTime"  />
					</td>
				</tr>
				
				<tr>
					<td class="textR" >作品：</td>
					<td colspan="2" class="textL">
						<s:property value="form.record.worksName" />
					</td>
					<td class="textR" >拍卖行：</td>
					<td  colspan="2"class="textL">
						<s:property value="form.record.housesName" />
					</td>
				</tr>
				
				<tr>
					<td class="textR" >作品来源：</td>
					<td class="textL" colspan="5" ><s:property value="form.record.worksSource" /></td>
				</tr>
				
				<tr>
					<td class="textR"  >版数：</td>
					<td colspan="2" class="textL"><s:textfield name="form.record.versionNum"/></td>
					<td class="textR"  >成交状态：</td>
					<td colspan="2" class="textL"><s:select list="codeSets.TRAN_STATUS" listKey="value" listValue="codeName" name="record.tranStatus" /></td>
				</tr>
				
				<tr>
					<td class="textR" valign="top">拍卖说明：</td>
					<td class="textL" colspan="5" style="height:60px"><s:property value="form.record.auctionDesc"  /></td>
				</tr>
				
				<tr>
					<td rowspan="5" class="textR">成交价：</td>
					<td class="textR">(人民币)</td>
					<td class="textL"><s:property value="form.record.cTranPrice" /></td>
				
					<td rowspan="5" class="textR">交易价：</td>
					<td class="textR">(人民币)</td>
					<td class="textL"><s:property value="form.record.cTradePrice" /></td>
				</tr>
				<tr>
					<td  class="textR">(美元)</td>
					<td  class="textL"><s:property value="form.record.dTranPrice" /></td>
					<td  class="textR">(美元)</td>
					<td  class="textL"><s:property value="form.record.dTradePrice" /></td>
				</tr>
				
				<tr>
					<td  class="textR">(欧元)</td>
					<td  class="textL"><s:property value="form.record.eTranPrice" /></td>
					<td  class="textR">(欧元)</td>
					<td  class="textL"><s:property value="form.record.eTradePrice" /></td>
				</tr>
				
				<tr>
					<td  class="textR">(英镑)</td>
					<td  class="textL"><s:property value="form.record.pTranPrice" /></td>
					<td  class="textR">(英镑)</td>
					<td  class="textL"><s:property value="form.record.pTradePrice" /></td>
				</tr>
				<tr>
					<td  class="textR">(港币)</td>
					<td  class="textL"><s:property value="form.record.hkTranPrice" /></td>
					<td  class="textR">(港币)</td>
					<td  class="textL"><s:property value="form.record.hkTradePrice" /></td>
				</tr>
				
				<tr>
					<td rowspan="5" class="textR">最低估价：</td>
					<td class="textR">(人民币)</td>
					<td class="textL"><s:property value="form.record.cLowestPrice" /></td>
				
					<td rowspan="5" class="textR">最高估价：</td>
					<td class="textR">(人民币)</td>
					<td class="textL"><s:property value="form.record.cHighestPrice" /></td>
				</tr>	
				
				<tr>
					<td  class="textR">(美元)</td>
					<td  class="textL"><s:property value="form.record.dLowestPrice" /></td>
					<td  class="textR">(美元)</td>
					<td  class="textL"><s:property value="form.record.dHighestPrice" /></td>
				</tr>
				<tr>
					<td  class="textR">(欧元)</td>
					<td  class="textL"><s:property value="form.record.eLowestPrice" /></td>
					<td  class="textR">(欧元)</td>
					<td  class="textL"><s:property value="form.record.eHighestPrice" /></td>
				</tr>
				<tr>
					<td  class="textR">(英镑)</td>
					<td  class="textL"><s:property value="form.record.pLowestPrice" /></td>
					<td  class="textR">(英镑)</td>
					<td  class="textL"><s:property value="form.record.pHighestPrice" /></td>
				</tr>
				<tr>
					<td  class="textR">(港币)</td>
					<td  class="textL"><s:property value="form.record.hkLowestPrice" /></td>
					<td  class="textR">(港币)</td>
					<td  class="textL"><s:property value="form.record.hkHighestPrice" /></td>
				</tr>
		 	</table>
		  </div>
		 </div>
		 <iframe  id="page_1" name="page_1" width="100%" height="100%" scrolling="no" frameborder="0"></iframe> 
		 <iframe  id="page_2" name="page_2" width="100%" height="100%" scrolling="no" frameborder="0"></iframe> 
</s:form>

<div id="btnDiv" class="btnDiv">
	 <gl:button name="btnAdd" onClick="goCancel()" >关闭</gl:button>
</div>

	<%@include file="/common/dialog.jsp"%>
	<script type="text/javascript">
	var mainbody=window.document.body;
	if(window.addEventListener) {
		     window.addEventListener("resize",goResize,false); 
	}
	else {
		     window.attachEvent('onresize',goResize);
	}
	
	var fDiv=window.document.getElementById('formDiv');
	var bDiv=window.document.getElementById('btnDiv');
	var btbl=window.document.getElementById('tblForm');
	
	function goResize(){
	 	   btbl.style.width=mainbody.offsetWidth-9+"px";
		   btbl.style.height=mainbody.offsetHeight-40+"px";
		   bDiv.style.width=mainbody.offsetWidth-10+"px";
		   bDiv.style.top=btbl.offsetHeight+5+"px";
		}
		goResize();  

		var tabbar = new dhtmlXTabBar("tblForm", "top");
		tabbar.setSkin('dhx_terrace');
		tabbar.setArrowsMode("auto");
		tabbar.addTab("a0", "作品拍卖基本信息", "140px");
		tabbar.addTab("a1", "拍卖相关视频", "120px");
		tabbar.addTab("a2", "拍卖相关文字", "120px");
		tabbar.tabs("a0").attachObject("formDiv");
		tabbar.tabs("a0").setActive();
		tabbar.tabs("a1").attachObject("page_1");
		tabbar.tabs("a2").attachObject("page_2");
		tabbar.enableAutoReSize(true);
		tabbar.enableTabCloseButton(true);
		tabbar.attachEvent("onTabClick", function(idClicked, idSelected){
			if(idClicked != "a0"){
				document.getElementById("btnDiv").style.display="none";
			}else{
				document.getElementById("btnDiv").style.display="";
			}
		});
		window.frames["page_1"].location.href = auctionVideoLink + '?action=LIST&record.auctionId=' + $$('auctionId').value + '&record.hide=1';
		window.frames["page_2"].location.href = auctionWordsLink + '?action=LIST&record.auctionId=' + $$('auctionId').value + '&record.hide=1';
		fDiv.style.height=btbl.offsetHeight-40+"px";
	</script>
</body>
</html>