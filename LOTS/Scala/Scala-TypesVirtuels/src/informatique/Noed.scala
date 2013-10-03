package informatique;

import virtualgeneral.GrapheType;
import virtualgeneral.SommetType;
import virtualgeneral.AreteType;



class Noed extends SommetType { 
  
  override type virtualGraphe = Reseau
  override type virtualSommet = Noed
  override type virtualArete = Lien  
  
  
  def this(graphe: Reseau, x: String, y: String) {
	this()
	this.graphe = graphe
	this.x = x
	this.y = y
}

}