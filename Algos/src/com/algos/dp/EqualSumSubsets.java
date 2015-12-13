package com.algos.dp;

import com.algos.AlgoUtil;
import com.algos.ArrayUtil;

//http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
//http://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
public class EqualSumSubsets {

	public static void main(String args[]) {
		// int[] A = ArrayUtil.getRandomArray(AlgoUtil.getRandomInteger());
		int[] A = ArrayUtil.getRandomArray(4);
		int sum = 0;
		for (int i : A) {
			sum += i;
		}
		System.out.println("SUM : " + sum);
		if ((sum & 1) == 1) {
			System.out.println("Equal sum subset exists? " + "false");
			// return;
		}

		boolean[][] DP = new boolean[A.length][sum + 1];

		for (int i = 0; i < A.length; i++) {
			DP[i][0] = true; // empty osubset has sum 0
		}
		for (int j = 0; j <= sum / 2; j++) {
			DP[0][j] = (j == A[0] ? true : false);
		}
		for (int i = 1; i < A.length; i++) {
			for (int j = 1; j <= sum / 2; j++) {
				DP[i][j] = DP[i - 1][j];// if A[i] is not part of subset
				if (j >= A[i])
					DP[i][j] = DP[i][j] || DP[i - 1][j - A[i]];// if A[i] is
																// part of
																// subset
			}
		}
		System.out.println("Equal sum subset exists? " + DP[A.length - 1][sum / 2]);
		// code for minimize difference between subset sum
		int j;
		for (j = sum / 2; j >= 1; j--) {
			if (DP[A.length - 1][j]) {
				// this means that there exists a subset whose sum is j, we are
				// starting with j=sum/2
				// to minimize the difference between subset sums
				int s2 = sum - j;// sum of elements of remaining subset
				int diff = Math.abs(j - s2);
				System.out.println("Minimum difference between subsets : " + diff);
				break;
			}
		}
		// construct one subset
		int i = A.length - 1;
		while (i > 0 && j >= 0) {
			if (j >= A[i] && DP[i - 1][j - A[i]]) {
				System.out.print(A[i] + " ");
				j = j - A[i];
			}
			i--;
		}
		if (j != 0)// A[0] is not considered in previous loop. if j!=0 then A[0]
					// is part of subset
			System.out.print(A[0] + " ");
	}
}
