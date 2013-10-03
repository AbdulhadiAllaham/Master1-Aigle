package informatique;

import generique.gGraphe;


public class Reseau extends gGraphe<Reseau, Lien, Noeud>{

	public Reseau(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Lien newAr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Noeud newSom(Reseau g, String x, String y) {
		// TODO Auto-generated method stub
		return new Noeud(g,x,y);
	}

	
	
	

}
