package graphe;

import java.util.HashSet;

public class Graphe {


	public HashSet<Sommet> ensembleSommets = new HashSet<Sommet>();
	public HashSet<Arete> ensembleAretes = new HashSet<Arete>();
	//Iterator<Arete> itArete = ensembleAretes.iterator();

	String nom;


	public Graphe(String nom){
		this.nom = nom;
	}


	public void addSommet(Sommet sommet){
		ensembleSommets.add(sommet);
		System.out.println("Ajout Sommet ok");
	}

	public void addArete(Arete arete)
	{
		if(this.ensembleSommets.isEmpty())
		{
			System.err.println("Le graphe ne comporte pas de sommets");
		}
		if((this.ensembleSommets.contains(arete.getSommet1()) && this.ensembleSommets.contains(arete.getSommet2())))
		{
			System.out.println("L'arrete a les memes sommets que le graphe");
			this.ensembleAretes.add(arete);
			arete.setGraphe(this);
		}
		else
		{
			System.err.println("Le graphe n'a pas les meme sommets que l'arrete");
		}
	}

	public void removeSommet(Sommet sommet)
	{
		if(ensembleSommets.remove(sommet))
		{
			System.out.println("Sommet ("+sommet.getX()+","+sommet.getY() +") suppression dans removeSommet");
			for(Arete ar:ensembleAretes)
			{
				if(ar.getSommet1().equals(sommet) || ar.getSommet2().equals(sommet))
				{
					ensembleAretes.remove(ar);
					System.out.println("Une arrete a été supprimée");
				}
			}
		}
		else
		{
			System.err.println("Sommet ("+sommet.getX()+","+sommet.getY()+") ne fait pas partie du graphe "+this.getNom());
		}
	}

	public void removeArete(Arete arete){
		if(this.ensembleAretes.remove(arete)){
			System.out.println("Arete suprrimé "+this.getNom() );
		}
		else{
			System.err.println("Arete ne fait pas partie du graphe "+this.getNom() );
		}
	}


	public boolean invarianceGraphe(){

		for(Arete ar:ensembleAretes){
			if(this != ar.graphe){
				System.err.println("Graphe n'est pas égal à un des graphes des aretes ");
				return false;
			}

		}
		System.out.println("Toutles les arretes ont le bon graphe");
		return true;

	}


	//Getters and setters


	public HashSet<Sommet> getEnsembleSommets() {
		return ensembleSommets;
	}

	public void setEnsembleSommets(HashSet<Sommet> ensembleSommets) {
		this.ensembleSommets = ensembleSommets;
	}

	public HashSet<Arete> getEnsembleAretes() {
		return ensembleAretes;
	}

	public void setEnsembleAretes(HashSet<Arete> ensembleAretes) {
		this.ensembleAretes = ensembleAretes;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void createArete(Sommet sommet1, Sommet sommet2)
	{
		if((sommet1 != null) && (sommet2 != null))
		{
			Arete arete = new Arete(sommet1,sommet2);
			this.addArete(arete);
			System.out.println("Arete a été créé avec succès");
		}
		else
		{
			System.err.println("ARete n'a pas pu être créé car un des sommets est null");
		}

	}






}
