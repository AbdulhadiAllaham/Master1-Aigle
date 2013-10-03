package Server;

import interfaces.CabinetVeterinaire;

import java.rmi.registry.*;


public class Server {

	public Server() {};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	System.setSecurityManager(new RMISecurityManager());
		
	try{
		CabinetVeterinaire cabinet = new CabinetImpl("Cabinet Chez Gilles");
		Registry registry = LocateRegistry.createRegistry(1099);
		
		if (registry == null){
			System.err.println("RmiRegistry not found");
		}
		else{
			registry.bind("Cabinet1", cabinet);
			System.err.println("Server cabinet ready");
		}
		
	} catch (Exception e){
		System.err.println("Erreur: " +e.toString());
		e.printStackTrace();
	}

	}

}
