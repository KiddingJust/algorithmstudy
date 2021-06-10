package org.kidding.backjoon.bfsdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Virus2606 {

	static int n;
	static int m;
	static int start;
	static int cnt; //바이러스 컴퓨터 댓수
	static int[][] linked;
	static boolean[] checked;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //정점의 갯수
		m = sc.nextInt(); //간선의 갯수
		start = 1;
		
		linked = new int[n+1][n+1];
		checked = new boolean[n+1];
		
		for(int i=1; i<=m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			linked[x][y] = linked[y][x] = 1;
		}
		
		bfs();
		System.out.println(cnt);
		
		//dfs 전 cnt, checked 초기화
		checked = new boolean[n+1];
		cnt = 0;
		dfs(start);
		System.out.println(cnt);
	}
	static void dfs(int i) {
		checked[i] = true;
		for(int j=1; j<=n; j++) {
			if(linked[i][j] == 1 && checked[j] == false) {
				cnt++;
				dfs(j);
			}
		}
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		checked[start] = true;
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for(int i=1; i<=n; i++) {
				if(linked[temp][i] == 1 && checked[i] == false) {
					queue.offer(i);
					checked[i] = true;
//					System.out.println("i: " + i);
					cnt++;
				}
			}
		}
	}
}
