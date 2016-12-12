package com.qjg;

import java.util.Scanner;

public class SetAllocal1612_22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int count[] = new int[100];
		for(int i=0;i<N;i++){
			count[i] = scan.nextInt();
		}
		
		int zw[][] = new int[20][6];
		for(int i = 0;i<zw.length;i++){
			zw[i][5] = 5;
		}
		for(int i=0;i<N;i++){
			int temp = count[i];
			boolean flag = false;
			for(int j = 0;j<zw.length;j++){
				int res = zw[j][5];
				if(res >= temp){
					int start = 5-res;
					zw[j][5] -= count[i];
					flag = true;
					for(int k = start ;k<start+count[i];k++){
						System.out.print(j*5+k+1+" ");
					}
					System.out.println();
					break;
				}
			}

			if(!flag){
				for( int j = 0;j<zw.length;j++){
					int res = zw[j][5];
					while(temp> res && res>0){
						int k = 5 - zw[j][5];
						zw[j][5] = zw[j][5]-1;
						System.out.print(j*5+k+1+" ");
						temp--;
					}
					if(0 == temp){
						break;
					}
				}
				System.out.println();
			}
		}
		
//		while(scan.hasNext()){
////			setArray[i][0]
//			int[][] setArray = new int[20][6];
//			int N = scan.nextInt();
//			int[] nums = new int[N];
//			for(int i = 0;i< N;i++){
//				int count = scan.nextInt();
//				nums[i] = count;
//			}
//			for(int num:nums){
////				if(num>5){
////					return ;
////				}
//				process(num,setArray);
//			}
//			
//		}
		
		scan.close();
	}

	private static void process(int count, int[][] setArray) {
		for(int i = 0;i<20;i++){
//价格注释试试看
			if(setArray[i][0]<5 && (5-setArray[i][0])>= count){
				int temp = 0;
				for(int j=setArray[i][0]+1;j<=5 && temp<count;j++){
					System.out.print(""+(i*5+j)+" ");
					temp++;
				}
				System.out.println();
				setArray[i][0] += count;
				return ;
			}
		}
	}

}
