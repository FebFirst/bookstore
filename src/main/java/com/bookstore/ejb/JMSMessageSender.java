package com.bookstore.ejb;

import javax.ejb.Remote;

/**
 * Created by googo on 12/04/2017.
 */
@Remote
public interface JMSMessageSender {
    void sendMessage(String jsonOrder);

}
