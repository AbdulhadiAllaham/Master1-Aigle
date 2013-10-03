package chimie
import general.Graphe
import general.Sommet
import general.Arete

class Liaison extends Arete {


	def this(sommet1: Atome, sommet2: Atome) {
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
		if (sommet1.isInstanceOf[Atome]) {
			this.sommet1 = sommet1
					System.out.println("ok")
		}
		else {
			System.err.println("pas ok")
		}
	}

	@Override override def setSommet2(sommet2: Sommet) {
		if (sommet2.isInstanceOf[Atome]) {
			this.sommet2 = sommet2
		}
		else {
			System.err.println("pas ok")
		}
	}
	
	@Override override def setGraphe(graphe: Graphe) {
		if(graphe.isInstanceOf[Molecule]){
			this.graphe = graphe;
		}
		else
		{
			System.err.println("Graphe n'est pas instance de Molecule");
		}
	}
}