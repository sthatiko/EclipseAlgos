package com.algos;

import java.util.Arrays;

public class BiTreeVerticalSum {
	public static int left=0,  right=0;
	public static int[] sums;
	public static void main(String[] args){
		BinaryTreeNode root = getSampleBST();
		printVerticalSum(root);
	}
	
	public static void printVerticalSum(BinaryTreeNode root){
		int count =  getWidth(root);
		left = Math.abs(left);
		sums = new int[count];
		calculateSums(root,0);
		System.out.println(Arrays.toString(sums));
	}
	
	public static int getWidth(BinaryTreeNode root){
		int localleft=0, localright=0;
		BinaryTreeNode leftN = root.leftNode;
		BinaryTreeNode rightN = root.rightNode;
		while(leftN !=null){			
			if(leftN.leftNode==null && leftN.rightNode!=null){
				leftN = leftN.rightNode;
				localleft--;
			}else {
				leftN = leftN.leftNode;
				localleft++;
			}
			if(localleft>left){
				left=localleft;
			}
		}
		while(rightN !=null){				
			if(rightN.rightNode==null && rightN.leftNode!=null){
				rightN = rightN.leftNode;
				localright--;
			}else {
				rightN = rightN.rightNode;
				localright++;
			}
			if(localright>right){
				right=localright;
			}
		}
		return right+left+1;
	}
	
	public static void calculateSums(BinaryTreeNode root,int hd){
		if(root==null) return;
		calculateSums(root.leftNode,hd-1);
		sums[hd+left] +=root.data;
		calculateSums(root.rightNode,hd+1);
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
}
