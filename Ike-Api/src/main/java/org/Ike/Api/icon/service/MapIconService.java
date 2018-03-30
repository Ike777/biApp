package org.Ike.Api.icon.service;

import com.system.exception.BusinessException;
import com.system.mybatis.Page;
import com.system.request.MapIconRequest;
import com.system.response.MapIconResponse;
import org.Ike.Api.icon.model.MapIcon;

import java.io.BufferedInputStream;
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

    /**
     * 保存
     *
     * @param mapIcon
     * @throws BusinessException
     */
    void saveMapIcon(MapIcon mapIcon) throws BusinessException;
}
