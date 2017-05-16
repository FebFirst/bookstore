package com.bookstore.controller;

import com.bookstore.model.Book;
import com.bookstore.model.Customer;
import com.bookstore.service.BookService;
import com.bookstore.service.CustomerService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by googo on 23/03/2017.
 */
@Controller
public class WebManager {
    @Autowired
    private BookService bookService;

    @Autowired
    private CustomerService customerService;


    /**
     * login page
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("Auth/login");
    }

    /**
     * Deprecated
     *
     * chat page, to test web socket service
     * @return
     */
    @RequestMapping("/chat")
    public ModelAndView chatPage(){
        return new ModelAndView("helloworld");
    }


    /**
     * sell page of the store
     * @return
     */
    @RequiresAuthentication
    @RequestMapping("/index/{language}")
    public ModelAndView indexPage(@PathVariable String language, HttpSession session){
        ModelAndView modelAndView = new ModelAndView("User/index");
        List<Book> books = bookService.getAllBooks();
        if(language.equals("zh_CN")){
            session.setAttribute("language","zh_CN");
            modelAndView.addObject("language","zh_CN");
        }else{
            session.setAttribute("language","en_US");
            modelAndView.addObject("language","en_US");
        }
        modelAndView.addObject("books", books);
        return modelAndView;
    }


    /**
     * Deprecated
     *
     * sell page of the store
     * @param session
     * @return
     */
    @RequiresAuthentication
    @RequestMapping("/home")
    public ModelAndView userHome(HttpSession session){
        if(session.getAttribute("user") == null)
            return new ModelAndView("redirect:/login");
        ModelAndView modelAndView = new ModelAndView("User/home");
        List<Book> books = bookService.getAllBooks();
        modelAndView.addObject("books", books);
        return modelAndView;
    }


    /**
     * book management page, admin access only
     * @return
     */
    @RequiresRoles(value = "admin")
    @RequestMapping("/book")
    public ModelAndView getAllBooks(){
        ModelAndView modelAndView = new ModelAndView("Admin/book");
        List<Book> books = bookService.getAllBooks();
        modelAndView.addObject("books", books);
        return modelAndView;
    }


    /**
     * customer management page, admin access only
     * @return
     */
    @RequiresRoles(value = "admin")
    @RequestMapping("/customer")
    public ModelAndView getAllCustomers(){
        ModelAndView modelAndView = new ModelAndView("Admin/customer");
        List<Customer> customers = customerService.getAllCustomers();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }


}
