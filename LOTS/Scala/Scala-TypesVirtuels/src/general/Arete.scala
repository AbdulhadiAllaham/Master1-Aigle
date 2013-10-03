package general;

import virtualgeneral.GrapheType
import virtualgeneral.SommetType
import virtualgeneral.AreteType;



class Arete extends AreteType { 
  
  override type virtualGraphe = Graphe
  override type virtualSommet = Sommet
  override type virtualArete = Arete
  
  def this(sommet1: Sommet, sommet2: Sommet) {
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