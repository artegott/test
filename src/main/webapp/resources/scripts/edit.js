$(document).ready(function () {
    $("#successful_edit").hide();
    $("#fail_edit").hide();
    $("#edit_btn").click(function () {
        edit();
    })
});

function edit() {
    var short_url = $("#short_url").text();
    var tags = $("#tags").val().split(',');
    var tag_array = [];
    for (var i = 0; i < tags.length; i++) {
        tag_array[i] = {
            name: tags[i]
        }
    }
    var url = {
        name: $("#url_name").val(),
        description: $("#description").val(),
        longUrl: "edit",
        shortUrl: short_url,
        tags: tag_array
    };

    $.ajax
    ({
        type: "POST",
        url: "/urls/edit",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(url),
        success: function () {
            $("#successful_edit").show();
            $("#fail_edit").hide();
        },
        error: function () {
            $("#successful_edit").hide();
            $("#fail_edit").show();
        }
    });
}
