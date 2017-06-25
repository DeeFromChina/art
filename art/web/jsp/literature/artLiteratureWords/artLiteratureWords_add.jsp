<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp" %>
<script language="javascript">		
	var fulllink = contextpath + "literature/ArtLiteratureWords.do";	

	function goCancel(){
		parent.closedialog('false');
		
	}

	function goSubmit() {
		if(checkFormInput()){
		    //var url =fulllink+"?action=SAVE"+ping("record.literatureWorks")
		    //		+ping("record.quoteLiterature")+ping("record.personInvolved")
		    //		+ping("record.relatedExhib")+ping("record.relatedEvent");
		  	document.forms[0].action=fulllink+"?action=SAVE";
			document.forms[0].submit();
		}
	}
	
	function checkFormInput(){
		if(!checkString(getElement('record.artistId'),"艺术家",100,true)) return;
		if(!checkString(getElement('form.record.literatureTitle'),"文献标题",200,true)) return;
		//if(!checkString(getElement('form.record.literatureAuther'),"作者",30,true)) return;
		if(!checkFile()) return;
		return true;
	}
	
	function checkFile() {
		var isPass = true;
		$(".checkFile").each(function(){
			if(this.value != ''){
				var format = this.value.split(".");
				var i = format.length;
				if(format[i-1] != "pdf"){
					alert("只能上传pdf格式！");
					isPass = false;
					return false;
				}
			}
		});
		return isPass;
	}
	
	function ping(key){
		var val = "";
		$(".ten").each(function(){
			if(this.value == undefined || this.value == "" || this.value == " "){
				return;
			}
			if("form."+key == this.name){
				if(val != ""){
					val = val + ",";
				}
				val = val + this.value;
			}
		});
		if(val == ""){
			return "&" + key + "=" + "";
		}
		return "&" + key + "=" + val;
	}
	
	function closedialog(ret) {
		var res=ret['ret'];
		if(res==true) {
	    	 getElement('record.artistId').value=ret['str'];
	    	 getElement('record.artistName').value=ret['str1'];
	     }
		if(ret=='true') {
			goSearch();
		}
		editMode="";
	}

	
	function init(){
		showMessage('<s:property value="errorMessage" escape="false"/>');
	}

	function goArtArtist(){
		var url_link=contextpath+'literature/ArtLiteratureWords.do?action=ARTIST&ids='+$$("artistId").value;
	    openWindow("选择作者",url_link,200,300);	
	}

	</script>
<style type="text/css"> 
   html, body {width:100%; height:100%; margin:0px; padding:0px; overflow:hidden;}
   .ten {width:17% !important;}
</style>
</head>
 
<body onload="init()">
	<s:form action="ArtLiteratureMedium" id="ArtLiteratureMediumForm" method="post" namespace="/literature" enctype="multipart/form-data">
			<div id="formDiv" class="formDiv" style="padding: 0px;">
			<table cellpadding="0" cellspacing="0" width="99%" class="formTable">
				<tr>
					<td class="textR" width="15%" ><font color="red">*</font>艺术家：</td>
					<td width="35%" class="textL">
							<s:textfield readonly="true" name="record.artistName" style="width:80%;" />
  	                        <s:hidden name="record.artistId" id="artistId"/>
  	                        <gl:button name="btnArtArtist" styleClass="btnFormStyle" onClick="goArtArtist()">选择</gl:button>
  	                </td>
					<td class="textR" width="15%" ><font color="red">*</font>文献标题：</td>
					<td width="35%" ><s:textfield name="form.record.literatureTitle"/></td>
				</tr>
				<tr>
					<td class="textR" width="15%" >作者：</td>
					<td width="35%" ><s:textfield name="form.record.literatureAuther"/></td>
					<td class="textR" width="15%" >刊登时间：</td>
					<td width="35%" >
						<s:textfield name="form.record.writeTime" placeholder="xxxx年xx月xx日" id="writeTime"/>
					</td>
				</tr>
				<tr>
					<td class="textR" width="15%" >出版物名称：</td>
					<td><s:textfield name="form.record.publicationName"/></td>
					<td class="textR" width="15%" >出版物期数：</td>
					<td><s:textfield name="form.record.publicationPeriod"/></td>
				</tr>
				<tr>
					<td class="textR" width="15%" >出版社：</td>
					<td><s:textfield name="form.record.press"/></td>
					<td class="textR" width="15%" >栏目：</td>
					<td width="35%" ><s:textfield name="form.record.literatureColumn"/></td>
				</tr>
				<tr>
					<td class="textR" width="15%" >相关页：</td>
					<td><s:textfield name="form.record.relevantPages"/></td>
					<td class="textR" width="15%" >文献类型：</td>
					<td><s:select list="codeSets.WORDS_TYPE" listKey="value" listValue="codeName" name="record.wordsType"/></td>
				</tr>
				<tr>
					<td class="textR" width="15%" >文献提及作品：</td>
					<td colspan="3" class="textL">
					    <s:textarea height="50px"  name="form.record.literatureWorks" placeholder="关键词，多个用、号隔开"/>
					</td>
				</tr>
				<tr>
					<td class="textR" width="15%" >引用文献：</td>
					<td colspan="3" class="textL">
				     	<s:textarea height="50px"  name="form.record.quoteLiterature" placeholder="引用文献，多个用、号隔开"/>
					</td>
				</tr>
				<tr>
					<td class="textR">文献相关人物：</td>
					<td colspan="3" class="textL">
					    <s:textarea height="50px"  name="form.record.personInvolved" placeholder="人物名，多个用、号隔开"/>
					</td>
				</tr>
				<tr>
					<td class="textR" width="15%" >文献相关展览：</td>
					<td colspan="3" class="textL">
					   <s:textarea height="50px"  name="form.record.relatedExhib" placeholder="展览，多个用、号隔开"/> 
					</td>
				</tr>
				<tr>
					<td class="textR" width="15%" >文献相关事件：</td>
					<td colspan="3" class="textL">
					    <s:textarea height="50px"  name="form.record.relatedEvent" placeholder="事件，多个用、号隔开"/> 
					</td>
				</tr>
				<tr>
					<td class="textR" width="15%" >附件：</td>
					<td colspan="3" class="textL">
					   <input type="file" name="files" id="file" class="checkFile" />
					</td>
				</tr>
				<tr>
					<td class="textR" width="15%" >附件来源：</td>
					<td colspan="3" class="textL">
						<s:textfield name="record.attachmentSource"/>
					</td>
				</tr>
				<tr>
					<td colspan="4" class="textC">文献研究</td>
				</tr>
				<tr>
					<td class="textR" width="15%" >主观重要度评级：</td>
					<td><s:select list="codeSets.COMMENT_LEVEL" listKey="value" listValue="codeName" name="record.subjectiveEval"/></td>
					<td class="textR" width="15%" >客观重要度评级：</td>
					<td><s:select list="codeSets.COMMENT_LEVEL" listKey="value" listValue="codeName" name="record.objectiveEval"/></td>
				</tr>
				<tr>
					<td class="textR" width="15%" >核心论断：</td>
					<td colspan="3" class="textL">
						<s:textarea height="80px" name="record.coreThesis"/>
					</td>
				</tr>
		 	</table>
	</div>
</s:form>

<div id="btnDiv" class="btnDiv">
	<gl:button name="btnAdd" onClick="goSubmit()" >保存</gl:button>&nbsp;
	<gl:button name="btnAdd" onClick="goCancel()" >关闭</gl:button>
</div>

<%@include file="/common/resize.jsp" %>
<%@include file="/common/dialog.jsp"%>

</body>
</html>