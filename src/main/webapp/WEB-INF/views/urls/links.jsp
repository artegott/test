<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Short link</th>
                <th>Original link</th>
                <th>Tags</th>
                <th>Total click</th>
                <th>Statistics</th>
                <th>Details</th>
            </tr>
            </thead>
            <tbody id="dataTable">
            <c:forEach var="url" items="${urls}">
                <tr>
                    <td>${url.name}</td>
                    <td>${url.description}</td>
                    <td><a href="<c:url value="/${url.shortUrl}"/>">${url.shortUrl}</a></td>
                    <td><a href="<c:url value="${url.longUrl}"/>">${url.longUrl}</a></td>
                    <td>
                        <c:forEach var="tag" items="${url.tags}">
                            <a href="<c:url value="/tags?tag=${tag.name}"/>">${tag.name}</a>
                        </c:forEach>
                    </td>
                    <td>${(url.statistics.countPcClick
                            + url.statistics.countMobileClick
                            + url.statistics.countTabletClick)}</td>
                    <td><a href="<c:url value="/statistics?url=${url.shortUrl}"/>" class="btn btn-danger">Statistics</a>
                    </td>
                    <td><a href="<c:url value="/urls/info?url=${url.shortUrl}"/>" class="btn btn-info">Info</a>
                    </td>
                    <td><a href="<c:url value="/urls/edit?url=${url.shortUrl}"/>" class="btn btn-warning">Edit</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
