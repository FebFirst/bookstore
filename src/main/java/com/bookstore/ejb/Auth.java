package com.bookstore.ejb;

import javax.ejb.Local;

/**
 * Created by googo on 19/03/2017.
 */
@Local
public interface Auth {

    boolean authLogin(String name, String code);

    //boolean authCustomerLogin(String name, String code);
}
