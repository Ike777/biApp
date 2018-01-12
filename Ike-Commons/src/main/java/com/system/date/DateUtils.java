package com.system.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <pre> 日期工具类
 * Author: taixiaomin
 * Created at : 2017/11/13
 * Version    : 1.0
 * </pre>
 */
public class DateUtils {

    private DateUtils() {
    }

    private static final String pattern = "yyyy-MM-dd HH:mm:ss";

    private static SimpleDateFormat sdf = new SimpleDateFormat(pattern);

    /**
     * 获得当前时间字符串，格式yyyy-MM-dd HH:mm:ss
     *
     * @return 系统时间字符串
     */
    public static String getCurrentDateTime() {
        return sdf.format(new Date());
    }
    

    /**
     * 获得当前时间字符串，格式自定义
     *
     * @return 系统时间字符串
     */
    public static String getCurrentDateTime(String pattern) {
        SimpleDateFormat fmt = new SimpleDateFormat(pattern);
        return fmt.format(new Date());
    }

    /**
     * 获取当前Date
     *
     * @return Date
     */
    public static Date getCurrentTime() {
        return new Date();
    }

    /**
     * 按指定的格式返回系统时间字符串
     *
     * @param format
     * @return
     */
    public static String getDateTimeString(String format) {
        return sdf.format(new Date());
    }

    /**
     * 字符串转date,默认为yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static Date string2Date(String date) {
        return string2Date(date, pattern);
    }

    /**
     * 字符串转为指定格式的date
     *
     * @param date
     * @param pattern
     * @return
     */
    public static Date string2Date(String date, String pattern) {
        try {
            return sdf.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * date转为String
     *
     * @param date
     * @return
     */
    public static String date2String(Date date) {
        return date2String(date, pattern);
    }

    /**
     * date转为String
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String date2String(Date date, String pattern){
        sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
    
    /**
     * 减少一年时间
     * @param date
     * @return
     * @throws Exception
     */
    public static Date decOneYear(Date date) throws Exception{
    	Date newDate = null;
    	Calendar c = Calendar.getInstance();
    	c.clear();
    	c.setTime(date);
    	c.add(Calendar.YEAR, -1);
		try {
			newDate = c.getTime();
		} catch (Exception e) {
			throw new Exception("时间转换出错");
		}
		return newDate;
    }
    
    /**
     * 让时间精确到秒
     * @param date
     * @return
     * @throws Exception
     */
    public static Date changeTimeFormat(Date date){
    	SimpleDateFormat lsdStrFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strD = lsdStrFormat.format(DateUtils.getCurrentTime()); 
		Date newDate;
		try {
			newDate = lsdStrFormat.parse(strD);
			return newDate;
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return null;
    }

}
