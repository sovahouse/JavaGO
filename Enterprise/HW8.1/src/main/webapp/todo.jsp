<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <form action="/todo" method="POST">
            Task Name <input type="text" name="name"/>
            Task Category <input type="text" name="category"/>
            <input type="submit" name="submit" value="Add Task"/>
        </form>

        <form action="/todo" method="POST">
        <table>
            <tr>
                <th>Name</th>
                <th>Category</th>
                <th>Complete</th>
            </tr>

            <c:forEach items="${requestScope.tasks.values()}" var="task">
                <tr>
                    <td><c:out value="${task.getName()}" /></td>
                    <td><c:out value="${task.getCategory()}"/></td>
                    <td><input type="checkbox" name="complete" value="${task.getId()}"/></td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" name="submit" value="Update"/>
        </form>
    </body>
</html>
