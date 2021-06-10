package org.kidding.basic;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

	public static void main(String[] args) {
		GraphDFS g = new GraphDFS(5);

//		[1, 2, 4]
//		[0, 2]
//		[0, 1, 3, 4]
//		[2, 4]
//		[0, 2, 3]
		
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
		
		g.DFS(0); /* 주어진 노드를 시작 노드로 DFS 탐색 */
//		g.DFS(); /* 비연결형 그래프의 경우 */
	}
}

/* 인접 리스트를 이용한 방향성 있는 그래프 클래스 */
class GraphDFS {
	private int V; // 노드의 개수
	private LinkedList<Integer> adj[]; // 인접 리스트

	/** 생성자 */
	GraphDFS(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) // 인접 리스트 초기화
			adj[i] = new LinkedList();
	}

	/** 노드를 연결 v->w */
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	/** DFS에 의해 사용되는 함수 */
	void DFSUtil(int v, boolean visited[]) {
				
		// 현재 노드를 방문한 것으로 표시하고 값을 출력
		// visited[0] = true -> visited[1]=true이고 1에서 탐색
		// -> visited[0]은 이미 true이므로 넘기고 visited[2]=true 이고 2에서 탐색
		// -> 0, 1은 이미 true이므로 visited[3]=true 이고 3에서 탐색
		// -> 2는 이미 true 이므로 visited[4] = true이고 4에서 탐색
		// -> 0, 2, 3 모두 이미 true이므로 더이상 탐색 x. 
		// 모두 탐색하지만 출력하지는 않는 것. 백트레킹은 탐색까지 안하는 것? 
		visited[v] = true;
		System.out.print(v + " ");

		// 방문한 노드와 인접한 모든 노드를 가져온다.
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			System.out.println("n: " + n);
			// 방문하지 않은 노드면 해당 노드를 시작 노드로 다시 DFSUtil 호출
			if (!visited[n])
				DFSUtil(n, visited); // 순환 호출
		}
	}

	/** 주어진 노드를 시작 노드로 DFS 탐색 */
	void DFS(int v) {
		// 노드의 방문 여부 판단 (초깃값: false)
		boolean visited[] = new boolean[V];

		// v를 시작 노드로 DFSUtil 순환 호출
		DFSUtil(v, visited);
	}

	/** DFS 탐색 */
	void DFS() {
		// 노드의 방문 여부 판단 (초깃값: false)
		boolean visited[] = new boolean[V];

		// 비연결형 그래프의 경우, 모든 정점을 하나씩 방문
		for (int i = 0; i < V; ++i) {
			if (visited[i] == false)
				DFSUtil(i, visited);
		}
	}
}
