<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <a href="<c:url value="/urls/list"/>"><span class="glyphicon glyphicon-arrow-left"></span> back to my links</a>
    <h2>http://localhost:8080/${URL}</h2>
    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>Device</th>
                <th>Clicks</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><img src="<c:url value="/resources/images/pc_icon.png"/>" class="img-circle" width="150"
                         height="150"/></td>
                <td>${PcClick}</td>
            </tr>
            <tr>
                <td><img src="<c:url value="/resources/images/mb_icon.png"/>" class="img-circle" width="150"
                         height="150"/></td>
                <td>${MobileClick}</td>
            </tr>
            <tr>
                <td><img src="<c:url value="/resources/images/tb_icon.png"/>" class="img-circle" width="150"
                         height="150"/></td>
                <td>${TabletClick}</td>
            </tr>
            <tr>
                <td></td>
                <td><h2>Total click: ${TotalClick}</h2></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
