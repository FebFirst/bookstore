package com.bookstore.dao;

import com.bookstore.model.Customer;
import com.bookstore.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by googo on 19/03/2017.
 */
@Repository
public class CustomerDAO {
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
//    public List<Customer> getAllCustomers();

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
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Customer result;
        try
        {
            session.beginTransaction();
            Query query = session.createQuery("from Customer where phone=?");
            query.setInteger(0, phone);
            result = (Customer) query.uniqueResult();
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            if(session.getTransaction().wasCommitted())
            {
                session.getTransaction().rollback();
            }
            return null;
        }
        return result;
    }

    public Customer getCustomerByEmail(String email){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Customer result;
        try
        {
            session.beginTransaction();

            Query query = session.createQuery("from Customer where email=?");
            query.setString(0, email);
            result = (Customer) query.uniqueResult();
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            if(session.getTransaction().wasCommitted())
            {
                session.getTransaction().rollback();
            }
            return null;
        }
        return result;
//        return null;
    }

    public List<Customer> getCustomersByName(String name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Customer> result = new ArrayList<>();
        try
        {
            session.beginTransaction();
            Query query = session.createQuery("from Customer where name=?");
            query.setString(0, name);
            result = query.list();
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            if(session.getTransaction().wasCommitted())
            {
                session.getTransaction().rollback();
            }
            return null;
        }
        return result;
    }

    public List<Customer> getAllCustomers(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Customer> result = new ArrayList<>();
        try
        {
            session.beginTransaction();
            Query query = session.createQuery("from Customer");
            result = query.list();
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            if(session.getTransaction().wasCommitted())
            {
                session.getTransaction().rollback();
            }
            return null;
        }
        return result;
    }


}
