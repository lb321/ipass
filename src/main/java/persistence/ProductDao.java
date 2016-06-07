package persistence;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Categorie;
import model.Product;
import model.Schap;

public class ProductDao extends BaseDao{
	
	public List<Product> findAll(){
		return find("SELECT * FROM producten");
	}
	
	public List<Product> find(String query){
		List<Product> list = new ArrayList<Product>();
		try(Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while(result.next()){
				int id = result.getInt("productid");
				String naam = result.getString("naam");
				double prijs = result.getDouble("prijs");
				int gewicht = result.getInt("gewicht");
				Categorie categorie = getCategorieByName(result.getString("categorienaam"));
				list.add(new Product(id, naam, prijs, gewicht, categorie));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public Product findProductByID(int productid){
		Product p = null;
		for(Product product: find("SELECT * FROM producten WHERE productid = " + productid)){
			p = product;
		}
		return p;
	}
	
	public List<Product> findProductsByCategorie(String cname){
		return find("SELECT * FROM producten WHERE categorienaam = '" + cname + "'");
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
	
	public boolean deleteProduct(int productID){
		boolean result = false;
		try(Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			result = stmt.execute("DELETE FROM producten WHERE productID = " + productID);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean saveProduct(String naam, double prijs, int gewicht, String categorienaam){
		boolean result = false;
		try(Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			result = stmt.execute("INSERT INTO producten VALUES("+ getNewProductID() +", '" + naam + "', " + gewicht + ", " + prijs + ", '" + categorienaam + "')");
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean saveProduct(String naam, double prijs, String categorienaam){
		boolean result = false;
		try(Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			result = stmt.execute("INSERT INTO producten VALUES("+ getNewProductID() +", '" + naam + "', NULL, " + prijs + ", '" + categorienaam + "')");
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public int getNewProductID(){
		int id = 0;
		try(Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT productID FROM producten ORDER BY productID desc limit 1");
			while(result.next()){
				id = result.getInt("productID") + 1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}
}
