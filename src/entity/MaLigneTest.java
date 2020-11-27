package entity;

import java.awt.Color;
import java.util.ArrayList;

public class MaLigneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Extremite> extremite = new ArrayList<Extremite>();
		extremite.add(new Extremite(0, 0, new MaCouleur(Color.BLUE)));
		extremite.add(new Extremite(1, 2, new MaCouleur(Color.BLUE)));
		MaLigne maligne = new MaLigne(new MaCouleur(Color.BLUE), extremite);
		System.out.println(maligne.toString());
		System.out.println(maligne.getExtremites());
		System.out.println(maligne.getMaCouleur());
		System.out.println(maligne.getCases());
		System.out.println(maligne.CaseCourante().toString());
		maligne.AjoutCase(new MaCase(0,1));
		System.out.println(maligne.CaseCourante().toString());
		System.out.println(maligne.getCases());
		maligne.AjoutCase(new MaCase(0,2));
		maligne.SupprimeDernièreCase();
		System.out.println(maligne.CaseCourante().toString());
		System.out.println(maligne.getCases());
		maligne.AjoutCase(new MaCase(0,2));
		maligne.SupprimeLigne();
		System.out.println(maligne.CaseCourante().toString());
		System.out.println(maligne.getCases());
	}

}
