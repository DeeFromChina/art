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

        function goAdd() {
            editMode = "ADD";
            var artistId = $$('artistId').value;
            var seriesId = $$('seriesId').value;
            openWindow("添加作品", fulllink + '?action=ADD&query.parameters.artistId=' + artistId + '&record.seriesId=' + seriesId, 0.8, 0.8);
        }

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
            if (ret == true || ret == 'true') {
                goSearch();
            }
            editMode = "";
        }

        function goDel() {
            var id = findMultiSelected("删除", ArtistWorksSeries_grid);
            console.log(id);
            if (id == "") return;
            var res = confirm("是否要删除？");
            if (res == true) {
                var data = ajaxSubmit(fulllink + "?action=DELETE&ids=" + id, "ArtistWorksSeriesForm");
                console.log(data);
                if (data.exit > 0) {
                    alert(data.message);
                    return;
                } else {
                    goSearch();
                }
            }
        }

        function setRepresentative() {
            var ids = findMultiSelected("添加代表作标记", ArtistWorksSeries_grid);
            if (ids == "") return;
            if (confirm("是否将这些作品设置为代表作？")) {
                var data = ajaxSubmit(fulllink + "?action=SET&ids=" + ids, "ArtistWorksSeriesForm");
                if (data.exit > 0) {
                    alert(data.message);
                    return;
                } else {
                    goSearch();
                }
            }
        }

        function setNotRepresentative() {
            var ids = findMultiSelected("添加代表作标记", ArtistWorksSeries_grid);
            if (ids == "") return;
            if (confirm("是否将这些作品设置为代表作？")) {
                var data = ajaxSubmit(fulllink + "?action=SET_NOT&ids=" + ids, "ArtistWorksSeriesForm");
                if (data.exit > 0) {
                    alert(data.message);
                    return;
                } else {
                    goSearch();
                }
            }
        }

        function goSubmit() {
            var id = findMultiSelected("保存", ArtistWorksSeries_grid);
            if (id == "") return;
            var form = document.forms[0];
            form.action = fulllink + '?action=SAVE&record.seriesId=' + $$('seriesId').value + '&ids=' + id;
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
        <s:hidden name="query.parameters.seriesId" id="seriesId"/>
        <table width="99%" id="tbl" cellpadding="0" cellspacing="0" class="queryTable">
        </table>
        <table id="btn" width="99%" cellspacing="1" cellpadding="1" class="controlTable">
            <tr>
                <td>
                    <gl:button styleClass="sbuBtnStyle" icon="addIcon" onClick="goAdd()">增加</gl:button>
                    <gl:button styleClass="sbuBtnStyle" icon="delIcon" onClick="goDel()">删除</gl:button>
                    <gl:button styleClass="sbuBtnStyle" icon="subIcon" onClick="setRepresentative()">添加代表作标记</gl:button>
                    <gl:button styleClass="sbuBtnStyle" icon="delIcon"
                               onClick="setNotRepresentative()">删除代表作标记</gl:button>
                </td>
            </tr>
        </table>
        <gl:grid styleClass="pageTurn" id="ArtistWorksSeries" page="true" form="ArtistWorksSeriesForm" property="query"
                 cellPadding="0" cellSpacing="0">
            var grid = new dhtmlXGridObject();
            grid.setImagePath(imagePath);
            var headAlign = [tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter,tCenter];
            grid.setHeader("#master_checkbox,代表作,缩略图,艺术家,作品编号,作品名称,作品英文名,创作年份,尺寸（cm）,媒介材料,媒介形式,签名位置,签名内容,作品系列",null, headAlign);
            grid.setInitWidthsP("3,7,10,7,10,7,7,7,7,7,7,7,7,7");
            grid.setColAlign("center,center,center,center,center,center,center,center,center,center,center,center,center,center");
            grid.setColTypes("ch,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro");
            grid.setColSorting("na,str,str,str,str,str,str,str,str,str,str,str,str,str");
		    grid.enableMultiline(true);
            grid.init();
            var gDiv = $$('ArtistWorksSeries_box');
        </gl:grid>
    </s:form>
</div>

<%@include file="/common/dialog.jsp" %>
<%@include file="/common/resizeList1.jsp" %>


</body>
</html>