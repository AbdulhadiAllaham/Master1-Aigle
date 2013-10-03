package client;

import interfaces.GestionnaireAlerte;
import interfaces.CabinetVeterinaire;
import interfaces.Espece;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String codebase = "file:/Users/Gilles/";

		//	System.setProperty("java.rmi.server.codebase", codebase);
		System.setProperty("java.security.policy", codebase+"client.txt");
		System.setSecurityManager(new RMISecurityManager());
		
		String host = (args.length < 1) ? null : args [0];
		
		
		try{
			
			Registry registry = LocateRegistry.getRegistry(host);
			//rŽcupŽr le stub (le cabinet veterinaire)
			CabinetVeterinaire stub = (CabinetVeterinaire) registry.lookup("Cabinet1");
			
			//ajouter un gestionnaire d'alerte
			GestionnaireAlerte alerte = new GestionnaireAlerteClient(stub);
			stub.creerGestionnaireAlerte(alerte);
			
			//crŽer des espces et les ajouter au cabinet
			Espece espece1 = new EspeceProtegee("chat","20 ans");
			Espece espece2 = new Espece("chien","15 ans");
			
			stub.creerEspece(espece1);
			stub.creerEspece(espece2);
			
			//crŽer des anmiaux
			stub.addAnimal("Grosminet", "Gilles", "chat", "persien");
			String anim = stub.getanim("Grosminet");
			System.out.println("description: "+anim);
			stub.addAnimal("Rex", "Gilles", "chien", "terrier");			
			stub.addAnimal("3", "Gilles", "chien", "terrier");
			stub.addAnimal("4", "Gilles", "chien", "terrier");
			stub.addAnimal("5ime", "Gilles", "chien", "terrier");
			stub.addAnimal("6", "Gilles", "chien", "terrier");
			stub.addAnimal("7", "Gilles", "chien", "terrier");
			stub.addAnimal("8", "Gilles", "chien", "terrier");
			stub.addAnimal("9", "Gilles", "chien", "terrier");
			stub.addAnimal("10ime", "Gilles", "chien", "terrier");
			stub.addAnimal("11ime", "Gilles", "chien", "terrier");
			stub.deleteanimal("11ime");
			stub.deleteanimal("5ime");
			System.out.println("nombre de patients aprs dernire modification : " +stub.getNombrePatients());

		
			//afficher description des animaux
			String anim1 = stub.getanim("Rex");
			System.out.println(anim1);

			String anim8 = stub.getanim("8");
			System.out.println(anim8);

			
			//afficher information sur les espces
			String espec = stub.getInfoEspece(espece1);
			String espec1 = stub.getInfoEspece(espece2);
			System.out.println(espec);
			System.out.println(espec1);
			
			//afficher espece ˆ partir du nom de l'aniaml
			String esp = stub.getEspecee("Grosminet");
			String esp8 = stub.getEspecee("8");
			System.out.println(esp);
			System.out.println(esp8);
			
			//rŽcupŽrer dossier de suivi
			System.out.println(stub.getDossierSuivi("Grosminet"));
			stub.modidossier("Grosminet", "je modifie");
			System.out.println(stub.getDossierSuivi("Grosminet"));
			System.out.println(stub.getDossierSuivi("Rex"));
			
			//rŽcupŽrer espce par copie
			Espece espobj = stub.getEspeceeObject("Grosminet");
			System.out.println(espobj.getespece());
			espobj.modifierEspece("modification de l'objet");
			System.out.println(espobj.getespece());
			System.out.println(stub.getEspecee("Grosminet"));

			
		}
		catch (Exception e){
			System.err.println("Erreur: " +e.toString());
			e.printStackTrace();
		}
			
	}

}
