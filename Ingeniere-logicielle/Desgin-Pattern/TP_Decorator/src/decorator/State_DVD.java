package decorator;

public abstract class State_DVD {
	Film film;

	public State_DVD(Film film) {
		this.film = film;
	}

	public abstract void empruntable();
	public abstract void rendre();
	
	
}
