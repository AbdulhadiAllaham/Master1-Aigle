<script>
function showResult(str)
{
if (str.length==0)
  {
  document.getElementById("livesearch").innerHTML="";
  document.getElementById("livesearch").style.border="0px";
  return;
  }
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("livesearch").innerHTML=xmlhttp.responseText;
    document.getElementById("livesearch").style.border="1px solid #A5ACB2";
  document.getElementById("livesearch").style.width="300px"; 
  document.getElementById("livesearch").style.marginTop="-17px"; 
  document.getElementById("livesearch").style.marginLeft="1px"; 
    }
  }
xmlhttp.open("GET","./includes/ajax-search.php?q="+str,true);
xmlhttp.send();
}
</script>
</head>
<body>


<form method="post" action="terme.php">
<p><input type="text" size="30" style="width:300px" onkeyup="showResult(this.value)">
<input type="button" name="btnListeTermes" id="btnListeTermes" value="Liste des termes" onclick="document.location.href='listeTermes.php';" />
	</p>
<div id="livesearch"></div>
	
</form>

