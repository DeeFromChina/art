package com.golead.art.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;

import com.golead.art.app.service.ArtistFristService;
import com.golead.art.app.service.MessageFristService;
import com.golead.art.app.service.PictureFristService;
import com.golead.art.app.service.QueryService;
import com.golead.art.app.service.ScreenFristService;
import com.golead.art.app.service.SeachFristService;
import com.golead.art.app.service.UserFristService;
import com.golead.art.app.service.WorksFristService;
import com.golead.common.service.system.SysRoleService;
import com.golead.common.service.system.SysUserService;
import com.golead.core.exception.ServiceException;
import com.golead.core.service.impl.BaseServiceImpl;

@Service
public class QueryServiceImpl extends BaseServiceImpl implements QueryService {

   private static final long serialVersionUID = 1L;
   
   public String sreachData(Map<String, String> parameters) throws ServiceException {
      String module = parameters.get("module");
      if (module.equalsIgnoreCase("userManager")) return userManager(parameters);// 用户中心
      else if (module.equalsIgnoreCase("seachManager")) return seachManager(parameters);// 搜索
      else if (module.equalsIgnoreCase("pictureShow")) return pictureShow(parameters);// 热图展示
      else if (module.equalsIgnoreCase("artistManager")) return artistManager(parameters);// 艺术家信息
      else if (module.equalsIgnoreCase("worksManager")) return worksManager(parameters);// 艺术品信息
      else if (module.equalsIgnoreCase("messageManager")) return messageManager(parameters);// 留言
      else if (module.equalsIgnoreCase("screenManager")) return screenManager(parameters);// 留言

      return null;
   }

   private String userManager(Map<String, String> parameters) {
      String version = parameters.get("version");
      try {
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         if (version.equalsIgnoreCase("1.0")){
            System.out.println("download art_project 1.0 data...");
            list = userFristService.appUser(parameters);
         }
         String chkError = chkError(list);
         if(chkError != null){
            return chkError;
         }
//         for(Map<String, Object> map : list){
//            if(map.get("userId") != null){
//               return "登陆成功";
//            }
//         }
         if(list.size() == 0){
            list = null;
         }
         return listToJson(list);
      }
      catch (ServiceException e) {
         e.printStackTrace();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }
   
   private String seachManager(Map<String, String> parameters) {
      String version = parameters.get("version");
      try {
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         if (version.equalsIgnoreCase("1.0")){
            System.out.println("download art_project 1.0 data...");
            list = seachFristService.seachArt(parameters);
         }
         String chkError = chkError(list);
         if(chkError != null){
            return chkError;
         }
         if(list != null){
            for(Map<String, Object> map : list){
               if(map.get("userId") != null){
                  return "id:" + map.get("userId").toString();
               }
            }
         }
         return listToJson(list);
      }
      catch (ServiceException e) {
         e.printStackTrace();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }
   
   private String pictureShow(Map<String, String> parameters) {
      String version = parameters.get("version");
      try {
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         if (version.equalsIgnoreCase("1.0")){
            System.out.println("download art_project 1.0 data...");
            list = pictureFristService.pictureShow(parameters);
         }
         String chkError = chkError(list);
         if(chkError != null){
            return chkError;
         }
         return listToJson(list);
      }
      catch (ServiceException e) {
         e.printStackTrace();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }
   
   private String artistManager(Map<String, String> parameters) {
      String version = parameters.get("version");
      try {
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         if (version.equalsIgnoreCase("1.0")){
            System.out.println("download art_project 1.0 data...");
            list = artistFristService.selectArtist(parameters);
         }
         String chkError = chkError(list);
         if(chkError != null){
            return chkError;
         }
         return listToJson(list);
      }
      catch (ServiceException e) {
         e.printStackTrace();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }
   
   private String worksManager(Map<String, String> parameters) {
      String version = parameters.get("version");
      try {
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         if (version.equalsIgnoreCase("1.0")){
            System.out.println("download art_project 1.0 data...");
            list = worksFristService.selectWorks(parameters);
         }
         String chkError = chkError(list);
         if(chkError != null){
            return chkError;
         }
         return listToJson(list);
      }
      catch (ServiceException e) {
         e.printStackTrace();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }
   
   private String messageManager(Map<String, String> parameters) {
      String version = parameters.get("version");
      try {
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         if (version.equalsIgnoreCase("1.0")){
            System.out.println("download art_project 1.0 data...");
            list = messageFristService.selectMessage(parameters);
         }
         String chkError = chkError(list);
         if(chkError != null){
            return chkError;
         }
         return listToJson(list);
      }
      catch (ServiceException e) {
         e.printStackTrace();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }
   
   private String screenManager(Map<String, String> parameters) {
      String version = parameters.get("version");
      try {
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
         if (version.equalsIgnoreCase("1.0")){
            System.out.println("download art_project 1.0 data...");
            list = screenFristService.selectScreen(parameters);
         }
         String chkError = chkError(list);
         if(chkError != null){
            return chkError;
         }
         return listToJson(list);
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
      return null;
   }

   private String listToJson(List<Map<String, Object>> list) {
      JSONArray jsonObject = JSONArray.fromObject(list);
      return jsonObject.toString();
   }

   @Resource
   private SysRoleService sysRoleService;

   @Resource
   private SysUserService sysUserService;
   
   @Resource
   private UserFristService userFristService;
   
   @Resource
   private SeachFristService seachFristService;
   
   @Resource
   private PictureFristService pictureFristService;
   
   @Resource
   private ArtistFristService artistFristService;
   
   @Resource
   private WorksFristService worksFristService;
   
   @Resource
   private MessageFristService messageFristService;
   
   @Resource
   private ScreenFristService screenFristService;

}
