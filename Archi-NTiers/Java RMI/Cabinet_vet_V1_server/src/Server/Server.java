package Server;


import java.rmi.RMISecurityManager;
import java.rmi.registry.*;


public class Server {

	public Server() {};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String codebase = "file:/Users/Gilles/";

//		System.setProperty("java.rmi.server.codebase", codebase);
		System.setProperty("java.security.policy", codebase+"allpolicy.txt");
		System.setSecurityManager(new RMISecurityManager());
		
	try{
		AnimalImpl animalimpl = new AnimalImpl();
		//AnimalImpl animalimpl1 = new AnimalImpl("Toto","Gilles","Chien","Monstre");
		Registry registry = LocateRegistry.createRegistry(1099);
		
		if (registry == null){
			System.err.println("RmiRegistry not found");
		}
		else{
			registry.bind("Anim1", animalimpl);
			System.err.println("Server Version1 ready");
		}
		
	} catch (Exception e){
		System.err.println("Erreur: " +e.toString());
		e.printStackTrace();
	}

	}

}
