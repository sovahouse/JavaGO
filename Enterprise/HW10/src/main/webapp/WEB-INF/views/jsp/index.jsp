<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--<figure>
        <figcaption><h1>Scheme of restaurant</h1></figcaption>
        <img src="http://www.biletomsk.ru/_object/shemy-zalov/1131/big/02.10.jpg">
    </figure>
    <a href="/employees">Our staff</a>
    <a href="/dishes">Show Menu</a>
    <form action="/dishes/" method="post">
        <label>Find dish:</label>
        <input type="text" name="dishName"/>
        <input type="submit"/>
    </form>
    <h2>Contacts</h2>
    <p>Address: Cold street, 28</p>
    <p>Phone number: 459 30 99</p>
    <p>e-mail: bestrestorant@r.com</p>--%>

    <p><a href="/employees">all employees</a></p>
    <p><a href="/employees/id=1">employees with id 1</a></p>
    <p><a href="/employees/Jill,Anderson">employees with name Jill and surname Anderson</a></p>
    <p><a href="/order">all orders</a></p>
    <p><a href="/order/closed">closed orders</a></p>
    <p><a href="/order/opened">opened orders</a></p>
    <p><a href="/order/1">order with id</a></p>
    <p><a href="/menu">all menu</a></p>
    <p><a href="/menu/id=1">menu with id 1</a></p>
    <p><a href="/menu/name=Salad">menu with name Salad</a></p>
</body>
</body>
</html>
