<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table style="align-items: center">
    <tr>
        <th>Name</th>
        <th>Weight</th>
        <th>Price</th>
        <th>Ingredients</th>
    </tr>
        <tr>
            <th>${dish.name}</th>
            <th>${dish.weight}</th>
            <th>${dish.price}</th>
            <th>
                <c:forEach var="ingredient" items="${dish.ingredients}">
                    ${ingredient.name}, <br>
                </c:forEach>
            </th>
        </tr>
</table>
</body>
</html>
