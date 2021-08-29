package org.kidding.z.checkpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {
	
	//https://velog.io/@courage331/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4Java-%EA%B1%B0%EB%A6%AC%EB%91%90%EA%B8%B0-%ED%99%95%EC%9D%B8%ED%95%98%EA%B8%B0
	//위에ㅏㅇ 비교 필요 
	//프로그래머스 거리두기 문제.  - dx, dy 다시 만들어보기. 
	//쿼드트리 만들기. 
	//P X P X P
	//X P X P X
	//P X P X P
	//X P X P X
	//P X P X P
	private static int[] toX = {1, -1, 0, 0};
	private static int[] toY = {0, 0, 1, -1};
	private static boolean[][] visited;
	private static String[][] places = 
		{{"OOOOO", "OOOOO", "OOPOO", "OOOOP", "OOOOO"}, 
		 {"XPXXX", "OXPOO", "XXXXX", "OOPOO", "XXXXX"},
		 {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
		 {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
		 {"PPPPP", "PPPPP", "PPPPP", "PPPPP", "PPPPP"}
		};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// if P일 때 2 거리 넘는지 탐색?
		// 그냥 P와 P간의 거리가 1이면 무조건 X. 
		// P와 P간의 거리가 2이면, 
		int[] answer = new int[5];

		for(int k=0; k<5; k++) {
			char[][] arr = new char[5][5];
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					arr[i][j] = places[k][i].charAt(j);
				}
			}
			
			answer[k] = 1;
			
			Loop1:
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					if(arr[i][j] == 'P') {
						visited = new boolean[5][5];
						visited[i][j] = true;
						if(check(arr, i, j) == false) {
							answer[k] = 0;
							break Loop1;
						}
					}
				}
			}
		}
		for(int i=0; i<5; i++) {
			System.out.print(answer[i] + " ");
		}
	}
	
	static boolean check(char[][] arr, int x, int y) {
		int depth = 0;
		
		Queue<DistancePair> q = new LinkedList<>();
		q.offer(new DistancePair(x, y));
		
		while(!q.isEmpty()) {
			if(depth == 2) {
				return true;
			}
			DistancePair xy = q.poll();
			int sx = xy.x;
			int sy = xy.y;
			for(int i=0; i<4; i++) {
				int newX = sx+toX[i];
				int newY = sy+toY[i];
				if(newX <= 4 && newY <=4 && newX >=0 && newY >=0 && visited[newX][newY] == false) {
					if(arr[newX][newY] == 'O') {
						visited[newX][newY] = true;
						q.offer(new DistancePair(newX, newY));
					}else if(arr[newX][newY] == 'P') {
						if(depth == 0 || depth == 1) {
							return false;
						}
					}
				}
			}
			depth++;
		}
		
		return true;
	}
}

class DistancePair{
	int x;
	int y;
	public DistancePair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
