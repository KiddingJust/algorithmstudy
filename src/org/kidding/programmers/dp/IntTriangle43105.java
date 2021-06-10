package org.kidding.programmers.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntTriangle43105 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] t = new int[n][n];
		int[][] dp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<i+1; j++) {
				t[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println("length check : " + t.length);


		dp[0][0] = t[0][0];
		for(int i=1; i<n; i++) {
			for (int j=0; j<n; j++) {
				dp[i][j] = -1;
			}
		}
		
		int max = 0;
		for(int i=0; i<n; i++) {
			int temp = dfs(i, n-1, t, dp);
			System.out.println(i + ": " + temp);
			if(temp > max) {
				max = temp;
			}
		}
		
		System.out.println(max);
		
	}
	
	static int dfs(int col, int idx, int[][] t, int[][] dp) {

		if(dp[idx][col] == -1) {
			if(col == 0) {
				dp[idx][col] = dfs(col, idx-1, t, dp) + t[idx][col];
			}else if(col == idx) {
				dp[idx][col] = dfs(col-1, idx-1, t, dp)  + t[idx][col];
			}else {
				dp[idx][col] = Math.max(dfs(col-1, idx-1, t, dp) , dfs(col, idx-1, t, dp)) + t[idx][col];
			}
		}	
		
		return dp[idx][col];
	}
}
