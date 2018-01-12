package org.Ike.Core.points.mapper;

import org.Ike.Api.points.model.MapPoints;


public interface MapPointsMapper {
    int insert(MapPoints record);

    int insertSelective(MapPoints record);

    MapPoints selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MapPoints record);

    int updateByPrimaryKey(MapPoints record);

}