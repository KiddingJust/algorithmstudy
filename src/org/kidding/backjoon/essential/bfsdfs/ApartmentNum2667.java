package org.kidding.backhoon.essential.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
	Integer x;
	Integer y;
	public Pair(Integer x, Integer y) {
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

public class ApartmentNum2667 {

	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] apart = new int[n][n];
		visited = new boolean[n][n];
		int cnt = 0; //단지 수 
		
		for(int i=0; i<n; i++) {
			String[] temp = br.readLine().split("");
			for(int j=0; j<n; j++) {
				apart[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(visited[i][j] == false && apart[i][j] == 1) {
					bfs(i, j, apart);
					cnt++;
				}
			}
		}
				
		System.out.println(cnt);
		Collections.sort(list);
		for(int i:list) {
			System.out.println(i);
		}
	}
	
	static void bfs(int x, int y, int[][] apart) {
		Queue<Pair> queue = new LinkedList<>();
		visited[x][y] = true;
		queue.offer(new Pair(x, y));
		
		int len = apart.length;
		int nx = 0;
		int ny = 0;
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			Pair now = queue.poll();
			for(int i=0; i<4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];	
				if(nx>=0&&ny>=0&&nx<len&&ny<len) {
					if(apart[nx][ny] == 1 && visited[nx][ny] == false) {
						queue.offer(new Pair(nx, ny));
						visited[nx][ny] = true;
						cnt++;
					}
				}
			}

		}
		list.add(cnt);
	}
}
