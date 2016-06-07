package model;

import java.util.ArrayList;

public class Klant {
	private int kaartnummer;
	private ArrayList<Bezoek> bezoeken = new ArrayList<Bezoek>();
	
	public Klant(int kaartnummer){
		this.kaartnummer = kaartnummer;
	}
	
	public int getKaartnummer(){
		return kaartnummer;
	}
	
	public void voegBezoekToe(Bezoek b){
		bezoeken.add(b);
	}
	
	public ArrayList<Bezoek> getBezoeken(){
		return bezoeken;
	}
}
