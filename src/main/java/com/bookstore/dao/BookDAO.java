package com.bookstore.dao;

import com.bookstore.model.Book;
import com.bookstore.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by googo on 19/03/2017.
 */
@Repository
public class BookDAO {
//    boolean addBook(Book book);
//
//    boolean deleteBook(Book book);
//
//    boolean updateBook(Book book);
//
//    Book getBookByISBN(String ISBN);
//
//    List<Book> getAllBooks();

    public boolean addBook(Book book){
        //todo
        return HibernateUtil.save(book);
    }

    public boolean deleteBook(Book book){
        //todo
        return HibernateUtil.delete(book);
    }

    public  boolean updateBook(Book book){
        //todo
        return HibernateUtil.update(book);
    }

    public Book getBookByISBN(String isbn){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Book result;
        try
        {
            session.beginTransaction();
            Query query = session.createQuery("from Book where isbn=?");
            query.setString(0, isbn);
            result = (Book) query.uniqueResult();
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

    public List<Book> getAllBooks(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Book> result;
        try
        {
            session.beginTransaction();
            Query query = session.createQuery("from Book");
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
