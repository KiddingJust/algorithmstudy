package org.kidding.programmers.bfsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//https://programmers.co.kr/learn/courses/30/lessons/12978?language=java
//1번 마을이 배달할 수 있는 곳 찾기
//최단 경로를 찾아서 배달 여부를 확인. 최단 경로를 찾는 것이므로 다익스트라 알고리즘. 

//아 왜 여기서 toCost는 앞의 adj와 같이 전체 초기화가 안되냐!!!!!!
public class Delivery_Dijkstra {

//	static int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
//	static int N = 5;
//	static int K = 3; 
	static int[][] road = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
	static int N = 6;
	static int K = 4; 
	static ArrayList<ArrayList<Edge>> toCost;	//각 거리 저장
	static int[] d = new int[N+1];	//1번 마을로부터의 거리 저장
	static int INF = 1000000;
	
	public static void main(String[] args) {
		
		toCost = new ArrayList<ArrayList<Edge>>();	
		//이거 초기화 하는 이유는 무엇?? 
        for(int i = 0 ; i < road.length ; i++) toCost.add(new ArrayList<>());
        
		for(int i=0; i<road.length; i++) {
			int from = road[i][0];
			int to = road[i][1];
			int dist = road[i][2];
			toCost.get(from).add(new Edge(to, dist));
			toCost.get(to).add(new Edge(from, dist));
		}
//        for(int i=0; i<toCost.size(); i++) {
//        	System.out.println(toCost.get(i).toString());
//        }
		//거리는 무한대로 초기화. 
		Arrays.fill(d, INF);

		dijkstra(1);
		
		int answer = 0;
		for(int i=1; i<d.length; i++) {
			if(d[i] <= K) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0)); 	//1번 마을부터 1번 마을까지의 거리는 0);
		d[1] = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int current = edge.to;
			int dist = edge.distance;
			
			//만약 current까지의 distance가 기존에 계산한 distance보다 크다면 계산 필요 X. 
			if(d[current] < dist) continue;
			//current 마을과 연결된 마을의 갯수(size) 체크 
			for(int i=0; i<toCost.get(current).size(); i++) {
				//current에서 i 인덱스의 to까지의 거리(비용) 계산
				int cost = toCost.get(current).get(i).distance;
				//0에서 toCost.get(current).get(i).to까지의 거리 vs 0부터 current까지 온 거리(dist) + current에서toCost.get(current).get(i).to까지의 거리;
				if(d[toCost.get(current).get(i).to] > dist + cost) {
					d[toCost.get(current).get(i).to] = dist+cost;
					//i까지의 거리는 dis+cost 이므로, 여기부터 다시 탐색해볼 수 있도록 큐에 저장. 
					pq.offer(new Edge(toCost.get(current).get(i).to, dist+cost));
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
		return to + ":" + distance + "";
	}
	
}
