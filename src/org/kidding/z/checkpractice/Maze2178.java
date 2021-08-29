package org.kidding.z.checkpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Maze2178 {

	static int N;
	static int M;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] maze;
	static boolean[][] visited;
	
	//위 아래 오른 왼 문제는 일단 dx, dy 적어두는 게 좋음.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		maze = new int[N+1][M+1]; 
		visited = new boolean[N+1][M+1]; 
		for(int i=1; i<N+1; i++) {
			String[] xy = br.readLine().split("");
			for(int j=1; j<M+1; j++) {
				maze[i][j] = Integer.parseInt(xy[j-1]);
			}
		}
		
		int answer = bfs();
		System.out.println(answer);
		
	}
	
	static int bfs() {
		Queue<PairMaze> q = new LinkedList<>();
		q.offer(new PairMaze(1, 1));
		visited[1][1] = true;
		
		while(!q.isEmpty()) {
			PairMaze xy = q.poll();
			int x = xy.x;
			int y = xy.y;
			
			for(int i=0; i<4; i++) {
				int newX = x+dx[i];
				int newY = y+dy[i];
				if(newX == N && newY == M) {
					maze[newX][newY] = maze[x][y]+1;
					return maze[N][M];
				}
				if(newX>=1&&newY>=1&&newX<=N&&newY<=M) {
					if(visited[newX][newY]==false&&maze[newX][newY]==1) {
						q.offer(new PairMaze(newX, newY));
						visited[newX][newY] = true;
						maze[newX][newY] = maze[x][y]+1;
					}
				}
			}
		}
		return maze[N][M];
	}
}

class PairMaze{
	int x;
	int y;
	public PairMaze(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
