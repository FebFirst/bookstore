package com.bookstore.service;

import com.bookstore.dao.CustomerDAO;
import com.bookstore.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public boolean addCustomer(Customer customer){
        return customerDAO.addCustomer(customer);
    }

    public boolean deleteCustomer(Customer customer){
        return customerDAO.deleteCustomer(customer);
    }

    public boolean updateCustomer(Customer customer){
        return customerDAO.updateCustomer(customer);
    }

    public Customer getCustomerByEmail(String email){
        return customerDAO.getCustomerByEmail(email);
    }

    public Customer getCustomerByPhone(int phone){
        return customerDAO.getCustomerByPhone(phone);
    }

    public List<Customer> getCustomersByName(String name){
        return customerDAO.getCustomersByName(name);
    }

    public List<Customer> getAllCustomers(){
        return customerDAO.getAllCustomers();
    }
}
