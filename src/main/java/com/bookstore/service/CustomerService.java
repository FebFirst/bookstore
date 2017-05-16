package com.bookstore.service;

import com.bookstore.dao.CustomerDAO;
import com.bookstore.dao.RecordDAO;
import com.bookstore.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by googo on 25/03/2017.
 */
@Service
@Transactional
public class CustomerService {
//    boolean addCustomer(Customer customer);
//
//    boolean deleteCustomer(Customer customer);
//
//    boolean updateCustomer(Customer customer);
//
//    Customer getCustomerByEmail(String email);
//
//    Customer getCustomerByPhone(int phone);
//
//    List<Customer> getCustomersByName(String name);
//
//    List<Customer> getAllCustomers();
    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private RecordDAO recordDAO;


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean addCustomer(Customer customer){
        return customerDAO.addCustomer(customer);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean deleteCustomer(Customer customer){
        //recordDAO.deleteRecord(customer.getId());
        return customerDAO.deleteCustomer(customer);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean updateCustomer(Customer customer){
        return customerDAO.updateCustomer(customer);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Customer getCustomerByEmail(String email){
        return customerDAO.getCustomerByEmail(email);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Customer getCustomerByPhone(int phone){
        return customerDAO.getCustomerByPhone(phone);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Customer> getCustomersByName(String name){
        return customerDAO.getCustomersByName(name);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Customer> getAllCustomers(){
        return customerDAO.getAllCustomers();
    }
}
