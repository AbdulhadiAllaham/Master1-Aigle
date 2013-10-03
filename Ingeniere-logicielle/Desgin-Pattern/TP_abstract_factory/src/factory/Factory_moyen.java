package factory;

public class Factory_moyen extends Abstract_Factory{

	@Override
	public Alphabet creerAlphabet() {
		// TODO Auto-generated method stub
		return new Alphabet_symbole();
	}

	@Override
	public Gestionnaire creerGestionnaire() {
		// TODO Auto-generated method stub
		return new Gestionnaire_nonguide();
	}




}
