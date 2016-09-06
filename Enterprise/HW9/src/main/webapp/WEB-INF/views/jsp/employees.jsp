<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="employee" items="${employees}">
        <figure>
            <img src="https://i512.mycdn.me/image?t=32&bid=772126541531&id=772126541531&plc=WEB&tkn=*bCcqXc516ibKKuf7Ddl_o2BSddo">
            <figcaption><h1>${employee.name}</h1></figcaption>
        </figure>
    </c:forEach>
</body>
</html>
