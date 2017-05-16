package com.bookstore.ejb.Impl;

import com.bookstore.model.Record;
import com.bookstore.util.HibernateUtil;
import net.sf.json.JSONObject;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by googo on 13/04/2017.
 */
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/bkQueue")

})
public class JMSMessageReceiverImpl implements MessageListener{

    static final Logger logger = Logger.getLogger("JMS");

    @Override
    public void onMessage(Message message){
        try {
            if (message instanceof TextMessage) {
                String msg = message.getBody(String.class);
                JSONObject object = JSONObject.fromObject(msg);
                int customerId = (Integer)object.get("customer");
                Map<String, Integer> orders = (Map<String, Integer>)object.get("order");
                for(Map.Entry<String, Integer> item: orders.entrySet()){
                    Record record = new Record();
                    record.setBook_id(item.getKey());
                    record.setCustomer_id(customerId);
                    record.setNumber(item.getValue());
                    record.setTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                    HibernateUtil.save(record);
                }
                logger.log(Level.INFO, msg);
            }else{
                logger.log(Level.INFO, "ERROR IN JMS MESSAGE");
            }
        }catch (JMSException e){
            e.printStackTrace();
        }
    }
}
