package org.Ike.Api.map.service;

import com.system.exception.BusinessException;
import com.system.mybatis.Page;
import com.system.request.MapProjectRequest;
import com.system.response.MapProjectResponse;
import org.Ike.Api.map.model.MapProject;

import java.util.List;


/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/28
 * Version    : 1.0
 * </pre>
 */
public interface MapProjectService {
    /**
     * 分页查询
     *
     * @param request
     * @param page
     * @return
     */
    List<MapProjectResponse> getMapProjectByPage(MapProjectRequest request, Page page);

    /**
     * 保存
     *
     * @param project
     */
    void createMapProject(MapProject project) throws BusinessException;

    /**
     * 根据项目名称查询
     *
     * @param projectName
     * @return
     */
    List<MapProject> getMapProjectByName(String projectName);
}
