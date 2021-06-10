package org.kidding.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB1149_Better {

	static int[][] cost;
	static int[][] dp;
	static int r = 0;
	static int g = 1;
	static int b = 2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		cost = new int[n][3];
		dp = new int[n][3];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[i][r] = Integer.parseInt(st.nextToken());
			cost[i][g] = Integer.parseInt(st.nextToken());
			cost[i][b] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][r] = cost[0][r];
		dp[0][g] = cost[0][g];
		dp[0][b] = cost[0][b];
		
		
		int answer = Math.min(Math.min(getCost(n-1, r), getCost(n-1, g)), getCost(n-1, b));
		System.out.println(answer);
	}
	
	static int getCost(int N, int color) {
		
		if(dp[N][color] == 0) {
			if(color == r) {
				dp[N][color] = Math.min(getCost(N-1, g), getCost(N-1, b)) + cost[N][color];
			}else if(color == g) {
				dp[N][color] = Math.min(getCost(N-1, r), getCost(N-1, b)) + cost[N][color];
			}else {
				dp[N][color] = Math.min(getCost(N-1, r), getCost(N-1, g)) + cost[N][color];
			}			
		}

		return dp[N][color];
	}
}
