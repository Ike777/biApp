package org.Ike.Core.map.domain;

import com.system.exception.BusinessException;
import com.system.mybatis.Page;
import com.system.request.MapProjectRequest;
import com.system.response.MapProjectResponse;
import org.Ike.Api.map.domain.MapProjectDomain;
import org.Ike.Api.map.model.MapProject;
import org.Ike.Api.map.service.MapProjectService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/28
 * Version    : 1.0
 * </pre>
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class MapProjectDomainImpl implements MapProjectDomain {

    private static final Logger logger = LoggerFactory.getLogger(MapProjectDomainImpl.class);

    @Autowired
    private MapProjectService mapProjectService;


    public Page getMapProjectByPage(MapProjectRequest request, Page page) {
        List<MapProjectResponse> list = null;
        try {
            list = mapProjectService.getMapProjectByPage(request, page);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return page.setRows(list);
    }

    @Override
    public void createMapProject(MapProjectRequest request) throws Exception {
        if (StringUtils.isEmpty(request.getProjectName())) {
            throw new BusinessException("param can not be empty");
        }
        List<MapProject> list = mapProjectService.getMapProjectByName(request.getProjectName());
        if (!CollectionUtils.isEmpty(list)) {
            throw new BusinessException("该项目名称已经存在");
        }
        MapProject project = new MapProject();
        BeanUtils.copyProperties(request, project);
        mapProjectService.createMapProject(project);
    }

}
