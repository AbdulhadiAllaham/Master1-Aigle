package decorator;


public abstract class Film {

	private String titre;
	public abstract int returnPprix();
	
	State_DVD etatcourant;
	State_DVD duree;
	ListeEtats listetats;

	public Film(String titre){
		this.titre = titre;
		listetats = new ListeEtats(this);
		duree= listetats.jours3;
		etatcourant= duree;
	}
	
	
	public void emprunter(Location fortfait){
		etatcourant.empruntable();
		fortfait.prixFortfait();
	}

	public void rendre(){
		etatcourant.rendre();
	}

	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
}
