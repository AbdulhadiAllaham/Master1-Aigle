package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Animal extends Remote{
	
	String getNomEtMaitre() throws RemoteException;
	String getDescriptionComplete() throws RemoteException;
	String getespece()throws RemoteException;

	
	String getMaitre() throws RemoteException;
	void setMaitre(String maitre) throws RemoteException;
	String getRace() throws RemoteException;
	void setRace(String race) throws RemoteException;
	String getNom() throws RemoteException;
	void setNom(String nom) throws RemoteException;
	

}
