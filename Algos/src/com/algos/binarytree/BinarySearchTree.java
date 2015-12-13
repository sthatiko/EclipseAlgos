package com.algos.binarytree;

import com.algos.AlgoUtil;
import com.algos.ArrayUtil;

public class BinarySearchTree {
	private int[] A;
	private BinaryTreeNode root;
	boolean initialized = false;
	
	public BinarySearchTree(int[] a) {
		super();
		A = a;
		init();
	}
	
	public void init(){
		if(!initialized){
			for(int e : A){
				root = insertBST(root, e);
			}
			initialized=true;
		}
	}
	
	private BinaryTreeNode insertBST(BinaryTreeNode node,int e){
		if(node==null){
			return new BinaryTreeNode(e);
		}
		if(e > node.data) {
			node.rightNode = insertBST(node.rightNode,e);
		}
		else{
			node.leftNode = insertBST(node.leftNode,e);
		}
		return node;
	}

	public BinaryTreeNode getBST(){
		return root;
	}
	
	public void printBST(){
		AlgoUtil.printBinaryTree(root);
	}
	
	public static boolean search(BinaryTreeNode root, int element){
		if(root.data==element) return true;
		else if(element < root.data) return  search(root.leftNode,element);
		else return search(root.rightNode,element);
	}
	
	/**
	 * Given an integer sum, find if there are two integers in bst whose sum is sum.
	 *  
	 * #orig
	 */
	public static boolean twoElementsWithSum(BinaryTreeNode bstnode, int sum){
		while(bstnode.data>=sum)bstnode = bstnode.leftNode;
		int b=sum - bstnode.data;
		if(b>bstnode.data && search(bstnode.rightNode,b)){
			System.out.print(bstnode.data + " " + b);
			return true;
		}
		else if(search(bstnode.leftNode,b)){
			System.out.print(bstnode.data + " " + b);
			return true;
		}
		return twoElementsWithSum(bstnode.leftNode,sum) || twoElementsWithSum(bstnode.rightNode,sum);
	}
	
	public static void main(String[] args){
		int[] A = ArrayUtil.getRandomArray(17);
		BinarySearchTree bst = new BinarySearchTree(A);
		int sum = A[0]+A[8];
		twoElementsWithSum(bst.getBST(),sum);
	}
	
}
