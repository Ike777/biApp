package org.Ike.Core.icon.domain;

import com.system.mybatis.Page;
import com.system.request.MapIconRequest;
import com.system.response.MapIconResponse;
import org.Ike.Api.icon.domain.MapIconDomain;
import org.Ike.Api.icon.model.MapIcon;
import org.Ike.Api.icon.service.MapIconService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/7
 * Version    : 1.0
 * </pre>
 */
@Component
public class MapIconDomainImpl implements MapIconDomain {

    private static final Logger logger = LoggerFactory.getLogger(MapIconDomainImpl.class);

    @Autowired
    private MapIconService mapIconService;

    @Override
    public Page getMapIconByPage(MapIconRequest request, Page page) {
        List<MapIconResponse> list = null;
        try {
            list = mapIconService.getMapIconByPage(request,page);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return page.setRows(list);
    }
}
