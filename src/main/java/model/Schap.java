package model;

public class Schap {
	private int nummer;
	private int gangpad;
	
	public Schap (int nummer){
		this(nummer, 0);
	}
	
	public Schap(int nummer, int gangpad){
		this.nummer = nummer;
		this.gangpad = gangpad;
	}

	public int getNummer() {
		return nummer;
	}

	public int getGangpad() {
		return gangpad;
	}
}
