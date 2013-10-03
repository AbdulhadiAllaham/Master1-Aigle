package decorator;


public abstract class Supplement implements Location{
	
	protected Location supplement;
	
	
	public Supplement(Location supplement){
		this.supplement=supplement;
	}


	
	
	  
}
