package general;



public class Graphe extends generique.gGraphe<Graphe, Arete, Sommet> {

	public Graphe(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Arete newAr() {
		// TODO Auto-generated method stub
		return new Arete();
	}

	@Override
	protected Sommet newSom(Graphe gra, String x, String y) {
		// TODO Auto-generated method stub
		return new Sommet(this,x,y);
	}

	
	

}
