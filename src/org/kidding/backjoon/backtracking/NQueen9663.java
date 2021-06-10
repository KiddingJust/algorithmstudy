package org.kidding.backjoon.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class NQueen9663 {

	static int n;
	static int[][] arr;
	static int[] temp;	//방문 치들. 
	static boolean[] visited;
//	static int depth;
	static int cnt;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		arr = new int[n][n];
		visited = new boolean[n];
		tracking(-1, -1, 0);
		
		System.out.println("======");
		System.out.println(cnt);
		
	}
	
	static void tracking(int a, int b, int d) {
		System.out.println("1. tracking( " + a+"와 "+b+"는 안됨 // + depth: " + d + ")");
		if(d == n) {
			System.out.println(Arrays.toString(temp));
			System.out.println("cnt++;");
			cnt++;
			System.out.println();
			return;
		}
		
		//왜 틀리냐면, 이 로직대로면 현재방문 지점으로부터 두개 열 뒤에 대각선 위치에 올 수 있음. 
		for(int i=0; i<n; i++) {
//			System.out.println("여기 한번도안빠지나? ==> " + i);
			if(visited[i] == false && i != a && i != b) {
				System.out.println("2. 방문: " + i);
				System.out.println("3. Tracking! ==> ");
				visited[i] = true;	//방문한 행 저장 
				tracking(i-1, i+1, d+1);
				visited[i] = false; //끝나면 초기화. 0열의 1행부터 다시 시작. 
			}
//			System.out.println("132에서 여기 빠지나 체크 ");
			
			//체스판 만들기 불가
//			if(i == n-1) {
//				visited = new boolean[n];
//				return;
//			}
		}
		System.out.println("Back!");
	}
}
