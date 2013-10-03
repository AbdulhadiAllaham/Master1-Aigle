package jeu_eau;

public class Remplir implements Command{
	
	Bidon bidon;

	@Override
	public void execute() {
		bidon.toRemplir();
	}
	
	public Remplir(Bidon bid){
		this.bidon=bid;
		
	}

}
