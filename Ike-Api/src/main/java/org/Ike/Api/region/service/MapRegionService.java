package org.Ike.Api.region.service;

import com.system.mybatis.Page;
import com.system.request.MapRegionRequest;
import com.system.response.MapRegionResponse;
import org.Ike.Api.region.model.MapRegion;

import java.util.List;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/7
 * Version    : 1.0
 * </pre>
 */
public interface MapRegionService {
    /**
     * 分页查询
     *
     * @param request
     * @param page
     * @return
     */
    List<MapRegionResponse> getMapRegionByPage(MapRegionRequest request, Page page);

    /**
     * 保存区域
     *
     * @param mapRegion
     */
    void save(MapRegion mapRegion);

    /**
     * 获取区域列表
     *
     * @param regionRequest
     * @return
     */
    List<MapRegion> getMapRegionList(MapRegionRequest regionRequest);
}
