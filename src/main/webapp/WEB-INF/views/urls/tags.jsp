<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
        <a href="<c:url value="/urls/list"/>"><span class="glyphicon glyphicon-arrow-left"></span> back to my links</a>
        <br/>

        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Short URL</th>
                    <th>Long URL</th>
                    <th>Tags</th>
                    <th>Statistics</th>
                    <th>Info</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="url" items="${tagUrls}">
                    <tr>
                        <td>${url.name}</td>
                        <td>${url.description}</td>
                        <td><a href="/${url.shortUrl}">${url.shortUrl}</a></td>
                        <td><a href="${url.longUrl}">${url.longUrl}</a></td>
                        <td>
                            <c:forEach var="tag" items="${url.tags}">
                                <a href="<c:url value="/tags?tag=${tag.name}"/>">${tag.name}</a>
                            </c:forEach>
                        </td>
                        <td><a class="btn btn-danger" href="<c:url value="/statistics?url=${url.shortUrl}"/>">Statistics</a></td>
                        <td><a class="btn btn-info" href="<c:url value="/urls/info?url=${url.shortUrl}"/>">Info</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
