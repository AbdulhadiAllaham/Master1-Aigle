package state_Reunion;

public class Plannification extends EtatReunion {

	public Plannification(Reunion ren) {
		super(ren);
		// TODO Auto-generated constructor stub
	}
	
	


	@Override
	public void donnerparole() {
		System.out.println("On dionne la parole");
		reunion.etatcourant = reunion.listetats.donnerparole;		
	}



	@Override
	public void fermer() {
		System.out.println("error");
		
	}

	
	
	

}
