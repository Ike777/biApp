package org.Ike.Api.region.domain;

import com.system.mybatis.Page;
import com.system.request.MapRegionRequest;
import org.Ike.Api.region.model.RegionPointsVo;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/7
 * Version    : 1.0
 * </pre>
 */
public interface MapRegionDomain {
    /**
     * 分页列表
     *
     * @param request
     * @param page
     * @return
     */
    Page getMapRegionByPage(MapRegionRequest request, Page page);

    /**
     * 创建区域
     *
     * @param regionPointsVo
     */
    void createRegion(RegionPointsVo regionPointsVo);
}
