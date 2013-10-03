package decorator;

public class Supplement25 extends Supplement{

	public Supplement25(Location supplement) {
		super(supplement);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int prixFortfait() {
		// TODO Auto-generated method stub
	//	System.out.println(supplement.prixFortfait()+10);
		return supplement.prixFortfait()+10;
	}
	


	

}
