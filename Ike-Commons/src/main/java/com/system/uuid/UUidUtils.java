package com.system.uuid;

import com.system.date.DateUtils;
import org.apache.commons.lang.StringUtils;

import java.util.UUID;

/**
 * <pre> UUid
 * Author: taixiaomin
 * Created at : 2017/11/13
 * Version    : 1.0
 * </pre>
 */
public class UUidUtils {

    private UUidUtils() {
    }

    public static String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};

    /**
     * 生成短八位的UUID
     *
     * @return
     */
    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }


    public static String generateOrderNo(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        StringBuffer buffer = new StringBuffer(key);
        buffer.append(DateUtils.getCurrentDateTime("yyMMddHHmmss"));
        String no = String.valueOf(Math.random() * 90000 + 1).substring(0,5);
        buffer.append(no);
        return buffer.toString();
    }


    public static void main(String[] args){

    }
}
