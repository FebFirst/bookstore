package com.bookstore.jaas;


import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;

/**
 * Created by googo on 21/03/2017.
 */
public class SimpleCallbackHandler implements CallbackHandler{
    private String name;
    private char[] code;

    public SimpleCallbackHandler(String name, char[] code){
        this.name = name;
        this.code = code;
    }

    public void handle(Callback[] callbacks){
        for(Callback callback: callbacks){
            if(callback instanceof NameCallback){
                ((NameCallback)callback).setName(name);
            }else if(callback instanceof PasswordCallback){
                ((PasswordCallback)callback).setPassword(code);
            }
        }
    }
}
