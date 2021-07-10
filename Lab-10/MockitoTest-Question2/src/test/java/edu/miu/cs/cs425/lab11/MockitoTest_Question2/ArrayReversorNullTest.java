package edu.miu.cs.cs425.lab11.MockitoTest_Question2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import static org.mockito.Mockito.*;

public class ArrayReversorNullTest {
	
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
		int [][] input = null;
		when(arrayFlattenerService.flattenArray(input)).thenReturn(null);
		int[] expected = null;
		int[] actual = this.arrayReverser.reverseArray(input);
		assertArrayEquals(expected,actual);
		verify(arrayFlattenerService).flattenArray(input);
		
	}

}

