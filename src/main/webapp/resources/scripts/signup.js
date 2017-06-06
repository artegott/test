$(document).ready(function () {
    $("#error_data").hide();
    $("#error_user_data").hide();
    $("#register_btn").click(function () {
        sign_up();
    })
});

function sign_up() {
    var r_password = $("#r_password").val();

    var user = {
        login: $("#user_name").val(),
        password: $("#password").val()
    };

    if (user.password == r_password) {
        $.ajax
        ({
            type: "POST",
            url: "/users",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(user),
            success: function () {
                window.location.replace("/?successfulRegister");
            },
            error: function () {
                $("#error_user_data").show();
                $("#error_data").hide();
            }
        })
    } else {
        $("#error_data").show();
        $("#error_user_data").hide();
    }
}