package com.qjg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1409_2 {

	public static class Rect{
		int x1,x2,y1,y2;
		public Rect(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Rect> list = new ArrayList<Rect>();
		for(int i = 0;i<n;i++){
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			list.add(new Rect(x1,y1,x2,y2));
		}
		
		int[][] array = new int[101][101];
		for(Rect r:list){
			for(int i = r.x1;i<r.x2;i++){
				for(int j = r.y1;j<r.y2;j++){
					array[i][j] = 1;
				}
			}
		}
		
		int count = 0;
		for(int i = 0;i<array.length;i++){
			for(int j = 0;j<array[0].length;j++){
				if(array[i][j]==1){
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
