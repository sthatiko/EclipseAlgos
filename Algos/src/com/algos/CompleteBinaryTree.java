package com.algos;

public class CompleteBinaryTree {
	
	int[] elements;
	BinaryTreeNode root ;
	Queue<BinaryTreeNode> q;
	
	public static void main(String[] args){
		int[] arr =  ArrayUtil.getRandomArray(14);
		//CompleteBinaryTree cbt = new CompleteBinaryTree(arr);
		System.out.print(isCompleteBinaryTree(BinaryTreeUtil.getRandomBST(1)));
	}
	
	public CompleteBinaryTree(int[] elements){
		this.elements = elements;
		if(elements.length > 0) init();
		else System.out.print("Empty array passed to Complete Binary Tree");
	}	
	
	public void init(){
		int size = elements.length;
		q = new Queue<BinaryTreeNode>(size);
		if(size > 0){
			root = new BinaryTreeNode(elements[0]);
			q.enqueue(root);
		}	
		for(int i=1;i<size;i++){
			insert(elements[i]);
		}
		root.print();
	}
	
	private void insert(int element){
		BinaryTreeNode node = q.front(), temp;
		if(!node.hasLeft()){			
			temp = new BinaryTreeNode(element);
			node.leftNode = temp;
			q.enqueue(temp);
		}else if(!node.hasRight()){
			temp = new BinaryTreeNode(element);
			node.rightNode = temp;
			q.enqueue(temp);
		}else{
			q.dequeue();
			insert(element);
		}
	}
	
	public static BinaryTreeNode getSampleTree(int size){
		int[] arr =  ArrayUtil.getRandomArray(25);
		CompleteBinaryTree cbt = new CompleteBinaryTree(arr);
		return cbt.root;
	}
	
	public static boolean isCompleteBinaryTree(BinaryTreeNode node){
		if(node == null) return true;
		Queue<BinaryTreeNode> q = new Queue<BinaryTreeNode>(node.getSize());
		q.enqueue(node);
		while(true){
			node = q.dequeue();
			if(!node.hasLeft() && node.hasRight()) return false;
			if (node.isLeaf()) break;
			if(node.hasLeft())q.enqueue(node.leftNode);
			if(node.hasRight())q.enqueue(node.rightNode);
			else break;
		}
		while(!q.isEmpty()){
			if(!q.dequeue().isLeaf()) return false;
		}
		return true;
	}

}
