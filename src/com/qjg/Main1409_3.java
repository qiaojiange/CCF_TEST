package com.qjg;

import java.util.Scanner;

public class Main1409_3 {
	private static int sense = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sense = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		String[] strs = new String[n];
		for(int i = 0;i<n;i++){
			strs[i] = sc.nextLine();
//			process(s,str);
		}

		for(int i = 0;i<n;i++){
			process(s,strs[i]);
		}

	}
	private static void process(String s, String str) {
		// TODO Auto-generated method stub
		if(sense == 0){
			StringBuilder sb1 = new StringBuilder(s.trim().toLowerCase());
			StringBuilder sb2 = new StringBuilder(str.trim().toLowerCase());
			if(-1 !=sb2.indexOf(sb1.toString()) ){
				System.out.println(str.trim());
			}
		}else{
			StringBuilder sb1 = new StringBuilder(s.trim());
			StringBuilder sb2 = new StringBuilder(str.trim());
			if(-1 !=sb2.indexOf(sb1.toString()) ){
				System.out.println(str.trim());
			}
		}
	}

}
