<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<input id="tagsHidden" type="hidden" value="${tags}">
<div>
    <a href="<c:url value="/urls/list"/>"><span class="glyphicon glyphicon-arrow-left"></span> back to my links</a>
    <br/>

    <div id="successful_edit" class="alert alert-success" align="center">
        Data successful saved!
    </div>

    <div id="fail_edit" class="alert alert-danger" align="center">
        Data not saved!
    </div>

    <div class="jumbotron" style="background-color: lightgray" align="center">
        <div class="jumbotron" style="background-color: #337ab7" align="center">
            <h3 style="color: white;">Edit link: <span id="short_url">${shortUrl}</span></h3>
            <br/>
            <form class="form-horizontal">
                <div class="form-group form-group-lg">
                    <div class="col-sm-8 input-group">
                        <div class="input-group-addon"><span>Name:</span></div>
                        <input type="text" id="url_name" name="url_name" class="text-info form-control"
                               placeholder="Enter url name" value="${name}"/>
                    </div>
                </div>
                <div class="form-group form-group-lg">
                    <div class="col-sm-8 input-group">
                        <div class="input-group-addon"><span>Description:</span></div>
                        <input type="text" id="description" name="description" class="text-info form-control"
                               placeholder="Enter url description" value="${description}"/>
                    </div>
                </div>
                <div class="form-group" align="center">
                    <input type="text" id="tags" name="tags" data-role="tagsinput" class="form-control"
                           placeholder="Enter tags">
                </div>
            </form>
        </div>
        <div align="center">
            <button id="edit_btn" type="button" class="btn btn-lg btn-success"><span
                    class="glyphicon glyphicon-ok-sign"></span> Save
            </button>
        </div>
    </div>
</div>
<script type="text/javascript">
    var tags = "${tags}";
    document.getElementById("tags").setAttribute("value", tags.split(" "));
</script>
