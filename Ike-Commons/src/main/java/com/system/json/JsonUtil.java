package com.system.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class JsonUtil {

    private final static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    /**
     * MSG
     */
    private static String MSG = "成功";

    /**
     * dateConfig
     */
    private static SerializeConfig dateConfig = new SerializeConfig();

    /**
     * 构造
     */
    private JsonUtil() {
        super();
    }

    static {
        dateConfig.put(java.util.Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
        dateConfig.put(java.sql.Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
        dateConfig.put(java.sql.Timestamp.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 将object对象转化为json打印出来
     *
     * @param object
     *            object
     * @param response
     *            response
     * @throws Exception
     *             Exception
     */
    public static void printJsonToPage(Object object, HttpServletResponse response) {
        SerializeWriter out = new SerializeWriter();
        JSONSerializer serializer = new JSONSerializer(out);
        serializer.write(object);
        try {
            out.writeTo(response.getWriter());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 将object对象转化为json打印出来
     *
     * @param object
     *            object
     * @param response
     *            response
     * @throws Exception
     *             Exception
     */
    public static void printJsonToPageParseDate(Object object, HttpServletResponse response) {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            bos.write(JSON.toJSONBytes(object, dateConfig));
            bos.flush();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 把一个对象转换为 JSON<br>
     *
     * @param obj
     *            obj
     * @return JSON
     */
    public static String toJson(Object obj) {
        return JSON.toJSONString(obj, dateConfig);
    }

    /**
     * 把string转换为 JSON对象
     *
     * @param str
     * @return
     */
    public static JSONObject toJson(String str) {
        return JSON.parseObject(str);
    }

    public static JSONObject toJsonObj(Object obj) {
        return JSON.parseObject(JSON.toJSONString(obj, dateConfig));
    }

    /**
     * 把一个json 数组转换为 list<br>
     *
     * @param json
     *            json
     * @param clazz
     *            clazz
     * @param <T>
     *            class
     * @return List<T>
     */
    public static <T> List<T> toArray(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }

    /**
     * 把一个json 数组转换为 Object<br>
     *
     * @param json
     *            json
     * @param clazz
     *            clazz
     * @param <T>
     *            class
     * @return T
     */
    public static <T> T toObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * 把一个json 为 Map<br>
     *
     * @param json
     * @return map
     */
    @SuppressWarnings("rawtypes")
    public static <K, V> Map<K, V> toMap(String json) {
        return (Map<K, V>) JSON.parse(json);
    }
}
