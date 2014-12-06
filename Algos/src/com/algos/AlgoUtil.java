package com.algos;

import java.util.Formatter;

public class AlgoUtil {
	
	public static int[][] getSampleMatrix(){
		int[][] matrix = new int[][]{
				{1,2,-1,-4,-20},
				{-8,-3,4,2,1},
				{3,8,10,1,3},
				{-4,-1,1,7,-6},
				{1,2,3,4,5}
		};
		return matrix;
	}
	
	public static <T> void printSLL(SLLNode<T> node){
		while(node!=null){
			System.out.print(node.data);
			if(node.next!=null)
				System.out.print("->");
			node = node.next;
		}
		System.out.println("Printing Done!!");
	}
	
	public static <T> SLLNode<T> createSLL(T[] values){		
		SLLNode<T> head = null,current=null;
		for(T i: values){
			if(head==null){
				head = new SLLNode<T>(i);
				current = head;
				continue;
			}
			current.next = new SLLNode<T>(i);
			current = current.next;
		}
		return head;
	}
	
	public static SLLNode<Integer> getSampleSLL(){
		//Integer[] values = {8,6,3,7,45,27,18,14,25,34,81};
		Integer[] values = {8,6,3,7,3,6,8};
		return createSLL((Integer[])values);
	}
	
	public static BinaryTreeNode getSampleBST(){
		int[] data = new int[]{74,54,12,48,23,13,72,49,29,34,100,94,97,120,78,};
		BinaryTreeNode head=null ,current=null,parent=null ;
		int currentInt ;
		for(int i=0;i<data.length;i++){
			currentInt = data[i];
			if(head==null){
				head = new BinaryTreeNode(currentInt);
				continue;
			}
			current = head;
			while(current!=null){
				parent = current;
				if(currentInt <= current.data)current = current.leftNode;
				else current = current.rightNode;
			}
			if(currentInt <=parent.data) parent.leftNode = new BinaryTreeNode(currentInt);
			else parent.rightNode = new BinaryTreeNode(currentInt);
		}
		return head;
	}
	/**
	 * level  Control how wide you want the tree to sparse (eg, level 1 has the minimum space between nodes, while level 2 has a larger space between nodes)
     * indentSpace  Change this to add some indent space to the left (eg, indentSpace of 0 means the lowest level of the left node will stick to the left margin)
	 * @param root
	 */
	public static void printBinaryTree(BinaryTreeNode root){
		if(root==null)return ;
		
		int num,h = getHeightIter(root),nodesInThisLevel = 1,i=0 ; 
		BinaryTreeNode temp;
		int nodeWidth = 4*((int)Math.pow(2, h-1));		
		Queue<BinaryTreeNode> q = new Queue<BinaryTreeNode>( 128);
		q.enqueue(root);
		while(i<h){
			num = q.getCount();
		    printNodes(nodeWidth, nodesInThisLevel, q);
			while(num>0){
				temp = q.dequeue();
				if(temp!=null ){
					q.enqueue(temp.leftNode);
					q.enqueue(temp.rightNode);
				}
				else{
					q.enqueue(null);
					q.enqueue(null);
				}
				num--;
			}
			nodesInThisLevel *=2;
			i++;nodeWidth/=2;
		}
	}
	
	public static void printNode(BinaryTreeNode node, int nodeWidth){
		if(node==null)System.out.print(padLeft("",nodeWidth,' '));
		else{
			Integer n = node.data;
			System.out.print(padLeft("",nodeWidth/4,' '));
			System.out.print(padLeft(n.toString(),nodeWidth/4,'_'));
			System.out.print(padLeft("",nodeWidth/4,'_'));
			System.out.print(padLeft("",nodeWidth/4,' '));
		}
	}

	private static void printNodes(int nodeWidth,  int nodesInThisLevel, Queue<BinaryTreeNode> q){
		BinaryTreeNode node = null;
		for (int i = 0; i < nodesInThisLevel; i++) {
			node=q.dequeue();
			printNode(node,nodeWidth);
			q.enqueue(node);
		}
		System.out.println();
		System.out.println();
	}
	
	/**
	 * Height is number of nodes across the path from root to deepest leaf node.
	 * Recursive version
	 * @param root
	 * @return
	 */
	public static int getHeight(BinaryTreeNode root){
		int height =-1;
		if(root==null) height = 0;
		else{
			return max(getHeight(root.leftNode),getHeight(root.rightNode))+1;
		}
		return height;
	}
	/**
	 * http://www.geeksforgeeks.org/iterative-method-to-find-height-of-binary-tree/
	 * @param root
	 * @return
	 */
	public static int getHeightIter(BinaryTreeNode root){
		int height=0,num; 
		BinaryTreeNode temp;
		if(root==null) 
			return height;
		Queue<BinaryTreeNode> q = new Queue<BinaryTreeNode>( 15);
		q.enqueue(root);
		while(!q.isEmpty()){
			height++;
			num = q.getCount();
			while(num>0){//this while loop is to dequeue all children at a given level and enqueue all children at next level.
				temp = q.dequeue();
				if(temp!=null){
					if(temp.leftNode!=null) q.enqueue(temp.leftNode);
					if(temp.rightNode!=null) q.enqueue(temp.rightNode);
				}
				num--;
			}
		}
		return height;
	}
	
	public static int max(int a, int b){
		return a>b? a:b;
	}
	
	public static String padLeft(String str, int n, char padChar) {
	    StringBuffer strb = new StringBuffer();
	    for(int i=0;i<n-str.length();i++){
	    	strb.append(padChar);
	    }
	    strb.append(str);
	    return strb.toString();
		//return String.format("%1$" + n + "s", str);  
	}
	
	public static String padRight(String str, int n,char padChar) {
		StringBuffer strb = new StringBuffer();
		strb.append(str);
	    for(int i=0;i<n-str.length();i++){
	    	strb.append(padChar);
	    }
	    
	    return strb.toString();
		//return String.format("%1$-" + n + "s", str);  
	}
	
	public static void main(String... args){
		//System.out.println(getHeight(getSampleBST()));
		printBinaryTree(getSampleBST());
	}
	
	public static <T> void reverseQ(Queue<T> q){
		if(q.isEmpty()) return ;
		T e = q.dequeue();
		reverseQ(q);
		q.enqueue(e);
	}
}
