/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.42
 * Generated at: 2016-11-30 06:54:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.wx.wx_005fmenu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.golead.core.web.UserSession;

public final class WxMenu_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/tag/gl-tag.tld", Long.valueOf(1469518854769L));
    _jspx_dependants.put("/common/header.jsp", Long.valueOf(1467793401644L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("   ");
      out.write('\r');
      out.write('\n');

   String path = request.getContextPath();
	String CONTEXT_PATH = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	String skinName="dhx_skyblue";

      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<meta http-equiv=\"x-ua-compatible\" content=\"ie=7;ie=8\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(CONTEXT_PATH);
      out.write("dhtmlx/dhtmlx.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(CONTEXT_PATH);
      out.write("dhtmlx/dhtmlx_add.css\" />\r\n");
      out.write("<script src=\"");
      out.print(CONTEXT_PATH);
      out.write("dhtmlx/dhtmlx.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(CONTEXT_PATH);
      out.write("css/main.css\" />\r\n");
      out.write("<script language=\"javascript\" src=\"");
      out.print( CONTEXT_PATH );
      out.write("js/ctrl_util.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"");
      out.print( CONTEXT_PATH );
      out.write("js/date_validate.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"");
      out.print( CONTEXT_PATH );
      out.write("js/jquery.js\"></script>\r\n");
      out.write("<script language=\"javascript\">\t\t\r\n");
      out.write("\tvar contextpath = \"");
      out.print(CONTEXT_PATH);
      out.write("\";\r\n");
      out.write("\tvar imagePath=\"");
      out.print(CONTEXT_PATH);
      out.write("dhtmlx/imgs/\";\r\n");
      out.write("\tvar skinName = \"dhx_terrace\";\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\"> \r\n");
      out.write("   html, body {width:100%; height:100%;}\r\n");
      out.write("</style>");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar hyperlink = \"../wx/wxMenuButon.do\";\r\n");
      out.write("\t\tvar fulllink = contextpath + \"wx/wxMenuButon.do\";\r\n");
      out.write("\r\n");
      out.write("\t\tfunction addcodeset(codesetid) {\r\n");
      out.write("// \t\t\topenWindow('添加代码', fulllink+'?action=ADD&codesetid='+codesetid, 600, 350);\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction modifycodeset() {\r\n");
      out.write("// \t\t\tvar mygrid=dhxLayout.cells(\"b\").getFrame().contentWindow.mygrid;\r\n");
      out.write("// \t\t\tvar id = findSelected(\"修改\",mygrid);\r\n");
      out.write("// \t\t\tif(id == \"\") return;\r\n");
      out.write("// \t\t\tvar rulcodesetedit=fulllink+'?action=EDIT&ids='+id;\r\n");
      out.write("// \t\t\topenWindow(\"修改代码\", rulcodesetedit, 600, 350);\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction deletecodeset(codesetid) {\r\n");
      out.write("// \t\t\tvar mygrid=dhxLayout.cells(\"b\").getFrame().contentWindow.mygrid;\r\n");
      out.write("// \t\t\tvar id = findMultiSelected(\"删除\",mygrid);\r\n");
      out.write("// \t\t\tif(id == \"\") return;\r\n");
      out.write("// \t\t\tvar res = confirm(\"是否真的要删除?\");\r\n");
      out.write("// \t\t\tif(res == true) {\r\n");
      out.write("// \t\t\t\tvar innerDoc;\r\n");
      out.write("// \t\t\t\tif (_isIE) {\r\n");
      out.write("// \t\t\t\t\tinnerDoc = dhxLayout.cells(\"b\").getFrame().contentWindow.document;\r\n");
      out.write("// \t\t\t\t} else {\r\n");
      out.write("// \t\t\t\t\tinnerDoc = dhxLayout.cells(\"b\").getFrame().contentDocument;\r\n");
      out.write("// \t\t\t\t}\r\n");
      out.write("// \t\t\t\tinnerDoc.forms[0].action = hyperlink + \"?action=delete&ids=\" + id+\"&codesetid=\"+codesetid;\r\n");
      out.write("// \t\t\t\tinnerDoc.forms[0].target = \"_self\";\r\n");
      out.write("// \t\t\t\tinnerDoc.forms[0].submit();\r\n");
      out.write("// \t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction view() {\r\n");
      out.write("// \t\t\tvar id = dhxLayout.cells(\"b\").getFrame().contentWindow.getModifyId();\r\n");
      out.write("// \t\t\tif(id == \"\") return;\r\n");
      out.write("// \t\t\tvar urllink = contextpath+\"system/sysCode.do\"+\"?action=CODELIST&codesetid=\"+id;\r\n");
      out.write("// \t\t\topenWindow('浏览系统代码值',  urllink, 600, 250);\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction viewCodesetGrid(id){\r\n");
      out.write("      if(id==null||id==\"\"||id==\"root\") {\r\n");
      out.write("      \trightPanel.attachURL(\"");
      out.print( CONTEXT_PATH);
      out.write("dhtmlx/imgs/blank.html\");\r\n");
      out.write("         toolbar.disableItem(\"new_codeset\");\r\n");
      out.write("         toolbar.disableItem(\"modify_codeset\");\r\n");
      out.write("         toolbar.disableItem(\"del_codeset\");\r\n");
      out.write("      \t}\t\r\n");
      out.write("    \telse {\r\n");
      out.write("    \t rightPanel.attachURL(\"");
      out.print( CONTEXT_PATH);
      out.write("system/sysCode.do?action=CODELIST&codesetid=\"+id);\r\n");
      out.write("         toolbar.enableItem(\"new_codeset\");\r\n");
      out.write("         toolbar.enableItem(\"modify_codeset\");\r\n");
      out.write("         toolbar.enableItem(\"del_codeset\");\r\n");
      out.write("    \t}   \r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("   html, body {width:100%; height:100%;}\r\n");
      out.write("</style>\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"div_left\" style=\"background-color:#ffffff;height:100%;width:100%;\"></div>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t\tvar dhxLayout = new dhtmlXLayoutObject(document.body, \"2U\");\r\n");
      out.write("    \tdhxLayout.setSkin(\"dhx_terrace\");\r\n");
      out.write("    \tvar leftPanel=dhxLayout.cells(\"a\");\r\n");
      out.write("    \tvar rightPanel=dhxLayout.cells(\"b\");\r\n");
      out.write("    \tleftPanel.hideHeader();\r\n");
      out.write("    \tleftPanel.attachObject(\"div_left\");\r\n");
      out.write("    \tleftPanel.setWidth(250);\r\n");
      out.write("    \trightPanel.hideHeader();\r\n");
      out.write("\r\n");
      out.write("\t\tvar toolbar = dhxLayout.attachToolbar();\r\n");
      out.write("\t\ttoolbar.setIconsPath(\"");
      out.print( CONTEXT_PATH);
      out.write("dhtmlx/imgs/icon/\");\r\n");
      out.write("\t\ttoolbar.addButton(\"add_menu\", 0, \"添加\", \"code_add.gif\", \"code_add.gif\");\r\n");
      out.write("    \ttoolbar.addSeparator(\"sep1\", 1);\r\n");
      out.write("\t\ttoolbar.addButton(\"modify_menu\", 2, \"修改\", \"code_mod.gif\", \"code_mod.gif\");\r\n");
      out.write("    \ttoolbar.addSeparator(\"sep2\", 3);\r\n");
      out.write("\t\ttoolbar.addButton(\"del_menu\", 4, \"删除\", \"code_del.gif\", \"code_del.gif\");\r\n");
      out.write("\t\ttoolbar.addSeparator(\"sep1\", 5);\r\n");
      out.write("\t\ttoolbar.addButton(\"start_menu\", 6, \"启用\", \"code_del.gif\", \"code_del.gif\");\r\n");
      out.write("\t\ttoolbar.addSeparator(\"sep1\", 7);\r\n");
      out.write("\t\ttoolbar.addButton(\"stop_menu\", 8, \"停用\", \"code_del.gif\", \"code_del.gif\");\r\n");
      out.write("\t\ttoolbar.addSeparator(\"sep1\", 9);\r\n");
      out.write("\t\ttoolbar.addButton(\"update_menu\", 10, \"更新菜单\", \"code_del.gif\", \"code_del.gif\");\r\n");
      out.write("\t\t//点击事件\r\n");
      out.write("\t\ttoolbar.attachEvent(\"onClick\", function(id){\r\n");
      out.write("\t\t\tif(id==\"add_menu\") {\r\n");
      out.write("// \t\t\t\tvar nodeId=tree.getSelectedItemId();\r\n");
      out.write("// \t\t\t\taddcodeset(nodeId);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse if(id==\"modify_menu\") modifycodeset();\r\n");
      out.write("\t\t\telse if(id==\"del_menu\") {\r\n");
      out.write("// \t\t\t\tvar nodeId=tree.getSelectedItemId();\r\n");
      out.write("// \t\t\t\tdeletecodeset(nodeId);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse if(id==\"start_menu\") {\r\n");
      out.write("// \t\t\t\tvar nodeId=tree.getSelectedItemId();\r\n");
      out.write("// \t\t\t\tdeletecodeset(nodeId);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse if(id==\"stop_menu\") {\r\n");
      out.write("// \t\t\t\tvar nodeId=tree.getSelectedItemId();\r\n");
      out.write("// \t\t\t\tdeletecodeset(nodeId);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse if(id==\"update_menu\") {\r\n");
      out.write("// \t\t\t\tvar nodeId=tree.getSelectedItemId();\r\n");
      out.write("// \t\t\t\tdeletecodeset(nodeId);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("    \ttoolbar.disableItem(\"add_menu\");\r\n");
      out.write("    \ttoolbar.disableItem(\"modify_menu\");\r\n");
      out.write("     \ttoolbar.disableItem(\"del_menu\");\r\n");
      out.write("     \ttoolbar.disableItem(\"start_menu\");\r\n");
      out.write("     \ttoolbar.disableItem(\"stop_menu\");\r\n");
      out.write("\r\n");
      out.write("\t\tvar tree = new dhtmlXTreeObject(\"div_left\",\"100%\",\"100%\",0);\r\n");
      out.write("\t\ttree.setImagePath(\"");
      out.print(CONTEXT_PATH);
      out.write("dhtmlx/imgs/dhxtree_terrace/\");\r\n");
      out.write("\t\ttree.attachEvent(\"onClick\", function(id){\r\n");
      out.write("\t\t\tviewCodesetGrid(id);\r\n");
      out.write("\t\t});\r\n");
      out.write("    \ttree.setSkin('dhx_terrace');\r\n");
      out.write("\t\ttree.setXMLAutoLoading(\"");
      out.print( CONTEXT_PATH);
      out.write("wx/wxMenuButon.do?action=getTree\");\r\n");
      out.write("\t\ttree.loadXML(\"");
      out.print( CONTEXT_PATH);
      out.write("wx/wxMenuButon.do?action=getTree\");\r\n");
      out.write("\r\n");
      out.write("\t\tvar dhxWins = dhxLayout.dhxWins;\r\n");
      out.write("\t\tvar winName=\"winCodeset\";   //打开窗口名称\r\n");
      out.write("\t   var editMode;       \t\t//页面编辑状态：ADD,EDIT,DELETE\r\n");
      out.write("\t\tdhxWins.enableAutoViewport(true);\r\n");
      out.write("\t\tdhxWins.setImagePath(\"");
      out.print( CONTEXT_PATH);
      out.write("dhtmlx/imgs/\");\r\n");
      out.write("\r\n");
      out.write("\t\tfunction openWindow(title,urlink,width,height){\r\n");
      out.write("\t\t\tvar w = dhxWins.createWindow(winName, 0, 0, width,height);\r\n");
      out.write("\t\t\tw.setText(title);\r\n");
      out.write("\t\t\tw.keepInViewport(true);\r\n");
      out.write("\t\t\tw.setModal(true);\r\n");
      out.write("\t\t\tw.centerOnScreen();\r\n");
      out.write("\t\t\tw.button(\"minmax1\").hide();\r\n");
      out.write("\t\t\tw.button(\"minmax2\").hide();\r\n");
      out.write("\t\t\tw.button(\"park\").hide();\r\n");
      out.write("\t\t\tw.attachURL(urlink);\r\n");
      out.write("\t\t\treturn w;    \r\n");
      out.write("\t    }\r\n");
      out.write("\r\n");
      out.write("\t\tfunction closedialog(ret){\r\n");
      out.write("\t\t\tdhxWins.window(winName).close();\r\n");
      out.write("\t\t\tvar id = tree.getSelectedItemId();\r\n");
      out.write("\t\t\tif(ret) reSearch(id);\r\n");
      out.write("\t\t\treturn id;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction reSearch(id){\r\n");
      out.write("\t\t\tviewCodesetGrid(id);\r\n");
      out.write("\t\t\t//dhxLayout.cells(\"b\").getFrame().contentWindow.renew(id);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}