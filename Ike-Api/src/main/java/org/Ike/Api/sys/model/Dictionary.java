package org.Ike.Api.sys.model;

import java.util.Date;

public class Dictionary {
    /**
     * 
     */
    private Integer id;

    /**
     * 字典唯一CODE
     */
    private String code;

    /**
     * 字典值
     */
    private String value;

    /**
     * 描述
     */
    private String comment;

    /**
     * 父级ID
     */
    private Integer parent;

    /**
     * 系统创建时间
     */
    private Date sysCreateDate;

    /**
     * 记录的版本 乐观锁
     */
    private Integer version;

    /**
     * 1 已逻辑删除 0 启用中
     */
    private Integer disabled;

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    
    
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    
    
    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    
    
    public Date getSysCreateDate() {
        return sysCreateDate;
    }

    public void setSysCreateDate(Date sysCreateDate) {
        this.sysCreateDate = sysCreateDate;
    }

    
    
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    
    
    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }
}