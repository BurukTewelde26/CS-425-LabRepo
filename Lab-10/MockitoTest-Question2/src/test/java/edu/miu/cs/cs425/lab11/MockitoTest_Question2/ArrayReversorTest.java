package edu.miu.cs.cs425.lab11.MockitoTest_Question2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayReversorTest {

	private ArrayReversor arrayReverser;
	private ArrayFlattenerService arrayFlattenerService = mock(ArrayFlattenerService.class);
	
	@Before
	public void setUp() throws Exception {
		this.arrayReverser = new ArrayReversor(arrayFlattenerService);
	}

	@After
	public void tearDown() throws Exception {
		this.arrayReverser = null;
	}

	@Test
	public void testReverseArray() {
		int[][] input =  {{1, 3},{0}, {4, 5, 9}};
		when(arrayFlattenerService.flattenArray(input)).thenReturn(new int[] {0,1,3,4,5,9});
		int[] expected = {9,5,4,3,1,0};
		int[] actual= this.arrayReverser.reverseArray(input);
		assertArrayEquals(expected,actual);
		verify(arrayFlattenerService).flattenArray(input);
		
	}

}

