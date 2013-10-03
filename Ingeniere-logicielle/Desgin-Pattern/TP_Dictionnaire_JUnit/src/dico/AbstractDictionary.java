package dico;

public abstract class AbstractDictionary implements IDictionary{

	protected Object tabKey [];
	protected Object tabValues [];




	public Object get(Object key) {
		Object keyGet = null;
		for(int i=0;i<tabKey.length;i++){

			if(tabKey[i]==key){
				keyGet= tabValues[i];
			}
		}

		return keyGet;
	}


	public Object put (Object key, Object value) {
		int ii=0;
		ii=tabKey.length;
		System.out.println("ii " +ii);
		System.out.println(key);

		int index = indexOf(key);

		System.out.println(index);

		if(index !=-1){
			tabKey[index]=key;
			tabValues[index]=value;

			System.out.println("tabKey["+index+"] " +tabKey[index].toString());
			System.out.println("tabValues["+index+"] " +tabValues[index].toString());
		}


		return this;

	}




	public boolean isEmpty() {
		boolean bool = true;
		int ab=0;


		for(int i=0;i<tabKey.length;i++){
			if(tabKey[i] != null){
				ab=1;
			}

			else{
				if(ab!=0){
			
				bool = false;
				}
			}
		}

		return bool;



	}



	public boolean containsKey(Object key) {

		int i=0;
		boolean contient = false;

		for(i=0;i<tabKey.length;i++){
			if(tabKey[i]!=null){
				if(tabKey[i]==key){
					contient= true;
				}
			}
		}
		return contient;

	}




	public int indexOf (Object key){

		int index=0;
		boolean test=false;
		for (int i=0; i<tabKey.length;i++){
			System.out.println( "i "+i);

			if(tabKey[i]!=null){

				if (tabKey[i]==key){
					System.out.println("tabKeyyyyy"+tabKey[i]);
					index=i;
					test=true;
					return index;

				}
				else{
					//System.out.println("non");
				}

			}
		}
		if (test==false){
			test=true;
			index=newIndexOf(key);
			System.out.println("nohon");

		}

		return index;


	}


	protected abstract int newIndexOf(Object Key);

	protected abstract int size();

}
