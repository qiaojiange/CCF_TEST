package com.qjg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class  Node{
	int v;//表示节点，Cost表示从出发点到v点的距离
	int cost;
	Node(int v,int cost){
		this.v = v;
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "v:"+v+" cost:"+cost;
	}
}
 class Edge{
	int v;//表示边的另一端节点，cost表示该边的权重
	int cost;
	Edge(int v,int c){
		this.v = v;
		this.cost = c;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "v:"+v+" cost:"+cost;
	}
}
class Graph{
	private ArrayList<Edge> list;
	Graph(){
		list= new ArrayList<Edge>();
	}
	public void add(Edge edge){
		list.add(edge);
	}
	public int size(){
		return list.size();
	}
	public Edge get(int i){
		if(i<list.size()){
			return list.get(i);
		}else{
			return null;
		}
	}
}

// 首先，对原图求出单源最短路，那么顶点之间就形成了一个拓扑图（也可以说是DAG）。
// 因为根据题目描述，高铁所构成的图要保证每个顶点到顶点1的最短距离相等这一条性质，
// 所以呢，遍历这个DAG，找出每个顶点u与其前驱顶点p1,p2,…,pk的最短距离，记作minx[u]， 
// 那么答案就是∑i=Ni=1minx[i]。
public class Main1612_4 {
	private static class G{
		Edge[] s = new Edge[MAX];
	}
	private final static int MAX= 10005;
	
	private static Graph[] G =new Graph[MAX];
	
	private static boolean[] marked= new boolean[MAX];
//	出发点到某点距离
	private static int[] disto=new int[MAX];
//	接通该点需要增加的边的权重
	private static int[] costo=new int[MAX];
	private static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int s,e,c;
		for(int i = 0;i< M;i++){
			s = sc.nextInt();
			e = sc.nextInt();
			c = sc.nextInt();
			Edge edge1 = new Edge(e,c);
			if(G[s]==null){
				G[s]= new Graph();
			}
			G[s].add(edge1);
			Edge edge2 = new Edge(s,c);
			if(G[e]==null){
				G[e] = new Graph();
			}
			G[e].add(edge2);
		}
		dijkstra(1);
		//统计边权重
		int res = 0;
		for(int i = 2;i<=N;i++){
			res += costo[i];
		}
		System.out.println(res);
	}

	private static void dijkstra(int s) {
		for(int i =0;i<=N;i++){
			costo[i] = disto[i] = Integer.MAX_VALUE;
			marked[i] = false;
		}
		
		disto[s] = 0;//从出发点到某点距离
		costo[s] = 0;//接通该点需要增加边的权重
//		保存<v,disto[v]>且按disto[v]升序排序
		PriorityQueue<Node> pq  = new PriorityQueue<Node>(100,new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o1.cost>o2.cost){
					return 1;
				}else if(o1.cost == o2.cost){
					return 0;
				}else{
					return -1;
				}
			}
		});
		
		pq.add(new Node(s,0));//
		marked[0] = true;
		Node temp;
		while(!pq.isEmpty()){
			temp = pq.poll();
			int v = temp.v;
			if(!marked[v]){
				marked[v] = true;
				int len = G[v].size();
				for(int i =0;i<len;i++){
					int vv = G[v].get(i).v;
					if(marked[vv]){
						continue;
					}
					int cost = G[v].get(i).cost;
					int newdist = disto[v] +cost;
					if(disto[vv]>newdist){
						disto[vv] = newdist;
						//增加的内容，这个地方也做了修改
						costo[vv] = cost;
						pq.add(new Node(vv,disto[vv]));
					}
					
					//加入点vv时若出现多种距离相同的方案，选取新边最小那个,这个地方做了修改
//					if(disto[vv] == newdist){
//						costo[vv] = Math.min(costo[vv], cost);
//					}
				}
			}
		}
		
	}

}
