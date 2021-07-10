package org.kidding.z.checkpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFSDFSBasic1260 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		int[][] linked = new int[n+1][n+1];
		boolean[] checked = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			linked[x][y] = linked[y][x] = 1;
		}		
		
		BFS(linked, checked, start);
		System.out.println(" ");
		checked = new boolean[n+1];
		DFS(linked, checked, start);

	}
	
	public static void DFS(int[][] linked, boolean[] checked, int start) {
		checked[start] = true;
		System.out.print(start + " ");
		for(int i=1; i<linked.length; i++) {
			if(checked[i] == false && linked[start][i] == 1) {
				checked[i] = true;
				DFS(linked, checked, i);
			}
		}
	}
	
	public static void BFS(int[][] linked, boolean[] checked, int start) {
		
		Queue<Integer> queue = new LinkedList<>();
		int n = linked.length;
		//첫 탐색 지점 집어넣기. 
		queue.offer(start);
		checked[start] = true;
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			System.out.print(temp + " ");
			for(int i=1; i<n; i++) {
				if(linked[temp][i] == 1 && checked[i] == false) {
					checked[i] = true;
					queue.offer(i);
				}
			}			
		}

		
		
	}
}
