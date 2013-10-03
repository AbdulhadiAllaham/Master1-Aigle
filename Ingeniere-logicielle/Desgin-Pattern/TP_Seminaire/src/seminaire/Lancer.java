package seminaire;

public class Lancer {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		CycleSeminaire cycle = new CycleSeminaire("test","test",0,10);
		
		Adherent ad = new Adherent("Entringer","Gilles");

		//cycle.Inscription(ad);
		cycle.ouvertureReservation();
		cycle.Inscription(ad);
		cycle.terminer();

	}

}
