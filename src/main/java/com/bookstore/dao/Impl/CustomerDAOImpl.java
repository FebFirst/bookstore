package com.bookstore.dao.Impl;

import com.bookstore.dao.CustomerDAO;
import com.bookstore.model.Customer;
import com.bookstore.util.HibernateUtil;

import java.util.List;

/**
 * Created by googo on 19/03/2017.
 */
public class CustomerDAOImpl  {

    public boolean addCustomer(Customer customer){
        //todo
        return HibernateUtil.save(customer);
    }

    public boolean deleteCustomer(Customer customer){
        //todo
        return HibernateUtil.delete(customer);
    }

    public boolean updateCustomer(Customer customer){
        //todo
        return HibernateUtil.update(customer);
    }

    public Customer getCustomerByPhone(int phone){
        //todo
        return null;
    }

    public Customer getCustomerByEmail(String email){
        //todo
        return null;
    }

    public List<Customer> getCustomersByName(String name){
        //todo
        return null;
    }

    public List<Customer> getAllCustomers(){
        //todo
        return null;
    }
}
