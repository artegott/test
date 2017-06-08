<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <c:if test="${param.get('error') ne null}">
        <div class="alert alert-danger fade in" align="center">
            Invalid username or password.
        </div>
    </c:if>
    <c:if test="${param.get('logout') ne null}">
        <div class="alert alert-info fade in" align="center">
            You have been logged out.
        </div>
    </c:if>

    <p>${firstName}</p>

    <div class="jumbotron" style="background-color: lightgray" align="center">
        <form role="form" action="<c:url value="/login"/>" method="post" class="form-horizontal">
            <div class="form-group form-group-lg">
                <div class="col-sm-8 input-group">
                    <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
                    <input type="text" id="username" name="username" class="text-info form-control"
                           placeholder="Enter your login"/>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <div class="col-sm-8 input-group">
                    <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
                    <input type="password" id="password" name="password" class="text-info form-control"
                           placeholder="Enter your password"/>
                </div>
            </div>
            <div align="center">
                <button type="submit" class="btn btn-lg btn-success"><span
                        class="glyphicon glyphicon-log-in"></span>
                    Log in
                </button>
            </div>
        </form>
    </div>
</div>
