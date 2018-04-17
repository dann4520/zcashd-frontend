<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>${siteTitle}</title>

</head>
<body>

<div class="container-fluid">

<div class="row">
<div class="col-3 mt-4">


<g:render template="/shared/buttonlist"/>


</div>
<div class="col border rounded m-4 p-4">

<div id="zcashBlog">
<i class="fas fa-cog fa-10x fa-pulse"></i>
</div>


<script>
$(document).ready(function() {
    $.ajax({
        url: "/",
        method: "POST",
    }).done(function(data){
        console.log(data);
        $("#zcashBlog").empty();
        data.zcashRss.forEach(function(element) {

$("#zcashBlog").append("<div class='card my-3'>" +
                       "<div class='card-body'>" +
                        "<h5 class='card-title'><a href='" + element.link + "'>" + element.title + "</a></h5>" +
                        "<p class='card-text'>" + element.description + "</p>" +
                        "<div class='card-footer text-muted'>" + element.pubDate + "</div></div></div>")
        })
    })
})
</script>


</div>
</div>
</div>

</body>
</html>
