package org.Ike.Core.region.domain;

import com.system.exception.BusinessException;
import com.system.mybatis.Page;
import com.system.request.MapRegionRequest;
import com.system.response.MapRegionResponse;
import com.system.uuid.UUidUtils;
import org.Ike.Api.points.model.MapPoints;
import org.Ike.Api.points.service.MapPointsService;
import org.Ike.Api.region.domain.MapRegionDomain;
import org.Ike.Api.region.model.MapRegion;
import org.Ike.Api.region.model.RegionPointsVo;
import org.Ike.Api.region.service.MapRegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/7
 * Version    : 1.0
 * </pre>
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class MapRegionDomainImpl implements MapRegionDomain {

    private static final Logger logger = LoggerFactory.getLogger(MapRegionDomainImpl.class);

    @Autowired
    private MapRegionService mapRegionService;

    @Autowired
    private MapPointsService mapPointsService;

    public Page getMapRegionByPage(MapRegionRequest request, Page page) {
        List<MapRegionResponse> list = null;
        try {
            list = mapRegionService.getMapRegionByPage(request, page);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return page.setRows(list);
    }

    public void createRegion(RegionPointsVo regionPointsVo) {

        MapRegion mapRegion = regionPointsVo.getMapRegion();

/*        if (StringUtils.isEmpty(mapRegion.getRegionName())) {
            throw new BusinessException("请完善表单信息");
        }*/
        String code = UUidUtils.generateOrderNo("WX");
        mapRegion.setRegionCode(code);
        mapRegion.setPopulationSt("XX");//待定
        mapRegion.setSysCreateDate(new Date());
        mapRegion.setVersion(0);
        mapRegion.setDisabled(0);
        mapRegionService.save(mapRegion);

        if (mapRegion.getId() == null) {
            throw new BusinessException("error");
        }

        List<MapPoints> mapPoints = regionPointsVo.getMapPoints();
        mapPointsService.savePointsRl(mapPoints, mapRegion.getId());

    }
}
