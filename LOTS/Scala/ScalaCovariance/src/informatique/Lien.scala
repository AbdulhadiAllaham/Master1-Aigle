package informatique

import general.Arete
import general.Sommet
import general.Graphe

class Lien extends Arete {
  

  
	def this(sommet1: Noed, sommet2: Noed) {
  		this()
  		if (sommet1!=sommet2 && sommet1.graphe == (sommet2.graphe)) {
  			this.sommet1 = sommet1
			this.sommet2 = sommet2
			sommet1.addAretes(this)
			sommet2.addAretes(this)
			this.graphe = sommet1.graphe
  		}
  		else {
  			System.out.println("Erreur lors de l'instanciation d'une arete, veuillez vérifier les sommets")
  		}
  	}

	@Override override def setSommet1(sommet1: Sommet) {
		if (sommet1.isInstanceOf[Noed]) {
			this.sommet1 = sommet1
			System.out.println("ok")
		}
		else {
			System.err.println("pas ok")
		}
	}

	@Override override def setSommet2(sommet2: Sommet) {
	  if (sommet2.isInstanceOf[Noed]) {
	    this.sommet2 = sommet2
	  }
	  else {
	    System.err.println("pas ok")
	  }
	}
	
	@Override override def setGraphe(graphe: Graphe) {
		if(graphe.isInstanceOf[Reseau]){
			this.graphe = graphe;
		}
		else
		{
			System.err.println("Graphe n'est pas instance de Reseau");
		}
	}
}