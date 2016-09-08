<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet"/>
</head>
<body>
    <div class="wrapper">
        <c:forEach var="employee" items="${employees}">
            <div class="container">
                <figure>
                    <img src="/resources/img/1.jpg" width="200" height="200">
                    <figcaption>${employee.name}</figcaption>
                </figure>
            </div>
        </c:forEach>
    </div>
</body>
</html>
