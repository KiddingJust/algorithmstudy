package org.kidding.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntTriangle1932 {

	private static int[][] trg;
	private static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		trg = new int[n][n];
		dp = new int[n][n];
				
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++) {
				trg[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				dp[i][j] = -1;
			}
		}
		
		//크기가 0이나 1인 경우는 미리 답 설정. 
		if(n == 1) {
			System.out.println(trg[0][0]);
			return;
		}else if(n == 2) {
			System.out.println(Math.max(trg[1][0] + trg[0][0], trg[1][1] + trg[0][0]));
			return;
		}
		
		dp[0][0] = trg[0][0];	//이걸 해주는 건 맨 처음값을 설정해주고, 탐색한 건 다시 탐색하지 않게 하기 위함?
		
		int max = getSum(n-1, 0);
//		System.out.println("max: " + max);
		for(int i=1; i<n; i++) {
			int temp = getSum(n-1, i);
//			System.out.println("temp: " + temp);
			if(max < temp) {
				max = temp;
			}
		}
		
		System.out.println(max);
		
		
	}
	
	static int getSum(int N, int col){
//		System.out.println("N: " + N + ", col: " + col);
		if(dp[N][col] == -1) {
			if(col == 0) {
				dp[N][col] = getSum(N-1, col) + trg[N][col];
			}else if(col == N) {
				dp[N][col] = getSum(N-1, col-1) + trg[N][col];
			}else{
//				int max = Math.max(dp[N-1][1] + trg[N][1], dp[N-1][2] + trg[N][1]);
//				for(int i=1; i<N; i++) {
//					int temp = Math.max(dp[N-1][col-1] + trg[N][col], dp[N-1][col] + trg[N][col]);
//					if(temp>max) {
//						max=temp;
//					}
//				}
				for(int i=1; i<N; i++) {
					dp[N][col] = Math.max(getSum(N-1, col-1) + trg[N][col], getSum(N-1, col)+ trg[N][col]);
				}
			}
		}
		
		return dp[N][col];
	}
	
}
