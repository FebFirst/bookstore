package com.bookstore.jaas;

import com.bookstore.dao.CustomerDAO;
import com.bookstore.model.Customer;

import javax.annotation.Resource;
import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.security.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by googo on 21/03/2017.
 */
public class SimpleLoginModule implements LoginModule{
    private Subject subject;
    private CallbackHandler callbackHandler;
    private Map<String, ?> sharedState;
    private Map<String, ?> options;

   // private AdminDAO adminDAO;
    @Resource
    private CustomerDAO customerDAO;

    private String getCustomer(String email, String code) throws Exception{
        String url = "jdbc:mysql://localhost:3306/bookstore";
        String user = "root";
        String password = "root";
        String sql = "SELECT * FROM customer WHERE email = '" + email + "' and code = '" + code + "'";
        Connection connection = DriverManager.getConnection(url, user, password);
        java.sql.Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery(sql);
        String role = "NULL";
        while (set.next()){
            role = set.getString("role");
        }
        return role;
    }

    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options){
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        this.sharedState = sharedState;
        this.options = options;
    }
    public boolean login() throws LoginException {
        if (callbackHandler == null)
            throw new LoginException("no handler");
        NameCallback nameCall = new NameCallback("username: ");
        PasswordCallback passCall = new PasswordCallback("password: ", false);
        try {
            callbackHandler.handle(new Callback[]{nameCall, passCall});
        } catch (UnsupportedCallbackException e) {
            LoginException e2 = new LoginException("Unsupported callback");
            e2.initCause(e);
            throw e2;
        } catch (IOException e) {
            LoginException e2 = new LoginException("I/O exception in callback");
            e2.initCause(e);
            throw e2;
        }

        return checkLogin(nameCall.getName(), String.valueOf(passCall.getPassword()));
    }



    private boolean checkLogin(String email, String password) throws LoginException {
        try {
            String role = getCustomer(email, password);
            //Customer customer = customerDAO.getCustomerByEmail(email);
            if(!role.equals("NULL")){

                Set<Principal> principals = subject.getPrincipals();
                principals.add(new SimplePrincipal("username", email));
                principals.add(new SimplePrincipal("role", role));
                return true;
            }

            return false;
        }catch (Exception e) {
            LoginException e2 = new LoginException("NO SUCH USER OR INVALID PASSWORD!");
            e2.initCause(e);
            throw e2;
        }
    }

    public boolean logout() { return true; }
    public boolean abort() { return true; }
    public boolean commit() { return true; }
}
