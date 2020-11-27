package entity;

import java.awt.Color;
import java.util.ArrayList;

public class MonPlateau {
	
	private int taille;
	private ArrayList<MaCase> cases;
	private ArrayList<MaLigne> lignes;
	private ArrayList<Extremite> extremites;
	
	public MonPlateau() {//constructeur du plateau
		super();
		
		this.taille = 6;//une seule taille de plateau
		
		this.extremites = new ArrayList<Extremite>(); 
		//génère les extrémités
		
		this.extremites.add(new Extremite(0,0, new MaCouleur(Color.ORANGE)));
		this.extremites.add(new Extremite(0,4, new MaCouleur(Color.ORANGE)));
		this.extremites.add(new Extremite(1,0, new MaCouleur(Color.BLUE)));
		this.extremites.add(new Extremite(0,5, new MaCouleur(Color.BLUE)));
		this.extremites.add(new Extremite(2,0, new MaCouleur(Color.GREEN)));
		this.extremites.add(new Extremite(2,2, new MaCouleur(Color.GREEN)));
		this.extremites.add(new Extremite(4,0, new MaCouleur(Color.YELLOW)));
		this.extremites.add(new Extremite(2,3, new MaCouleur(Color.YELLOW)));
		this.extremites.add(new Extremite(5,0, new MaCouleur(Color.RED)));
		this.extremites.add(new Extremite(2,5, new MaCouleur(Color.RED)));
		this.extremites.add(new Extremite(4,1, new MaCouleur(Color.CYAN)));
		this.extremites.add(new Extremite(2,4, new MaCouleur(Color.CYAN)));
		
		this.cases = new ArrayList<MaCase>();
		//génère les cases du plateau
		
		for(int i=0; i < taille; i++) {
			for(int j=0; j < taille; j++) {
				
				MaCase newCase = new MaCase(i,j);
				//pour chacune des taille^2 case
				//on veut savoir si c'est une extrémité pour savoir quelle couleur lui affecter 
								
				for(int e=0; e<this.extremites.size(); e++) {
					
					Extremite extremite = extremites.get(e);
					//on parcourt la liste des extrémités
					
					if (extremite.getX()==i && extremite.getY()==j) { 
						//s'il existe une extrémité à la position i,j
						//on change la couleur de la case de la couleur de l'extrémité
						newCase.setMaCouleur(extremite.getMaCouleur());
						}
					
					//sinon la couleur de la case est toujours noire
				}
			
				this.cases.add(newCase);//on la rajoute à la fin de la liste des cases
				
			}
		}
		
		
		this.lignes = new ArrayList<MaLigne>();
		//pour chaque paire d'extremités on a une liste

		for(int i=0; i<extremites.size(); i+=2) {
			//on parcourt la liste des extrémités deux par deux
			
			//on crée une liste de deux extrémités de même couleur nécessaire à la définition de la ligne
			ArrayList<Extremite> extremiteListe = new ArrayList<Extremite>();
			extremiteListe.add(this.extremites.get(i));
			extremiteListe.add(this.extremites.get(i+1));
			
			//on définit la couleur de la ligne
			MaCouleur couleurListe = this.extremites.get(i).getMaCouleur();		
			
			//on construit la ligne
			lignes.add(new MaLigne(couleurListe, extremiteListe));
		}
	}
	
	public int getTaille() {
		//retourne la taille
		return taille;
	}

	public ArrayList<MaCase> getCases() {
		//retourne la liste des cases
		return this.cases;
	}
	
	public ArrayList<MaLigne> getLignes() {
		//retourne la liste des lignes
		return lignes;
	}

	public ArrayList<Extremite> getExtremites() {
		//retourne la liste des extrémités
		return extremites;
	}
	
	public void SetCouleurCase(int x, int y, MaCouleur couleur) {
		//modifie la couleur de la case à la position x, y
		
		int indice = this.taille*x+y; // indice de la case dans la liste des cases du plateau 
		MaCase maCase = this.cases.get(indice); // case à modifier
		maCase.setMaCouleur(couleur); //on modifie la couleur de la case
		this.cases.set(indice, maCase); // on remet la case modifiée dans l'ensemble des cases
	}

	public double nbreCasesColoriées() {
		// TODO Auto-generated method stub
		
		double nbcasescoloriees = 0.0;
		
		//on compte le nombre de cases de couleur
		//on sort un double puisque cette méthode est utilisée pour une division
		
		for (MaCase maCase : cases) {
			//Pour chaque case du plateau
		
			if (!maCase.getMaCouleur().getmaCouleur().equals(Color.BLACK)) {
				//si elle est coloriée
				//on incrémente le compteur
				
				nbcasescoloriees++;
			}
		}
		return nbcasescoloriees;
	}

	

}
