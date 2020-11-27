package control;

import java.awt.Color;

import entity.MaCouleur;

public class MonControleurTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MonControleur monControleur = new MonControleur();
		System.out.println(monControleur.getTaille());
		System.out.println(monControleur.getExtremites());
		
		System.out.println("Situation initiale de la grille");
		System.out.println(monControleur.getCases());
		System.out.println("La première case devient bleue");
		monControleur.SetCouleurCase(0, 0, Color.BLUE);
		System.out.println(monControleur.getCases());
		System.out.println("La première case redevient orange");
		monControleur.SetCouleurCase(0, 0, Color.ORANGE);
		
		System.out.println(monControleur.getLignes());
		
		System.out.println("Ma Ligne active initiale");
		System.out.println(monControleur.getLigneActive());
		System.out.println("Couleur de la ligne active");
		System.out.println(monControleur.getMaCouleur());
		
		System.out.println("Ma Ligne Active est orange");
		monControleur.setLigneActive(Color.ORANGE);
		System.out.println(monControleur.getLigneActive());
		System.out.println("Couleur de la ligne active");
		System.out.println(monControleur.getMaCouleur());

		
		System.out.println("Ma Case courante initiale");
		System.out.println(monControleur.getCaseCourante());
		monControleur.AjoutCase(1, 0);
		System.out.println("Ma nouvelle case courante");
		System.out.println(monControleur.getCaseCourante());

		System.out.println("La case (1,0) est une extrémité ? (non)");
		System.out.println(monControleur.isExtremite(1,0));
		System.out.println("La case (0,0) est une extrémité ?  (oui)");
		System.out.println(monControleur.isExtremite(0,0));
		System.out.println("La case (0,0) l'extrémité : ");
		System.out.println(monControleur.getExtremitePointer(0,0));
		
		System.out.println("La case (3,3) est dans une ligne ?(non)");
		System.out.println(monControleur.isInLigne(3, 3));
		System.out.println("La case(0,0) est dans une ligne ?(non car c'est une extrémité)");
		System.out.println(monControleur.isInLigne(0, 0));
		System.out.println("La case(1,0) est dans une ligne ?(oui)");
		System.out.println(monControleur.isInLigne(1, 0));

	}

}
