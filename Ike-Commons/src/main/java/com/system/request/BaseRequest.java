package com.system.request;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/8
 * Version    : 1.0
 * </pre>
 */
public class BaseRequest implements java.io.Serializable{

    private String pageNumber;//当前页

    private String pageSize;//大小

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
