package general

import java.util.HashSet
import java.util.Set
import scala.collection.mutable.ArrayBuffer

class Sommet {

	var x: String = null
	var y: String = null
	var graphe: Graphe = null
	var nom: String = null
	var ensembleAretes = new  HashSet[Arete]();

	def this(x: String, y: String) {
		this()
		this.x = x
		this.y = y
	}
	
	def this(graphe: Graphe, x: String, y: String) {
		this()
		this.graphe = graphe
		this.x = x
		this.y = y
	}

	def addAretes(arete: Arete) {
		ensembleAretes.add(arete);
	}

	def addAretes(arete: Arete, sommet: Sommet) {
		if (this.graphe != null && graphe == sommet.graphe) {
			System.out.println("vérification des graphes ok dans addArretes")
			if ((arete.sommet1!=this && arete.sommet2!=sommet)) {
				// arete.removeFromSommets
				arete.sommet1 = this
				if (sommet != null) {
					arete.sommet2 = sommet
				}
				ensembleAretes.add(arete)
				System.out.println("L'arete a été remplacé et ajouté")
			}
			else {
				System.out.println("L'arete se trouve déjà entre les deux sommets")
			}
		}
		else {
			System.out.println("Veuillez vérifier le graphe de l'arete et des sommets")
		}
	}

	def removeArete(arete: Arete) {
		if (ensembleAretes.remove(arete)) {
			System.out.println("L'arete a bien été supprimé")
		}
		else {
			System.err.println("L'arrete ne se trouve pas au sommet indiqué")
		}
	}

	def getGraphe: Graphe = {
		return graphe
	}

	def setGraphe(graphe: Graphe) {
		this.graphe = graphe
	}

	def getEnsembleArretes: HashSet[Arete] = {
		return ensembleAretes
	}

	def setEnsembleArretes(ensembleAretes: HashSet[Arete]) {
		this.ensembleAretes = ensembleAretes
	}

	def getNom: String = {
		return nom
	}

	def setNom(nom: Nothing) {
		this.nom = nom
	}

	def getX: String = {
		return x
	}
	
	def setX(x: String) {
		this.x = x
	}

	def getY: String = {
		return y
	}

	def setY(y: String) {
		this.y = y
	}

}