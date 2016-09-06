<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <figure>
        <figcaption><h1>Scheme of restaurant</h1></figcaption>
        <img src="http://www.biletomsk.ru/_object/shemy-zalov/1131/big/02.10.jpg">
    </figure>
    <a href="/employees">Our staff</a>
    <a href="/dishes">Show Menu</a>
    <form:form action="/dish" method="POST" modelAttribute="dish">
        <label>Find dish:</label>
        <input type="text" name="search"/>
        <input type="submit"/>
    </form:form>
    <h2>Contacts</h2>
    <p>Address: Cold street, 28</p>
    <p>Phone number: 459 30 99</p>
    <p>e-mail: bestrestorant@r.com</p>
</body>
</body>
</html>
