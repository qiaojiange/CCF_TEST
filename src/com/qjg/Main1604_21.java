package com.qjg;

import java.util.Scanner;

public class Main1604_21 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] graph = new int[15][10];
		for(int i = 0;i<15;i++){
			for(int j =0;j<10;j++){
				graph[i][j]=sc.nextInt();
			}
		}
		int[][] block = new int[4][4];
		for(int i = 0;i<4;i++){
			for(int j = 0;j<4;j++){
				block[i][j]= sc.nextInt();
			}
		}
		
		int startIndex = sc.nextInt();
		int[] blockMaxRow = new int[4];
		int[] graphMaxRow = new int[4];
		int minRowBlock = -1;
		int maxRowBlock = 0;
		for(int i=0;i<4;i++){
			for(int j = 0;j<4;j++){
				if(block[i][j]==1 && minRowBlock==-1){
					minRowBlock = i;
				}
				if(block[i][j] == 1){
					maxRowBlock = i; 
				}
			}
		}
		
		//计算每列行高
		calcBlockColHigh(block,blockMaxRow,minRowBlock,maxRowBlock);
		calcGraphColHigh(graph,graphMaxRow,startIndex);
		
//		在图中找到最小的行高
		int minRowGraph = 15;
		for(int i = 0;i<blockMaxRow.length;i++){
			if(blockMaxRow[i] != 0){
				int diff = graphMaxRow[i]-blockMaxRow[i];
				if(diff<minRowGraph){
					minRowGraph = diff; 
				}
			}
		}
		
		
		
		int k = minRowGraph;
		for(int i = minRowBlock;i<=maxRowBlock;i++,k++){
			for(int j = 0;j<4;j++){
				graph[k][startIndex-1+j] += block[i][j];
			}
		}
		
		for(int i = 0;i<graph.length;i++){
			for(int j = 0;j<graph[0].length;j++){
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}

	private static void calcBlockColHigh(int[][] block, int[] blockMaxRow, int minRowBlock, int maxRowBlock) {
		// TODO Auto-generated method stub
		for(int i = 0;i<blockMaxRow.length;i++){
			for(int j = maxRowBlock;j>=minRowBlock;j--){
//				if(block[j][i]==1){//统计小木块的个数，这种方法对于翻转的L并不适用
//					blockMaxRow[i] += 1;
//				}
				if(block[j][i]==1){
					if(j == maxRowBlock){
//						0 0 1 0//这种是比较坑的
//						1 1 1 0
//						0 0 0 0
//						0 0 0 0						
						blockMaxRow[i] = maxRowBlock-minRowBlock+1;
						break;
					}else{
//					   	 0 0 0 0
//						 0 1 1 1
//						 0 0 0 1
//						 0 0 0 0					
						blockMaxRow[i] += 1;
					}
				}
				
			}
		}
	}

	private static void calcGraphColHigh(int[][] graph, int[] graphMaxRow,int startIndex) {
		for(int i = startIndex-1;i<startIndex-1+4;i++){
			for(int j = 0;j<graph.length;j++){
				if(graph[j][i]==1){
					graphMaxRow[i-startIndex+1] = j;
					break;
				}else{
					graphMaxRow[i-startIndex+1] = graph.length;
				}
			}
		}
	}

//	private static void calcBlockColHigh(int[][] block, int[] blockMaxRow) {
//		for(int i = 0;i<blockMaxRow.length;i++){
//			for(int j = 3;j>=0;j--){
////				if(block[j][i]==1){//统计小木块的个数，这种方法对于翻转的L并不适用
////					blockMaxRow[i] += 1;
////				}
//				if(block[j][i]==1){
//					blockMaxRow[i] = j+1;
//					break;
//				}
//				
//			}
//		}
//	}

}
