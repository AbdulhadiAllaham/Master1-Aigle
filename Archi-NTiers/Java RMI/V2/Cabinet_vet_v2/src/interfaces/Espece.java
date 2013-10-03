package interfaces;

import java.io.Serializable;


public class Espece implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 697261193227485011L;
	/**
	 * 
	 */
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
		
		this.duree += " " + modification;
		System.out.println("Essai de modifier espece");

	}
	
	

	
	

}
