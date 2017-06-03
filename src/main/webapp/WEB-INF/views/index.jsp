<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${param.get('successfulRegister') ne null}">
    <div id="successfulRegister" class="alert alert-success fade in" align="center">
        <strong>Registration</strong> completed successfully!
    </div>
</c:if>

<div class="jumbotron" style="background-color: lightgray">
    <div id="link_info" class="jumbotron" style="background-color: #337ab7" align="center">
        <div class="form-group form-group-lg">
            <div class="col-sm-8 input-group">
                <div class="input-group-addon"><span>Your link:</span></div>
                <input type="text" id="link_short" class="form-control"/>
                <span class="input-group-btn" id="link_statistics"></span>
            </div>
        </div>
        <br/>
        <div id="fail_create_message" class="alert alert-danger fade in" align="center">
            Failed to create link!
        </div>
    </div>
    <form>
        <div class="form-group form-group-lg" align="center">
            <div>
                <input type="text" id="long_url" name="longUrl" class="form-control"
                       placeholder="Enter your link"/>
            </div>
        </div>
    </form>
    <div id="additionally_option" class="collapse">
        <div id="info" class="jumbotron" style="background-color: #337ab7">
            <form class="form-horizontal">
                <div class="form-group" align="center">
                    <div class="col-sm-8 input-group">
                        <div class="input-group-addon">Name:</div>
                        <input type="text" id="url_name" name="UrlName" class="form-control"
                               placeholder="Enter name"/>
                    </div>
                </div>
                <div class="form-group" align="center">
                    <div class="col-sm-8 input-group">
                        <div class="input-group-addon">Description:</div>
                        <input type="text" id="url_desc" name="UrlDesc" class="form-control"
                               placeholder="Enter description"/>
                    </div>
                </div>
                <div class="form-group" align="center">
                    <input type="text" id="tags" name="tags" data-role="tagsinput" class="form-control"
                           placeholder="Enter tags"/>
                </div>
            </form>
        </div>
    </div>
    <div align="center">
        <button data-toggle="collapse" data-target="#additionally_option" class="btn btn-lg btn-primary">
            Additionally
        </button>
        <input type="button" id="short_btn" name="short_btn" class="btn btn-lg btn-danger" value="SHORTEN URL"/>
    </div>
</div>
