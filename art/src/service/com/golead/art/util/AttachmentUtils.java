package com.golead.art.util;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author jiahua-lan 12/14/16.
 */
public class AttachmentUtils {
   private static Logger logger = LoggerFactory.getLogger(AttachmentUtils.class);

   private AttachmentUtils() {
   }

   /**
    * 生成新的附件名
    *
    * @param fileName
    *           附件的原文件名
    * @return 附件的原文件名+根据系统时间生成的保存在文件系统中的文件名以/分割
    */
   public static String getNewAttachmentName(String fileName) {
      logger.debug("fileName:" + fileName);
      String suffix = fileName.substring(fileName.indexOf("."));
      String prefix = String.valueOf(System.currentTimeMillis());
      String newFileName = prefix + suffix;
      logger.debug("newFileName:" + newFileName);
      return fileName + "/" + newFileName;
   }

   /**
    * 替换附件
    *
    * @param file
    *           新的附件文件
    * @param fileName
    *           新的文件名
    * @param dirPath
    *           附件所在的文件夹路径
    * @param oldAttachmentName
    *           旧附件名(格式为： "*.*\/*.*)
    */
   public static String replaceAttachment(File file, String fileName, String dirPath, final String oldAttachmentName) {
      File attachmentDir = new File(dirPath);
      try {
         logger.debug("AttachmentFileName:" + fileName);
         if (isisDirectory(attachmentDir)) {
            File[] files = attachmentDir.listFiles(new FilenameFilter() {
               @Override
               public boolean accept(File file, String s) {
                  return s.equals(oldAttachmentName);
               }
            });
            for (File f : files) {
               f.delete();
            }
            return addAttachment(file, fileName, dirPath);
         }
      }
      catch (IOException e) {
         logger.error(e.getMessage(), e);
      }
      return null;
   }

   /**
    * 添加附件
    *
    * @param file
    *           附件文件
    * @param fileName
    *           附件文件名
    * @param dirPath
    *           附件所在的文件夹路径
    */
   public static String addAttachment(File file, String fileName, String dirPath) {
      File dir = new File(dirPath);
      try {
         if (isisDirectory(dir)) {
            String newFileName = getNewAttachmentName(fileName);
            File target = new File(dirPath + File.separator + newFileName.split("/")[1]);
            FileUtils.copyFile(file, target);
            return newFileName;
         }
      }
      catch (IOException e) {
         logger.error(e.getMessage(), e);
      }
      return null;
   }

   /**
    * 删除附件
    *
    * @param dirPath
    *           附件所在的文件夹路径
    * @param attachmentNames
    *           附件的文件名
    */
   public static void deleteAttachment(String dirPath, final String[] attachmentNames) {
      File file = new File(dirPath);
      try {
         if (isisDirectory(file)) {
            File[] files = file.listFiles(new FilenameFilter() {
               @Override
               public boolean accept(File file, String filename) {
                  return (Arrays.asList(attachmentNames).contains(filename));
               }
            });
            for (File deleteFile : files) {
               deleteFile.delete();
            }
         }
      }
      catch (IOException e) {
         logger.error(e.getMessage(), e);
      }
   }

   /**
    * 移动附件
    *
    * @param dirPath
    *           文件附件所在的文件夹
    * @param targetPath
    *           目标文件夹
    * @param fileName
    *           附件文件名
    */
   public static void moveAttachment(String dirPath, String targetPath, final String fileName) {
      File dir = new File(dirPath);
      final File target = new File(targetPath);
      try {
         if (isisDirectory(dir) && isisDirectory(target)) {
            dir.listFiles(new FilenameFilter() {
               @Override
               public boolean accept(File dir, String name) {
                  if (fileName.equals(name)) {
                     try {
                        FileUtils.copyFileToDirectory(dir, target);
                     }
                     catch (IOException e) {
                        e.printStackTrace();
                     }
                  }
                  return false;
               }
            });
         }
      }
      catch (IOException e) {
         logger.error(e.getMessage(), e);
      }
   }

   /**
    * 判断该文件是否指向一个文件夹
    */
   private static boolean isisDirectory(File file) throws IOException {
      if (file.exists() && file.isDirectory()) {
         return true;
      }
      else {
         throw new IOException("该路径指向的不是一个文件夹");
      }
   }
}
