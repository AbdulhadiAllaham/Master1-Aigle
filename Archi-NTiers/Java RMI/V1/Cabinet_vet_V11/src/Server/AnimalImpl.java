package Server;



import interfaces.Animal;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;




@SuppressWarnings("serial")
public class AnimalImpl extends UnicastRemoteObject implements Animal {
	
	protected AnimalImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}



	String nom;
	String maitre;
	String race;
	String especeee;
	Espece espece;
	DossierSuivi dossier;
	
	
/*	public AnimalImpl (String nom, String maitre, String espece, String race) throws RemoteException{
		this.nom=nom;
		this.maitre=maitre;
		this.espece=espece;
		this.race=race;
		
		dossier = new DossierSuivi(nom);
		especee = new Espece(nom);

	}*/
	
	
		
	
	
	public String getMaitre() throws RemoteException{
		return maitre;
	}


	public void setMaitre(String maitre) throws RemoteException{
		this.maitre = maitre;
	}



	public String getRace() throws RemoteException{
		return race;
	}



	public void setRace(String race) throws RemoteException{
		this.race = race;
	}



	public void setNom(String nom) throws RemoteException{
		this.nom = nom;
	}


	public String getNom()throws RemoteException{
		return nom;
	}
	
	public String getNomEtMaitre()throws RemoteException{
		String nometmaitre = "nom : " + this.getNom() + "maitre : "+this.getMaitre();
		return nometmaitre;
	}
	
	public String getDescriptionComplete()throws RemoteException{
		String complet = " nom : " + this.getNom() + " maitre : "+this.getMaitre() + " espece : " + this.espece.getespece() + " race : " + this.getRace();
		return complet;
	}


	public String getDossierSuivi(String nom) throws RemoteException {
		this.nom = nom;
		String desc = dossier.getDossierSuivi(nom);
		return desc;
	}
	
	



	public String getEspecee() throws RemoteException {
		String especedesc = "espece "+ this.espece.getespece();
		return especedesc;
	}


	public void addAnimal(String nom, String maitre, String especee, String race) throws RemoteException{
		
		this.nom=nom;
		this.maitre=maitre;
		this.setEspece(this.recuperEspece(especee));
		this.race=race;
		this.dossier = new DossierSuivi(this);
		// TODO Auto-generated method stub
		
	}


	public Espece getEspece() {
		return espece;
	}


	public void setEspece(Espece espece) {
		this.espece = espece;
	}


	public void modidossier(String dossierDesc) throws RemoteException {
		this.dossier.modifierDossier(dossierDesc);
	}


	@Override
	public void creerEspece(String nom, String duree) throws RemoteException {
		
		this.espece = new Espece(nom,duree);
		// TODO Auto-generated method stub
	}


	public String getEspeceee() {
		return especeee;
	}


	public void setEspeceee(String especeee) {
		this.especeee = especeee;
	}

	public String recupEspece() throws RemoteException{
		
		return this.espece.getespece();
	}

	public Espece recuperEspece(String nom) throws RemoteException {
		// TODO Auto-generated method stub
		if (this.espece.getNom().equals(nom)){
		return this.espece;
		}
		else{
			return null;
		}
	}

}
