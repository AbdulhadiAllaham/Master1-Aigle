package virtualgeneral



abstract class AreteType {

	type virtualArete <: AreteType;
	type virtualSommet <: SommetType;
	type virtualGraphe <: GrapheType;

	var graphe: virtualGraphe = _;
	var sommet1: virtualSommet = _;
	var sommet2: virtualSommet = _; 
	var arete: virtualArete = _;
	

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



	def getGraphe: virtualGraphe = {
		return graphe
	}

	def setGraphe(graphe: virtualGraphe) {
		this.graphe = graphe
	}

	def getSommet1: virtualSommet = {
		return sommet1
	}

	def setSommet1(sommet1: virtualSommet) {
		this.sommet1 = sommet1
	}

	def getSommet2: virtualSommet = {
		return sommet2
	}

	def setSommet2(sommet2: virtualSommet) {
		this.sommet2 = sommet2
	}
	
	def removeFromSommets {
	  
//		if (sommet1 != null && sommet2 != null) {
//			sommet1.removeArete(this.asInstanceOf[this.virtualSommet])
//			sommet2.removeArete(this)
//		}
//		else {
//			System.out.println("Les sommets sont null")
//		}
	}

}