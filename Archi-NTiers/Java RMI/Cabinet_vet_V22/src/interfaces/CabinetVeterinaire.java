package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface CabinetVeterinaire extends Remote {
		
	String getanim(String nom) throws RemoteException;
	void addAnimal(String nom, String maitre, String espece, String race) throws RemoteException;

	void creerEspece(String nom, String duree) throws RemoteException;
	String getEspecee(String nom)throws RemoteException;
	
	String getDossierSuivi(String nom) throws RemoteException;
	void modidossier(String nom, String modification) throws RemoteException;
	void modifierEsepece(String nom, String modification)throws RemoteException;;

	
}

