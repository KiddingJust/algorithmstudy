package org.kidding.backjoon.dp;

import java.util.Scanner;

public class EasyStairs10844 {

	static long[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new long[n+1][10];

		//1의자릿수면서 0으로 끝나는 수. 
		dp[1][0] = 0L;
		for(int i=1; i<10; i++) {
			dp[1][i] = 1L;
		}
		long answer = 0;
		for(int i=0; i<10; i++) {
			Long temp = getStair(n, i);
//			System.out.println("i: " + i + "=> " + temp);
			answer += temp;
		}
		
		System.out.println(answer%1000000000);
	}
	
	static Long getStair(int n, int k) {
//		System.out.println("getStar(" + n + ", " + k + ")");
		
		if(dp[n][k] == 0L &&  n > 1) {
			if(k == 0) {
				dp[n][k] = getStair(n-1, 1);
			}else if(k == 9){
				dp[n][k] = getStair(n-1, 8);
			}else {
				dp[n][k] = getStair(n-1, k-1) + getStair(n-1, k+1);
			}		
		}
		
//		System.out.println("리턴할 값: " + dp[n][k]);
		
		return dp[n][k]%1000000000;
	}
}
