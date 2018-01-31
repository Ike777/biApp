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


    @RequestMapping(value = "/export.do")
    public String export(HttpServletRequest request, HttpServletResponse response) {
        Excel excel = new Excel();
        // list
        String[] fileds = {"---", "-----"};
        String[] heads = {"", ""};
        excel.createHSSFSheet(null, heads, fileds, new ArrayList<>());
        excel.writeWebExcel(request, response, "导出");
        return null;
    }


    @ResponseBody
    @RequestMapping(value = "/import.do")
    public AscResponse importData(MultipartHttpServletRequest request) {
        AscResponse result = new AscResponse();
        try {
            Map<String, MultipartFile> fileMap = request.getFileMap();

            for (MultipartFile mf : fileMap.values()) {
                ExcelImport re = new ExcelImport(mf.getInputStream());
                //...do somethings
                result.setSuccess(true);
            }
        } catch (BusinessException e) {
            logger.error(e.getMessage(), e);
            result.setMessage(e.getMessage());
        } catch (OfficeXmlFileException e) {
            logger.error("文件上传错误：" + e.getMessage(), e);
            result.setMessage("文件上传错误：这个Excel文件似乎是2007 + ，系统目前不支持！");
        } catch (Exception e) {
            logger.error("文件上传错误：" + e.getMessage(), e);
            result.setMessage("文件格式不正确，请下载模版参考格式！");
        }
        return result;
    }


}
