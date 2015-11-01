package com.algos;

import java.util.ArrayList;

public class StringAlgos {

	static char[] testString = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M'};
	static boolean[] charsPresent = new boolean[256];
	static char[] string =new char[3];
	public static void main(String[] args) {
		long l1 = System.nanoTime();
		printPermsSorted(3,3);
		System.out.println(count);
		count =0;
		long l2 = System.nanoTime();
		printPermutations("","AAB");
		System.out.println(count);
		long l3 = System.nanoTime();
		System.out.println("M1: " + (l2-l1));
		System.out.println("M2: " + (l3-l2));
	}

	public static void printPermsSorted(int level, int N){
		if(level==0) {
			System.out.println(string);	
			count++;
			return;
		}		
		for(int i=0;i<N;i++){
			if(!charsPresent[testString[i]]){
				charsPresent[testString[i]] = true;
				string[N-level]=testString[i];
				printPermsSorted(level-1,N);
				charsPresent[testString[i]] = false;
			}
		}
	}
	

	public static ArrayList<String> getPermutations(String s){
		ArrayList<String> ret = new ArrayList<String>();
		if(s==null || s.length()==0) {
			ret.add("");
			return ret;
		}
		for(int i=1;i<=s.length();i++){
			s=rotate(s);
			ArrayList<String> temp = getPermutations(s.substring(1));
			for(String a: temp){
				ret.add(s.charAt(0)+a);
			}
		}
		return ret;
	}
	
	static String lastPrinted = "";
	//for this method to print in sorted order initial string that 
	//is passed should have characters in sorted order
	public static void printPermutations(String prefix, String s){		
		if(s==null||s.length()==0){
			if(!lastPrinted.equals(prefix)){//to handle duplicate characters. not working for AAB
				System.out.println(prefix);
				count++;
				lastPrinted = prefix;
			}			
			return;
		}
		for(int i=0;i<s.length();i++){
			printPermutations(prefix+s.charAt(0),s.substring(1));
			s=swapAtIndex(s,i+1);//for sorted order otherwise rotate can be used
		}
		//printPermutations("","123");
	}
	
	public static String rotate(String s){
		return s.substring(1)+s.charAt(0);
	}
	
	/**
	 * char at index and char at 0 are swapped and returned 
	 * @param s
	 * @param index
	 * @return
	 */
	public static String swapAtIndex(String s, int index){
		if(index>=s.length())return s;
		char[] temp = s.toCharArray();
		char t=temp[0];
		temp[0] = temp[index];
		temp[index] = t;
		return new String(temp);
	}
	
	/**
	 * for n=3 prints 123,132,213,231,312,321
	 * print all permutations in sorted order. only for integers.
	 * @param n
	 */
	public static void printNumbers(int n){
		printNumbers(0,n,n);
		System.out.println(count);
	}	
	static int bitMap =0,count=0;
	static char[] str = {'A','B','C','D','E','F','G','H','I'};
	private static void printNumbers(int num, int level, int N){
		count++;
		if(level==0){
			char[] t = new char[N];
			int a = num,i=N-1;
			while(num!=0){
				t[i--]=str[num%10-1];
				num /=10;
			}
			System.out.println(a+ " - "+new String(t));
			return;
		}
		//int bitMap = getBitMapForNum(num);
		for(int i=1;i<=N;i++){
			if(!isSet(bitMap,i)){
				bitMap = setBit(bitMap,i);
				printNumbers(num*10+i,level-1,N);
				bitMap = unsetBit(bitMap,i);
			}
		}
	}
	
	/**
	 *  For int 123 returns 0000 0000 0000 1110
	 *  For int 1247 returns 0000 0000 1001 0110
	 *   
	 * @param num
	 * @return
	 */
	public static int getBitMapForNum(int num){
		int bitMap = 0;
		while(num!=0 ){
			bitMap = setBit(bitMap,num%10);
			num /=10;
		}
		return bitMap;
	}
	
	public static int setBit(int bitMap, int index){
		int mask = 0x1;
		mask=mask<<index;
		return bitMap |= mask;
	}
	
	public static int unsetBit(int bitMap, int index){
		int mask = 1;
		mask =mask<<index;
		mask = ~mask;
		return bitMap &=mask;
	}
	
	public static boolean isSet(int bitMap, int index){
		int mask = 0x1;
		mask = mask<<index;
		return (bitMap&mask)!=0;
	}
	
	/**
	 * calculates runtime of printNumbers method for input n
	 * Draw method call tree to understand this
	 * http://math.stackexchange.com/questions/161314/what-is-the-sum-of-following-permutation-series-np0-np1-np2-cdots-npn
	 * @param n
	 * @return
	 */
	public static int getRunTime(int n){
		int c =1,total=c, x=n;
		while(n>0){
			c =c*n--;
			total +=c;
		}
		// return total;
		return (int) (factorial(x)*Math.E);		
	}
	
	public static int factorial(int n){
		if(n==0) return 1;
		return n*factorial(n-1);
	}

}
