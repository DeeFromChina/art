package com.golead.common;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class UploadServlet extends HttpServlet {
   private ServletConfig servletConfig;

   
   @Override
   public void init(ServletConfig servletConfig) throws ServletException {
      super.init(servletConfig);
      this.servletConfig = servletConfig;
   }

   /** 
        *  
        */
   private static final long serialVersionUID = 1L;

   
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      doPost(req, resp);
   }

   
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html");

      SmartUpload u = new SmartUpload();
      u.initialize(getServletConfig(), request, response);
      u.setAllowedFilesList("doc");

      try {

         u.upload();

         String fname = u.getRequest().getParameter("fname");
         if(fname!=null)fname=unescape(fname);
         // u.save("/upload");
         u.getFiles().getFile(0).saveAs("d:/web/"+fname, SmartUpload.SAVE_PHYSICAL);

      } catch (SmartUploadException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   public String unescape(String src) {
      StringBuffer tmp = new StringBuffer();
      tmp.ensureCapacity(src.length());
      int lastPos = 0, pos = 0;
      char ch;
      while (lastPos < src.length()) {
         pos = src.indexOf("%", lastPos);
         if (pos == lastPos) {
            if (src.charAt(pos + 1) == 'u') {
               ch = (char) Integer.parseInt(src.substring(pos + 2, pos + 6), 16);
               tmp.append(ch);
               lastPos = pos + 6;
            }
            else {
               ch = (char) Integer.parseInt(src.substring(pos + 1, pos + 3), 16);
               tmp.append(ch);
               lastPos = pos + 3;
            }
         }
         else {
            if (pos == -1) {
               tmp.append(src.substring(lastPos));
               lastPos = src.length();
            }
            else {
               tmp.append(src.substring(lastPos, pos));
               lastPos = pos;
            }
         }
      }
      return tmp.toString();
   }

   
@Override
public ServletConfig getServletConfig() {
      return servletConfig;
   }

   public void setServletConfig(ServletConfig servletConfig) {
      this.servletConfig = servletConfig;
   }
}
