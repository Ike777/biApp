package org.Ike.controller;

import com.system.exception.BusinessException;
import com.system.mybatis.Page;
import com.system.request.MapProjectRequest;
import org.Ike.Api.map.domain.MapProjectDomain;
import org.Ike.Api.region.model.RegionPointsVo;
import org.Ike.Api.sys.model.AscResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/28
 * Version    : 1.0
 * </pre>
 */
@Controller
@RequestMapping(value = "map")
public class MapProjectController {

    @Autowired
    private MapProjectDomain mapProjectDomain;

    @RequestMapping(value = "/list.do", method = RequestMethod.POST)
    @ResponseBody
    public Page getMapProjectByPage(@RequestBody MapProjectRequest request) {
        return mapProjectDomain.getMapProjectByPage(request, Page.getPage(request.getPageNumber(), request.getPageSize()));
    }


    @RequestMapping(value = "/createMapProject.do", method = RequestMethod.POST)
    @ResponseBody
    public AscResponse createMapProject(@RequestBody MapProjectRequest request) {
        AscResponse response = new AscResponse("保存失败", false);
        try {
            mapProjectDomain.createMapProject(request);
            response.setSuccess(true);
            response.setMessage("保存成功");
        } catch (BusinessException e) {
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setMessage("服务异常");
        }
        return response;
    }

}
