package org.Ike.controller;

import com.system.JsonResponse;
import com.system.exception.BusinessException;
import com.system.file.Excel;
import com.system.file.ExcelImport;
import com.system.mybatis.Page;
import org.Ike.Api.sys.model.AscResponse;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
