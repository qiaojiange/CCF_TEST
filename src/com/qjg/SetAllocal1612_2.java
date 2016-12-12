package com.qjg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SetAllocal1612_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			boolean[] setArray = new boolean[101];
			int N = scan.nextInt();
			int[] nums = new int[N];
			for(int i = 0;i< N;i++){
				int count = scan.nextInt();
				nums[i] = count;
			}
			for(int num:nums){
				if(num>5){
					return ;
				}
				process(num,setArray);
			}
			
		}
	}

	private static void process(int count, boolean[] setArray) {
		// TODO Auto-generated method stub
		for(int i = 0;i<20;i++){
			int countPer = 0;
			for(int j = 0;j<5;j++){
				if(!setArray[i*5+j]){
					countPer++;
					if(countPer >= count){
						break;
					}
				}
			}
			if(countPer >= count){
				int count1 = 0;
				for(int j = 0;j<5;j++){
					if(!setArray[i*5+j] && count1<countPer){
						setArray[i*5+j] = true;
						count1++;
						System.out.print(""+(i*5+j+1)+" ");	
					}
				}
				System.out.println();
				return;
			}
		}
	}

}
