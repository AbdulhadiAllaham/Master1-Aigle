package serveur;


import interfaces.Animal;
import interfaces.Espece;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



public class AnimalImpl extends UnicastRemoteObject implements Animal {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4775970394772896145L;






	protected AnimalImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}



	String nom;
	String maitre;
	Espece espece;
	String race;
	

	
	
	
	
	public String getMaitre() throws RemoteException{
		return maitre;
	}


	public void setMaitre(String maitre) throws RemoteException{
		this.maitre = maitre;
	}




	public String getRace() throws RemoteException{
		return race;
	}



	public void setRace(String race) throws RemoteException{
		this.race = race;
	}



	public void setNom(String nom) throws RemoteException{
		this.nom = nom;
	}


	public String getNom()throws RemoteException{
		return nom;
	}
	
	public String getNomEtMaitre()throws RemoteException{
		String nometmaitre = "nom : " + this.getNom() + "maitre : "+this.getMaitre();
		return nometmaitre;
	}
	
	public String getDescriptionComplete()throws RemoteException{
		String complet = " nom : " + this.getNom() + " maitre : "+this.getMaitre() + " espece : " + this.getEspece().getNom() + " race : " + this.getRace();
		return complet;
	}




	public Espece getEspece() throws RemoteException {
		// TODO Auto-generated method stub
		return this.espece;
	}





	public void setEspece(Espece espece) throws RemoteException {
		// TODO Auto-generated method stub
		this.espece=espece;
		System.out.println("espece");
		
		
	}


	@Override
	public String getespece() throws RemoteException {
		// TODO Auto-generated method stub
		return this.getEspece().getespece();
	}








}
