package com.bookstore.ejb.Impl;

import com.bookstore.model.Book;
import com.bookstore.util.JDBCUtil;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.ResultSet;

/**
 * Created by googo on 16/05/2017.
 */
@Stateless
@Path("ws")
public class BookQueryRSWebService {
    @GET
    @Path("/book/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBookById(@PathParam(value = "id")String id){
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
            return book;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
