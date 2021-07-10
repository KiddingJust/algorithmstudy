package org.kidding.essential;

//특정한 하나의 정점에서 다른 모든 정점으로 가는 최단경로
//최단거리는 여러개의 다른 최단거리로 이루어져있으므로 일종의 다이나믹 프로그래밍이라 할 수 있음. 
//이건 선형탐색으로 만든 것. 실제로는 이렇게 하지 X -> 정점은 많은데 간선이 적을 때, 굉장히 비효율적이 될 수 있음 
public class DijkstraAlgorithm {
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
		
		dajkstra(0);
		for(int i:distance) {
			System.out.println(i);
		}
		
	}
	
	static void dajkstra(int start) {
		for(int i=0; i<arr.length; i++) {
			distance[i] = arr[i][start];
		}
		visited[start] = true;
		//가장 가까운 정점을 찾아가며 순차적으로 정점 탐색. 정점까지의 거리는 탐색 중 업데이트. 
		//dp로 돌 필요는 없음. 
		//-2인 이유는, 일단 정점이 나를 뺴면 5개이므로 5번 반복
		//여기에 어차피 가장 먼 정점은, 끝까지 가장 멀기 때문에 계산할 필요 X (앞의 정점의 거리들도 더 가까워지는 경우만 업데이트 침)
		for(int i=0; i<arr.length-2;i++) {
			int current = getSmallIndex();	//위의 arr.length-2 까지 해서 시간복잡도가 n*n이 됨. 
			visited[current] = true;
			for(int j=0; i<arr.length; j++) {
				if(!visited[j]) {
					distance[j] = Math.min(distance[j], distance[current]+arr[current][j]);
				}
			}
		}
	}
	
	static int getSmallIndex() {
		int min = INF;
		int index = 0;
		for(int i=0; i<6; i++) {
			if(distance[i]<min && visited[i] == false) {
				min = distance[i];
				index = i;
			}
		}
		return index;
	}
}
