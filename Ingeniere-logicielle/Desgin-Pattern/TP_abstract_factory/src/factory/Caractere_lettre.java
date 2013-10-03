package factory;

import java.util.ArrayList;

public class Caractere_lettre implements Caractere{

	Mot mot = new Mot();
	ArrayList <Character> characters = new ArrayList <Character>();
	ArrayList <String> mots = new ArrayList <String>();

	public Caractere_lettre() {
		
		mots = mot.getMot();
		String word;
		
		for(String m:mots){
			word=m.toLowerCase();
			for(int a = 0; a < word.length(); a++){
			characters.add(word.charAt(a));
		}
			characters.add(' ');
		}
		
		for(Character ch: characters){
			System.out.println(ch);
		}
		
		this.setCharacters(characters);
		
	}

	public Mot getMot() {
		return mot;
	}

	public void setMot(Mot mot) {
		this.mot = mot;
	}

	public ArrayList<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(ArrayList<Character> characters) {
		this.characters = characters;
	}

	public ArrayList<String> getMots() {
		return mots;
	}

	public void setMots(ArrayList<String> mots) {
		this.mots = mots;
	}

	
	
}
