package com.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.algos.binarytree.BinaryTreeNode;

public class Main {
	
	static SLLNode<Integer>  head = AlgoUtil.getSampleSLL();
	
	public static void main(String[] args){
		
		indexSort(new int[]{50, 40, 70, 60, 90}, new int[]{3,  0,  4,  1,  2});
	}
	
	public static void indexSort(int[] arr, int[] index){
		int length = index.length,x;
		for(i =0; i< length; i++){
			x=arr[index[i]];
			arr[index[i]] = index[i];
			index[i]=x;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(index));
	}
	
	public static int[][] pyramidMatrix(int N) {
		  int[][] M = new int[N][N];
		  for(int i=0,x;i<N;i++){
			  x=i;
			  if(i>=N/2)x=N-1-i;
			  for(int j=0,y;j<N;j++){
				  y=j;
				  if(j>=N/2)y=N-1-j;
				  M[i][j]=1+(x>y?y:x);
		    }
		  }
		  return M;
	}
	
	public static int[][] pyramidMatrix1(int N) {
		  int[][] M = new int[N][N];
		  for(int i=0;i<(N+1)/2;i++){
			  for(int j=0;j<(N+1)/2;j++){
				  M[i][j]=M[i][N-1-j]=M[N-1-i][N-1-j]=M[N-1-i][j]=(i<j)?i+1:j+1;
		    }
		  }
		  return M;
	}
	
	static int toDec(String roman){
		int m[]=new int[1001],p=0,s=0;
		m['I']=1;m['V']=5;m['X']=10;m['L']=50;m['C']=100;m['D']=500;m['M']=1000;
		for(int i :  roman.getBytes() ){
			if(m[i]<=p)s+=m[i];
			else s=s+m[i]-2*p;
			p=m[i];
		}
		return s;
	}
	
	static String toRoman(int n){		
		String s = "";
		if(n==0) return s;
		int m[]=new int[1001],r=0,L[]={'I','V','X','L','C','D','M'},i;
		m['I']=1;m['V']=5;m['X']=10;m['L']=50;m['C']=100;m['D']=500;m['M']=1000;
		for(i =6;i>=0;i--){
			r=n/m[L[i]];
			if(r>0){
				if(r>3){
					if(s.length()>0 && s.charAt(s.length()-1)==L[i+1] && i<4&&2*m[L[i+1]]==m[L[i+2]])
						s=""+s.substring(0,s.length()-1)+(char)L[i]+""+(char)L[i+2];
					else s=s+(char)L[i]+(char)L[i+1];
				}
				else
					for(;r>0;r--)s+=(char)L[i];
				n=n%m[L[i]];
			}
		}				
		return s;
	}
	
	static String prime_encryption(String msg) {
		int p[] = new int[160];
  		String s = "";
		for (int i = 2; i < 160; i++)
			for (int j = 2; j * i < 160; j++)
				p[j * i] = 1;		
		for (int c : msg.getBytes()) 			
			if (c < 33) s += ". ";
         	else{
              	int n = c>96?c - 96:c<47?37:c-21,z=2;
	            for (; n > 0;  )
    	            if (p[z++]<1) n--; 
			    s += z - 1 + " ";
          	}
		return s.trim();
	}

	

	int f(int n){
	 return n==0?1:n*f(n-1); 
	}
	
	static int x,B,r;
	
	static int MMI(int A, int N) {
	  x=A%N;
	  if(x==1)return 1;
	  if(N==1||N%A==0) return -1;
	  B=N/x+1;
	  r=(x*B)%N;
	  if(r==1)return B;
	  B=2*N/A+1;
	  if((x*B)%N==1) return B;
	  return -1;
	}

	
	static int w[][],i,j;
	static int walksNumber(int x, int y) {
		  	w= new int[x+1][y+1];		
			for(;i<=x;i++)
				for(j=0;j<=y;j++)
	                w[i][j]=i*j==0?1:i==j?0:w[i][j-1]+w[i-1][j];
			return w[x][y]; 
	}
	
	
	private static <T> SLLNode<T> reverseSLL(SLLNode<T> head){
		if(head==null) return null;
		SLLNode<T> first = null,second= head,third=null;
		while( second!=null){
			third=second.next;
			second.next=first;
			first = second;
			second = third;
		}
		return first;
	}
	
	public static boolean isPalindrome2(SLLNode<Integer> head){
		SLLNode<Integer> middle = getMiddle(head);
		SLLNode<Integer> head2 = reverseSLL(middle),temp = head2;
		while(head2.next!=null){
			if(head.data!=head2.data) return false;
			head = head.next;
			head2= head2.next;
		}
		if(head.data==head2.data){
			middle = reverseSLL(temp);
			head.next=middle;
			return true;
		}
		return false;
	}
	
	public static <T> SLLNode<T> getMiddle(SLLNode<T> head){
		if(head==null) return null;
		SLLNode<T> slow=head, fast = head;
		while(fast!=null&&fast.next!=null){
			slow=slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private static boolean isPalindrome( SLLNode<Integer> current){
		if(current.next==null) return current.data==head.data;
		boolean result = isPalindrome(current.next);
		if(result){
			head = head.next;
			return head.data==current.data;
		}
		return false;
	}
	
	public static BinaryTreeNode findLCABST(BinaryTreeNode root,int e1, int e2){
		if(root==null) return null;
		//if(root.data==e1||root.data==e2) return root;
		if(e1<root.data && e2<root.data)return  findLCABST(root.leftNode,e1,e2);
		else if(e1>root.data && e2>root.data) return  findLCABST(root.rightNode,e1,e2);
		else return root;
	}
	public static boolean findPath(BinaryTreeNode root, int element,List<BinaryTreeNode> path){
		if(root==null) return false;
		path.add(root);
		if(root.data==element) return true;
		if(findPath(root.leftNode,element,path)||findPath(root.rightNode,element,path)) return true;
		path.remove(root);
		return false;
	}
	
	public static BinaryTreeNode findLCA(BinaryTreeNode root, int e1, int e2){
		List<BinaryTreeNode> path1 = new ArrayList<BinaryTreeNode>();
		List<BinaryTreeNode> path2 = new ArrayList<BinaryTreeNode>();
		BinaryTreeNode prev =null,temp;
		if(findPath(root,e1,path1)&&findPath(root,e2,path2)){
			Iterator<BinaryTreeNode> iter1 = path1.iterator();
			Iterator<BinaryTreeNode> iter2 = path2.iterator();
			while(iter1.hasNext()&& iter2.hasNext()){
				temp = iter1.next();
				if(temp.data!=iter2.next().data) return prev;
				else prev=temp;
			}
			return prev;
		}
		return null;
	}
	
	/**
	 * number of unique paths
	 * http://leetcode.com/2010/11/unique-paths.html
	 */
	public static int getUniquePaths(int rows, int columns){
		int[][] results = new int[rows][columns];//contains 0 by default. local variables gets memory from stack, instance variables from heap.		
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				if(i==0 || j==0)results[i][j]=1;
				else results[i][j] = results[i-1][j]+results[i][j-1];
			}
		}
		return results[rows-1][columns-1];
	}
	
	/**
	 * replaces occurrence of pattern in text with X
	 * continuous occurrences are replaces by single X
	 * http://leetcode.com/2010/11/microsoft-string-replacement-problem.html
	 * @param text
	 * @param pattern
	 * @return
	 */
	public static String replacePattern(String text, String pattern){
		char[] ctext = text.toCharArray();
		char[] cpattern = pattern.toCharArray();
		boolean matched = false;int slow=0;
		for(int fast=0;fast<text.length();){
			matched = false;
			while(isMatch(ctext,cpattern,fast)){
				fast+=pattern.length();
				matched = true;
			}
			if(matched){
				ctext[slow++] = 'X';
			}
			if(fast <ctext.length)
			ctext[slow++] = ctext[fast++];
		}
		return new String(ctext,0,slow);
		//System.out.println(replacePattern("ababd","ab"));
	}
	
	/**
	 * verifies if pattern matches with the text starting at index
	 * @param text
	 * @param pattern
	 * @param index
	 * @return
	 */
	public static boolean isMatch(char[] text, char[] pattern, int index){
		if(index>=text.length) return false;
		boolean result = true;
		for(int i=0;i<pattern.length&&result&&index <text.length;){
			result = result && (text[index++]==pattern[i++]);
		}
		return result;
	}
	/**
	 * search a 2d matrix for a number 
	 * in which all rows and columns are sorted
	 * http://leetcode.com/2010/10/searching-2d-sorted-matrix-part-ii.html
	 * @param mat
	 * @param target
	 * @return
	 */
	public static int stepLinearSearch(int[][] mat, int target){
		int n = mat.length;//number of rows
		int m = mat[0].length;//number of columns
		int currRow =0,currCol = m-1,currElem;
		while(currRow<=n-1 && currCol>=0){
			currElem = mat[currRow][currCol];
			if(currElem == target)return target;
			else if(  target < currElem) currCol--;
			else currRow++;
		}
//		if(--currRow==n-1){
//			while(currCol>=0){
//				currElem = mat[currRow][currCol];
//				if(currElem == target)return target;
//				else currCol--;
//			}
//		}
//		if(--currCol==0){
//			while(currRow<=n-1){
//				currElem = mat[currRow][currCol];
//				if(currElem == target)return target;
//				else currRow++;
//			}
//		}
		return -1;
		//System.out.print(stepLinearSearch(getIntMatrix(),88));
	}
	
	public static int[][] getIntMatrix(){
		return new int[][]{
				{1,4,7,11,15},
				{2,5,8,12,19},
				{3,6,9,16,22},
				{10,13,14,17,24},
				{18,21,23,26,30}
			};
	}
	
	public static void printLL(LLNode head){
		if(head==null) System.out.println("Empty LL");
		while(head.next!=null){
			System.out.print(head.data + "->");
			head = head.next;
		}
		System.out.print(head.data);
	}
	
	public static LLNode createLL(){
		int[] data = new int[]{74,54,12,48,23,13,72,49,29,34};
		LLNode head = new LLNode(),start=head;int i =0;
		for(;i<data.length-1;i++){
			head.data = data[i];
			head.next= new LLNode();
			head = head.next;
		}
		head.data = data[i];
		return start;
	}
	
	
	
	/**
	 * TODO: Level order traversal using BFS. Queue is needed.
	 * http://leetcode.com/2010/09/printing-binary-tree-in-level-order.html
	 */
	
	/**
	 *  post order traversal using two stacks
	 */
	public static void printPostOrder(BinaryTreeNode head){
		if(head==null) return;
		Stack<BinaryTreeNode> temp = new Stack<BinaryTreeNode>(25);
		Stack<BinaryTreeNode> finalStack = new Stack<BinaryTreeNode>(25);
		temp.push(head);
		while(temp.size() >0){
			head = temp.pop();
			finalStack.push(head);
			if(head.leftNode!=null)temp.push(head.leftNode);
			if(head.rightNode!=null)temp.push(head.rightNode);
		}
		while(finalStack.size()>0)
			System.out.print(finalStack.pop().data+ "-");
		System.out.println();
	}
	
	/**
	 * post order traversal using single stack
	 * http://leetcode.com/2010/10/binary-tree-post-order-traversal.html
	 */
	
	public static void printPostOrderSS(BinaryTreeNode head){
		if(head==null) return;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>(25);
		BinaryTreeNode prev = null;stack.push(head);
		while(stack.size()>0){
			head = stack.peek();
			if(prev==null||prev.leftNode==head||prev.rightNode==head){// we are traversing down the tree
				if(head.leftNode!=null)stack.push(head.leftNode);
				else if(head.rightNode!=null)stack.push(head.rightNode);
				else {
					System.out.print(head.data+ "-");
					stack.pop();
				}
			}
			else if(head.leftNode ==prev){// we are traversing up the tree from the left
				if(head.rightNode!=null)stack.push(head.rightNode);
				else {
					System.out.print(head.data+ "-");
					stack.pop();
				}
			}
			else if(head.rightNode ==prev){// we are traversing up the tree from the right
				System.out.print(head.data+ "-");
				stack.pop();
			}
			prev = head;
		}
	}
	
	/**
	 * preorder traversal iterative
	 * http://en.wikipedia.org/wiki/Tree_traversal
	 * we can calculate height by saving depth of each node with it.
	 * @param head
	 */	
	public static void printPreOrder(BinaryTreeNode head){
		if(head==null) return;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>(25);
		while(head!=null){
			System.out.print(head.data + "-");						
			if(head.rightNode !=null){
				stack.push(head.rightNode);
			}
			if(head.leftNode !=null){
				stack.push(head.leftNode);
			}
			head = stack.pop();
		}
	}
	
	
	
	
	/**
	 * print all permutations of a given string.
	 * doesn't handle cases of repeated letters
	 * recursive solution
	 * @param prefix
	 * @param string
	 */
	public static void printPermutations(String prefix, String string){
		if(string==null||string.isEmpty())System.out.println(prefix);
		int length = string.length();
		for(int i=0;i<length;i++){
			string = rotate(string);
			printPermutations(prefix+string.substring(0, 1),string.substring(1)); 
		}
		
		//http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
		//above link has another recursive solution, probably can be used to handle repeated characters
	}
	
	public static String rotate(String str){
		char[] input = str.toCharArray(); 
		char c=input[0];
		int i =0;
		for(i=0;i<input.length-1;i++){
			input[i]=input[i+1];
		}
		input[i]=c;
		return new String(input);
		//System.out.println(rotate("ABCDE"));
	}
	
	/**
	 * prepends passed character to each string in the list
	 * @param c
	 * @param inputList
	 * @return
	 */
	public static  List<String> prependChar(char c,List<String> inputList){
		for(int i=0;i<inputList.size();i++){
			String str = inputList.get(i);
			str = c+ str;
			inputList.set(i, str);
		}		
		return inputList;
		
		/*
		List<String> list = new ArrayList<String>();
		list.add("1234");
		list.add("abcde");
		list.add("p");
		list.add("xyz");
		System.out.print(prependChar('x',list));
		 */
	}
	
	public  static void printCartesians(List<String> list,String prefix, int index){
		int length = list.size();
		String str = list.get(index);
		if(index==length-1){
			for(char c : str.toCharArray()){
				System.out.println(prefix +c);	
			}			
		}
		else{
			for(char c : str.toCharArray()){
				printCartesians(list, prefix + c, index +1);	
			}
		}
		/*
		List<String> list = new ArrayList<String>();
		list.add("1234");
		list.add("abcde");
		list.add("p");
		list.add("xyz");
		printCartesians(list, "",0);
		 */
	}
	
	public static int[] moveZeroesToEnd(int[] input){
		//http://www.geeksforgeeks.org/move-zeroes-end-array/
		//Maintains the initial order
		int size = input.length;
		int nonZeroesFound =0;
		for(int i=0;i<size;i++){
			if(input[i]!=0){
				nonZeroesFound++;
				input[nonZeroesFound-1] = input[i];
			}
		}
		for(int i=nonZeroesFound; i<size;i++){
			input[i]=0;
		}
		System.out.println(Arrays.toString(input));
		return input;
//		int[] input = new int[] {12,0,45,67,43,0,42,0,265,0,3,5,0,22,67,67,0,45,2,0,1,0,4};
//		moveZeroesToEnd(input);
	}
	
	/**
	 * length of LCS(Substring), DP approach
	 * @param X
	 * @param Y
	 * @return
	 */
	public static int lengthofLCS(String X, String Y, boolean print){
		char[] x = X.toCharArray(), y = Y.toCharArray();
		int m = X.length(), n = Y.length();
		int L[][] = new int[m+1][n+1];//1 more to accommodate base case
		//L[i][j] holds the length of LCS of strings X[0...i-1], Y[0...j-1]
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0||j==0){ //base case sets L[0][*] and L[*][0] to 0. setup part.
					L[i][j]=0;
					System.out.println("L["+i+"]["+j+"]="+L[i][j]);
				}
				else{
					if(x[i-1]==y[j-1]){//indices will never be -1 since 0 is handled above
						L[i][j]=1+L[i-1][j-1];
						System.out.println("L["+i+"]["+j+"]="+L[i][j]);
					}
					else{
						L[i][j]=max(L[i][j-1],L[i-1][j]);
						System.out.println("L["+i+"]["+j+"]="+L[i][j]);
					}
				}
			}
		}
		if(print){
			char[] lcs = new char[L[m][n]];
			int i=m,j=n,index= lcs.length-1;
			while(i>=1 && j>=1){
				if(x[i-1]==y[j-1]){
					lcs[index] = x[i-1];
					index--;
					i--;j--;
				}else{
					if(L[i-1][j]>L[i][j-1])i--;
					else j--;
				}
			}
			System.out.println("String LCS="+new String(lcs));
		}
		return L[m][n];
		/*
		 String X= "AGGTAB";
		 String Y = "GXTXAYB";
		 System.out.print("output: "+ lengthofLCS(X,Y,true));
		 */
	}
	
	/**
	 * recursive approach to length of LCS(substring)
	 * @param X
	 * @param Y
	 * @param m
	 * @param n
	 * @return
	 */
	public static int lengthofLCS(String X, String Y, int m, int n){
		if(m==0||n==0) return 0;
		if(X.charAt(m-1)==Y.charAt(n-1)) return 1+lengthofLCS(X, Y, m-1,n-1);
		else return max(lengthofLCS(X,Y,m-1,n),lengthofLCS(X,Y,m,n-1));
		/*
		 String X= "AGGTAB";
		 String Y = "GXTXAYB";
		 System.out.print("output: "+ lengthofLCS(X,Y,X.length(),Y.length()));
		 */		
	}
	
	/**
	 * Naive implementation. Slide the pattern over the text.
	 * @param pat pattern to be searched for
	 * @param text text in which search is to be done
	 */
	public static void searchForPattern(String pat, String text){
		if(pat==null||pat.isEmpty()||text==null||text.isEmpty()) System.out.println("Input is empty");
		char[] cpat = pat.toCharArray();
		char[] ctext = text.toCharArray();
		int plength = cpat.length,tlength = ctext.length;
		System.out.println("Pattern: '"+pat+"' Text: '"+text+"'");
		for(int i=0;i<=tlength-plength;i++){
			boolean patternFound = true;
			for(int j=0;j<plength && patternFound;j++){
				patternFound = patternFound && cpat[j]==ctext[i+j];
			}
			if(patternFound)System.out.println("Pattern found at index "+ i);
		}
		//searchForPattern("ABX","YRNABGTABXJNRABXXKYVAB");
	}
	
	public static int max(int x, int y){
		return x > y? x:y;
	}
	//http://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
	//http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
}
