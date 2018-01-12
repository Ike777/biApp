package com.system.response;

import java.util.Date;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/8
 * Version    : 1.0
 * </pre>
 */
public class MapRegionResponse {

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getLevelSt() {
        return levelSt;
    }

    public void setLevelSt(String levelSt) {
        this.levelSt = levelSt;
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
        this.populationSt = populationSt;
    }
}
