
import informatique.Lien;
import informatique.Noeud;
import informatique.Reseau;
import graphe.*;
import chimie.*;

public class MAIN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(" ");
		System.out.println("------Test de Graphe---------");
		System.out.println(" ");
		Graphe graphe1 = new Graphe ("Graphe de test");
		Arete arete1 = new Arete();
		Sommet sommet1 = new Sommet(graphe1,"1","2");
		Sommet sommet3 = new Sommet(graphe1, "4","5");
		Sommet sommet4 = new Sommet(graphe1, "8","7");
		Arete arete11 = new Arete(sommet1,sommet3);
		
		graphe1.addSommet(sommet3);
		arete1.setGraphe(graphe1);
		arete1.setSommet1(sommet3);
		arete1.setSommet2(sommet4);
		sommet1.setGraphe(graphe1);
		graphe1.addArete(arete11);
		//graphe1.removeArete(arete11);
		//graphe1.removeSommet(sommet4);
		
		
		System.out.println(" ");
		System.out.println("------Test de Chimie---------");
		System.out.println(" ");		
		
		Molecule molecule = new Molecule("Molecule");
		Liaison liaison0 = new Liaison();
		Atome atome1 = new Atome(molecule,"10","11");
		Atome atome2 = new Atome("5","6");
		Atome atome3 = new Atome("7","9");
		atome2.setGraphe(molecule);
		atome3.setGraphe(molecule);
		Liaison liaison1 = new Liaison(atome2,atome3);
		Liaison liaison2 = new Liaison(atome1,atome2);
		
		atome3.setGraphe(molecule);
		molecule.addSommet(atome3);
		molecule.addSommet(atome1);
		molecule.addSommet(atome2);
		liaison0.setGraphe(molecule);
		liaison0.setSommet1(atome1);
		liaison0.setSommet2(atome2);
		molecule.addArete(liaison1);
		molecule.addArete(liaison2);
		//molecule.removeSommet(atome3);
		//molecule.removeSommet(atome2);
		molecule.removeArete(liaison1); // désactiver removesommet
		molecule.invarianceGraphe();
		liaison0.invarianceArrete();
		
		
		System.out.println(" ");
		System.out.println("------Test de Informatique---------");
		System.out.println(" ");	
		
		Reseau reseau = new Reseau("Reseau");
		Lien lien0 = new Lien();
		Noeud noeud1 = new Noeud(reseau,"10","11");
		Noeud noeud2 = new Noeud("5","6");
		Noeud noeud3 = new Noeud("7","9");
		noeud2.setGraphe(reseau);
		noeud3.setGraphe(reseau);
		Lien lien1 = new Lien(noeud2,noeud3);
		Lien lien2 = new Lien(noeud1,noeud2);
		
		noeud3.setGraphe(reseau);
		reseau.addSommet(noeud3);
		reseau.addSommet(noeud1);
		reseau.addSommet(noeud2);
		lien0.setGraphe(reseau);
		lien0.setSommet1(noeud1);
		lien0.setSommet2(noeud2);
		reseau.addArete(lien1);
		reseau.addArete(lien2);
		molecule.removeSommet(atome3);
		reseau.removeArete(lien1); // désactiver removesommet
		reseau.invarianceGraphe();
		lien0.invarianceArrete();

		
		

	}

}
