package com.bookstore.service;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.RecordDAO;
import com.bookstore.model.Book;
import com.bookstore.util.JSONFormatUtil;
import com.bookstore.util.RedisUtil;
import com.bookstore.util.SerializationUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
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

    @Autowired
    private RecordDAO recordDAO;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean addBook(Book book){
        RedisUtil.jedisSet(book.getIsbn(), book);
        return bookDAO.addBook(book);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean deleteBook(Book book){
        RedisUtil.jedisDelete(book.getIsbn());
        recordDAO.deleteRecord(book.getIsbn());
        return bookDAO.deleteBook(book);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean updateBook(Book book){
        RedisUtil.jedisDelete(book.getIsbn());
        return bookDAO.updateBook(book);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Book> getAllBooks(){
        List<Book> books = bookDAO.getAllBooks();
        for(Book book : books){
            RedisUtil.jedisSet(book.getIsbn(), JSONObject.fromObject(book).toString());
        }
        return books;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Book getBookByISBN(String isbn){
        String bookTmp = (String)RedisUtil.jedisGet(isbn);
        Book book = new Book();
        if(bookTmp != null) {
            return JSONFormatUtil.bookFormat(bookTmp);
        }
        book = bookDAO.getBookByISBN(isbn);
        if(book != null) RedisUtil.jedisSet(book.getIsbn(), book);
        return book;
    }


    /**
     * convert Map<BOOK_ISBN, BOOK_NUMBER> to Map<BOOK_NAME, BOOK_NUMBER>
     * @param items
     * @return
     */
    public Map<String, Integer> getNameAndNumber(Map<String, Integer> items){
        Map<String, Integer> res = new HashMap<>();
        for(Map.Entry<String, Integer> item: items.entrySet()){
            Book book = bookDAO.getBookByISBN(item.getKey());
            res.put(book.getName(), item.getValue());
        }

        return res;
    }
}
