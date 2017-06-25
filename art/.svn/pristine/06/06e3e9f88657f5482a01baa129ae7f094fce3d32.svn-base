package com.golead.art.app.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.golead.art.app.appUser.dao.ArtAppUserDao;
import com.golead.art.app.appUser.model.ArtAppUser;
import com.golead.art.app.service.DataUploadService;
import com.golead.art.utils.FileUtils;
import com.golead.core.exception.ServiceException;

@Service
public class DataUploadServiceImpl implements DataUploadService {

   private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
   
   public void uploadFile(Map<String, String> record, File doc) throws ServiceException{
      try {
         String userId = record.get("userId");
         String fileName = record.get("fileName");
         String endless = fileName.substring(fileName.lastIndexOf("."));
         ArtAppUser artAppUser = artAppUserDao.get(Integer.valueOf(userId));
         String cName = String.valueOf(System.currentTimeMillis());
         cName = cName + endless;
         String FILE_PATH = ServletActionContext.getServletContext().getRealPath("/upload/app/");
         String path = FILE_PATH + userId;
         File file = new File(path);
         if(!file.exists()){
            file.mkdirs();
         }
         File[] files = file.listFiles();
         for(int i = 0; i<file.length(); i++){
            File file2 = files[i];
            if(file2.isFile()){
               file2.delete();
            }
         }
         String fullPaht = path + File.separator + cName;
         // 上传文件
         FileUtils.fileUpload(fullPaht, doc);
         artAppUser.setPhoto(userId+"/"+cName);

      }
      catch (Exception e) {
         throw new ServiceException(e.getMessage());
      }
   }

   @Resource
   private ArtAppUserDao artAppUserDao;
   
}
