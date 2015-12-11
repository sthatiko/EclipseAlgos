package com.algos.binarytree;

import com.algos.AlgoUtil;
import com.algos.BinaryTreeNode;

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
	
}
