package org.kidding.programmers.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Network43162 {

	static int[][] com;
	static boolean[] checked;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		com = new int[n][n];
		checked = new boolean[n];
		
				
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				com[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			if(checked[i] == false) {
				bfs(i, n);
				cnt++;
			}
		}
		System.out.println(cnt);

		
		for(int i=0; i<n; i++) {
			checked[i] = false;
		}
		cnt = 0;
		
		for(int i=0; i<n; i++) {
			if(checked[i] == false) {
				dfs(i, n);
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
	}
	
	static void bfs(int start, int idx) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		checked[start] = true;
		
		while(!queue.isEmpty()) {
			int visit = queue.poll();
			for(int i=0; i<idx; i++ ) {
				if(com[i][visit] == 1 && checked[i] == false ) {
					checked[i] = true;
					queue.offer(i);
				}
			}
		}	
	}
	
	//dfs로도 참고해서 풀어보기 
	static void dfs(int start, int idx) {
		if(start >= idx-1) {
			return;
		}
		
		checked[start] = true;
		
		if(com[start+1][start] == 1 && checked[start+1] == false) {
			checked[start+1] = true;
			dfs(start+1, idx);
	
		}
	}
	
}
