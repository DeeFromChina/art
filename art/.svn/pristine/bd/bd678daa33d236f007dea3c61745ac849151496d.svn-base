package com.golead.art.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.golead.art.app.service.PictureFristService;
import com.golead.core.exception.ServiceException;
import com.golead.core.service.impl.BaseServiceImpl;

@Service
public class PictureFristServiceImpl extends BaseServiceImpl implements PictureFristService {

   @Override
   public List<Map<String, Object>> pictureShow(Map<String, String> parameters) throws ServiceException {
      try {
         String pageName = parameters.get("pageName");
         if (pageName.equalsIgnoreCase("mainPage")) return mainPage(parameters);// 首页
//         else if (pageName.equalsIgnoreCase("search")) return search(parameters);// 艺术家搜索
//         else if (pageName.equalsIgnoreCase("aristPage")) return aristPage(parameters);// 艺术家主页
      }
      catch (ServiceException e) {
         e.printStackTrace();
      }
      catch (Exception e) {
         e.printStackTrace();
      }

      return null;
   }

   private List<Map<String, Object>> mainPage(Map<String, String> parameters) throws ServiceException {
      System.out.println("mainPage...");
      try {
         String sql = "SELECT page.homepage_photo AS photo,page.seq_no AS no FROM art_app_home_page page WHERE page.homepage_status='1' "
               + " ORDER BY page.seq_no ASC ";
         List<Map<String, Object>> list = jdbcDao.queryBySql(sql);
         if(list != null && list.size() > 0){
            for(Map<String, Object> map : list){
               if(map.get("photo") != null){
                  String photo = map.get("photo").toString().substring(map.get("photo").toString().lastIndexOf("/"));
                  map.put("photo", "app/homepage"+photo);
               }
            }
         }
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

}
