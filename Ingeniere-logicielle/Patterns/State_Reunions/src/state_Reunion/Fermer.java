package state_Reunion;

public class Fermer extends EtatReunion{

	public Fermer(Reunion ren) {
		super(ren);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void donnerparole() {
		System.out.println("Erreur");
	}

	@Override
	public void fermer() {
		System.out.println("Fermeture");
	}

}
