package decorator;

public class Emprunte extends State_DVD{

	public Emprunte(Film film) {
		super(film);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void empruntable() {
		System.out.println("deja emprunte");
		
	}

	@Override
	public void rendre() {
		
		System.out.println("Merci d'avoir rendu");
		film.etatcourant=super.film.duree;
		// TODO Auto-generated method stub
		
	}

	

}
