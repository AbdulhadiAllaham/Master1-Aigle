package informatique;

import graphe.Arete;
import graphe.Graphe;
import graphe.Sommet;

public class Lien extends Arete{

	public Lien() {
		
	}
	
	public Lien(Sommet sommet1, Sommet sommet2) {
		super(sommet1, sommet2);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setSommet1(Sommet sommet1) {
		if(sommet1 instanceof Noed){
			this.sommet1 = sommet1;
			System.out.println("ok");
		}
		else
		{
			System.err.println("pas ok");
		}
	}
	
	@Override
	public void setSommet2(Sommet sommet2) {
		if(sommet2 instanceof Noed){
			this.sommet2 = sommet2;
		}
		else
		{
			System.err.println("pas ok");
		}
	}
	
	@Override
	public void setGraphe(Graphe graphe) {
		if(graphe instanceof Reseau){
			this.graphe = graphe;
		}
		else
		{
			System.err.println("Graphe n'est pas instance de Reseau");
		}
	}
	
	

}
