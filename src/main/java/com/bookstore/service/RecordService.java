package com.bookstore.service;

import com.bookstore.dao.RecordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by googo on 25/03/2017.
 */
@Service
@Transactional
public class RecordService {
    @Autowired
    RecordDAO recordDAO;

    public boolean addRecord(Map<String, Integer> books, int customer){
        return recordDAO.addRecord(books, customer);
    }
}
