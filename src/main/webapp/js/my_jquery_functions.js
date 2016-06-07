$(document).ready(function(){
	$.get("restservices/producten",
			function(data){
				var lijst = {};
				$.each(data, function(i, product){
					lijst[String(product.schap)] = product.categorie;
					console.log(String(product.schap) + " = " + product.categorie);
					//schrijfSchapNaam(product.schap, product.categorie);
					//$("#countries").append("<tr><td>" + country.code + "</td><td>" + country.name + "</td><td>" + country.continent + "</td><td>" + country.region + "</td><td>" + country.surface + "</td><td>" + country.population + "</td><td>" + country.government + "</td></tr>")
				});
				console.log("schrijf!!!")
				schrijfSchapNamen(lijst);				
		})
})