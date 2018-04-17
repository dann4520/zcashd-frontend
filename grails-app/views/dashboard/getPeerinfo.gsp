<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>
<body>


<script>


$(document).ready(function() {
    var refreshData = function(){

    //$("#peersList").append('<i class="fas fa-cog fa-10x fa-pulse"></i>');

        $.ajax({
            url: "/getPeerinfo",
            method: "POST",
        }).done(function(data){

        $("#peersList").empty();

        data.forEach(function(e) {

            $("#peersList").append('<div class="card d-inline-block m-3" style="width: 24rem; ">' +
                                    '<div class="card-body">' +
                                    '<h5 class="card-title">Address: ' + e.addr + '</h5>' +
                                    '<h6 class="card-subtitle mb-2 text-muted">Version: ' + e.version + ' </h6>' +
                                    '<table class="table"><tbody>' +
                                    '<tr><th>id</th><td>' + e.id + '</td></tr>' +
                                    '<tr><th>synced_headers</th><td>' + e.synced_headers + '</td></tr>' +
                                    '<tr><th>bytessent</th><td>' + e.bytessent + '</td></tr>' +
                                    '<tr><th>pingtime</th><td>' + e.pingtime + '</td></tr>' +
                                    '<tr><th>bytesrecv</th><td>' + e.bytesrecv + '</td></tr>' +
                                    '<tr><th>lastsend</th><td>' + e.lastsend + '</td></tr>' +
                                    '<tr><th>lastrecv</th><td>' + e.lastrecv + '</td></tr>' +
                                    '</tbody></table></div></div>')

        });
    })
}

refreshData();
setInterval(refreshData, 3000);

})


</script>



<div class="container-fluid">
<div class="row">
<div class="col-3">


<g:render template="/shared/buttonlist"/>


</div>
<div class="col border my-4 p-1">

<div id="peersList">
</div>



</div>
</div>
</div>

</body>
</html>
