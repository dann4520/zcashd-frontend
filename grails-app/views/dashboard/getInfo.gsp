<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>${siteTitle}</title>
</head>
<body>

<div class="container-fluid">

<div class="row">
<div class="col-3">


<script>
$(document).ready(function() {
    var refreshData = function(){
    $("#peersList").append('<i class="fas fa-cog fa-10x fa-pulse"></i>');
        $.ajax({
            url: "/getInfo",
            method: "POST",
        }).done(function(data){
            console.log(data);
            $("#protocolversion").html(data.protocolversion);
            $("#relayfee").html(data.relayfee);
            $("#timeoffset").html(data.timeoffset);
            $("#blocks").html(data.blocks);
            $("#version").html(data.version);
            $("#keypoolsize").html(data.keypoolsize);
            $("#paytxfee").html(data.paytxfee);
            $("#difficulty").html(data.difficulty);
            $("#proxy").html(data.proxy);
            $("#walletversion").html(data.walletversion);
            $("#balance").html(data.balance);
            $("#keypoololdest").html(data.keypoololdest);
            $("#testnet").html(data.testnet);
            $("#connections").html(data.connections);
        })
    };

    refreshData();
    setInterval(refreshData, ${refresh});


})
</script>


<g:render template="/shared/buttonlist"/>


</div>
<div class="col border my-4 p-1">

<table class="table">
  <tbody>
    <tr>
      <th>protocolversion</th>
      <td id="protocolversion"></th>
      </tr>
      <tr>
      <th>relayfee</th>
      <td id="relayfee"></td>
      </tr>
      <tr>
      <th>timeoffset</th>
      <td id="timeoffset"></td>
      </tr>
      <tr>
      <th>blocks</th>
      <td id="blocks"></td>
      </tr>
      <tr>
    <th>version</th>
    <td id="version"></th>
    </tr>
    <tr>
    <th>keypoolsize</th>
    <td id="keypoolsize"></td>
    </tr>
    <tr>
    <th>paytxfee</th>
    <td id="paytxfee"></td>
    </tr>
    <tr>
    <th>difficulty</th>
    <td id="difficulty"></td>
</tr>
    <tr>
    <th>proxy</th>
    <td id="proxy"></td>
</tr>
    <tr>
    <th>walletversion</th>
    <td id="walletversion"></td>
</tr>
    <tr>
    <th>balance</th>
    <td id="balance"></td>
</tr>
    <tr>
    <th>keypoololdest</th>
    <td id="keypoololdest"></td>
</tr>
    <tr>
    <th>testnet</th>
    <td id="testnet"></td>
</tr>
    <tr>
    <th>connections</th>
    <td id="connections"></td>
</tr>
    <tr>
    <th>errors</th>
    <td id="errors"></td>
</tr>

    </tbody>
  </table>


</div>
</div>
</div>

</body>
</html>
