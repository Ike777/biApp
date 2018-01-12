package com.system.exception;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/4
 * Version    : 1.0
 * </pre>
 */
public class BusinessException extends SystemException{

    public BusinessException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public BusinessException(String errorMsg) {
        super("999999", errorMsg);
    }

    /**
     * @param errorCode 错误码
     * @param ex 异常
     */
    public BusinessException(String errorCode, Exception ex) {
        super(errorCode, ex);
    }

}
