package org.Ike.Core.icon.domain;

import com.system.exception.BusinessException;
import com.system.mybatis.Page;
import com.system.request.MapIconRequest;
import com.system.response.MapIconResponse;
import org.Ike.Api.icon.domain.MapIconDomain;
import org.Ike.Api.icon.model.MapIcon;
import org.Ike.Api.icon.service.MapIconService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/7
 * Version    : 1.0
 * </pre>
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class MapIconDomainImpl implements MapIconDomain {

    private static final Logger logger = LoggerFactory.getLogger(MapIconDomainImpl.class);

    @Autowired
    private MapIconService mapIconService;

    public Page getMapIconByPage(MapIconRequest request, Page page) {
        List<MapIconResponse> list = null;
        try {
            list = mapIconService.getMapIconByPage(request, page);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return page.setRows(list);
    }

    public void importMapIconByExcel(List<List<Object>> importList) throws Exception {
        if (CollectionUtils.isEmpty(importList)) {
            throw new BusinessException("Excel内容为空");
        }

        for (List<Object> objectList : importList) {
            if (objectList.size() != 4) {
                throw new BusinessException("请严格按照模板格式导入Excel");
            }

            MapIcon mapIcon = new MapIcon();
            mapIcon.setIconName(objectList.get(0).toString());
            mapIcon.setIconSt(objectList.get(1).toString());
            mapIcon.setRealEstateSt(objectList.get(2).toString());
            mapIcon.setApartmentSt(objectList.get(3).toString());
            mapIcon.setCreateDate(new Date());
            mapIconService.saveMapIcon(mapIcon);
        }

    }
}
