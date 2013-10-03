package dico;


public class OrderedDictionary extends AbstractDictionary{


	OrderedDictionary(int size){
		tabKey = new Object [size];
		tabValues = new Object [size];

//		for (int i=0;i<size;i++){
//			tabKey[i]= new String ();
//			tabValues[i] = new String ();
//		}
	}

	//protected Object orderedDict [];


	@Override
	protected int newIndexOf(Object Key) {
		System.out.println("newindexof");
		int indexof=0;
		int longeur = tabKey.length;
		Object tabKeys [] = new Object [longeur+1];
		Object tabValue [] = new Object [longeur+1];

		if (tabKey.length==0){
			tabKeys = new Object [longeur+1];
			tabValue = new Object [longeur+1];
			tabKey=tabKeys;
			tabValues=tabValue;
			indexof=0;
			System.out.println("index envoye: "+indexof);

			return indexof;

		}
		
		else{
		


		for(int i=0;i<tabKey.length;i++){
			int ab = i;

			//for(int i=0;i<tabKey.length;i++){
				if(tabKey[i]!=null){
					///i++;
					if(i==tabKey.length-1){
						tabKeys[i]=tabKey[i];
						tabValue[i]=tabValues[i];

						tabKey=tabKeys;
						//tabKey[tabKey.length-1]= new String();
						tabValues=tabValue;
						//tabValues[tabValues.length-1] = new String();

						indexof=(tabKey.length-1);
						System.out.println("tabKey " +tabKey[i] );

						System.out.println("nouveau index créé " + indexof);
						System.out.println("index envoye: "+indexof);



					}
				}
					
				}


				}
		return indexof;

	}



				@Override
				protected int size() {
					int sizee = 0;
					for(int i = 0; i<tabKey.length;i++){
						if(tabKey[i]!=null){
							sizee=i;
							//System.out.println("i"+ i);
						}
					}
					return sizee+1;
				}

			}
