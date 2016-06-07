package services;

import java.util.List;

import model.Bezoek;
import persistence.BezoekDao;

public class BezoekService {
	BezoekDao bd = new BezoekDao();
	
	public List<Bezoek> findAll(){
		return bd.findAll();
	}
	
	public List<Bezoek> findBezoekenVanKlant(int klantnummer){
		return bd.getBezoekenVanKlant(klantnummer);
	}
}
