package jeu_eau;

public class Bidon {

	int volume;
	int quantite;
	public Bidon(int volume){
		this.volume=volume;
	}




	public void toRemplir(){
		if(this.quantite<this.getVolume()){
		this.quantite=this.volume;
		System.out.println("Bidon rempli");
		}
		else{
			System.out.println("Bidon déjà plein");
		}
	}

	public void toVider(){
		this.setQuantite(0);
		System.out.println("Bidon vidé");

	}

	public void toTransvaser(Bidon bid, Bidon bid2){

		int quant = bid.getQuantite();
		int quant2 = bid2.getQuantite();
		if(quant > (bid2.getVolume()-bid2.getQuantite())){
			bid.setQuantite(bid.getQuantite() - (bid2.getVolume()-bid2.getQuantite()));
			bid2.setQuantite(bid2.getVolume());
			System.out.println("quantite dans bidon A = "+ bid.getQuantite());
			System.out.println("quantite dans bidon B = "+ bid2.getQuantite());

		}
		else{
			if(quant < (bid2.getVolume()-bid2.getQuantite())){
		
			bid.setQuantite(0);
			bid2.setQuantite(quant2 + quant);
			System.out.println("quantite dans bidon A = "+ bid.getQuantite());
			System.out.println("quantite dans bidon B = "+ bid2.getQuantite());
		}
		}
		System.out.println("Bidon a transvasé dans bidon b");

	}




	public int getVolume() {
		return volume;
	}




	public void setVolume(int volume) {
		this.volume = volume;
	}




	public int getQuantite() {
		return quantite;
	}




	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}




}
