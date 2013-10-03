package decorator;

public class Supplement_temps extends Supplement{

	public Supplement_temps(Location supplement) {
		super(supplement);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int prixFortfait() {
		// TODO Auto-generated method stub
		
		return supplement.prixFortfait()+10;
	}

	@Override
	public String toString() {
		return "[prixFortfait()=" + prixFortfait() + "]";
	}

}
