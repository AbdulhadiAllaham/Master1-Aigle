package seminaire;

public abstract class CycleEtatSeminaire {


	CycleSeminaire cycle;
	Adherent ad;


	CycleEtatSeminaire(CycleSeminaire c){
		cycle = c;
	}



	public abstract void ajoutListeAttente(Adherent ad);

	public abstract void ajoutInscrit(Adherent ad);
	/*public void ajoutInscrit(Adherent ad) throws Exception{

		this.setAd(ad);

		for (Adherent ab:cycle.getListeInscrit()){
			if(!cycle.getListeInscrit().contains(ab)){
				cycle.getListeInscrit().add(ad);
			}https://www.facebook.com/
		}
		cycle.updateState();
	}*/

	public abstract void retirerInscrit(Adherent ad);

	public Adherent popListeAttente(){
		Adherent ab = null;
		if(cycle.getListeInscrit().size()>0){
			ab = cycle.getListeInscrit().get(0);
		}

		return ab;

	}


	public abstract void Inscription(Adherent ad) ;
	public abstract void ouvertureReservation();
	public abstract void terminer();


	public Adherent getAd() {
		return ad;
	}

	public void setAd(Adherent ad) {
		this.ad = ad;
	}













}
