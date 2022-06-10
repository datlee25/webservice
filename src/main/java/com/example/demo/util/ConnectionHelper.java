package com.example.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    public static final String CONNECT_STRING = "jdbc:mysql://localhost/t2008m-webservice";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public static Connection connection;
    public static Connection getConnection(){
        try{
            if (connection == null || connection.isClosed()){
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(CONNECT_STRING, USERNAME, PASSWORD);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
