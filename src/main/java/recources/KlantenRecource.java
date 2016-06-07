package recources;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.Bezoek;
import model.Klant;
import model.Product;
import services.ServiceProvider;

@Path("/klanten")
public class KlantenRecource {
	@GET
	@Produces("application/json")
	public String getAlleKlanten(){
		JsonArrayBuilder jab = Json.createArrayBuilder();
		List<Klant> klanten = ServiceProvider.getKlantService().getAlleKlanten();
		for(Klant k: klanten){
			jab.add(k.getKaartnummer());
		}
		return jab.build().toString();
	}
	
	@GET
	@Produces("application/json")
	@Path("/bezoeken")
	public String getAlleBezoeken(){
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for(Klant k: ServiceProvider.getKlantService().getAlleBezoeken()){
			for(Bezoek b: k.getBezoeken()){
				JsonObjectBuilder job = createBezoekJob(b);
				job.add("klantnummer", k.getKaartnummer());
				jab.add(job);
			}
			
		}
		return jab.build().toString();
	}
	
	private JsonObjectBuilder createBezoekJob(Bezoek b){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("afrekentijd", b.getAfrekenTijd().format(formatter));
		JsonArrayBuilder jab2 = Json.createArrayBuilder();
		for(Product p: b.getGekochteProducten()){
			JsonObjectBuilder job2 = Json.createObjectBuilder();
			job2.add("productNaam", p.getNaam());
			job2.add("prijs", p.getPrijs());
			job2.add("categorie", p.getCategorie().getNaam());
			jab2.add(job2);
		}
		job.add("aantalproducten", b.getGekochteProducten().size());
		job.add("gekochteproducten", jab2);
		return job;
	}
	
	@GET
	@Produces("application/json")
	@Path("/bezoeken/{klantnmr}")
	public String getBezoekenByKlantnummer(@PathParam("klantnmr") int klantnummer){
		JsonArrayBuilder jab = Json.createArrayBuilder();
		Klant k = ServiceProvider.getKlantService().getBezoekVanKlant(new Klant(klantnummer));
		for(Bezoek b: k.getBezoeken()){
			JsonObjectBuilder job = createBezoekJob(b);
			job.add("klantnummer", k.getKaartnummer());
			jab.add(job);
		}
		return jab.build().toString();
	}
}
