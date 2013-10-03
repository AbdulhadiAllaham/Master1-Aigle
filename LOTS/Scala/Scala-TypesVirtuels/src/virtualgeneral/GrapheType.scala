package virtualgeneral

import java.util.HashSet
import java.util.Set

class GrapheType {

	type virtualSommet <: SommetType;
	type virtualArete <: AreteType;
	type virtualGraphe <: GrapheType;
	
	var ensembleSommets = new  HashSet[virtualSommet]();
	var ensembleAretes  = new  HashSet[virtualArete]();
	var nom: String = null

	def this(nom: String) {
		this()
		this.nom = nom
	}

	def addSommet(sommet: virtualSommet) {
		ensembleSommets.add(sommet)
	}

	def addArete(arete: virtualArete) {
		if (this.ensembleSommets.isEmpty) {
			System.err.println("Le graphe ne comporte pas de sommets")
		}
		if ((this.ensembleSommets.contains(arete.getSommet1) && this.ensembleSommets.contains(arete.getSommet2))) {
			System.out.println("L'arrete a les memes sommets que le graphe")
			this.ensembleAretes.add(arete)
			arete.setGraphe(this.asInstanceOf[arete.virtualGraphe])
		}
		else {
			System.err.println("Le graphe n'a pas les meme sommets que l'arrete")
		}
	}

	def removeSommet(sommet: virtualSommet) {
		if (ensembleSommets.remove(sommet)) {
			System.out.println("Sommet (" + sommet.getX + "," + sommet.getY + ") suppression dans removeSommet")
			import scala.collection.JavaConversions._
			for (ar <- ensembleAretes) {
				if ((ar.getSommet1 == sommet) || (ar.getSommet2 == sommet)) {
					ensembleAretes.remove(ar)
					System.out.println("Une arrete a été supprimée")
				}
			}
		}
		else {
			System.err.println("Sommet (" + sommet.getX + "," + sommet.getY + ") ne fait pas partie du graphe " + this.getNom)
		}
	}

	def removeArete(arete: virtualArete) {
		if (this.ensembleSommets.remove(arete)) {
			System.out.println("Arete suprrimé " + this.getNom)
		}
		else {
			System.err.println("Arete ne fait pas partie du graphe " + this.getNom)
		}
	}

	def invarianceGraphe: Boolean = {
			import scala.collection.JavaConversions._
			for (ar <- ensembleAretes) {
				if (this ne ar.graphe) {
					System.err.println("Graphe n'est pas égal à un des graphes des aretes ")
					return false
				}
			}
			System.out.println("Toutles les arretes ont le bon graphe")
			return true
	}

	def getEnsembleSommets: HashSet[virtualSommet] = {
		return ensembleSommets
	}

	def setEnsembleSommets(ensembleSommets: HashSet[virtualSommet]) {
		this.ensembleSommets = ensembleSommets
	}

	def getEnsembleAretes: HashSet[virtualArete] = {
		return ensembleAretes
	}

	def setEnsembleAretes(ensembleAretes: HashSet[virtualArete]) {
		this.ensembleAretes = ensembleAretes
	}

	def getNom: String = {
		return nom
	}

	def setNom(nom: String) {
		this.nom = nom
	}

	def createArete(sommet1: virtualSommet, sommet2: virtualSommet) {
//			if ((sommet1 != null) && (sommet2 != null)) {
//						val arete: virtualArete = new Arete(sommet1, sommet2)
//						this.addArete(arete)
//						System.out.println("Arete a été créé avec succès")
//						}
//						else {
//							System.err.println("ARete n'a pas pu être créé car un des sommets est null")
//						}
	}


}