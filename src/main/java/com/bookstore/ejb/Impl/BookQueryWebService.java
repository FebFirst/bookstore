package com.bookstore.ejb.Impl;

import com.bookstore.model.Book;
import com.bookstore.util.JDBCUtil;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.ResultSet;

/**
 * Created by googo on 16/05/2017.
 */
@Stateless
@WebService(name="bookQueryWebService")
@SOAPBinding
public class BookQueryWebService {
    @WebMethod(operationName = "book")
    public String getBookById(@WebParam(name="isbn")String id){
        try {
            Book book = new Book();
            String sql = "SELECT * FROM book WHERE isbn = '" + id + "'";
            ResultSet set = (ResultSet) JDBCUtil.getDB(sql);
            while (set.next()) {
                book.setAuthor(set.getString("author"));
                book.setCate(set.getInt("cate"));
                book.setIsbn(set.getString("isbn"));
                book.setName(set.getString("name"));
                book.setPrice(set.getDouble("price"));
            }
            return "nimahai";
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
