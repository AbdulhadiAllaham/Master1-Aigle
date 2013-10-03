package chimie;

import virtualgeneral.GrapheType;
import virtualgeneral.SommetType;
import virtualgeneral.AreteType;



class Atome extends SommetType { 
  
  override type virtualGraphe = Molecule
  override type virtualSommet = Atome
  override type virtualArete = Liaison  
  
  
  def this(graphe: Molecule, x: String, y: String) {
	this()
	this.graphe = graphe
	this.x = x
	this.y = y
}

}