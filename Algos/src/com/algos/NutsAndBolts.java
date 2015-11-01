package com.algos;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/nuts-bolts-problem-lock-key-problem/ nuts cannot
 * be compared with bolts and bolts cannot be compared with nuts
 * http://algs4.cs.princeton.edu/23quicksort/
 * 
 * @author sthatiko
 * 
 */
public class NutsAndBolts {

	char[] nuts = { 'x', 'y', 'z', 'b', 'c','n', 'f', 'g', 'r' };
	char[] bolts = { 'b', 'c', 'g', 'r', 'x', 'y', 'f', 'z','n' };
	int[] indices = {0,1,2,3,4,5,6,7,8};

	public static void main(String[] args) {
		NutsAndBolts nb = new NutsAndBolts();
		nb.run();
	}

	public void run() {
		//matchPairs(nuts, bolts, 0, nuts.length - 1);
		quickSort(nuts,0,8);
		System.out.println(Arrays.toString(nuts));
		System.out.println(Arrays.toString(bolts));
		System.out.println(Arrays.toString(indices));
	}

	public void matchPairs(char[] nuts, char[] bolts, int low, int high) {
		if (low < high) {
			int nutIndex = partition(nuts, low, high, bolts[high]);
			int boltIndex = partition(bolts, low, high, nuts[nutIndex]);
			matchPairs(nuts, bolts, low, nutIndex - 1);
			matchPairs(nuts, bolts, boltIndex + 1, high);
		}
	}

	public int partition(char[] arr, int low, int high, int pivot) {
		int i = low;
		int j = high;
		int pivotIndex = -1;
		while (true) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (arr[i] == pivot){
				pivotIndex = j;
			}
			else if (arr[j] == pivot){
				pivotIndex = i;
			}
			if (i >= j)
				break;
			swap(arr, i, j);
		}
		return pivotIndex;
	}
	
	public void quickSort(char[] arr, int low, int high){
		if(low<high){
			int pindex = partition(arr,low,high,arr[high]);
			quickSort(arr,low,pindex-1);
			quickSort(arr,pindex+1,high);
		}
	}

	public void swap(char[] arr, int i, int j) {
		char x = arr[i];
		arr[i] = arr[j];
		arr[j] = x;
		int temp = indices[i];
		indices[i] = indices[j];
		indices[j] = temp;
	}

}
