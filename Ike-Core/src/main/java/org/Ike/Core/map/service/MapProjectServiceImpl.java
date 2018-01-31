package org.Ike.Core.map.service;

import com.system.exception.BusinessException;
import com.system.mybatis.Page;
import com.system.request.MapProjectRequest;
import com.system.response.MapProjectResponse;
import org.Ike.Api.map.model.MapProject;
import org.Ike.Api.map.service.MapProjectService;
import org.Ike.Core.map.mapper.MapProjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/28
 * Version    : 1.0
 * </pre>
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MapProjectServiceImpl implements MapProjectService {

    private static final Logger logger = LoggerFactory.getLogger(MapProjectServiceImpl.class);

    @Autowired(required = false)
    private MapProjectMapper mapProjectMapper;

    public List<MapProjectResponse> getMapProjectByPage(MapProjectRequest request, Page page) {
        return mapProjectMapper.getMapProjectByPage(request, page);
    }

    @Override
    public void createMapProject(MapProject project) throws BusinessException {
        try {
            mapProjectMapper.createMapProject(project);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException("保存失败");
        }
    }

    @Override
    public List<MapProject> getMapProjectByName(String projectName) {
        return mapProjectMapper.getMapProjectByName(projectName);
    }
}
