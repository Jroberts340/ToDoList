
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/index.css">
    <title>JSP - Add Task</title>
</head>
<body class="page">
    <div class="app">
        <h1>
            JAVA To Do List
        </h1>
        <a class="linkbtn" href="index.jsp"> Home </a>

        <a class="linkbtn" href="deleteTask.jsp"> Delete Task </a>

        <a class="linkbtn" href="viewTask.jsp"> View Tasks </a>

        <p> Click the "Submit" button when you are ready to enter your task</p>

        <form action="addServlet" method="post">
            <div class="ad">
                Add Tasks: <input type="text" name="task">
            </div>
                <input class="linkbtn" type="reset" value="Clear" name="clear" />
                <input class="linkbtn" type="submit" value="Submit" name="submit" />

        </form>
    </div>
</body>
</html>
