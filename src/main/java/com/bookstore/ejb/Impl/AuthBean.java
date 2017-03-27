package com.bookstore.ejb.Impl;

import com.bookstore.ejb.Auth;
import com.bookstore.jaas.SimpleCallbackHandler;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.ejb.Stateless;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;


/**
 * Created by googo on 19/03/2017.
 */
@Stateless(name = "AuthEJB")
public class AuthBean implements Auth {
    /**
     * simple login module request by the teacher
     * @param email
     * @param code
     * @return
     */
    public boolean authLogin(String email, String code){
        System.setProperty("java.security.auth.login.config","/Users/googo/IdeaProjects/test-project/src/main/resources/jaas.config");
        try {
            LoginContext context = new LoginContext("SimpleLoginModule", new SimpleCallbackHandler(email, code.toCharArray()));
            context.login();
            return true;
        }catch (LoginException e){
            System.out.println("Login Error:" + e.getMessage());
            return false;
        }catch (SecurityException e){
            System.out.println("Login Security Error:" + e.getMessage());
            return false;
        }
    }


//    public boolean shiroAuthLogin(String email, String code) throws AuthenticationException{
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(email, code);
//        subject.login(token);
//    }
}
