<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="align-items: center">
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Position</th>
        <th>Salary</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <th>${employee.name}</th>
            <th>${employee.surname}</th>
            <th>${employee.position}</th>
            <th>${employee.salary}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
