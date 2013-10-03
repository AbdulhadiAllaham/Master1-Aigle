package general;

import virtualgeneral.GrapheType;
import virtualgeneral.SommetType;
import virtualgeneral.AreteType;



class Sommet extends SommetType { 
  
  override type virtualGraphe = Graphe
  override type virtualSommet = Sommet
  override type virtualArete = Arete  
  
  
  def this(graphe: Graphe, x: String, y: String) {
	this()
	this.graphe = graphe
	this.x = x
	this.y = y
}

}