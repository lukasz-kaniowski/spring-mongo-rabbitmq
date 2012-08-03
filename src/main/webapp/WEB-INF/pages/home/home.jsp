<%--
  User: lukasz.kanoiowski
  Date: 12-08-02
  Time: 23:55
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Home Screen</title></head>
<body>
<h1>Home Screen</h1>

<p>${controllerAttr}</p>

<h2>The following people have been stored in the database:</h2>
<ul>
    <c:forEach items="${people}" var="person">
        <li><p>${person.name}</p></li>
    </c:forEach>
</ul>

</body>
</html>