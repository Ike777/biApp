package org.Ike.Core.icon.service;

import com.system.mybatis.Page;
import com.system.request.MapIconRequest;
import com.system.response.MapIconResponse;
import org.Ike.Api.icon.model.MapIcon;
import org.Ike.Api.icon.service.MapIconService;
import org.Ike.Core.icon.mapper.MapIconMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/7
 * Version    : 1.0
 * </pre>
 */
@Service
public class MapIconServiceImpl implements MapIconService {

    @Autowired(required = false)
    private MapIconMapper mapIconMapper;

    @Override
    public List<MapIconResponse> getMapIconByPage(MapIconRequest request, Page page) {
        return mapIconMapper.getMapIconByPage(request, page);
    }
}
