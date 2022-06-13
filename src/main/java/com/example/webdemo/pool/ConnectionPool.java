package com.example.webdemo.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private static ConnectionPool instance;
    private final int CAPACITY=8;
    private BlockingQueue<Connection> free = new LinkedBlockingQueue<>(CAPACITY);
    private BlockingQueue<Connection> used = new LinkedBlockingQueue<>(CAPACITY);

//    static {
//        try{
//            DriverManager.registerDriver(new org.postgresql.Driver());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    private ConnectionPool(){
        try{
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String url = "jdbc:postgresql://localhost:5432/web1";
        String user = "postgres";
        String pass = "1404";
        for(int i=0;i<CAPACITY;i++){
            Connection connection=null;
            try {
                connection = DriverManager.getConnection(url,user,pass);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            free.add(connection);
        }
    }
    public static ConnectionPool getInstance() {
        instance = new ConnectionPool();
        return instance;
    }
    public Connection getConnection(){
        Connection connection=null;
        try {
            connection = free.take();
            used.put(connection);
        } catch (InterruptedException e) {
            //log
            Thread.currentThread().interrupt();
        }
        return connection;
    }

    //deregisterDrive

    public void releaseConnection(Connection connection){
        try {
            used.remove(connection);
            free.put(connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void destroyPool(){
        for(int i=0;i<CAPACITY;i++){
            try {
                free.take().close();
            } catch (SQLException | InterruptedException e) {
                  ///log e.printStackTrace()
            }
        }
    }
}
