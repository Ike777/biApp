package org.Ike.Core.map.mapper;

import org.Ike.Api.map.model.MapProject;

public interface MapProjectMapper {
    int insert(MapProject record);

    int insertSelective(MapProject record);

    MapProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MapProject record);

    int updateByPrimaryKey(MapProject record);
}