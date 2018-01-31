package org.Ike.Core.region.service;

import com.system.mybatis.Page;
import com.system.request.MapRegionRequest;
import com.system.response.MapRegionResponse;
import org.Ike.Api.region.model.MapRegion;
import org.Ike.Api.region.service.MapRegionService;
import org.Ike.Core.region.mapper.MapRegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/7
 * Version    : 1.0
 * </pre>
 */
@Service
public class MapRegionServiceImpl implements MapRegionService{

    @Autowired(required = false)
    private MapRegionMapper mapRegionMapper;

    @Override
    public List<MapRegionResponse> getMapRegionByPage(MapRegionRequest request, Page page) {
        return mapRegionMapper.getMapRegionByPage(request,page);
    }

    @Override
    public void save(MapRegion mapRegion) {
        mapRegion.setCreateDate(new Date());
        mapRegionMapper.insert(mapRegion);
    }

    @Override
    public List<MapRegion> getMapRegionList(MapRegionRequest regionRequest) {
        return mapRegionMapper.getMapRegionList(regionRequest);
    }
}
