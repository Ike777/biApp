/*
 * Copyright (C) 2011 Fhpt All Rights Reserved.
 * 
 * chenghong
 */
package com.system.date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

	private static final Logger logger = LoggerFactory.getLogger(DateFormat.class);

	/**
	 * FMT_DATE_YYYYMMDD
	 */
	public static final int FMT_DATE_YYYYMMDD = 1;

	/**
	 * FMT_DATE_YYYYMMDD_HHMMSS
	 */
	public static final int FMT_DATE_YYYYMMDD_HHMMSS = 2;

	/**
	 * FMT_DATE_HHMMSS
	 */
	public static final int FMT_DATE_HHMMSS = 3;

	/**
	 * FMT_DATE_HHMM
	 */
	public static final int FMT_DATE_HHMM = 4;

	/**
	 * FMT_DATE_SPECIAL
	 */
	public static final int FMT_DATE_SPECIAL = 5;

	/**
	 * FMT_DATE_YYYYMMDDHHMMSS
	 */
	public static final int FMT_DATE_YYYYMMDDHHMMSS = 6;

	/**
	 * 构造文件隐藏
	 */
	private DateFormat() {

	}

	/**
	 * 日期格式
	 */
	public static final String DATESTYLE_LONG = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 将日期转换成指定格式的字符串
	 * 
	 * @param date
	 *            日期
	 * @param style
	 *            日期格式
	 * @return 指定格式的字符串
	 */
	public static String dateToString(Date date, String style) {
		SimpleDateFormat dFmt = new SimpleDateFormat(style);
		return dFmt.format(date);
	}

	/**
	 * this function is to format date into a string @ param date the date to be
	 * formatted.
	 * 
	 * @param nFmt
	 *            FMT_DATE_YYYYMMDD to format string like 'yyyy-mm-dd' or to
	 *            format string like 'yyyy-mm-dd hh:mm:ss'
	 * @param date
	 *            d
	 * @return String
	 */
	public static String formatDate(Date date, int nFmt) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat fmtDate = new SimpleDateFormat();
		switch (nFmt) {
		case DateFormat.FMT_DATE_YYYYMMDD:
			fmtDate.applyPattern("yyyy-MM-dd");
			break;
		case DateFormat.FMT_DATE_YYYYMMDD_HHMMSS:
			fmtDate.applyPattern("yyyy-MM-dd HH:mm:ss");
			break;
		case DateFormat.FMT_DATE_HHMM:
			fmtDate.applyPattern("HH:mm");
			break;
		case DateFormat.FMT_DATE_HHMMSS:
			fmtDate.applyPattern("HH:mm:ss");
			break;
		case DateFormat.FMT_DATE_SPECIAL:
			fmtDate.applyPattern("yyyyMMdd");
			break;
		case DateFormat.FMT_DATE_YYYYMMDDHHMMSS:
			fmtDate.applyPattern("yyyyMMddHHmmss");
			break;
		default:
		}
		return fmtDate.format(date);
	}

	/**
	 * parse date from string with specific format.
	 * 
	 * @param strDate
	 *            a date string
	 * @param nFmtDate
	 *            specific date string format defined in this class.
	 * @exception raise
	 *                ParseException, if string format dismathed.
	 * @return Date 日期类型
	 */
	public static Date parseDate(String strDate, int nFmtDate) {
		SimpleDateFormat fmtDate = new SimpleDateFormat();
		switch (nFmtDate) {
		case DateFormat.FMT_DATE_YYYYMMDD:
			fmtDate.applyPattern("yyyy-MM-dd");
			break;
		case DateFormat.FMT_DATE_YYYYMMDD_HHMMSS:
			fmtDate.applyLocalizedPattern("yyyy-MM-dd HH:mm:ss");
			break;
		case DateFormat.FMT_DATE_HHMM:
			fmtDate.applyLocalizedPattern("HH:mm");
			break;
		case DateFormat.FMT_DATE_HHMMSS:
			fmtDate.applyLocalizedPattern("HH:mm:ss");
			break;
		default:
		}
		try {
			return fmtDate.parse(strDate);
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * @param strDate
	 * @param style
	 * @return
	 */
	public static Date parseDate(String strDate, String style) {
		try {
			SimpleDateFormat fmtDate = new SimpleDateFormat(style);
			return fmtDate.parse(strDate);
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
}
