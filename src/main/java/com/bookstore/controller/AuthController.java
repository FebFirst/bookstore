package com.bookstore.controller;

import com.bookstore.ejb.Auth;
import com.bookstore.model.Customer;
import com.bookstore.service.CustomerService;
import com.bookstore.util.BKError;
import com.bookstore.util.ResInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.ejb.EJB;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by googo on 21/03/2017.
 */
@Controller
public class AuthController {
    //@Autowired
    @EJB(mappedName = "global/bookstore/AuthEJB!com.bookstore.ejb.Auth")
    private Auth auth;

    @Autowired
    private CustomerService customerService;

    /**
     * login controller, now we completed authentication by shiro
     * Uncomment the code to use simple login module
     * @param customer
     * @param session
     * @return
     */
    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> login(@RequestBody Customer customer, HttpSession session){
        Map<String, String> res = new HashMap<>();
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(customer.getEmail(), customer.getCode());
            subject.login(token);
            customer = customerService.getCustomerByEmail(customer.getEmail());
            session.setAttribute("user", customer);
            res.put(ResInfo.InfoCode(), BKError.info(BKError.OK));
            return res;
            /**Uncomment to use simple login module*/
//            if (auth.authLogin(customer.getEmail(), customer.getCode())) {
//                customer = customerService.getCustomerByEmail(customer.getEmail());
//                //List<Customer> customers = customerService.getCustomersByName("jetlag");
//                session.setAttribute("user", customer);
//                res.put("msg","success");
//                return res;
//            } else {
//                res.put("msg","fail");
//                return res;
//            }
        }catch (Exception e){
            e.printStackTrace();
            res.put(ResInfo.InfoCode(),BKError.info(BKError.INVALID));
            return res;
        }
    }

    /**
     * log out
     * @param customer
     * @return
     */
    @RequiresAuthentication
    @RequestMapping(value = "/auth/logout", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> logout(@RequestBody Customer customer){
        Map<String, String> res = new HashMap<>();
        try {
            Subject subject = SecurityUtils.getSubject();
            //UsernamePasswordToken token = new UsernamePasswordToken(customer.getEmail(), customer.getCode());
            subject.logout();
            res.put(ResInfo.InfoCode(),BKError.info(BKError.OK));
            return res;
        }catch (Exception e){
            e.printStackTrace();
            res.put(ResInfo.InfoCode(), BKError.info(BKError.UNKNOWN));
            return res;
        }
    }
}
