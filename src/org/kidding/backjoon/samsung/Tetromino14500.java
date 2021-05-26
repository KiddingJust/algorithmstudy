package org.kidding.backjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
import java.util.StringTokenizer;

//class PairTet{
//	Integer x;
//	Integer y;
//	public PairTet(Integer x, Integer y) {
//		this.x = x;
//		this.y = y;
//	}
//	public Integer first() {
//		return x;
//	}
//	public Integer second() {
//		return y;
//	}
//}

public class Tetromino14500 {

	static boolean[][] visited;
	static int max = 0;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];
				
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<m+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				visited[i][j] = true;
				dfs(arr, i, j, 1, arr[i][j]);
				visited[i][j] = false;
				
				//후 
			}
		}

		System.out.println(max);
		
	}

	static void dfs(int[][] arr, int n, int m, int depth, int sum) {
//		System.out.println("dfs(" + n + ", " + m + ", " + depth + ", " + sum + ")");
		if(depth == 4) {
			if(sum >= max) {
				max = sum;
			}
			return;
		}
			
		for(int i=0; i<4; i++) {
			int nx = n + dx[i];
			int ny = m + dy[i];
			if(nx>=1 && nx <arr.length && ny>=1 && ny < arr[0].length && visited[nx][ny] == false ) {
				visited[nx][ny] = true;
				sum += arr[nx][ny];
				
				//ㅗ ㅜ  ㅏ ㅓ 케이스 처리. depth=2일 때 한번 이동한 후, 다시 이전 점에서 이동하는 케이스 처리 
				if(depth == 2) {
					for(int j=0; j<4; j++) {
						int jx = n + dx[j];
						int jy = m + dy[j];
						if(jx>=1 && jx <arr.length && jy>=1 && jy < arr[0].length && visited[jx][jy] == false) {
							if(sum + arr[jx][jy] >= max){
								max = sum + arr[jx][jy];
							}
						}
					}
				}
				
				depth++;
				dfs(arr, nx, ny, depth, sum);
				depth--;
				sum -= arr[nx][ny];
				visited[nx][ny] = false;
			}
			

			
		}
	}
	
//	static int bfs(int[][] arr, int n, int m, int depth) {
//		
//		Queue<PairTet> q = new LinkedList<PairTet>();
//		
//		visited[n][m] = true;
//		q.add(new PairTet(n, m));
//		
//		while(!q.isEmpty()) {
//			PairTet xy = q.poll();
//			
//			for(int i=0; i<4; i++) {
//				int nx = xy.first() + dx[i];
//				int ny = xy.second() + dy[i];
//				
//				if(nx>=1 && nx <arr.length && ny>=1 && ny < arr[0].length ) {
//					visited[nx][ny] = true;
//					q.offer(new PairTet(nx, ny));
//				}
//			}
//		}
//		
//		return 0;
//	}
}
