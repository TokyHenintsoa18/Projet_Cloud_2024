package com.example.cloud_project.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    public Connection getConnex() {
        String url = "jdbc:postgresql://viaduct.proxy.rlwy.net:44152/railway";
        String username = "postgres";
        String password = "Fb-4eD33fCgcdc-BFbE2FB44BF461*cG";
        Connection conn = null;

        try {    
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load PostgreSQL JDBC driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
	        return conn;
}
}
