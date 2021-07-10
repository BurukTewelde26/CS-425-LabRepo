package edu.miu.cs.cs425.lab11.arrayFlattnerReverser;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayFlattenerNullTest {
	 private ArrayFlattener arrayFlattener;

	@Before
	public void setUp() throws Exception {
		 this.arrayFlattener=new ArrayFlattener();
	}

	@After
	public void tearDown() throws Exception {
		arrayFlattener = null;
	}

	@Test
	public void testFlattenedArray() {
		 int[][] input = null;
	        int[] expected=null;
	        int[] actual=this.arrayFlattener.flattenedArray(input);
//	  
	        assertArrayEquals(expected,actual);
		
	}

}
