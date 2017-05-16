package com.bookstore.util.MySqlDaoUtil;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import javax.sql.DataSource;
import java.util.logging.Logger;

/**
 * Created by googo on 09/05/2017.
 */
public class MasterDaoSupport extends JdbcDaoSupport{
    protected Logger logger = Logger.getLogger("datasourceM logger");

    @Qualifier("sessionFactoryM")
    SessionFactory sessionFactory;

    protected HibernateDaoSupport support;

    @Autowired
    public void initJDBC(@Qualifier("dataSourceM")DataSource dataSource){
        super.setDataSource(dataSource);
    }

    @Autowired
    public void initHibernate(@Qualifier("sessionFactoryM") SessionFactory sessionFactory){
        support = new HibernateDaoSupport() {
        };
        support.setSessionFactory(sessionFactory);
    }

    public HibernateTemplate getHibernateTemplate(){
        return support.getHibernateTemplate();
    }
}
