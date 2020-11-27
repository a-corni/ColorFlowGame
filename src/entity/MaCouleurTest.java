package entity;

import java.awt.Color;

public class MaCouleurTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaCouleur maCouleur = new MaCouleur(Color.WHITE);
		System.out.println(maCouleur.toString());
		System.out.println(maCouleur.getmaCouleur());
		maCouleur.setmaCouleur(Color.WHITE);
		System.out.println(maCouleur.toString());
	}
}
