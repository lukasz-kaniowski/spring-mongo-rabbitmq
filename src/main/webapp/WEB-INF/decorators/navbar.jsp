<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<a class="brand" href="#">Spring Framework 3</a>

<ul class="nav">
    <li ><a href="<c:url value="/" />"><s:message code="navbar.home"/></a></li>
    <li ><a href="<c:url value="/mongo" />"><s:message code="navbar.mongo"/></a></li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><s:message code="navbar.lang"/>
            <b class="caret"></b>
        </a>
        <ul class="dropdown-menu">
            <li><a href="?siteLanguage=en"><s:message code="navbar.lang.en"/></a></li>
            <li><a href="?siteLanguage=pl"><s:message code="navbar.lang.pl"/></a></li>
        </ul>
    </li>

</ul>
