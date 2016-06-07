package services;

import java.util.List;

import model.Product;
import persistence.ProductDao;

public class ProductService {
	ProductDao pd = new ProductDao();
	
	public List<Product> getAllProducts(){
		return pd.findAll();
	}
	
	public List<Product> findProductsByCategorie(String cname){
		return pd.findProductsByCategorie(cname);
	}
	
	public boolean deleteProduct(int productID){
		return pd.deleteProduct(productID);
	}
	
	public boolean deleteProduct(String productID){
		boolean result = false;
		try{
			result = pd.deleteProduct(Integer.parseInt(productID));
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean insertProduct(String naam, double prijs, int gewicht, String categorienaam){
		if(gewicht == 0){
			return pd.saveProduct(naam, prijs, categorienaam);
		}
		return pd.saveProduct(naam, prijs, gewicht, categorienaam);
	}
	
	public Product findProductByID(int productid){
		return pd.findProductByID(productid);
	}
}
