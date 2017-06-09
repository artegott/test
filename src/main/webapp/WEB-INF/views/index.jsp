<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:if test="${param.get('successfulRegister') ne null}">
    <div id="successfulRegister" align="center">
        <strong>Registration</strong> completed successfully!
    </div>
</c:if>

<c:if test="${url.shortUrl ne null}">
    <div align="center">
        <div><span>Your link:</span></div>
        <input type="text" id="link_short" value="${url.shortUrl}"/>
    </div>
</c:if>
<form:form modelAttribute="url" action="urls" method="post">
    <div align="center">
        <div>
            <form:input path="longUrl" id="longUrl" name="longUrl" type="text" placeholder="Enter your link"/>
            <form:errors path="longUrl"/>
        </div>
    </div>
    <div align="center">
        <div>Name:</div>
        <form:input path="name" id="name" name="name" type="text" placeholder="Enter name"/>
    </div>
    <div align="center">
        <div>Description:</div>
        <form:input path="description" id="description" name="description" type="text" placeholder="Enter description"/>
    </div>
    <div align="center">
        <form:input path="tags" id="tags" name="tags" data-role="tagsinput" type="text" placeholder="Enter tags"/>
    </div>
    <div align="center">
        <form:button id="short_btn" name="short_btn">Shorten URL</form:button>
    </div>
</form:form>
