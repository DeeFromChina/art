package com.golead.common;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PicServlet extends HttpServlet {
   private ServletConfig     servletConfig;
   private static final long serialVersionUID = 1L;

   
   @Override
   public void init(ServletConfig servletConfig) throws ServletException {
      super.init(servletConfig);
      this.servletConfig = servletConfig;
   }

   
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("application/x-download"); // 内容是下载
      response.setHeader("Content-Disposition", "attachment;filename=chart.png");// 文件名，可以进一步处理
      // 读数据
      BufferedInputStream inputStream = new BufferedInputStream(request.getInputStream());
      OutputStream outputStream = response.getOutputStream();
      byte[] bytes = new byte[1024];
      int v;
      // 写数据
      while ((v = inputStream.read(bytes)) > 0) {
         outputStream.write(bytes, 0, v);
      }
      outputStream.flush();
      outputStream.close();
      inputStream.close();
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
