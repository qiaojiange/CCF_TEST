package com.qjg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1604_3 {
	public static class Dir{
		Dir parent = null;
		public List<Dir> childs = new ArrayList<>();
		Dir(String str){
			this.dirName = str;
			this.parent = null;
		}
		Dir(String str,Dir parent){
			this.dirName = str;
			this.parent = parent;
		}
		String dirName;
		public String toString() {
			return dirName;
		}
		public Dir addDir(Dir dir){
			this.childs.add(dir);
			curr = dir;
			return dir;
		}
		public boolean haveDir(String dirName){
			if(this.dirName.equals(dirName)) return true;
			for(Dir d:childs){
				if(d.dirName.equals(dirName)){
					return true;
				}
			}
			return false;
		}
		
		public void moveTo(String dirName){
			if(this.dirName.equals(dirName)) return ;
			for(Dir d:childs){
				if(d.dirName.equals(dirName)){
					curr = d;
					return;
				}
			}
		}
	}
	private static Dir root  = new Dir("/");
	private static Dir curr = root;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		sc.nextLine();
		String currPath = sc.nextLine();
		formatStr(currPath.trim());
		List<String> list = new ArrayList<>();
		Dir temp = curr;
		for(int i = 0;i<p;i++){
			curr = temp;
			String formatPath = sc.nextLine();
			process(list, formatPath);
		}
		for(String str:list){
			System.out.println(str);
		}
	}


	public static void process(List<String> list, String formatPath) {
		if(formatPath.equals("")|| formatPath.length()==0){
			list.add("/");
		}else{
			formatStr(formatPath.trim());
			list.add(printPath());
		}
	}
	
	
	private static String printPath() {
		Dir temp = curr;
		if(temp == root) {
			return "/";
//			System.out.println("/");
		}
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<>();
		while(temp!=null){
			list.add(temp.dirName);
			temp = temp.parent;
		}
		
		for(int i = list.size()-1;i>=0;i--){
			sb.append(list.get(i)+"/");
		}
		
		//sb.append("/");
		//System.out.println(sb.substring(1,sb.length()-1).toString());
		return sb.substring(1,sb.length()-1).toString();
	}


	private static void formatStr(String formatPath) {
		// TODO Auto-generated method stub
		if(formatPath.charAt(0)=='/'){
			String[] strs = formatPath.split("/");
			curr = root;
			recursion(strs,1);
		}else{
			//以..开头
			String[] strs = formatPath.split("/");
			recursion(strs,0);
		}
	}


	private static void recursion(String[] strs, int i) {
		// TODO Auto-generated method stub
		if(i>= strs.length) return;
		if(strs[i].equals("") || strs[1].length()==0){// for /////
			recursion(strs,i+1);
		}else if(strs[i].equals(".")){
			recursion(strs,i+1);
		}else if(strs[i].equals("..")){
			if(curr != root){
				curr = curr.parent;
			}			
			recursion(strs,i+1);
		}else{//
			if(curr.haveDir(strs[i])){
				curr.moveTo(strs[i]);
			}else{
				curr.addDir(new Dir(strs[i],curr));
			}
			recursion(strs,i+1);
		}
	}


	private static void format(String currPath) {
		// TODO Auto-generated method stub
		String[] strs = currPath.split("/");
		curr.addDir(new Dir(strs[1],curr));
		curr.addDir(new Dir(strs[2],curr));
	}

}
