package com.system.mybatis;

import com.system.exception.SystemException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.apache.commons.beanutils.converters.SqlTimestampConverter;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

public class BeanUtils extends org.apache.commons.beanutils.BeanUtils {

	private final static Logger logger = LoggerFactory.getLogger(BeanUtils.class);

	private BeanUtils() {
		super();
	}

	static {
		// 注册sql.date的转换器，即允许BeanUtils.copyProperties时的源目标的sql类型的值允许为空
		ConvertUtils.register(new SqlDateConverter(), java.util.Date.class);
		ConvertUtils.register(new SqlTimestampConverter(null), java.sql.Timestamp.class);
		// 注册util.date的转换器，即允许BeanUtils.copyProperties时的源目标的util类型的值允许为空
		ConvertUtils.register(new DateConvert(), java.util.Date.class);
	}

	public static void copyProperties(Object target, Object source) {
		// 支持对日期copy
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(target, source);
		} catch (Exception e) {
			throw new SystemException(e.getMessage(), e);
		}
	}

	/**
	 * 设置属性的值
	 * 
	 * @param bean
	 * @param name
	 * @param value
	 * @return
	 */
	public static Field setValue(Object bean, String name, Object value) {
		try {
			Class<?> clazz = bean.getClass();
			Field field = clazz.getDeclaredField(name);
			field.setAccessible(true);
			field.set(bean, value);
			return field;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * 通过对象的属性名 获得属性值
	 * 
	 * @param bean
	 * @param name
	 * @return
	 */
	public static Object getValue(Object bean, String name) {
		try {
			if (bean != null) {
				Class<?> clazz = bean.getClass();
				String[] names = name.split("\\.");
				for (String na : names) {
					bean = clazz.getMethod("get" + StringUtils.capitalize(na)).invoke(bean);
					if (bean == null) {
						return null;
					}
					clazz = bean.getClass();
				}
				return bean;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

}
