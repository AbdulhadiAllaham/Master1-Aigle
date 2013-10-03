package factory;

import java.util.ArrayList;

public class Alphabet_symbole implements Alphabet{

	ArrayList<Character> symbols = new ArrayList<Character>();

	Caractere_lettre car;

	public Alphabet_symbole() {
		// TODO Auto-generated method stub
		symbols.add('@');
		symbols.add('#');
		symbols.add('&');
		symbols.add('¤');
		symbols.add('!');
		symbols.add('$');
		symbols.add('£');
		symbols.add('%');
		symbols.add('Û');
		symbols.add('+');
		symbols.add('*');

		this.setSymbols(symbols);

	}

	public ArrayList<Character> getSymbols() {
		return symbols;
	}

	public void setSymbols(ArrayList<Character> symbols) {
		this.symbols = symbols;
	}
	
	
	

}
