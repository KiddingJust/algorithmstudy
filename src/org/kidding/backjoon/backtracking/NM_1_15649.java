package org.kidding.backjoon.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class NM_1_15649 {

	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		visited = new boolean[n];
		arr = new int[m];

		dfs(n, m, 0);
		System.out.println(sb);

				
	}
	
	static void dfs(int n, int m, int depth) {
		if(depth == m) {
			for(int i=0; i<m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//1 2 3 4 후에
		//1 2 4 3 탐색
		//1 2 3 4 후에 dfs 끝나면 visited = false인 3번으로 가기 때문. 
		//visited를 넣는 이유는, 중복 숫자를 피하기 위함
		for(int i=0; i<n; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				arr[depth] = i+1;
				dfs(n, m, depth+1);
				visited[i] = false;
			}
		}
		
	}
}
