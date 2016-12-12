package com.qjg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main1412_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] array = new int[n][n];
		for(int i =0;i<n;i++){
			for(int j = 0;j<n;j++){
				array[i][j] = sc.nextInt();
			}
		}
		
		List<Integer> list =new ArrayList<>();
		boolean flag = true;
		Stack<Integer> stack = new Stack<>();
		//上三角部分
		for(int i = 0;i<n;i++){
			int j = 0;
			int k = i;
			if(flag){
				while(k>=0 && j<n ){
					stack.push(array[j][k]);
					k--;
					j++;
				}
				flag = false;
				while(!stack.isEmpty()){
					list.add(stack.pop());
				}
			}else{
				while(k >= 0){
					list.add(array[j][k]);
					k--;
					j++;
				}
				flag = true;
			}
		}
		
//		下三角部分
		for(int i = 1;i<n;i++){
			int j = n-1;
			int k = i;
			if(flag){
				while(k<n){
					stack.push(array[k][j]);
					k++;
					j--;
				}
				flag = false;
				while(!stack.isEmpty()){
					list.add(stack.pop());
				}
			}else{
				while(k<n){
					list.add(array[k][j]);
					k++;
					j--;
				}
				flag = true;
			}
		}
		for(Integer in:list){
			System.out.print(in+" ");
		}
		
	}

}
