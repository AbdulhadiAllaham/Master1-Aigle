package Server;


public class Espece implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nom;
	String espece;
	String duree;
	public Espece (String nom, String duree){
		this.nom = nom;
		this.duree= duree;
	}
	
	public String getespece(){
		this.espece = this.nom;
		return this.espece +" " +this.duree;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}

	public void modifierEspece(String modification) {
		
		this.duree += " testt" + modification;
		
	}
	
	

	
	

}
