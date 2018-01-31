package org.Ike.Api.region.model;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/30
 * Version    : 1.0
 * </pre>
 */
public class RegionDict implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;

    /**
     * 区域名称
     */
    private String regionName;

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
}
