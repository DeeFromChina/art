package com.golead.common.web.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class GlobalDateTimeConverter extends DefaultTypeConverter {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public Object convertValue(Map<String, Object> context, Object value, Class toType) {
		
		try {
			
			if(toType.equals(Date.class)) {
				
		         String dateString = null; 
		         String[] params = (String[])value; 
		         dateString = params[0];//获取日期的字符串 
		         
		         return sdf.parse(dateString);
		         
			} else {
				
				 Date date = (Date)value;
				 return sdf.format(date);
				 
			}
			
		} catch (Exception e) {
			
			return null;
			
		}
		
	}

}
