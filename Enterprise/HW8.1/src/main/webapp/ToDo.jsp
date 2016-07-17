<%@ page import="goit.hw8_1.servlets.Task" %>
<%@ page import="goit.hw8_1.servlets.TODOServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <form action="/todo" method="POST">
            Task Name <input type="text" name="name">
            Task Category <input type="text" name="category"/>
            <input type="submit" value="Add Task"/>
        </form>
        <tr>
            <th>Name</th>
            <th>Category</th>
        </tr>
        <c:forEach items="${requestScope.tasks}" var="task">
            <c:out value="${task.getName()}" />
            <c:out value="${task.getCategory()}"/>
        </c:forEach>
    </body>
</html>
