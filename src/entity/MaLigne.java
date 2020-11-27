package entity;

import java.util.ArrayList;

public class MaLigne {
	
	private MaCouleur maCouleur;
	private ArrayList<Extremite> extremites; // Premier élément de extremites : extrémité de départ. Deuxième élément : extrémité d'arrivée
	private ArrayList<MaCase> cases;
	
	public MaLigne(MaCouleur maCouleur, ArrayList<Extremite> extremites) {//constructeur

		this.maCouleur = maCouleur;
		this.extremites = extremites;
		this.cases = new ArrayList<MaCase>() ; //pile de cases initialement vide
		
	}
	
	public MaCouleur getMaCouleur() {
		//obtenir la couleur
		return maCouleur;
	}

	public ArrayList<Extremite> getExtremites() {
		//obtenir la liste d'extrémités
		return extremites;
	}
	
	public ArrayList<MaCase> getCases() {
		//obtenir la liste des cases en-dehors des extrémités
		return cases;
	}
	
	public MaCase CaseCourante(){
		
		if(this.cases.size()>0) {
			//obtenir la dernière case de la pile de cases si celle-ci n'est pas vide
			return this.cases.get(this.cases.size()-1);
		}
		else {
			//si la pile de cases est vide
			//obtenir l'extrémité de départ
			return this.extremites.get(0).toMaCase();
		}
	}
	
	public void AjoutCase(MaCase maCase) {
		//ajout d'une case dans la pile de cases
		this.cases.add(maCase);
	}
	
	public void SupprimeDernièreCase() {
		//enlève la case du dessus de la pile de cases si elle n'est pas vide
		if(cases.size()>0) {
			this.cases.remove(this.cases.size()-1);
		}
	}
	
	public void SupprimeLigne() {
		//on remet la pile à zéro
		this.cases = new ArrayList<MaCase>();
	}
		
	
	public void ExtrémitéDépart(Extremite extremitedepart){
		
		//définir une extrémité de départ 
		//si c'est déjà le premier élément de la liste extremites, on n'a rien à faire
		
		if(this.extremites.get(1).isEqual(extremitedepart)) {
			//sinon
			//on permute les deux éléments de la liste extremites
			this.extremites.set(1, this.extremites.get(0));
			this.extremites.set(0, extremitedepart);
			
			//la pile est remise à zéro
			this.cases = new ArrayList<MaCase>();
		}
	}
	public String toString() {
		//test
		String str;
		str = "Extremites :"+extremites.get(0).toString()+extremites.get(1).toString()+"/Cases :";
		for (MaCase maCase : cases) {
			str += maCase.toString();
		}
		return str;
	}
	
}
