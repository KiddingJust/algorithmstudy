package org.kidding.backjoon.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class NM_3_15651 {

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
		
		for(int i=0; i<n; i++) {
				arr[depth] = i+1;
				dfs(n, m, depth+1);

		}
		
	}
}
