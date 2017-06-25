package com.golead.art.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Quick {

	private Quick(){
		
	}
	
	public static String toStr(Object obj){
		return obj == null ? "" : obj.toString();
	}
	
	public static String toDateStr(Object obj, String formate) {
		return obj == null ? "" : new SimpleDateFormat(formate).format(obj);
	}
	
	public static String toDateStr(Object obj) {
		return obj == null ? "" : new SimpleDateFormat("yyyy-MM-dd").format(obj);
	}
	
	public static boolean isStrNoE(Object obj){
		return (obj == null || obj.toString().trim().length() == 0);
	}
	
	public static void PutWhereClauseTogether(StringBuffer sb, String sql, String param) {
		if(!isStrNoE(param)){
			if(sb != null && sb.length() > 0)
				sb.append(" and ");
			
			if("null".equalsIgnoreCase(param)){
				sql = sql.replaceAll("[=]", " is ");
				sql = sql.replaceAll("[?]", "null");
				
			} else if("notNull".equalsIgnoreCase(param)){
				sql = sql.replaceAll("[=]", " is ");
				sql = sql.replaceAll("[?]", "not null");
				
			} else {
				sql = sql.replaceAll("[?]", param);
			}
			
			sb.append(sql);
		}
	}
	
	public static void PutWhereClauseTogether(StringBuffer sb, String sql) {
		if(!isStrNoE(sql)){
			if(sb != null && sb.length() > 0)
				sb.append(" and ");
		
			sb.append(sql);
		}
	}
	
	public static void copyFile(File master, File clone, int buffSize){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(master);
			fos = new FileOutputStream(clone);
			int len;
			byte[] buff = new byte[buffSize];
			while((len = fis.read(buff)) != -1) {
				fos.write(buff, 0, len);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(fis != null) fis.close();
				if(fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
