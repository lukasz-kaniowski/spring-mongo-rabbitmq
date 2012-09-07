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

<div class="span4">
    <legend>List of people</legend>
    <a href="#" id="clearDb" class="btn">Clear Collection</a>

    <div id="peopleList">
        <jsp:include page="peopleList.jsp"/>
    </div>
</div>
<div class="span6">
    <form method="post">
        <legend>Add New Person</legend>
        <label for="name">Name:</label>
        <input id="name" name="name" type="text" placeholder="name...">
        <br/>
        <button type="submit" class="btn">Submit</button>
    </form>
</div>
<script type="text/javascript">
    $(document).ready(function () {

        $("#clearDb").click(function () {
            $.get("clearDb?ajax=true", function (data) {
                $('#peopleList').html(data);
            });
        });
    });
</script>
</body>

</html>