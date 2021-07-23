package org.kidding.backjoon.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ShortestPath1753 {

	static ArrayList<Edge>[] distArr;
	static int[] d;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		//외우기 이거..! 초기화하는 방법! 
		distArr = new ArrayList[V+1];
		for(int i=0; i<distArr.length; i++) distArr[i] = new ArrayList<>();
		
		visited = new boolean[V+1];
		d = new int[V+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			distArr[from].add(new Edge(to, dist));
//			distArr[to].add(new Edge(from, dist));
		}
		
		d[start] = 0;
		dijkstra(start);
		
		for(int i=1; i<d.length; i++) {
			if(visited[i]) {
			System.out.println(d[i]);
			}else{
				System.out.println("INF");
			};
		}
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int curr = edge.to;
			int dist = edge.distance;
			visited[curr] = true;
			
			//이미 계산된 d[curr] 거리가 더 작으면, curr부터 새로운 경로 탐색할 필요 X
			if(d[curr] < dist) continue;
			
			for(int i=0; i<distArr[curr].size(); i++) {
				int currTo = distArr[curr].get(i).to;
				int currToDist = distArr[curr].get(i).distance;
				
				if(d[currTo] > dist+currToDist) {
					d[currTo] = dist+currToDist;
					pq.offer(new Edge(currTo, dist+currToDist));
				}
			}
		}
		
	}
}

//Edge 클래스. 
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
	
}
