package com.algos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * http://www.redditmirror.cc/cache/websites/www.pcplus.co.uk_8tw1x/www.pcplus.co.uk/files/pcp_images/PCP282theoryfigure2.png
 * @author sthatiko
 *
 */
public class TernarySearchTree {
	private Node root;
	List<String> words ;
	String fileName;
	
	private class Node{
		char data;
		boolean endOfString;
		Node leftPtr;
		Node rightPtr;
		Node eqlPtr;
		public Node(char c) {
			this.data = c;
		}
	}
	
	private void loadWords() {
		words = new ArrayList<String>();
		Scanner in = null;
		try {
			in = new Scanner(getClass().getResourceAsStream("/"+fileName));
			String line;
			while (in.hasNext() ) {
				line = in.nextLine();
				words.add(line);				
			}
		} finally {
			if (in != null)
				in.close();
		}
	}
	
	private void createTST(){
		for(String word: words){
			this.root = insert(root, word.toCharArray(),0);
		}
	}
	
	private Node insert(Node root, char[] word, int index){
		if(root==null){
			root = new Node(word[index]);
		}
		if(word[index]<root.data){
			root.leftPtr=insert(root.leftPtr,word,index);
		}else if(word[index] > root.data){
			root.rightPtr =  insert(root.rightPtr,word,index);
		}else{
			if(index+1<word.length)
				root.eqlPtr =insert(root.eqlPtr,word,++index);
			else root.endOfString = true;
		}
		return root;
	}
	
	private boolean deleteWord(String word){
		return deleteWord(root, word.toCharArray(), 0);
	}
	
	private boolean deleteWord(Node root, char[] word,int index){
		if(root==null||word.length ==0) return false;
		if(root.data==word[index]){
			if(word.length-1==index && root.endOfString) {
				root.endOfString = false;
				return true;
			}
			return deleteWord(root.eqlPtr,word,++index);
		}
		else if(word[index]< root.data) return deleteWord(root.leftPtr,word,index);
		else return deleteWord(root.rightPtr,word,index);
	}
	
	public boolean findWord(String word){
		return findWord(root,word.toCharArray(),0);
	}
	
	private boolean findWord(Node root, char[] word, int index){
		if(root==null||word.length ==0) return false;
		if(root.data==word[index]){
			if(word.length-1==index) return root.endOfString;
			return findWord(root.eqlPtr,word,++index);
		}
		else if(word[index]< root.data) return findWord(root.leftPtr,word,index);
		else return findWord(root.rightPtr,word,index);
	}
	
	public Node getNode(String word){
		return getNode(root,word.toCharArray(),0);
	}
	
	private Node getNode(Node root, char[] word, int index){
		if(root==null||word.length ==0) return null;
		if(root.data==word[index]){
			if(word.length-1==index) return root;
			return getNode(root.eqlPtr,word,++index);
		}
		else if(word[index]< root.data) return getNode(root.leftPtr,word,index);
		else return getNode(root.rightPtr,word,index);
	}
	
	public TernarySearchTree(String fileName) {	
		this.fileName = fileName;
		loadWords();
		createTST();
	}
	
	public List<String> getSuggestions(String word){
		Node n = getNode(word);
		List<String> matches = new ArrayList<String>();
		if(n!=null){
			getMatches(n,matches,word);
		}
		return matches;
	}
	
	private void getMatches(Node start, List<String> matches, String prefix){
		if(start.endOfString)matches.add(prefix);
		if(start.leftPtr!=null)getMatches(start.leftPtr,matches,prefix.substring(0, prefix.length() -1)+start.leftPtr.data);
		if(start.eqlPtr!=null)getMatches(start.eqlPtr,matches,prefix+start.eqlPtr.data);
		if(start.rightPtr!=null)getMatches(start.rightPtr,matches,prefix.substring(0, prefix.length() -1)+start.rightPtr.data);		
	}
	
	public static void main(String[] args) {
		TernarySearchTree m = new TernarySearchTree("dictionary.txt");
		System.out.println("Number of words in dictionary : "+m.words.size());
		List<String> sugg = m.getSuggestions("abdomin");
		for(String s: sugg){
			System.out.println(s+ " : "+m.findWord(s));
		}
	}
}
