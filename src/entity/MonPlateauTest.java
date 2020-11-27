package entity;

import java.awt.Color;

public class MonPlateauTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MonPlateau monPlateau = new MonPlateau();
		System.out.println(monPlateau.getTaille());
		System.out.println(monPlateau.getCases());
		System.out.println(monPlateau.getExtremites());
		System.out.println(monPlateau.getLignes());
		monPlateau.SetCouleurCase(0, 0, new MaCouleur(Color.BLUE));
		System.out.println(monPlateau.getCases());	
		
	}

}
