package com.bookstore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Created by googo on 16/04/2017.
 */
public class JDBCUtil {
    public static Object getDB(String sql){
        try {
            String url = "jdbc:mysql://localhost:3306/bookstore";
            String user = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, user, password);
            java.sql.Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(sql);
            return set;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
