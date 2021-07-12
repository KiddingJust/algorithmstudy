package org.kidding.programmers.bfsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//https://programmers.co.kr/learn/courses/30/lessons/12978?language=java
//1번 마을이 배달할 수 있는 곳 찾기
//최단 경로를 찾아서 배달 여부를 확인. 최단 경로를 찾는 것이므로 다익스트라 알고리즘. 

//아 왜 여기서 toCost는 앞의 adj와 같이 전체 초기화가 안되냐!!!!!!
public class Delivery_Dijkstra {

	static int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
	static int N = 5;
	static int K = 3; 
	static int result = 4;
	static ArrayList<ArrayList<Edge>> toCost;	//각 거리 저장
	static int[] d = new int[6];	//1번 마을로부터의 거리 저장
	static int INF = 1000000;
	
	public static void main(String[] args) {
		
		toCost = new ArrayList<ArrayList<Edge>>();	
		//이거 초기화 하는 이유는 무엇?? 
        for(int i = 0 ; i < road.length ; i++) {
        	toCost.add(new ArrayList<>());
        };
        
		for(int i=0; i<road.length; i++) {
			int from = road[i][0];
			int to = road[i][1];
			int dist = road[i][2];
			toCost.get(from).add(new Edge(to, dist));
//			toCost.get(i).set(to, new Edge(to, dist));	이거 안되는 이유는? add vs set 
		}
		
        for(int i=0; i<toCost.size(); i++) {
        	System.out.println(toCost.get(i).toString());
        }
        
		//거리는 무한대로 초기화. 
		Arrays.fill(d, INF);

		dijkstra(1);
		
		for(int i=0; i<N; i++) {
			System.out.println(d[i]);
		}
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0)); 	//1번 마을부터 1번 마을까지의 거리는 0);
		d[1] = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int current = edge.to;
			int dist = edge.distance;
			System.out.println("current: " + current  + " dist: " + dist);
			
			//toCost.get(current)의 사이즈로 하는 이유는?
			System.out.println("size check: " + toCost.get(current).size());
			for(int i=0; i<toCost.get(current).size(); i++) {
				//current에서 i까지의 거리(비용) 계산
				int cost = toCost.get(current).get(i).distance;
				System.out.println("cost: " + cost);
				//0에서 i까지의 거리 vs 0부터 current까지 온 거리(dist) + current에서 i까지의 거리;
				if(d[i] > dist + cost) {
					d[i] = dist+cost;
					//i까지의 거리는 dis+cost 이므로, 여기부터 다시 탐색해볼 수 있도록 큐에 저장. 
					pq.offer(new Edge(i, dist+cost));
				}
				
				
				
			}
			
			
			
		}
	}
}


class Edge implements Comparable<Edge>{
	
	public int to;
	public int distance;
	
	public Edge(int to, int distance) {
		this.to = to;
		this.distance = distance;
	}
	
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.distance, o.distance);
	}
	
	@Override
	public String toString() {
		return to + "," + distance + "";
	}
	
}
