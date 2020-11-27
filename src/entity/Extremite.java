package entity;

public class Extremite {
	
	private int x;
	private int y;
	private MaCouleur maCouleur;
	
	public Extremite(int x, int y, MaCouleur maCouleur) { //constructeur
		this.x = x;
		this.y = y;
		this.maCouleur = maCouleur;
	}
	
	public MaCouleur getMaCouleur() {
		//obtenir la couleur
		return maCouleur;
	}
	
	public int getX() {
		//obtenir l'abscisse
		return this.x;
	}

	public int getY() {
		//obtenir l'ordonnée
		return this.y;
	}
	
	public boolean isEqual(Extremite extremite) {
		//test d'égalité entre deux extrémités
		//sont égales si leur position est la même
		return this.x == extremite.getX() && this.y == extremite.getY();
	}
	
	
	public MaCase toMaCase() { 
		//convertir une extrémité en case
		//on définit la case associée
		MaCase maCase = new MaCase(x,y);
		//on modifie sa couleur
		maCase.setMaCouleur(maCouleur);
		//on retourne cette case modifiée
		return maCase;
		}
	 
	public String toString() {
		//pour les tests
		return "x :"+Integer.toString(x)+" y :"+Integer.toString(y)+" Couleur :"+maCouleur.toString();
	}
}
	