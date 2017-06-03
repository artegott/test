<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:importAttribute name="scripts"/>
<tiles:importAttribute name="links"/>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1, user-scalable=no"
          id="Viewport" name="viewport"/>

    <c:forEach var="link" items="${links}">
        <link rel="stylesheet" href="<c:url value="${link}"/>">
    </c:forEach>
</head>

<body style="background-color: white">

<div class="container" style=" margin-top: 20px">
    <tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="body"/>
</div>

<c:forEach var="script" items="${scripts}">
    <script src="<c:url value="${script}"/>"></script>
</c:forEach>
</body>
</html>
