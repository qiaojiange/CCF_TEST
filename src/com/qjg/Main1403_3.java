package com.qjg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main1403_3 {

//	选项有两类:带参数的选项和不带参数的选项。
//	一个合法的无参数选项的形式是一个减号后面跟单个小写字母,如"-a" 或"-b"。
//	而带参数选项则由两个由空格分隔的字符串构成,前者的格式要求与无参数选项相同,
//	后者则是该选项的参数,是由小写字母,数字和减号组成的非空字符串。
//	该命令行工具的作者提供给你一个格式字符串以指定他的命令行工具需要接受哪些选项。
//	这个字符串由若干小写字母和冒号组成,其中的每个小写字母表示一个该程序接受的选项。
//	如果该小写字母后面紧跟了一个冒号,它就表示一个带参数的选项,否则则为不带参数的选项。
//	例如, "ab:m:" 表示该程序接受三种选项,即"-a"(不带参数),"-b"(带参数), 以及"-m"(带参数)。
	private static Set<Character> isNSet = new HashSet<>();
	private static Set<Character> isYSet = new HashSet<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		analyParameter(str);
		int N = sc.nextInt();
		sc.nextLine();
		for(int i = 0;i<N;i++){
			String command = sc.nextLine();
			analysCommand(command,i);
		}
	}

	public static void analysCommand(String command,int index) {
		Set<String> chooseSet = new TreeSet<>();
		Map<String,String> chooseParameterMap = new HashMap<>();  
		String[] strs = command.split(" ");
		for(int i = 1;i < strs.length;){
			if(isN(strs[i])){
				chooseSet.add(strs[i]);
				i++;
				continue;
			}else if(isY(strs[i])){
				if( chooseParameterMap.containsKey(strs[i]) ){
					if((i+1)<strs.length && strs[i+1]!=null){
						if( judgeParameter(strs[i+1])){
							chooseParameterMap.put(strs[i], strs[i+1]);
							i+=2;
						}else{
							break;
						}
					}else{
						break;
					}
				}else{
					if( (i+1)<strs.length && strs[i+1]!=null){
						if(judgeParameter(strs[i+1])){
							chooseSet.add(strs[i]);
							chooseParameterMap.put(strs[i],strs[i+1]);
							i+=2;
						}
					}else{
						break;
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

	private static boolean judgeParameter(String string) {
		// TODO Auto-generated method stub
		if(string!=null && string.length()>0){
			for(int i = 0;i<string.length();i++){
				char ch = string.charAt(i);
				if(('a'<=ch && ch<='z') || (ch=='-') || ('0'<=ch && ch<='9')){
					
				}else{
					return false;
				}
			}
			
		}
		return true;
	}

	private static boolean isN(String string) {
		if(string.length()==2 && string.charAt(0)=='-' && isNSet.contains(string.charAt(1))){
			return true;
		}
		return false;
	}
	private static boolean isY(String string){
		if(string.length()==2 && string.charAt(0)=='-' && isYSet.contains(string.charAt(1))){
			return true;
		}
		return false;
	}
	private static void analyParameter(String str) {
		// TODO Auto-generated method stub
		for(int i =0;i<str.length();i++){
			if(str.charAt(i)!=':'){
				if((i+1)<str.length() && str.charAt(i+1)==':' ){
					isYSet.add(str.charAt(i));
				}else{
					isNSet.add(str.charAt(i));
				}
			}
			
		}
	}

}
