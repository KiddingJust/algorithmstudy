package org.kidding.basic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;



//LinkedList 생성자 부분만 이해되지 않음. 
public class BFS {
	public static void main(String[] args) {
		 
		
		Graph g = new Graph(5); //정점의 갯수만큼 생성 

		  
		  //양방향으로 변경하려면 생성자에서 설정해주면 됨.
		  //addEdge(v, w)에서 w, v 위치만 바꿔주면 ok
		  //현재는 단방향으로 넣는 중. 
		  g.addEdge(0, 1);
		  g.addEdge(0, 2);
		  g.addEdge(0, 4);
		  g.addEdge(1, 0);
		  g.addEdge(1, 2);
		  g.addEdge(2, 0);
		  g.addEdge(2, 1);
		  g.addEdge(2, 3);
		  g.addEdge(2, 4);
		  g.addEdge(3, 2);
		  g.addEdge(3, 4);
		  g.addEdge(4, 0);
		  g.addEdge(4, 2);
		  g.addEdge(4, 3);

		  g.BFS(0); /* 주어진 노드를 시작 노드로 BFS 탐색. 방문 순서 출력 */
	}
}

class Graph {
	private int V; // 노드의 개수
	private LinkedList<Integer> adj[]; // 인접 리스트

	/** 생성자 */
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) { // 인접 리스트 초기화
			adj[i] = new LinkedList(); //왜 초기화를 이렇게 시키지. 
		}
	}

	/** 노드를 연결 v->w */
	//adj의 특정 인덱스(v)에 데이터(w)를 넣는 것. 
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	/** s를 시작 노드으로 한 BFS로 탐색하면서 탐색한 노드들을 출력 */
	void BFS(int s) {
		for (int i=0; i<adj.length; i++) {
			System.out.println(adj[i]);
		}
		
		// 노드의 방문 여부 판단 (초깃값: false)
		boolean visited[] = new boolean[V];
		// BFS 구현을 위한 큐(Queue) 생성
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// 현재 노드를 방문한 것으로 표시하고 큐에 삽입(enqueue)
		visited[s] = true;
		queue.add(s);

		// 큐(Queue)가 빌 때까지 반복
		// queue = 0 -> (i.hasNext()) 1, 2, 4 -> 2, 4 -> 2, 4, 3 -> 4, 3 -> 3 -> null
		while (queue.size() != 0) {
			// 방문한 노드를 큐에서 추출(dequeue)하고 값을 출력
			s = queue.poll();
			System.out.print(s + " ");

			// 방문한 노드와 인접한 모든 노드를 가져온다.
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				// 방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입(enqueue)
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
}
