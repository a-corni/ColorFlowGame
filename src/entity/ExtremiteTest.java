package entity;

import java.awt.Color;

public class ExtremiteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Extremite extremite = new Extremite(0, 0, new MaCouleur(Color.BLACK));
		System.out.println(extremite.toString());
		System.out.println(extremite.getX());
		System.out.println(extremite.getY());
		System.out.println(extremite.getMaCouleur());
		System.out.println(extremite.toMaCase());
		System.out.println(extremite.isEqual(new Extremite(0, 0,new MaCouleur(Color.WHITE))));
		System.out.println(extremite.isEqual(new Extremite(1, 0,new MaCouleur(Color.BLACK))));
		}
}
