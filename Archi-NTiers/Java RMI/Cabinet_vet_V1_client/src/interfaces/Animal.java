package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Animal extends Remote{
	
	
	String getNomEtMaitre() throws RemoteException;
	String getDescriptionComplete() throws RemoteException;
	String getDossierSuivi(String nom) throws RemoteException;
	String getEspecee() throws RemoteException;
	String recupEspece() throws RemoteException;

	String getMaitre() throws RemoteException;
	void setMaitre(String maitre) throws RemoteException;
	String getRace() throws RemoteException;
	void setRace(String race) throws RemoteException;
	String getNom() throws RemoteException;
	void setNom(String nom) throws RemoteException;

	void modidossier(String dossierDesc) throws RemoteException;
	void modifierEsepece(String nom, String modification)throws RemoteException;;

  	Espece getEspece() throws RemoteException;
	void setEspece(Espece espece) throws RemoteException;
	void addAnimal(String nom, String maitre, String especee, String race) throws RemoteException;

	void addAnimalEspece(String nom, String maitre, Espece lespece, String race) throws RemoteException;
	void creerEspece(String nom, String duree) throws RemoteException;

}
