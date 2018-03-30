package org.Ike.Core.icon.service;

import com.system.exception.BusinessException;
import com.system.mybatis.Page;
import com.system.request.MapIconRequest;
import com.system.response.MapIconResponse;
import org.Ike.Api.icon.model.MapIcon;
import org.Ike.Api.icon.service.MapIconService;
import org.Ike.Core.icon.mapper.MapIconMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/7
 * Version    : 1.0
 * </pre>
 */
@Service
public class MapIconServiceImpl implements MapIconService {

    private static final Logger logger = LoggerFactory.getLogger(MapIconServiceImpl.class);

    @Autowired(required = false)
    private MapIconMapper mapIconMapper;

    public List<MapIconResponse> getMapIconByPage(MapIconRequest request, Page page) {
        return mapIconMapper.getMapIconByPage(request, page);
    }

    public void saveMapIcon(MapIcon mapIcon) throws BusinessException {
        try {
            mapIcon.setSysCreateDate(new Date());
            mapIcon.setDisabled(0);
            mapIcon.setVersion(1);
            mapIconMapper.insertSelective(mapIcon);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException("error", "error");
        }
    }
}
