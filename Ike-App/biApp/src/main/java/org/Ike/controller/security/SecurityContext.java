package org.Ike.controller.security;

import java.util.HashSet;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/3/29
 * Version    : 1.0
 * </pre>
 */
public class SecurityContext {


    private String userName;

    private String passWord;

    private HashSet<String> role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public HashSet<String> getRole() {
        return role;
    }

    public void setRole(HashSet<String> role) {
        this.role = role;
    }
}
