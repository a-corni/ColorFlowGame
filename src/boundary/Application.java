package boundary;

import control.MonControleur;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MonControleur monControleur = new MonControleur();
		MonAfficheur monAfficheur = new MonAfficheur(monControleur);
		MaFenetre maFenetre = new MaFenetre(monAfficheur);
		//System.out.println(monControleur.ExtremitetoString());
		//System.out.println(monControleur.getExtremites().get(0).toMaCase().toString());
		//System.out.println(monAfficheur.getPointer(20, 50));
	}
}
