package org.Ike.Core.points.service;

import com.sun.org.apache.regexp.internal.RE;
import com.system.mybatis.Page;
import com.system.request.MapPointsRequest;
import com.system.response.MapPointsResponse;
import org.Ike.Api.points.model.MapPoints;
import org.Ike.Api.points.model.MapRegionPointRl;
import org.Ike.Api.points.service.MapPointsService;
import org.Ike.Core.points.mapper.MapPointsMapper;
import org.Ike.Core.points.mapper.MapRegionPointRlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
@Transactional(rollbackFor = Exception.class)
public class MapPointsServiceImpl implements MapPointsService {

    @Autowired(required = false)
    private MapPointsMapper mapPointsMapper;

    @Autowired(required = false)
    private MapRegionPointRlMapper regionPointRlMapper;

    @Override
    public void savePointsRl(List<MapPoints> mapPoints, Integer regionId) {
        if (!CollectionUtils.isEmpty(mapPoints)) {
            for (MapPoints point : mapPoints) {
                point.setDisabled(0);
                point.setSysCreateDate(new Date());
                point.setVersion(0);
                mapPointsMapper.insert(point);
                MapRegionPointRl regionPointRl = new MapRegionPointRl();
                regionPointRl.setRegionId(regionId);
                regionPointRl.setPointId(point.getId());
                regionPointRlMapper.insert(regionPointRl);
            }
        }
    }
}
