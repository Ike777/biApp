package org.Ike.controller;

import com.system.exception.BusinessException;
import com.system.mybatis.Page;
import com.system.request.MapRegionRequest;
import org.Ike.Api.region.domain.MapRegionDomain;
import org.Ike.Api.region.model.RegionPointsVo;
import org.Ike.Api.sys.model.AscResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <pre> 区域
 * Author: taixiaomin
 * Created at : 2018/1/7
 * Version    : 1.0
 * </pre>
 */
@Controller
@RequestMapping(value = "/region")
public class MapRegionController {

    @Autowired
    private MapRegionDomain mapRegionDomain;

    @RequestMapping(value = "/list.do")
    @ResponseBody
    public Page getMapRegionByPage(@RequestBody MapRegionRequest request) {
        return mapRegionDomain.getMapRegionByPage(request, Page.getPage(request.getPageNumber(), request.getPageSize()));
    }

    @RequestMapping(value = "/createRegion.do")
    @ResponseBody
    public AscResponse<RegionPointsVo> createRegion(@RequestBody RegionPointsVo regionPointsVo) {
        AscResponse<RegionPointsVo> response = new AscResponse<>("", 2);
        try {
            mapRegionDomain.createRegion(regionPointsVo);
            response.setSuccess(1);
            response.setMessage("保存成功");
        } catch (BusinessException e) {
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setMessage("服务异常");
        }
        return response;
    }
}
