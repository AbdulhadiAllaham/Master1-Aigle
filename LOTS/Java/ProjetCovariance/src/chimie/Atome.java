package chimie;

import graphe.Arete;
import graphe.Graphe;
import graphe.Sommet;

public class Atome extends Sommet{


	public Atome(String x, String y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public Atome(Graphe graphe, String x, String y){
		super(graphe,x,y);
	}

	@Override
	public void addAretes(Arete arete){
		if(arete instanceof Liaison)
		{
			ensembleAretes.add(arete);
			System.out.println("ajout de la liaison ok");
		}
		else
		{
			System.err.println("L'arrete n'est pas isntance de Liaison");
		}
	}

	@Override
	public void addAretes(Arete arete, Sommet sommet){
		if(arete instanceof Liaison && sommet instanceof Atome){
			if(graphe != null && graphe == sommet.graphe){
				System.out.println("vérification des graphes ok dans addArretes");
				if((arete.sommet1!=this && arete.sommet2!=sommet) && ((arete.sommet1!=sommet && arete.sommet2!=this))) // test pour voir s'il y a déja une arete en place
				{

					arete.removeFromSommets();

					arete.sommet1=this;
					if(sommet != null)
					{
						arete.sommet2=sommet;
					}
					ensembleAretes.add(arete);
				}
				else
				{
					System.out.println("L'arete se trouve déjà entre les deux sommets");
				}
			}
			else
			{
				System.out.println("Veuillez vérifier le graphe de l'arete et des sommets");
			}
		}
		else{
			System.out.println("Problème d'instance dans addarete(arrete,sommet) dans Atome");
		}
	}
	
	@Override
	public void setGraphe(Graphe graphe) {
		if(graphe instanceof Molecule){
		this.graphe = graphe;
		}
		else{
			System.err.println("Graphe n'est pas isntance de Molecule");
		}
	}
}


