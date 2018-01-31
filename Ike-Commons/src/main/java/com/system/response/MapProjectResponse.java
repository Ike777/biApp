package com.system.response;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/28
 * Version    : 1.0
 * </pre>
 */
public class MapProjectResponse {

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
     * 占地面积
     */
    private Integer areaAmount;

    /**
     * 区域名
     */
    private String regionName;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

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
        this.projectName = projectName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getAreaAmount() {
        return areaAmount;
    }

    public void setAreaAmount(Integer areaAmount) {
        this.areaAmount = areaAmount;
    }
}
