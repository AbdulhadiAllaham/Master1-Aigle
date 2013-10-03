package decorator;

public class Jours3 extends State_DVD{
	
	Jours3(Film film){
		super(film);
	}

	@Override
	public void empruntable() {
		System.out.println("a retourner dans 3 jours");
		film.etatcourant=film.listetats.emprunt;
		
	}

	@Override
	public void rendre() {
		// TODO Auto-generated method stub
		
	}

}
