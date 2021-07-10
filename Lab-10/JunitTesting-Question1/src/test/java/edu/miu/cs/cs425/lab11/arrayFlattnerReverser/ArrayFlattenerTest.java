package edu.miu.cs.cs425.lab11.arrayFlattnerReverser;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayFlattenerTest {
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
		 int[][] input = {{1, 3}, {0},{4, 5, 9}};
	        int[] expected={1,3,0,4,5,9};
	        int[] actual=this.arrayFlattener.flattenedArray(input);
//	        assertEquals(Arrays.toString(expected),Arrays.toString(actual));
	        assertArrayEquals(expected,actual);
		
	}

}
