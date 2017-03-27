package com.bookstore.ejb;

import com.bookstore.model.Book;

import javax.ejb.Remote;
import java.net.Inet4Address;
import java.util.List;
import java.util.Map;

/**
 * Created by googo on 19/03/2017.
 */

@Remote
public interface Cart {
    /**
     * initialize the cart with user's id
     * @param customer
     * @return
     */
    boolean initialize(int customer);

    /**
     * add a new book into cart,
     * if this book already exists, increase its number
     * @param isbn
     * @return
     */
    boolean addBook(String isbn);

//    /**
//     * get all books in the cart
//     * @return
//     */
//    List<Book> getBookInCart();


    /**
     * get books and each book's number
     * @return
     */
    Map<String, Integer> getBookAndNumber();
    /**
     * checkout the cart with a signal
     * A Signal class will be added later
     * @return
     */
    boolean checkout(int signal);
}
