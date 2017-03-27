package com.bookstore.service;

import com.bookstore.dao.BookDAO;
import com.bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by googo on 26/03/2017.
 */
@Service
@Transactional
public class BookService {
    @Autowired
    private BookDAO bookDAO;

    public boolean addBook(Book book){
        return bookDAO.addBook(book);
    }

    public boolean deleteBook(Book book){
        return bookDAO.deleteBook(book);
    }

    public boolean updateBook(Book book){
        return bookDAO.updateBook(book);
    }

    public List<Book> getAllBooks(){
        return bookDAO.getAllBooks();
    }

    public Book getBookByISBN(String isbn){
        return bookDAO.getBookByISBN(isbn);
    }

    public Map<String, Integer> getNameAndNumber(Map<String, Integer> items){
        Map<String, Integer> res = new HashMap<>();
        for(Map.Entry<String, Integer> item: items.entrySet()){
            Book book = bookDAO.getBookByISBN(item.getKey());
            res.put(book.getName(), item.getValue());
        }

        return res;
    }
}
