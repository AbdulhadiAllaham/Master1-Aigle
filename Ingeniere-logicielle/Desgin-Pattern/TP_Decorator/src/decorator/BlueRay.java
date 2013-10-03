package decorator;

public class BlueRay extends Film{

	public BlueRay(String titre) {
		super(titre);
		super.duree=listetats.jours3;
		super.etatcourant=duree;

		// TODO Auto-generated constructor stub
	}



	private int prix;
	

	

	public int getPrix() {
		return prix;
	}



	public void setPrix(int prix) {
		this.prix = prix;
	}



	@Override
	public int returnPprix() {
		// TODO Auto-generated method stub
		this.setPrix(2);
		return 0;
	}



	

}
