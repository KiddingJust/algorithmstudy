package org.kidding.z.checkpractice;

import java.util.Scanner;

public class EasyStep10844 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] dp = new int[n+1][10];
		for(int i=1; i<10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2; i<=n; i++) {
			dp[i][0] = dp[i-1][1];
			dp[i][9] = dp[i-1][8];
			for(int j=1; j<9; j++) {
				dp[i][j] = dp[i-1][j-1]+dp[i-1][j+1];
			}
		}
		
		int total = 0;
		for(int i=0; i<10; i++) {
			total += dp[n][i];
		}
		System.out.println(total%1000000000);
		
	}
}
