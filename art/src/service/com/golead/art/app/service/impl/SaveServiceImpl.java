package com.golead.art.app.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;

import com.golead.art.app.service.SaveService;
import com.golead.art.app.service.UserFristService;
import com.golead.core.exception.ServiceException;
import com.golead.core.service.impl.BaseServiceImpl;

@Service
public class SaveServiceImpl extends BaseServiceImpl implements SaveService {
   
   private Map<String, Object> map = new HashMap<String, Object>();

   public String save(Map<String, String> parameters, File photo) throws ServiceException {
      String version = parameters.get("version");
      String module = parameters.get("module");
      String userId = parameters.get("userId");
      map.put("version", version);
      map.put("userId", userId);
      if (module.equalsIgnoreCase("userManager")) return userManager(parameters, photo);// 用户中心
//      else if (module.equalsIgnoreCase("seachManager")) return seachManager(parameters);// 搜索
//      else if (module.equalsIgnoreCase("pictureShow")) return pictureShow(parameters);// 热图展示
//      else if (module.equalsIgnoreCase("artistManager")) return artistManager(parameters);// 艺术家信息
//      else if (module.equalsIgnoreCase("worksManager")) return worksManager(parameters);// 艺术品信息
//      else if (module.equalsIgnoreCase("messageManager")) return messageManager(parameters);// 留言

      return null;
   }
   

   private String userManager(Map<String, String> parameters, File photo) {
      String version = parameters.get("version");
      try {
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         if (version.equalsIgnoreCase("1.0")){
            System.out.println("download art_project 1.0 data...");
            String userId = userFristService.addUser(parameters, photo);
            map.put("userId", userId);
         }
         String chkError = chkError(list);
         if(chkError != null){
            return chkError;
         }
         return toJson(list);
      }
      catch (ServiceException e) {
         e.printStackTrace();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   private String chkError(List<Map<String, Object>> list){
      if(list == null || list.size() == 0){
         list = new ArrayList<Map<String, Object>>();
      }
      if(list.size() > 0){
         for(Map<String, Object> listMap : list){
            if(listMap.get("error") != null){
               return "error:" + listMap.get("error").toString();
            }
         }
      }
      list.add(map);
      return null;
   }
   
   private String toJson(List<Map<String, Object>> list) {
      JSONArray jsonObject = JSONArray.fromObject(list);
      return jsonObject.toString();
   }

   @Resource
   private UserFristService userFristService;
}
