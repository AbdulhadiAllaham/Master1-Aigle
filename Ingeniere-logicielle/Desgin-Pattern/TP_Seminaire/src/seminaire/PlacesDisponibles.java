package seminaire;

public class PlacesDisponibles extends ReservationOuverte{

	PlacesDisponibles(CycleSeminaire c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ouvertureReservation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Inscription(Adherent ad) {
		if(!cycle.getListeInscrit().contains(ad) && cycle.getCapacite()>cycle.getNbInscrits()){
			System.out.println("OK "+ad.toString()+" inscrit");
			cycle.getListeInscrit().add(ad);	
		}
		
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

	@Override
	public void terminer(){
		cycle.etatCourant=cycle.listetats.termine;
		System.out.println("termine");

	}

	
	
	
	
	
	
}
