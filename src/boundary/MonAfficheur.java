package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import control.*;

public class MonAfficheur extends JPanel {
	
	private MonControleur monControleur;
	
	
	public MonAfficheur (MonControleur controleur) { //constructeur de MonAfficheur
			this.monControleur = controleur; 
	}
	
	public void paint(Graphics g) { //g est le crayon
		
		for (int i=0;i<monControleur.getTaille()*monControleur.getTaille();i++) { 
			// on parcourt les cases du plateau. 
			//Pour chaque case on construit un carré de sa couleur de taille 100 pixels x 100 pixels entouré d'un cadre blanc de même taille
			
			g.setColor(monControleur.getCases().get(i).getMaCouleur().getmaCouleur());
			g.fillRect(monControleur.getCases().get(i).getX()*100, monControleur.getCases().get(i).getY()*100, 100, 100);
			g.setColor(Color.WHITE);
			g.drawRect(monControleur.getCases().get(i).getX()*100, monControleur.getCases().get(i).getY()*100, 100, 100);
		}
		
		//on rajoute des informations à droite de la grille
		//Information sur la couleur de la ligne sélectionnée
		g.setColor(Color.BLACK);
		g.drawString("Couleur de la ligne active",620,50);
		//la couleur en cours de la ligne sélectionnée est affichée dans une case à droite de la grille
		g.setColor(monControleur.getMaCouleur().getmaCouleur());
		g.fillRect(637, 70, 100,100);
		g.setColor(Color.WHITE);
		g.drawRect(637, 70, 100, 100);
		
		//Information sur la progression
		//on l'écrit sur un cadre blanc pour éviter que le texte ne se superpose
		g.fillRect(633, 185, 110, 20);
		g.setColor(Color.BLACK);
		g.drawString("Progression : " + monControleur.progression(),638,200);
		
		//affichage final
		if((int)monControleur.progression()==1 && monControleur.verify()) {
		
			//si chaque case est coloriée et que chaque ligne joint bien les deux extrémités
			//la grille devient blanche
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 620, 650);
			
			//on affiche "Vous avez gagné !" 
			Font fonte = new Font("Arial ",Font.BOLD,100);
			g.setFont(fonte);
			g.setColor(Color.BLACK);
			g.drawString("Vous", 200, 200);
			g.drawString("avez", 210, 300);
			g.drawString("gagné !", 150, 400);
		}
	}

	public void getPointer(int x, int y) {
		
		if(monControleur.isExtremite(x,y)) {
			// si on clique sur une extrémité
			// La ligne active devient celle associée à l'extrémité sélectionnée
			this.monControleur.setLigneActive(monControleur.getExtremitePointer(x, y).getMaCouleur().getmaCouleur());

			if (monControleur.getLigneActive().getExtremites().get(1).isEqual(monControleur.getExtremitePointer(x, y))) {
				//si on a commencé à tracer une ligne de cette couleur mais à partir de l'autre extrémité
				//on la supprime
				//on fait repartir la ligne de l'extrémité sélectionnée
				this.monControleur.SupprimeLigne(monControleur.getLigneActive());
				this.monControleur.getLigneActive().ExtrémitéDépart(monControleur.getExtremitePointer(x, y));
			}
		}
		else {
			//si on a cliqué à côté
			//la ligne active va être redevenir null
			this.monControleur.setLigneActive(Color.WHITE);
		}
		// on reconstruit un nouveau plateau
		this.repaint();
	}
	
	public void down() {
		
		if (monControleur.getLigneActive() != null) {
			
			//si on a sélectionné une extrémité
			//on récupère les coordonnées de la case courante
			int initialx = monControleur.getCaseCourante().getX();
			int initialy = monControleur.getCaseCourante().getY();
			
			//on définit les coordonnées de la case que l'utilisateur a demandé
			int finx = initialx;
			int finy = initialy +1; //on descend d'une position sur l'axe des ordonnés
			
			if (finy<monControleur.getTaille()) {
				//si la case demandée est sur le plateau
				
				if(monControleur.getCases().get(finx*monControleur.getTaille()+finy).isEqual(monControleur.getLigneActive().getExtremites().get(1).toMaCase())) {
					//si la case demandée est l'autre extrémité de la ligne active
					//la case courante est toujours la même
				}
				
				else if (monControleur.getCases().get(finx*monControleur.getTaille()+finy).getMaCouleur().getmaCouleur().equals(monControleur.getMaCouleur().getmaCouleur())) {
					//si la case demandée est déjà de la couleur de la ligne courante
					//on veut faire marche arrière
					this.monControleur.SupprimeDernièreCase();//on supprime la case courante
					this.monControleur.SetCouleurCase(initialx, initialy, Color.BLACK);//on la met noire sur le plateau
				}
				
				else if(monControleur.isExtremite(finx*100+70,finy*100+100)) {
					//si la case demandée est l'extrémité d'une ligne
					//la case courante est toujours la même
				}
				
				else {
					//la case est modifiable
					if(monControleur.isInLigne(finx,finy)) {
						//si elle fait parti d'une ligne (elle a déjà une couleur)
						//on supprime la ligne à laquelle elle appartient
						this.monControleur.SupprimeLigne(monControleur.getLigne(finx,finy));
					}
					
					//on affecte la case à la ligne active (nouvelle case courante)
					//on lui donne la couleur de la ligne active sur le plateau
					this.monControleur.AjoutCase(finx,finy);
					this.monControleur.SetCouleurCase(finx, finy, monControleur.getMaCouleur().getmaCouleur());
				}
			}
			//on construit un nouveau plateau
			this.repaint();
		}
	}

	public void up() {
		
				if (monControleur.getLigneActive() != null) {

					//si on a sélectionné une extrémité
					//on récupère les coordonnées de la case courante
					int initialx = monControleur.getCaseCourante().getX();
					int initialy = monControleur.getCaseCourante().getY();
					
					//on définit les coordonnées de la case que l'utilisateur a demandé
					int finx = initialx;
					int finy = initialy -1; //on remonte sur l'axe des ordonnés
					
					if (finy>=0) {
						//si la case demandée est sur le plateau
						
						if(monControleur.getCases().get(finx*monControleur.getTaille()+finy).isEqual(monControleur.getLigneActive().getExtremites().get(1).toMaCase())) {
							//si la case demandée est l'autre extrémité de la ligne active
							//la case courante est toujours la même
						}
						
						else if (monControleur.getCases().get(finx*monControleur.getTaille()+finy).getMaCouleur().getmaCouleur().equals(monControleur.getMaCouleur().getmaCouleur())) {
							//si la case demandée est déjà de la couleur de la ligne courante
							//on veut faire marche arrière
							this.monControleur.SupprimeDernièreCase();//on supprime la case courante
							this.monControleur.SetCouleurCase(initialx, initialy, Color.BLACK);//on la met noire sur le plateau
						}
						
						else if(monControleur.isExtremite(finx*100+70,finy*100+100)) {
							//si la case demandée est l'extrémité d'une ligne
							//la case courante est toujours la même
						}
						
						else {
							//la case est modifiable
							if(monControleur.isInLigne(finx,finy)) {
								//si elle fait parti d'une ligne (elle a déjà une couleur)
								//on supprime la ligne à laquelle elle appartient
								this.monControleur.SupprimeLigne(monControleur.getLigne(finx,finy));
							}
							
							//on affecte la case à la ligne active (nouvelle case courante)
							//on lui donne la couleur de la ligne active sur le plateau
							this.monControleur.AjoutCase(finx,finy);
							this.monControleur.SetCouleurCase(finx, finy, monControleur.getMaCouleur().getmaCouleur());
						}
					}
					//on construit un nouveau plateau
					this.repaint();
				}
	}

	public void left() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				if (monControleur.getLigneActive() != null) {
					//si on a sélectionné une extrémité
					//on récupère les coordonnées de la case courante
					int initialx = monControleur.getCaseCourante().getX();
					int initialy = monControleur.getCaseCourante().getY();
					
					//on définit les coordonnées de la case que l'utilisateur a demandé
					int finx = initialx-1;//on se déplace d'un cran sur la gauche de l'axe des abscisses
					int finy = initialy;
					if (finx>=0) {
						//si la case demandée est sur le plateau
						
						if(monControleur.getCases().get(finx*monControleur.getTaille()+finy).isEqual(monControleur.getLigneActive().getExtremites().get(1).toMaCase())) {
							//si la case demandée est l'autre extrémité de la ligne active
							//la case courante est toujours la même
						}
						
						else if (monControleur.getCases().get(finx*monControleur.getTaille()+finy).getMaCouleur().getmaCouleur().equals(monControleur.getMaCouleur().getmaCouleur())) {
							//si la case demandée est déjà de la couleur de la ligne courante
							//on veut faire marche arrière
							this.monControleur.SupprimeDernièreCase();//on supprime la case courante
							this.monControleur.SetCouleurCase(initialx, initialy, Color.BLACK);//on la met noire sur le plateau
						}
						
						else if(monControleur.isExtremite(finx*100+70,finy*100+100)) {
							//si la case demandée est l'extrémité d'une ligne
							//la case courante est toujours la même
						}
						
						else {
							//la case est modifiable
							if(monControleur.isInLigne(finx,finy)) {
								//si elle fait parti d'une ligne (elle a déjà une couleur)
								//on supprime la ligne à laquelle elle appartient
								this.monControleur.SupprimeLigne(monControleur.getLigne(finx,finy));
							}
							
							//on affecte la case à la ligne active (nouvelle case courante)
							//on lui donne la couleur de la ligne active sur le plateau
							this.monControleur.AjoutCase(finx,finy);
							this.monControleur.SetCouleurCase(finx, finy, monControleur.getMaCouleur().getmaCouleur());
						}
					}
					//on construit un nouveau plateau
					this.repaint();
				}
	}

	public void right() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				if (monControleur.getLigneActive() != null) {
					//si on a sélectionné une extrémité
					//on récupère les coordonnées de la case courante
					int initialx = monControleur.getCaseCourante().getX();
					int initialy = monControleur.getCaseCourante().getY();
					
					//on définit les coordonnées de la case que l'utilisateur a demandé
					int finx = initialx+1;//on se déplace d'un cran sur la droite de l'axe des abscisses
					int finy = initialy;
					if (finx<monControleur.getTaille()) {
						//si la case demandée est sur le plateau
						
						if(monControleur.getCases().get(finx*monControleur.getTaille()+finy).isEqual(monControleur.getLigneActive().getExtremites().get(1).toMaCase())) {
							//si la case demandée est l'autre extrémité de la ligne active
							//la case courante est toujours la même
						}
						
						else if (monControleur.getCases().get(finx*monControleur.getTaille()+finy).getMaCouleur().getmaCouleur().equals(monControleur.getMaCouleur().getmaCouleur())) {
							//si la case demandée est déjà de la couleur de la ligne courante
							//on veut faire marche arrière
							this.monControleur.SupprimeDernièreCase();//on supprime la case courante
							this.monControleur.SetCouleurCase(initialx, initialy, Color.BLACK);//on la met noire sur le plateau
						}
						
						else if(monControleur.isExtremite(finx*100+70,finy*100+100)) {
							//si la case demandée est l'extrémité d'une ligne
							//la case courante est toujours la même
						}
						
						else {
							//la case est modifiable
							if(monControleur.isInLigne(finx,finy)) {
								//si elle fait parti d'une ligne (elle a déjà une couleur)
								//on supprime la ligne à laquelle elle appartient
								this.monControleur.SupprimeLigne(monControleur.getLigne(finx,finy));
							}
							
							//on affecte la case à la ligne active (nouvelle case courante)
							//on lui donne la couleur de la ligne active sur le plateau
							this.monControleur.AjoutCase(finx,finy);
							this.monControleur.SetCouleurCase(finx, finy, monControleur.getMaCouleur().getmaCouleur());
						}
					}
					//on construit un nouveau plateau
					this.repaint();
				}
	}

}