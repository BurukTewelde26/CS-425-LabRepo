package edu.miu.cs.cs425.lab11.arrayFlattnerReverser;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayFlattener {
    public int[] flattenedArray(int[][] input){
        if(input==null || input.length<1)
            return  null;
       int[] x= Stream.of(input).flatMapToInt(row -> IntStream.of(row))
                .toArray();
        return x;
    }
}

