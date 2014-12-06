package com.algos;

public class BinaryTreeNode {
	int data;
	BinaryTreeNode leftNode;
	BinaryTreeNode rightNode;
	
	public BinaryTreeNode(int data,BinaryTreeNode left, BinaryTreeNode right ){
		this.data = data;
		this.leftNode = left;
		this.rightNode = right;
	}
	public BinaryTreeNode( ){

	}
	public BinaryTreeNode(int data ){
		this.data = data;
	}
}
