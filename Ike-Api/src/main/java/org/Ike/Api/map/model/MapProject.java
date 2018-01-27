package org.Ike.Api.map.model;

import java.util.Date;

public class MapProject {
    /**
     * 
     */
    private Integer id;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 区
     */
    private String area;

    /**
     * MAP_REGION.ID
     */
    private Integer regionId;

    /**
     * 区域名 冗余字段
     */
    private String regionName;

    /**
     * 占地面积
     */
    private Integer areaAmount;

    /**
     * 
     */
    private Integer price;

    /**
     * 
     */
    private Integer version;

    /**
     * 
     */
    private Date createDate;

    /**
     * 1 已删除 
     */
    private Integer disabled;

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    
    
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    
    
    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    
    
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    
    
    public Integer getAreaAmount() {
        return areaAmount;
    }

    public void setAreaAmount(Integer areaAmount) {
        this.areaAmount = areaAmount;
    }

    
    
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    
    
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    
    
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
    
    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }
}