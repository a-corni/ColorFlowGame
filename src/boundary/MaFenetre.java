package boundary;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MaFenetre extends JFrame implements KeyListener, MouseListener{

	private MonAfficheur monAfficheur;

	public MaFenetre(MonAfficheur afficheur) { //constructeur de MaFenetre
		
		this.setPreferredSize(new Dimension(820,650)); //taille de la fenetre (prend en c
		this.setTitle("ColorFlow"); //titre de l'application
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ferme la fenêtre quand on clique sur la croix
		
		this.monAfficheur = afficheur;
		this.add(this.monAfficheur);//dessine ce qui est à afficher sur la fenêtre
		
		this.addKeyListener(this); //entrée clavier
		this.addMouseListener(this);//entrée souris
		this.pack();
		
		this.setVisible(true);//affiche la fenêtre
			
	}

		@Override
		public void keyPressed(KeyEvent e) {
			//lorsque l'on appuie sur la touche
			if(e.getKeyCode()==40) {//down
				monAfficheur.down();
			}
			else if(e.getKeyCode()==38) {//up
				monAfficheur.up();
			}
			else if(e.getKeyCode()==37) {//left
				monAfficheur.left();
			}
			else if(e.getKeyCode()==39) {//down
				monAfficheur.right();
			}
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			//lorsque l'on clique sur la souris
			//on récupère les coordonnées de la souris et on les envoie à l'afficheur
			this.monAfficheur.getPointer(arg0.getX(), arg0.getY());
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

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
}
