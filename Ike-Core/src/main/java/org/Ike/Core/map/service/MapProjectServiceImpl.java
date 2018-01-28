package org.Ike.Core.map.service;

import com.system.mybatis.Page;
import com.system.request.MapProjectRequest;
import com.system.response.MapProjectResponse;
import org.Ike.Api.map.service.MapProjectService;
import org.Ike.Core.map.mapper.MapProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/28
 * Version    : 1.0
 * </pre>
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MapProjectServiceImpl implements MapProjectService {

    @Autowired(required = false)
    private MapProjectMapper mapProjectMapper;

    public List<MapProjectResponse> getMapProjectByPage(MapProjectRequest request, Page page) {
        return mapProjectMapper.getMapProjectByPage(request, page);
    }
}
