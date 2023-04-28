package com.example.tdl_tomcat;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "/addServlet", urlPatterns = "/addServlet")
public class addServlet extends HttpServlet {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /*
        String in =  request.getParameter("task");
        ToDoList todo = new ToDoList();
        todo.addDB(in);
        response.sendRedirect("addTask.jsp");
        */

        String in = request.getParameter("task");

    }
}