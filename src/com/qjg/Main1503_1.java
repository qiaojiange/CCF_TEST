package com.qjg;

import java.util.Scanner;

public class Main1503_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] nums = new int[n][m];
		int[][] afterNums = new int[m][n];
		for(int i = 0;i<n;i++){
			for(int j = 0;j<m;j++){
				nums[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0;i<n;i++){
			for(int j = 0;j<m;j++){
				afterNums[m-j-1][i] = nums[i][j];
			}
		}
		
		for(int i=0;i<m;i++){
			for(int j = 0;j<n;j++){
				System.out.print(afterNums[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
