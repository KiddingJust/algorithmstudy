package org.kidding.z.checkpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][3];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dp[i][0] = Integer.parseInt(st.nextToken());
			dp[i][1] = Integer.parseInt(st.nextToken());
			dp[i][2] = Integer.parseInt(st.nextToken());
		}
		
		//방법 1
		//for문으로 index 0부터 쌓아가는 방법. 
//		for(int i=1; i<n; i++) {
//			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+dp[i][0];
//			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+dp[i][1];
//			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+dp[i][2];
//		}
//		
//		int min = Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
//		System.out.println(min);
		
		//방법 2
		//재귀호출 돌리기. 
		//return 시, color 값도 변수로 주면 됨. 
		int min2 = Math.min(Math.min(dfs(dp, n-1, 0), dfs(dp, n-1, 1)), dfs(dp, n-1, 2));
		System.out.println(min2);
	}
	
	static int dfs(int[][] dp, int n, int rgb) {
		if(n==-1) {
			return 0;
		}
		
		if(rgb == 0) {
			dp[n][0] = Math.min(dfs(dp, n-1, 1), dfs(dp, n-1, 2))+dp[n][0];
		}else if(rgb == 1) {
			dp[n][1] = Math.min(dfs(dp, n-1, 0), dfs(dp, n-1, 2))+dp[n][1];
		}else {
			dp[n][2] = Math.min(dfs(dp, n-1, 0), dfs(dp, n-1, 1))+dp[n][2];
		}
		return dp[n][rgb];
	}
}
