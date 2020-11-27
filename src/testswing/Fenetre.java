package testswing;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Fenetre extends JFrame implements KeyListener, MouseListener{

	private Dessin monDessin;

	public Fenetre(Dessin dessin) {
		
		this.setPreferredSize(new Dimension(3600,3600)); //modifie la taille de la fenetre
		this.setTitle("ColorFlow"); //modifie le titre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ferme la fenêtre quand on clique sur la croix
		
		this.monDessin = dessin;
		this.add(this.monDessin);
		
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.pack();
		
		this.setVisible(true);
			
	}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}
