<%@ page import="java.util.Enumeration" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <form action="todo" method="POST">
            Task Name <input type="text" name="name">
            Task Category <input type="text" name="category"/>
            <input type="submit" value="Add Task"/>
        </form>
    </body>
</html>
