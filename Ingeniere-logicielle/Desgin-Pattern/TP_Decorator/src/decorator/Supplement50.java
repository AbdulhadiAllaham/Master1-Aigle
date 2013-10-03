package decorator;

public class Supplement50 extends Supplement{

	public Supplement50(Location supplement) {
		super(supplement);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int prixFortfait() {
		// TODO Auto-generated method stub
		return supplement.prixFortfait()+30;
	}
	


	
	

}
