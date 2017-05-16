package com.bookstore.util;

import com.bookstore.util.MySqlDaoUtil.MasterDaoSupport;
import com.bookstore.util.MySqlDaoUtil.SlaveDaoSupport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by googo on 19/03/2017.
 */
public class HibernateUtil {
//    private static MasterDaoSupport masterDaoSupport = new MasterDaoSupport();
//    private static SlaveDaoSupport slaveDaoSupport = new SlaveDaoSupport();
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        try {
            return new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex){
            System.err.println("Initial SessionFactory Creation Failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

//    public static SessionFactory getMasterSessionFactory(){return masterDaoSupport.getHibernateTemplate().getSessionFactory();}
//    public static SessionFactory getSlaveSessionFactory(){return slaveDaoSupport.getHibernateTemplate().getSessionFactory();}
    public static boolean save(Object object){
        Session session = sessionFactory.getCurrentSession();
//        Session session = getMasterSessionFactory().getCurrentSession();
        try
        {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            if(!session.getTransaction().wasCommitted()) {
                session.getTransaction().rollback();
            }
            return false;
        }
        return true;
    }

    public static boolean delete(Object object){
        Session session = sessionFactory.getCurrentSession();
//        Session session = getMasterSessionFactory().getCurrentSession();
        try{
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
        }catch (Exception e)
        {
            if(!session.getTransaction().wasCommitted()) {
                session.getTransaction().rollback();
            }
            return false;
        }
        return true;
    }

    public static boolean update(Object object){
        Session session = sessionFactory.getCurrentSession();
//        Session session = getMasterSessionFactory().getCurrentSession();
        try{
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        }catch (Exception e)
        {
            if(!session.getTransaction().wasCommitted()) {
                session.getTransaction().rollback();
            }
            return false;
        }
        return true;
    }
}
