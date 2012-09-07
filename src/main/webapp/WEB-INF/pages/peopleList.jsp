<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul>
    <c:forEach items="${people}" var="person">
        <li><p>${person.name}</p></li>
    </c:forEach>
</ul>