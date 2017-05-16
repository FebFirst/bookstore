package com.bookstore.controller;

import com.bookstore.ejb.Cart;
import com.bookstore.ejb.JMSMessageSender;
import com.bookstore.model.Book;
import com.bookstore.model.Customer;
import com.bookstore.service.BookService;
import com.bookstore.service.RecordService;
import com.bookstore.util.BKError;
import com.bookstore.util.JSONFormatUtil;
import com.bookstore.util.ResInfo;
import net.sf.json.JSONObject;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ejb.EJB;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by googo on 25/03/2017.
 */
@Controller
public class BookController {
    @EJB(mappedName = "global/bookstore/CartEJB!com.bookstore.ejb.Cart")
    Cart cart;

    @EJB(mappedName = "global/bookstore/JMSMessageSender!com.bookstore.ejb.JMSMessageSender")
    JMSMessageSender sender;

    @Autowired
    BookService bookService;

    @Autowired
    RecordService recordService;

    /**controller of cart*/

    /**
     * add book to cart
     * @param isbn
     * @param session
     * @return
     */
    @RequiresAuthentication
    @RequestMapping(value = "/cart/add/{isbn}", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> addBookToCart(@PathVariable String isbn, HttpSession session){
        Map<String, String> res = new HashMap<>();
        try {
            if(bookService.getBookByISBN(isbn) == null){
                res.put(ResInfo.InfoCode(), BKError.info(BKError.EMPTY));
                return res;
            }
            cart.addBook(isbn);
            res.put(ResInfo.InfoCode(), BKError.info(BKError.OK));
            return res;
        }catch (Exception e){
            e.printStackTrace();
            res.clear();
            res.put(ResInfo.InfoCode(), BKError.info(BKError.INVALID));
            return res;
        }
    }


    /**
     * get items in shopping cart
     * @param session
     * @return
     */
    @RequiresAuthentication
    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Integer> getCart(HttpSession session){
        Map<String, Integer> res = new HashMap<>();
        try {
//            if (session.getAttribute("user") == null) {
//                res.put("msg", -1);
//                return res;
//            }
            res = bookService.getNameAndNumber(cart.getBookAndNumber());
            return res;
        }catch (Exception e){
            e.printStackTrace();
            res.clear();
            res.put(ResInfo.InfoCode(), -1);
            return res;
        }
    }

    /**
     * clear shopping cart
     * @param session
     * @return
     */
    @RequiresAuthentication
    @RequestMapping(value = "/cart/checkout", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> checkoutCart(HttpSession session){
        Map<String, String> res = new HashMap<>();
        try {
//            if (session.getAttribute("user") == null) {
//                res.put("msg", "NOT LOGIN!");
//                return res;
//            }
            cart.checkout(1);
            res.put(ResInfo.InfoCode(), BKError.info(BKError.OK));
            return res;
        }catch (Exception e){
            e.printStackTrace();
            res.clear();
            res.put(ResInfo.InfoCode(), BKError.info(BKError.UNKNOWN));
            return res;
        }
    }

    /**
     * pay books in the shopping cart
     * @param session
     * @return
     */
    @RequiresAuthentication
    @RequestMapping(value = "/cart/pay", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> payCart(HttpSession session){
        Map<String, String> res = new HashMap<>();
        try {
//            if (session.getAttribute("user") == null) {
//                res.put("msg", "NOT LOGIN!");
//                return res;
//            }
            Customer customer = (Customer) session.getAttribute("user");
            String orderMessage = JSONFormatUtil.orderFormat(cart.getBookAndNumber(), customer.getId());
            sender.sendMessage(orderMessage);
            cart.checkout(1);
            res.put(ResInfo.InfoCode(), BKError.info(BKError.OK));
            return res;
        }catch (Exception e){
            e.printStackTrace();
            res.clear();
            res.put(ResInfo.InfoCode(), BKError.info(BKError.UNKNOWN));
            return res;
        }
    }

//    @RequiresRoles(value ="admin")
//    @RequestMapping(value = "/cart/pay/{discount}", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, String> payCartWithDiscount(@PathVariable double discount, HttpSession session){
//        Map<String, String> res = new HashMap<>();
//        try{
////            Subject subject = SecurityUtils.getSubject();
////            String email = subject.
//            Customer customer = (Customer) session.getAttribute("user");
//
//            recordService.addRecord(cart.getBookAndNumber(), customer.getId());
//            cart.checkout(1);
//            res.put("msg", "SUCCESS");
//            return res;
//        }catch (Exception e){
//            e.printStackTrace();
//            res.clear();
//            res.put("msg","NO DISCOUNT PERMISSION");
//            return res;
//        }
//    }

    /**book service*/

    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> addBook(@RequestBody Book book){
        Map<String, String> res = new HashMap<>();
        try{
            bookService.addBook(book);
            res.put(ResInfo.InfoCode(), BKError.info(BKError.OK));
            //sender.sendMessage("You Touch My Heart Baby!");
            return res;
        }catch (Exception e){
            e.printStackTrace();
            res.clear();
            res.put(ResInfo.InfoCode(), BKError.info(BKError.UNKNOWN));
            return res;
        }
    }

    /**
     * delete book, admin access only
     * @param book
     * @return
     */
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/book/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> deleteBook(@RequestBody Book book){
        Map<String, String> res = new HashMap<>();
        try{
            bookService.deleteBook(book);
            res.put(ResInfo.InfoCode(), BKError.info(BKError.OK));
            return res;
        }catch (Exception e){
            e.printStackTrace();
            res.clear();
            res.put(ResInfo.InfoCode(), BKError.info(BKError.UNKNOWN));
            return res;
        }
    }


    /**
     * update book's info, admin access only
     * @param book
     * @return
     */
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/book/update", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> updateBook(@RequestBody Book book){
        Map<String, String> res = new HashMap<>();
        try{
            bookService.updateBook(book);
            res.put(ResInfo.InfoCode(), BKError.info(BKError.OK));
            return res;
        }catch (Exception e){
            e.printStackTrace();
            res.clear();
            res.put(ResInfo.InfoCode(), BKError.info(BKError.UNKNOWN));
            return res;
        }
    }


    /**
     * get all books
     * @return
     */
    @RequiresAuthentication
    @RequestMapping(value = "/book/all", method = RequestMethod.POST)
    @ResponseBody
    public Object getAllBooks(){
        try{
            return bookService.getAllBooks();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequiresAuthentication
    @RequestMapping(value = "/book/detail/{isbn}", method = RequestMethod.POST)
    @ResponseBody
    public Object bookDetail(@PathVariable String isbn){
        Map<String, String> res = new HashMap<>();
        try{
            Book book = bookService.getBookByISBN(isbn);
            return book;
        }catch (Exception e){
            e.printStackTrace();
            res.clear();
            res.put(ResInfo.InfoCode(), BKError.info(BKError.UNKNOWN));
            return res;
        }
    }

}
