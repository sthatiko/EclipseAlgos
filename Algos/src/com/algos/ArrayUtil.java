package com.algos;

import java.util.Arrays;

public class ArrayUtil {

	
	public static int[] getRandomArray(int size){
		//if(size==0)size =30+(int) (Math.random()*(10));
		System.out.println("Array size : " + size);
		int[] A = new int[size];
		for(int i=0;i<size;i++){
			A[i]=(int)(Math.random()*(100));
		}
		System.out.println("A : " +Arrays.toString(A));
		return A;
	}
	
	public static Integer[] toObject(int[] intArray) {
		Integer[] retVal = null;
		if(intArray!=null){
			retVal = new Integer[intArray.length];
			int i =0;
			for(int v : intArray){
				retVal[i++] = new Integer(v);
			}
		}
		return retVal;
	}
}
