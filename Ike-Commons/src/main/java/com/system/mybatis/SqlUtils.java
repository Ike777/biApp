package com.system.mybatis;

import org.apache.commons.lang.StringUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SqlUtils {

	private SqlUtils() {
		super();
	}

	public static String buildPageSqlForOracle(String sql, Page page) {
		boolean isForUpdate = false;
		if (sql.toLowerCase().endsWith(" for update")) {
			sql = sql.substring(0, sql.length() - 11);
			isForUpdate = true;
		}
		StringBuilder pageSql = new StringBuilder(100);
		String beginrow = String.valueOf((page.getPage() - 1) * page.getPageSize());
		String endrow = String.valueOf(page.getPage() * page.getPageSize());
		pageSql.append("select * from ( select temp.*, rownum row_id from ( ");
		pageSql.append(sql);
		pageSql.append(" ) temp where rownum <= ").append(endrow);
		pageSql.append(") where row_id > ").append(beginrow);
		if (isForUpdate) {
			pageSql.append(" for update");
		}
		return pageSql.toString();
	}

	public static String buildPageSqlForMysql(String sql, Page page) {
		boolean isForUpdate = false;
		if (sql.toLowerCase().endsWith(" for update")) {
			sql = sql.substring(0, sql.length() - 11);
			isForUpdate = true;
		}
		StringBuilder pageSql = new StringBuilder(100);
		String beginrow = String.valueOf((page.getPage() - 1) * page.getPageSize());
		pageSql.append(sql);
		pageSql.append(" limit " + beginrow + "," + page.getPageSize());

		if (isForUpdate) {
			pageSql.append(" for update");
		}
		return pageSql.toString();
	}

	public static String getCountSql(String sql) {
		return "select count(0) from (" + sql + ") count_temp";
	}

	public static String toParamSql(String sql, Map<String, String> param) {
		if (!StringUtils.isEmpty(sql)) {
			Set<Entry<String, String>> entrySet = param.entrySet();
			Iterator<Entry<String, String>> iterator = entrySet.iterator();
			Entry<String, String> next;
			String key;
			String val;
			while (iterator.hasNext()) {
				next = iterator.next();
				key = next.getKey();
				val = next.getValue();
				if (StringUtils.isEmpty(val)) {
					sql = sql.replaceAll("'#\\{" + key + "\\}'", "'1' or 1=1");
					sql = sql.replaceAll("'%#\\{" + key + "\\}%'", "'1' or 1=1");
					sql = sql.replaceAll("'%#\\{" + key + "\\}'", "'1' or 1=1");
					sql = sql.replaceAll("'#\\{" + key + "\\}%'", "'1' or 1=1");
				} else {
					sql = sql.replaceAll("#\\{" + key + "\\}", val.trim());
				}
			}

			sql = sql.replaceAll("'#\\{.*\\}'", "'1' or 1=1");
			sql = sql.replaceAll("'%#\\{.*\\}%'", "'1' or 1=1");
			sql = sql.replaceAll("'%#\\{.*\\}'", "'1' or 1=1");
			sql = sql.replaceAll("'#\\{.*\\}%'", "'1' or 1=1");
		}
		return sql;
	}
}
