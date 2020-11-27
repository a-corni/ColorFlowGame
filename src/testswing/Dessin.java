package testswing;

import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;

public class Dessin extends JPanel {

	private Color maCouleur;
	
	public Dessin () {	
			this.maCouleur = Color.WHITE;
	}
	
	@Override
	public void paint(Graphics g) { //g est le crayon
		g.setColor(this.maCouleur);
		g.fillRect(0,0,6000,6000);
		g.setColor(Color.BLACK);
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				g.drawRect(i*80+20, j*80+20, 80, 80);
			}
		}
	}
	
	public void setColor (Color newColor) {
		this.maCouleur = newColor;
	}
	
	public void paintSquare(Graphics g, int NumberCase_x, int NumberCase_y) {
		g.setColor(this.maCouleur);
		g.fillRect(NumberCase_x*60, NumberCase_y*60, 60, 60);	
	}

}
