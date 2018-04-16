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
      <th>protocolversion</th>
      <th>relayfee</th>
      <th>timeoffset</th>
      <th>blocks</th>
    <th>version</th>
    <th>keypoolsize</th>
    <th>paytxfee</th>
    <th>difficulty</th>
</tr>
  </thead>
  <tbody>
      <tr>
        <td>${info.protocolversion}</th>
        <td>${info.relayfee}</td>
        <td>${info.timeoffset}</td>
        <td>${info.blocks}</td>
        <td>${info.version}</th>
        <td>${info.keypoolsize}</td>
        <td>${info.paytxfee}</td>
        <td>${info.difficulty}</td>
</tr>
    </tbody>
  </table>


</div>
</div>
</div>

</body>
</html>
