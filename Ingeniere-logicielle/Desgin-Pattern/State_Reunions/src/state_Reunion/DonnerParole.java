package state_Reunion;

public class DonnerParole extends EtatReunion{

	public DonnerParole(Reunion ren) {
		super(ren);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void donnerparole() {
		System.out.println("error");
		
	}

	@Override
	public void fermer() {
		System.out.println("On ferme");
		reunion.etatcourant =reunion.listetats.fermer;
	}
	
	

}
