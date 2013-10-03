package generique;


public abstract class gArete 
<Gra extends gGraphe<Gra,Ar,Som>,
Ar extends gArete<Gra,Ar,Som>, 
Som extends gSommet<Gra,Ar,Som>>
	{

	Gra gGraphe;
	public Som sommet1;
	public Som sommet2;

	public gArete(){

	}

	@SuppressWarnings("unchecked")
	public gArete(Som sommet1, Som sommet2){
		if(sommet1 != sommet2 && sommet1.gGraphe == sommet2.gGraphe)
		{
			this.sommet1=sommet1;
			this.sommet2=sommet2;
			sommet1.addAretes((Ar) this);
			sommet2.addAretes((Ar) this);
			this.gGraphe = sommet1.gGraphe;
		}
		else{
			System.out.println("Erreur lors de l'instanciation d'une gArete, veuillez vérifier les sommets");
		}
	}
	


	public boolean invarianceArrete()
	{
		if((this.getSommet1()==null && this.getSommet2()==null) || (this.getSommet1()!=null && this.getSommet2()!=null))
		{
			if(this.getSommet1().gGraphe==this.gGraphe && (this.gGraphe==this.getSommet2().gGraphe))
			{
				System.out.println("Test invariance gArete ok");
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
			System.err.println("Erreur : L'gArete est branché d'un côté seulement");
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void removeFromSommets(){
		if(sommet1 != null && sommet2 != null)
		{
		sommet1.removeArete((Ar) this);
		sommet2.removeArete((Ar) this);
		}
		else
		{
			System.out.println("Les sommets sont null");
		}
	}
	
	public void remiseAzeroSommets(){
		this.sommet1 = null;
		this.sommet2 = null;
	}


	//Getters and setters

	public gGraphe<Gra, Ar, Som> getGraphe() {
		return gGraphe;
	}

	public void setGraphe(Gra gGraphe) {
		this.gGraphe = gGraphe;
	}

	public gSommet<Gra, Ar, Som> getSommet1() {
		return sommet1;
	}

	public void setSommet1(Som sommet1) {
		this.sommet1 = sommet1;
	}

	public gSommet<Gra, Ar, Som> getSommet2() {
		return sommet2;
	}

	public void setSommet2(Som sommet2) {
		this.sommet2 = sommet2;
	}
	
	
}
