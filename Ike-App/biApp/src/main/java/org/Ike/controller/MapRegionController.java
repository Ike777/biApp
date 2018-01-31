package org.Ike.controller;

import com.system.exception.BusinessException;
import com.system.mybatis.Page;
import com.system.request.MapRegionRequest;
import org.Ike.Api.region.domain.MapRegionDomain;
import org.Ike.Api.region.model.RegionDict;
import org.Ike.Api.region.model.RegionPointsVo;
import org.Ike.Api.sys.model.AscResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping(value = "/list.do", method = RequestMethod.POST)
    @ResponseBody
    public Page getMapRegionByPage(@RequestBody MapRegionRequest request) {
        return mapRegionDomain.getMapRegionByPage(request, Page.getPage(request.getPageNumber(), request.getPageSize()));
    }

    @RequestMapping(value = "/createRegion.do", method = RequestMethod.POST)
    @ResponseBody
    public AscResponse<RegionPointsVo> createRegion(@RequestBody RegionPointsVo regionPointsVo) {
        AscResponse<RegionPointsVo> response = new AscResponse<>("", false);
        try {
            mapRegionDomain.createRegion(regionPointsVo);
            response.setSuccess(true);
            response.setMessage("保存成功");
        } catch (BusinessException e) {
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setMessage("服务异常,请稍后再试.");
        }
        return response;
    }

    @RequestMapping(value = "/regions.do", method = RequestMethod.POST)
    @ResponseBody
    public AscResponse<List<RegionDict>> getRegionList() {
        AscResponse<List<RegionDict>> response = new AscResponse<>("", false);
        try {
            List<RegionDict> regionDict = mapRegionDomain.getRegionDictList();
            response.setSuccess(true);
            response.setT(regionDict);
            response.setMessage("查询成功");
        } catch (BusinessException e) {
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setMessage("服务异常");
        }
        return response;
    }
}
