package com.qjg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main1612_3 {
	public static class Hero{
		int id ;
		int health;
		int attack;
		public Hero(int id) {
			super();
			this.id = id;
			this.health = 30;
			this.attack = 0;		
		}
		List<Follower> followers = new ArrayList<>();
		public boolean putFollower(Follower follower){
			if(followers.size()<7){
				followers.add(follower);
				return true;
			}
			return false;
		}
		
		public void flushFollowers(){
			for(int i = 0;i<followers.size();i++){
				Follower temp = followers.get(i);
				if(temp.isDeath()){
					//followers.remove(followers.get(i+1));
					followers.remove(i);
					i--;
				}
			}
			
			for(int i =0;i<followers.size();i++){
				Follower temp = followers.get(i);
				temp.position = i+1;
			}
		}
		//从80分到100分之间，不曾觉得自己理解的召唤随从有问题
		public Follower summon(int position,int health,int attack) {
			followers.add(position-1, new Follower(health,attack));
			return followers.get(position-1);
//			int positionWantMove = position-1;//原来的英雄位置
//			int positionNew = FindFollowerPosition(health,attack);
//			if(positionNew == -1) {
//				if(followers.size()<7){// 当本方战场有 7 个随从时，不会再召唤新的随从。
//					followers.add(new Follower(followers.size()-1,health,attack));
//				}else{
//					return null;
//				}
//			}
//			
//			//即如果当前本方战场上有 m 个随从，则召唤随从的位置一定在 1 到 m + 1 之间，其中 1 表示战场最左边的位置，m + 1 表示战场最右边的位置。
//			if(positionWantMove<0 || positionWantMove>=followers.size()){
//				return null;
//			}
//			
//			positionNew = FindFollowerPosition(health,attack);
//			//开始召唤英雄
//			Follower beSummonFollow = followers.get(positionNew);
//			for(int i = positionNew-1;i>=positionWantMove;i--){
//				followers.get(i).position = i+1;
//			}
//			
//			beSummonFollow.position = positionWantMove;
//			Collections.sort(followers, new Comparator<Follower>(){
//				@Override
//				public int compare(Follower o1, Follower o2) {
//					if(o1.position>o2.position){
//						return 1;
//					}else{
//						return -1;
//					}
//				}
//			});
//			return beSummonFollow;
		}
		
		private int FindFollowerPosition(int health2, int attack2) {
			// TODO Auto-generated method stub
			Follower tempFollower = null;
			for(int i = 0;i<followers.size();i++){
				tempFollower = followers.get(i); 
				if(tempFollower.health== health2 && tempFollower.attack == attack2){
					return i;
				}
			}
			return -1;
		}

		public Follower getFollower(int position){
			if(1<=position && position<=followers.size()){
				return followers.get(position-1);
			}else{
				return null;
			}
		}
		
	}
	
	public static class Follower {
		int id;//和英雄的id一样
		int position;
		int health;
		int attack;
		public Follower(int position,int health, int attack) {
			this.position = position;
			this.health = health;
			this.attack = attack;
		}
		public Follower(int health, int attack) {
			this.health = health;
			this.attack = attack;
		}
		public void attack(Follower other){
			other.health -= this.attack;
			this.health -= other.attack;
		}
		
		public void attack(Hero hero){
			hero.health -= this.attack;
		}
		
//		public void attack(List<Follower> list,int position){
//			Follower other = list.get(position-1);
//			other.health -= this.attack;
//			this.health -= other.attack;
//		}
		public boolean isDeath(){
			if(health<=0){
				return true;
			}
			return false;
		}
	}
	
	public static enum GameState{
		Win,Lose,GoOn;//表示的是先手玩家赢，先手玩家输，游戏继续
	}
	
	public static enum Token{
		First,Last;
	}
	
	private static GameState gameState = GameState.GoOn;
	private static Token token = Token.First;//表示先手玩家
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Hero hero1 = new Hero(1);
		Hero hero2 = new Hero(1);
		sc.nextLine();
		for(int i =0;i<n;i++){
			String str = sc.nextLine();
			process(str,hero1,hero2);
		}
		
		if(gameState == GameState.GoOn){
			System.out.println(0);
		}else if(gameState == GameState.Win){
			System.out.println(1);
		}else{
			System.out.println(-1);
		}
		
		System.out.println(hero1.health);
		int size = hero1.followers.size();
		System.out.print(size+" ");
		for(int i=0;i<size;i++){
			System.out.print(hero1.followers.get(i).health+" ");
		}
		System.out.println();
		System.out.println(hero2.health);
		size = hero2.followers.size();
		System.out.print(size+" ");
		for(int i=0;i<size;i++){
			System.out.print(hero2.followers.get(i).health+" ");
		}
	}

	private static void process(String str, Hero hero1, Hero hero2) {
		if(gameState != GameState.GoOn){
			return ;
		}
		String[] strs = str.trim().split(" ");
		if(strs[0].equals("summon")){
			int position = Integer.parseInt(strs[1]);
			int attack = Integer.parseInt(strs[2]);
			int health = Integer.parseInt(strs[3]);
			if(token == Token.First){
				if(hero1.followers.size()<8){//当本方战场有 7 个随从时，不会再召唤新的随从。
					hero1.summon(position, health, attack);
				}else{
					return ;
				}
			}else{
				if(hero2.followers.size()<8){//当本方战场有 7 个随从时，不会再召唤新的随从。
					hero2.summon(position, health, attack);
				}else{
					return ;
				}
			}
		}else if(strs[0].equals("attack")){
			int id1 = Integer.parseInt(strs[1]);
			int id2 = Integer.parseInt(strs[2]);
			if(token == Token.First){
				Follower  myFollower = hero1.getFollower(id1);
				if(myFollower==null || (myFollower!=null && myFollower.attack<=0)) return ;
				if(id2 == 0){
					myFollower.attack(hero2);
					if(hero2.health <= 0){
						gameState = GameState.Win;
					}
				}else{
					Follower other = hero2.getFollower(id2);
					if(other!=null){
						myFollower.attack(other);
					}else{
						return;
					}
				}
			}else{
				Follower  myFollower = hero2.getFollower(id1);
				if(myFollower==null || myFollower.attack<=0) return ;//发起攻击的角色攻击力大于 0
				if(id2 == 0){
					myFollower.attack(hero1);
					if(hero1.health <=0){
						gameState = GameState.Lose;
					}
				}else{
					Follower other = hero1.getFollower(id2);
					if(other!=null){// 发起攻击和被攻击的角色一定存在
						myFollower.attack(other);
					}else{
						return;
					}
				}
			}
			hero1.flushFollowers();
			hero2.flushFollowers();
		}else{//equal end
			if(token == Token.First){
				token = Token.Last;
			}else{
				token = Token.First;
			}
		}
	}
}
