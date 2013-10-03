package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.GestionnaireAlerte;
import interfaces.CabinetVeterinaire;

public class GestionnaireAlerteClient extends UnicastRemoteObject implements GestionnaireAlerte{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CabinetVeterinaire cabinet;

	public GestionnaireAlerteClient(CabinetVeterinaire cabinet) throws RemoteException {
			this.cabinet=cabinet;
	}




	public void print(String nom, int nombre)throws RemoteException{
		switch (nombre){
		case 2 : 
			System.out.println("Vous venez d'ajouter le deuxième animal de nom : " +nom);
			nombre= 0;
			break;
		case 5:
			System.out.println("Vous venez d'ajouter le "+nombre+"ième animal de nom : " +nom);
			nombre= 0;
			break;
		case 10:
			System.out.println("Vous venez d'ajouter le "+nombre+"ième animal de nom : " +nom);
			nombre= 0;
			break;
		case 100:
			System.out.println("Vous venez d'ajouter le "+nombre+"ième animal de nom : " +nom);
			nombre= 0;
			break;
		case 50:
			System.out.println("Vous venez d'ajouter le "+nombre+"ième animal de nom : " +nom);
			nombre= 0;
			break;
		}

	}




	@Override
	public void negatif(String nom, int nombrePatients) throws RemoteException {
		switch (nombrePatients){
		case 2 : 
			System.out.println("Vous venez de perdre le deuxième animal de nom : " +nom);
			nombrePatients= 0;
			break;
		case 5:
			System.out.println("Vous venez de perdre le "+nombrePatients+"ième animal de nom : " +nom);
			nombrePatients= 0;
			break;
		case 10:
			System.out.println("Vous venez de perdre le "+nombrePatients+"ième animal de nom : " +nom);
			nombrePatients= 0;
			break;
		case 100:
			System.out.println("Vous venez de perdre le "+nombrePatients+"ième animal de nom : " +nom);
			nombrePatients= 0;
			break;
		case 50:
			System.out.println("Vous venez de perdre le "+nombrePatients+"ième animal de nom : " +nom);
			nombrePatients= 0;
			break;
		}		
		
	}




	
}
