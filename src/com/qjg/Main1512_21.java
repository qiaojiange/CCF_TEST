package com.qjg;
import java.util.Scanner;

public class Main1512_21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] array = new int[n][m];
		int[][] array1 = new int[n][m];
		int[][] array2 = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				array[i][j] = sc.nextInt();
				array1[i][j] = array[i][j];
				array2[i][j] = array[i][j];
			}
		}

		
		array1 = array.clone();
		rowProcess(array1);
		colProcess(array2);

		int[][] array3 = new int[n][m];
		for(int i = 0;i<n;i++){
			for(int j =0;j<m;j++){
				array3[i][j] = array1[i][j]&array2[i][j];
			}
		}
		for(int i = 0;i<n;i++){
			for(int j =0;j<m;j++){
				System.out.print(array3[i][j]+" ");
				array3[i][j] = array1[i][j]&array2[i][j];
			}
			System.out.println();
		}
	}

	private static void colProcess(int[][] array2) {
		boolean[][] flag = new boolean[array2.length][array2[0].length];
		for(int i = 0;i<array2[0].length;i++){
			int num = 0;
			for(int j = 0;j<array2.length;j++){
				if(j != array2.length-1 && array2[j][i] == array2[j+1][i] ){
					num++;
				}else{
					if(num>=2) {
						while(num>=0){
							flag[j-num][i] = true;
							num--;
						}
					}
					num = 0;
				}
			}
		}
		
		for(int i = 0;i<array2.length;i++){
			for(int j =0;j<array2[0].length;j++){
				if(flag[i][j]){
					array2[i][j] = 0;
				}
			}
		}
		
	}


	private static void rowProcess(int[][] array1) {
		boolean[][] flag = new boolean[array1.length][array1[0].length];
		for(int i = 0;i<array1.length;i++){
			int num = 0;
			for(int j = 0;j<array1[0].length;j++){
				if( j!= array1[0].length-1 && array1[i][j] == array1[i][j+1]){
					num++;
				}else{
					if(num >= 2){
						while(num >= 0){
							flag[i][j-num] = true;
							num--;
						} 
					}
					num = 0;
				}
			}
		}
		
		for(int i=0;i<array1.length;i++){
			for(int j=0;j<array1[0].length;j++){
				if(flag[i][j]){
					array1[i][j] = 0;
				}
			}
		}
		
	}

}
