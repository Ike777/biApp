package com.system.mybatis;

import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert implements Converter{

	@SuppressWarnings("all")
	public Object convert(Class arg0, Object arg1) {
		if(arg1 instanceof String){
			String p = (String)arg1;
			if(p== null || p.trim().length()==0){
				return null;
			}   
			try{
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return df.parse(p.trim());
			}
			catch(Exception e){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parse(p.trim());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		}else if(arg1 instanceof java.sql.Date){
			return new Date(((Date)arg1).getTime());
		}else if(arg1 instanceof Date){
			return arg1;
		}
		return null;

	}
}
