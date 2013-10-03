package jeu_eau;

import java.util.ArrayList;

public class Exécuter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bidon bid = new Bidon(10);
		Bidon bid2 = new Bidon(8);
		Bidon bid3 = new Bidon(6);
		Bidon bid4 = new Bidon(4);
		Bidon bid5 = new Bidon(2);

		
		
		Command remplir = new Remplir(bid);
		Command vider = new Vider(bid2);
		Command transvaser = new Transvaser(bid, bid5);
		remplir.execute();
		vider.execute();
		transvaser.execute();
		
		Entree s = new Entree();
		
		s.storeAndExecute(remplir);
		s.storeAndExecute(vider);
		s.storeAndExecute(transvaser);

	}

}
