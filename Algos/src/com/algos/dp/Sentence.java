package com.algos.dp;


import java.util.Arrays;
import java.util.List;

public class Sentence {
	static String[] dictionary = new String[]{"i", "like", "sam", "sung", "samsung", "mobile", "ice", 
			  "cream", "icecream", "man", "go", "mango","his","him","hi"};
	static List<String> dict =  Arrays.asList(dictionary);
	
	public static boolean isSentence(String prefix, String rest){
		while(!rest.isEmpty()){
			while(!dict.contains(prefix)&&!rest.isEmpty()){
				prefix=prefix+rest.charAt(0);
				rest = rest.substring(1);
			}
			if(!rest.isEmpty()){
				if(!isSentence("",rest)){
					prefix=prefix+rest.charAt(0);
					rest = rest.substring(1);
				}else{
					return true;
				}
			}
			else if(dict.contains(prefix))return true;			
		}
		return false;
	}
	
	public static void main(String[] args){
		boolean b = isSentence("","hisamshimhi");
		System.out.println("Is Sentence?" + b);
	}

}
