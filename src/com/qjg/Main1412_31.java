package com.qjg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;



public class Main1412_31 {
	public static class Stock{
		float price;
		int num;
		Stock(float price,int num){
			this.price = price;
			this.num = num;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		List<String> list = new ArrayList<>();
		Map<Integer,String> map = new HashMap<>();
		String str ;
		int index = 1;
		
		while((str=sc.nextLine())!=null && ( str.trim().length()!=0) ){
			map.put(index, str.trim());
			index++;
		} 
		
//		while(sc.hasNextLine()){
//			str = sc.nextLine();
//			if(str.trim().length() == 0){
//				break;
//			}
//			map.put(index, str.trim());
//			index++;
//		}
		
		
		sc.close();
		processCancel(map);
		calculatePrice(map);
	}
	
	private static void calculatePrice(Map<Integer, String> map) {
		List<Stock> buyList = new ArrayList<>();
		List<Stock> sellList = new ArrayList<>();
		for(Entry<Integer,String> en :map.entrySet()){
			String str = en.getValue();
			String[] strs = str.split(" ");
			if(strs[0].equals("buy")){
				float price = Float.parseFloat(strs[1]);
				int num = Integer.parseInt(strs[2]);
				buyList.add(new Stock(price,num));
			}else if(strs[0].equals("sell")){
				float price = Float.parseFloat(strs[1]);
				int num = Integer.parseInt(strs[2]);
				sellList.add(new Stock(price,num));
			}
		}
		Collections.sort(buyList, new Comparator<Stock>(){//decent
			public int compare(Stock o1, Stock o2) {
				if(o1.price>o2.price){
					return -1;
				}
				return 1;
			}
		});
		
		Collections.sort(sellList,new Comparator<Stock>(){//ascent
			@Override
			public int compare(Stock o1, Stock o2) {
				if(o1.price>o2.price){
					return 1;
				}
				return -1;
			}
		});
		
		float ansPrice = 0;
		int ansSum = 0;
		int sum1 = 0;
		int sum2 = 0;
		for(int i = 0;i<buyList.size();i++){
			Stock s = buyList.get(i);
			float p = s.price;
			sum1 += s.num;
			sum2 = 0;
			for(int j = 0;j<sellList.size();j++){
				if(sellList.get(j).price > p){
					break;
				}
				sum2 += sellList.get(j).num;
			}
			
			int minSum = Math.min(sum2, sum1);
			if(ansSum < minSum){
				ansSum = minSum;
				ansPrice = p;
			}
		}
		System.out.printf("%.2f",ansPrice);
	    System.out.printf(" "+ansSum);
		
//		List<Entry<Double,Integer>> list = new ArrayList<>(resultMap.entrySet());
//		Collections.sort(list,new Comparator<Entry<Double,Integer>>(){
//			@Override
//			public int compare(Entry<Double, Integer> o1, Entry<Double, Integer> o2) {
//				if( o1.getValue()>o2.getValue() ){
//					return -1;
//				}else if(o1.getValue()==o2.getValue()){
//					if(o1.getKey()>o2.getKey()){
//						return -1;
//					}else{
//						return 1;
//					}
//				}else{
//					return 1;
//				}
//			}
//		});
//		System.out.println(list.get(0).getKey().+" "+list.get(0).getValue());
//		System.out.printf("%.2f",list.get(0).getKey());
//		System.out.printf(" "+list.get(0).getValue());
	    
	    
	}

	private static void processCancel(Map<Integer, String> map) {
		// TODO Auto-generated method stub
//		remove want to cancel
		List<Integer> removeList = new ArrayList<>();
		for(Entry<Integer,String> en :map.entrySet()){
			String str = en.getValue();
			String[] strs = str.split(" ");
			if(strs[0].equals("cancel")){
				//map.remove(Integer.parseInt(strs[1]));
				removeList.add(Integer.parseInt(strs[1]));
			}
		}
		for(int i =0;i<removeList.size();i++){
			map.remove(removeList.get(i));
		}
	}

}
