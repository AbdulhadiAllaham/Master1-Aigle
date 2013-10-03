package serveur;

import interfaces.GestionnaireAlerte;
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
	int nombrePatients;
	GestionnaireAlerte alerte;
	CabinetVeterinaire cabinet;

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
	public void creerEspece(Espece espece) throws RemoteException {
		this.listeEspece.add(espece);

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
		int nombreVerif = this.getNombrePatients();

		this.setNombrePatients(nombrePatients+1);
		if(nombreVerif<this.getNombrePatients()){
			if(this.getNombrePatients()==2 || this.getNombrePatients()==5 || this.getNombrePatients()==10 || this.getNombrePatients()==50 || this.getNombrePatients()==100 ){
				System.out.println("alerteeee");
				alerte.print(nom,this.getNombrePatients());
			}
		}

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
		
		int nombreVerif = this.getNombrePatients();

		this.setNombrePatients(nombrePatients+1);
		if(nombreVerif<this.getNombrePatients()){
			if(this.getNombrePatients()==2 || this.getNombrePatients()==5 || this.getNombrePatients()==10 || this.getNombrePatients()==50 || this.getNombrePatients()==100 ){
				System.out.println("alerteeee");
				alerte.print(nom,this.getNombrePatients());
			}
		}
		
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteanimal(String nom)
			throws RemoteException {

		AnimalImpl anim = null;


		for(AnimalImpl animmm : listeAnimal){
			if(animmm.getNom().equals(nom)){
				anim=animmm;
			}
		}


		this.listeAnimal.remove(anim);
		int nombreVerif = this.getNombrePatients();

		this.setNombrePatients(nombrePatients-1);
		System.out.println("nomb " +this.getNombrePatients());
		if(nombreVerif>this.getNombrePatients()){
			if(this.getNombrePatients()==1 || this.getNombrePatients()==4 || this.getNombrePatients()==9 || this.getNombrePatients()==49 || this.getNombrePatients()==99 ){
				System.out.println("nom"+ nom);
				System.out.println(this.getNombrePatients());
				alerte.negatif(nom,this.getNombrePatients()+1);
				System.out.println("nombverfi"+nombreVerif);

			}
		}

		// TODO Auto-generated method stub

	}



	@Override
	public String getEspecee(String nom) throws RemoteException {
		// TODO Auto-generated method stub
		Espece espe = null;
		for(AnimalImpl anim : listeAnimal){
			if(anim.getNom().equals(nom)){
				espe = anim.getEspece();

			}
		}

		String protection = "pas protégés ";
		if(espe.getIsProtegee().equals("oui")){
			protection =" est protégé";
		}
		// TODO Auto-generated method stub
		return espe.getespece()+" "+ protection;
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




	@Override
	public String alerter(CabinetVeterinaire cabinet) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}









	@Override
	public String getInfoEspece(Espece espece1) {
		// TODO Auto-generated method stub
		String protection = "pas protégés ";
		if(espece1.getIsProtegee().equals("oui")){
			protection =" est protégé";
		}
		// TODO Auto-generated method stub
		return espece1.getespece()+" "+ protection;
	}




	public int getNombrePatients() throws RemoteException{
		return nombrePatients;
	}




	public void setNombrePatients(int nombrePatients) throws RemoteException{
		this.nombrePatients = nombrePatients;
	}




	@Override
	public void creerGestionnaireAlerte(GestionnaireAlerte alerte, CabinetVeterinaire cabinet)throws RemoteException{

		this.alerte = alerte;
		// TODO Auto-generated method stub

	}




	@Override
	public void creerGestionnaireAlerte(GestionnaireAlerte alerte)
			throws RemoteException {
		// TODO Auto-generated method stub
		this.alerte = alerte;


	}













}
