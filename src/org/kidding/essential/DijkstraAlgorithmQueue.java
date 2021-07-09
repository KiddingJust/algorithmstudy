package org.kidding.essential;

import org.kidding.basic.Edge;

//특정한 하나의 정점에서 다른 모든 정점으로 가는 최단경로
//최단거리는 여러개의 다른 최단거리로 이루어져있으므로 일종의 다이나믹 프로그래밍이라 할 수 있음. 
//이건 선형탐색으로 만든 것. 실제로는 이렇게 하지 X -> 정점은 많은데 간선이 적을 때, 굉장히 비효율적이 될 수 있음 
public class DijkstraAlgorithmQueue {
	static int INF = 10000000;
	static int[][] arr = {{0, 2, 5, 1, INF, INF},
						  {2, 0, 3, 2, INF, INF},
						  {5, 3, 0, 3, 1, 5},
						  {1, 2, 3, 0, 1, INF},
						  {INF, INF, 1, 1, 0, 2},
						  {INF, INF, 5, INF, 2, 0}};
	static boolean[] visited = new boolean[6];
	static int[] distance = new int[6]; //최단거리
	public static void main(String[] args) {
		
		for(int i=0; i<arr.length; i++) {
			pu
		}
		
		dajkstra(0);
		for(int i:distance) {
			System.out.println(i);
		}
		
	}
	
	static void dajkstra(int start) {

	}
	

}

class Edge implements Comparable<Edge>{

	public int destination;
	public int weight; 
	
	public Edge(int destination, int weight) {
		this.destination = destination;
		this.weight = weight;
	}
	
//	public int getDestination() {
//		return this.destination;
//	}
//	public int getWeight() {
//		return this.weight;
//	}
	
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.weight, o.weight);
	}
	
}