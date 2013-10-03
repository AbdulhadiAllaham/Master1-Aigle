package decorator;

public class Jours5 extends State_DVD{

	public Jours5(Film film) {
		super(film);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void empruntable() {
		System.out.println("a retourner dans 5 jours");
		film.etatcourant=film.listetats.emprunt;
	}

	@Override
	public void rendre() {
		// TODO Auto-generated method stub
		
	}

}
