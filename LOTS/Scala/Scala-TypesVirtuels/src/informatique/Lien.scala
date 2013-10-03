package informatique;

import virtualgeneral.GrapheType
import virtualgeneral.SommetType
import virtualgeneral.AreteType;



class Lien extends AreteType { 
  
  override type virtualGraphe = Reseau
  override type virtualSommet = Noed
  override type virtualArete = Lien
  
  def this(sommet1: Noed, sommet2: Noed) {
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