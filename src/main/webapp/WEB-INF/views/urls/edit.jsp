<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<input id="tagsHidden" type="hidden" value="${tags}">
<div>
    <a href="<c:url value="/urls/list"/>"><span class="glyphicon glyphicon-arrow-left"></span> back to my links</a>
    <br/>

    <c:if test="${success ne null}">
        <div id="successful_edit" class="alert alert-success" align="center">
            Data saved!
        </div>
    </c:if>

    <div class="jumbotron" style="background-color: lightgray" align="center">
        <div class="jumbotron" style="background-color: #337ab7" align="center">
            <h3 style="color: white;">Edit link: <span id="short_url">${url.shortUrl}</span></h3>
            <br/>
            <form:form modelAttribute="url" action="/urls/edit" method="post" class="form-horizontal">
                <div class="form-group form-group-lg">
                    <div class="col-sm-8 input-group">
                        <div class="input-group-addon"><span>Name:</span></div>
                        <form:input path="name" id="name" name="name" type="text" class="text-info form-control"
                                    placeholder="Enter url name" value="${url.name}"/>
                    </div>
                </div>
                <div class="form-group form-group-lg">
                    <div class="col-sm-8 input-group">
                        <div class="input-group-addon"><span>Description:</span></div>
                        <form:input path="description" id="description" name="description" type="text"
                                    class="text-info form-control"
                                    placeholder="Enter url description" value="${url.description}"/>
                    </div>
                </div>
                <div class="form-group" align="center">
                    <form:input path="tags" id="tags" name="tags" type="text" data-role="tagsinput" class="form-control"
                                placeholder="Enter tags" value="${url.tags}"/>
                </div>
                <div align="center">
                    <form:hidden path="shortUrl"/>
                    <form:hidden path="longUrl"/>
                    <form:button id="save_button" name="save_button">Save</form:button>
                </div>
            </form:form>
        </div>
    </div>
</div>