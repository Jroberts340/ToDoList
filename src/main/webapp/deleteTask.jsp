<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/index.css">
    <title>JSP - Delete Task</title>
</head>
<body class="page">
    <div class="app">
        <h1>
            JAVA To Do List
        </h1>
        <a class="linkbtn" href="index.jsp"> Home </a>

        <a class="linkbtn" href="addTask.jsp"> Add Task </a>

        <a class="linkbtn" href="viewTask.jsp"> View Tasks </a>
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
        %>
        <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>TASKS</th>
        </tr>
        </thead>
        <% while(rs.next()) {
            int id = rs.getInt("id");
            String todo = rs.getString("todo");
        %>
        <tbody>
        <tr>
            <td><%=id%></td>
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

        <form action="deleteServlet" method="post">
            <div class="ad">
                Delete by Task ID: <input type="text" name="task">
            </div>

            <input class="linkbtn" type="reset" value="Clear" name="clear" />
            <input class="linkbtn" type="submit" value="Submit" name="submit" />

        </form>
    </div>
</body>
</html>
