package state_Reunion;

public class Reunion {
	
	EtatReunion etatcourant;
	ListeEtats listetats;
	
	
	public Reunion(){
		
		listetats = new ListeEtats(this);
		etatcourant = listetats.planification;
		
	}
	
	
	public void donnerParole(){
		etatcourant.donnerparole();
	}
	
	public void fermer(){
		etatcourant.fermer();
	}
	

}
