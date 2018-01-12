package org.Ike.Core.points.mapper;


import org.Ike.Api.points.model.MapRegionPointRl;

public interface MapRegionPointRlMapper {
    int insert(MapRegionPointRl record);

    int insertSelective(MapRegionPointRl record);

    MapRegionPointRl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MapRegionPointRl record);

    int updateByPrimaryKey(MapRegionPointRl record);
}