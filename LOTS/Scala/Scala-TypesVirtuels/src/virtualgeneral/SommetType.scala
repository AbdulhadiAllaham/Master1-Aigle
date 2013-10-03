package virtualgeneral

import java.util.HashSet
import java.util.Set
import scala.collection.mutable.ArrayBuffer



class SommetType {
  
  
	type virtualArete <: AreteType;
	type virtualSommet <: SommetType;
	type virtualGraphe <: GrapheType;

	var x: String = null
	var y: String = null
	var graphe: virtualGraphe = _;
	var nom: String = null
	var ensembleAretes = new  HashSet[virtualArete]();

	def this(x: String, y: String) {
		this()
		this.x = x
		this.y = y
	}



	def addAretes(arete: virtualArete) {
		ensembleAretes.add(arete);
	}

	def addAretes(arete: virtualArete, sommet: virtualSommet) {
		if (this.graphe != null && graphe == sommet.getGraphe) {
			System.out.println("vérification des graphes ok dans addArretes")
			if ((arete.sommet1!=this && arete.sommet2!=sommet)) {
			// arete.removeFromSommets
				arete.sommet1 = this.asInstanceOf[arete.virtualSommet]
				if (sommet != null) {
					arete.sommet2 = sommet.asInstanceOf[arete.virtualSommet]
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

	def removeArete(arete: virtualArete) {
		if (ensembleAretes.remove(arete)) {
			System.out.println("L'arete a bien été supprimé")
		}
		else {
			System.err.println("L'arrete ne se trouve pas au sommet indiqué")
		}
	}

	def getGraphe: virtualGraphe = {
			return graphe
	}
	
	def setGraphe(graphe: virtualGraphe) {
		this.graphe = graphe
	}

	def getEnsembleArretes: HashSet[virtualArete] = {
		return ensembleAretes
	}

	def setEnsembleArretes(ensembleAretes: HashSet[virtualArete]) {
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