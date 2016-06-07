package model;

public class Categorie {
	private String naam;
	private Schap schap;
	
	public Categorie(String naam, Schap schap){
		this.naam = naam;
		this.schap = schap;
	}
	
	public String getNaam(){
		return naam;
	}
	
	public Schap getSchap(){
		return schap;
	}
	
	public void setSchap(Schap p){
		schap = p;
	}
	
	@Override
	public boolean equals(Object other){
		boolean result = other != null;
		result = result && other instanceof Categorie;
		result = result && ((Categorie) other).getNaam().equals(naam);
		result = result && ((Categorie) other).getSchap().getNummer() == schap.getNummer();
		return result;
	}
}
