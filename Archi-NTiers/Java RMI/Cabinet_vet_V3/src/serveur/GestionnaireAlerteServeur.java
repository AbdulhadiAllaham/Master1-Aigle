package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.GestionnaireAlerte;
import interfaces.CabinetVeterinaire;

public class GestionnaireAlerteServeur extends UnicastRemoteObject implements GestionnaireAlerte{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CabinetVeterinaire cabinet;

	public GestionnaireAlerteServeur(CabinetVeterinaire cabinet) throws RemoteException{
		this.cabinet = cabinet;
	}

	
	
	public void print(String nom, int nombre)throws RemoteException{
		System.out.println("test");
	}



	@Override
	public void negatif(String nom, int nombrePatients) throws RemoteException {
		// TODO Auto-generated method stub
		
	}



}
