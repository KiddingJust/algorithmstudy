package org.kidding.backjoon.essential.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1260
public class BFSDFS1260 {

	static boolean[] visited;
			
	//bfs, dfs, dfs(stack 사용) 세가지 버전으로 풀어보기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		
//		생성된 인접행렬(?) 확인 
//		for(int i=0; i<n+1; i++) {
//			System.out.println("");
//			for(int j=0; j<n+1; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//		}
		
		System.out.println("");
		System.out.print("dfsStack ==> ");
		dfsStack(start, arr);
		visited = new boolean[n+1];
		System.out.println("");
		System.out.print("dfsRecur ==> ");
		dfs(start, arr);
		visited = new boolean[n+1];
		System.out.println("");
		System.out.print("bfs ==> ");
		bfs(start, arr);
	}
	
	//bfs는 dfs처럼 재귀호출을 하는 게 아님. 
	//while문을 통해 전체 접점 탐색.
	// --> 이를 통해 현재 queue에서 뽑아낸 정점과 연결된 정점 중 방문한 적이 없는 정점을 찾음
	static void bfs(int start, int[][] arr) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
		System.out.print(start + " ");
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for(int i=1; i<arr.length; i++) {
				if(arr[temp][i] == 1 && visited[i] == false) {
					queue.offer(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}
	
	//BFS는 연결된 걸 모두 queue에 담고 다시 연결된걸 탐색
	//DFS는 연결된걸 발견한 순간, 그걸 기준으로 다시 탐색하기 때문에
	//재귀 개념으로 이해 가능. 다시 본인을 호출해서 탐색
	static void dfs(int start, int[][] arr) {
		
		visited[start] = true;
		System.out.print(start + " ");
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i][start] == 1 && visited[i] == false) {
				visited[i] = true;
				dfs(i, arr);
			}
		}
	}
	
	//Stack으로 구현해보기 
	//BFS와 달리, 접점을 찾은 곳부터 탐색이 되어야함. 
	// -> 고로 탐색 시 pop을 통해 바로 뽑아선 안됨. 계속 누적해가야 탐색 불가능 시 pop하고 이전부터 찾기 때문!
	static void dfsStack(int start, int[][] arr) {
		
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		visited[start] = true;
		System.out.print(start + " ");
		
		while(!stack.isEmpty()) {
			//바로 안뽑는 건, 1 -> 2 -> 6 ->5 탐색 다음에 다시 1->3->... 탐색을 해주어야하므로
			int temp = stack.peek();
			boolean flag = false;
			for(int i=0; i<arr.length; i++) {
				if(arr[temp][i] == 1 && visited[i] == false) {
					flag = true; // 깊이가 남음. 
					stack.push(i);
					visited[i] = true;
					System.out.print(i + " ");
					break;
				}
			}
			//for문 돌렸는데 깊이가 없으면(더이상 탐색 불가하면) 스택에서 제거
			if(flag == false) {
				stack.pop();
			}
		}
	}
}
