package seminaire;

public class Planification extends Annulable {
	

	Planification(CycleSeminaire c) {
		super(c);
		
		
	}

	

	@Override
	public void Inscription(Adherent ad) {
		System.out.println("Erreur");
		
	}


	@Override
	public void ajoutInscrit(Adherent ad) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void ajoutListeAttente(Adherent ad) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void retirerInscrit(Adherent ad) {
		// TODO Auto-generated method stub
		
	}
	
	public void terminer(){
		cycle.etatCourant=cycle.listetats.termine;
		System.out.println("termine");

	}



	@Override
	public void ouvertureReservation() {
		System.out.println("ouverture reservation");
		cycle.etatCourant=cycle.listetats.placesdispo;
	}

	
}
