package com.golead.art.job.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.golead.art.utils.DateUtils;

public class DataCollectHandler {

   private SimpleDateFormat outFormat = new SimpleDateFormat("yyyy-MM-dd");

   private Log              logger    = LogFactory.getLog(DataCollectHandler.class);

   private Connection       connection;

   public DataCollectHandler() {
      executeCollect();
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
         Date yesterday = DateUtils.adjustDate(DateUtils.DAY, -1, new Date());
         String date = outFormat.format(yesterday);
         list = goCollection("select * from art t where t.url like 'http://auction.artron.net/paimai%' and  t.createTime BETWEEN '" + date + " 00:00:00' and '" + date + " 23:59:59';");//
         closeConnection();
         logger.info("数据采集结束。");
      }
      return list;
   }

   private void openConnection() {
      String userName = "art";
      String password = "123456";
      String url = "jdbc:mysql://211.162.122.49:13306/wechat_art";
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
