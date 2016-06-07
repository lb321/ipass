package services;

import persistence.KlantDao;

import java.util.List;

import model.Klant;

public class KlantService {
	KlantDao kd = new KlantDao();
	
	public List<Klant> getAlleKlanten(){
		return kd.findAll();
	}
	
	public List<Klant> getAlleBezoeken(){
		return kd.getAllBezoeken();
	}
	
	public Klant getBezoekVanKlant(Klant k){
		return kd.getBezoekenVanKlant(k);
	}
}
