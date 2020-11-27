package entity;

import java.util.ArrayList;

public class MaLigne {
	
	private MaCouleur maCouleur;
	private ArrayList<Extremite> extremites; // Premier �l�ment de extremites : extr�mit� de d�part. Deuxi�me �l�ment : extr�mit� d'arriv�e
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
		//obtenir la liste d'extr�mit�s
		return extremites;
	}
	
	public ArrayList<MaCase> getCases() {
		//obtenir la liste des cases en-dehors des extr�mit�s
		return cases;
	}
	
	public MaCase CaseCourante(){
		
		if(this.cases.size()>0) {
			//obtenir la derni�re case de la pile de cases si celle-ci n'est pas vide
			return this.cases.get(this.cases.size()-1);
		}
		else {
			//si la pile de cases est vide
			//obtenir l'extr�mit� de d�part
			return this.extremites.get(0).toMaCase();
		}
	}
	
	public void AjoutCase(MaCase maCase) {
		//ajout d'une case dans la pile de cases
		this.cases.add(maCase);
	}
	
	public void SupprimeDerni�reCase() {
		//enl�ve la case du dessus de la pile de cases si elle n'est pas vide
		if(cases.size()>0) {
			this.cases.remove(this.cases.size()-1);
		}
	}
	
	public void SupprimeLigne() {
		//on remet la pile � z�ro
		this.cases = new ArrayList<MaCase>();
	}
		
	
	public void Extr�mit�D�part(Extremite extremitedepart){
		
		//d�finir une extr�mit� de d�part 
		//si c'est d�j� le premier �l�ment de la liste extremites, on n'a rien � faire
		
		if(this.extremites.get(1).isEqual(extremitedepart)) {
			//sinon
			//on permute les deux �l�ments de la liste extremites
			this.extremites.set(1, this.extremites.get(0));
			this.extremites.set(0, extremitedepart);
			
			//la pile est remise � z�ro
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
