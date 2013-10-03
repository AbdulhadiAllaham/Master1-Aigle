package decorator;

public class ListeEtats {
	
	Jours3 jours3;
	Jours5 jours5;
	Emprunte emprunt;
	
	public ListeEtats(Film film){
		
		jours3 = new Jours3(film);
		jours5 = new Jours5(film);
		emprunt = new Emprunte(film);
	}

}
