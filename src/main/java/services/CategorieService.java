package services;

import java.util.ArrayList;
import java.util.List;

import persistence.CategorieDao;
import model.Categorie;

public class CategorieService {
	CategorieDao cd = new CategorieDao();
	
	public List<Categorie> getAllCategorieen(){
		return cd.findAll();
	}
	
	private List<Categorie> findChangedCategories(List<Categorie> checkVeranderingen){
		List<Categorie> huidig = cd.findAll();
		List<Categorie> veranderd = new ArrayList<Categorie>();
		for(Categorie c: checkVeranderingen){
			if(!huidig.contains(c)){
				veranderd.add(c);
			}
		}
		return veranderd;
	}
	
	public boolean updateCategories(List<Categorie> checkVeranderingen){
		boolean result = true;
		for(Categorie c: findChangedCategories(checkVeranderingen)){
			result = result && cd.updateCategorie(c);
		}
		return result;
	}
}
