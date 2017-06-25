package com.golead.art.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {
   
   /**
    * 写文件
    * @param filePath
    * @param image
    */
	public static void fileUpload(String filePath,File image) {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
        	File file = new File(filePath);
			if (!file.exists()) file.createNewFile();
            // 建立文件输出流
            fos = new FileOutputStream(filePath);
            // 建立文件上传流
            fis = new FileInputStream(image);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			try {
				if (fos != null) fos.close();
				if (fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

        }
    }
	
	/**
	 * 删除文件
	 * @param filePath
	 */
	public static void deleteFile(String filePath) {
		File file = new File(filePath);		
		if(file.exists()) 
			file.delete();
	}

	/**
	 * 读取文件为String
	 * @param src
	 * @return
	 */
   public static String readFromFile(File src) {
      BufferedReader bufferedReader = null;
      try {
         bufferedReader = new BufferedReader(new FileReader(src));
         StringBuilder stringBuilder = new StringBuilder();
         String content;
         while ((content = bufferedReader.readLine()) != null) {
            stringBuilder.append(content);
         }
         return stringBuilder.toString();
      }
      catch (FileNotFoundException e) {
         e.printStackTrace();
         return null;
      }
      catch (IOException e) {
         e.printStackTrace();
         return null;
      }
      finally {
         try {
            if (bufferedReader != null) bufferedReader.close();
         }
         catch (IOException e) {
            e.printStackTrace();
         }

      }
   }
}
