<div>
    <div id="error_data" class="alert alert-danger fade in" align="center">
        <strong>Error</strong> input data!
    </div>

    <div id="error_user_data" class="alert alert-danger fade in" align="center">
        <strong>Error</strong> input data!<br/>
        Most likely a user with this login already exists
    </div>

    <div class="jumbotron" style="background-color: lightgray" align="center">
        <form role="form" class="form-horizontal">
            <div class="form-group form-group-lg">
                <div class="col-sm-8 input-group">
                    <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
                    <input type="text" id="user_name" name="username" class="text-info form-control"
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
            <div class="form-group form-group-lg">
                <div class="col-sm-8 input-group">
                    <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
                    <input type="password" id="r_password" class="text-info form-control"
                           placeholder="Repeat your password"/>
                </div>
            </div>
            <div align="center">
                <button class="btn btn-lg btn-success" type="button" id="register_btn"><span
                        class="glyphicon glyphicon-ok-sign"></span> Register
                </button>
            </div>
        </form>
    </div>

</div>
