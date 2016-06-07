package recources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.Bezoek;
import model.Categorie;
import model.Klant;
import model.Product;
import services.ServiceProvider;

@Path("/producten")
public class ProductenRecource {
	
	@GET
	@Produces("application/json")
	public String getAllProducts(){
		JsonArrayBuilder jab = Json.createArrayBuilder();
		List<Product> producten = ServiceProvider.getProductService().getAllProducts();
		for(Product p: producten){
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("id", p.getId());
			job.add("naam", p.getNaam());
			job.add("prijs", p.getPrijs());
			job.add("gewicht", p.getGewicht());
			job.add("categorie", p.getCategorie().getNaam());
			job.add("schap", "s" + p.getCategorie().getSchap().getNummer());
			jab.add(job);
		}
		return jab.build().toString();
		
	}
	
	@GET
	@Path("/locaties")
	@Produces("application/json")
	public String getLocaties(){
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for(Categorie c: ServiceProvider.getCategorieService().getAllCategorieen()){
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("naam", c.getNaam());
			job.add("schapnummer", c.getSchap().getNummer());
			jab.add(job);
		}
		return jab.build().toString();
	}
	
	@GET
	@Path("/categorienamen")
	@Produces("application/json")
	public String getAllCategorieNamen(){
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for(Categorie c: ServiceProvider.getCategorieService().getAllCategorieen()){
			jab.add(c.getNaam());
		}
		return jab.build().toString();
	}
	
	@GET
	@Path("/{name}")
	@Produces("application/json")
	public String getProductsByCategoriename(@PathParam("name") String name){
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for(Product p: ServiceProvider.getProductService().findProductsByCategorie(name)){
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("id", p.getId());
			job.add("naam", p.getNaam());
			job.add("prijs", p.getPrijs());
			job.add("gewicht", p.getGewicht());
			job.add("categorie", p.getCategorie().getNaam());
			job.add("schap", "s" + p.getCategorie().getSchap().getNummer());
			jab.add(job);
		}
		return jab.build().toString();
	}
	
	/*public String getAlleKlanten(){
		List<Klant> klanten = new ArrayList<Klant>();
		klanten.add(new Klant(0));
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for(Klant k: klanten){
			Bezoek b = new Bezoek(new Date());
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("kaartnummer", k.getKaartnummer());
			jab.add(k.getKaartnummer());
		}
		return jab.build().toString();
	}*/

}
