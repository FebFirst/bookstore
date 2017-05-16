package com.bookstore.util;

import com.bookstore.model.Book;
import net.sf.json.JSONObject;

import java.util.Map;

/**
 * Created by googo on 16/04/2017.
 */
public class JSONFormatUtil {
    public static String orderFormat(Map<String, Integer> order, Integer customerId){
        JSONObject object = new JSONObject();
        object.put("customer",customerId);
        object.put("order",order);
        return object.toString();
    }

    public static Book bookFormat(String bookTmp){
        Book book = new Book();
        if(bookTmp != null) {
            JSONObject object = JSONObject.fromObject(bookTmp);
            book.setIsbn((String)object.get("isbn"));
            book.setName((String)object.get("name"));
            book.setAuthor((String)object.get("author"));
            book.setCate((Integer)object.get("cate"));
            book.setPrice((Double)object.get("price"));
            return book;
        }
        return null;
    }
}
