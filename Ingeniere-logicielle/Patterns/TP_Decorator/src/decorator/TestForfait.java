package decorator;

public class TestForfait {
	
    public static void main(String[] args) {
    	
    
  

    
	Location forfait = new Supplement25(new Supplement50(new Forfait_base()));
	
	Location forfait2 = new Supplement25(new Supplement50(forfait));

	System.out.println(forfait2.prixFortfait());
	
	/*  Film film = new DVD("Test");
	    Film film2 = new BlueRay("Test");
	    
	    film.emprunter(forfait);
	    film2.emprunter(forfait);

	    film.emprunter(forfait);
	    film2.emprunter(forfait);
	    
	    
	    film.rendre();
	    film.emprunter(forfait);*/

	    //film2.rendre();
	    //film2.emprunter(forfait);
	    
	    

}
}