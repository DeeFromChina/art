package com.golead.art.app.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.golead.art.app.appUser.dao.ArtAppUserDao;
import com.golead.art.app.appUser.model.ArtAppUser;
import com.golead.art.app.commentary.dao.ArtCommentaryDao;
import com.golead.art.app.commentary.model.ArtCommentary;
import com.golead.art.app.service.MessageFristService;
import com.golead.core.exception.ServiceException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.Encryption;

@Service
public class MessageFristServiceImpl extends BaseServiceImpl implements MessageFristService {
   
   @Override
   public List<Map<String, Object>> selectMessage(Map<String, String> parameters) throws ServiceException {
      try {
         String pageName = parameters.get("pageName");
         if (pageName.equalsIgnoreCase("myCommentary")) return myCommentary(parameters);// 我的留言
         else if (pageName.equalsIgnoreCase("goCommentary")) return goCommentary(parameters);// 意见反馈
      }
      catch (ServiceException e) {
         e.printStackTrace();
      }
      catch (Exception e) {
         e.printStackTrace();
      }

      return null;
   }

   private List<Map<String, Object>> myCommentary(Map<String, String> parameters) throws ServiceException {
      System.out.println("myCommentary...");
      try {
         int userId = isLogin(parameters.get("account"), parameters.get("password"));
         if (userId <= 1) { throw new ServiceException("请先登陆！"); }
         ArtAppUser artAppUser = artAppUserDao.get(Integer.valueOf(userId));
         if (artAppUser == null) { throw new ServiceException("没有找到用户！"); }
         String sql = "SELECT works.id,works.works_c_name AS worksName," + " works.works_status AS descript,user.user_name AS userName,"
               + " DATE_FORMAT(commentary.create_time,'%Y-%m-%d %T') AS time,commentary.commentary_status AS status,"
               + "commentary.content " + " FROM art_commentary commentary "
               + " LEFT JOIN art_app_user user ON user.id=commentary.app_user_id " + " LEFT JOIN art_works works ON works.id=works_id "
               + " WHERE commentary.app_user_id=" + artAppUser.getId() + " AND commentary.comment_type='0' ";
         return jdbcDao.queryBySql(sql);
      }
      catch (ServiceException e) {
         e.printStackTrace();
         List<Map<String, Object>> list = addError(e.getMessage());
         return list;
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   private List<Map<String, Object>> goCommentary(Map<String, String> parameters) throws ServiceException {
      System.out.println("goCommentary...");
      try {
         int userId = isLogin(parameters.get("account"), parameters.get("password"));
         if (userId <= 1) { throw new ServiceException("请先登陆！"); }
         ArtAppUser artAppUser = artAppUserDao.get(Integer.valueOf(userId));
         if (artAppUser == null) { throw new ServiceException("没有找到用户！"); }
         String content = returnString(parameters.get("content"));
         if("".equals(content.trim())){
            throw new ServiceException("内容有误！"); 
         }
         ArtCommentary artCommentary = new ArtCommentary();
         artCommentary.setAppUserId(artAppUser.getId());
         artCommentary.setCommentaryStatus("0");
         artCommentary.setCreateTime(new Date());
         artCommentary.setContent(content);
         artCommentary.setCommentType("1");
         artCommentaryDao.save(artCommentary);
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         Map<String, Object> map = new HashMap<String, Object>();
         map.put("message", "success");
         list.add(map);
         return list;
      }
      catch (ServiceException e) {
         e.printStackTrace();
         List<Map<String, Object>> list = addError(e.getMessage());
         return list;
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   private int isLogin(String account, String password) {
      if (account == null || password == null || "".equals(account) || "".equals(password)) { return 0; }
      List<ArtAppUser> artAppUsers = artAppUserDao.findByField(ArtAppUser.PROP_ACCOUNT_NAME, account);
      password = Encryption.encrypt(password.getBytes());
      if (artAppUsers != null && artAppUsers.size() == 1) {
         ArtAppUser artAppUser = artAppUsers.get(0);
         if ("0".equals(artAppUser.getUserStatus())) { return -1; }
         if (password.equals(returnString(artAppUser.getPassword()))) { return artAppUser.getId(); }
      }
      if (!isInteger(account)) { return 0; }
      artAppUsers = artAppUserDao.findByField(ArtAppUser.PROP_PHONE_NUMBER, Integer.valueOf(account));
      if (artAppUsers != null && artAppUsers.size() == 1) {
         ArtAppUser artAppUser = artAppUsers.get(0);
         if ("0".equals(artAppUser.getUserStatus())) { return -1; }
         if (password.equals(returnString(artAppUser.getPassword()))) { return artAppUser.getId(); }
      }
      return 0;
   }

   private boolean isInteger(String account) {
      try {
         Integer.valueOf(account);
         return true;
      }
      catch (Exception e) {
         return false;
      }
   }

   private String returnString(Object obj) {
      if (obj == null) { return ""; }
      return obj.toString();
   }

   private List<Map<String, Object>> addError(String message) {
      Map<String, Object> map = new HashMap<String, Object>();
      List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
      map.put("error", message);
      list.add(map);
      return list;
   }

   @Resource
   private ArtAppUserDao artAppUserDao;
   
   @Resource
   private ArtCommentaryDao artCommentaryDao;
}
