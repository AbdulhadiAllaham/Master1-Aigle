package chimie;

import generique.gGraphe;


public class Molecule extends gGraphe<Molecule, Liaison, Atome>{

	public Molecule(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Liaison newAr() {
		// TODO Auto-generated method stub
		return new Liaison();
	}

	@Override
	protected Atome newSom(Molecule g, String x, String y) {
		// TODO Auto-generated method stub
		return new Atome(g,x,y);
	}

	

	

	
	
	

}
