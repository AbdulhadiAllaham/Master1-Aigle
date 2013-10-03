package seminaire;

public class ListeEtats {

	Abandonne abandonne;	
	Annuler annuler;
	Archive archive;
	Complet complet;
	EnCours encours;
	Fini fini;
	PlacesDisponibles placesdispo;
	Planification planification;
	Preparation preparation;
	Termine termine;

	ListeEtats(CycleSeminaire cycle){

		abandonne = new Abandonne(cycle);
		annuler = new Annuler(cycle);
		archive = new Archive(cycle);
		complet = new Complet(cycle);
		encours = new EnCours(cycle);
		fini = new Fini(cycle);
		placesdispo = new PlacesDisponibles(cycle);
		planification = new Planification(cycle);
		preparation = new Preparation(cycle);
		termine = new Termine(cycle);
	}








}
