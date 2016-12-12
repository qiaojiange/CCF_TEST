package com.qjg;

import java.util.Scanner;

public class Main1509_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int d = sc.nextInt();
		
		int[] months={0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(ismoon(y)){
			months[2] = 29;
			for(int i = 1;i<months.length;i++){
				if(d>months[i]){
					d -= months[i];
				}else{
					System.out.println(i);
					System.out.println(d);
					break;
				}
			}
		}else{
			for(int i = 1;i<months.length;i++){
				if(d>months[i]){
					d -= months[i];
				}else{
					System.out.println(i);
					System.out.println(d);
					break;
				}
			}
		}
	}

	private static boolean ismoon(int y) {
		if( (y%4==0 && y%100!=0) || (y%400==0)){
			return true;
		}
		return false;
	}

}
