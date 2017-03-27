package com.bookstore.dao.Impl;

import com.bookstore.dao.BookDAO;
import com.bookstore.model.Book;
import com.bookstore.util.HibernateUtil;

import java.util.List;

/**
 * Created by googo on 19/03/2017.
 */
public class BookDAOImpl{
    public boolean addBook(Book book){
        //todo
        return HibernateUtil.save(book);
    }

    public boolean deleteBook(Book book){
        //todo
        return HibernateUtil.delete(book);
    }

    public  boolean updateBook(Book book){
        //todo
        return HibernateUtil.update(book);
    }

    public Book getBookByISBN(String isbn){
        //todo
        return null;
    }

    public List<Book> getAllBooks(){
        //todo
        return null;
    }
}
