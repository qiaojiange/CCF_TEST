package com.qjg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Main1412_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		List<String> list = new ArrayList<>();
		Map<Integer,String> map = new HashMap<>();
		String str ;
		int index = 1;
		
//		while((str=sc.nextLine())!=null && ( str.trim().length()!=0) ){
//			map.put(index, str.trim());
//			index++;
//		}
		
		while(sc.hasNextLine()){
			str =sc.nextLine();
			if(str.trim().length() == 0){
				break;
			}
			map.put(index, str.trim());
			index++;
		}
		sc.close();
		processCancel(map);
		calculatePrice(map);
	}

	private static void calculatePrice(Map<Integer, String> map) {
		TreeMap<Double,Integer> buyMap = new TreeMap<>();
		TreeMap<Double,Integer> sellMap = new TreeMap<>();
		int buySum = 0;
		int sellSum = 0;
		for(Entry<Integer,String> en :map.entrySet()){
			String str = en.getValue();
			String[] strs = str.split(" ");
			if(strs[0].equals("buy")){
				double key = Double.parseDouble(strs[1]);
				int temp = Integer.parseInt(strs[2]);
				if(buyMap.containsKey(key)){
					buyMap.put(key,temp+buyMap.get(key));
				}else{
					buyMap.put(key,temp);
				}
				buySum += temp;
			}else if(strs[0].equals("sell")){
				double key = Double.parseDouble(strs[1]);
				int temp = Integer.parseInt(strs[2]);
				if(sellMap.containsKey(key)){
					sellMap.put(key,temp+sellMap.get(key));
				}else{
					sellMap.put(key,temp);
				}
				sellSum += temp;
			}
		}
		
		TreeMap<Double,Integer> resultMap = new TreeMap<>();
		int tempBuySum = buySum;
		for(Entry<Double,Integer> enbuy : buyMap.entrySet()){
			double pricebuy = enbuy.getKey();
			int tempSellSum = sellSum;
			for(Entry<Double,Integer> enSell : sellMap.entrySet()){
				if(enSell.getKey() > pricebuy){
					tempSellSum -= enSell.getValue();
				}
			}
			resultMap.put(pricebuy, tempBuySum>tempSellSum?tempSellSum:tempBuySum);
			tempBuySum -= enbuy.getValue();
		}
		
		
//		for(Entry<Double,Integer> enbuy : buyMap.entrySet()){
//			double pricebuy = enbuy.getKey();
//			int tempSellSum = sellSum;
//			for(Entry<Double,Integer> enSell : sellMap.entrySet()){
//				if(enSell.getKey() > pricebuy){
//					tempSellSum -= enSell.getValue();
//				}
//			}
//			resultMap.put(pricebuy, tempBuySum>tempSellSum?tempSellSum:tempBuySum);
//			tempBuySum -= enbuy.getValue();
//		}
		
		
		
		
		
		
//		int ansSum = 0;
//		double ansPrice = 0.0;
//		List<Double> listBuyPrice = new ArrayList<>(buyMap.keySet());
//		listBuyPrice.addAll(sellMap.keySet());
//		Collections.sort(listBuyPrice);
//		for(int i = 0;i<listBuyPrice.size();i++){
//			double price = listBuyPrice.get(i);
//			int sum1 = 0;
//			for(Entry<Double,Integer> enbuy:buyMap.entrySet()){
//				if(enbuy.getKey()>=listBuyPrice.get(i) ){
//					sum1+=enbuy.getValue();
//				}
//			}
//			int sum2 = 0;
//			for(Entry<Double,Integer> enSell:sellMap.entrySet()){
//				if(enSell.getKey()<=listBuyPrice.get(i) ){
//					sum2 += enSell.getValue();
//				}
//			}
//			//resultMap.put(price, Math.min(sum1, sum2));
//			if(ansSum <= Math.min(sum1, sum2)){
//				ansSum = Math.min(sum1, sum2);
//				ansPrice = price;
//			}
//		}
//		System.out.printf("%.2f",ansPrice);
//	    System.out.printf(" "+ansSum);
		
		List<Entry<Double,Integer>> list = new ArrayList<>(resultMap.entrySet());
		Collections.sort(list,new Comparator<Entry<Double,Integer>>(){
			@Override
			public int compare(Entry<Double, Integer> o1, Entry<Double, Integer> o2) {
				if( o1.getValue()>o2.getValue() ){
					return -1;
				}else if(o1.getValue()==o2.getValue()){
					if(o1.getKey()>o2.getKey()){
						return -1;
					}else{
						return 1;
					}
				}else{
					return 1;
				}
			}
		});
//		System.out.println(list.get(0).getKey().+" "+list.get(0).getValue());
		System.out.printf("%.2f",list.get(0).getKey());
		System.out.printf(" "+list.get(0).getValue());
	    
	    
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
