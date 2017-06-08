<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value="/"/>"><span class="glyphicon glyphicon-link"></span>
                ShortLinks</a>
        </div>
        <ul class="nav navbar-nav">
            <sec:authorize access="isAuthenticated()">
                <li><a href="<c:url value="/urls/list"/>">Links</a></li>
            </sec:authorize>
            <li><a href="#">Help</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <sec:authorize access="!isAuthenticated()">
                <li><a href="<c:url value="/register"/>"><span class="glyphicon glyphicon-user"></span>Sign up</a></li>
                <li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in"></span>Log in</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li><a><sec:authentication property="principal.username"/></a></li>
                <li><a href="<c:url value="/logout"/>"><span class="glyphicon glyphicon-log-out"></span>Log out</a></li>
            </sec:authorize>
        </ul>
    </div>
</nav>
