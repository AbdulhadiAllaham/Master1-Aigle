package generique;


import java.util.HashSet;

public abstract class gGraphe
<Gra extends gGraphe<Gra, Ar, Som>, 
Ar extends gArete<Gra, Ar, Som>, 
Som extends gSommet<Gra, Ar, Som>> {

	public HashSet<Ar> ensembleAretes = new HashSet<Ar>();
	public HashSet<Som> ensembleSommets = new HashSet<Som>();
	String nom;

	
	public gGraphe(String nom){
		this.nom = nom;
	}

	public void addSommet(Som sommet){
		ensembleSommets.add(sommet);
		System.out.println("Ajout du sommet ok");
	}

	@SuppressWarnings("unchecked")
	public void addArete(Ar arete)
	{
		if(this.ensembleSommets.isEmpty())
		{
			System.err.println("Le graphe ne comporte pas de sommets");
		}
		if((this.ensembleSommets.contains(arete.getSommet1()) && this.ensembleSommets.contains(arete.getSommet2())))
		{
			System.out.println("L'arrete a les memes sommets que le graphe");
			this.ensembleAretes.add(arete);
			arete.setGraphe((Gra) this);
		}
		else
		{
			System.err.println("Le graphe n'a pas les meme sommets que l'arrete");
		}
	}

	public void removeSommet(Som sommet)
	{
		if(ensembleSommets.remove(sommet))
		{
			System.out.println("Sommet ("+sommet.getX()+","+sommet.getY() +") suppression dans removeSommet");
			for(gArete<Gra, Ar, Som> ar:ensembleAretes)
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

	public void removeArete(Ar arete){
		if(this.ensembleSommets.remove(arete)){
			System.out.println("Arete suprrimé "+this.getNom() );
		}
		else{
			System.err.println("Arete ne fait pas partie du graphe "+this.getNom() );
		}
	}
	
	
	public boolean invarianceGraphe(){

		for(gArete<Gra, Ar, Som> ar:ensembleAretes){
			if(this != ar.gGraphe){
				System.err.println("Graphe n'est pas égal à un des graphes des aretes ");
				return false;
			}

		}
		System.out.println("Toutles les arretes ont le bon graphe");
		return true;

	}
	
	
	//Getters and setters


	public HashSet<Som> getEnsembleSommets() {
		return ensembleSommets;
	}

	public void setEnsembleSommets(HashSet<Som> ensembleSommets) {
		this.ensembleSommets = ensembleSommets;
	}

	public HashSet<Ar> getEnsembleAretes() {
		return ensembleAretes;
	}

	public void setEnsembleAretes(HashSet<Ar> ensembleAretes) {
		this.ensembleAretes = ensembleAretes;
	}

	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void createArete(Som sommet1, Som sommet2)
	{
		if((sommet1 != null) && (sommet2 != null))
		{
			//gArete<Gra, Ar, Som> arete;
			this.addArete(newAr());
			System.out.println("Arete a été créé avec succès");
		}
		else
		{
			System.err.println("Arete n'a pas pu être créé car un des sommets est null");
		}
	
	}
	
	@SuppressWarnings("unchecked")
	public void createSommet(String x, String y){
		
		this.addSommet(newSom((Gra) this,x,y));
		System.out.println("Sommet a été créé avec succès");
	}
	
	protected abstract Ar newAr();
	protected abstract Som newSom(Gra g, String x, String y);
	

}
