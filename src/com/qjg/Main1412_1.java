package com.qjg;

import java.util.Scanner;

public class Main1412_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//谁是注释
		int[] hash = new int[1001];
		int[] record = new int[n];
		int[] result = new int[n];
		for(int i = 0;i<n;i++){
			record[i] = sc.nextInt();
			hash[record[i]]++;
			result[i] = hash[record[i]];
		}
		for(int i = 0;i<n;i++){
			System.out.print(result[i]+" ");
		}
	}

}
