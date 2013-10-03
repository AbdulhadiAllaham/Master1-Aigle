package interfaces;

import java.rmi.RemoteException;

public interface DossierInterface extends Animal{

	
	
	void modifierDossier(String dossierDesc) throws RemoteException;
	String getDossierSuivi(String nom) throws RemoteException;


}
