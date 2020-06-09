package com.luv2code.testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDB {
    public static void main(String[] args) throws SQLException {
        String user = "springstudent";
        String pass = "springstudent";

        String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";

        System.out.println("Connecting to database" + jdbcURL);

        Connection myConn = DriverManager.getConnection(jdbcURL, user, pass);
        System.out.println("Success!!!");
        myConn.close();
    }
}
