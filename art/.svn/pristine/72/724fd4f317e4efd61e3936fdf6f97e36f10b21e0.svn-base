package com.golead.art.works;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataCollectHandler {

   private Log        logger = LogFactory.getLog(DataCollectHandler.class);

   private Connection connection;

   public static void main(String[] args) {
      new DataCollectHandler();
   }

   public DataCollectHandler() {
      List<Map<String, Object>> list = executeCollect();
      for (Map<String, Object> map : list) {
         Integer id = Integer.valueOf(map.get("id") + "");
         String sizeCm = map.get("size_cm") == null ? null : map.get("size_cm") + "";
         String sql = null;
         if (sizeCm != null) {
            System.out.println(sizeCm.indexOf("×"));
            if (sizeCm.indexOf("×") > -1) {
               if (sizeCm.indexOf(":") > -1) {
                  String[] sizeCms = sizeCm.split("×");
                  String[] height = sizeCms[0].split(":");
                  String[] width = sizeCms[1].split(":");
                  String[] length = sizeCms[2].split(":");
                  sql = "update art_works set size_cm_length=" + Double.valueOf(length[1].trim()) + ", size_cm_width=" + Double.valueOf(width[1].trim())
                        + ", size_cm_height=" + Double.valueOf(height[1].trim()) + "where id=" + id;

               }
               else {
                  String[] sizeCms = sizeCm.split("×");
                  sql = "update art_works set size_cm_length=" + Double.valueOf(sizeCms[0].trim()) + ", size_cm_width=" + Double.valueOf(sizeCms[1].trim())
                        + "where id=" + id;
               }
            }
            if (sizeCm.indexOf("*") > -1) {
               String[] sizeCms = sizeCm.split("\\*");
               sql = "update art_works set size_cm_length=" + Double.valueOf(sizeCms[0].trim()) + ", size_cm_width=" + Double.valueOf(sizeCms[1].trim())
                     + "where id=" + id;
            }
            if (sizeCm.indexOf("X") > -1) {
               String[] sizeCms = sizeCm.split("X");
               sql = "update art_works set size_cm_length=" + Double.valueOf(sizeCms[0].trim()) + ", size_cm_width=" + Double.valueOf(sizeCms[1].trim())
                     + "where id=" + id;
            }
         }
         if (sql != null) updateDate(sql);
      }
      closeConnection();
   }

   private void updateDate(String sql) {
      Statement stmt = null;
      try {
         logger.info("执行更新语句：" + sql);
         stmt = connection.createStatement();
         stmt.executeUpdate(sql);
      }
      catch (SQLException e) {
         logger.error("数据更新错误。");
         logger.error(e);
      }
      catch (Exception e) {
         logger.error("系统错误：" + e.getMessage());
      }
      finally {
         colseObject(stmt, null);
      }
   }

   public List<Map<String, Object>> executeCollect() {
      List<Map<String, Object>> list = null;
      logger.info("拍卖数据采集开始。");
      try {
         Class.forName("com.mysql.jdbc.Driver");
      }
      catch (ClassNotFoundException e) {
         logger.error("找不到数据库驱动程序。");
         return null;
      }
      openConnection();
      if (connection != null) {
         list = goCollection("select id,size_cm from art_works ");
         //closeConnection();
         logger.info("数据采集结束。");
      }
      return list;
   }

   private void openConnection() {
      String userName = "art";
      String password = "art";
      String url = "jdbc:mysql://112.74.131.122:3306/art";
      try {
         connection = DriverManager.getConnection(url, userName, password);
         logger.info("数据库已连接。");
      }
      catch (SQLException e) {
         logger.error("数据库连接失败。");
         connection = null;
      }
   }

   private void closeConnection() {
      try {
         if (connection != null && !connection.isClosed()) {
            connection.close();
            logger.info("数据库已关闭。");
         }
      }
      catch (SQLException e) {
         logger.error("数据库关闭失败。");
      }
   }

   public List<Map<String, Object>> goCollection(String sql) {
      Statement stmt = null;
      ResultSet rs = null;
      List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
      try {
         logger.info("执行查询语句：" + sql);
         stmt = connection.createStatement();
         rs = stmt.executeQuery(sql);
         if (rs == null) return list;
         ResultSetMetaData md = rs.getMetaData(); //得到结果集(rs)的结构信息，比如字段数、字段名等   
         int columnCount = md.getColumnCount(); //返回此 ResultSet 对象中的列数   
         Map<String, Object> rowData = new HashMap<String, Object>();
         while (rs.next()) {
            rowData = new HashMap<String, Object>(columnCount);
            for (int i = 1; i <= columnCount; i++) {
               rowData.put(md.getColumnName(i), rs.getObject(i));
            }
            list.add(rowData);
         }
         return list;
      }
      catch (SQLException e) {
         logger.error("数据查询错误。");
         logger.error(e);
         return list;

      }
      catch (Exception e) {
         logger.error("系统错误：" + e.getMessage());
         return list;
      }
      finally {
         colseObject(stmt, rs);
      }
   }

   protected void colseObject(Statement stmt, ResultSet rs) {
      if (rs != null) {
         try {
            rs.close();
            rs = null;
         }
         catch (SQLException e) {
            logger.error("数据集操作错误。");
         }
      }
      if (stmt != null) {
         try {
            stmt.close();
            stmt = null;
         }
         catch (SQLException e) {
            logger.error("数据集操作错误。");
         }
      }
   }

}
