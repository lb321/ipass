package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Bezoek {
	private ArrayList<Product> gekochteProducten = new ArrayList<Product>();
	private LocalDateTime afrekenTijd; 
	
	public Bezoek(LocalDateTime afrekenTijd){
		this.afrekenTijd = afrekenTijd;
	}
	
	public void addProduct(Product p){
		gekochteProducten.add(p);
	}
	
	public void removeProduct(Product p){
		gekochteProducten.remove(p);
	}
	
	public ArrayList<Product> getGekochteProducten(){
		return gekochteProducten;
	}
	
	public LocalDateTime getAfrekenTijd(){
		return afrekenTijd;
	}
}
