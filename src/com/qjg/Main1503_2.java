package com.qjg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main1503_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<Integer,Integer> map = new HashMap<>();
		for(int i =0;i<n;i++){
			int temp = sc.nextInt();
			if(!map.containsKey(temp)){
				map.put(temp,1);
			}else{
				map.put(temp,map.get(temp)+1);
			}
		}
		
		List<Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list,new Comparator< Entry<Integer,Integer> >(){
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				if(o1.getValue()<o2.getValue()){
					return 1;
				}else if(o1.getValue() == o2.getValue()){
					if(o1.getKey()>o2.getKey()){
						return 1;
					}else{
						return -1;
					}
				}
				return -1;
			}
		});
		
		for(Entry<Integer,Integer> en:list){
			System.out.println(en.getKey()+" "+en.getValue());
		}
	}

}
