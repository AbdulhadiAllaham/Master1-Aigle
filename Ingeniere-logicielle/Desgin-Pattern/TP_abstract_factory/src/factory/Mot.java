package factory;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Mot {

	Phrase p = new Phrase();
	ArrayList <String> mot = new ArrayList<String>();

	public Mot(){

		String str = p.getPhrase1();
		StringTokenizer st = new StringTokenizer(str);

		while (st.hasMoreElements()) {
			//System.out.println(st.nextElement());
			mot.add(st.nextToken());
		}

		for(String e:mot){
			System.out.println(e);
		}
		
		this.setMot(mot);
		
		
	}

	public Phrase getP() {
		return p;
	}

	public void setP(Phrase p) {
		this.p = p;
	}

	public ArrayList<String> getMot() {
		return mot;
	}

	public void setMot(ArrayList<String> mot) {
		this.mot = mot;
	}
	

}
