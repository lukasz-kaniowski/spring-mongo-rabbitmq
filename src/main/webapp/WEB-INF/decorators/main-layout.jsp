<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Spring-MVC-Showcase</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/css/bootstrap-responsive.min.css" />" rel="stylesheet" type="text/css"/>


    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>

<body>

<div class="navbar">
    <div class="navbar-inner">
        <c:import url="/WEB-INF/decorators/navbar.jsp"/>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="span12">
            <decorator:body/>
        </div>
    </div>
</div>
<hr>

<footer>
    <c:import url="/WEB-INF/decorators/footer.jsp"/>
</footer>


<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>