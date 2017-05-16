package com.bookstore.ejb.Impl;

//import com.bookstore.ejb.JMSMessageSender;

import com.bookstore.ejb.JMSMessageSender;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;

/**
 * Created by googo on 12/04/2017.
 */

@Stateless(name = "JMSMessageSender")
public class JMSMessageSenderImpl implements JMSMessageSender{
    //@Resource(mappedName = "java:jboss/exported/jms/RemoteConnectionFactory")
    //@Resource(mappedName = "java:/ConnectionFactory")

    @Resource(mappedName = "java:jboss/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;

    private Connection connection;

    private Session session;

    @Resource(mappedName = "java:/jboss/exported/jms/queue/bkQueue")
    private Queue queue;

    private MessageProducer producer = null;
    @Override
    public void sendMessage(String jsonOrder){
        try {
            connection = connectionFactory.createConnection("jetlag","make1ove");
            connection.start();
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(queue);
            TextMessage message = session.createTextMessage(jsonOrder);
            producer.send(message);
//            System.out.println(jsonOrder);
        }catch (JMSException e){
//            System.out.println("cainima");
            e.printStackTrace();
        }
    }



}
