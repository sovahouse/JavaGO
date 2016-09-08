<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<h1>MENU</h1>
<table style="align-items: center">
    <tr>
        <th>Name</th>
        <th>Weight</th>
        <th>Price</th>
    </tr>
    <c:forEach var="employee" items="${dishes}">
        <tr>
            <th><a href="/dish?dishName=${employee.name}"> ${employee.name} </a></th>
            <th>${employee.weight}</th>
            <th>${employee.price}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
