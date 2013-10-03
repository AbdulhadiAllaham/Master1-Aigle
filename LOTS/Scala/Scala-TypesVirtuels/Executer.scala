

object Executer {
  
  	def main(args: Array[String]): Unit = {

  			val graphe = new Graphe;
			val sommet1 = new Sommet(graphe,"1","2");
			val sommet2 = new Sommet(graphe,"4","4");
			val sommet3 = new Sommet(graphe,"4","64");
			
			//val molecule = new Molecule();
			

			sommet1.setGraphe(graphe);
			sommet2.setGraphe(graphe);

			val arete = new Arete(sommet1,sommet2);

			graphe.addSommet(sommet1);
			graphe.addSommet(sommet2);
			// graphe.addSommet(sommet3);

			graphe.addArete(arete);
			//molecule.addSommet(sommet1);

	}

}