package seminaire;

import java.util.ArrayList;

public class CycleSeminaire{


	CycleEtatSeminaire etatCourant;
	Adherent adherent;
	ListeEtats listetats ;


	public CycleSeminaire(String titre, String resume, int nbInscrits, int capacite){
		this.capacite=capacite;
		this.resume= resume;
		this.nbInscrits=nbInscrits;
		this.capacite=capacite;
		
		listetats = new ListeEtats(this);
		etatCourant= listetats.planification;

		
	}


	/*public void updateState() throws Exception{
		etatCourant = etatCourant.updateState();
		System.out.println("Nouveau état");
	}*/


	private ArrayList <Adherent> listeAttente= new ArrayList<Adherent>();
	private ArrayList <Adherent> listeInscrit= new ArrayList<Adherent>();



	public void ajoutListeAttente(Adherent ad){
		etatCourant.ajoutListeAttente(ad);
		/*this.adherent=ad;
		System.out.println(ad.toString());
		etatCourant.ajoutListeAttente(ad);*/
		
	}

	public  void ajoutInscrit(Adherent ad) {
		etatCourant.ajoutInscrit(ad);
	}

	public void retirerInscrit(Adherent ad){
		etatCourant.retirerInscrit(ad);
	}
	
	public void Inscription(Adherent ad){
		etatCourant.Inscription(ad);
	}

	public Adherent popListeAttente(){
		return etatCourant.popListeAttente();
	}
	
	public  void ouvertureReservation(){
		etatCourant.ouvertureReservation();
	}




	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public int getNbInscrits() {
		return nbInscrits;
	}
	public void setNbInscrits(int nbInscrits) {
		this.nbInscrits = nbInscrits;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	private String titre;
	private String resume;
	private int nbInscrits;
	private int capacite;


	public void setListeAttente(ArrayList <Adherent> listeAttente) {
		this.listeAttente = listeAttente;
	}
	public ArrayList <Adherent> getListeAttente() {
		return listeAttente;
	}
	public void setListeInscrit(ArrayList <Adherent> listeInscrit) {
		this.listeInscrit = listeInscrit;
	}
	public ArrayList <Adherent> getListeInscrit() {
		return listeInscrit;
	}

	public void terminer() {
		etatCourant.terminer();
		
	}

}
