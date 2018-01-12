package com.system.exception;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/4
 * Version    : 1.0
 * </pre>
 */
public class SystemException extends RuntimeException {

    public SystemException(Throwable t) {
        super(t);
    }

    public String toString() {
        return super.toString();
    }

    /**
     * 构造函数
     *
     * @param errorCode 错误编码
     * @param errorMsg  错误消息
     */
    public SystemException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    /**
     * 构造函数
     *
     * @param errorMsg 错误消息
     */
    public SystemException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    /**
     * 构造函数
     *
     * @param e 错误异常
     */
    public SystemException(Exception e) {
        super(e);
        this.errorMsg = e.getMessage();
    }

    /**
     * 构造异常
     *
     * @param errorCode 异常状态码
     * @param ex        异常来源
     */
    public SystemException(String errorCode, Exception ex) {
        super(ex);
        this.errorCode = errorCode;
    }

    /**
     * @return 返回 errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode 参数 errorCode
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return 返回 errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @param errorMsg 参数 errorMsg
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * 错误编码
     */
    private String errorCode;

    /**
     * 错误消息
     */
    private String errorMsg;

}
