package dico;


import static org.junit.Assert.*;

import org.junit.*;

public class Test_Ordered extends SuperTest {


	@Before
	public void setUp() throws Exception {

		idict = new OrderedDictionary(0);

	}

	@Test
	public void testAddOneElementToEmptyDico(){

		idict.put("a","b");
		assertEquals(1,((OrderedDictionary) idict).size());
		assertTrue(idict.containsKey("a"));

		System.out.println(((OrderedDictionary) idict).size());

	}

	@Test
	public void testAddTwoElementToEmptyDico(){


		idict.put("a","b");
		idict.put("c","d");

		assertEquals(2,((OrderedDictionary) idict).size());
		assertTrue(idict.containsKey("a"));
		assertTrue(idict.containsKey("c"));

		System.out.println(((OrderedDictionary) idict).size());

	}

	

	@Test
	public void testNewIndex(){

		assertEquals(0,((OrderedDictionary) idict).newIndexOf("a"));
		//assertEquals(1,ordered.newIndexOf("c"));

	}
	

	@Test
	public void testIndex(){
		idict.put("a","b");
		idict.put("c","d");


		assertEquals(0,idict.indexOf("a"));
		assertEquals(1,idict.indexOf("c"));


	}
	



}
