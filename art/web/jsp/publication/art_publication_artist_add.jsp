<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@include file="/common/header.jsp" %>

    <script language="javascript">
        var hyperlink = "../publication/pubArtist.do";
        var fulllink = contextpath + "/publication/pubArtist.do";

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

        function goSubmit() {
            var id = findMultiSelected("添加", pubArtist_grid);
            var publicationId = $$('publicationId').value;
            if (id == "") return;

            var url = fulllink + "?action=SAVE&record.publicationId=" + publicationId + "&ids=" + id;
            document.forms[0].action = url;
            document.forms[0].submit();
        }

        function closedialog(ret) {
            if (ret == true || ret == 'true') {
                goSearch();
            }
            editMode = "";
        }

        function goSearch() {
            gopubArtistGridSearch();
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
    <s:form action="pubArtist" id="pubArtistForm" method="post" namespace="/publication">
        <s:hidden name="query.parameters.publicationId" id="publicationId"/>
        <s:hidden name="query.order"/>
        <s:hidden name="query.orderDirection"/>
        <s:hidden name="query.pageNumber"/>
        <s:hidden name="query.recordCount"/>
        <s:hidden name="query.pageCount"/>
        <table width="99%" id="tbl" cellpadding="0" cellspacing="0" class="queryTable">
        </table>
        <table id="btn" width="99%" cellspacing="1" cellpadding="1" class="controlTable">
            <tr>
                <td>
                    <gl:button styleClass="sbuBtnStyle" icon="addIcon" onClick="goSubmit()">关联到出版物</gl:button>
                </td>
            </tr>
        </table>
        <gl:grid styleClass="pageTurn" id="pubArtist" page="true" form="pubArtistForm" property="query"
                 cellPadding="0" cellSpacing="0">
            var grid = new dhtmlXGridObject();
            grid.setImagePath(imagePath);
            var headAlign = [tCenter,tCenter,tCenter];
            grid.setHeader("#master_checkbox,艺术家照片,艺术家姓名（中/英文）",null, headAlign);
            grid.setInitWidthsP("10,45,45");
            grid.setColAlign("center,center,center");
            grid.setColTypes("ch,ro,ro");
            grid.setColSorting("na,str,str");
            grid.enableMultiline(true);
            grid.init();
            var gDiv = $$('pubArtist_box');
        </gl:grid>
    </s:form>
</div>

<%@include file="/common/dialog.jsp" %>
<%@include file="/common/resizeList1.jsp" %>

</body>
</html>