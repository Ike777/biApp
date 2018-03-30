package org.Ike.controller.security;

import com.system.exception.BusinessException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/3/29
 * Version    : 1.0
 * </pre>
 */
public class SampleRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(SampleRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SecurityContext context = (SecurityContext) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        try {
            // do somethings
            info.addStringPermissions(context.getRole());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        String password = String.valueOf(token.getPassword());
        SecurityContext context = new SecurityContext();
        try{
            if ("18888888888".equals(userName) && "123456".equals(password)) {
                context.setUserName(userName);
                context.setPassWord(password);
            } else {
                throw new BusinessException("用户名/密码错误");
            }
        }catch (Exception e){
            throw new AuthenticationException(e.getMessage(),e);
        }
        return new SimpleAuthenticationInfo(context, password, getName());
    }
}
