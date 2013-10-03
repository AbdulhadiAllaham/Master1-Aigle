package factory;

public class Jeu {

	Alphabet alphabet;
	Gestionnaire gestionnaire;
	
	public Jeu (Abstract_Factory f){
		this.gestionnaire = f.creerGestionnaire();
		this.alphabet = f.creerAlphabet();
	}
	
	
	

}
