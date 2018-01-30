package com.system.request;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/28
 * Version    : 1.0
 * </pre>
 */
public class MapProjectRequest extends BaseRequest{

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

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
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
}
