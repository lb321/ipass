<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Indeling veranderer | KRIS</title>
<link rel="stylesheet" type="text/css" href="style/navbar.css">
<script src="https://code.jquery.com/jquery-2.2.3.js"></script>
<script src="js/iets.js"></script>
<script language="javascript" type="text/javascript">
  function resizeIframe(obj) {
    obj.style.height = obj.contentWindow.document.body.scrollHeight + 'px';
    obj.style.width = obj.contentWindow.document.body.scrollWidth + 'px';
  }
</script>
</head>
<body>

<ul>
  <li><a href="index.jsp">Home</a></li>
  	<li><a href="#route.html">Route van klant</a></li>
  	<li><a href="#drukte.html">Drukte per gangpad</a></li>
  	<li class="dropdown"><a href="#producten.jsp">Producten</a>
  		<div class="dropdown-content">
  			<a href="producttoevoegen.html">Toevoegen</a>
  			<a href="productverwijderen.html">Verwijderen</a>
  		</div>
  	</li>
  	<li><a class="active" href="indelingveranderen.jsp">Indeling winkel aanpassen</a></li>
  	<form id="form" action="LogoutServlet.do" method="post">
 		<li><a href="javascript:{}"onclick="document.getElementById('form').submit();">Uitloggen</a></li>
	</form>
</ul>
<script>
$(document).ready(function(){
	
	$.get("restservices/producten/locaties", function(data){
		$("#table").html("");
		$("#table").append("<tr><th>Categorie naam</th><th>Schapnummer</th></tr>");
		$.each(data, function(i, categorie){
			$("#table").append("<tr><td>"+categorie.naam + "</td><td><input type=\"number\" name=\""+categorie.naam + "\"value=\""+ categorie.schapnummer + "\"</td></tr>")
		})
	})
	
	$("#nummering").click(function(){
		ctx.clearRect(0, 0, canvas.width, canvas.height);
		tekenPlattegrond(ctx);
		schrijfSchapNummers();
	})
	$("#huidig").click(function(){
		ctx.clearRect(0, 0, canvas.width, canvas.height);
		tekenPlattegrond(ctx);
		$.get("restservices/producten",
				function(data){
					var lijst = {};
					$.each(data, function(i, product){
						lijst[String(product.schap)] = product.categorie;
					});
					schrijfSchapNamen(lijst);				
			})
	})
})
</script>
<form action="WijzigCategorieServlet.do" method="post">
	<table id="table" style="display:inline-block;">
	</table>
<div style="display:inline-block; margin-top: 5px;vertical-align: top;">
	<button type="button" id="huidig" ><h4 style="display:inline-block; margin: 0 0 0 0;">Huidige indeling</h4></button>
	<button type="button" id="nummering"><h4 style="display:inline-block; margin: 0 0 0 0;">Schapnummering</h4></button>
	<canvas id="myCanvas" style="display:block;" width="1000" height="725"
	style="border:1px solid #c3c3c3;">
	Your browser does not support the canvas element.
	</canvas>
	<script>
	var canvas = document.getElementById("myCanvas");
	var ctx = canvas.getContext("2d");
	tekenPlattegrond(ctx);
	 function getMousePos(evt) {
		    var rect = canvas.getBoundingClientRect();
		    return {
		      x: evt.clientX - rect.left,
		      y: evt.clientY - rect.top
		    };
			}
		 canvas.addEventListener("mousemove", function(e){
				console.log(getMousePos(e));
			});
	</script>
</div>
<br/>
<input type="submit" value="Opslaan"/>
<% Object message = request.getAttribute("message");
	if(message != null){
		out.println(message);
	}
%>
</form>
</body>
</html>