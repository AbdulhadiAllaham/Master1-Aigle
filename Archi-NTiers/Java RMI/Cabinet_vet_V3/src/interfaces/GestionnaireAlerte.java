package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GestionnaireAlerte extends Remote{
	
	void print(String nom, int nombre)throws RemoteException;

	void negatif(String nom, int nombrePatients) throws RemoteException;;  
}
