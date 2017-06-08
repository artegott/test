<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>

    <c:if test="${errorMessage ne null}">
        <div id="error_user_data" class="alert alert-danger fade in" align="center">
            <strong>Error</strong> input data!<br/>
                ${errorMessage}
        </div>
    </c:if>
    <form:errors/>
    <div class="jumbotron" style="background-color: lightgray" align="center">
        <form:form modelAttribute="user" action="registerProcess" method="post" class="form-horizontal">
            <div class="form-group form-group-lg">
                <div class="col-sm-8 input-group">
                    <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
                    <form:label path="login">Login</form:label>
                    <form:input path="login" id="login" name="login" cssClass="text-info form-control"/>
                    <form:errors path="login"/>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <div class="col-sm-8 input-group">
                    <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
                    <form:label path="password">Password</form:label>
                    <form:input path="password" name="password" id="password" cssClass="text-info form-control"/>
                    <form:errors path="password"/>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <div class="col-sm-8 input-group">
                    <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
                    <form:label path="">Matching Password</form:label>
                    <form:input path="matchingPassword" name="matchingPassword" id="matchingPassword"
                                cssClass="text-info form-control"/>
                    <form:errors path="matchingPassword"/>
                </div>
            </div>
            <div align="center">
                <form:button id="register" name="register">Register</form:button>
            </div>
        </form:form>
    </div>

</div>
