package client;

import interfaces.Animal;

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
			Animal stub = (Animal) registry.lookup("Anim1");
			
			stub.creerEspece("chat", "Žternel");
			
			
			stub.addAnimal("Grosminet", "Gilles", "chat", "Bengal");

			System.out.println(stub.getDescriptionComplete());
			System.out.println(stub.getEspecee());

			String dossier = stub.getDossierSuivi("Grosminet");
			System.out.println(dossier);
			stub.modidossier(" modificiation du dossier");
			dossier = stub.getDossierSuivi("Grosminet");
			System.out.println(dossier);

			
			
			
			
			/*System.out.println("Que voulez vous faire?");
			System.out.println("1. Ajouter un animal");
			System.out.println("2. Ajouter une espece");
			System.out.println("3. Consulter dossier de suivi d'un animal");
			Scanner sc = new Scanner(System.in);
			int choix = sc.nextInt();

			String nom;
			String maitre;
			String race;
			String nvdossier;
			switch(choix){

			case 1 : System.out.println("Nom: ");
			sc.nextLine();
			nom = sc.nextLine();
			System.out.println("Maitre: ");
			maitre = sc.nextLine();
			System.out.println("Race: ");
			race = sc.nextLine();
			stub.addAnimal(nom, maitre, espece, race);

			case 2 : System.out.println("Nom de l'espece: ");
			String nomEspece = sc.nextLine();
			new Espece(nomEspece);
			case 3 : System.out.println("Nom de l'animal: ");
			String nomAnimal = sc.nextLine();
			String dossier = stub.getDossierSuivi(nomAnimal);
			System.out.println("dossier suivi : " + dossier);
			System.out.println("Entrez 1 pour modifier le dossier de suivi : ");
			choix = sc.nextInt();
			if(choix == 1){
				System.out.println("Saisissez les information ˆ rajouter au dossier");
				sc.nextLine();
				nvdossier = sc.nextLine();
				if(!nvdossier.equals("")){
					stub.modidossier(nvdossier);
				}
				dossier=stub.getDossierSuivi(nomAnimal);
				System.out.println("dossier suivi : " + dossier);
			}

			}
*/





		}
		catch (Exception e){
			System.err.println("Erreur: " +e.toString());
			e.printStackTrace();
		}

	}

}
