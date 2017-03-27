package com.bookstore.ejb.Impl;

import com.bookstore.dao.BookDAO;
import com.bookstore.ejb.Cart;
import com.bookstore.model.Book;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by googo on 17/03/2017.
 */

@Stateful(name = "CartEJB")
public class CartBean implements Cart {


    private Map<String, Integer> items  = new HashMap<>();
    int customer_id;

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
            this.customer_id = customer_id;
            this.items = new HashMap<>();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addBook(String isbn){
        try {
            if(this.items == null){
                this.items = new HashMap<>();
                this.items.put(isbn, initNumber);
                System.out.println("NIMABI");
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

    @Override
    public Map<String, Integer> getBookAndNumber(){
        return items;
    }

    @Override
    @Remove
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
