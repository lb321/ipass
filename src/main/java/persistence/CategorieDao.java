package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Categorie;
import model.Schap;

public class CategorieDao extends BaseDao{
	
	public List<Categorie> findAll(){
		return find("SELECT * FROM categorie");
	}
	
	public List<Categorie> find(String query){
		List<Categorie> categorieen = new ArrayList<Categorie>();
		try(Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while(result.next()){
				Categorie categorie = getCategorieByName(result.getString("categorienaam"));
				categorieen.add(categorie);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return categorieen;
	}
	
	public Categorie getCategorieByName(String name){
		Categorie c = null;
		try(Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM categorie WHERE categorienaam = '" + name + "'");
			while(result.next()){
				c = new Categorie(name , new Schap(result.getInt("locatie")));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return c;
	}
	
	private boolean addToHistory(String name){
		boolean result = false;
		try(Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			System.out.println("INSERT INTO categorie_history VALUES('"+ name + "', " + getCategorieByName(name).getSchap().getNummer() + ",now())");
			stmt.execute("INSERT INTO categorie_history VALUES('"+ name + "', " + getCategorieByName(name).getSchap().getNummer() + ",now())");
			result = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	public boolean updateCategorie(Categorie c){
		boolean result = false;
		try(Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			if(addToHistory(c.getNaam())){
				stmt.execute("UPDATE categorie SET locatie = " +  c.getSchap().getNummer()+ " WHERE categorienaam = '" + c.getNaam() + "'" );
				result = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
