package com.algos;

import java.util.Arrays;

public class Matrix {
	
	public static void main(String[] args){
		int[][] M = getSquareMatrix(false);
		printMatrix(M);
		rotateMatrix2(M);
		rotateMatrix2(M);
		rotateMatrix2(M);
		rotateMatrix2(M);
		printMatrix(M);

		//printMatrix(rotateMatrix(getSquareMatrix(false)));
		
		//printSpiral(M);
	}
	
	public static int[][] rotateMatrix1(int[][] M){
		int N=M[0].length;
		int layers=N/2;
		for(int layer=0;layer<layers;layer++){
			int  S=layer,E=N-1-layer,i=S,j=E;
			while(i<E){
				int tmp=M[S][i];
				M[S][i]=M[j][S];
				M[j][S]=M[E][j];
				M[E][j]=M[i][E];
				M[i][E]=tmp;
				i++;
				j--;
			}
		}
		return M;
	}
	
	public static int[][] rotateMatrix2(int[][] M){
		int N = M[0].length;
		int layers = N/2;
		for(int R=0;R<layers;R++){
			int C=N-1-R;
			for(int i=R,j=C;i<C;i++,j--){
				int t=M[R][i];
				M[R][i]=M[j][R];
				M[j][R]=M[C][j];
				M[C][j]=M[i][C];
				M[i][C]=t;
			}
		}
		return M;
	}
	public static void printSpiral(int[][] M) {
		int R = M.length;
		int C = M[0].length;
		int rs = 0, re = R - 1, cs = 0, ce = C - 1;
		int count = 0;
		while (true) {
			for (int i = cs; i < ce; i++) {
				System.out.print(M[rs][i] + " ");
				count++;
			}
			for (int i = rs; i < re; i++) {
				System.out.print(M[i][ce] + " ");
				count++;
			}
			for (int i = ce; i > cs; i--) {
				System.out.print(M[re][i] + " ");
				count++;
			}
			for (int i = re; i > rs; i--) {
				System.out.print(M[i][cs] + " ");
				count++;
			}
			System.out.println();
			rs++;
			re--;
			cs++;
			ce--;
			if (rs >= re && cs >= ce) {
				if (R == C && (R & 1) == 1) {
					System.out.println(M[R / 2][R / 2]);
					count++;
				}
				System.out.println("Count :" + count);
				break;
			}
		}
	}
	
	/**
	 * Only square matrix can be rotated in-place. Try rectangular matrix rotation
	 * by creating a new matrix with NXM. Rectangular can be rotated in-place
	 * but not in java as it needs pointers.(I believe)
	 *  
	 * @param M
	 */
	public static int[][] rotateMatrix(int[][] M){
		int R = M.length, temp,length = R;
		int fr =0,fc=0,lr=R-1,lc=R-1;
		for(int n=1;n<=R/2;n++){
			for(int i=0;i<length-1;i++){
				temp = M[fr][fc+i];
				M[fr][fc+i] = M[lr-i][fc];
				M[lr-i][fc] = M[lr][lc-i];
				M[lr][lc-i]=M[fr+i][lc];
				M[fr+i][lc]=temp;
			}
			length -=2;
			fr++;
			fc++;
			lc--;
			lr--;
		}
		return M;
	}
	
	
	public static int[][] getSquareMatrix(boolean odd){
		int[][] oddM =  new int[][]{
				{1,2,3,4,5,6,7},
				{8,9,10,11,12,13,14},
				{15,16,17,18,19,20,21},
				{22,23,24,25,26,27,28},
				{29,30,31,32,33,34,35},
				{36,37,38,39,40,41,42},
				{43,44,45,46,47,48,49}
				};
		int[][] evenM =  new int[][]{
				{1,2,3,4,5,6,7,8},
				{9,10,11,12,13,14,15,16},
				{17,18,19,20,21,22,23,24},
				{25,26,27,28,29,30,31,32},
				{33,34,35,36,37,38,39,40},
				{41,42,43,44,45,46,47,48},
				{49,50,51,52,53,54,55,56},
				{57,58,59,60,61,62,63,64}
				};
		if(odd) return oddM;
		return evenM;
	}
	
	public static int[][] getMatrix(){
		int[][] M =  new int[][]{
				{1,2,3,4,5,6,7,8},
				{9,10,11,12,13,14,15,16},
				{17,18,19,20,21,22,23,24},
				{25,26,27,28,29,30,31,32},
				{33,34,35,36,37,38,39,40},
				{41,42,43,44,45,46,47,48},
				{49,50,51,52,53,54,55,56},
				{57,58,59,60,61,62,63,64},
				{65,66,67,68,69,70,71,72}
				};
		return M;
	}
	
	public static void printMatrix(int[][] M){
		int R = M.length;
		int C = M[0].length;
		for(int i=0;i<R;i++){
			System.out.print("[");
			for(int j=0;j<C;j++){
				System.out.print(String.format("%1$" + 3 + "s", M[i][j]));
			}
			System.out.println(" ]");
		}
		System.out.println();
	}

}
