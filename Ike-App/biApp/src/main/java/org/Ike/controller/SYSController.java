package org.Ike.controller;

import com.system.exception.BusinessException;
import com.system.file.Excel;
import com.system.file.ImportExcelUtil;
import com.system.mybatis.Page;
import com.system.request.MapIconRequest;
import com.system.response.MapIconResponse;
import org.Ike.Api.icon.domain.MapIconDomain;
import org.Ike.Api.sys.domain.DictionaryDomain;
import org.Ike.Api.sys.model.AscResponse;
import org.Ike.Api.sys.model.DictionaryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private MapIconDomain mapIconDomain;

    /**
     * 根据父级code查询
     * <p>
     * 缓存?
     *
     * @param parentCode
     * @return
     */
    @RequestMapping(value = "/dictByParentCode.do", method = RequestMethod.POST)
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
    @RequestMapping(value = "/import.do")
    public AscResponse importData(MultipartHttpServletRequest request) {
        AscResponse result = new AscResponse();
        InputStream in = null;
        List<List<Object>> importList = null;
        try {
            MultipartFile file = request.getFile("upfile");
            if (file == null || file.isEmpty()) {
                throw new BusinessException("文件为空");
            }
            //todo  file size
            in = file.getInputStream();
            importList = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
            mapIconDomain.importMapIconByExcel(importList);
            result.setSuccess(true);
            result.setMessage("导入成功");
        } catch (BusinessException e) {
            logger.error(e.getMessage(), e);
            result.setMessage(e.getMessage());
/*        } catch (OfficeXmlFileException e) {
            logger.error("文件上传错误：" + e.getMessage(), e);
            result.setMessage("文件上传错误：这个Excel文件似乎是2007 + ，系统目前不支持！");*/
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
        Page page = mapIconDomain.getMapIconByPage(new MapIconRequest(), Page.getPage("1", "1000"));
        List<MapIconResponse> list = page.getRows();
        String[] heads = {"标物名称", "标物类型", "物业类型", "公寓类型"};
        String[] fileds = {"iconName", "iconStr", "realEstateStr", "apartmentStr"};
        excel.createHSSFSheet("--", heads, fileds, list);
        excel.writeWebExcel(request, response, "标物列表导出");
        return null;
    }

    /**
     * 下载模板
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/getTemplate.do")
    public String getTemplate(HttpServletRequest request) throws Exception {
        String path = null;
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath();
        path = url + "/file/test.xlsx";

        return path;
    }
}
