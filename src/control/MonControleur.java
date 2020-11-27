package control;

import java.awt.Color;
import java.util.ArrayList;

import entity.*;

public class MonControleur {
	
	private MonPlateau monPlateau;
	private MaLigne LigneActive;
	
	public MonControleur() { //constructeur de MonControleur
		this.monPlateau = new MonPlateau();  //plateau par défaut
		this.LigneActive = null; //ligne active par défaut
	}
	
	public int getTaille() {
		return monPlateau.getTaille();
	}
	
	public ArrayList<Extremite> getExtremites(){ 
		//liste des extrémités du plateau 
		return this.monPlateau.getExtremites();
	}
	
	public ArrayList<MaCase> getCases() {
		//liste des cases du plateau
		//ce que l'on entend par plateau
		return this.monPlateau.getCases();		
	}
	
	public void SetCouleurCase(int x, int y, Color couleur) {
		//modifie la couleur d'une case du plateau
		this.monPlateau.SetCouleurCase(x, y, new MaCouleur(couleur));
	}
	
	public ArrayList<MaLigne> getLignes(){
		//liste des lignes du plateau
		return this.monPlateau.getLignes();
	}

	public MaLigne getLigneActive() {
		//retourne la ligne active
		return LigneActive;
	}

	public void setLigneActive(Color couleur) {
		//modifie la ligne active en fonction de la couleur
		//chaque ligne a une couleur unique
		
		if (!couleur.equals(Color.WHITE)) {
			//la couleur blanche est associée à un null
			//on parcourt l'ensemble des lignes du plateau jusqu'à trouver celle qui a la bonne couleur
			
			for (MaLigne Ligne : monPlateau.getLignes()) {
				if(Ligne.getMaCouleur().getmaCouleur().equals(couleur)) {
					this.LigneActive = Ligne; //la ligne avec la bonne couleur devient la ligne active
				}
			}	
		}
		
		else {
			//la ligne est null
			this.LigneActive=null;
		}
	}
	
	public MaCouleur getMaCouleur() {
		//la couleur "courante" est la couleur de la ligne active
		if (LigneActive != null)
			{return LigneActive.getMaCouleur();}
		else {
			return new MaCouleur(Color.BLACK);
		}
	}
	
	public MaCase getCaseCourante() {
		//la case courante est la dernière case de la ligne active (cf MaLigne) 
		return LigneActive.CaseCourante();
	}
	
	public void AjoutCase(int x, int y) {
		//modifie la case courante en ajoutant une case à la fin de la ligne active
		
		//on crée une nouvelle case et lui affecte la couleur de la ligne active
		MaCase maCase = new MaCase(x,y);  
		maCase.setMaCouleur(LigneActive.getMaCouleur());
		
		//on l'empile sur la ligne active
		this.LigneActive.AjoutCase(maCase);
	}
	
	public void SupprimeDernièreCase() {
		//modifie la case courante en supprimant la dernière case à la fin de la ligne active
		//des précautions sont prises concernant son utilisation cf MaLigne
		this.LigneActive.SupprimeDernièreCase();
	}

	public boolean isExtremite(int px, int py) {
		//permet de savoir si on pointe une extrémité
		//x et y sont des numéros de pixels et non pas des indices
		
		boolean isextremite = false;
		
		int x = (int)((px-20)/100);
		int y = (int)((py-50)/100);
		for (Extremite extremite : monPlateau.getExtremites()) {
			//on parcourt les extrémités du plateau
			
			if (extremite.getX()==x) { //+20 : ajout empirique dû à l'écart sur le côté de l'écran
				if (extremite.getY()==y) {//+50 : ajout empirique dû au titre de la fenêtre
					
					//si le pixel se situe dans le cadre blanc d'une extrémité alors on retourne true
					isextremite = true; 
				}
			}
		}
		return isextremite;
	}

	public Extremite getExtremitePointer(int px, int py) {
		// permet de connaître l'extrémité que l'on pointe avec la souris
		//à n'utiliser que si on sait que l'on pointe une extrémité
		//x et y sont des numéros de pixels et non pas des indices
		
		Extremite extremitePointer = null;
		int x = (int)((px-20)/100);
		int y = (int)((py-50)/100);
		
		for (Extremite extremite : monPlateau.getExtremites()) {
			//on parcourt les extrémités du plateau
			if (extremite.getX()==x) {//+20 : ajout empirique dû à l'écart sur le côté de l'écran
				if (extremite.getY()==y) {//+50 : ajout empirique dû au titre de la fenêtre
					
					//si le pixel se situe dans le cadre blanc d'une extrémité alors on retourne cette extrémité
					extremitePointer = extremite;
				}
			}
		}
		
		return extremitePointer;
	}

	public boolean isInLigne(int x, int y) {
		//permet de savoir si une case indicée par x et y appartient à une ligne (sans en être une extrémité)
		
		boolean isinligne = false;
		
		for (MaLigne maLigne : monPlateau.getLignes()) {
			//on parcourt les lignes du plateau
			
			for(MaCase maCase : maLigne.getCases()) {
				//on parcourt les cases de cette ligne
				
				if (maCase.getY()==y && maCase.getX()==x) {
					//si les coordonnées d'entrées correspondent aux coordonnées d'une case d'une ligne du plateau
					//on retourne true
					isinligne = true;
					
				}
			}
		}
		return isinligne;
	}

	public MaLigne getLigne(int x, int y) {
		//permet de connaître la ligne à laquelle la case indicée par x et y appartient
		//à n'utiliser que si on sait que la case appartient à une ligne

		MaLigne isLigne = null;

		for (MaLigne maLigne : monPlateau.getLignes()) {
			//on parcourt les lignes du plateau

			for(MaCase maCase : maLigne.getCases()) {
				//on parcourt les cases de cette ligne
				
				if (maCase.getY()==y && maCase.getX()==x) {
					//si les coordonnées d'entrées correspondent aux coordonnées d'une case de cette ligne
					//on retourne la ligne
					isLigne = maLigne;
				
				}
			}
		}
		return isLigne;
	}

	public void SupprimeLigne(MaLigne ligne) {
		//l'utilisateur ne souhaite plus voir la ligne sur l'écran
		//dépile toutes les cases de la ligne qui ne sont pas des extrémités
		
		
		for(MaCase maCase : ligne.getCases()) {
			//pour chaque case de la ligne 
			//sa couleur redevient noire sur le plateau
			this.monPlateau.SetCouleurCase(maCase.getX(), maCase.getY(), new MaCouleur(Color.BLACK));
		}
		
		//la ligne ne contient plus que ses extrémités
		ligne.SupprimeLigne();
	}

	public double progression() {
		// TODO Auto-generated method stub
		//on compte le nombre de cases coloriées qui ne sont pas des extrémités
		//on divise ce nombre par le nombre de cases qui ne sont pas des extrémités
		//on l'arrondit au centième
		return (double)Math.round((monPlateau.nbreCasesColoriées()-monPlateau.getExtremites().size())/(monPlateau.getTaille()*monPlateau.getTaille()-monPlateau.getExtremites().size())*100)/100;
		
	}

	public boolean verify() {
		
		boolean wrongdisposition = false;
		
		for (MaLigne maLigne : monPlateau.getLignes()) {
			
			//Pour chaque ligne du plateau
			//on vérifie que la dernière case de la ligne est voisine de son extrémité d'arrivée
			
			//on récupère les coordonnées de la dernière case de la ligne - la case courante
			int xcourant = maLigne.CaseCourante().getX();
			int ycourant =  maLigne.CaseCourante().getY();
			
			//on récupère les coordonnées de l'extrémité d'arrivée
			int xextremite = maLigne.getExtremites().get(1).getX();
			int yextremite = maLigne.getExtremites().get(1).getY();
			
			
			if ( (Math.abs(xcourant-xextremite)>1 || Math.abs(ycourant-yextremite)>1) || (Math.abs(xcourant-xextremite)==1 && (Math.abs(ycourant-yextremite)==1))) {
				
				//si la case n'est pas voisine ou si elle est située diagonalement à l'extrémité d'arrivée
				//la grille est fausse
				wrongdisposition = true;
			}
		}
		
		return !wrongdisposition;
	}
	

}