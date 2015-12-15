package com.algos.graphs;

//http://waytocrack.com/forum/index.php/48/probability-getting-destroyed-in-stepsin-matrix-for-robot

//Problem doesn't say anything about whether we can go back to previous position. 
//This solution assumes that we can not go back to previous position

public class RectangleKSteps {
	
	public static void main(String[] args){
		int k=2,m=4,n=4,x=3,y=2;
		traverse(x,y,k,m,n,-1,-1);
		System.out.println("Number of paths with k steps that are safe : " + safe);
		System.out.println("Number of paths with k steps that are destroyed : " + destroyed);
	}
	static int safe = 0, destroyed =0;
	public static void traverse(int x, int y, int steps, int m,int n, int origx, int origy ){
		if(steps==0){
			return;
		}
		if(x-1>=0){			
			if(x-1!=origx || y!=origy){
				traverse(x-1,y,steps-1,m,n,x,y);
				safe++;
			}//else it is not a valid move to go back to previous position
		}else destroyed++;
		if(x+1<=m){
			if(x+1!=origx || y!=origy){
				traverse(x+1,y,steps-1,m,n,x,y);
				safe++;
			}//else it is not a valid move to go back to previous position
		}else destroyed++;
		if(y-1>=0){
			if(x!=origx || y-1!=origy){
				traverse(x,y-1,steps-1,m,n,x,y);
				safe++;
			}//else it is not a valid move to go back to previous position
		}else destroyed++;
		if(y+1<=n){
			if(x!=origx || y+1!=origy){
				traverse(x,y+1,steps-1,m,n,x,y);
				safe++;
			}//else it is not a valid move to go back to previous position
		}else destroyed++;
	}

}
