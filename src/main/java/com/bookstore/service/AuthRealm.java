package com.bookstore.service;

import com.bookstore.dao.CustomerDAO;
import com.bookstore.model.Customer;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by googo on 26/03/2017.
 *
 * Reference: classmate fyy;  http://www.tuicool.com/articles/AFFBre
 */
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collections){
        String email = (String)collections.getPrimaryPrincipal();
        Customer customer = customerDAO.getCustomerByEmail(email);
        String role = customer.getRole();
        Set<String> permissions = new HashSet<>();
        if(role.equals("admin")){
            permissions.add("cart:book:customer:*");
        }else if(role.equals("customer")){
            permissions.add("cart:pay, add, view, checkout");
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole(role);
        info.addStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)throws AuthenticationException{
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
        String email = usernamePasswordToken.getUsername();
        Customer customer = customerDAO.getCustomerByEmail(email);
        if(customer == null){
            throw new UnknownAccountException();
        }
//        if(Boolean.TRUE.equals(Customer.getLocked())) {
//            throw new LockedAccountException(); //帐号锁定
//        }
        SimpleAuthenticationInfo info= new SimpleAuthenticationInfo(customer.getEmail(), customer.getCode(), getName());
        return info;
    }
}
