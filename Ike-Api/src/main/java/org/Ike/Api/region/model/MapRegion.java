package org.Ike.Api.region.model;

import java.util.Date;

public class MapRegion {
    /**
     * 
     */
    private Integer id;

    /**
     * 区域名称
     */
    private String regionName;

    /**
     * 区域码 WX0001
     */
    private String regionCode;

    /**
     * 成熟度Code 候选项：起步 成长 成熟
     */
    private String levelSt;

    /**
     * yyyy-MM-dd 成立时间 手填
     */
    private Date createDate;

    /**
     * 区域均价 单位：元
     */
    private Long price;

    /**
     *  最高价 单位：元
     */
    private Long topPrice;

    /**
     * 人口密度Code 候选项：待定
     */
    private String populationSt;

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

    
    
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regignName) {
        this.regionName = regignName == null ? null : regignName.trim();
    }

    
    
    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode == null ? null : regionCode.trim();
    }

    
    
    public String getLevelSt() {
        return levelSt;
    }

    public void setLevelSt(String levelSt) {
        this.levelSt = levelSt == null ? null : levelSt.trim();
    }

    
    
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
    
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    
    
    public Long getTopPrice() {
        return topPrice;
    }

    public void setTopPrice(Long topPrice) {
        this.topPrice = topPrice;
    }

    
    
    public String getPopulationSt() {
        return populationSt;
    }

    public void setPopulationSt(String populationSt) {
        this.populationSt = populationSt == null ? null : populationSt.trim();
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