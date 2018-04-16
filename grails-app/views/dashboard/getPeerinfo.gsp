<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>
<body>

<div class="container-fluid">

<div class="row">
<div class="col-3">


<g:render template="/shared/buttonlist"/>


</div>
<div class="col border my-4 p-1">

  <table class="table">
    <thead>
      <tr>
    <th>proxy</th>
    <th>walletversion</th>
    <th>balance</th>
    <th>keypoololdest</th>
      <th>testnet</th>
      <th>connections</th>
      <th>errors</th>
      </tr>

        <tr>
                <td>${info.proxy}</th>
                <td>${info.walletversion}</td>
                <td>${info.balance}</td>
                <td>${info.keypoololdest}</td>
                <td>${info.testnet}</th>
                <td>${info.connections}</td>
                <td>${info.errors}</td>
              </tr>
      </tbody>
    </table>


   <g:each in="${peers}" var="peer">


   <div class="card d-inline-block m-3" style="width: 24rem; ">
     <div class="card-body">
       <h5 class="card-title">${peer.addr}</h5>
       <h6 class="card-subtitle mb-2 text-muted">Version:  ${peer.version}</h6>

<table class="table">
  <tbody>
    <tr>
      <th>id</th>
      <td>${peer.id}</td>
    </tr>
    <tr>
      <th>synced_headers</th>
        <td>${peer.synced_headers}</td>
    </tr>
        <tr>
          <th>bytesent</th>
          <td>${peer.bytessent}</td>
        </tr>
    <tr>
            <tr>
              <th>pingwait</th>
              <td>${peer.pingwait}</td>
            </tr>
        <tr>
      <th>bytesrecv</th>
        <td>${peer.bytesrecv}</td>
    </tr>
    <tr>
      <th>lastsend</th>
        <td>${peer.lastsend}</td>
    </tr>
        <tr>
          <th>lastrecv</th>
            <td>${peer.lastrecv}</td>
        </tr>
  </tbody>
</table>

     </div>
   </div>

   </g:each>

</div>
</div>
</div>

</body>
</html>
