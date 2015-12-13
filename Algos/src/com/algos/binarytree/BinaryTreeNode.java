package com.algos.binarytree;

import com.algos.AlgoUtil;
import com.algos.Queue;
import com.algos.Stack;

public class BinaryTreeNode {
	public int data;
	public BinaryTreeNode leftNode;
	public BinaryTreeNode rightNode;

	public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
		this.data = data;
		this.leftNode = left;
		this.rightNode = right;
	}

	public BinaryTreeNode() {

	}

	public BinaryTreeNode(int data) {
		this.data = data;
	}

	public void print() {
		AlgoUtil.printBinaryTree(this);
	}

	public void printLevelOrder() {
		printLevelOrder(this);
	}

	public void printLevelOrder(BinaryTreeNode root) {
		Queue<BinaryTreeNode> q = new Queue<BinaryTreeNode>();
		BinaryTreeNode node = null;
		int count = 0;
		if (root != null) {
			System.out.print("Level Order Traversal : ");
			q.enqueue(root);
			while (!q.isEmpty()) {
				int n = q.getCount();
				while (n > 0) {
					node = q.dequeue();
					System.out.print(node.data + " ");
					if (node.leftNode != null)
						q.enqueue(node.leftNode);
					if (node.rightNode != null)
						q.enqueue(node.rightNode);
					n--;
					count++;
				}
			}
		}
		System.out.println();
		System.out.println("Count : " + count);
	}
	
	//height is number of edged in longest path from root to leaf. use 0 instead of -1 for nodes.
	public int getHeightR(BinaryTreeNode node){
		if(node==null)return -1;
		int lheight =  getHeightR(node.leftNode);
		int rheight =  getHeightR(node.rightNode);
		if(lheight > rheight) return lheight+1;
		return rheight+1;		
	}
	
	//height is number of edges in longest path from root to leaf
	public int getHeightI(BinaryTreeNode node){
		int height =-1;
		if(node!=null){
			Queue<BinaryTreeNode> q = new Queue<BinaryTreeNode>();
			q.enqueue(node);
			while(!q.isEmpty()){
				int n = q.getCount();
				while(n>0){
					node = q.dequeue();
					if(node.leftNode!=null)q.enqueue(node.leftNode);
					if(node.rightNode!=null)q.enqueue(node.rightNode);
					n--;
				}
				height++;
			}
		}
		return height;
	}
	
	public int getHeightR(){
		return getHeightR(this);
	}
	
	public int getHeightI(){
		return getHeightI(this);
	}
	
	public void printGivenLevel(BinaryTreeNode node, int level,boolean ltr){
		if(node==null) return;
		if(level==1){
			System.out.print(node.data + " ");
			return;
		}
		if(ltr){
			printGivenLevel(node.leftNode,level-1,ltr);
			printGivenLevel(node.rightNode,level-1,ltr);
		}else{
			printGivenLevel(node.rightNode,level-1,ltr);
			printGivenLevel(node.leftNode,level-1,ltr);
		}
	}
	
	public void printLevelOrder1(BinaryTreeNode node){
		int levels = node.getHeightI() +1;
		System.out.print("Level Order Traversal1 : ");
		for(int level=1; level <= levels;level++){
			printGivenLevel(node,level,true);
		}
		System.out.println();
	}
	
	public void printReverseLevelOrder(BinaryTreeNode node){
		int levels = node.getHeightI() +1;
		System.out.print("Reverse Level Order Traversal : ");
		boolean ltr=false;
		for(int level=levels; level >=1;level--){
			printGivenLevel(node,level,true);
			ltr=!ltr;
		}
		System.out.println();
	}
	
	public void printSpiralOrder(BinaryTreeNode node){
		int levels = node.getHeightI() +1;
		System.out.print("Spiral Traversal : ");
		boolean ltr=false;
		for(int level=1; level <= levels; level++){
			printGivenLevel(node,level,ltr);
			ltr=!ltr;
		}
		System.out.println();
	}

	public void printSpiralOrder1(BinaryTreeNode node){
		Stack<BinaryTreeNode> ltr = new Stack<BinaryTreeNode>(40);
		Stack<BinaryTreeNode> rtl = new Stack<BinaryTreeNode>(40);
		if(node!=null){
			System.out.print("Spiral Traversal1 : ");
			rtl.push(node);
			while(!ltr.isEmpty() || !rtl.isEmpty()){
				while(!ltr.isEmpty()){
					node = ltr.pop();
					System.out.print(node.data + " ");
					if ( node.leftNode != null) rtl.push(node.leftNode);
					if ( node.rightNode != null) rtl.push(node.rightNode);
				}
				while(!rtl.isEmpty()){
					node = rtl.pop();
					System.out.print(node.data + " ");
					if ( node.rightNode != null) ltr.push(node.rightNode);
					if ( node.leftNode != null)ltr.push(node.leftNode);
				}
			}
		}
		System.out.println();
	}
	
	public void printInOrderI(BinaryTreeNode node){
		if(node==null) return;
		System.out.print("\nInorder Traversal using stack : ");
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>(40);	
		while(true){
			while(node!=null){
				stack.push(node);
				node=node.leftNode;
			}
			node=stack.pop();
			if(node==null)break;
			System.out.print(node.data + " ");
			node=node.rightNode;
		}
		System.out.println();
	}
	
	public void printInOrderR(BinaryTreeNode node){
		if(node!=null){
			printInOrderR(node.leftNode);
			System.out.print(node.data +" ") ;
			printInOrderR(node.rightNode);
		}
	}
	
	public void printInOrderR(){
			System.out.print("Inorder Recursive : ");
			printInOrderR(this);
	}
	
	public boolean hasLeft(){
		return this.leftNode!=null;
	}
	
	public boolean hasRight(){
		return this.rightNode!=null;
	}
	
	public boolean hasBoth(){
		return hasLeft() && hasRight();
	}
	
	public boolean isLeaf(){
		return !hasLeft() && !hasRight();
	}
	
	public int getSize(BinaryTreeNode node){
		if (node == null) return 0;
		else return 1 + getSize(node.leftNode) + getSize(node.rightNode);
	}
	
	
	public int getSize(){
		return getSize(this);
	}
}
