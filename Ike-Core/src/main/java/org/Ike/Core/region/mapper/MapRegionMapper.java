package org.Ike.Core.region.mapper;

import com.system.mybatis.Page;
import com.system.request.MapRegionRequest;
import com.system.response.MapRegionResponse;
import org.Ike.Api.region.model.MapRegion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MapRegionMapper {
    int insert(MapRegion record);

    int insertSelective(MapRegion record);

    MapRegion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MapRegion record);

    int updateByPrimaryKey(MapRegion record);

    List<MapRegionResponse> getMapRegionByPage(@Param("model") MapRegionRequest request, @Param("page") Page page);

    List<MapRegion> getMapRegionList(@Param("model") MapRegionRequest regionRequest);
}