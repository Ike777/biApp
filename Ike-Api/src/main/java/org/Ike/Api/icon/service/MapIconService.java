package org.Ike.Api.icon.service;

import com.system.mybatis.Page;
import com.system.request.MapIconRequest;
import com.system.response.MapIconResponse;

import java.util.List;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/7
 * Version    : 1.0
 * </pre>
 */
public interface MapIconService {

    /**
     * 分页查询
     *
     * @param request
     * @param page
     * @return
     */
    List<MapIconResponse> getMapIconByPage(MapIconRequest request, Page page);
}
