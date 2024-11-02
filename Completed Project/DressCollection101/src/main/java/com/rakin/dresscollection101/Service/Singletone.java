package com.rakin.dresscollection101.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singletone {
    private static final String host = "localhost";
    private static final String user = "root";
    private static final String pass = "EIAda@32";
    private static final String DB_Name = "dresscollection";
    private static final String url = "jdbc:mysql://" + host + "/" + DB_Name;
    private static Connection connection;
    private static Singletone singletone = new Singletone();
    public static Connection getConnection() {
        return connection;
    }

    private Singletone( ) {
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
