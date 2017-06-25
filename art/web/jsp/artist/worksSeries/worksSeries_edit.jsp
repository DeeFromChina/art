<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@include file="/common/header.jsp" %>
    <script language="javascript">

        var fulllink = contextpath + "artist/ArtistWorksSeries.do";

        function goCancel() {
            parent.closedialog('false');
        }

        function goSubmit() {
            if (checkFormInput()) {
                var url = fulllink + "?action=UPDATE";
                document.forms[0].action = url;
                document.forms[0].submit();
            }
        }

        function checkFormInput() {
            if (!checkString(getElement('form.record.seriesName'), "系列名称", 30, true)) return;
            if (!checkString(getElement('form.record.seriesImportant'), "系列重要度", 30, true)) return;
            return true;
        }

        function closedialog(ret) {
            if (ret == 'true') {
                goSearch();
            }
            editMode = "";
        }

        function init() {
            showMessage('<s:property value="errorMessage" escape="false"/>');
        }

    </script>
    <style type="text/css">
        html, body {
            width: 100%;
            height: 100%;
            margin: 0px;
            padding: 0px;
            overflow: hidden;
        }
    </style>
</head>

<body onload="init()">
<s:form action="ArtistWorksSeries" id="ArtistWorksSeriesForm" method="post" namespace="/artist">
    <s:hidden name="record.artistId" id="artistId"/>
    <s:hidden name="record.id" id="id"/>
    <div id="tblForm"></div>
    <div id="page_0" style="padding:2px; height:100%; width:100%;">
        <div id="formDiv" class="formDiv" style="padding: 0px;">
            <table cellpadding="0" cellspacing="0" width="99%" class="formTable">
                <tr>
                    <td class="textR" width="15%"><font color="red">*</font>系列名称：</td>
                    <td class="textL" colspan="3"><s:textfield name="form.record.seriesName"/></td>
                </tr>
                <tr>
                    <td class="textR">
                        系列出现年份：
                    </td>
                    <td>
                        <s:textfield name="form.record.appearYear" placeholder="时间起"/>
                    </td>
                    <td class="textC">
                        至
                    </td>
                    <td>
                        <s:textfield name="form.record.endingYear" placeholder="时间止"/>
                    </td>
                </tr>
                <tr>
                    <td class="textR">
                        <font color="red">*</font>系列重要度：
                    </td>
                    <td colspan="3">
                        <s:select list="codeSets.COMMENT_LEVEL" listKey="value" listValue="codeName"
                                  name="form.record.seriesImportant"/>
                    </td>
                </tr>
                <tr>
                    <td class="textR">
                        系列类型：
                    </td>
                    <td colspan="3" class="textL">
                        <s:checkboxlist list="codeSets.SERIES_TYPE" listKey="value" listValue="codeName"
                                        name="form.record.seriesType" cssStyle="width:20px;"/>
                    </td>
                </tr>
                <tr>
                    <td class="textR">
                        系列描述及评价：
                    </td>
                    <td colspan="3">
                        <s:textarea id="descript" name="form.record.descript"
                                    placeholder="可填写该系列的主要描绘内容，意图，灵感来源，社会历史背景，主要技法，学术评价，等等（1000字以内）"/>
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <iframe id="page_1" name="page_1" width="100%" height="100%" scrolling="no" frameborder="0"></iframe>
    <iframe id="page_2" name="page_2" width="100%" height="100%" scrolling="no" frameborder="0"></iframe>
</s:form>

<div id="btnDiv" class="btnDiv">
    <gl:button name="btnAdd" onClick="goSubmit()">保存</gl:button>&nbsp;
    <gl:button name="btnAdd" onClick="goCancel()">关闭</gl:button>
</div>

<%@include file="/common/dialog.jsp" %>

<script type="text/javascript">
    var mainbody = window.document.body;
    if (window.addEventListener) {
        window.addEventListener("resize", goResize, false);
    } else {
        window.attachEvent('onresize', goResize);
    }

    var fDiv = window.document.getElementById('formDiv');
    var bDiv = window.document.getElementById('btnDiv');
    var btbl = window.document.getElementById('tblForm');

    function goResize() {
        fDiv.style.width = mainbody.offsetWidth - fDiv.offsetLeft * 2 + "px";
        bDiv.style.width = mainbody.offsetWidth - bDiv.offsetLeft * 2 + "px";
        fDiv.style.height = mainbody.offsetHeight - bDiv.offsetHeight - fDiv.offsetTop * 2 + "px";
        bDiv.style.top = fDiv.offsetHeight + fDiv.offsetTop * 2 - 5 + "px";
        if (btbl) {
            btbl.style.width = fDiv.offsetWidth - fDiv.offsetLeft - 9 + "px";
            btbl.style.height = fDiv.offsetHeight - fDiv.offsetTop - 12 + "px";
        }
    }
    goResize();

    var tabbar = new dhtmlXTabBar("tblForm", "top");
    tabbar.setSkin('dhx_terrace');
    tabbar.setArrowsMode("auto");
    tabbar.addTab("a0", "系列基本信息", "100px");
    tabbar.addTab("a1", "系列作品", "100px");
    tabbar.addTab("a2", "系列个案研究", "100px");

    tabbar.enableAutoReSize(true);
    tabbar.enableTabCloseButton(true);

    tabbar.tabs("a0").attachObject("page_0");
    tabbar.tabs("a0").setActive();
    tabbar.tabs("a1").attachObject("page_1");
    tabbar.tabs("a2").attachObject("page_2");

    window.frames["page_1"].location.href = contextpath + 'artist/ArtistSeriesWorks.do?query.parameters.artistId=' + $$('artistId').value + '&query.parameters.seriesId=' + $$('id').value;
    window.frames["page_2"].location.href = contextpath + 'artist/ArtistWorksSeriesCase.do' + '?query.parameters.seriesId=' + $$('id').value;
</script>
</body>
</html>