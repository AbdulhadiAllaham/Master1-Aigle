package generique;

import java.util.HashSet;


public abstract class gSommet<
	Gra extends gGraphe<Gra,Ar,Som>,
	Ar extends gArete<Gra,Ar,Som>, 
	Som extends gSommet<Gra,Ar,Som>> 
	{

	String x, y;
	public Gra gGraphe;
	String nom;
	public HashSet<Ar> ensembleAretes = 
			new HashSet<Ar>();


	
	public gSommet(String x, String y){
		this.x = x;
		this.y = y;
	}

	public gSommet(Gra g, String x, String y){
		gGraphe=g;
		this.x = x;
		this.y = y;
	}


	public void addAretes(Ar gArete){
		this.ensembleAretes.add(gArete);

	}

	@SuppressWarnings("unchecked")
	public void addAretes(Ar gArete, Som gSommet){

		if(this.gGraphe != null && gGraphe == gSommet.gGraphe){

			System.out.println("vérification des graphes ok dans addArretes");
			if((gArete.sommet1!=this && gArete.sommet2!=gSommet)) // test pour voir s'il y a déja une gArete en place
			{

				gArete.removeFromSommets();

				gArete.sommet1=(Som) this;
				if(gSommet != null)
				{
					gArete.sommet2=gSommet;
				}
				ensembleAretes.add(gArete);
				System.out.println("L'gArete a été remplacé et ajouté");
			}
			else
			{
				System.out.println("L'gArete se trouve déjà entre les deux sommets");
			}
		}
		else
		{
			System.out.println("Veuillez vérifier le gGraphe de l'gArete et des sommets");
		}	
	}



	public void removeArete(Ar gArete){
		if(this.ensembleAretes.contains(gArete)){
			this.ensembleAretes.remove(gArete);
		}
		else{
			System.err.println("L'arrete ne se trouve pas au gSommet indiqu�");
		}
	}

	//Getters and setters


	public Gra getGraphe() {
		return gGraphe;
	}

	public void setGraphe(Gra gGraphe) {
		this.gGraphe = gGraphe;
	}



	public HashSet<Ar> getEnsembleArretes() {
		return ensembleAretes;
	}



	public void setEnsembleArretes(HashSet<Ar> ensembleAretes) {
		this.ensembleAretes = ensembleAretes;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getX() {
		return x;
	}


	public void setX(String x) {
		this.x = x;
	}


	public String getY() {
		return y;
	}


	public void setY(String y) {
		this.y = y;
	}


}
