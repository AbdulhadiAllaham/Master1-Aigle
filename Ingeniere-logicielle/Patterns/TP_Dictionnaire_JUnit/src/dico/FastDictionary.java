package dico;


public class FastDictionary extends AbstractDictionary{





	public FastDictionary(int size){
		tabKey = new Object [size];
		tabValues = new Object [size];

		/*for (int i=0;i<size;i++){
			tabKey[i]= new String ();
			tabValues[i] = new String ();
		}*/
		//		System.out.println("fastdict: "+tabKey.length);
		//		System.out.println("fastdict: "+tabValues.length);

	}


	protected int nbrObjets;





	@Override
	protected int size() {
		nbrObjets=0;		

		//System.out.println(tabKey.length);

		for(int i=0;i<tabKey.length;i++){
			//System.out.println("tabkey "+ i + tabKey[i]);
			if(tabKey[i]!=null){
				//System.out.println("size control "+tabKey[i]);
				this.nbrObjets++;
			}
		}

		return nbrObjets;
	}




	protected boolean mustGrow(){

		int nbrelelements=0;
		nbrelelements = size()+1;
		System.out.println("nbrelments "+nbrObjets);
		double troisquarts = nbrelelements+(nbrelelements*0.25);
		int longeur=0;
		longeur = this.tabKey.length;
		System.out.println("troisquarts: "+troisquarts);
		System.out.println("longeur "+longeur);

		//		System.out.println("siiize "+siize);
		//		System.out.println(nbrObjets);
		//System.out.println("long"+longeur);
		boolean ok = false;


		if(troisquarts>longeur){
			ok = true;
			System.out.println("trop long ");

		}
		else{
			ok = false;
			//System.out.println("taille ok");

		}
		if(ok == true){
			//System.out.println("trop long ");
			ok = false;
			grow();
			//System.out.println("taille pas ok");

		}
		return ok;

	}

	protected void grow(){

		Object [] acopierKey;
		Object [] acopierValue;

		int length = this.tabKey.length;
		acopierKey = new Object [length+1];
		acopierValue = new Object [length+1];

		for(int i=0;i<tabKey.length;i++){
			acopierKey[i]=tabKey[i];
			acopierValue[i]=tabValues[i];
		}

		this.tabKey=acopierKey;
		this.tabValues=acopierValue;
		//this.tabKey[tabKey.length-1]=new String();
		//this.tabValues[tabValues.length-1]=new String();

		System.out.println("grow 1");

		boolean must = mustGrow();
		if (must==true){
			grow();


		}



	}


	protected int newIndexOf(Object key) 
	{
		int ii=0;

		//System.out.println("ii " +ii);
		boolean must = mustGrow();
		int index = key.hashCode()%tabKey.length;

		System.out.println("indexmodulo1 : "+index);

		if(index<0){
			index=index*(-1);
		}
		System.out.println("indexmodulo : "+index);
		System.out.println("length du tab : "+tabKey.length);

		if(must==false){
			System.out.println("faux");

			for (int i=index;i<tabKey.length;i++){
				System.out.println("i"+i);
				System.out.println(tabKey[i]);
				if(tabKey[i]==null){
					System.out.println("vide trouvŽ");

					ii=i;
					i=tabKey.length-1;

				}
				


			}
		}
		else{
			if(must==true){
				grow();
			}
		}
		return ii;
	}


	public int returnLength(){
		
		
		return tabValues.length;
	}




}
