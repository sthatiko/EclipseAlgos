package com.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
class TestMain {
	 
	 static int[] sortedRotatedE = {8,9,10,11,12,1,2,3,4,5,6,7};
	 static int[] sortedRotatedO = {8,9,10,11,12,13,1,2,3,4,5,6,7};
	 static int[] sortedAE = {1,2,3,4,5,6,7,8,9,10,11,12};
	 static int[] sortedAO = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	 static int[] sortedDE = {12,11,10,9,8,7,6,5,4,3,2,1};
	 static int[] sortedDO = {13,12,11,10,9,8,7,6,5,4,3,2,1};
	
	 public static void main(String[] args) {
		 List<Integer> input = new ArrayList<Integer>();
		 input.add(1);
		 input.add(2);
		 input.add(3);
		 input.add(4);
		 //List op = getAllSubsets(input);
//		 for(int i=0;i<sortedAO.length;i++){
//			 rotateArray(sortedAO);
//			 System.out.println(findMin(sortedAO,0,sortedAO.length-1));
//		 }
		 System.out.println(numberOfCarries(99,99,0));
	}
	 
	static int numberOfCarries(int a, int b, int c) {
		if((a|b)>0){
			 c+=a%10+b%10;
		   return (c/=10)+numberOfCarries(a/10,b/10,c);
		  }
		  return 0;
		}
	
	/**
	 * for sorted array rotated unknown number of times find the min 
	 * http://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/
	 * http://stackoverflow.com/questions/5946155/searching-a-element-in-a-array-which-is-rotated-n-times
	 * @param arr
	 * @param lo
	 * @param hi
	 * @return
	 */
	public static int findMin(int[] arr, int lo, int hi){ 
		if(hi<lo)return arr[0];
		if(hi==lo) return arr[lo];
		int mid = lo+ (hi-lo)/2;
		if(mid>lo && arr[mid]<arr[mid-1]) return  arr[mid];
		if(mid<hi && arr[mid]>arr[mid+1]) return  arr[mid+1];
		if(arr[mid]<arr[hi])return  findMin(arr,lo,mid-1);
		return findMin(arr,mid+1,hi);	
	}
	
	public static void rotateArray(int[] arr){
		int len = arr.length;
		if(len<=1)return;
		int temp = arr[len-1];
		for(int i=len-1;i>=1;i--){
			arr[i] = arr[i-1];
		}
		arr[0]=temp;
	}
	public static List<ArrayList<Integer>> getAllSubsets(List<Integer> input){
		ArrayList<ArrayList<Integer>> allSubSets = new ArrayList<ArrayList<Integer>>();
		allSubSets.add(new ArrayList<Integer>());
		if(input.size()==0)return allSubSets;
		for(int i=0;i<input.size();i++){
			List<ArrayList<Integer>> moreSubSets =  listCopy(allSubSets);
			for(ArrayList<Integer> subSet:moreSubSets){
				subSet.add(input.get(i));
			}
			allSubSets.addAll(moreSubSets);
		}
		return allSubSets;
	}
	
	public  static  List<ArrayList<Integer>> listCopy(List<ArrayList<Integer>> input){
		List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> e: input){
			result.add((ArrayList<Integer>) e.clone());
		}
		return result;
	}
	
//	public static List<ArrayList<Integer>> getSubSets(List<ArrayList<Integer>> subsets, int index){
//		
//	}
	 
	
	
	public static int updateBits(int n, int m, int i, int j) {
		 int max = ~0; /* All 1’s */
		
		 // 1’s through position j, then 0’s
		 int left = max - ((1 << j+1) - 1);
		
		 // 1’s after position i
		 int right = ((1 << i) - 1);
		
		 // 1’s, with 0s between i and j
		 int mask = left | right;
		
		 // Clear i through j, then put m in there
		 return (n & mask) | (m << i);
	}
	
	private static class BinaryTreeNode{
		int data;
		BinaryTreeNode leftNode;
		BinaryTreeNode rightNode;
		boolean visited;
		
		private BinaryTreeNode(int data ){
			this.data = data;
		}
	}	
	
	public static BinaryTreeNode getBinaryTree(){
		BinaryTreeNode root = new BinaryTreeNode(5);
		root.leftNode = new BinaryTreeNode(4);
		root.rightNode = new BinaryTreeNode(8);
		root.leftNode.leftNode = new BinaryTreeNode(11);
		root.leftNode.leftNode.leftNode = new BinaryTreeNode(7);
		root.leftNode.leftNode.rightNode = new BinaryTreeNode(2);
		root.rightNode.leftNode = new BinaryTreeNode(13);
		root.rightNode.rightNode = new BinaryTreeNode(4);
		root.rightNode.rightNode.leftNode = new BinaryTreeNode(5);
		root.rightNode.rightNode.rightNode = new BinaryTreeNode(1);
		return root;
	}
	
	

	
	/**
	 * Given a number n, find the smallest number that has same 
	 * set of digits as n and is greater than n.
	 * @param num
	 * @return
	 */
	public static  char[]  nextGreatestNum(long num){//2687653
		char[] number = (""+num).toCharArray();
		int i=number.length-1;
		for(;i>0;i--){
			if(number[i-1]<number[i])break;
		}
		if(i==0) return "Not Possible".toCharArray();
		char temp = number[i-1];
		int j=number.length-1;
		//swaps the characters
		for(;j>=i;j--){
			if(number[j]>temp){
				number[i-1]=number[j];
				number[j] = temp;
				break;
			}
		}//2786653
		//sorts the remaining part in descending order
		for(;j<number.length-1;j++){
			if(number[j]<number[j+1]){
				temp=number[j];
				number[j]=number[j+1];
				number[j+1]=temp;
			}
		}
		//sort the remaining part in ascending order
		while(i<j){
			temp=number[i];
			number[i]=number[j];
			number[j]=temp;j--;i++;
		}		
		return number;
		//http://www.geeksforgeeks.org/find-next-greater-number-set-digits/
		//System.out.println(nextGreatestNum(2687653));
	}
	
	/**
	 * Convert a BST into inorder, preorder and postorder linkedlists inplace.
	 */
}
