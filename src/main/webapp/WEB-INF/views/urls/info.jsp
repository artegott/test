<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <a href="<c:url value="/urls/list"/>"><span class="glyphicon glyphicon-arrow-left"></span> back to my links</a>
    <br/>
    <div class="jumbotron" style="background-color: lightgray" align="center">
        <div class="jumbotron" align="center">
            <h3 style="color: black;">Link: <span>http://localhost:8080/</span><span id="short_url"></span></h3>
            <br/>
            <form class="form-horizontal">
                <div class="form-group form-group-lg">
                    <div class="col-sm-8 input-group">
                        <div class="input-group-addon"><span>Name: </span></div>
                        <span id="name" class="text-info form-control">${name}</span>
                    </div>
                </div>
                <div class="form-group form-group-lg">
                    <div class="col-sm-8 input-group">
                        <div class="input-group-addon"><span>Description: </span></div>
                        <span id="description" class="text-info form-control">${description}</span>
                    </div>
                </div>
                <div class="form-group form-group-lg" align="center">
                    <div class="col-sm-8 input-group">
                        <div class="input-group-addon"><span>Tags: </span></div>
                        <span id="tags_link" class="text-info form-control"></span>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript">
    var tag_array = "${tags}".split(" ");
    var tags = "";
    for (var i = 0; i < tag_array.length; i++) {
        tags += "<a href='/tags?tag=" + tag_array[i] + "'>" + tag_array[i] + "</a> "
    }
    document.createTextNode(tags);
    document.getElementById("tags_link").innerHTML = tags;
</script>

