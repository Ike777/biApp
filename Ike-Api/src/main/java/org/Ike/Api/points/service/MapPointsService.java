package org.Ike.Api.points.service;

import org.Ike.Api.points.model.MapPoints;

import java.util.List;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/7
 * Version    : 1.0
 * </pre>
 */
public interface MapPointsService {

    /**
     * 保存坐标点以及区域关联
     *
     * @param mapPoints
     * @param regionId
     */
    void savePointsRl(List<MapPoints> mapPoints, Integer regionId);
}
