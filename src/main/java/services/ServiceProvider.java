package services;

public class ServiceProvider {
	private static ProductService ps = new ProductService();
	private static CategorieService cs = new CategorieService();
	private static KlantService ks = new KlantService();
	private static BezoekService bs = new BezoekService();
	
	public static ProductService getProductService(){
		return ps;
	}
	
	public static CategorieService getCategorieService(){
		return cs;
	}
	
	public static KlantService getKlantService(){
		return ks;
	}
	
	public static BezoekService getBezoekService(){
		return bs;
	}
}
