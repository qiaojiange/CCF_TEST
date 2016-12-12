package com.qjg;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main1503_3 {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);            
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int y1 = sc.nextInt();
            int y2 = sc.nextInt();
            
            for(int i = y1 ;i<=y2;i++){
                  calc(a, b, c, i);
            }
      }
      public static void calc(int a, int b, int c, int y1) {
            //          先判断到y1年a月1日有多少天，并计算出是星期几。
                        //计算多少天
                        int days = 0;
                        for(int i = 1850;i<y1;i++){
                              if(isLeap(i)){
                                    days += 366;
                              }else{
                                    days += 365;
                              }
                        }
                        
                        int[] months = {0,31,28,31,30,31,30,31,31,30,31,30,31};
                        for(int i = 1;i<a;i++){
                              if( i==2 && isLeap(y1)){
                                    days += 29;
                              }else{
                                    days += months[i];
                              }
                        }
                        Map<Integer,Integer> map = new HashMap<>();
                        map.put(7, 6);
                        map.put(6, 5);
                        map.put(5, 4);
                        map.put(4, 3);
                        map.put(3, 2);
                        map.put(2, 1);
                        map.put(1, 0);
                        
                        
                        int weekCount = 0;
                        int i =0;
                        boolean flag  =false;
                        if(a == 2 && isLeap(y1)){
                        	months[a] = 29;
                        }
                        for(i = 1;i<=months[a];i++){
                              int temp = days + i;
                              if(temp%7 == map.get(c)){
                            	  weekCount++;
                            	  if(weekCount==b){
                            		  flag = true;
                            		  break;
                            	  }
                              }
                        }
                        if(flag){
                              int tempA ,tempDay ;
                              StringBuilder sb = new StringBuilder();
                              sb.append(y1+"/");
                              if(a<10){
                                    sb.append("0"+a+"/");
                              }else{
                                    sb.append(a+"/");
                              }
                              if(i<10){
                                    sb.append("0"+i);
                              }else{
                                    sb.append(i);
                              }
                              System.out.println(sb.toString());
                        }else{
                              System.out.println("none");               
                        }
      }
      private static boolean isLeap(int i) {
            if((i%4==0&& i%100!=0)||(i%400==0)){
                  return true;
            }
            return false;
      }
}
