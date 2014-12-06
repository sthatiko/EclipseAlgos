package com.algos;

/**
 * 
 * http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/
 * http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
 * @author sthatiko
 *
 */
class KMPSearchString {
	
	public static void main(String[] args){		
		kmpSearch("IS","IS THIS A THIS TEST");
	}
	
	/**
	 * Time complexity of search is O(N)
	 * @param searchString
	 * @param text
	 */
	public static void kmpSearch(String searchString, String text){
		char[] ss = searchString.toCharArray();
		char[] txt = text.toCharArray();
		int[] lps = computeLPS(searchString);
		int i=0,j=0,M=ss.length,N=txt.length;
		while(i<N){
			if(ss[j]==txt[i]){
				j++;
				i++;
			}
			if(j==M-1){
				System.out.println("Found string at index "+ (i-M+1));
				j=lps[j-1];
			}
			else if(i<N && ss[j]!=txt[i]){//mismatch after j characters had matched
				if(j!=0)
					j=lps[j-1];
				else i++;
			}
		}
	}
	
	/**
	 * LPS - longest prefix which is also a suffix.
	 * for "AAACAAAA" lps is {0,1,2,0,1,2,3,4}
	 * lps[i] holds the lps for string starting at index 0 and 
	 * ending at index i. Time complexity is O(M)
	 * @param searchString
	 * @return
	 */
	public static  int[] computeLPS(String searchString){
		char[] ss = searchString.toCharArray();
		int M = ss.length,len=0,i=1;
		int[] lps = new int[M];
		lps[0] = 0;
		while(i<M){
			if(ss[len]==ss[i]){
				len++;
				lps[i]=len;
				i++;				
			}
			else{
				if(len==0){
					lps[i]=0;
					i++;
				}else{
					len = lps[len-1];
					/*
					 * len = lps[len -1] is essentially backtracking. It means we 
					 * couldn't extend the Longest Prefix(LP) found so far, 
					 * but there could be a sub prefix within this LP. 
					 * lps[len-1] returns the length of longest sub prefix of LP.
					 */
				}
			}
		}
		return lps;
	}

}
