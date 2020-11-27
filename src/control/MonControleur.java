package control;

import java.awt.Color;
import java.util.ArrayList;

import entity.*;

public class MonControleur {
	
	private MonPlateau monPlateau;
	private MaLigne LigneActive;
	
	public MonControleur() { //constructeur de MonControleur
		this.monPlateau = new MonPlateau();  //plateau par d�faut
		this.LigneActive = null; //ligne active par d�faut
	}
	
	public int getTaille() {
		return monPlateau.getTaille();
	}
	
	public ArrayList<Extremite> getExtremites(){ 
		//liste des extr�mit�s du plateau 
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
			//la couleur blanche est associ�e � un null
			//on parcourt l'ensemble des lignes du plateau jusqu'� trouver celle qui a la bonne couleur
			
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
		//la case courante est la derni�re case de la ligne active (cf MaLigne) 
		return LigneActive.CaseCourante();
	}
	
	public void AjoutCase(int x, int y) {
		//modifie la case courante en ajoutant une case � la fin de la ligne active
		
		//on cr�e une nouvelle case et lui affecte la couleur de la ligne active
		MaCase maCase = new MaCase(x,y);  
		maCase.setMaCouleur(LigneActive.getMaCouleur());
		
		//on l'empile sur la ligne active
		this.LigneActive.AjoutCase(maCase);
	}
	
	public void SupprimeDerni�reCase() {
		//modifie la case courante en supprimant la derni�re case � la fin de la ligne active
		//des pr�cautions sont prises concernant son utilisation cf MaLigne
		this.LigneActive.SupprimeDerni�reCase();
	}

	public boolean isExtremite(int px, int py) {
		//permet de savoir si on pointe une extr�mit�
		//x et y sont des num�ros de pixels et non pas des indices
		
		boolean isextremite = false;
		
		int x = (int)((px-20)/100);
		int y = (int)((py-50)/100);
		for (Extremite extremite : monPlateau.getExtremites()) {
			//on parcourt les extr�mit�s du plateau
			
			if (extremite.getX()==x) { //+20 : ajout empirique d� � l'�cart sur le c�t� de l'�cran
				if (extremite.getY()==y) {//+50 : ajout empirique d� au titre de la fen�tre
					
					//si le pixel se situe dans le cadre blanc d'une extr�mit� alors on retourne true
					isextremite = true; 
				}
			}
		}
		return isextremite;
	}

	public Extremite getExtremitePointer(int px, int py) {
		// permet de conna�tre l'extr�mit� que l'on pointe avec la souris
		//� n'utiliser que si on sait que l'on pointe une extr�mit�
		//x et y sont des num�ros de pixels et non pas des indices
		
		Extremite extremitePointer = null;
		int x = (int)((px-20)/100);
		int y = (int)((py-50)/100);
		
		for (Extremite extremite : monPlateau.getExtremites()) {
			//on parcourt les extr�mit�s du plateau
			if (extremite.getX()==x) {//+20 : ajout empirique d� � l'�cart sur le c�t� de l'�cran
				if (extremite.getY()==y) {//+50 : ajout empirique d� au titre de la fen�tre
					
					//si le pixel se situe dans le cadre blanc d'une extr�mit� alors on retourne cette extr�mit�
					extremitePointer = extremite;
				}
			}
		}
		
		return extremitePointer;
	}

	public boolean isInLigne(int x, int y) {
		//permet de savoir si une case indic�e par x et y appartient � une ligne (sans en �tre une extr�mit�)
		
		boolean isinligne = false;
		
		for (MaLigne maLigne : monPlateau.getLignes()) {
			//on parcourt les lignes du plateau
			
			for(MaCase maCase : maLigne.getCases()) {
				//on parcourt les cases de cette ligne
				
				if (maCase.getY()==y && maCase.getX()==x) {
					//si les coordonn�es d'entr�es correspondent aux coordonn�es d'une case d'une ligne du plateau
					//on retourne true
					isinligne = true;
					
				}
			}
		}
		return isinligne;
	}

	public MaLigne getLigne(int x, int y) {
		//permet de conna�tre la ligne � laquelle la case indic�e par x et y appartient
		//� n'utiliser que si on sait que la case appartient � une ligne

		MaLigne isLigne = null;

		for (MaLigne maLigne : monPlateau.getLignes()) {
			//on parcourt les lignes du plateau

			for(MaCase maCase : maLigne.getCases()) {
				//on parcourt les cases de cette ligne
				
				if (maCase.getY()==y && maCase.getX()==x) {
					//si les coordonn�es d'entr�es correspondent aux coordonn�es d'une case de cette ligne
					//on retourne la ligne
					isLigne = maLigne;
				
				}
			}
		}
		return isLigne;
	}

	public void SupprimeLigne(MaLigne ligne) {
		//l'utilisateur ne souhaite plus voir la ligne sur l'�cran
		//d�pile toutes les cases de la ligne qui ne sont pas des extr�mit�s
		
		
		for(MaCase maCase : ligne.getCases()) {
			//pour chaque case de la ligne 
			//sa couleur redevient noire sur le plateau
			this.monPlateau.SetCouleurCase(maCase.getX(), maCase.getY(), new MaCouleur(Color.BLACK));
		}
		
		//la ligne ne contient plus que ses extr�mit�s
		ligne.SupprimeLigne();
	}

	public double progression() {
		// TODO Auto-generated method stub
		//on compte le nombre de cases colori�es qui ne sont pas des extr�mit�s
		//on divise ce nombre par le nombre de cases qui ne sont pas des extr�mit�s
		//on l'arrondit au centi�me
		return (double)Math.round((monPlateau.nbreCasesColori�es()-monPlateau.getExtremites().size())/(monPlateau.getTaille()*monPlateau.getTaille()-monPlateau.getExtremites().size())*100)/100;
		
	}

	public boolean verify() {
		
		boolean wrongdisposition = false;
		
		for (MaLigne maLigne : monPlateau.getLignes()) {
			
			//Pour chaque ligne du plateau
			//on v�rifie que la derni�re case de la ligne est voisine de son extr�mit� d'arriv�e
			
			//on r�cup�re les coordonn�es de la derni�re case de la ligne - la case courante
			int xcourant = maLigne.CaseCourante().getX();
			int ycourant =  maLigne.CaseCourante().getY();
			
			//on r�cup�re les coordonn�es de l'extr�mit� d'arriv�e
			int xextremite = maLigne.getExtremites().get(1).getX();
			int yextremite = maLigne.getExtremites().get(1).getY();
			
			
			if ( (Math.abs(xcourant-xextremite)>1 || Math.abs(ycourant-yextremite)>1) || (Math.abs(xcourant-xextremite)==1 && (Math.abs(ycourant-yextremite)==1))) {
				
				//si la case n'est pas voisine ou si elle est situ�e diagonalement � l'extr�mit� d'arriv�e
				//la grille est fausse
				wrongdisposition = true;
			}
		}
		
		return !wrongdisposition;
	}
	

}