package com.algos;

public class FirstNonRepeatingCharacter {
	private String ss;
	
	public FirstNonRepeatingCharacter(String input){
		this.ss= input;
	}
	public static void main(String[] args) {
		FirstNonRepeatingCharacter main = new FirstNonRepeatingCharacter("nvkbjdhfueurvnnvbxchldskfewpruefdjvnhkjvhfdgkjdfhnxaspwq");
		System.out.println("First Non-Repeating char : "+ main.getFirstNonRepeatingCharacter());
	}
	
	public char getFirstNonRepeatingCharacter(){
		int[] alphabetCount = new int[26];
		char[] alphabets = new char[26];
		int charIndex =0;
		for (char c:  ss.toCharArray()) {
			if(++alphabetCount[c-'a']==1){
				alphabets[charIndex++]=c; 
			}
		}
		for(char c: alphabets){
			if(alphabetCount[c-'a']==1) return c;
		}
		return ' ';
	}
}
