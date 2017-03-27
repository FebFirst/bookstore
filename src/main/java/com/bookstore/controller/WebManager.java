package com.bookstore.controller;

import com.bookstore.model.Book;
import com.bookstore.model.Customer;
import com.bookstore.service.BookService;
import com.bookstore.service.CustomerService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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


    @RequestMapping("/login")
    public ModelAndView login(){
        System.out.println("CAO NI MA");
        return new ModelAndView("Auth/login");
    }


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

    @RequiresRoles(value = "admin")
    @RequestMapping("/book")
    public ModelAndView getAllBooks(){
        ModelAndView modelAndView = new ModelAndView("Book/display");
        List<Book> books = bookService.getAllBooks();
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @RequiresRoles(value = "admin")
    @RequestMapping("/customer")
    public ModelAndView getAllCustomers(){
        ModelAndView modelAndView = new ModelAndView("Customer/display");
        List<Customer> customers = customerService.getAllCustomers();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

}
