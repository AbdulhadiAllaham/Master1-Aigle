package jeu_eau;

import java.util.ArrayList;

public class Entree {
	
	private ArrayList<Command> history = new ArrayList<Command>();

	public Entree(){
	}
	
	public void storeAndExecute(Command cmd) {
	      this.history.add(cmd); // optional 
	      cmd.execute();        
	   }
	
}
