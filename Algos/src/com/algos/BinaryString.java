package com.algos;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/find-index-0-replaced-1-get-longest-continuous-sequence-1s-binary-array/
 * @author sthatiko
 *
 */
public class BinaryString {
	final int[] arr ;
	
	public BinaryString(int[] arr) {
		super();
		this.arr = arr;
	}

	public static void main(String[] args) {
		int[] a = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 };
		BinaryString bs  = new BinaryString(a);
		System.out.println(bs.getZeroIndex());
		System.out.println(Arrays.toString(bs.arr));
	}
	
	public void calculateOneSums(){
		int len = arr.length, tempSum =0, prevOneIndex =0;
		for(int i =0;i<len;i++){
			if(arr[i]==1){
				tempSum++;
				if(prevOneIndex==-1)prevOneIndex=i;
			}else{
				for(int j=prevOneIndex;j<i && j>=0;j++) 
					arr[j]=tempSum;
				tempSum =0;
				prevOneIndex = -1;
			}
		}
		if(prevOneIndex!=-1){
			for(int j=prevOneIndex;j<len && j>=0;j++) 
				arr[j]=tempSum;
		}
	}
	
	public int getZeroIndex(){
		calculateOneSums();
		int maxSum=0,maxIndex=0,sum,len = arr.length;
		for(int i=0;i<arr.length;i++){
			sum =0;
			if(arr[i]==0){
				if(i>0)sum +=arr[i-1];
				if(i<len-1)sum+=arr[i+1];
				if(sum>maxSum){
					maxSum=sum;
					maxIndex = i;
				}
			}
		}
		return maxIndex;
	}

}
