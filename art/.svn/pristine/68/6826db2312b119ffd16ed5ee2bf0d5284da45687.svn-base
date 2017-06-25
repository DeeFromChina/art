<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@include file="/common/header.jsp" %>

    <script language="javascript">
        var hyperlink = contextpath + "literature/ArtLiteratureOther.do";
        var fulllink = contextpath + "literature/ArtLiteratureOther.do";

        var pageAction = "?action=RELATED_WORKS_ADD_PAGE";


        function goSubmit() {
            var id = findMultiSelected("删除", ArtLiteratureOther_grid);
            if (id == "")
                return;
            var url = fulllink + '?action=RELATED_WORKS_SAVE&ids=' + id + '&record.otherId=' + $$('id').value;
            document.forms[0].action = url;
            document.forms[0].submit();
        }

        function goSearch() {
            goArtLiteratureOtherGridSearch();
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
    <s:form action="ArtLiteratureOther" id="ArtLiteratureOtherForm"
            method="post" namespace="/literature">
        <s:hidden name="query.order"/>
        <s:hidden name="query.orderDirection"/>
        <s:hidden name="query.pageNumber"/>
        <s:hidden name="query.recordCount"/>
        <s:hidden name="query.pageCount"/>
        <s:hidden name="query.parameters.otherId" id="id"/>
        <table width="99%" id="tbl" cellpadding="0" cellspacing="0"
               class="queryTable">
        </table>
        <table id="btn" width="99%" cellspacing="1" cellpadding="1"
               class="controlTable">
            <tr>
                <td>
                    <gl:button styleClass="sbuBtnStyle" icon="addIcon" onClick="goSubmit()">增加</gl:button>
            </tr>
        </table>
        <gl:grid styleClass="pageTurn" id="ArtLiteratureOther" page="true"
                 form="ArtLiteratureOtherForm" property="query" cellPadding="0"
                 cellSpacing="0">
            var grid = new dhtmlXGridObject();
            grid.setImagePath(imagePath);
            var headAlign = [tCenter,tCenter,tCenter,tCenter];
            grid.setHeader("#master_checkbox,图片,中文名,英文名",null, headAlign);
            grid.setInitWidthsP("25,25,25,25");
            grid.setColAlign("center,center,center,center");
            grid.setColTypes("ch,ro,ro,ro");
            grid.setColSorting("na,str,str,str");
            grid.init();
            var gDiv = $$('ArtLiteratureOther_box');
        </gl:grid>
    </s:form>
</div>
<%@include file="/common/dialog.jsp" %>
<%@include file="/common/resizeList1.jsp" %>

</body>
</html>