package com.bookstore.dao.Impl;

import com.bookstore.dao.AdminDAO;
import com.bookstore.model.Admin;
import com.bookstore.util.HibernateUtil;

/**
 * Created by googo on 19/03/2017.
 */
public class AdminDAOImpl{
    public boolean addAdmin(Admin admin){
        //todo
        return HibernateUtil.save(admin);
    }

    public boolean deleteAdmin(Admin admin){
        //todo
        return HibernateUtil.delete(admin);
    }

    public boolean updateAdmin(Admin admin){
        //todo
        return HibernateUtil.update(admin);
    }

    public Admin getAdminById(int id){
        //todo
        return null;
    }

    public Admin getAdminByName(String name){
        //todo
        return null;
    }
}
