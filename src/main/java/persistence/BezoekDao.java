package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Bezoek;
import model.Klant;

public class BezoekDao extends BaseDao{
	
	public List<Bezoek> getBezoekenVanKlant(int klantnummer){
		return find("SELECT afrekentijd, klantnummer, count(*) as aantalProducten FROM ipass.bezoek where klantnummer =" + klantnummer + "group by afrekentijd, klantnummer");
	}
	
	public List<Bezoek> findAll(){
		return find("SELECT distinct afrekentijd, klantnummer FROM bezoek");
	}
	
	
	private List<Bezoek> find(String query){
		List<Bezoek> bezoeken = new ArrayList<Bezoek>();
		try(Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while(result.next()){
				int klantnummer = result.getInt("klantnummer");
				LocalDateTime afrekentijd = Timestamp.valueOf(result.getTimestamp("afrekentijd").toString()).toLocalDateTime();
				//int aantal = result.getInt("aantalProducten");
				bezoeken.add(new Bezoek(new Klant(klantnummer), afrekentijd));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return bezoeken;
	}
	
}
