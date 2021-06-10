package org.kidding.backjoon.essential.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class PairMaze{
	Integer x;
	Integer y;
	public PairMaze(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	public Integer first() {
		return x;
	}
	public Integer second() {
		return y;
	}
}

public class Maze2178 {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		visited = new boolean[n][m];
		int[][] arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String[] temp = br.readLine().split("");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
//		for(int i=0; i<n; i++) {
//			System.out.println("");
//			for(int j=0; j<m; j++) {
//				System.out.print(arr[i][j]);
//			}
//		}
		
		//dfs는 시간초과 뜸. 
		visited[0][0] = true;
		dfs(arr, n, m, 0, 0, 1);
		Collections.sort(list);
		System.out.println(list.get(0));
		
		//bfs
		visited = new boolean[n][m];
		visited[0][0] = true;
		int answer = bfs(arr, n, m);
		System.out.println(answer);
	}
	
	static int bfs(int[][] arr, int n, int m) {
		
		Queue<PairMaze> queue = new LinkedList<PairMaze>();
		queue.offer(new PairMaze(0, 0));
		int nx = 0;
		int ny = 0;
		
		while(!queue.isEmpty()) {
			PairMaze xy = queue.poll();
			for(int i=0; i<4; i++) {
				nx = xy.first() + dx[i];
				ny = xy.second() + dy[i];
				
				if(nx>=0&&ny>=0&&nx<n&&ny<m) {
//					System.out.println("nx: " + nx + ", ny: " + ny);
					if(visited[nx][ny] == false && arr[nx][ny] == 1) {
						queue.offer(new PairMaze(nx, ny));
						visited[nx][ny] = true;
						arr[nx][ny] = arr[xy.first()][xy.second()]+1;
					}
				}
			}
			if(nx == n-1 && ny == m-1) {
				break;
			}
		}
		
		return arr[n-1][m-1];
	}
	
	static void dfs(int[][] arr, int n, int m, int x, int y, int depth) {
		int nx = 0;
		int ny = 0;
		
		if(x == n-1 && y == m-1) {
			list.add(depth);
			return;
		}
		
		for(int i=0; i<4; i++) {
			nx = x+dx[i];
			ny = y+dy[i];
			if(nx>=0&&ny>=0&&nx<n&&ny<m) {
				if(visited[nx][ny] == false && arr[nx][ny] == 1) {
					visited[nx][ny] = true;
					depth++;
					dfs(arr, n, m, nx, ny, depth);
					visited[nx][ny] = false;
					depth--;
				}
			}
			
		}
		
		
		
	}
}
