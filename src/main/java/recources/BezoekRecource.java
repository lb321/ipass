package recources;

import java.time.LocalDateTime;
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
import services.ServiceProvider;

@Path("/bezoek")
public class BezoekRecource {
	
	@GET
	@Produces("application/json")
	public String getAlleBezoeken(){
		JsonArrayBuilder jab = Json.createArrayBuilder();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		for(Klant k: ServiceProvider.getKlantService().getAlleBezoeken()){
			/*JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("klantnummer", b.getKlant().getKaartnummer());
			job.add("afrekentijd", b.getAfrekenTijd().format(formatter));
			jab.add(job);*/
		}
		return jab.build().toString();
	}
	
	@GET
	@Path("/bezoek/{klantnmr}")
	@Produces("application/json")
	public String getBezoekVanKlant(@PathParam("klantnmr") int klantnummer){
		JsonArrayBuilder jab = Json.createArrayBuilder();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		for(Bezoek b: ServiceProvider.getBezoekService().findBezoekenVanKlant(klantnummer)){
			JsonObjectBuilder job = Json.createObjectBuilder();
			//job.add("klantnummer", b.getKlant().getKaartnummer());
			job.add("afrekentijd", b.getAfrekenTijd().format(formatter));
			//job.add("aantalProducten", arg1);
		}
		return jab.build().toString();
	}
}
