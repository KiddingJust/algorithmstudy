package org.kidding.backhoon.essential.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Virus2606 {

	static boolean[] visited;
	static int cnt =0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n+1][n+1];
		visited = new boolean[n+1];
		int start = 1;
		
		for(int i=1; i<=m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = arr[y][x] = 1;
		}
		
		
		
		//연결된 접점 갯수 찾기 -> 이것 BFS로..!
		int b = bfs(start, arr);
		System.out.println(b);
		visited = new boolean[n+1];
		dfs(start, arr);
		System.out.println(cnt);
		visited = new boolean[n+1];
		
		
		
	}
	
	static int bfs(int start, int[][] arr) {	
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[start] = true;
		int ret = 0;
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i=1; i<arr.length; i++) {
				if(arr[temp][i] == 1 && visited[i] == false) {
					visited[i] = true;
					q.offer(i);
					ret++;
				}
			}			
		}
		return ret;
	}
	
	static void dfs(int start, int[][] arr) {
		
		visited[start] = true;
		
		for(int i=1; i<arr.length; i++) {
			if(arr[start][i] == 1 && visited[i] == false) {
				visited[i] = true;
				cnt++;
				dfs(i, arr);
			}
		}
	}
}
