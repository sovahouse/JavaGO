<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TODO LIST</title>
    <link href="https://necolas.github.io/normalize.css/4.1.1/normalize.css" rel="stylesheet">
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="style.css" rel="stylesheet">
</head>
<body>
<form class="form-inline" action="/todo" method="POST">
    <div class="form-group">
        Task Name <input class="form-control" type="text" name="name"/>
        Task Category <input class="form-control" type="text" name="category"/>
        <input class="btn btn-primary" type="submit" name="submit" value="Add Task">
    </div>
</form>

<form action="/todo" method="POST">
    <div class="main">
        <table class="table"> <!--TODO: обернуть в див что бы таблица не расползалась по всей страницеy-->
            <tr>
                <th>Name</th>
                <th>Category</th>
                <th>Complete</th>
            </tr>

            <c:forEach items="${requestScope.tasks.values()}" var="task">
                <tr>
                    <td><c:out value="${task.getName()}"/></td>
                    <td><c:out value="${task.getCategory()}"/></td>
                    <td><input type="checkbox" name="complete" value="${task.getId()}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <input type="submit" name="submit" value="Update"/>
</form>
</body>
</html>
