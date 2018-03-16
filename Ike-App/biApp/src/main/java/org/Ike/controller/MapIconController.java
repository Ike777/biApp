package org.Ike.controller;

import com.system.mybatis.Page;
import com.system.request.MapIconRequest;
import org.Ike.Api.icon.domain.MapIconDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <pre> 地图标物
 * Author: taixiaomin
 * Created at : 2018/1/7
 * Version    : 1.0
 * </pre>
 */
@Controller
@RequestMapping(value = "/icon")
public class MapIconController {

    @Autowired
    private MapIconDomain mapIconDomain;

    @RequestMapping(value = "/list.do", method = RequestMethod.POST)
    @ResponseBody
    public Page getMapIconByPage(@RequestBody MapIconRequest request) {
        return mapIconDomain.getMapIconByPage(request, Page.getPage(request.getPageNumber(), request.getPageSize()));
    }

}
