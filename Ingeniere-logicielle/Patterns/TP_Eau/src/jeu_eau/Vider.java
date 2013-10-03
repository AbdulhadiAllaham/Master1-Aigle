package jeu_eau;

public class Vider implements Command{

	Bidon bidon;
	

	
	public Vider(Bidon bid){
		this.bidon=bid;
		
	}
	
	@Override
	public void execute() {
		
		bidon.toVider();
		// TODO Auto-generated method stub
		
	}

}
