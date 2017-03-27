package com.bookstore.jaas;


import java.security.Principal;
import java.util.Objects;

/**
 * Created by googo on 21/03/2017.
 */
public class SimplePrincipal implements Principal{
    private String descr;
    private String value;

    public SimplePrincipal(String descr, String value){
        this.descr = descr;
        this.value = value;
    }


    public String getName(){
        return descr + "=" + value;
    }

    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(object == null){
            return false;
        }
        if(this.getClass() != object.getClass()){
            return false;
        }

        SimplePrincipal principal = (SimplePrincipal)object;
        return Objects.equals(this.getName(), principal.getName());
    }

    public int hashcode(){
        return Objects.hashCode(this.getName());
    }
}
