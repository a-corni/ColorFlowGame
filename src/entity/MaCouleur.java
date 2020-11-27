package entity;

import java.awt.Color;

public class MaCouleur {
	
	private Color maCouleur;

	public MaCouleur(Color couleur) {//constructeur
		this.maCouleur = couleur;
	}

	public Color getmaCouleur() {
		//obtenir la couleur
		return maCouleur;
	}

	public void setmaCouleur(Color couleur) {
		//modifier la couleur
		this.maCouleur = couleur;
	}
	
	public String toString() {
		//test
		return maCouleur.toString();
	}
	
}
