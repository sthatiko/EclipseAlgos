package com.algos;

/**
 * http://www.geeksforgeeks.org/mobile-numeric-keypad-problem/
 * 
 * implementation of my own solution. DP approach. space optimized.
 * @author sthatiko
 *
 */
public class KeyPadDPProblem {
	
	private static char[][] keypad = {
			{'1','2','3',},
			{'4','5','6'},
			{'7','8','9'},
			{'*','0','#'} };
	
	public static void main(String[] args){
		System.out.println("Possible number for N=2 are " + getValidNumberCount(2) );
		System.out.println("Possible number for N=3 are " + getValidNumberCount(3) );
		System.out.println("Possible number for N=4 are " + getValidNumberCount(4) );
		System.out.println("Possible number for N=5 are " + getValidNumberCount(5) );
	}
	
	public static int getValidNumberCount(int N){
		if(N<=0) return 0;
		if(N==1) return 10;
		int[] vals = new int[10]; 
		for(int i=0;i<4;i++){
			for(int j=0;j<3;j++){
				if( keypad[i][j]!='*' && keypad[i][j]!='#'){
					vals[keypad[i][j]-48]= getValidNumbers(i,j).length;
				}
			}
		}
		int[] copy = getCopy(vals);
		if(N>=3){
			for(int k=3;k<=N;k++){
				for(int i=0;i<4;i++){
					for(int j=0;j<3;j++){
						int[] nums =null;
						if( keypad[i][j]!='*' && keypad[i][j]!='#'){
							nums= getValidNumbers(i,j);
							int temp = 0;
							for(int l =0;l<nums.length;l++){
								temp+=vals[nums[l]];
							}
							copy[keypad[i][j]-48]=temp;
						}						
					}
				}
				vals = copy;
				copy = getCopy(copy);
			}
		}
		int sum=0;
		for(int i=0;i<10;i++){
			sum +=vals[i];
		}
		return sum;
	}
	
	public static int[] getCopy(int[] array){
		int[] copy = new int[array.length];
		for(int i=0;i<array.length;i++){
			copy[i]=array[i];
		}
		return copy;
	}
	
	public static int[] getValidNumbers(int i, int j){
		int[] temp = new int[5]; 
		int[] row= {0,0,-1,0,1};//current, left,top,right,bottom
		int[] col= {0,-1,0,1,0};
		int r=0,c=0,count =0;
		for(int move=0;move<5;move++){
			r=i+row[move];
			c=j+col[move];
			if(r>=0&& r<4 && c>=0&& c < 3 && keypad[r][c]!='*' && keypad[r][c]!='#'){
				temp[count++]=keypad[r][c]-48;
			}
		}
		int[] returnValues = new int[count];
		for(i=0;i<count;i++){
			returnValues[i]=temp[i];
		}
		return returnValues;
	}
}
