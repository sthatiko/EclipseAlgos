package com.algos;

import java.util.Arrays;

/**
 * TODO
 * http://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 * @author sthatiko
 *
 */
public class TrainPlatforms {
	static float arr[] = {9.00f,9.40f,9.50f,11.00f,15.00f,18.00f };
	static float dep[] = {9.10f,12.00f,11.20f,11.30f,19.00f,20.00f};
	
	public static void main(String[] args){
		int[] indices = insertionSort(dep);
		sortArrayWithIndices(indices,arr);
		//System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(dep));
		
	}
	public static void sortDeps(float[] arr){
		
	}
	
	public static int[] insertionSort(float[] arr){
		int[] indices = new int[arr.length];
		indices[0] = 0;
		for(int i=1;i<arr.length;i++){
			int j=i;
			for(;j>=1 && arr[j]<arr[j-1];j--){
					float temp = arr[j];
					arr[j] = arr[j-1];
					indices[j]=indices[j-1];
					arr[j-1] = temp;
			}
			indices[j]=i;
		}
		return indices;//indices of sorted elements
	}
	
	public static void sortArrayWithIndices(int[] indices, float[] arr){
		if(indices.length!= arr.length)System.out.println("Invalid Indices array");
		for(int i=0;i<arr.length;i++){
			float temp = arr[i];
			arr[i] = arr[indices[i]];
			arr[indices[i]] = temp;
		}
	}
}
