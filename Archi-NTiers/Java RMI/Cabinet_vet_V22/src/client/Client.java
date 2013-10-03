package client;

import interfaces.CabinetVeterinaire;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String host = (args.length < 1) ? null : args [0];
		
		try{
			
			Registry registry = LocateRegistry.getRegistry(host);
			CabinetVeterinaire stub = (CabinetVeterinaire) registry.lookup("Cabinet1");

			
			stub.creerEspece("chat", "Žternel");
			stub.creerEspece("chien", "15ans");

			stub.addAnimal("Grosminet", "Gilles", "chat", "bengal");
			String anim = stub.getanim("Grosminet");
			
			stub.addAnimal("Rex", "Gilles", "chien", "terrier");
			String anim1 = stub.getanim("Rex");
			
			

			
			System.out.println("description: "+anim);
			System.out.println(stub.getEspecee("Grosminet"));
			System.out.println(stub.getDossierSuivi("Grosminet"));
			stub.modidossier("Grosminet", "je modifie");
			System.out.println(stub.getDossierSuivi("Grosminet"));
			System.out.println(stub.getDossierSuivi("Rex"));

			
			System.out.println("description: "+anim1);
			System.out.println(stub.getEspecee("Rex"));
			stub.modifierEsepece("Rex","modiffff");
			System.out.println("Espece essai de modification " +stub.getEspecee("Rex"));
			System.out.println(stub.getDossierSuivi("Rex"));
			stub.modidossier("Rex", "je modifie Rex");
			System.out.println(stub.getDossierSuivi("Rex"));
			System.out.println(stub.getDossierSuivi("Grosminet"));

			
		}
		catch (Exception e){
			System.err.println("Erreur: " +e.toString());
			e.printStackTrace();
		}
			
	}

}
