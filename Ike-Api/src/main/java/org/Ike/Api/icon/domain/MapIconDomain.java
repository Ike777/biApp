package org.Ike.Api.icon.domain;

import com.system.mybatis.Page;
import com.system.request.MapIconRequest;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/7
 * Version    : 1.0
 * </pre>
 */
public interface MapIconDomain {

    /**
     * 分页查询
     *
     * @param request
     * @param page
     * @return
     */
    Page getMapIconByPage(MapIconRequest request, Page page);
}
