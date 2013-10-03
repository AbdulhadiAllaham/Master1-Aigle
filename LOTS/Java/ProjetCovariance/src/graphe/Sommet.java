package graphe;

import java.util.HashSet;

public class Sommet {

	String x, y;
	public Graphe graphe;
	String nom;
	public HashSet<Arete> ensembleAretes = new HashSet<Arete>();

	public Sommet(String x, String y){
		this.x = x;
		this.y = y;
	}

	public Sommet(Graphe graphe, String x, String y){
		this.graphe=graphe;
		this.x = x;
		this.y = y;
		//addSommetToGraphe(graphe);
	}


	public void addAretes(Arete arete){
		this.ensembleAretes.add(arete);
	}

	public void addAretes(Arete arete, Sommet sommet){

		if(this.graphe != null && graphe == sommet.graphe){

			System.out.println("vérification des graphes ok dans addArretes");
			if((arete.sommet1!=this && arete.sommet2!=sommet)) // test pour voir s'il y a déja une arete en place
			{

				arete.removeFromSommets();

				arete.sommet1=this;
				if(sommet != null)
				{
					arete.sommet2=sommet;
				}
				ensembleAretes.add(arete);
				System.out.println("L'arete a été remplacé et ajouté");
			}
			else
			{
				System.out.println("L'arete se trouve déjà entre les deux sommets");
			}
		}
		else
		{
			System.out.println("Veuillez vérifier le graphe de l'arete et des sommets");
		}	
	}


	public void removeArete(Arete arete){
		if(ensembleAretes.remove(arete)){
			System.out.println("L'arete a bien été supprimé");
		}

		else{
			System.err.println("L'arrete ne se trouve pas au sommet indiqué");
		}
	}
	
	public void addSommetToGraphe(Graphe graphe){
		graphe.ensembleSommets.add(this);
	}

	//Getters and setters


	public Graphe getGraphe() {
		return graphe;
	}

	public void setGraphe(Graphe graphe) {
		this.graphe = graphe;
	}



	public HashSet<Arete> getEnsembleArretes() {
		return ensembleAretes;
	}



	public void setEnsembleArretes(HashSet<Arete> ensembleAretes) {
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
