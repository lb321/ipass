package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Bezoek;
import model.Categorie;
import model.Klant;
import model.Product;
import services.ServiceProvider;

public class KlantDao extends BaseDao{

	public List<Klant> findAll() {
		return find("SELECT * FROM klanten");
	}
	
	private List<Klant> find(String query){
		List<Klant> klanten = new ArrayList<Klant>();
		try(Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while(result.next()){
				int klantID = result.getInt("klantnummer");
				klanten.add(new Klant(klantID));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return klanten;
	}
	
	private List<LocalDateTime> findBezoektijdenVanKlant(String query){
		List<LocalDateTime> tijden = new ArrayList<LocalDateTime>();
		try(Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while(result.next()){
				int klantnummer = result.getInt("klantnummer");
				LocalDateTime afrekentijd = Timestamp.valueOf(result.getTimestamp("afrekentijd").toString()).toLocalDateTime();
				tijden.add(afrekentijd);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return tijden;
	}
	
	public Klant getBezoekenVanKlant(Klant k){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		List<LocalDateTime> bezoekTijden = findBezoektijdenVanKlant("select *, count(*) from bezoek where klantnummer = " + k.getKaartnummer() + " group by afrekentijd");
		for(LocalDateTime tijd: bezoekTijden){
			Bezoek b = new Bezoek(tijd);
			List<Product> producten = new ArrayList<Product>(); 
			try(Connection conn = super.getConnection()){
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery("select * from bezoek where afrekentijd = str_to_date('" + tijd.format(formatter) + "', '%Y-%m-%d %H:%i:%S') and klantnummer = " + k.getKaartnummer() + " order by scanmoment");
				while(result.next()){
					int productID = result.getInt("productID");
					producten.add(ServiceProvider.getProductService().findProductByID(productID));
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			for(Product p: producten){
				b.addProduct(p);
			}
			k.voegBezoekToe(b);
		}
		return k;
	}
	
	public List<Klant> getAllBezoeken(){
		List<Klant> klanten = findAll();
		for(Klant k: klanten){
			getBezoekenVanKlant(k);
		}
		return klanten;
	}
	
}
