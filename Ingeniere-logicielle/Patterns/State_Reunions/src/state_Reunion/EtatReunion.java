package state_Reunion;

public abstract class EtatReunion {
	
	Reunion reunion;
	
	
	public EtatReunion(Reunion ren){
		reunion = ren;
	}
	
	
	public abstract void donnerparole();
	public abstract void fermer();

}
