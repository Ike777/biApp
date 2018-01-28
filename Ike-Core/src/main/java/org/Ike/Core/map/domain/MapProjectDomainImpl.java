package org.Ike.Core.map.domain;

import com.system.mybatis.Page;
import com.system.request.MapProjectRequest;
import com.system.response.MapProjectResponse;
import org.Ike.Api.map.domain.MapProjectDomain;
import org.Ike.Api.map.service.MapProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/28
 * Version    : 1.0
 * </pre>
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class MapProjectDomainImpl implements MapProjectDomain{

    private static final Logger logger = LoggerFactory.getLogger(MapProjectDomainImpl.class);

    @Autowired
    private MapProjectService mapProjectService;


    public Page getMapProjectByPage(MapProjectRequest request, Page page) {
        List<MapProjectResponse> list = null;
        try {
            list = mapProjectService.getMapProjectByPage(request, page);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return page.setRows(list);
    }
}
