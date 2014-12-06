package com.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
class TestMain {
	
	 public static void main(String[] args) {
		 List<Integer> input = new ArrayList<Integer>();
		 input.add(1);
		 input.add(2);
		 input.add(3);
		 input.add(4);
		 List op = getAllSubsets(input);
		 System.out.println(op);
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
