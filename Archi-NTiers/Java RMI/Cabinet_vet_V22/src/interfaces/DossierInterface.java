package interfaces;

import java.rmi.RemoteException;

public interface DossierInterface extends Animal{

	
	String getDossierDesc() throws RemoteException;
	void setDossierDesc(String dossierDesc) throws RemoteException;
	void modifierDossier(String dossierDesc) throws RemoteException;
	String getDossierSuivi(String nom) throws RemoteException;


}
