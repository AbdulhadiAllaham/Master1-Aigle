package dico;


import static org.junit.Assert.*;

import org.junit.*;

public class Test_Fast extends SuperTest {


	@Before
	public void setUp() throws Exception {

		idict = new FastDictionary(0);

	}

	@Test
	public void testAddOneElementToEmptyDicoFast(){

		idict.put("a","b");
		assertEquals(1,((FastDictionary) idict).size());
		assertTrue(idict.containsKey("a"));
		System.out.println("premier test");
		System.out.println(((FastDictionary) idict).size());

	}

	@Test
	public void testAddTwoElementToEmptyDico(){


		idict.put("a","b");
		idict.put("c","d");

		assertEquals(2,((FastDictionary) idict).size());
		assertTrue(idict.containsKey("a"));
		assertTrue(idict.containsKey("c"));

		System.out.println(((FastDictionary) idict).size());

	}

	
	@Test
	public void testSizeFast(){


		idict.put("a","b");
		idict.put("c","d");
		idict.put("e","f");
		//idict.put("g","h");
		//idict.put("i","j");

		//assertEquals(3,((FastDictionary) idict).size());
		assertTrue(idict.containsKey("a"));
		assertTrue(idict.containsKey("c"));
		assertTrue(idict.containsKey("e"));
		
		assertEquals(4,((FastDictionary) idict).returnLength());


	}
	
	/*
	@Test
	public void testNewIndex(){

		assertEquals(0,((OrderedDictionary) idict).newIndexOf("a"));
		//assertEquals(1,ordered.newIndexOf("c"));

	}
	


*/

}
