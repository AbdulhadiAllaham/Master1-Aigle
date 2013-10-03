package factory;

import java.util.ArrayList;
import java.util.Collections;

public class Gestionnaire_guide implements Gestionnaire{

	ArrayList<Character> characters = new ArrayList<Character>();
	ArrayList<Character> characters2 = new ArrayList<Character>();

	ArrayList<Character> alpha = new ArrayList<Character>();
	ArrayList<Character> alpha2 = new ArrayList<Character>();

	Alphabet_symbole alph = new Alphabet_symbole();
	Caractere_lettre carac = new Caractere_lettre();
	Alphabet_lettre alphalettre = new Alphabet_lettre();
	public Gestionnaire_guide(){

		characters = carac.getCharacters();
		characters2 = characters;

		alpha = alph.getSymbols();
		alpha2 = alphalettre.getLetters();
		int sizee = 0;


		for(int abc = 0 ; abc <alpha2.size();abc++){
			if (characters2.contains(alpha2.get(abc))){
				sizee++;
				//characters2.remove(alpha2.get(abc));
			}
		}

		int size = (int) (sizee*0.7);
		int sizefirst=size;
		int sizeRest=0;
		size = Math.round(size);

		size = size / 2;
		//		size = Math.round(size);
		size = (int) Math.ceil(size);
		sizeRest = sizefirst-size;

		System.out.println("size "+size);
		System.out.println("sizeRest "+sizeRest);


		for(int i=0;i<characters.size();i++){
			char charac = characters.get(i);
			if(charac != ' '){
				//for(int ii=i;ii<characters.size();ii++){
					if(characters.get(i).equals(charac) && characters.get(i) != ' '){
						for(int j = 0; j<alpha.size();j++){
						System.out.print("trouvŽ" +j);
						Collections.replaceAll(characters, charac, alpha.get(j));
					}
					}
					System.out.println("tset");
				}
			
		}

		for(Character s:characters){
			System.out.print(s);	
		}
		System.out.print("");
	}

}
