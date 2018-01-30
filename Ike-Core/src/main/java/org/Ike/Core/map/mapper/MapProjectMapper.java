package org.Ike.Core.map.mapper;

import com.system.mybatis.Page;
import com.system.request.MapProjectRequest;
import com.system.response.MapProjectResponse;
import org.Ike.Api.map.model.MapProject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MapProjectMapper {
    int insert(MapProject record);

    int insertSelective(MapProject record);

    MapProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MapProject record);

    int updateByPrimaryKey(MapProject record);

    List<MapProjectResponse> getMapProjectByPage(MapProjectRequest request, Page page);

    void createMapProject(MapProject project);

    List<MapProject> getMapProjectByName(@Param("projectName") String projectName);
}