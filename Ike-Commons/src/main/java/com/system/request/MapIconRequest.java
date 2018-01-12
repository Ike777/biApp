package com.system.request;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/8
 * Version    : 1.0
 * </pre>
 */
public class MapIconRequest extends BaseRequest{

    /**
     * MAP_REGION.ID
     */
    private Integer regionId;

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }
}
