package entity;

import java.awt.Color;


public class MaCase {
	
	private int x;
	private int y;
	private MaCouleur maCouleur;
	
	public MaCase(int x, int y) {//constructeur
		super();
		this.x = x;
		this.y = y;
		this.maCouleur = new MaCouleur(Color.BLACK);
	}

	public MaCouleur getMaCouleur() {
		//obtenir la couleur
		return maCouleur;
	}

	public void setMaCouleur(MaCouleur maCouleur) {
		//modifier la couleur
		this.maCouleur = maCouleur;
	}

	public int getX() {
		//obtenir l'abscisse
		return x;
	}

	public int getY() {
		//obtenir l'ordonnée
		return y;
	}
	
	public boolean isEqual(MaCase maCase) {
		//tester l'égalité
		//deux cases égales si leur position est identique
		return this.x == maCase.getX() && this.y == maCase.getY();
	}
	
	public String toString() {
		//test
		return "x :"+Integer.toString(x)+" y :"+Integer.toString(y)+" Couleur :"+maCouleur.toString();
	}
	
}
