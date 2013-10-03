package Server;

import interfaces.Animal;
import interfaces.DossierInterface;
import interfaces.Espece;

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
		this.espece=anim.recupEspece();
		this.dossierDesc = "Dossier de l'animal de nom "+nom + ", nom du ma”tre = " + maitre + ", de race " + race +" et d'espece " + espece;
	}
	
	
	
	

	public void modifierDossier(String ajoutaudossier) throws RemoteException  {
		this.dossierDesc +=" "+ ajoutaudossier;
		
	}


	@Override
	public String getEspecee() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
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
	public String getNom() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void setNom(String nom) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addAnimal(String nom, String maitre, String especee, String race) {
		// TODO Auto-generated method stub
		
	}


	

	@Override
	public void modidossier(String dossierDesc) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void creerEspece(String nom, String duree) throws RemoteException {
		// TODO Auto-generated method stub
	}


	@Override
	public String recupEspece() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void modifierEsepece(String nom, String modification)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void setEspece(Espece espece) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Espece getEspece() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addAnimalEspece(String nom, String maitre, Espece lespece,
			String race) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	/*@Override
	public Espece recupEspece(String nom) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}*/

}
