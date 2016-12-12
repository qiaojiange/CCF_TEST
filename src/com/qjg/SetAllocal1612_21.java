package com.qjg;

import java.util.Scanner;

public class SetAllocal1612_21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
//			setArray[i][0],表示已分配的个数
			int[][] setArray = new int[20][6];
			int N = scan.nextInt();
			int[] nums = new int[N];
			for(int i = 0;i< N;i++){
				int count = scan.nextInt();
				nums[i] = count;
			}
			for(int num:nums){
//				if(num>5){
//					return ;
//				}
				process(num,setArray);
			}
			
		}
		scan.close();
	}

	private static void process(int count, int[][] setArray) {
		boolean flag = false;
		for(int i = 0;i<20;i++){
			//开始计算分配的位置
			if(setArray[i][0]<5 && (5-setArray[i][0])>= count){
				int temp = 0;
				for(int j=setArray[i][0]+1;j<=5 && temp<count;j++){
					System.out.print(""+(i*5+j)+" ");
					temp++;
				}
				System.out.println();
				flag = true;
				setArray[i][0] += count;
				return ;
			}
		}
		if(!flag){//没有分配成功
			int temp = 0;
			for(int i=0;i<20;i++){
				if(setArray[i][0]!=5){
					for(int j = setArray[i][0]+1;j<=5 && temp<count;j++){
						System.out.print((i*5+j)+" ");
						temp++;
						++setArray[i][0];
					}
				}
			}
			System.out.println();
		}
			
		
	}

}
