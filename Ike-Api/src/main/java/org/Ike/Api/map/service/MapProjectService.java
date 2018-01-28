package org.Ike.Api.map.service;

import com.system.mybatis.Page;
import com.system.request.MapProjectRequest;
import com.system.response.MapProjectResponse;

import java.util.List;


/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/28
 * Version    : 1.0
 * </pre>
 */
public interface MapProjectService {
    /**
     * 分页查询
     *
     * @param request
     * @param page
     * @return
     */
    List<MapProjectResponse> getMapProjectByPage(MapProjectRequest request, Page page);
}
