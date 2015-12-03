package com.algos;



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
			int[] A = ArrayUtil.getRandomArray(size);
			BinaryTreeNode bst =  createBST(A);
			bst.print();
			return bst;
		}
		
		public static BinaryTreeNode createBST(int[] A){
			BinarySearchTree bst = new BinarySearchTree(A);
			return bst.getBST();
		}
		
		
		
		
}
