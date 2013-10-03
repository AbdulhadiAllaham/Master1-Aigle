

import general.Sommet
import general.Graphe
import chimie.Molecule
import general.Arete
import java.lang.Override
import java.lang.Override
import informatique.Reseau
import chimie.Liaison
import chimie.Atome
import informatique.Noed
import informatique.Lien

object Executer {

  def main(args: Array[String]): Unit = {
    
    
		System.out.println(" ");
		System.out.println("------Test de Graphe---------");
		System.out.println(" ");
		
		val graphe1 = new Graphe();
		val arete1 = new Arete();
		val sommet1 = new Sommet("1","2");
		val sommet12 = new Sommet("3","4");
		val sommet3 = new Sommet(graphe1, "4","5");
		val sommet4 = new Sommet(graphe1, "8","7");
		val arete11 = new Arete(sommet3,sommet4);
		
		graphe1.addSommet(sommet3);
		arete1.setGraphe(graphe1);
		arete1.setSommet1(sommet3);
		arete1.setSommet2(sommet4);
		sommet12.setGraphe(graphe1);
		sommet1.setGraphe(graphe1);
		sommet1.addAretes(arete11, sommet12);
		graphe1.addArete(arete11);
		//graphe1.removeArete(arete11);
		//graphe1.removeSommet(sommet4);
		
		
		System.out.println(" ");
		System.out.println("------Test de Chimie---------");
		System.out.println(" ");
		
		val molecule = new Molecule();
		val liaison0 = new Liaison();
		val atome1 = new Atome(molecule,"10","11");
		val atome2 = new Atome("5","6");
		val atome3 = new Atome("7","9");
		atome2.setGraphe(molecule);
		atome3.setGraphe(molecule);
		val liaison1 = new Liaison(atome2,atome3);
		val liaison2 = new Liaison(atome1,atome2);
		
		atome3.setGraphe(molecule);
		molecule.addSommet(atome3);
		molecule.addSommet(sommet3);
		molecule.addSommet(atome1);
		molecule.addSommet(atome2);
		liaison0.setGraphe(molecule);
		liaison0.setGraphe(graphe1);
		liaison0.setSommet1(sommet12);
		liaison0.setSommet1(atome1);
		liaison0.setSommet2(atome2);
		molecule.addArete(liaison1);
		molecule.addArete(liaison2);
		molecule.addArete(arete11);
		molecule.removeSommet(sommet1);
		molecule.removeArete(arete1);
		//molecule.removeSommet(atome3);
		//molecule.removeSommet(atome2);
		molecule.removeArete(liaison1); // désactiver removesommet
		molecule.invarianceGraphe;
		liaison0.invarianceArrete;
		
		
		System.out.println(" ");
		System.out.println("------Test de Informatique---------");
		System.out.println(" ");
		
		val reseau = new Reseau();
		val lien0 = new Lien();
		val noeud1 = new Noed(reseau,"10","11");
		val noeud2 = new Noed("5","6");
		val noeud3 = new Noed("7","9");
		noeud2.setGraphe(reseau);
		noeud3.setGraphe(reseau);
		val lien1 = new Lien(noeud2,noeud3);
		val lien2 = new Lien(noeud1,noeud2);
		
		noeud3.setGraphe(reseau);
		reseau.addSommet(noeud3);
		reseau.addSommet(sommet3);
		reseau.addSommet(noeud1);
		reseau.addSommet(noeud2);
		lien0.setGraphe(reseau);
		lien0.setGraphe(graphe1);
		lien0.setSommet1(sommet12);
		lien0.setSommet1(noeud1);
		lien0.setSommet2(noeud2);
		reseau.addArete(lien1);
		reseau.addArete(lien2);
		reseau.addArete(arete11);
		reseau.removeSommet(sommet1);
		reseau.removeArete(arete1);
		//molecule.removeSommet(atome3);
		//molecule.removeSommet(noeud3);
		reseau.removeArete(lien1); // désactiver removesommet
		reseau.invarianceGraphe;
		lien0.invarianceArrete;
    
    
    
    
    /*val sommet1 = new Sommet("1","2");
			val sommet2 = new Sommet("4","4");
			val sommet3 = new Sommet("4","64");
			val graphe = new Graphe;
			val molecule = new Molecule;
			val atome1 = new Atome("4","5");
			val atome2 = new Atome("6","5");

			val liaison = new Liaison(atome1,atome2);
			
			molecule.addSommet(atome1);
			molecule.addSommet(sommet2);


			sommet1.setGraphe(graphe);
			sommet2.setGraphe(graphe);

			val arete = new Arete(sommet1,sommet2);
			
			graphe.addSommet(sommet1);
			graphe.addSommet(sommet2);
			 graphe.addSommet(sommet3);

			graphe.addArete(arete);
			molecule.addSommet(sommet1);
			
			val reseau = new Reseau;
			val noeud1 = new Noed(reseau,"1","2");
			val noeud2 = new Noed(reseau,"1","2");
			val lien = new Lien(noeud1,noeud2);
			
			reseau.addSommet(atome1);
			reseau.addSommet(noeud1);
			reseau.addSommet(noeud2);
			reseau.addSommet(sommet1);
			reseau.addArete(lien);*/

    


    
    
  }

}