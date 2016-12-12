package com.qjg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxMove1612_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int N = scan.nextInt();
			List<Integer> nums = new ArrayList<>();
			for(int i = 0;i<N;i++){
				nums.add(scan.nextInt());
			}
			process(nums);
		}
	}

	private static void process(List<Integer> nums) {
		// TODO Auto-generated method stub
		int max = 0;
		int temp = 0;
		for(int i = 0;i<nums.size()-1;++i){
			temp = Math.abs(nums.get(i+1)-nums.get(i));
			if(temp> max){
				max = temp;
			}
		}
		System.out.println(max);
		
	}

}
