package entity;

import java.awt.Color;

public class MaCaseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaCase maCase = new MaCase(0, 0);
		System.out.println(maCase.toString());
		System.out.println(maCase.getX());
		System.out.println(maCase.getY());
		System.out.println(maCase.getMaCouleur());
		System.out.println(maCase.isEqual(new MaCase(0, 0)));
		System.out.println(maCase.isEqual(new MaCase(1, 0)));
		maCase.setMaCouleur(new MaCouleur(Color.WHITE));
		System.out.println(maCase.toString());
	}

}
