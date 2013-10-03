package client;


import interfaces.Espece;

import java.rmi.RemoteException;


public class EspeceProtegee extends Espece {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3665251672686999168L;
	/**
	 * 
	 */
	

	public EspeceProtegee(String nom, String duree) {
		super(nom, duree);
		this.setIsProtegee("oui");
		// TODO Auto-generated constructor stub
	}
	
	
	
	


	public String getSynthese(Espece espece) throws RemoteException{
		
		
		return null;
	}


}
