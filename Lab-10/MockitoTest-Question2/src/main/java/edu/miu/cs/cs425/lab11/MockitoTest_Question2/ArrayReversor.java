package edu.miu.cs.cs425.lab11.MockitoTest_Question2;

import java.util.stream.IntStream;

public class ArrayReversor {
	
	public ArrayReversor() {}
	private ArrayFlattenerService arrayFlattenerService;
	
	public ArrayReversor(ArrayFlattenerService arrayFlattenerService) {
		this.arrayFlattenerService = arrayFlattenerService;
	}
	
	
	public int[] reverseArray(int[][] input) {
		int[] flattened=arrayFlattenerService.flattenArray(input);
		
		if(input == null || input.length < 1) {
			return null;
		}
		
		
		return IntStream.range(0, flattened.length)
                .map(i -> flattened[flattened.length - 1 - i])
                .toArray();
	}
	

}

