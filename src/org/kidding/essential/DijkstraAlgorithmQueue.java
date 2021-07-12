package org.kidding.essential;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

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
	static PriorityQueue<EdgeQ> pq;
    static ArrayList<ArrayList<EdgeQ>> adj;
	static int[] distance = new int[6]; //최단거리
	public static void main(String[] args) {
		
        adj = new ArrayList<ArrayList<EdgeQ>>();
        pq = new PriorityQueue<>();
        
        //왜 거리를 무한대로 초기화?? 
        Arrays.fill(distance, INF);
        
        for(int i = 0 ; i < arr.length ; i++) adj.add(new ArrayList<>());

        for(int i = 0 ; i < arr.length ; i++){
        	for(int j=0; j<arr.length; j++) {
                int weight = arr[i][j];
                //i에서 j로 가는 비용이 weight 라는 의미. 
                adj.get(i).add(new EdgeQ(j, weight));
        	}
        }
        
        for(int i=0; i<adj.size(); i++) {
        	System.out.println(adj.get(i).toString());
        }
        
		dajkstra(0);
		
		for(int i:distance) {
			System.out.println(i);
		}
		
	}
	
	static void dajkstra(int start) {
		
		//시작 노드로 가기 위한 최단 경로는 0
		pq.offer(new EdgeQ(start, 0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			System.out.println("==================================");
			EdgeQ edge = pq.poll();
			int dist = edge.weight;	//현재 노드까지의 비용
			int current = edge.destination;	//현재 노드. 
			System.out.println("dist: " + dist + ", current: " + current);
			System.out.println("distance[current]: " + distance[current]);
			//현재 계산된 거리보다 거리가 작을 경우 pass. 
			if(distance[current] < dist) continue;
			//현재 노드와 연결된 다른 인접한 노드들 확인
			System.out.println("사이즈체크!!!!!: " + adj.get(current).size());
			for(int i=0; i<adj.get(current).size(); i++) {
				System.out.println("start에서 " + i + "까지");
				System.out.println("adj.get(current).get(i).weight: " + adj.get(current).get(i).weight);
				int cost = distance[current] + adj.get(current).get(i).weight;
				System.out.println("cost: " + cost);
				System.out.println("distance[adj.get(current).get(i).destination]: " + distance[adj.get(current).get(i).destination]);
				if(cost < distance[adj.get(current).get(i).destination]) {
					System.out.println("새로운 cost: " + cost);
					System.out.println("distance[" + adj.get(current).get(i).destination + "]: " + cost);
					distance[adj.get(current).get(i).destination] = cost;
					pq.offer(new EdgeQ(adj.get(current).get(i).destination, cost));
				}
			}
		}
		

	}

//	static int getSmallIndex() {
//		int min = INF;
//		int index = 0;
//		for(int i=0; i<6; i++) {
//			if(distance[i]<min && visited[i] == false) {
//				min = distance[i];
//				index = i;
//			}
//		}
//		return index;
//	}

}

class EdgeQ implements Comparable<EdgeQ>{

	public int destination;
	public int weight; 
	
	public EdgeQ(int destination, int weight) {
		this.destination = destination;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(EdgeQ o) {
		return Integer.compare(this.weight, o.weight);
	}
	
	@Override
	public String toString() {
		return destination + "," + weight + "";
	}
	
}