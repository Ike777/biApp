package org.Ike.Api.map.domain;

import com.system.mybatis.Page;
import com.system.request.MapProjectRequest;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/28
 * Version    : 1.0
 * </pre>
 */
public interface MapProjectDomain {
    /**
     * 分页查询
     *
     * @param request
     * @param page
     * @return
     */
    Page getMapProjectByPage(MapProjectRequest request, Page page);

    /**
     * 保存
     *
     * @param request
     */
    void createMapProject(MapProjectRequest request) throws Exception;
}
