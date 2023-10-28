package com.example.databasesDemo.Controllers;

import org.springframework.context.annotation.ComponentScan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static String connectionUrl = "jdbc:mysql://localhost:3306/employee_db?enabledTLSProtocols=TLSv1.2";

    public static Connection getDbConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(connectionUrl , "root" , "");
        return connection;
    }
}