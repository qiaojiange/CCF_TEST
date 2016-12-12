package com.qjg;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1512_2 {

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
		// for(int i = 0;i<n;i++){
		// for(int j = 0;j<m;j++){
		// System.out.print(array1[i][j]+" ");
		//// array[i][j] = sc.nextInt();
		// }
		// System.out.println();
		// }
//		array2 = array.clone();
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
//				array3[i][j] = array1[i][j]&array2[i][j];
			}
			System.out.println();
		}
	}

	private static void colProcess(int[][] array2) {
		// TODO Auto-generated method stub
		Queue<Position> queue = new LinkedList<>();
		for (int i = 0; i < array2.length; i++) {//表示列,
			queue.add(new Position(0, i));
			for (int j = 1; j < array2.length; j++) {//行动，列不动
				if (array2[j][i] == array2[queue.peek().x][queue.peek().y]) {
					queue.add(new Position(j, i));
				} else {
					if (queue.size() > 2) {
						while (!queue.isEmpty()) {
							array2[queue.peek().x][queue.peek().y] = 0;
							queue.poll();
						}
					}
					queue.clear();
					queue.add(new Position(j, i));
				}
			}
			if (queue.size() > 2) {
				while (!queue.isEmpty()) {
					array2[queue.peek().x][queue.peek().y] = 0;
					queue.poll();
				}
			}
			queue.clear();
		}
	}

	public static class Position {
		int x, y;
		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static void rowProcess(int[][] array1) {
		// TODO Auto-generated method stub
		Queue<Position> queue = new LinkedList<>();
		for (int i = 0; i < array1.length; i++) {
			queue.add(new Position(i, 0));
			for (int j = 1; j < array1[0].length ; j++) {
				if (array1[i][j] == array1[queue.peek().x][queue.peek().y]) {
					queue.add(new Position(i, j));
				} else {
					if (queue.size() > 2) {
						while (!queue.isEmpty()) {
							array1[queue.peek().x][queue.peek().y] = 0;
							queue.poll();
						}
					}
					queue.clear();
					queue.add(new Position(i, j));
				}
			}
			if (queue.size() > 2) {
				while (!queue.isEmpty()) {
					array1[queue.peek().x][queue.peek().y] = 0;
					queue.poll();
				}
			}
			queue.clear();
		}
	}

}
