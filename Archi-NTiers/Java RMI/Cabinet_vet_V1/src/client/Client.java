package client;

import interfaces.Animal;
import interfaces.Espece;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {



	/**
	 * @param args
	 */
	public static void main(String[] args) {



		String codebase = "file:/Users/Gilles/";

		//	System.setProperty("java.rmi.server.codebase", codebase);
		System.setProperty("java.security.policy", codebase+"allpolicy.txt");
		System.setSecurityManager(new RMISecurityManager());

		// TODO Auto-generated method stub

		String host = (args.length < 1) ? null : args [0];

		try{

			Registry registry = LocateRegistry.getRegistry(host);
			//demande stub	
			Animal stub = (Animal) registry.lookup("Anim1");
			
			//--- V1.1 CrŽer l'animal avec espce en cha”ne de caractre  ----  //
			
			//crŽer une espce
			stub.creerEspece("chat", "Žternel");
			//crŽer un animal sur le serveur 			
			stub.addAnimal("Grosminet", "Gilles", "chat", "Bengal");
			//afficher despcription de l'aniaml
			System.out.println(stub.getDescriptionComplete());
			//afficher despcription de l'espece
			System.out.println(stub.getEspecee());
			//rŽcupŽrer espce par copie
			Espece esp = stub.getEspece();
			System.out.println("espece : "+esp.getespece());
			//essai de modifier l'espece
			esp.modifierEspece("modification");
			System.out.println("espce aprs modification " +stub.getEspecee());
			//rŽcupŽrer dossier de suivi
			String dossier = stub.getDossierSuivi("Grosminet");
			System.out.println(dossier);
			//modifier dossier de suivi
			stub.modidossier("modificiation du dossier");
			dossier = stub.getDossierSuivi("Grosminet");
			System.out.println(dossier);
	
			
			//--- V1.2 CrŽer l'animal ˆ partir de l'objet copiŽ  ----  //
			/*
			stub.creerEspece("chat", "Žternel");
			Espece esp = stub.getEspece();
			
			stub.addAnimalEspece("Grosminet", "Gilles", esp, "Bengal");
			//Description de l'animal
			System.out.println(stub.getDescriptionComplete());
			//Descritpion de l'espece
			System.out.println(esp.getespece());
			//rŽcupŽrer dossier de suivi
			String dossier = stub.getDossierSuivi("Grosminet");
			System.out.println(dossier);
			//modifier dossier de suivi
			stub.modidossier("modificiation du dossier");
			dossier = stub.getDossierSuivi("Grosminet");
			System.out.println(dossier);
			*/

		}
		catch (Exception e){
			System.err.println("Erreur: " +e.toString());
			e.printStackTrace();
		}

	}

}
