package com.bookstore.dao;

import com.bookstore.model.Book;
import com.bookstore.model.Record;
import com.bookstore.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.ejb.EJB;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by googo on 19/03/2017.
 */
@Repository
public class RecordDAO {
    //todo
    public boolean addRecord(Map<String, Integer> books, int customer){
        try{
            for(Map.Entry<String, Integer> item: books.entrySet()){
                Record record = new Record();
                record.setBook_id(item.getKey());
                record.setCustomer_id(customer);
                record.setNumber(item.getValue());
                record.setTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                HibernateUtil.save(record);
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
