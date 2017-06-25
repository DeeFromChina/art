<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/WEB-INF/tag/gl-tag.tld" prefix="gl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@include file="/common/header.jsp" %>

    <script language="javascript">
        var hyperlink = "../publication/pubAency.do";
        var fulllink = contextpath + "/publication/pubAency.do";
        var syslink = contextpath + "system/artAgency.do";

        function goAdd() {
            editMode = "ADD";
            var publicationId = $$('publicationId').value;
            openWindow("添加机构", fulllink + '?action=ADD&query.parameters.publicationId=' + publicationId, 0.6, 0.6);
        }

        function goDel() {
            var id = findMultiSelected("删除", pubAency_grid);
            if (id == "") return;
            var res = confirm("是否要删除？");
            if (res == true) {
                var data = ajaxSubmit(fulllink + "?action=delete&ids=" + id, "pubAencyForm");
                if (data.exit > 0) {
                    alert(data.message);
                    return;
                } else {
                    goSearch();
                }
            }
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

        function goSearch() {
            gopubAencyGridSearch();
        }

        function init() {
            showMessage('<s:property value="errorMessage" escape="false"/>');
            renew();
        }


        function view(id) {
            var url_link = syslink + '?action=VIEW&record.id=' + id;
            openWindow("查看机构", url_link, 0.8, 0.8);
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
    <s:form action="pubAency" id="pubAencyForm" method="post" namespace="/publication">
        <s:hidden name="query.parameters.publicationId" id="publicationId"/>
        <s:hidden name="record.hide" id="hide"/>
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
                    <gl:button styleClass="sbuBtnStyle" icon="addIcon" onClick="goAdd()">增加</gl:button>
                    <gl:button styleClass="sbuBtnStyle" icon="delIcon" onClick="goDel()">删除</gl:button>
                </td>
            </tr>
        </table>
        <gl:grid styleClass="pageTurn" id="pubAency" page="true" form="pubAencyForm" property="query"
                 cellPadding="0" cellSpacing="0">
            var grid = new dhtmlXGridObject();
            grid.setImagePath(imagePath);
            var headAlign = [tCenter,tCenter,tCenter,tCenter];
            grid.setHeader("#master_checkbox,机构名称（中/英文）,国家,类型",null, headAlign);
            grid.setInitWidthsP("5,35,25,35");
            grid.setColAlign("center,center,center,center");
            grid.setColTypes("ch,link,ro,ro");
            grid.setColSorting("na,str,str,str");
            grid.enableMultiline(true);
            grid.init();
            var gDiv = $$('pubAency_box');
        </gl:grid>
    </s:form>
</div>

<%@include file="/common/dialog.jsp" %>
<%@include file="/common/resizeList1.jsp" %>

</body>
</html>