package Server;

import interfaces.Animal;
import interfaces.CabinetVeterinaire;
import interfaces.Espece;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CabinetImpl extends UnicastRemoteObject implements CabinetVeterinaire  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9192468409054271504L;
	public ArrayList<AnimalImpl> listeAnimal = new ArrayList<AnimalImpl>(); 
	public ArrayList<Espece> listeEspece = new ArrayList<Espece>(); 
	public ArrayList<DossierSuivi> listeDossiers = new ArrayList<DossierSuivi>(); 

//	Animal animal1 = new AnimalImpl("Grosminet","Gilles","Chatte","Tigre");
//	Animal animal2 = new AnimalImpl("didi","Gilles","Lapin","Monstre");
	String nomCabinet;
	

	
	protected CabinetImpl(String nom) throws RemoteException {
		this.nomCabinet = nom;
	}
	
	


	@Override
	public String getanim(String nom) throws RemoteException {
		
	//	this.listeAnimal.add(animal1);
	//	this.listeAnimal.add(animal2);
		Animal animtrouve = null;
		for(Animal anim:listeAnimal){
			if(nom.equals(anim.getNom())){
				System.out.println(nom);
				animtrouve = anim;
				return animtrouve.getDescriptionComplete();
			}
			else{
				System.out.println("pras trouvé");
			}
		}
		// TODO Auto-generated method stub
		//return animtrouve;
		return null;
		
	}
	
	

	@Override
	public void creerEspece(String nom, String duree) throws RemoteException {
		
		Espece esp = new Espece(nom,duree);
		this.listeEspece.add(esp);
		
		// TODO Auto-generated method stub
	}







	@Override
	public void addAnimal(String nom, String maitre, String lespece, String race)
			throws RemoteException {
		
		AnimalImpl anim = new AnimalImpl();
		DossierSuivi dossier;
		anim.setNom(nom);
		anim.setMaitre(maitre);
		anim.setRace(race);
		

		for(Espece espp : listeEspece){
			if(espp.getNom().equals(lespece)){
				anim.setEspece(espp);
			}
		}
		dossier = new DossierSuivi(anim);
		
		this.listeAnimal.add(anim);
		this.listeDossiers.add(dossier);
		
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addAnimalEspece(String nom, String maitre, Espece lespece, String race)
			throws RemoteException {
		
		AnimalImpl anim = new AnimalImpl();
		DossierSuivi dossier;
		anim.setNom(nom);
		anim.setMaitre(maitre);
		anim.setRace(race);
		
		anim.setEspece(lespece);
		
		dossier = new DossierSuivi(anim);
		
		this.listeAnimal.add(anim);
		this.listeDossiers.add(dossier);
		
		// TODO Auto-generated method stub
		
	}




	@Override
	public Espece getEspecee(String nom) throws RemoteException {
		// TODO Auto-generated method stub
		for(AnimalImpl anim : listeAnimal){
			if(anim.getNom().equals(nom)){
				Espece esp = anim.getEspece();
				return esp;

			}
		}
		return null;
	}


	@Override
	public String getDossierSuivi(String nom) throws RemoteException {
		// TODO Auto-generated method stub
		for(DossierSuivi dossier : listeDossiers){
			if(dossier.getNom().equals(nom)){
				return dossier.getDossierSuivi(nom);
			}
		}
		return null;
		
	}



	
	@Override
	public void modidossier(String nom, String modification) throws RemoteException {
		// TODO Auto-generated method stub
		for(DossierSuivi dossier : listeDossiers){
			if(dossier.getNom().equals(nom)){
				dossier.modifierDossier(modification);
			}
		}
		
	}




	@Override
	public void modifierEsepece(String nom, String modification)
			throws RemoteException {
		for(Espece esp : listeEspece){
			if(esp.getNom().equals(nom)){
				esp.modifierEspece(modification);
			}
		}
		
	}








	
}
