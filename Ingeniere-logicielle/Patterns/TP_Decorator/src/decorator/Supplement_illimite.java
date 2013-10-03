package decorator;

public class Supplement_illimite extends Supplement{

	public Supplement_illimite(Location supplement) {
		super(supplement);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int prixFortfait() {
		// TODO Auto-generated method stub
		return supplement.prixFortfait()+20;
	}

	@Override
	public String toString() {
		return "[prixFortfait()=" + prixFortfait() + "]";
	}

}
