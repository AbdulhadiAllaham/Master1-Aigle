package general

class Arete {

	var graphe: Graphe = null
	var sommet1: Sommet = null
	var sommet2: Sommet = null


	def this(sommet1: Sommet, sommet2: Sommet) {
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

	def invarianceArrete: Boolean = {
			if ((this.getSommet1 == null && this.getSommet2 == null) || (this.getSommet1 != null && this.getSommet2 != null)) {
				if (this.getSommet1.graphe.eq(graphe) && (this.graphe eq this.getSommet2.graphe)) {
					System.out.println("Test invariance arete ok")
					return true
				}
				else {
					System.err.println("Les deux aretes n'apparatiennent pas au même graphue que l'arrete")
					return false
				}
			}
			else {
				System.err.println("Erreur : L'arete est branché d'un côté seulement")
				return false
			}
	}

	def removeFromSommets {
		if (sommet1 != null && sommet2 != null) {
			sommet1.removeArete(this)
			sommet2.removeArete(this)
		}
		else {
			System.out.println("Les sommets sont null")
		}
	}

	def getGraphe: Graphe = {
		return graphe
	}

	def setGraphe(graphe: Graphe) {
		this.graphe = graphe
	}

	def getSommet1: Sommet = {
		return sommet1
	}

	def setSommet1(sommet1: Sommet) {
		this.sommet1 = sommet1
	}

	def getSommet2: Sommet = {
		return sommet2
	}

	def setSommet2(sommet2: Sommet) {
		this.sommet2 = sommet2
	}

}