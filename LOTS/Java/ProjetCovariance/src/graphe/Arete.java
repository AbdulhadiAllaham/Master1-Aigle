package graphe;

public class Arete {


	public Graphe graphe;
	public Sommet sommet1;
	public Sommet sommet2;

	public Arete(){

	}

	public Arete(Sommet sommet1, Sommet sommet2){
		if(sommet1 != sommet2 && sommet1.graphe == sommet2.graphe)
		{
			this.sommet1=sommet1;
			this.sommet2=sommet2;
			sommet1.addAretes(this);
			sommet2.addAretes(this);
			this.graphe = sommet1.graphe;
		}
		else{
			System.out.println("Erreur lors de l'instanciation d'une arete, veuillez vérifier les sommets");
		}
	}



	public boolean invarianceArrete()
	{
		if((this.getSommet1()==null && this.getSommet2()==null) || (this.getSommet1()!=null && this.getSommet2()!=null))
		{
			if(this.getSommet1().graphe==this.graphe && (this.graphe==this.getSommet2().graphe))
			{
				System.out.println("Test invariance arete ok");
				return true;
			}
			else
			{
				System.err.println("Les deux aretes n'apparatiennent pas au même graphue que l'arrete");
				return false;
			}
		}
		else
		{
			System.err.println("Erreur : L'arete est branché d'un côté seulement");
			return false;
		}
	}

	public void removeFromSommets(){
		if(sommet1 != null && sommet2 != null)
		{
		sommet1.removeArete(this);
		sommet2.removeArete(this);
		}
		else
		{
			System.out.println("Les sommets sont null");
		}
	}


	//Getters and setters

	public Graphe getGraphe() {
		return graphe;
	}

	public void setGraphe(Graphe graphe) {
		this.graphe = graphe;
	}

	public Sommet getSommet1() {
		return sommet1;
	}

	public void setSommet1(Sommet sommet1) {
		this.sommet1 = sommet1;
	}

	public Sommet getSommet2() {
		return sommet2;
	}

	public void setSommet2(Sommet sommet2) {
		this.sommet2 = sommet2;
	}

}
