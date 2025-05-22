package com.example.magazine;


import java.sql.*;

public class dbconnect {
    private final String url="jdbc:mysql://localhost:3306/magazin";
    private final String username="root";
    private final String password=null;
    private Connection conn=null;
    public dbconnect()throws ClassNotFoundException{
            Class.forName("com.mysql.cj.jdbc.Driver");
    }
    public void connect()throws SQLException {
        conn= DriverManager.getConnection(url,username,password);
    }

    public Connection getConn() {
        return conn;
    }
}
