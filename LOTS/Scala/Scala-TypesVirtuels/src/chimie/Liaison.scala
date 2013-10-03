package chimie;

import virtualgeneral.GrapheType
import virtualgeneral.SommetType
import virtualgeneral.AreteType;



class Liaison extends AreteType { 
  
  override type virtualGraphe = Molecule
  override type virtualSommet = Atome
  override type virtualArete = Liaison  
  
  def this(sommet1: Atome, sommet2: Atome) {
		this()
		if (sommet1!=sommet2 && sommet1.graphe == (sommet2.graphe)) {
			this.sommet1 = sommet1
					this.sommet2 = sommet2
					sommet1.addAretes(this)
					sommet2.addAretes(this)
					//this.graphe = sommet1.graphe
		}
		else {
			System.out.println("Erreur lors de l'instanciation d'une arete, veuillez vérifier les sommets")
		}
	}
  
}