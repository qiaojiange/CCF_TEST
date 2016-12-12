package com.qjg;

import java.util.Scanner;

public class Main1509_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N];
		for(int i = 0;i<N;i++){
			nums[i] = sc.nextInt();
		}
		
		int count = 0;
		for(int i =0;i<N-1;i++){
			if(nums[i]!=nums[i+1]){
				count++;
			}
		}
		count++;
		System.out.println(count);
	}

}
