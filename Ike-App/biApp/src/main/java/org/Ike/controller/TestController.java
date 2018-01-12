package org.Ike.controller;

import com.system.JsonResponse;
import com.system.exception.BusinessException;
import com.system.mybatis.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/4
 * Version    : 1.0
 * </pre>
 */
@Controller
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/c.do")
    @ResponseBody
    public JsonResponse test() {
        JsonResponse res = new JsonResponse();
        try {
            res = null;
        } catch (BusinessException e) {
            //.
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return res;
    }


    @RequestMapping(value = "/p.do")
    @ResponseBody
    public Page getXxxByPage(@RequestBody String json) {
        try {
            //return testDomain.getXxxByPage(request, Page.getPage(request.getPageNumber(), request.getPageSize()));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
