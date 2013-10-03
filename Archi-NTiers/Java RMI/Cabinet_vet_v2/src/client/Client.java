package client;

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
			//rŽcupŽrer stub
			CabinetVeterinaire stub = (CabinetVeterinaire) registry.lookup("Cabinet1");

			//crŽer des espces
			stub.creerEspece("chat", "Žternel");
			stub.creerEspece("chien", "15ans");

			//ajouter un animal au cabinet
			stub.addAnimal("Grosminet", "Gilles", "chat", "bengal");
			//mŽthode pour rŽcupŽrer l'animal par nom
			String anim = stub.getanim("Grosminet");
			
			//ajouter deuxime animal au cabinet
			stub.addAnimal("Rex", "Gilles", "chien", "terrier");
			//mŽthode pour rŽcupŽrer l'animal par nom
			String anim1 = stub.getanim("Rex");
			
			//rŽcupŽrer l'espce en copie
			Espece esp = stub.getEspecee("Grosminet");
			System.out.println(esp.getespece());
			
			//ajouter troisime animal ˆ partir du objet "esp" copiŽ 
			stub.addAnimalEspece("Gombo", "Gilles", esp, "bizarre");
			//mŽthode pour rŽcupŽrer l'animal par nom
			String anim2 = stub.getanim("Gombo");

			//description de l'animal "Grosminet"
			System.out.println("description: "+anim);
		//	System.out.println(stub.getEspecee("Grosminet"));
			System.out.println(stub.getDossierSuivi("Grosminet"));
			stub.modidossier("Grosminet", "je modifie");
			System.out.println(stub.getDossierSuivi("Grosminet"));
			System.out.println(stub.getDossierSuivi("Rex"));
			
			//description de l'animal "Rex"
			System.out.println("description: "+anim1);
		//	System.out.println(stub.getEspecee("Rex"));
			System.out.println(stub.getDossierSuivi("Rex"));
			stub.modidossier("Rex", "je modifie Rex");
			System.out.println(stub.getDossierSuivi("Rex"));
			System.out.println(stub.getDossierSuivi("Grosminet"));
			
			//description de l'animal "Gombo"
			System.out.println("description: "+anim2);
			//	System.out.println(stub.getEspecee("Rex"));
			System.out.println(stub.getDossierSuivi("Gombo"));
			stub.modidossier("Gombo", "je modifie Gombo");
			System.out.println(stub.getDossierSuivi("Gombo"));
			System.out.println(stub.getDossierSuivi("Grosminet"));
			System.out.println(stub.getDossierSuivi("Rex"));

		}
		catch (Exception e){
			System.err.println("Erreur: " +e.toString());
			e.printStackTrace();
		}
			
	}

}
