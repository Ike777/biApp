package com.system.reflect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

public abstract class ReflectUtil {

	private final static Logger logger = LoggerFactory.getLogger(ReflectUtil.class);

	private ReflectUtil() {
		super();
	}

	public static Object getClassField(Object obj, String name) {
		try {
			Field field = getField(obj.getClass(), name);
			return field.get(obj);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public static void setClassField(Object obj, String name, Object value) {
		try {
			Field field = getField(obj.getClass(), name);
			field.set(obj, value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public static Object getSuperClassField(Object obj, String name) {
		try {
			Field field = getField(obj.getClass().getSuperclass(), name);
			return field.get(obj);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	private static Field getField(Class<?> clazz, String name) {
		Field field = null;
		for (Field f : clazz.getDeclaredFields()) {
			if (f.getName().equals(name)) {
				f.setAccessible(true);
				field = f;
				break;
			}
		}
		return field;
	}

}