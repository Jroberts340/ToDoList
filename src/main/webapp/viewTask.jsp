
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/index.css">
    <title>JSP - View Task</title>
</head>
<body class="page">
    <div class="app">
        <h1>
            JAVA To Do List
        </h1>
        <a class="linkbtn" href="index.jsp"> Home </a>

        <a class="linkbtn" href="addTask.jsp"> Add Task </a>

        <a class="linkbtn" href="deleteTask.jsp"> Delete Tasks </a>

        <%
            Connection con = null;
            Statement st = null;
            ResultSet rs;

            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/to_do_list","root","Heaven23*");
                st = con.createStatement();
                rs = st.executeQuery("select * from todolist;");
        %><table class="tab">
        <thead>
        <tr>
            <th style="text-align: center">TASKS</th>
        </tr>
        </thead>
        <tbody>
        <%while(rs.next()) {
            String todo = rs.getString("todo");
        %>
        <tr>
            <td><%=todo %></td>
        </tr>
        <%}%>
        </tbody>
    </table><br>
        <%}
        catch(Exception e){
            e.printStackTrace();
        }
        %>

    </div>
</body>
</html>
