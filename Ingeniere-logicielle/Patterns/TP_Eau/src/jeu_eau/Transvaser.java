package jeu_eau;

public class Transvaser implements Command{

	Bidon bidon;
	Bidon bidon2;



	public Transvaser(Bidon bid, Bidon bid2){
		this.bidon=bid;
		this.bidon2=bid2;
		
	}
	
	@Override
	public void execute() {
		
		bidon.toTransvaser(bidon, bidon2);
		// TODO Auto-generated method stub
		
	}
	

}
