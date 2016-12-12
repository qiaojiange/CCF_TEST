package com.qjg;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1509_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		sc.nextLine();
		String[] templete = new String[m];
		String[] var = new String[n];
		
		for(int i = 0;i<m;i++){
			templete[i] = sc.nextLine();
		}
		
		Map<String ,String> map = new HashMap<>();
		for(int i= 0;i<n;i++){
			var[i] = sc.nextLine();
			var[i] = var[i].trim();
			processVar(var[i],map);
		}
		
		for( int i = 0;i<m;i++){
//			if(3 == i){
//				System.out.println("dafadsf");
//			}
			templete[i] = processTemplete(templete[i],map);
		}
		
		for(int i = 0;i<m;i++){
			System.out.println(templete[i]);
		}
		
	}

	private static String processTemplete(String string, Map<String, String> map) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(string.trim());
		StringBuilder sbResult = new StringBuilder();
		boolean isFind = false;
		
		String str = "{{ ";
		String str1 ="";
		int start = 0;
		boolean isHave = false;
		while((start=sb.indexOf(str,0))!=-1){//出现了多个可以替换的
			sbResult.append(sb.substring(0, start));
			sb.delete(0, start);
			String tempString = sb.substring(0, sb.indexOf("}}"));
			sb.delete(0, tempString.length()+2);
			String key = getKey(tempString);
			isFind = true;
			if(map.containsKey(key)){
				sbResult.append(map.get(key));
			}else{
				continue;
			}
		}
		sbResult.append(sb.toString());
		
		if(isFind){
			return sbResult.toString();
		}else{
			return sb.toString();
		}
	}

	private static String getKey(String str) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(str);
		int start = sb.indexOf(" ");
		sb.delete(0, start);
		return sb.toString().trim();
	}

	private static void processVar(String string, Map<String, String> map) {
		// TODO Auto-generated method stub
		String[] strs = new String[2];
		int start = string.indexOf('"');
		strs[0] = string.substring(0, start).trim();
		strs[1] = string.substring(start+1, string.length()-1).trim();
		map.put(strs[0], strs[1]);
	}

}
