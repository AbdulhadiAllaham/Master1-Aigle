package interfaces;


public class Espece implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nom;
	String espece;
	String duree;
	String isProtegee;
	
	public Espece (String nom, String duree){
		this.nom = nom;
		this.duree= duree;
		this.setIsProtegee("non");
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

	
	public String getIsProtegee() {
		return isProtegee;
	}

	public void setIsProtegee(String isProtegee) {
		this.isProtegee = isProtegee;
	}
	
	public void modifierEspece(String modification) {
		
		this.duree += " " + modification;
		System.out.println("Essai de modifier espece");
		
	}
	

	
	

}
