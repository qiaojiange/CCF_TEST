package com.qjg;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1512_3 {
//-1：表'-'
//-2：表'|'
//-3: 表'+'
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int q = sc.nextInt();

		int[][] plant = new int[n][m];
		sc.nextLine();
		for (int i = 0; i < q; i++) {
			String str = sc.nextLine();
			paint(str.trim(), plant);
		}
		paint(plant, plant[0].length, plant.length);
	}

	public static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static void paint(String str, int[][] plant) {
		// TODO Auto-generated method stub
		int width = plant[0].length;
		int high = plant.length;
		String[] strs = str.split(" ");
		boolean[][] flag = new boolean[high][width];
		// 填充
		if (strs.length == 4) {
			int x1 = Integer.parseInt(strs[1]);
			int y1 = Integer.parseInt(strs[2]);
			char ch = strs[3].charAt(0);
			// 广度优先遍历
			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(y1, x1));
			flag[y1][x1] = true;
			while (!queue.isEmpty()) {
				Point p = queue.poll();
				plant[p.x][p.y] = ch;
				// 向上
				if ((p.x + 1 < high) && plant[p.x + 1][p.y] >= 0 && plant[p.x + 1][p.y] != ch && !flag[p.x + 1][p.y]) {
					queue.add(new Point(p.x + 1, p.y));
					flag[p.x + 1][p.y] = true;
				}
				// 向下
				if ((p.x - 1 > -1) && plant[p.x - 1][p.y] >= 0 && plant[p.x - 1][p.y] != ch && !flag[p.x - 1][p.y]) {
					queue.add(new Point(p.x - 1, p.y));
					flag[p.x - 1][p.y] = true;
				}
				// 向左
				if ((p.y + 1 < width) && plant[p.x][p.y + 1] >= 0 && plant[p.x][p.y + 1] != ch && !flag[p.x][p.y + 1]) {
					queue.add(new Point(p.x, p.y + 1));
					flag[p.x][p.y + 1] = true;
				}
				// 向右
				if ((p.y - 1 >= 0) && (p.y - 1 < width) && plant[p.x][p.y - 1] >= 0 && plant[p.x][p.y - 1] != ch && !flag[p.x][p.y - 1]) {
					queue.add(new Point(p.x, p.y - 1));
					flag[p.x][p.y - 1] = true;
				}
			}
		} else {//画线
			int x1 = Integer.parseInt(strs[1]);// 1
			int y1 = Integer.parseInt(strs[2]);// 0
			int x2 = Integer.parseInt(strs[3]);// 2
			int y2 = Integer.parseInt(strs[4]);// 0
			if (x1 == x2) {
				int min = Math.min(y1, y2);
				int max = Math.max(y1, y2);
				for (int i = min; i <= max; i++) {
					if (plant[i][x1] >= 0) {
						plant[i][x1] = -2;
					} else if (plant[i][x1] == -1) {
						plant[i][x1] += -2;
					}
				}
			}
			if (y1 == y2) {// 横线
				int min = Math.min(x1, x2);
				int max = Math.max(x1, x2);
				for (int i = min; i <= max; i++) {
					if (plant[y1][i] >= 0) {
						plant[y1][i] = -1;
					} else if (plant[y1][i] == -2) {
						plant[y1][i] += -1;
					}
				}
			}
		}
//		paint(plant, width, high);
	}

	public static void paint(int[][] plant, int width, int high) {
		for (int j = high - 1; j >= 0; j--) {
			for (int i = 0; i < width; i++) {
				if (plant[j][i] > 0) {
					char ch = (char) plant[j][i];
					System.out.print(ch);
				} else if (plant[j][i] == 0) {
					System.out.print(".");
				} else if (plant[j][i] == -1) {
					System.out.print("-");
				} else if (plant[j][i] == -2) {
					System.out.print("|");
				} else {
					System.out.print("+");
				}
			}
			System.out.println();
		}
	}

}
