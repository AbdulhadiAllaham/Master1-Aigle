package factory;

import java.util.ArrayList;

public class Alphabet_lettre implements Alphabet{

	ArrayList<Character> letters = new ArrayList<Character>();
	
	public Alphabet_lettre (){
		for(char ch = 'a'; ch <='z'; ch++)
		{
			letters.add(ch);
		}
		
		this.setLetters(letters);
	}

	public ArrayList<Character> getLetters() {
		return letters;
	}

	public void setLetters(ArrayList<Character> letters) {
		this.letters = letters;
	}
	
}




