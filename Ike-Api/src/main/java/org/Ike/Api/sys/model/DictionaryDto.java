package org.Ike.Api.sys.model;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/3/14
 * Version    : 1.0
 * </pre>
 */
public class DictionaryDto implements java.io.Serializable{

    /**
     * 字典唯一CODE
     */
    private String code;

    /**
     * 字典值
     */
    private String value;

    /**
     * 父级ID
     */
    private Integer parent;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
