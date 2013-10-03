package decorator;

public class DVD extends Film{
	
	public DVD(String titre) {
		super(titre);
		super.duree=listetats.jours5;
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
		this.setPrix(2);
		return this.getPrix();
	}



	
}
