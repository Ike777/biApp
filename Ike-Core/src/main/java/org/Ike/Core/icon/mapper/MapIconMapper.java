package org.Ike.Core.icon.mapper;

import com.system.mybatis.Page;
import com.system.request.MapIconRequest;
import com.system.response.MapIconResponse;
import org.Ike.Api.icon.model.MapIcon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MapIconMapper {
    int insert(MapIcon record);

    int insertSelective(MapIcon record);

    MapIcon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MapIcon record);

    int updateByPrimaryKey(MapIcon record);

    List<MapIconResponse> getMapIconByPage(@Param("model") MapIconRequest request, @Param("page") Page page);
}