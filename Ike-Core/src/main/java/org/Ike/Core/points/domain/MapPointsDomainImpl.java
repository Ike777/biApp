package org.Ike.Core.points.domain;

import org.Ike.Api.points.domain.MapPointsDomain;
import org.Ike.Api.points.service.MapPointsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/7
 * Version    : 1.0
 * </pre>
 */
@Component
public class MapPointsDomainImpl implements MapPointsDomain{

    private static final Logger logger = LoggerFactory.getLogger(MapPointsDomainImpl.class);

    @Autowired
    private MapPointsService mapPointsService;

}
