package org.kidding.backjoon.dp;

import java.util.Scanner;

public class MakingOne1463_forloop {

	private static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		dp=new int[n+1];
		dp[1] = 0;
		
		for(int i=2; i<n+1; i++) {
			
			int min = dp[i-1]+1;
			
			if(i%3 == 0) {
				int temp = dp[i/3] + 1;
				if(temp < min) {
					min = temp;
				}
			}
			
			if(i%2 == 0) {
				int temp = dp[i/2] + 1;
				if(temp < min) {
					min = temp;
				}
			}
			
			dp[i] = min;
		}
		
		System.out.println(dp[n]);
	}
}
