<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@include file="/common/header.jsp" %>
    <title>系列代表作页面</title>
    <script language="javascript">

        var hyperlink = "../artist/ArtistSeriesWorks.do";
        var fulllink = contextpath + "artist/ArtistSeriesWorks.do";

        var pageAction = '?action=ADD_PAGE';

        function renew() {
            var order = getElement("query.order");
            order.value = "";
            var desc = getElement("query.orderDirection");
            desc.value = "";
            var pn = getElement("query.pageNumber");
            pn.value = "1";
            var ps = getElement("query.pageSize");
            ps.value = "10";
            goSearch();
        }

        function closedialog(ret) {
            parent.closedialog('false');
        }

        function goSubmit() {
            var id = findMultiSelected("保存", ArtistWorksSeries_grid);
            console.log(id);
            if(id == "") return;
            var form = document.forms[0];
            form.action = fulllink + '?action=SAVE&record.seriesId='+$$('seriesId').value+'&ids=' + id;
            form.submit();
        }

        function goSearch() {
            goArtistWorksSeriesGridSearch();
        }

        function init() {
            showMessage('<s:property value="errorMessage" escape="false"/>');
            renew();
        }

    </script>

    <style type="text/css">
        html, body {
            width: 100%;
            height: 100%;
        }
    </style>
</head>

<body onload="init()">
<div class="special-padding" id="mainDiv">
    <s:form action="ArtistWorksSeries" id="ArtistWorksSeriesForm" method="post" namespace="/artist"
            enctype="multipart/form-data">
        <s:hidden name="query.order"/>
        <s:hidden name="query.orderDirection"/>
        <s:hidden name="query.pageNumber"/>
        <s:hidden name="query.recordCount"/>
        <s:hidden name="query.pageCount"/>
        <s:hidden name="query.parameters.artistId" id="artistId"/>
        <s:hidden name="record.seriesId" id="seriesId"/>
        <table width="99%" id="tbl" cellpadding="0" cellspacing="0" class="queryTable">
        </table>
        <table id="btn" width="99%" cellspacing="1" cellpadding="1" class="controlTable">
            <tr>
                <td>
                    <gl:button styleClass="sbuBtnStyle" icon="addIcon" onClick="goSubmit()">增加</gl:button>
                </td>
            </tr>
        </table>
        <gl:grid styleClass="pageTurn" id="ArtistWorksSeries" page="true" form="ArtistWorksSeriesForm" property="query"
                 cellPadding="0" cellSpacing="0">
            var grid = new dhtmlXGridObject();
            grid.setImagePath(imagePath);
            var headAlign = [tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter];
            grid.setHeader("#master_checkbox,代表作,缩略图,艺术家,作品编号,作品名称,作品英文名,创作年份,尺寸（cm）,媒介材料,媒介形式,签名位置,签名内容,作品系列",null, headAlign);
            grid.setInitWidths("25,50,120,60,100,80,80,55,80,80,80,80,80,80");
            grid.setColAlign("center,center,center,center,center,center,center,center,center,center,center,center,center,center");
            grid.setColTypes("ch,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro");
            grid.setColSorting("na,str,str,str,str,str,str,str,str,str,str,str,str,str");
            grid.init();
            var gDiv = $$('ArtistWorksSeries_box');
        </gl:grid>
    </s:form>
</div>

<%@include file="/common/dialog.jsp" %>
<%@include file="/common/resizeList1.jsp" %>


</body>
</html>