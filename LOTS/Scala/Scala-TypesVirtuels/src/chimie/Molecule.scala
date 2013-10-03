package chimie;

import virtualgeneral.GrapheType;
import virtualgeneral.SommetType;
import virtualgeneral.AreteType;


class Molecule extends GrapheType { 
  
  
  override type virtualGraphe = Molecule
  override type virtualSommet = Atome
  override type virtualArete = Liaison
  
 


}