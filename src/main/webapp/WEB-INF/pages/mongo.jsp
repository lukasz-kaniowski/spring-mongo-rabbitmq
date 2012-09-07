<%--
  User: lukasz.kanoiowski
  Date: 12-08-02
  Time: 23:55
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1><s:message code="mongo.title"/></h1>

<p>${controllerAttr}</p>

<h2>The following people have been stored in the database:</h2>
<ul>
    <c:forEach items="${people}" var="person">
        <li><p>${person.name}</p></li>
    </c:forEach>
</ul>

</body>

</html>