package org.kidding.backjoon.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class NM_4_15652 {

	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[m];
		dfs(n, m, 0, 0);
		System.out.println(sb);

				
	}
	
	static void dfs(int n, int m, int start, int depth) {
		if(depth == m) {
			for(int i=0; i<m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<n; i++) {
				arr[depth] = i+1;
				dfs(n, m, i, depth+1);
		}
		
	}
}
