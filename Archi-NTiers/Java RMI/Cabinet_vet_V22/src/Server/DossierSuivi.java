package Server;

import interfaces.Animal;
import interfaces.DossierInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class DossierSuivi extends UnicastRemoteObject implements DossierInterface{

	
	String nom;
	String maitre;
	String race;
	String espece;
	String dossierDesc;
	Animal anim;
	String modif;
	
	public DossierSuivi(Animal anim) throws RemoteException {
		this.anim=anim;
		this.nom = anim.getNom();
		this.race = anim.getRace();
		this.maitre=anim.getMaitre();
		this.espece=anim.getespece();
		this.dossierDesc = "Dossier de l'animal "+nom + " " + maitre + " " + race +" " + espece;
	}
	
	
	public String getDossierDesc() throws RemoteException {
		return dossierDesc + " " + modif;
	}


	public void setDossierDesc(String dossierDescc) throws RemoteException   {
		this.dossierDesc = dossierDescc;
		System.out.println("ok");
	}

	public void modifierDossier(String ajoutaudossier) throws RemoteException  {
		this.dossierDesc +=" "+ ajoutaudossier;
		
	}


	public String getDossierSuivi() throws RemoteException {
		// TODO Auto-generated method stub
		return dossierDesc;
	}
	
	@Override
	public String getDossierSuivi(String nom) throws RemoteException {
		// TODO Auto-generated method stub
		if(nom.equals(this.nom)){
		return dossierDesc;
		}
		else{
			return null;
		}
	}




	@Override
	public String getNomEtMaitre() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public String getDescriptionComplete() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public String getMaitre() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void setMaitre(String maitre) throws RemoteException {
		// TODO Auto-generated method stub
		
	}







	@Override
	public String getRace() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void setRace(String race) throws RemoteException {
		// TODO Auto-generated method stub
		
	}








	@Override
	public String getespece() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	/*@Override
	public Espece recupEspece(String nom) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}*/

}
