package org.Ike.controller.auth;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.JsonResponse;

@Controller
@RequestMapping ( "/auth")
public class AuthController {
	
	@RequestMapping("/login.do")  // 请求url地址映射，类似Struts的action-mapping
    public @ResponseBody JsonResponse  testLogin(@RequestParam(value="username",required=false)String username, String password, HttpServletRequest request) {
		JsonResponse res = new JsonResponse();
		res.setData("success");
        return res;
    }
	
	@RequestMapping("/demo.do") 
    public @ResponseBody Map<String, String> getMap() { 
        Map<String, String> map = new HashMap<String, String>(); 
        map.put("key1", "value-1"); 
        map.put("key2", "value-2"); 
        return map; 
    }

}
