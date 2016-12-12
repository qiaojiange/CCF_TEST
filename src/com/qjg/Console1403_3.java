package com.qjg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class Console1403_3 {
	
	static Set<Character > setN= new TreeSet<>();
	static Set<Character > setY = new TreeSet<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext() ){
			String formatStr = scan.nextLine();
			if(!checkFormatStr(formatStr)){
				return ;
			}
			setN.clear();
			setY.clear();
			analys(formatStr);
			int N = scan.nextInt();
			if(N<1 || N>20) return;
			scan.nextLine();
			for(int i = 0;i<N;i++){
				String command = scan.nextLine();
				if(!checkCommand(command)){
					return ;
				}
				analysCommand(command,i);
			}
		}
	}
	
	//@Test
	public static boolean checkFormatStr(String formatStr) {
		// TODO Auto-generated method stub
		if(formatStr.length()>52){
			return false;
		}
		Set<Character> set =new HashSet<>();
		for(int i = 0;i<formatStr.length();i++){
			if( ('a'<= formatStr.charAt(i) && formatStr.charAt(i)<='z') ||(formatStr.charAt(i)==':') ){
				if(i == 0 && (formatStr.charAt(0) ==':')){
					return false;
				}
				if(set.contains(formatStr.charAt(i))){
					return false;
				}
				if((i+1)<formatStr.length() && formatStr.charAt(i)== ':' && formatStr.charAt(i+1)==':'){
					return false;
				}
				set.add(formatStr.charAt(i));
			}else{
				return false;
			}
		
		}
		return true;
	}

	public  static boolean checkCommand(String command) {
		if(command.length() > 256){
			return false;
		}
		
		for(int i = 0;i<command.length();i++){
			char ch = command.charAt(i);
			if(ch ==' '|| ch =='-' || ('0'<=ch && ch<='9')|| ('a'<=ch && ch<='z')){
				continue;
			}else{
				return false;
			}
		}
		return true;
	}

	public static void analysCommand(String command,int index) {
		Set<String> chooseSet = new TreeSet<>();
		Map<String,String> chooseParameterMap = new HashMap<>();  
		String[] strs = command.split(" ");
		for(int i = 1;i < strs.length;i++){
			if(isN(strs[i])){
				chooseSet.add(strs[i]);
			}else if(isY(strs[i])){
				
				if(chooseParameterMap.containsKey(strs[i]) ){
					if((i+1)< strs.length && strs[i]!=null){
						if(judgeParameter(strs[i+1])){
							chooseParameterMap.put(strs[i],strs[i+1]);
							i+=1;
						}else{
							break;
						}
					}
				}else{
					if((i+1)< strs.length && strs[i]!=null){
						if(judgeParameter(strs[i+1])){
							chooseSet.add(strs[i]);
							chooseParameterMap.put(strs[i],strs[i+1]);
							i+=1;
						}else{
							break;
						}
					}
				}
			}else{
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("Case "+(index+1)+":");
		for(String str:chooseSet){
			if(chooseParameterMap.containsKey(str)){
				sb.append(" ");
				sb.append(str);
				sb.append(" ");
				sb.append(chooseParameterMap.get(str));
			}else{
				sb.append(" ");
				sb.append(str);
			}
		}
		
		System.out.println(sb.toString());
	}

	public static boolean judgeParameter(String string) {
		for (int i = 0; i < string.length(); i++) {
			if ((string.charAt(i) <= '9' && string.charAt(i) >= '0')
					|| (string.charAt(i) <= 'z' && string.charAt(i) >= 'a') || (string.charAt(i) == '-')) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}


	public static boolean isY(String string) {
		if(setY.contains(string.charAt(1))&& (string.length() == 2)){
			return true;
		}
		return false;
	}

	public static boolean isN(String string) {
		if(setN.contains(string.charAt(1))  &&(string.length() == 2)){
			return true;
		}
		return false;
	}
	
	public static void analys(String formatStr) {
		// TODO Auto-generated method stub
		for(int i = 0;i < formatStr.length();i++){
			if(formatStr.charAt(i) != ':'){
				if((i+1)<formatStr.length() && formatStr.charAt(i+1) == ':'){
					setY.add(formatStr.charAt(i));
				}else{
					setN.add(formatStr.charAt(i));
				}
			}
		}
	}
	

}
