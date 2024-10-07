package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;
    public  static  void  connect()
    {
        try {
            connection= DriverManager.getConnection("jdbc:sqlite:C:\\Users\\popso\\OneDrive\\Pulpit\\progrmowanie\\java sem2\\lab14\\baza");
            System.out.println("connected");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public  static  void  disconnect()
    {
        try {
            connection.close();
            System.out.println("disconnected");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        DatabaseConnection.connection = connection;
    }
}
