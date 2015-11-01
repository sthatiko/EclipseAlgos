package com.algos;

import java.util.Arrays;

public class Heap {
	int[] M;
	int N;
	int heapsize;
	public Heap(int[] M){
		this.M=M;
		N=M.length;
		heapsize=N;
		heapify();
	}
	
	public void heapify(){
		for(int i=N/2;i>=0;i--){
			siftdown(i);
		}
	}
	
	public void siftdown(int i){
		int l=-1,r=-1;
		int lindex=2*i+1;
		int rindex=2*i+2;

			if(lindex<heapsize)
				l=M[lindex];
			if(rindex<heapsize)
				r=M[rindex];
			if(l>r && l>M[i]){
				swap(i,lindex);
				siftdown(lindex);
			}
			else if(r>l&&r>M[i]){
				swap(i,rindex);
				siftdown(rindex);
			}
		
	}
	
	public void sort(){
		while(heapsize>0){
			swap(0,heapsize-1);		
			heapsize--;
			siftdown(0);
		}
		System.out.println(Arrays.toString(M));
	}
	
	void swap(int i, int j){
		M[i]+=M[j];
		M[j]=M[i]-M[j];
		M[i]=M[i]-M[j];
	}
	
	public static void main(String args[]){
		int[] M = {3,74,9874,874,56,6,972,738,8734575,83,95,540,18,39};
		Heap h = new Heap(M);
		h.sort();
	}
}
