package org.kidding.backjoon.bfsdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BFSDFS1260 {

	static int[][] linked;
	static boolean[] checked;
	static int n; 	//정점 갯수
	static int m;   //간선 갯수
	static int start;	//탐색 시작점
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
		
		linked = new int[n+1][n+1];
		checked = new boolean[n+1];
		
		//간선 연결상태 저장
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			//양방향 연결. 연결여부는 1로 저장. 
			linked[x][y] = linked[y][x] = 1;
		}
		
		dfsStack();
		System.out.println("");
		checked = new boolean[n+1]; 
		dfs(start);
		
		System.out.println("");
		checked = new boolean[n+1]; 

		bfs();
		
	}
	
	static void bfs() {
		//큐는 linkedList인가...?
		Queue<Integer> queue = new LinkedList<Integer>();
		//시작점 넣고 시작
		queue.offer(start);
		checked[start] = true;
		System.out.print(start + " ");
		
		//Queue가 빌 때까 연결된 접점 방문. 
		while(!queue.isEmpty()) {
			//queue에서 가장 예전에 들어간 것 추출. 
			int temp = queue.poll();
			
			for(int j=1; j<=n; j++) {
				//인접한 j 찾기. 인접하면서 방문한 적이 없으면 queue에 추가
				//방문 여부는 queue에 넣는 순간 바로 체크해주기. 
				if(linked[temp][j] == 1 && checked[j] == false) {
					queue.offer(j);
					checked[j] = true;
					System.out.print(j + " ");
				}
			}
		}
	}
	
	
	static void dfsStack() {
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		checked[start] = true;
		//false로 해두고, 탐색 불가한 경우 그냥 pop 해주기 위함
		//stack이 빌 때까지 while문을 돌려주어야 하므로...! 
		boolean flag;
		System.out.print(start + " ");
			
		while(!stack.isEmpty()) {
			flag = false;
			int temp = stack.peek();
			for(int i=1; i<=n; i++) {
				if(linked[temp][i] == 1 && checked[i] == false) {
					flag = true;
					checked[i] = true;
					stack.push(i);
					System.out.print(i + " ");
					//stack은 선입후출이므로 push하고 다음 while루프에서 peek하면
					//자연히 재귀처럼 깊이우선탐색이 성립함. 
					//다만, [1][3] 후에 [1][4]를 호출하는 것이 아닌,
					//[1][3]후에 [3][1]부터 다시 탐색해야하므로 일단 break.
					//스택에는 1,3 순서로 쌓이므로 깊이우선 탐색. 
					//[1][4]는 나중에 stack에서 1이 peek될 때 다시 탐색. 
					break;
				}
			}
			
			if(!flag) {
				stack.pop();
			}
		}
	}
	
	//재귀는 인자가 필요함. 
	static void dfs(int i) {
		checked[i] = true;
		System.out.print(i + " ");
		
		for(int j=1; j<=n; j++) {
			if(linked[i][j] == 1 && checked[j] == false) {
				dfs(j);
			}
		}
	}
}
