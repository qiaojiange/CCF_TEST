package com.qjg;

import java.util.Scanner;

//俄罗斯方块
//检验两种情况:
//1.板块中某一个方块的下边缘与方格图上的方块上边缘重合
//2.达到下边界时，板块不再移动

public class Main1604_2{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	//	while(sc.hasNext()){
			int[][] graph = new int[15][10];
			for(int i = 0;i<15;i++){
				for(int j =0;j<10;j++){
					graph[i][j]=sc.nextInt();
				}
			}
			int[][] shape = new int[4][4];
			for(int i = 0;i<4;i++){
				for(int j = 0;j<4;j++){
					shape[i][j]= sc.nextInt();
				}
			}
			int startIndex = sc.nextInt();
			simulate(graph,shape,startIndex);
			
//		}
	}

	private static void simulate(int[][] graph, int[][] shape, int startIndex) {
		// TODO Auto-generated method stub
		boolean stop = false;
		int startShape = calculateStart(shape);
		// 行
		for (int i = 0; i < 15; ) {
			for (int k = startShape; k >= 0; k--) {
				for (int l = 0; l < 4; l++) {//按列扫描
					if ((graph[i][startIndex-1+l] & shape[k][l]) != 0) {
				//		i += 4-k;
						stop = true;
						break;
					}
				}
				if (stop) {
					break;
				}
				i++;
			}
			if (stop || i==14) {
				boolean startCopy =false;
				for(int k = startShape;k>=0;k--,i--){
						for(int l = 0;l<4;l++){
							graph[i][startIndex-1+l] += shape[k][l];
						}
				}
				break;
			}
		}
		
		for(int i = 0;i<15;i++){
			for(int j=0;j<10;j++){
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static int calculateStart(int[][] shape) {
		// TODO Auto-generated method stub
		for(int i = 3;i>=0;i--){
			int sum =0;
			for(int j = 0;j<4;j++){
				if(shape[i][j] == 1){
					return i;
				} 
			}
		}
		return 3;
	}

}
