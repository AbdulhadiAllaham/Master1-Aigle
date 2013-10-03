package factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		
		int difficulte;
		BufferedReader clavier=new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("A quel niveau voulez-vous jouer?");
		System.out.println("Facile tapez 1, Moyen tapez 2, Difficile tapez 2");

		
		difficulte =Integer.parseInt(clavier.readLine());
		
		Abstract_Factory factfac = null;
		
		if(difficulte == 1){
		factfac = new Factory_facile();
		}
		
		Jeu jeu = new Jeu(factfac);
		
		
	}

}
