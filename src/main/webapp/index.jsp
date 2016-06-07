<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home | KRIS</title>
<link rel="stylesheet" type="text/css" href="style/navbar.css">
</head>
<body>
<ul>
  <li><a class="active" href="index.jsp">Home</a></li>
  <% if (request.getSession().getAttribute("type") != null && (request.getSession().getAttribute("type").equals("gebruiker") || request.getSession().getAttribute("type").equals("beheerder"))) { %>
  	<li><a href="plattegrond.html">Plattegrond van de winkel</a></li>
  	<li><a href="route.html">Route van klant</a></li>
  	<li><a href="#drukte.html">Drukte per gangpad</a></li>
  <%}if(request.getSession().getAttribute("type") != null && request.getSession().getAttribute("type").equals("beheerder")){ %>
  	<li class="dropdown"><a href="#producten.jsp">Producten</a>
  		<div class="dropdown-content">
  			<a href="producttoevoegen.html">Toevoegen</a>
  			<a href="productverwijderen.html">Verwijderen</a>
  		</div>
  	</li>
  	<li><a href="indelingveranderen.jsp">Indeling winkel aanpassen</a></li>
  	<%} if (request.getSession().getAttribute("type") != null) {%>
	  	<form id="form" action="LogoutServlet.do" method="post">
	 		<li><a href="javascript:{}"onclick="document.getElementById('form').submit();">Uitloggen</a></li>
		</form>
	<%} %>
</ul>
<h1>Welkom bij de website van het klant-route informatie systeem (KRIS)!</h1>
<h3>Inloggen</h3>
<div style="border-style: groove; width:250px; display:inline-block;">
	<%  String n = (String) request.getAttribute("name"); 
		String name = "";
		if(n != null){name=n;}
	%>
	<form action="LoginServlet.do" method="post">
		<p>Inlog naam</p>
		<input type="text" name="name" value='<%=name%>' required/>
		<p>Wachtwoord</p>
		<input type="password" name="pass" required/>
		<p></p>
		<input type="submit" value="Submit"/>
		<p></p>
		<% Object message = request.getAttribute("message");
			if(message != null){
				out.println(message);
			}
		%>
	</form>
</div>
</body>
</html>