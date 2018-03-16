package org.Ike.controller;

import com.system.exception.BusinessException;
import com.system.file.Excel;
import com.system.file.ExcelImport;
import org.Ike.Api.sys.domain.DictionaryDomain;
import org.Ike.Api.sys.model.AscResponse;
import org.Ike.Api.sys.model.DictionaryDto;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
 * Created at : 2018/3/14
 * Version    : 1.0
 * </pre>
 */
@RestController
@RequestMapping("/sys")
public class SYSController {

    private static final Logger logger = LoggerFactory.getLogger(SYSController.class);

    @Autowired
    private DictionaryDomain dictionaryDomain;

    /**
     * 根据父级code查询
     * <p>
     * 缓存?
     *
     * @param parentCode
     * @return
     */
    @RequestMapping(value = "/dictByParentCode.do", method = RequestMethod.POST)
    @ResponseBody
    public AscResponse<List<DictionaryDto>> getDictByParentCode(String parentCode) {
        AscResponse<List<DictionaryDto>> response = new AscResponse<>();
        List<DictionaryDto> dict = dictionaryDomain.getDictByParentCode(parentCode);
        response.setSuccess(true);
        response.setT(dict);
        return response;
    }


    /**
     * 上传文件至数据库
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/import.do")
    public AscResponse importData(MultipartHttpServletRequest request) {
        AscResponse result = new AscResponse();
        try {
            Map<String, MultipartFile> fileMap = request.getFileMap();

            for (MultipartFile mf : fileMap.values()) {
                ExcelImport ex = new ExcelImport(mf.getInputStream());

            }
            result.setSuccess(true);
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


    /**
     * excel列表导出
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/export.do")
    public String export(HttpServletRequest request, HttpServletResponse response) {
        Excel excel = new Excel();
        String[] fileds = {"---", "-----"};
        String[] heads = {"", ""};
        excel.createHSSFSheet(null, heads, fileds, new ArrayList<>());
        excel.writeWebExcel(request, response, "导出");
        return null;
    }




}
