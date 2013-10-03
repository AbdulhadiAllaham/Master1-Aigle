package copy;


public abstract class Copy {
	
	public Object get(Object key) {

		String keyGet = "";
		for(int i=0;i<tabKey.length;i++){
			if(tabKey[i].equals(key)){
				keyGet=(String) tabValues[i];
			}
		}

		return keyGet;
	}


	public Object put (Object key, Object value) {

		for (int i=0;i<tabKey.length&&i<tabValues.length;i++){
			if(tabKey[i].equals("")&&tabValues[i].equals("")){
				tabKey[i]=key;
				tabValues[i]=value;
			}
		}

		return this;

	}

	
	

	public boolean isEmpty() {
		boolean bool;
		if(this.equals("")){
			bool= true;
		}
		else{
			bool= false;
		}
		return bool;
	}
	
	

	public boolean containsKey(Object key) {

		int i=0;
		boolean contient = false;
		
		for(i=0;i<tabKey.length;i++){
			if(tabKey[i].equals(key)){
				contient= true;
			}
			else{
				contient= false;
			}
		}
		return contient;

	}

	protected Object tabKey [] = new String [0];
	protected Object tabValues [] = new String [0];



	protected int indexOf (Object key){

		int index=0;
		for (int i=0; i<tabKey.length;i++){

			if (tabKey[i].equals(key)){
				index=i;
			}

			else {
				newIndexOf(key);
			}
		}

		return index;

	}


	protected int newIndexOf(Object Key){
		int indexof=0;
		int longeur = tabKey.length;
		Object tabKeys [] = new Object [longeur+1];
		Object tabValue [] = new Object [longeur+1];

		for(int i=0;i<tabKey.length;i++){
			tabKeys[i]=tabKey[i];
			tabValue[i]=tabValues[i];
		}
		tabKey=tabKeys;
		tabValues=tabValue;
		
		indexof=tabKey.length;
		return indexof;

	}
	
	protected int size(){
		int sizee = 0;
		for(int i = 0; i<tabKey.length;i++){
			if(!tabKey[i].equals(null)){
				sizee=i;
			}
		}
		return sizee;
	}

}
