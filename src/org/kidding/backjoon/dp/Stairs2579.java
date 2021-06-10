package org.kidding.backjoon.dp;

import java.util.Scanner;

public class Stairs2579 {

	private static int[] stairs;
	private static int[] dp;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		stairs = new int[n];
		dp = new int[n];
		for(int i=0; i<n; i++) {
			stairs[i] = sc.nextInt();
		}
		
		dp[0] = stairs[0];
//		dp[1] = stairs[1];
//		dp[2] = stairs[2];
		
		if(n==1) {
			System.out.println(stairs[0]);
			return;
		}else if(n==2) {
			System.out.println(stairs[0] + stairs[1]);
		}else if(n==3) {
			System.out.println(Math.max(stairs[0] + stairs[2], stairs[1]+stairs[2]));
		}else {
			System.out.println(getSum(n-1));
		}
		
	}
	
	static int getSum(int N) {
//		System.out.println("getSum("+N+")");
		if(N == -1 || N == -2) {
			return 0;
		}
		if(dp[N] == 0) {
			int temp1 = getSum(N-2) + stairs[N];
			int temp2 =  getSum(N-3) + stairs[N-1] + stairs[N];

			dp[N] = Math.max(temp1, temp2);
		}
//		System.out.println("dp[N]: " + dp[N]);
		return dp[N];
	}
}
