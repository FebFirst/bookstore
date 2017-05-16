package com.bookstore.ejb.Impl;

import com.bookstore.ejb.Cart;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.ejb.Stateful;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by googo on 17/03/2017.
 */

@Stateful(name = "CartEJB")
public class CartBean implements Cart {

   // @Resource(mappedName = "")
   // private BookService bookService;
    private Map<String, Integer> items  = new HashMap<>();
    int customer_id;

    /**
     * default book number to add
     */
    private static final int initNumber = 1;

    /**
     * Constructor
     */
//    public CartBean(){
//        this.items = new HashMap<>();
//    }

    @Override
    public boolean initialize(int customer_id){
        try{
           // bookService.getAllBooks();
            this.customer_id = customer_id;
            this.items = new HashMap<>();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * add books to this stateful bean
     * @param isbn
     * @return
     */
    @Override
    public boolean addBook(String isbn){
        try {
           // bookService.getAllBooks();
            if(this.items == null){
                this.items = new HashMap<>();
                this.items.put(isbn, initNumber);
            }
            else if (!this.items.containsKey(isbn)) {
                this.items.put(isbn, initNumber);
            } else {
                int number = this.items.get(isbn) + 1;
                this.items.put(isbn, number);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

//    @Override
//    public List<Book> getBookInCart(){
//        try {
//            List<Book> books = new ArrayList<>();
//            for(Map.Entry<String, Integer> item: this.items.entrySet()){
//                Book book = bookDAO.getBookByISBN(item.getKey());
//                books.add(book);
//            }
//
//            return books;
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }

    /**
     * get info of this bean
     * @return
     */
    @Override
    public Map<String, Integer> getBookAndNumber(){
        return items;
    }

    /**
     * clean the information in this bean
     * @param signal
     * @return
     */
    @Override
    //@Remove
    public boolean checkout(int signal){
        try{
            if(items != null)
                items = null;
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
