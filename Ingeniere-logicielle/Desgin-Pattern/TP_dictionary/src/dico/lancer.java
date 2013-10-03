package src.dico;

public class lancer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//FastDictionary fast = new FastDictionary();
	//	OrderedDictionary order = new OrderedDictionary(0);
		//System.out.println(order.size());

		//order.put("gilles", "test");
		//order.put("master", "aigle");
		//order.put("abc", "abcs");
		
		//System.out.println(order.size());
		
		FastDictionary fast = new FastDictionary(0);
		
		fast.put("a", "b");
		fast.put("c", "d");
		fast.put("e", "f");
		fast.put("g", "h");

		//int test2 = order.indexOf("aa");
		
		System.out.println("size" + fast.size());

		/*
		
	//	System.out.println("indexof: "+test2);
		//fast.isEmpty();
		//order.isEmpty();
	//	System.out.println(" taille : "+order.size());
		
		

		//System.out.println("nombre d'elements" +fast.size());
		
		//int fasts = fast.IndexOf("aa");
		//System.out.println("fasts" + fasts);
		*/
		


		

	}

}
