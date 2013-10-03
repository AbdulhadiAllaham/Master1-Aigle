package state_Reunion;

public class ListeEtats {
	
	Plannification planification;
	DonnerParole donnerparole;
	Fermer fermer;
	
	public ListeEtats(Reunion ren){
		planification = new Plannification(ren);
		donnerparole = new DonnerParole(ren);
		fermer = new Fermer(ren);
	}

}
