package com.algos;

import java.util.Arrays;

public class BinaryTreeUtil {

		public static void main(String args[]){
			BinaryTreeNode bst = getRandomBST(14);
			bst.printLevelOrder();
			bst.printLevelOrder1(bst);
			bst.printReverseLevelOrder(bst);
			bst.printSpiralOrder(bst);
			bst.printSpiralOrder1(bst);
			bst.printInOrderR();
			bst.printInOrderI(bst);
			System.out.println("Height : " + bst.getHeightR() + " ," + bst.getHeightI());
		}
		public static BinaryTreeNode getRandomBST(int size){
			int[] A = getRandomArray(size);
			BinaryTreeNode bst =  createBST(A);
			bst.print();
			return bst;
		}
		
		public static BinaryTreeNode createBST(int[] A){
			BinarySearchTree bst = new BinarySearchTree(A);
			return bst.getBST();
		}
		
		public static int[] getRandomArray(int size){
			if(size==0)size =30+(int) (Math.random()*(10));
			System.out.println("Array size : " + size);
			int[] A = new int[size];
			for(int i=0;i<size;i++){
				A[i]=(int)(Math.random()*(100));
			}
			System.out.println("A : " +Arrays.toString(A));
			return A;
		}
		
		
}
