package com.qjg;

import java.util.Scanner;

public class Main1512_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum =0;
		while(N!=0){
			sum += N%10;
			N /=10;
		}
		System.out.println(sum);
	}

}
