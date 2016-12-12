package com.qjg;

import java.util.Scanner;
//折点，就是找到两边比自己都大，或都小的数
public class Main1604_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int N = sc.nextInt();
			int[] sell = new int[N];
			for(int i = 0;i<N;i++){
				sell[i] = sc.nextInt();
			}
			process(sell);
		}
	}

	private static void process(int[] sell) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i = 1;i<sell.length-1;i++){
			if(sell[i]>sell[i+1] && sell[i]>sell[i-1]){
				count++;
			}
			if(sell[i]<sell[i+1] && sell[i]<sell[i-1]){
				count++;
			}
		}
		System.out.println(count);
	}

}
