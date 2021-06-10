package org.kidding.backjoon.dp;

import java.util.Scanner;

public class EasyStairs10844_Wrong {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		dp[1] = 9;
		for(int i=2; i<n+1; i++) {
			dp[i] = dp[i-1]*2 - (i-1);
		}
		
		System.out.println(dp[n]);
	}
}
