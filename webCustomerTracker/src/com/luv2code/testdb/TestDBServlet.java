package com.luv2code.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(name = "TestDBServlet")
public class TestDBServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //setup connection variables
        String user = "springstudent";
        String pass = "springstudent";

        String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";

        //get connection
        try {
            PrintWriter out = response.getWriter();
            out.println("Connecting to database" + jdbcURL);
            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(jdbcURL, user, pass);
            out.println("Success!!!");
            myConn.close();
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }

    }
}
