package dico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class SuperTest {
	
	IDictionary idict;
	
	
	
		
	

	
	@Test
	public void testNotNull(){
		idict.put("a","b");
		idict.put("c","d");

		assertNotNull(idict);

	}
	
	

	
	@Test
	public void testIsEmpty(){

		assertTrue(idict.isEmpty());
		//assertEquals(1,ordered.newIndexOf("c"));

	}

	
	@Test
	public void testGetValue(){


		idict.put("a","b");
		idict.put("c","d");

		assertEquals("b",idict.get("a"));
		assertEquals("d",idict.get("c"));

	}


}
