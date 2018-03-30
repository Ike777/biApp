package org.Ike.controller.auth;

import com.system.exception.BusinessException;
import org.Ike.Api.sys.model.AscResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @RequestMapping("/login.do")
    @ResponseBody
    public AscResponse login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        AscResponse result = new AscResponse();
        result.setSuccess(false);
        Subject subject = SecurityUtils.getSubject();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            result.setSuccess(true);
            result.setMessage("登录成功");
        } catch (AuthenticationException ex) {
            if (ex.getCause() instanceof BusinessException) {
                result.setMessage(ex.getCause().getMessage());
            }
        } catch (Exception ex1) {
            logger.error(ex1.getMessage(), ex1);
            result.setMessage("服务器错误，请稍候再试");
        }
        return result;
    }

}
