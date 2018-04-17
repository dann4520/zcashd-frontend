<div class="text-center">
<h4>Commands</h4>
<hr class="mb-4">
<div class="list-group">
<button type="button" onclick="window.location.href='/'" class="list-group-item list-group-item-action ${params.action == "home" ? "active" : ""}">home</button>
  <button type="button" onclick="window.location.href='/getInfo'" class="list-group-item list-group-item-action ${params.action == "getInfo" ? "active" : ""}">getinfo</button>
  <button type="button" onclick="window.location.href='/getPeerinfo'" class="list-group-item list-group-item-action ${params.action == "getPeerinfo" ? "active" : ""}">getpeerinfo</button>
</div>
</div>