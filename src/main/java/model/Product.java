package model;

public class Product {
	private int id;
	private String naam;
	private double prijs;
	private int gewicht;
	private Categorie categorie;
	
	public Product(int id, String naam, double prijs, Categorie categorie){
		this.id = id;
		this.naam = naam;
		this.prijs = prijs;
		this.categorie = categorie;
	}
	
	public Product(int id, String naam, double prijs, int gewicht, Categorie categorie){
		this.id = id;
		this.naam = naam;
		this.prijs = prijs;
		this.gewicht = gewicht;
		this.categorie = categorie;
	}

	public int getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}
	
	public double getPrijs(){
		return prijs;
	}
	
	public int getGewicht(){
		return gewicht;
	}

	public Categorie getCategorie(){
		return categorie;
	}
	
	public void setCategorie(Categorie c){
		categorie = c;
	}
	
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
}
