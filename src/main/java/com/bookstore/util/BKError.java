package com.bookstore.util;

/**
 * Created by googo on 27/03/2017.
 */
public enum BKError {
    OK,
    UNAUTH,
    DENIED,
    UNKNOWN,
    INVALID,

    /**cart part*/
    EMPTY,
    ;
    public static String info(BKError error){
        if(error == OK) return "OK";
        else if(error == UNAUTH) return "NOT AUTHORIZED";
        else if(error == DENIED) return "ACCESS DENIED";
        else if(error == UNKNOWN) return "UNKNOWN ERROR";
        else if(error == EMPTY) return "EMPTY CART";
        else return "INVALID";

    }


}
