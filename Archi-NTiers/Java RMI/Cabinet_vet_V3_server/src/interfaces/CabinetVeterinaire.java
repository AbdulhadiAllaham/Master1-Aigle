package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface CabinetVeterinaire extends Remote {
		
	String getanim(String nom) throws RemoteException;
	void addAnimal(String nom, String maitre, String espece, String race) throws RemoteException;

	void creerEspece(Espece espece) throws RemoteException;

	String getEspecee(String nom)throws RemoteException;
	String alerter(CabinetVeterinaire cabinet)throws RemoteException;
	void creerGestionnaireAlerte(GestionnaireAlerte alerte) throws RemoteException;
	void creerGestionnaireAlerte(GestionnaireAlerte alerte, CabinetVeterinaire cabinet)throws RemoteException;

	
	String getDossierSuivi(String nom) throws RemoteException;
	void modidossier(String nom, String modification) throws RemoteException;
	void modifierEsepece(String nom, String modification)throws RemoteException;
	String getInfoEspece(Espece espece1)throws RemoteException;
	
	int getNombrePatients()throws RemoteException;
	void setNombrePatients(int nombrePatients) throws RemoteException;
	void deleteanimal(String nom) throws RemoteException;
	void addAnimalEspece(String nom, String maitre, Espece lespece, String race)
			throws RemoteException;
	Espece getEspeceeObject(String nom) throws RemoteException;
	
}

