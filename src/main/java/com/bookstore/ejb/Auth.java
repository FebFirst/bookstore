package com.bookstore.ejb;

import javax.ejb.Local;

/**
 * Created by googo on 19/03/2017.
 */
@Local
public interface Auth {

    /**
     * Deprecated
     *
     * jaas login module
     * @param name
     * @param code
     * @return
     */
    boolean authLogin(String name, String code);

    //boolean authCustomerLogin(String name, String code);
}
