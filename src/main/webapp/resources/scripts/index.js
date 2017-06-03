
$(document).ready(function () {
    $("#link_info").hide();
    $("#fail_create_message").hide();
    $("#short_btn").click(function () {
        shorten_url();
    });
});

function shorten_url() {
    var tags = $("#tags").val().split(',');
    var tag_objs = [];
    for (var i = 0; i < tags.length; i++) {
        tag_objs[i] = {
            name: tags[i]
        };
    }

    var url = {
        name: $("#url_name").val(),
        description: $("#url_desc").val(),
        longUrl: $("#long_url").val(),
        tags: tag_objs
    };

    $.ajax
    ({
        type: "POST",
        url: "/urls",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(url),
        success: function (data) {
            $("#fail_create_message").hide();
            $("#link_info").show();
            $("#link_short").val("http://178.124.203.244/" + data.shortUrl);
            var link_statistics = "<a href='/statistics?url=" + data.shortUrl + "' class='btn btn-lg btn-danger'>Statistics</a>";
            $("#link_statistics").empty();
            $("#link_statistics").append(link_statistics);
            link_statistics = "";
        },
        error: function () {
            $("#link_info").show();
            $("#fail_create_message").show();
        }
    })

}