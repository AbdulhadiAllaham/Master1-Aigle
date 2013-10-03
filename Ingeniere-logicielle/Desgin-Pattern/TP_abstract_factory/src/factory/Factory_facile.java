package factory;

public class Factory_facile extends Abstract_Factory{

	
	
	public Factory_facile(){
		System.out.println("Vous avez choisi le niveau facile");
		
	}
	@Override
	public Alphabet creerAlphabet() {
		// TODO Auto-generated method stub
		return new Alphabet_symbole();
	}

	@Override
	public Gestionnaire creerGestionnaire() {
		// TODO Auto-generated method stub
		return new Gestionnaire_guide();
	}



}
