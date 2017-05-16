package com.bookstore.webSocket;

import com.bookstore.model.Customer;
import com.bookstore.webSocket.decoders.MessageDecoder;
import com.bookstore.webSocket.encoders.ChatMessageEncoder;
import com.bookstore.webSocket.encoders.InfoMessageEncoder;
import com.bookstore.webSocket.encoders.JoinMessageEncoder;
import com.bookstore.webSocket.encoders.UsersMessageEncoder;
import com.bookstore.webSocket.httpSessionConfigurator.GetHttpSessionConfigurator;
import com.bookstore.webSocket.messages.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by googo on 05/04/2017.
 */

@ServerEndpoint(value = "/message",
                decoders = {MessageDecoder.class},
                encoders = {JoinMessageEncoder.class, ChatMessageEncoder.class,
                        InfoMessageEncoder.class, UsersMessageEncoder.class},
                configurator=GetHttpSessionConfigurator.class)
public class DontCry {
    private static final Logger logger = Logger.getLogger("Read Your Heart");
    private HttpSession httpSession;
    /* Bot functionality bean */
//    //@Inject
//    private BotStockBean botstockbean = new BotStockBean();
//    /* Executor service for asynchronous processing */
//    @Resource(name="tomcatThreadPool")
//    private ManagedExecutorService mes;

    @RequiresAuthentication
    @OnOpen
    public void openConnection(Session session, EndpointConfig config) {
        logger.log(Level.INFO, "Connection opened.");
        httpSession = (HttpSession)config.getUserProperties().get(HttpSession.class.getName());
    }

    @RequiresAuthentication
    @OnMessage
    public void message(final Session session, Message msg) {
        logger.log(Level.INFO, "Received: {0}", msg.toString());

        if (msg instanceof JoinMessage) {
            /* Add the new user and notify everybody */
            JoinMessage jmsg = (JoinMessage) msg;

            Customer customer = (Customer)httpSession.getAttribute("user");
            session.getUserProperties().put("name", customer.getName());
            //session.getUserProperties().put("name", jmsg.getName());

            session.getUserProperties().put("active", true);
           // logger.log(Level.INFO, "Received: {0}", jmsg.toString());
            sendAll(session, new InfoMessage(customer.getName() + " has joined the chat"));
            sendAll(session, new ChatMessage("Read Your Heart", customer.getName(), "Hi there!!"));
            sendAll(session, new UsersMessage(this.getUserList(session)));

        } else if (msg instanceof ChatMessage) {
            /* Forward the message to everybody */
            final ChatMessage cmsg = (ChatMessage) msg;
            Customer customer = (Customer)httpSession.getAttribute("user");
            cmsg.setName(customer.getName());
            logger.log(Level.INFO, "Received: {0}", cmsg.toString());
            sendAll(session, cmsg);
//            if (cmsg.getTarget().compareTo("Duke") == 0) {
//                /* The bot replies to the message */
//            	System.out.println("this is Duke'msg");
//                mes.submit(new Runnable() {
//                    public void run() {
//                        String resp = "Duke";//botstockbean.respond(cmsg.getMessage());
//                        sendAll(session, new ChatMessage("Duke", cmsg.getName(), resp));
//                    }
//                });
//            }
        }
    }

    @OnClose
    public void closedConnection(Session session) {
        /* Notify everybody */
        session.getUserProperties().put("active", false);
        if (session.getUserProperties().containsKey("name")) {
            String name = session.getUserProperties().get("name").toString();
            sendAll(session, new InfoMessage(name + " has left the chat"));
            sendAll(session, new UsersMessage(this.getUserList(session)));
        }
        logger.log(Level.INFO, "Connection closed.");
    }

    @OnError
    public void error(Session session, Throwable t) {
        logger.log(Level.INFO, "Connection error ({0})", t.toString());
    }

    /* Forward a message to all connected clients
     * The endpoint figures what encoder to use based on the message type */
    public synchronized void sendAll(Session session, Object msg) {
        try {
            for (Session s : session.getOpenSessions()) {
                if (s.isOpen()) {
                    s.getBasicRemote().sendObject(msg);
                    logger.log(Level.INFO, "Sent: {0}", msg.toString());
                }
            }
        } catch (IOException | EncodeException e) {
            logger.log(Level.INFO, e.toString());
        }
    }

    /* Returns the list of users from the properties of all open sessions */
    public List<String> getUserList(Session session) {
        List<String> users = new ArrayList<>();
        //users.add("Duke");
        for (Session s : session.getOpenSessions()) {
            if (s.isOpen() && (boolean) s.getUserProperties().get("active"))
                users.add(s.getUserProperties().get("name").toString());
        }
        return users;
    }

}
