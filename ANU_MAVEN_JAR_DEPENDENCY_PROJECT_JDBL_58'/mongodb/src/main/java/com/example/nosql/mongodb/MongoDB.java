package com.example.nosql.mongodb;

import com.example.db.globaldb.connection.DbConnection;

public class MongoDB extends DbConnection {
    @Override
    public void connectToDB(String connectionUrl) {
        System.out.println("Connected");
    }
}
