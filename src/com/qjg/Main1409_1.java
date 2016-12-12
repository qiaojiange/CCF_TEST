package com.qjg;

import java.util.Scanner;

public class Main1409_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//谁是注释
		boolean[] hash = new boolean[10001];
		int[] record = new int[n];
//		int[] result = new int[n];
		int count=0;
		for(int i = 0;i<n;i++){
			record[i] = sc.nextInt();
			hash[record[i]] = true;
//			if(hash[record[i]-1] ){
//				count++;
//			}
//			if(hash[record[i]+1] ){
//				count++;
//			}
		}
		for(int i =0;i<10001;i++){
			if(hash[i] && hash[i+1]){
				count++;
			}
		}
		
		System.out.println(count);
	}

}
