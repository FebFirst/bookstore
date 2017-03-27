package com.bookstore.dao;

import com.bookstore.model.Admin;
import com.bookstore.util.HibernateUtil;
import org.springframework.stereotype.Repository;

/**
 * Created by googo on 19/03/2017.
 */
@Repository
public class AdminDAO {
//    boolean addAdmin(Admin admin);
//
//    boolean deleteAdmin(Admin admin);
//
//    boolean updateAdmin(Admin admin);
//
//    Admin getAdminById(int id);
//
//    Admin getAdminByName(String name);

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
